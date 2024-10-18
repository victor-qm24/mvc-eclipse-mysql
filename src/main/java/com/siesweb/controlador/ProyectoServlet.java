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

import com.siesweb.dao.ProyectosDAO;
import com.siesweb.modelo.Proyectos;


@WebServlet({"/ProyectoServlet","/insertarProyecto","/actualizarProyecto","/eliminarProyecto","/listarProyecto"})
public class ProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProyectosDAO proyectosDAO = new ProyectosDAO();
       
    public ProyectoServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/insertarProyecto":
			insertarProyecto(request, response);
			break;
		case "/actualizarProyecto":
			actualizarProyecto(request, response);
			break;
		case "/eliminarProyecto":
			eliminarProyecto(request, response);
			break;
		case "/listarProyecto":
			listarProyecto(request, response);
			break;
		default:
			System.out.println("No se reconoce la opcion enviada!");
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertarProyecto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String estado = request.getParameter("estado");
		String ubicacion = request.getParameter("ubicacion");		
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			
			if (!titulo.isEmpty() && !estado.isEmpty() && !ubicacion.isEmpty()) {
				if (validar(titulo) && validarEstado(estado) && validar(ubicacion)) {
					try {
						proyectosDAO.insertarProyecto(new Proyectos(0, titulo, estado, ubicacion));
							JOptionPane.showMessageDialog(null, "Proyecto agregado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
							dispatcher.forward(request, response);
					} catch (SQLException e) {
						System.out.println("Error al insertar proyecto." + e);
						JOptionPane.showMessageDialog(null, "Error al insertar proyecto.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
						dispatcher.forward(request, response);
					}
				} else {					
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
				dispatcher.forward(request, response);
			}
			
		}else {			
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void actualizarProyecto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idProyecto");	
		String titulo = request.getParameter("title");
		String estado = request.getParameter("state");
		String ubicacion = request.getParameter("ubication");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty() && !titulo.isEmpty() && !estado.isEmpty() && !ubicacion.isEmpty()) {
				if (validar(titulo) && validarEstado(estado) && validar(ubicacion) && validarId(idString)) {
							
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							proyectosDAO.actualizarProyecto(new Proyectos(id, titulo, estado, ubicacion));
							JOptionPane.showMessageDialog(null, "Proyecto actualizado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al actualizar proyecto." + e);
							JOptionPane.showMessageDialog(null, "Error al actualizar proyecto.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
							dispatcher.forward(request, response);
						}
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
						dispatcher.forward(request, response);
					}
							
				} else {					
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
				dispatcher.forward(request, response);
			}
		}else {			
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void eliminarProyecto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idProyectos");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {		
			if (!idString.isEmpty()) {
				if (validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							proyectosDAO.eliminarProyecto(id);
							JOptionPane.showMessageDialog(null, "Proyecto eliminado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al eliminar proyecto." + e);
							JOptionPane.showMessageDialog(null, "Error al eliminar proyecto.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
						dispatcher.forward(request, response);
					}
				} else {					
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Proyecto.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
				dispatcher.forward(request, response);
			}
		}else {			
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarProyecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();
				request.setAttribute("listaProyectos", proyectos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error al listar proyectos" + e);
				JOptionPane.showMessageDialog(null, "Error al listar proyectos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
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
	
	public static boolean validar(String validar) {
		String regex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,100}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(validar);
		return matcher.matches();
	}
	
	public static boolean validarEstado(String estado) {
		String regex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,25}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(estado);
		return matcher.matches();
	}
}
