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

import com.siesweb.dao.RolesDAO;
import com.siesweb.modelo.Roles;


@WebServlet({"/RolServlet","/insertarRol","/actualizarRol","/eliminarRol","/listarRol"})
public class RolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final RolesDAO rolesDAO = new RolesDAO();   
    
    public RolServlet() {
        super();        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/insertarRol":
			insertarRol(request, response);
			break;
		case "/actualizarRol":
			actualizarRol(request, response);
			break;
		case "/eliminarRol":
			eliminarRol(request, response);
			break;
		case "/listarRol":
			listarRol(request, response);
			break;
		default:
			System.out.println("No se reconoce la opcion enviada!");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertarRol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("descRol");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {		
			if (!descripcion.isEmpty()) {
				if (validarDescripcion(descripcion) ) {
					try {
						rolesDAO.insertarRol(new Roles(0, descripcion));
						JOptionPane.showMessageDialog(null, "Rol agregado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
						dispatcher.forward(request, response);
					} catch (SQLException e) {
						System.out.println("Error al insertar rol." + e);
						JOptionPane.showMessageDialog(null, "Error al insertar rol.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
						dispatcher.forward(request, response);
					}					
				} else {					
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
				dispatcher.forward(request, response);
			}
		
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void actualizarRol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idRol");	
		String descripcion = request.getParameter("descripcionRol");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {			
			if (!idString.isEmpty() && !descripcion.isEmpty()) {
				if (validarDescripcion(descripcion) && validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							rolesDAO.actualizarRol(new Roles(id, descripcion));
							JOptionPane.showMessageDialog(null, "Rol actualizado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al actualizar rol." + e);
							JOptionPane.showMessageDialog(null, "Error al actualizar rol.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
							dispatcher.forward(request, response);
						}
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
						dispatcher.forward(request, response);
					}
				} else {					
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void eliminarRol(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idRoles");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {		
			if (!idString.isEmpty()) {
				if (validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							rolesDAO.eliminarRol(id);
							JOptionPane.showMessageDialog(null, "Rol eliminado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al eliminar rol." + e);
							JOptionPane.showMessageDialog(null, "Error al eliminar rol.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
						dispatcher.forward(request, response);
					}
				} else {					
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Rol.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarRol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<Roles> roles = rolesDAO.obtenerRoles();
				request.setAttribute("listaRoles", roles);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error al listar roles." + e);
				JOptionPane.showMessageDialog(null, "Error al listar roles.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminRol.jsp");
				dispatcher.forward(request, response);
			}
		}else {
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
	
	public static boolean validarDescripcion(String descripcion) {
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(descripcion);
		return matcher.matches();
	}

}
