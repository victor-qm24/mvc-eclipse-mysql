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
		
		try {
			if (!titulo.isEmpty() && !estado.isEmpty() && !ubicacion.isEmpty()) {
				if (validar(titulo) && validar(estado) && validar(ubicacion)) {
					HttpSession session = request.getSession(false);
					if (session != null && session.getAttribute("nombreUser") != null) {
						proyectosDAO.insertarProyecto(new Proyectos(0, titulo, estado, ubicacion));
							JOptionPane.showMessageDialog(null, "Proyecto agregado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
							dispatcher.forward(request, response);
					}else {
						JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					System.out.println("Uno o varios campos no son validos.");
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private void actualizarProyecto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idProyecto");	
		String titulo = request.getParameter("title");
		String estado = request.getParameter("state");
		String ubicacion = request.getParameter("ubication");
		
		if (!idString.isEmpty()) {
			try {
				if (!titulo.isEmpty() && !estado.isEmpty() && !ubicacion.isEmpty()) {
					if (validar(titulo) && validar(estado) && validar(ubicacion) && validarId(idString)) {						
						
						int id = Integer.parseInt(idString);
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
							
								proyectosDAO.actualizarProyecto(new Proyectos(id, titulo, estado, ubicacion));
								JOptionPane.showMessageDialog(null, "Proyecto actualizado con exito.", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
								dispatcher.forward(request, response);
							}else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("Uno o varios campos no son validos.");
						JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					System.out.println("Debe llenar todos los campos.");
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Proyecto.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void eliminarProyecto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idProyectos");
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					List<Proyectos> proyecto = proyectosDAO.buscarProyecto(id);
					if (!proyecto.isEmpty()) {
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								proyectosDAO.eliminarProyecto(id);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
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
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Proyecto.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarProyecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombreUser") != null) {
				List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();
				request.setAttribute("listaProyectos", proyectos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminProyecto.jsp");
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
	
	public static boolean validarId(String id) {
		String regex = "^[0-9]{1,3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}
	
	public static boolean validar(String validar) {
		String regex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,40}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(validar);
		return matcher.matches();
	}
}
