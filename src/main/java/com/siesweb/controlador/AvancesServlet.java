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
import com.siesweb.dao.AvancesDAO;
import com.siesweb.modelo.Avances;

@WebServlet({ "/AvancesServlet", "/insertarAvc", "/actualizarAvc", "/buscarAvce", "/eliminarAvc", "/listarAvc",
	"/cargarInsercionAvc", "/cargarActualizacionAvc"})
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
		case "/cargarInsercionAvc":
			loadInsercionAvc(request, response);
			break;
		case "/cargarActualizacionAvc":
			loadActualizacionAvc(request, response);
			break;
		default:
			System.out.println("No ha elegido ninguna opcion");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
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
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!fecha.isEmpty() && !tramo_amp.isEmpty() && !tramo_mej.isEmpty() && !tramo_sub.isEmpty()
					&& !tramo_bas.isEmpty() && !tramo_asf.isEmpty() && !cunetas.isEmpty() && !muros.isEmpty()
					&& !ejecucion.isEmpty() && !proyecto.isEmpty()) {
				if (validarFecha(fecha) && validarTramo(tramo_mej) && validarTramo(tramo_amp)
						&& validarTramo(tramo_sub) && validarTramo(tramo_bas) && validarTramo(tramo_asf)
						&& validarCunetasMuros(cunetas) && validarCunetasMuros(muros) && validarEjecucion(ejecucion) 
						&& proyecto != "-") {	
					try {
						Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
						avancesDAO.insertarAvc(new Avances(0, fecha, tramo_amp, tramo_mej, tramo_sub, tramo_bas, tramo_asf,
								cunetas, muros, ejecucion, proy.getId()));
						JOptionPane.showMessageDialog(null, "Avance insertado con exito.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						loadInsercionAvc(request,response);	
					} catch (SQLException e) {
						System.out.println("Error al insertar avance." + e);
						JOptionPane.showMessageDialog(null, "Error al insertar avance.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						loadInsercionAvc(request,response);
					}
				}else {				
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					loadInsercionAvc(request,response);					
				}
			}else {			
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				loadInsercionAvc(request,response);	
			}
		}else {							
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void actualizarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idUpdate");
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
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty() && !fecha.isEmpty() && !tramo_amp.isEmpty() && !tramo_mej.isEmpty() && !tramo_sub.isEmpty()
					&& !tramo_bas.isEmpty() && !tramo_asf.isEmpty() && !cunetas.isEmpty() && !muros.isEmpty()
					&& !ejecucion.isEmpty() && !proyecto.isEmpty()) {
				if (validarId(idString) && validarFecha(fecha) && validarTramo(tramo_mej) && validarTramo(tramo_amp)
						&& validarTramo(tramo_sub) && validarTramo(tramo_bas) && validarTramo(tramo_asf)
						&& validarCunetasMuros(cunetas) && validarCunetasMuros(muros) && validarEjecucion(ejecucion) 
						&& proyecto != "-") {					
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						int id = Integer.parseInt(idString);
						try {
							Proyectos proy = proyectosDAO.obtenerIdProyecto(proyecto);
							avancesDAO.actualizarAvc(new Avances(id, fecha, tramo_amp, tramo_mej, tramo_sub, tramo_bas,
									tramo_asf, cunetas, muros, ejecucion, proy.getId()));
							JOptionPane.showMessageDialog(null, "Avance actualizado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							loadActualizacionAvc(request,response);								
						} catch (SQLException e) {
							System.out.println("Error al actualizar avance." + e);
							JOptionPane.showMessageDialog(null, "Error al actualizar avance.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							loadActualizacionAvc(request,response);
						}
					}else {
						loadActualizacionAvc(request,response);						
					}					
				}else {				
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					loadActualizacionAvc(request,response);					
				}
			}else {			
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				loadActualizacionAvc(request,response);				
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void buscarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idStr = request.getParameter("idLoad");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idStr.isEmpty()) {
				if (validarId(idStr)) {
					try {
						int id = Integer.parseInt(idStr);
						List<Avances> avanc = avancesDAO.buscarAvc(id);
						request.setAttribute("Avanc", avanc);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
						dispatcher.forward(request, response);
					} catch (SQLException e) {
						System.out.println("Error al buscar avance." + e);
						JOptionPane.showMessageDialog(null, "Error al buscar avance.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
						dispatcher.forward(request, response);
					}
				}else {				
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
					dispatcher.forward(request, response);
				}
			} else {			
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void eliminarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("idDelete");
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty()) {
				if (validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);						
							avancesDAO.eliminarAvc(id);
							JOptionPane.showMessageDialog(null, "Avance eliminado con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al eliminar avance." + e);
							JOptionPane.showMessageDialog(null, "Error al eliminar avance.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
							dispatcher.forward(request, response);
						}
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
						dispatcher.forward(request, response);
					}
				}else {				
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
					dispatcher.forward(request, response);
				}
			}else {			
				JOptionPane.showMessageDialog(null, "Debes ingresar el id del Usuario.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminBuscarEliminarAvc.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void listarAvc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<Avances> avanc = avancesDAO.obtenerAvc();
				request.setAttribute("Avanc", avanc);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarAvc.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error al listar avances." + e);
				JOptionPane.showMessageDialog(null, "Error al listar avances.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminListarAvc.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void loadInsercionAvc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {            
            List<Proyectos> proyectos = proyectosDAO.obtenerProyectos(); 
            request.setAttribute("listaProyectos", proyectos);           
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminInsertarAvc.jsp");
			dispatcher.forward(request, response);
            
        } catch (SQLException e) {
        	System.out.println("no se agrego nada a los select" + e);
        }
    }
	private void loadActualizacionAvc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<Proyectos> proyectos = proyectosDAO.obtenerProyectos(); 
            request.setAttribute("listaProyectos", proyectos);           
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminActualizarAvc.jsp");
			dispatcher.forward(request, response);
            
        } catch (SQLException e) {
        	System.out.println("no se agrego nada a los select" + e);
        }
    }
	
	public static boolean validarId(String id) {
		String regex = "^[0-9]{1,3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public static boolean validarFecha(String fecha) {
		String regex = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fecha);
		return matcher.matches();
	}

	public static boolean validarTramo(String tramo) {
		String regex = "^(?:[1-9]\\d*|[1-9]\\d*\\.\\d{2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(tramo);
		return matcher.matches();
	}

	public static boolean validarCunetasMuros(String cantidad) {
		String regex = "^[1-9]\\d*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cantidad);
		return matcher.matches();
	}

	public static boolean validarEjecucion(String ejecucion) {
		String regex = "^(100|[0-9]?\\d)(\\.\\d+)?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ejecucion);
		return matcher.matches();
	}
}
