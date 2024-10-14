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

import com.siesweb.dao.ProyectosDAO;
import com.siesweb.dao.SolicitudesDAO;
import com.siesweb.dao.TemasDAO;
import com.siesweb.dao.UsuariosDAO;
import com.siesweb.modelo.Solicitudes;


@WebServlet({"/SolicitudServlet","/actualizarSolicitud","/listarSolicitud"})
public class SolicitudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	
	private final UsuariosDAO usuarioDAO = new UsuariosDAO();
	private final ProyectosDAO proyectosDAO = new ProyectosDAO();
	private final TemasDAO rolesDAO = new TemasDAO();
	private final SolicitudesDAO solicitudDAO = new SolicitudesDAO();
	
    public SolicitudServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/actualizarSolicitud":
			actualizarSolicitud(request, response);
			break;
		case "/listarSolicitud":
			listarSolicitud(request, response);
			break;
		default:
			System.out.println("No se reconoce la opcion enviada!");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void actualizarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idSolicitud");
		String estado = "Terminado";
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					List<Solicitudes> solicitud = solicitudDAO.buscarSolicitud(id);
					
					if (!solicitud.isEmpty()) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
						if (respuesta == JOptionPane.YES_OPTION) {
							solicitudDAO.actualizarSolicitud(new Solicitudes(id,"","",estado,0,0,0));
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
							dispatcher.forward(request, response);
						} else {
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("No se encontro el id a ejecutar.");
						JOptionPane.showMessageDialog(null, "No se encontro el id a ejecutar.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
				}
			} else {
				System.out.println("El id no es valido.");
				JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Ingresa un id porfavor");
			JOptionPane.showMessageDialog(null, "Debes ingresar el id de la solicitud.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<Solicitudes> solicitudes = solicitudDAO.obtenerSolicitudes();
			//int id = solicitudes.get(0)
			//List<Usuarios> user = usuarioDAO.buscarUsuario(0)
			request.setAttribute("listaSolicitudes", solicitudes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
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
}
