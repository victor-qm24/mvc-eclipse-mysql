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
import javax.swing.JOptionPane;

import com.siesweb.dao.TiposDocumentosDAO;
import com.siesweb.modelo.TiposDocumentos;

@WebServlet({"/TipoServlet","/insertarTipo","/actualizarTipo","/eliminarTipo","/listarTipo"})
public class TipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final TiposDocumentosDAO tiposDocumentosDAO = new TiposDocumentosDAO();
       
    public TipoServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void insertarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("descTipo");
		try {
			if (!descripcion.isEmpty()) {
				if (validarDescripcion(descripcion) ) {						
					tiposDocumentosDAO.insertarTipo(new TiposDocumentos(0, descripcion));
						JOptionPane.showMessageDialog(null, "Usuario agregado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
						dispatcher.forward(request, response);					
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
			System.out.println(e);
		}
	}
	
	private void actualizarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idTipo");	
		String descripcion = request.getParameter("descripcionTipo");
		if (!idString.isEmpty()) {
			try {
				if (!descripcion.isEmpty()) {
					if (validarDescripcion(descripcion) && validarId(idString)) {						
						
						int id = Integer.parseInt(idString);
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
						if (respuesta == JOptionPane.YES_OPTION) {
						
							tiposDocumentosDAO.actualizarTipo(new TiposDocumentos(id, descripcion));
							JOptionPane.showMessageDialog(null, "Tipo de documento actualizado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
							dispatcher.forward(request, response);
						}else {
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("Uno o varios campos no son validos.");
						JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					System.out.println("Debe llenar todos los campos.");
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Tipo de documento.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void eliminarTipo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idTipoDoc");
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					List<TiposDocumentos> tipo = tiposDocumentosDAO.buscarTipo(id);
					if (!tipo.isEmpty()) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
						if (respuesta == JOptionPane.YES_OPTION) {
							tiposDocumentosDAO.eliminarTipo(id);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
							dispatcher.forward(request, response);
						} else {
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("No se encontro el id a eliminar.");
						JOptionPane.showMessageDialog(null, "No se encontro el id a eliminar.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id del Tipo de documento.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<TiposDocumentos> tipos = tiposDocumentosDAO.obtenerTipos();
			request.setAttribute("listaTipos", tipos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminTipo.jsp");
			dispatcher.forward(request, response);
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
