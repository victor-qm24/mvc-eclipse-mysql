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
		if (!idString.isEmpty()) {
			if (validarId(idString)) {
				int id = Integer.parseInt(idString);
				try {
					List<Solicitudes> solicitud = solicitudDAO.buscarSolicitud(id);
					
					if (!solicitud.isEmpty()) {
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro?");
							if (respuesta == JOptionPane.YES_OPTION) {
								solicitudDAO.actualizarSolicitud(new Solicitudes(id,"","",estado,0,0,0));
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
								dispatcher.forward(request, response);
							} else {
								RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
								dispatcher.forward(request, response);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombreUser") != null) {
				List<Solicitudes> solicitudes = solicitudDAO.obtenerSolicitudes();			
				request.setAttribute("listaSolicitudes", solicitudes);
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminSolicitud.jsp");
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
	
	private void insertarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fech = request.getParameter("fech");
		String users = request.getParameter("users");
		String proyect = request.getParameter("proyect");
		String temas = request.getParameter("temas");		
		String observacion = request.getParameter("observacion");		

		try {
			Temas tema = temasDAO.obtenerIdTema(temas);
			Proyectos proy = proyectosDAO.obtenerIdProyecto(proyect);
			Usuarios user = usuarioDAO.obtenerIdUsuario(users);

			if (!users.isEmpty() && !proyect.isEmpty() && !temas.isEmpty()) {
				System.out.println(users + user.getUsuario());
				if (users.equals(user.getUsuario())) {

					if (tema != null && proy != null && user != null) {
						HttpSession session = request.getSession(false);
						if (session != null && session.getAttribute("nombreUser") != null) {
							String estado = "Pendiente";
							solicitudDAO.agregarSolicitud(new Solicitudes(0, fech, observacion, estado, proy.getId(), tema.getId(), user.getId()));
							JOptionPane.showMessageDialog(null, "Solicitud agregada con exito.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							
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
							
							RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
							dispatcher.forward(request, response);
						}else {
							JOptionPane.showMessageDialog(null, "Debes volver a iniciar sesión.", "!Advertencia¡",
									JOptionPane.INFORMATION_MESSAGE);
							RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
							dispatcher.forward(request, response);
						}
					} else {
						System.out.println("No se pudo obtener el id de tema, usuario o proyecto.");
					}
				} else {
					System.out.println("El email debe ser el mismo con el que se registro.");
					JOptionPane.showMessageDialog(null, "El email debe ser el mismo con el que se registro.", "!Advertencia¡",
							JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				System.out.println("Debe llenar todos los campos.");
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "!Advertencia¡",
						JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("No se pudo obtener el Id de rol, tipo y proyecto" + e);
		}
	}
	
	public void enviarEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		try {
						
			String emisor = request.getParameter("users");
			Usuarios us = usuarioDAO.buscarDatosSesion(emisor);
			String correoEmisor = us.getEmail();
			
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
	        
	        final String username = "quinayas.manuel.24@gmail.com"; // Cambia esto por tu dirección de correo	        
	        final String password = "ntgh fdaw twdg fcqa"; // Usa la contraseña de aplicación
	        
	        // Autenticación
	        
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });
	        
	        try {
	            // Crear el mensaje
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
	            message.setSubject(asunto);
	            message.setText(contenido);
	            
	            Transport.send(message);            	
	            
	            System.out.println("enviado");
	        } catch (MessagingException e) {	            
	            System.out.println("error al enviar" + e);	            
	        }  
	        
	        
		} catch (SQLException e) {
			response.getWriter().println("Usuario no encontrado.");
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
