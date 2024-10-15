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

import com.siesweb.dao.TemasDAO;
import com.siesweb.modelo.Temas;


@WebServlet({"/TemaServlet","/insertarTema","/actualizarTema","/eliminarTema","/listarTema"})
public class TemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private final TemasDAO temaDAO = new TemasDAO();
	
    public TemaServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/insertarTema":
			insertarTema(request, response);
			break;
		case "/actualizarTema":
			actualizarTema(request, response);
			break;
		case "/eliminarTema":
			eliminarTema(request, response);
			break;
		case "/listarTema":
			listarTema(request, response);
			break;
		default:
			System.out.println("No se reconoce la opcion enviada!");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("descTema");
		try {
			if (!descripcion.isEmpty()) {
				if (validarDescripcion(descripcion) ) {
					HttpSession session = request.getSession(false);
					if (session != null && session.getAttribute("nombreUser") != null) {
						temaDAO.insertarTema(new Temas(0, descripcion));
							JOptionPane.showMessageDialog(null, "Tema agregado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
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
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private void actualizarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idTema");	
		String descripcion = request.getParameter("descripcionTema");
		if (!idString.isEmpty()) {
			try {
				if (!descripcion.isEmpty()) {
					if (validarDescripcion(descripcion) && validarId(idString)) {						
						
						int id = Integer.parseInt(idString);
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
							
								temaDAO.actualizarTema(new Temas(id, descripcion));
								JOptionPane.showMessageDialog(null, "Tema actualizado con exito.", "!Advertencia¡",
										JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
								dispatcher.forward(request, response);
							}else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
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
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					System.out.println("Debe llenar todos los campos.");
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Tema.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void eliminarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idRoles");
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					List<Temas> tema = temaDAO.buscarTema(id);
					if (!tema.isEmpty()) {
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								temaDAO.eliminarTema(id);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
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
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Tema.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarTema(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombreUser") != null) {
				List<Temas> temas = temaDAO.obtenerTemas();
				request.setAttribute("listaTemas", temas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
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
	
	public static boolean validarDescripcion(String descripcion) {
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,40}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(descripcion);
		return matcher.matches();
	}

}
