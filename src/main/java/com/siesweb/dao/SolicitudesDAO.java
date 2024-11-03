package com.siesweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.Solicitudes;

public class SolicitudesDAO {
	public List<Solicitudes> buscarSolicitud(int id) throws SQLException {
		List<Solicitudes> solicitudes = new ArrayList<>();
		String sql = "SELECT * FROM Solicitudes WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Solicitudes solicitud = new Solicitudes(rs.getInt("id"), rs.getString("fecha"),
						rs.getString("observacion"), rs.getString("estado"), rs.getInt("proyecto_id_solicitud"),
						rs.getInt("tema_id_solicitud"), rs.getInt("usuario_id_solicitud"));
				solicitudes.add(solicitud);
			}
		}
		return solicitudes;
	}

	public void eliminarSolicitud(int id) throws SQLException {
		String sql = "DELETE FROM Solicitudes WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	public List<Solicitudes> obtenerSolicitudes() throws SQLException {
		List<Solicitudes> solicitudes = new ArrayList<>();
		String sql = "SELECT * FROM Solicitudes";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Solicitudes solicitud = new Solicitudes(rs.getInt("id"), rs.getString("fecha"),
						rs.getString("observacion"), rs.getString("estado"), rs.getInt("proyecto_id_solicitud"),
						rs.getInt("tema_id_solicitud"), rs.getInt("usuario_id_solicitud"));
				solicitudes.add(solicitud);
			}
		}
		return solicitudes;
	}

	public void actualizarSolicitud(Solicitudes solicitud) throws SQLException {
		String sql = "UPDATE Solicitudes SET estado = ? WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, solicitud.getEstado());
			pstmt.setInt(2, solicitud.getId());
			pstmt.executeUpdate();
		}
	}

	public void agregarSolicitud(Solicitudes solicitud) throws SQLException {
		String sql = "INSERT INTO Solicitudes (fecha, observacion, estado,"
				+ "proyecto_id_solicitud, tema_id_solicitud, usuario_id_solicitud) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, solicitud.getFecha());
			pstmt.setString(2, solicitud.getObservacion());
			pstmt.setString(3, solicitud.getEstado());
			pstmt.setInt(4, solicitud.getProyectoId());
			pstmt.setInt(5, solicitud.getTemaId());
			pstmt.setInt(6, solicitud.getUsuarioId());
			pstmt.executeUpdate();
		}
	}
}
