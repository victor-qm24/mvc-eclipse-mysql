package com.siesweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.Temas;

public class TemasDAO {
	public Temas obtenerIdTema(String tema) throws SQLException {
		String sql = "SELECT * FROM Temas WHERE descripcion_tema = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tema);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Temas(rs.getInt("id"), rs.getString("descripcion_tema"));
			}
		}
		return null;
	}

	public void insertarTema(Temas tema) throws SQLException {
		String sql = "INSERT INTO Temas (descripcion_tema) VALUES (?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tema.getDescripcion_tema());
			pstmt.executeUpdate();
		}
	}

	public void actualizarTema(Temas tema) throws SQLException {
		String sql = "UPDATE Temas SET descripcion_tema = ? WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tema.getDescripcion_tema());
			pstmt.setInt(2, tema.getId());
			pstmt.executeUpdate();
		}
	}

	public List<Temas> buscarTema(int id) throws SQLException {
		List<Temas> temas = new ArrayList<>();
		String sql = "SELECT * FROM Temas WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Temas tema = new Temas(rs.getInt("id"), rs.getString("descripcion_tema"));
				temas.add(tema);
			}
		}
		return temas;
	}

	public void eliminarTema(int id) throws SQLException {
		String sql = "DELETE FROM Temas WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	public List<Temas> obtenerTemas() throws SQLException {
		List<Temas> temas = new ArrayList<>();
		String sql = "SELECT * FROM Temas";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Temas tema = new Temas(rs.getInt("id"), rs.getString("descripcion_tema"));
				temas.add(tema);
			}
		}
		return temas;
	}
}
