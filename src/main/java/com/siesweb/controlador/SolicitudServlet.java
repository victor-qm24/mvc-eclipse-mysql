package com.siesweb.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.siesweb.dao.AvancesDAO;
import com.siesweb.dao.ProyectosDAO;
import com.siesweb.dao.SolicitudesDAO;
import com.siesweb.dao.TemasDAO;
import com.siesweb.dao.UsuariosDAO;
import com.siesweb.modelo.Avances;
import com.siesweb.modelo.Proyectos;
import com.siesweb.modelo.Solicitudes;
import com.siesweb.modelo.Temas;
import com.siesweb.modelo.Usuarios;


@WebServlet({"/SolicitudServlet","/actualizarSolicitud","/listarSolicitud","/insertarSolicitud"})
public class SolicitudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	
	private final UsuariosDAO usuarioDAO = new UsuariosDAO();
	private final ProyectosDAO proyectosDAO = new ProyectosDAO();
	private final TemasDAO temasDAO = new TemasDAO();
	private final SolicitudesDAO solicitudDAO = new SolicitudesDAO();
	private final AvancesDAO avanceDAO = new AvancesDAO();
	
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
		case "/insertarSolicitud":
			insertarSolicitud(request, response);
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
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!idString.isEmpty()) {
				if (validarId(idString)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
					if (respuesta == JOptionPane.YES_OPTION) {
						try {
							int id = Integer.parseInt(idString);
							solicitudDAO.actualizarSolicitud(new Solicitudes(id,"","",estado,0,0,0));
							JOptionPane.showMessageDialog(null, "Solicitud ejecutada con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
							dispatcher.forward(request, response);
						} catch (SQLException e) {
							System.out.println("Error al ejecutar solicitud." + e);
							JOptionPane.showMessageDialog(null, "Error al ejecutar solicitud.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
						dispatcher.forward(request, response);
					}
				} else {					
					JOptionPane.showMessageDialog(null, "El id no es valido.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debes ingresar el id de la solicitud.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listarSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			try {
				List<Solicitudes> solicitudes = solicitudDAO.obtenerSolicitudes();			
				request.setAttribute("listaSolicitudes", solicitudes);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				System.out.println("Error al listar solicitudes." + e);
				JOptionPane.showMessageDialog(null, "Error al listar solicitudes.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}		
	}
	
	private void insertarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fech = request.getParameter("fech");
		String users = request.getParameter("users");
		String proyect = request.getParameter("proyect");
		String temas = request.getParameter("temas");		
		String observacion = request.getParameter("observacion");		
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("nombreUser") != null) {
			if (!users.isEmpty() && !proyect.isEmpty() && !temas.isEmpty()) {
				if(validarFecha(fech) && validarUsuario(users) && validarObservacion(observacion)) {
					try {	
						Temas tema = temasDAO.obtenerIdTema(temas);
						Proyectos proy = proyectosDAO.obtenerIdProyecto(proyect);
						Usuarios user = usuarioDAO.obtenerIdUsuario(users);	
						String estado = "Pendiente";
						if (users.equals(user.getUsuario())) {
							solicitudDAO.agregarSolicitud(new Solicitudes(0, fech, observacion, estado, proy.getId(), tema.getId(), user.getId()));												
							Avances avanceUltimo = avanceDAO.obtenerUltimoAvc();
							List<Avances> avances = avanceDAO.obtenerAvc();
							List<Proyectos> proyectos = proyectosDAO.obtenerProyectos();
							List<Temas> temass = temasDAO.obtenerTemas();						
							Gson gson = new Gson();
							String json = gson.toJson(avances);	
							request.setAttribute("avancesJson", json);					    
							request.setAttribute("avancesUltimo", avanceUltimo);
							request.setAttribute("listaProyectos", proyectos);					    
							request.setAttribute("listaTemas", temass);
							enviarEmail(request,response);
							JOptionPane.showMessageDialog(null, "Solicitud agregada con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
							dispatcher.forward(request, response);
						} else {						
							JOptionPane.showMessageDialog(null, "El usuario debe ser el mismo con el que se registro.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
							dispatcher.forward(request, response);
						}
					} catch (SQLException e) {
						System.out.println("Error al enviar solicitud." + e);
						JOptionPane.showMessageDialog(null, "Error al enviar solicitud.", "!Advertencia¡",
								JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Uno o varios campos no son validos.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
					dispatcher.forward(request, response);
				}
			} else {				
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
					JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public void enviarEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		try {						
			String usuarioEmisor = request.getParameter("users");
			Usuarios datosUsuario = usuarioDAO.buscarDatosSesion(usuarioEmisor);
			String correoEmisor = datosUsuario.getEmail();
			
			String asunto = request.getParameter("temas");
	        String proyect = request.getParameter("proyect");
	        String observacion = request.getParameter("observacion");
	        String contenido = observacion + " \n\nProyecto asociado: " + proyect +" \n\nLa respuesta se debe enviar al correo: "
	        		+ correoEmisor;
	        
	        // Configuración de la sesión en gmail
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        
	        final String correoAdmin = "quinayas.manuel.24@gmail.com"; // Cambia esto por tu dirección de correo	        
	        final String passwordAdmin = "ntgh fdaw twdg fcqa"; // Usa la contraseña de aplicación
	        
	        // Autenticación	        
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(correoAdmin, passwordAdmin);
	                    }
	                });
	        
	        try {
	            // Crear el mensaje
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(correoAdmin));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoAdmin)); //correo trabajo social
	            message.setSubject(asunto);
	            message.setText(contenido);
	            
	            Transport.send(message);
	            JOptionPane.showMessageDialog(null, "Solicitud enviada con exito al correo.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
	        } catch (MessagingException e) {	            
	            System.out.println("error al enviar" + e);
	            JOptionPane.showMessageDialog(null, "Error al enviar solicitud al correo.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
	        } 
		} catch (SQLException e) {
			System.out.println("Usuario no encontrado" + e);
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
	
	public static boolean validarUsuario(String usuario) {
		String regex = "^[a-zA-Z0-9._-]{1,25}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(usuario);
		return matcher.matches();
	}
	
	public static boolean validarObservacion(String observacion) {
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,100}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(observacion);
		return matcher.matches();
	}
}
