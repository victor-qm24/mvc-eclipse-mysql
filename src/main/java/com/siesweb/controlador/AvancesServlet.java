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

import com.siesweb.dao.ProyectosDAO;
import com.siesweb.modelo.Proyectos;
import com.siesweb.dao.AvancesDAO;
import com.siesweb.modelo.Avances;

@WebServlet({ "/AvancesServlet", "/insertarAvc", "/actualizarAvc", "/buscarAvce", "/eliminarAvc", "/listarAvc" })
public class AvancesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProyectosDAO proyectosDAO = new ProyectosDAO();
	private final AvancesDAO avancesDAO = new AvancesDAO();

	public AvancesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getServletPath();
		switch (opcion) {
		case "/insertarAvc":
			insertarAvc(request, response);
			break;
		case "/actualizarAvc":
			actualizarAvc(request, response);
			break;
		case "/buscarAvce":
			buscarAvc(request, response);
			break;
		case "/eliminarAvc":
			eliminarAvc(request, response);
			break;
		case "/listarAvc":
			listarAvc(request, response);
			break;
		default:
			System.out.println("No ha elegido ninguna opcion");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void insertarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fecha = request.getParameter("fecha");
		String tramo_amp = request.getParameter("tramo_amp");
		String tramo_mej = request.getParameter("tramo_mej");
		String tramo_sub = request.getParameter("tramo_sub");
		String tramo_bas = request.getParameter("tramo_bas");
		String tramo_asf = request.getParameter("tramo_asf");
		String cunetas = request.getParameter("cunetas");
		String muros = request.getParameter("muros");
		String ejecucion = request.getParameter("ejecucion");
		String proyecto = request.getParameter("proyecto");

		try {
			Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);

			if (proy != null) {
				avancesDAO.insertarAvc(new Avances(0, fecha, tramo_amp, tramo_mej, tramo_sub, tramo_bas, tramo_asf,
						cunetas, muros, ejecucion, proy.getId()));
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminInsertarAvc.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("Algo salio mal!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void actualizarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idUpdate");

		if (!idString.isEmpty()) {

			int id = Integer.parseInt(idString);
			String fecha = request.getParameter("fecha");
			String tramo_amp = request.getParameter("tramo_amp");
			String tramo_mej = request.getParameter("tramo_mej");
			String tramo_sub = request.getParameter("tramo_sub");
			String tramo_bas = request.getParameter("tramo_bas");
			String tramo_asf = request.getParameter("tramo_asf");
			String cunetas = request.getParameter("cunetas");
			String muros = request.getParameter("muros");
			String ejecucion = request.getParameter("ejecucion");
			String proyecto = request.getParameter("proyecto");

			try {
				Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);

				if (proy != null) {
					avancesDAO.actualizarAvc(new Avances(id, fecha, tramo_amp, tramo_mej, tramo_sub, tramo_bas,
							tramo_asf, cunetas, muros, ejecucion, proy.getId()));
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarAvc.jsp");
					dispatcher.forward(request, response);
				} else {
					System.out.println("Algo salio mal!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Ingresa un id porfavor");
		}
	}

	private void buscarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idLoad");
		if (!idStr.isEmpty()) {
			int id = Integer.parseInt(idStr);
			try {
				List<Avances> avanc = avancesDAO.buscarAvc(id);
				if (avanc != null) {
					request.setAttribute("Avanc", avanc);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
					dispatcher.forward(request, response);
				} else {
					System.out.println("La instancia de avance es nula!");
				}
			} catch (SQLException e) {
			}
		} else {
			System.out.println("Debes ingresar un Id");
		}
	}

	private void eliminarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idDelete");
		if (!idString.isEmpty()) {
			int id = Integer.parseInt(idString);
			try {
				avancesDAO.eliminarAvc(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
			}
		} else {
			System.out.println("Ingresa un id porfavor");
		}
	}

	private void listarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Avances> avanc = avancesDAO.obtenerAvc();
			request.setAttribute("Avanc", avanc);
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarAvc.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
