package com.siesweb.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siesweb.modelo.*;
import com.siesweb.dao.*;

@WebServlet({"/UsuarioServlet","/iniciarSesion","/registrar","/actualizar","/eliminar","/listar","/buscar"})
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    private final UsuariosDAO usuarioDAO = new UsuariosDAO();
    private final ProyectosDAO proyectosDAO = new ProyectosDAO();
    private final TiposDocumentosDAO tiposDocumentosDAO = new TiposDocumentosDAO();
    private final RolesDAO rolesDAO = new RolesDAO();
    
    public UsuarioServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch(action) {				
			case "/iniciarSesion":
				iniciar_sesion(request,response);
				break;
			case "/registrar":
				registrar(request,response);
				break;
			case "/actualizar":
				actualizar(request,response);
				break;
			case "/eliminar":
				eliminar(request,response);
				break;
			case "/listar":
				listar(request,response);
				break;
			case "/buscar":
				buscar(request,response);
				break;
			default:
				System.out.println("No se reconoce la opcion enviada!");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void iniciar_sesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");
				
		if(!user.isEmpty() && !pass.isEmpty()) {
			try {
				Usuarios usuario = usuarioDAO.buscarDatosSesion(user,pass);
				if(usuario != null) {
					int idRol = usuario.getRolId();
					String nombreUser = usuario.getNombre();
					request.setAttribute("nombreUser", nombreUser);
					if(idRol == 1) {						
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
				        dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
				        dispatcher.forward(request, response);
					}					
				}else {
					System.out.println("Sin permisos");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String documento = request.getParameter("documento");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");        
        String tipo = request.getParameter("tipo");
        String rol = request.getParameter("rol");
        String proyecto = request.getParameter("proyecto");
        
        try {
			TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
			Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
			Roles rl = rolesDAO.obtenerIdRol(rol);			
			
			if (tipoDocumento != null && proy != null && rl != null) {
				usuarioDAO.agregarUsuario(new Usuarios(0, nombre, apellido,
                        documento, email, telefono, usuario, password,
                        tipoDocumento.getId(), proy.getId(), rl.getId()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminAgregarUser.jsp");
		        dispatcher.forward(request, response);
			}else {
				System.out.println("Algo salio mal!");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idString = request.getParameter("id");

        if (!idString.isEmpty()) {

            int id = Integer.parseInt(idString);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String documento = request.getParameter("documento");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");        
            String tipo = request.getParameter("tipo");
            String rol = request.getParameter("rol");
            String proyecto = request.getParameter("proyecto");

            try {
    			TiposDocumentos tipoDocumento = tiposDocumentosDAO.obtenerIdTipo(tipo);
    			Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
    			Roles rl = rolesDAO.obtenerIdRol(rol);			
    			
    			if (tipoDocumento != null && proy != null && rl != null) {
    				usuarioDAO.actualizarUsuario(new Usuarios(id, nombre, apellido,
                            documento, email, telefono, usuario, password,
                            tipoDocumento.getId(), proy.getId(), rl.getId()));
    				RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarUser.jsp");
    		        dispatcher.forward(request, response);
    			}else {
    				System.out.println("Algo salio mal!");
    			}
    		} catch (SQLException e) {			
    			e.printStackTrace();
    		}
        } else {
            System.out.println("Ingresa un id porfavor");
        }
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idString = request.getParameter("id");
        if (!idString.isEmpty()) {
            int id = Integer.parseInt(idString);
            try {
                usuarioDAO.eliminarUsuario(id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminEliminarUser.jsp");
		        dispatcher.forward(request, response);
            } catch (SQLException e) {
            }
        } else {
        	System.out.println("Ingresa un id porfavor");
        }
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Usuarios> usuarios = usuarioDAO.obtenerUsuarios();
			request.setAttribute("listaUsuarios", usuarios);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarUser.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
        if (!idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            try {
            	List<Usuarios> user = usuarioDAO.buscarUsuario(id);
                if (user != null) {                	
                	request.setAttribute("User", user);
                	RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarUser.jsp");
        	        dispatcher.forward(request, response);
                } else {
                	System.out.println("es nulo");
                }
            } catch (SQLException e) {
            }
        } else {
            System.out.println("no hay id");
        }
	}
}
