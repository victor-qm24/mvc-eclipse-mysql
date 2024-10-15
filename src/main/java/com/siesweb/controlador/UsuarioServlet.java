package com.siesweb.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

import com.siesweb.modelo.*;
import com.siesweb.dao.*;

@WebServlet({ "/UsuarioServlet", "/iniciarSesion", "/registrar", "/insertar","/actualizar", "/eliminar", "/listar", "/buscar"
	,"/cargarRegistro","/cargarInsercion","/cargarActualizacion","/logout","/inactivar"})
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final UsuariosDAO usuarioDAO = new UsuariosDAO();
	private final ProyectosDAO proyectosDAO = new ProyectosDAO();
	private final TiposDocumentosDAO tiposDocumentosDAO = new TiposDocumentosDAO();
	private final RolesDAO rolesDAO = new RolesDAO();

	public UsuarioServlet() {
		super();
		
	}	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();		

		switch (action) {
		case "/iniciarSesion":
			iniciar_sesion(request, response);
			break;
		case "/registrar":
			registrar(request, response);
			break;
		case "/insertar":
			insertar(request, response);
			break;
		case "/actualizar":
			actualizar(request, response);
			break;
		case "/eliminar":
			eliminar(request, response);
			break;
		case "/listar":
			listar(request, response);
			break;
		case "/buscar":
			buscar(request, response);
			break;
		case "/cargarRegistro":			
			loadRegistro(request, response);
			break;
		case "/cargarInsercion":			
			loadInsercion(request, response);
			break;
		case "/cargarActualizacion":			
			loadActualizacion(request, response);
			break;
		case "/inactivar":			
			inactivar(request, response);
			break;		
		case "/logout":			
			HttpSession session = request.getSession(false); // No crea una nueva sesión si no existe
	        if (session != null) {
	            session.invalidate(); // Invalida la sesión actual
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			System.out.println("No se reconoce la opcion enviada!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void iniciar_sesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");	
		

		if (!user.isEmpty() && !pass.isEmpty()) {
			try {
				Usuarios usuario = usuarioDAO.buscarDatosSesion(user);
				String passHash = usuario.getPassword();
				if (BCrypt.checkpw(pass, passHash)) {
					int idRol = usuario.getRolId();
					String nombreUser = usuario.getNombre();
					HttpSession session = request.getSession();			        
					session.setAttribute("nombreUser", nombreUser);
					if (idRol == 1) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
						dispatcher.forward(request, response);
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					System.out.println("Usuario no registrado en la base de datos.");
					JOptionPane.showMessageDialog(null, "Usuario no registrado en la base de datos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Debe llenar todos los campos.");
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String usuario = request.getParameter("usuario");
		
		String password = request.getParameter("password");
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		String estado = "Activo";
		String tipo = request.getParameter("tipo");
		String rol = request.getParameter("rol");
		String proyecto = request.getParameter("proyecto");

		try {
			TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
			Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
			Roles rl = rolesDAO.obtenerIdRol(rol);

			if (!nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty() && !email.isEmpty()
					&& !telefono.isEmpty() && !usuario.isEmpty() && !password.isEmpty() && !tipo.isEmpty()
					&& !proyecto.isEmpty() && !rol.isEmpty()) {

				if (validarNombre(nombre) && validarNombre(apellido) && validarDocumento(documento)
						&& validarEmail(email) && validarTelefono(telefono) && validarUsuario(usuario)
						&& validarPassword(password) && tipo != "-" && rol != "-" && proyecto != "-") {

					if (tipoDocumento != null && proy != null && rl != null) {
						
						usuarioDAO.agregarUsuario(new Usuarios(0, nombre, apellido, documento, email, telefono, usuario,
								hashedPassword, estado, tipoDocumento.getId(), proy.getId(), rl.getId()));
						JOptionPane.showMessageDialog(null, "Usuario agregado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
						dispatcher.forward(request, response);
						
					} else {
						System.out.println("No se pudo obtener el id de tipo, rol o proyecto.");
					}
				} else {
					System.out.println("Uno o varios campos no son validos.");
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("No se pudo obtener el Id de rol, tipo y proyecto" + e);
		}
	}
	
	private void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String usuario = request.getParameter("usuario");
		
		String password = request.getParameter("password");
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		String estado = request.getParameter("estado");
		String tipo = request.getParameter("tipo");
		String rol = request.getParameter("rol");
		String proyecto = request.getParameter("proyecto");

		try {
			TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
			Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
			Roles rl = rolesDAO.obtenerIdRol(rol);

			if (!nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty() && !email.isEmpty()
					&& !telefono.isEmpty() && !usuario.isEmpty() && !password.isEmpty() && !estado.isEmpty() 
					&& !tipo.isEmpty() && !proyecto.isEmpty() && !rol.isEmpty()) {

				if (validarNombre(nombre) && validarNombre(apellido) && validarDocumento(documento)
						&& validarEmail(email) && validarTelefono(telefono) && validarUsuario(usuario)
						&& validarPassword(password)) {

					if (tipoDocumento != null && proy != null && rl != null) {
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							usuarioDAO.agregarUsuario(new Usuarios(0, nombre, apellido, documento, email, telefono, usuario,
									hashedPassword, estado, tipoDocumento.getId(), proy.getId(), rl.getId()));
							JOptionPane.showMessageDialog(null, "Usuario agregado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminAgregarUser.jsp");
							dispatcher.forward(request, response);
						}else {
							JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("No se pudo obtener el id de tipo, rol o proyecto.");
					}
				} else {
					System.out.println("Uno o varios campos no son validos.");
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminAgregarUser.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminAgregarUser.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("No se pudo obtener el Id de rol, tipo y proyecto" + e);
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idActualizar");		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String usuario = request.getParameter("usuario");
		
		String password = request.getParameter("password");
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		String estado = request.getParameter("estado");
		String tipo = request.getParameter("tipo");
		String rol = request.getParameter("rol");
		String proyecto = request.getParameter("proyecto");	

		if (!idString.isEmpty()) {

			if (!nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty() && !email.isEmpty()
					&& !telefono.isEmpty() && !usuario.isEmpty() && !password.isEmpty() && !estado.isEmpty() &&
					!tipo.isEmpty() && !proyecto.isEmpty() && !rol.isEmpty()) {

				if (validarId(idString) && validarNombre(nombre) && validarNombre(apellido)
						&& validarDocumento(documento) && validarEmail(email) && validarTelefono(telefono)
						&& validarUsuario(usuario) && validarPassword(password)) {
					
					int id = Integer.parseInt(idString);
					try {						
						TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
						Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
						Roles rl = rolesDAO.obtenerIdRol(rol);

						if (tipoDocumento != null && proy != null && rl != null) {
							HttpSession session = request.getSession(false);
							if (session != null && session.getAttribute("nombreUser") != null) {
								int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
								if (respuesta == JOptionPane.YES_OPTION) {
	
									usuarioDAO.actualizarUsuario(new Usuarios(id, nombre, apellido, documento, email,
											telefono, usuario, hashedPassword, estado, tipoDocumento.getId(), proy.getId(), rl.getId()));
									RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
									dispatcher.forward(request, response);
								} else {
									RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
									dispatcher.forward(request, response);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
								dispatcher.forward(request, response);
							}	
						} else {
							System.out.println("No se pudo obtener el id de tipo, rol o proyecto.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Uno o varios campos no son validos.");
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idEliminar");
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					List<Usuarios> user = usuarioDAO.buscarUsuario(id);
					if (!user.isEmpty()) {
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
						
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								usuarioDAO.eliminarUsuario(id);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("No se encontro el id a eliminar.");
						JOptionPane.showMessageDialog(null, "No se encontro el id a eliminar.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombreUser") != null) {
				List<Usuarios> usuarios = usuarioDAO.obtenerUsuarios();
				request.setAttribute("listaUsuarios", usuarios);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarUser.jsp");
				dispatcher.forward(request, response);
			}else {
				JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("idBuscar");
		if (!idStr.isEmpty()) {

			if (validarId(idStr)) {
				int id = Integer.parseInt(idStr);
				try {
					HttpSession session = request.getSession(false);
					if (session != null && session.getAttribute("nombreUser") != null) {
						List<Usuarios> user = usuarioDAO.buscarUsuario(id);
						if (!user.isEmpty()) {
	
							request.setAttribute("User", user);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						} else {
							System.out.println("Usuario no encontrado.");
							JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void loadRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<TiposDocumentos> tipos = tiposDocumentosDAO.obtenerTipos();
            List<Roles> roles = rolesDAO.obtenerRoles();
            List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();            
            request.setAttribute("listaTipos", tipos);
            request.setAttribute("listaRoles", roles);
            request.setAttribute("listaProyectos", proyectos);           
            RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
			dispatcher.forward(request, response);
            
        } catch (SQLException e) {
        	System.out.println("no se agrego nada");
        }
    }
	private void loadInsercion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<TiposDocumentos> tipos = tiposDocumentosDAO.obtenerTipos();
            List<Roles> roles = rolesDAO.obtenerRoles();
            List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();            
            request.setAttribute("listaTipos", tipos);
            request.setAttribute("listaRoles", roles);
            request.setAttribute("listaProyectos", proyectos);           
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminAgregarUser.jsp");
			dispatcher.forward(request, response);
            
        } catch (SQLException e) {
        	System.out.println("no se agrego nada");
        }
    }
	private void loadActualizacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<TiposDocumentos> tipos = tiposDocumentosDAO.obtenerTipos();
            List<Roles> roles = rolesDAO.obtenerRoles();
            List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();            
            request.setAttribute("listaTipos", tipos);
            request.setAttribute("listaRoles", roles);
            request.setAttribute("listaProyectos", proyectos);           
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
			dispatcher.forward(request, response);
            
        } catch (SQLException e) {
        	System.out.println("no se agrego nada");
        }
    }
	
	private void inactivar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idInactivar");
		String estado = "Inactivo";
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					HttpSession session = request.getSession(false);
					if (session != null && session.getAttribute("nombreUser") != null) {
						List<Usuarios> usuario = usuarioDAO.buscarUsuario(id);
						
						if (!usuario.isEmpty()) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								usuarioDAO.inactivarUsuario(new Usuarios(id,"","","","","","","",estado,0,0,0));
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							}
						} else {
							System.out.println("No se encontro el id a inactivar.");
							JOptionPane.showMessageDialog(null, "No se encontro el id a inactivar.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id para inactivar.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public static boolean validarId(String id) {
		String regex = "^[0-9]{1,3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public static boolean validarNombre(String nombre) {
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nombre);
		return matcher.matches();
	}

	public static boolean validarDocumento(String documento) {
		String regex = "^[0-9]{8,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(documento);
		return matcher.matches();
	}

	public static boolean validarEmail(String email) {
		String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validarTelefono(String telefono) {
		String regex = "^[0-9]{7,14}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telefono);
		return matcher.matches();
	}

	public static boolean validarUsuario(String usuario) {
		String regex = "^[a-zA-Z0-9._-]{3,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(usuario);
		return matcher.matches();
	}

	public static boolean validarPassword(String password) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
