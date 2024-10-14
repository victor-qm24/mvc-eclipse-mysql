package com.siesweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.Proyectos;

public class ProyectosDAO {
	public Proyectos obtenerIdProyecto(String proyecto) throws SQLException {
		String sql = "SELECT * FROM Proyectos WHERE titulo = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, proyecto);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Proyectos(rs.getInt("id"), rs.getString("titulo"), rs.getString("estado"),
						rs.getString("ubicacion"));
			}
		}
		return null;
	}
	
	public List<Proyectos> obtenerProyectos() throws SQLException {
		List<Proyectos> proyectos = new ArrayList<>();
		String sql = "SELECT * FROM Proyectos";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Proyectos proyecto = new Proyectos(rs.getInt("id"), rs.getString("titulo"), rs.getString("estado"), rs.getString("ubicacion"));
				proyectos.add(proyecto);
			}
		}
		return proyectos;
	}
		
}
