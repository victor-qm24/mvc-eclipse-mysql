package com.siesweb.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.siesweb.dao.UsuariosDAO;
import com.siesweb.modelo.Usuarios;

import org.junit.jupiter.api.BeforeEach;

class login {

	private UsuariosDAO usuarioDAO;

	@BeforeEach
	public void setUp() {
		// Crear la instancia de usuarioDAO
		usuarioDAO = new UsuariosDAO();
	}

	@Test
	void testDatosSesion() {

		Usuarios userEsperado = new Usuarios(2, "Victor Manuel", "Quinayas", "1061799845",
				"quinayas.manuel.24@gmail.com", "3135735659", "victor24",
				"$2a$10$wjyCI9fnRxKM3GDgqiwrfOg9qBEauxWNTQDtgYDE2laWJfGEsTD6e", "Activo", 1, 1, 1);

		try {
			Usuarios userResultado = usuarioDAO.buscarDatosSesion("victor24");
			assertEquals(userEsperado, userResultado, "El inicio de sesión debería ser exitoso");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testUserNoRegister() {

		try {
			Usuarios userResultado = usuarioDAO.buscarDatosSesion("victor");
			assertNull(userResultado, "Usuario no registrado");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
