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
import com.google.gson.Gson;

import com.siesweb.modelo.*;
import com.siesweb.dao.*;

@WebServlet({ "/UsuarioServlet", "/iniciarSesion", "/registrar", "/insertar", "/actualizar", "/eliminar", "/listar",
		"/buscar", "/cargarRegistro", "/cargarInsercion", "/cargarActualizacion", "/logout", "/inactivar" })
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final UsuariosDAO usuarioDAO = new UsuariosDAO();
	private final ProyectosDAO proyectosDAO = new ProyectosDAO();
	private final TiposDocumentosDAO tiposDocumentosDAO = new TiposDocumentosDAO();
	private final RolesDAO rolesDAO = new RolesDAO();
	private final AvancesDAO avancesDAO = new AvancesDAO();
	private final TemasDAO temasDAO = new TemasDAO();

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
		case "/buscar":
			buscar(request, response);
			break;
		case "/eliminar":
			eliminar(request, response);
			break;
		case "/inactivar":
			inactivar(request, response);
			break;
		case "/listar":
			listar(request, response);
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public boolean iniciar_sesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");
		if (user != null && pass != null) {
			if (!user.isEmpty() && !pass.isEmpty()) {
				if(validarUsuario(user) && validarPassword(pass)) {
					try {
						Usuarios usuario = usuarioDAO.buscarDatosSesion(user);
						if(usuario != null) {
							String passHash = usuario.getPassword();
							if (BCrypt.checkpw(pass, passHash)) {
								int idRol = usuario.getRolId();
								String nombreUser = usuario.getNombre();
								String estadoUser = usuario.getEstado();
								HttpSession session = request.getSession();
								session.setAttribute("nombreUser", nombreUser);
								System.out.println(estadoUser);
								if (estadoUser.equals("Activo")) {
									if (idRol == 1) {
										RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
										dispatcher.forward(request, response);
										return true;
									} else {
										Avances avanceUltimo = avancesDAO.obtenerUltimoAvc();
										List<Avances> avances = avancesDAO.obtenerAvc();
										List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();
										List<Temas> temas = temasDAO.obtenerTemas();
		
										Gson gson = new Gson();
										String json = gson.toJson(avances);
		
										request.setAttribute("avancesJson", json);
										request.setAttribute("avancesUltimo", avanceUltimo);
										request.setAttribute("listaProyectos", proyectos);
										request.setAttribute("listaTemas", temas);
		
										RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
										dispatcher.forward(request, response);
										return true;
									}
								} else {
									JOptionPane.showMessageDialog(null,
											"Datos de sesion correctos, pero te encuentras en estado inactivo", "!Advertencia¡",
											JOptionPane.INFORMATION_MESSAGE);
									RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
									dispatcher.forward(request, response);
									return false;
								}
							} else {
								JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
								dispatcher.forward(request, response);
								return false;
							}
						}else {
							JOptionPane.showMessageDialog(null, "Usuario no registrado.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
							dispatcher.forward(request, response);
							return false;
						}
					} catch (SQLException e) {
						System.out.println("Usuario no registrado." + e);
						JOptionPane.showMessageDialog(null, "Usuario no registrado.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);					
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					return false;
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				return false;
			}
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			return false;
		}
		return false;
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

		if (!nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty() && !email.isEmpty() && !telefono.isEmpty()
				&& !usuario.isEmpty() && !password.isEmpty() && !tipo.isEmpty() && !proyecto.isEmpty()
				&& !rol.isEmpty()) {
			if (validarNombre(nombre) && validarNombre(apellido) && validarDocumento(documento) && validarEmail(email)
					&& validarTelefono(telefono) && validarUsuario(usuario) && validarPassword(password) && tipo != "-"
					&& rol != "-" && proyecto != "-") {
				try {
					TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
					Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
					Roles rl = rolesDAO.obtenerIdRol(rol);
					if(tipoDocumento != null && proy != null && rl != null) {
						usuarioDAO.agregarUsuario(new Usuarios(0, nombre, apellido, documento, email, telefono, usuario,
								hashedPassword, estado, tipoDocumento.getId(), proy.getId(), rl.getId()));
						JOptionPane.showMessageDialog(null, "Usuario agregado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						loadRegistro(request, response);
					}else {
						JOptionPane.showMessageDialog(null, "Campos adicionales no encontrados.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						loadRegistro(request, response);	
					}
				} catch (SQLException e) {
					System.out.println("Error al registrar usuario." + e);
					JOptionPane.showMessageDialog(null, "Error al registrar usuario.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					loadRegistro(request, response);					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				loadRegistro(request, response);				
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			loadRegistro(request, response);			
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

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty() && !email.isEmpty()
					&& !telefono.isEmpty() && !usuario.isEmpty() && !password.isEmpty() && !estado.isEmpty()
					&& !tipo.isEmpty() && !proyecto.isEmpty() && !rol.isEmpty()) {
				if (validarNombre(nombre) && validarNombre(apellido) && validarDocumento(documento)
						&& validarEmail(email) && validarTelefono(telefono) && validarUsuario(usuario)
						&& validarPassword(password)) {
					try {
						TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
						Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
						Roles rl = rolesDAO.obtenerIdRol(rol);
						if(tipoDocumento != null && proy != null && rl != null) {
							usuarioDAO.agregarUsuario(new Usuarios(0, nombre, apellido, documento, email, telefono, usuario,
									hashedPassword, estado, tipoDocumento.getId(), proy.getId(), rl.getId()));
							JOptionPane.showMessageDialog(null, "Usuario agregado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							loadInsercion(request, response);
						}else {
							JOptionPane.showMessageDialog(null, "Campos adicionales no encontrados.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							loadRegistro(request, response);	
						}
					} catch (SQLException e) {
						System.out.println("Error al insertar usuario." + e);
						JOptionPane.showMessageDialog(null, "Error al insertar usuario.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						loadInsercion(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					loadInsercion(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				loadInsercion(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
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

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty()
					&& !email.isEmpty() && !telefono.isEmpty() && !usuario.isEmpty() && !password.isEmpty()
					&& !estado.isEmpty() && !tipo.isEmpty() && !proyecto.isEmpty() && !rol.isEmpty()) {
				if (validarId(idString) && validarNombre(nombre) && validarNombre(apellido)
						&& validarDocumento(documento) && validarEmail(email) && validarTelefono(telefono)
						&& validarUsuario(usuario) && validarPassword(password)) {
					try {
						int id = Integer.parseInt(idString);
						List<Usuarios> user = usuarioDAO.buscarUsuario(id);	
						if(!user.isEmpty()) {
							TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
							Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
							Roles rl = rolesDAO.obtenerIdRol(rol);
							if(tipoDocumento != null && proy != null && rl != null) {
								int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
								if (respuesta == JOptionPane.YES_OPTION) {
									usuarioDAO.actualizarUsuario(new Usuarios(id, nombre, apellido, documento, email, telefono,
											usuario, hashedPassword, estado, tipoDocumento.getId(), proy.getId(), rl.getId()));
									JOptionPane.showMessageDialog(null, "Usuario actualizado con exito.", "!Advertencia¡",
											JOptionPane.INFORMATION_MESSAGE);
									loadActualizacion(request, response);
								} else {
									loadActualizacion(request, response);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Campos adicionales no encontrados.", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								loadRegistro(request, response);	
							}
						}else {
							JOptionPane.showMessageDialog(null, "El usuario no esta registrado.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							loadActualizacion(request, response);
						}
					} catch (SQLException e) {
						System.out.println("Error al actualizar usuario." + e);
						JOptionPane.showMessageDialog(null, "Error al actualizar usuario.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						loadActualizacion(request, response);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					loadActualizacion(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				loadActualizacion(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idEliminar");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty()) {
				if (validarId(idString)) {					
					try {
						int id = Integer.parseInt(idString);
						List<Usuarios> user = usuarioDAO.buscarUsuario(id);	
						if(!user.isEmpty()) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								usuarioDAO.eliminarUsuario(id);
								JOptionPane.showMessageDialog(null, "Usuario eliminado con exito.", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "El usuario no esta registrado.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						}
					} catch (SQLException e) {
						System.out.println("Error al eliminar usuario.");
						JOptionPane.showMessageDialog(null, "Error al eliminar usuario.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
						dispatcher.forward(request, response);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<Usuarios> usuarios = usuarioDAO.obtenerUsuarios();
				if(usuarios != null) {
					request.setAttribute("listaUsuarios", usuarios);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarUser.jsp");
					dispatcher.forward(request, response);
				}else {
					JOptionPane.showMessageDialog(null, "Usuarios no encontrados.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarUser.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				System.out.println("Error al listar usuarios." + e);
				JOptionPane.showMessageDialog(null, "Error al listar usuarios.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("idBuscar");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idStr.isEmpty()) {
				if (validarId(idStr)) {
					try {
						int id = Integer.parseInt(idStr);
						List<Usuarios> user = usuarioDAO.buscarUsuario(id);
						if (!user.isEmpty()) {
							request.setAttribute("User", user);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						} else {
							JOptionPane.showMessageDialog(null, "El usuario no esta registrado.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						}
					} catch (SQLException e) {
						System.out.println("Error al buscar usuario." + e);
						JOptionPane.showMessageDialog(null, "Error al buscar usuario.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void loadRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			System.out.println("no se agrego nada a los select");
		}
	}

	private void loadInsercion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			System.out.println("no se agrego nada a los select");
		}
	}

	private void loadActualizacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			System.out.println("no se agrego nada a los select");
		}
	}

	private void inactivar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idInactivar");
		String estado = "Inactivo";

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty()) {
				if (validarId(idString)) {					
					try {
						int id = Integer.parseInt(idString);
						List<Usuarios> user = usuarioDAO.buscarUsuario(id);	
						if(!user.isEmpty()) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								usuarioDAO.inactivarUsuario(new Usuarios(id, "", "", "", "", "", "", "", estado, 0, 0, 0));
								JOptionPane.showMessageDialog(null, "Usuario inactivado con exito.", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "El usuario no esta registrado.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
							dispatcher.forward(request, response);
						}	
					} catch (SQLException e) {
						System.out.println("Error al inactivar usuario." + e);
						JOptionPane.showMessageDialog(null, "Error al inactivar usuario.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
						dispatcher.forward(request, response);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar el id del usuario.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarUser.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Debes volver a iniciar sesión");
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nombre);
		return matcher.matches();
	}

	public static boolean validarDocumento(String documento) {
		String regex = "^[0-9]{1,15}$";
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
		String regex = "^[0-9]{1,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telefono);
		return matcher.matches();
	}

	public static boolean validarUsuario(String usuario) {
		String regex = "^[a-zA-Z0-9._-]{1,25}$";
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
