package com.siesweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static final String URL = "jdbc:mysql://localhost:3306/proyecto_siesweb";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			if (!connection.isClosed()) {
				System.out.println("Conexión exitosa a bd!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se pudo conectar a bd!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se encontro la clase en la lib!!");
		}
		return connection;
	}
}
