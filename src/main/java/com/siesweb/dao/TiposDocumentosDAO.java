package com.siesweb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.TiposDocumentos;

public class TiposDocumentosDAO {

	public TiposDocumentos obtenerIdTipo(String tipo) throws SQLException {
		String sql = "SELECT * FROM TipoDocumento WHERE descripcion_tipo = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tipo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new TiposDocumentos(rs.getInt("id"), rs.getString("descripcion_tipo"));
			}
		}
		return null;
	}

	public void insertarTipo(TiposDocumentos tipo) throws SQLException {
		String sql = "INSERT INTO TipoDocumento (descripcion_tipo) VALUES (?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tipo.getDescripcion_tipo());
			pstmt.executeUpdate();
		}
	}

	public void actualizarTipo(TiposDocumentos tipo) throws SQLException {
		String sql = "UPDATE TipoDocumento SET descripcion_tipo = ? WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tipo.getDescripcion_tipo());
			pstmt.setInt(2, tipo.getId());
			pstmt.executeUpdate();
		}
	}

	public List<TiposDocumentos> buscarTipo(int id) throws SQLException {
		List<TiposDocumentos> tipos = new ArrayList<>();
		String sql = "SELECT * FROM TipoDocumento WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				TiposDocumentos tipo = new TiposDocumentos(rs.getInt("id"), rs.getString("descripcion_tipo"));
				tipos.add(tipo);
			}
		}
		return tipos;
	}

	public void eliminarTipo(int id) throws SQLException {
		String sql = "DELETE FROM TipoDocumento WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	public List<TiposDocumentos> obtenerTipos() throws SQLException {
		List<TiposDocumentos> tipos = new ArrayList<>();
		String sql = "SELECT * FROM TipoDocumento";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				TiposDocumentos tipo = new TiposDocumentos(rs.getInt("id"), rs.getString("descripcion_tipo"));
				tipos.add(tipo);
			}
		}
		return tipos;
	}

}
