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

@WebServlet({ "/TemaServlet", "/insertarTema", "/actualizarTema", "/eliminarTema", "/listarTema" })
public class TemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final TemasDAO temaDAO = new TemasDAO();

	public TemaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void insertarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("descTema");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!descripcion.isEmpty()) {
				if (validarDescripcion(descripcion)) {
					try {
						temaDAO.insertarTema(new Temas(0, descripcion));
						JOptionPane.showMessageDialog(null, "Tema agregado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
						dispatcher.forward(request, response);
					} catch (SQLException e) {
						System.out.println("Error al insertar tema." + e);
						JOptionPane.showMessageDialog(null, "Error al insertar tema.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void actualizarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("idTema");
		String descripcion = request.getParameter("descripcionTema");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty() && !descripcion.isEmpty()) {
				if (validarDescripcion(descripcion) && validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							temaDAO.actualizarTema(new Temas(id, descripcion));
							JOptionPane.showMessageDialog(null, "Tema actualizado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al actualizar tema." + e);
							JOptionPane.showMessageDialog(null, "Error al actualizar tema.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void eliminarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("idTemas");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty()) {
				if (validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							temaDAO.eliminarTema(id);
							JOptionPane.showMessageDialog(null, "Tema eliminado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al eliminar tema." + e);
							JOptionPane.showMessageDialog(null, "Error al eliminar tema.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Tema.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void listarTema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<Temas> temas = temaDAO.obtenerTemas();
				request.setAttribute("listaTemas", temas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error al listar temas." + e);
				JOptionPane.showMessageDialog(null, "Error al eliminar tema.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTema.jsp");
				dispatcher.forward(request, response);
			}
		} else {
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
