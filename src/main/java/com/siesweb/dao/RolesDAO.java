package com.siesweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.Roles;

public class RolesDAO {
	public Roles obtenerIdRol(String rol) throws SQLException {
		String sql = "SELECT * FROM Roles WHERE descripcion_rol = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, rol);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Roles(rs.getInt("id"), rs.getString("descripcion_rol"));
			}
		}
		return null;
	}
	
	public void insertarRol(Roles rol) throws SQLException {
		String sql = "INSERT INTO Roles (descripcion_rol) VALUES (?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, rol.getDescripcion_rol());			
			pstmt.executeUpdate();
		}
	}
	
	public void actualizarRol(Roles rol) throws SQLException {
		String sql = "UPDATE Roles SET descripcion_rol = ? WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, rol.getDescripcion_rol());			
			pstmt.setInt(2, rol.getId());
			pstmt.executeUpdate();
		}
	}
	
	public List<Roles> buscarRol(int id) throws SQLException {
		List<Roles> roles = new ArrayList<>();
		String sql = "SELECT * FROM Roles WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Roles rol = new Roles(rs.getInt("id"), rs.getString("descripcion_rol"));
				roles.add(rol);
			}
		}
		return roles;
	}
	
	public void eliminarRol(int id) throws SQLException {
		String sql = "DELETE FROM Roles WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}
	
	public List<Roles> obtenerRoles() throws SQLException {
		List<Roles> roles = new ArrayList<>();
		String sql = "SELECT * FROM Roles";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Roles rol = new Roles(rs.getInt("id"), rs.getString("descripcion_rol"));
				roles.add(rol);
			}
		}
		return roles;
	}
}
