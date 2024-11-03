package com.siesweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.Avances;

public class AvancesDAO {
	public void insertarAvc(Avances avance) throws SQLException {
		String sql = "INSERT INTO Avances (fecha, tramo_amp, tramp_mej, tramo_sub, "
				+ "tramo_bas, tramo_asf, cunetas, muros, porcentaje_ejecucion, proyecto_id_avance) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, avance.getFecha());
			pstmt.setString(2, avance.getTramo_amp());
			pstmt.setString(3, avance.getTramo_mej());
			pstmt.setString(4, avance.getTramo_sub());
			pstmt.setString(5, avance.getTramo_bas());
			pstmt.setString(6, avance.getTramo_asf());
			pstmt.setString(7, avance.getCunetas());
			pstmt.setString(8, avance.getMuros());
			pstmt.setString(9, avance.getPorcentaje_ejecucion());
			pstmt.setInt(10, avance.getProyectoId());
			pstmt.executeUpdate();
		}
	}

	public void actualizarAvc(Avances avance) throws SQLException {
		String sql = "UPDATE Avances SET fecha = ?, tramo_amp = ?, tramp_mej = ?, "
				+ "tramo_sub = ?, tramo_bas = ?, tramo_asf = ?, cunetas = ?, " + "muros = ?, porcentaje_ejecucion = ?,"
				+ "proyecto_id_avance = ? WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, avance.getFecha());
			pstmt.setString(2, avance.getTramo_amp());
			pstmt.setString(3, avance.getTramo_mej());
			pstmt.setString(4, avance.getTramo_sub());
			pstmt.setString(5, avance.getTramo_bas());
			pstmt.setString(6, avance.getTramo_asf());
			pstmt.setString(7, avance.getCunetas());
			pstmt.setString(8, avance.getMuros());
			pstmt.setString(9, avance.getPorcentaje_ejecucion());
			pstmt.setInt(10, avance.getProyectoId());
			pstmt.setInt(11, avance.getId());
			pstmt.executeUpdate();
		}
	}

	public List<Avances> buscarAvc(int id) throws SQLException {
		List<Avances> avances = new ArrayList<>();
		String sql = "SELECT * FROM Avances WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Avances avance = new Avances(rs.getInt("id"), rs.getString("fecha"), rs.getString("tramo_amp"),
						rs.getString("tramp_mej"), rs.getString("tramo_sub"), rs.getString("tramo_bas"),
						rs.getString("tramo_asf"), rs.getString("cunetas"), rs.getString("muros"),
						rs.getString("porcentaje_ejecucion"), rs.getInt("proyecto_id_avance"));
				avances.add(avance);
			}
			System.out.println(avances);
		}
		return avances;
	}

	public void eliminarAvc(int id) throws SQLException {
		String sql = "DELETE FROM Avances WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	public List<Avances> obtenerAvc() throws SQLException {
		List<Avances> avances = new ArrayList<>();
		String sql = "SELECT * FROM Avances";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Avances avance = new Avances(rs.getInt("id"), rs.getString("fecha"), rs.getString("tramo_amp"),
						rs.getString("tramp_mej"), rs.getString("tramo_sub"), rs.getString("tramo_bas"),
						rs.getString("tramo_asf"), rs.getString("cunetas"), rs.getString("muros"),
						rs.getString("porcentaje_ejecucion"), rs.getInt("proyecto_id_avance"));
				avances.add(avance);
			}
		}
		return avances;
	}

	public Avances obtenerUltimoAvc() throws SQLException {
		String sql = "SELECT * FROM Avances ORDER BY id DESC LIMIT 1;";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Avances avance = new Avances(rs.getInt("id"), rs.getString("fecha"), rs.getString("tramo_amp"),
						rs.getString("tramp_mej"), rs.getString("tramo_sub"), rs.getString("tramo_bas"),
						rs.getString("tramo_asf"), rs.getString("cunetas"), rs.getString("muros"),
						rs.getString("porcentaje_ejecucion"), rs.getInt("proyecto_id_avance"));
				return avance;
			}
		}
		return null;
	}
}
