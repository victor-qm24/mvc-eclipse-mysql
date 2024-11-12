package com.siesweb.pruebas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.siesweb.controlador.UsuarioServlet;
import com.siesweb.dao.UsuariosDAO;
import com.siesweb.modelo.Usuarios;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

class LoginMockito {

	@InjectMocks
	private UsuarioServlet usuarioServlet; // El servlet que estamos probando
	@Mock
	private HttpServletRequest request; // Simulamos la solicitud HTTP
	@Mock
	private HttpServletResponse response; // Simulamos la respuesta HTTP
	@Mock
	private RequestDispatcher requestDispatcher; // Simulamos el RequestDispatcher
	@Mock
	private UsuariosDAO usuariosDAOMock;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Inicializa los mocks			
	}

	@Test
	void testDispatcher() throws ServletException, IOException {
		// Simulamos la solicitud
		when(request.getServletPath()).thenReturn("/iniciarSesion");
		when(request.getParameter("usuario")).thenReturn("victor24");
		when(request.getParameter("password")).thenReturn("@Victor24");
		
		// Simulamos que el request obtiene el RequestDispatcher para "/admin.jsp"
		when(request.getRequestDispatcher("/admin.jsp")).thenReturn(requestDispatcher);

		// Ejecutamos el método del servlet
		usuarioServlet.doPost(request, response);

		// Verificamos que se haya llamado a forward con el destino correcto
		verify(requestDispatcher).forward(request, response);

	}
	
	@Test
    void testLogin_ValidCredentials() throws SQLException {
        // Configuramos el mock para devolver un usuario válido
		Usuarios mockUser = new Usuarios(2, "Victor Manuel", "Quinayas", "1061799845",
				"quinayas.manuel.24@gmail.com", "3135735659", "victor24",
				"$2a$10$wjyCI9fnRxKM3GDgqiwrfOg9qBEauxWNTQDtgYDE2laWJfGEsTD6e", "Activo", 1, 1, 1);

        // Probar que el inicio de sesión es exitoso con credenciales correctas
        
		try {
			
	        when(usuariosDAOMock.buscarDatosSesion("victor24")).thenReturn(mockUser);
			boolean result = usuarioServlet.iniciar_sesion(request,response);
			assertTrue(result, "El inicio de sesión debería ser exitoso con credenciales válidas.");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
