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

import com.siesweb.dao.TiposDocumentosDAO;
import com.siesweb.modelo.TiposDocumentos;

@WebServlet({ "/TipoServlet", "/insertarTipo", "/actualizarTipo", "/eliminarTipo", "/listarTipo" })
public class TipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final TiposDocumentosDAO tiposDocumentosDAO = new TiposDocumentosDAO();

	public TipoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/insertarTipo":
			insertarTipo(request, response);
			break;
		case "/actualizarTipo":
			actualizarTipo(request, response);
			break;
		case "/eliminarTipo":
			eliminarTipo(request, response);
			break;
		case "/listarTipo":
			listarTipo(request, response);
			break;
		default:
			System.out.println("No se reconoce la opcion enviada!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void insertarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("descTipo");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!descripcion.isEmpty()) {
				if (validarDescripcion(descripcion)) {
					try {
						tiposDocumentosDAO.insertarTipo(new TiposDocumentos(0, descripcion));
						JOptionPane.showMessageDialog(null, "Tipo de documento insertado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
						dispatcher.forward(request, response);
					} catch (SQLException e) {
						System.out.println("Error al insertar tipo de documento." + e);
						JOptionPane.showMessageDialog(null, "Error al insertar tipo de documento.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void actualizarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idTipo");
		String descripcion = request.getParameter("descripcionTipo");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty() && !descripcion.isEmpty()) {
				if (validarDescripcion(descripcion) && validarId(idString)) {					
					try {
						int id = Integer.parseInt(idString);
						List<TiposDocumentos> tipos = tiposDocumentosDAO.buscarTipo(id);
						if(!tipos.isEmpty()) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								tiposDocumentosDAO.actualizarTipo(new TiposDocumentos(id, descripcion));
								JOptionPane.showMessageDialog(null, "Tipo de documento actualizado con exito.",
										"!Advertencia¡", JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Tipo no registrado.",
									"!Advertencia¡", JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
							dispatcher.forward(request, response);
						}
					} catch (SQLException e) {
						System.out.println("Error al actualizar tipo de documento." + e);
						JOptionPane.showMessageDialog(null, "Error al actualizar tipo de documento.",
								"!Advertencia¡", JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
						dispatcher.forward(request, response);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void eliminarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idTipos");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty()) {
				if (validarId(idString)) {
					try {
						int id = Integer.parseInt(idString);
						List<TiposDocumentos> tipos = tiposDocumentosDAO.buscarTipo(id);
						if(!tipos.isEmpty()) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								tiposDocumentosDAO.eliminarTipo(id);
								JOptionPane.showMessageDialog(null, "Tipo de documento eliminado con exito.",
										"!Advertencia¡", JOptionPane.INFORMATION_MESSAGE);
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Tipo no registrado.",
									"!Advertencia¡", JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
							dispatcher.forward(request, response);
						}							
					} catch (SQLException e) {
						System.out.println("Error al eliminar tipo de documento." + e);
						JOptionPane.showMessageDialog(null, "Error al eliminar tipo de documento.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
						dispatcher.forward(request, response);
					}					
				} else {
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Tipo de documento.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void listarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<TiposDocumentos> tipos = tiposDocumentosDAO.obtenerTipos();
				request.setAttribute("listaTipos", tipos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error al listar tipos de documento." + e);
				JOptionPane.showMessageDialog(null, "Error al listar tipos de documento.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
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
