package com.siesweb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.*;

public class UsuariosDAO {

	public Usuarios buscarDatosSesion(String user) throws SQLException {
		String sql = "SELECT * FROM Usuarios WHERE usuario = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user);			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Usuarios(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("documento"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("usuario"), rs.getString("contraseña"), rs.getString("estado"), rs.getInt("tipo_documento_id_usuario"),
						rs.getInt("proyecto_id_usuario"), rs.getInt("rol_id_usuario"));
			}
		}
		return null;
	}

	public void agregarUsuario(Usuarios usuario) throws SQLException {
		String sql = "INSERT INTO Usuarios (nombre, apellido, documento, email, "
				+ "telefono, usuario, contraseña, estado, tipo_documento_id_usuario, "
				+ "proyecto_id_usuario, rol_id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usuario.getNombre());
			pstmt.setString(2, usuario.getApellido());
			pstmt.setString(3, usuario.getDocumento());
			pstmt.setString(4, usuario.getEmail());
			pstmt.setString(5, usuario.getTelefono());
			pstmt.setString(6, usuario.getUsuario());
			pstmt.setString(7, usuario.getPassword());
			pstmt.setString(8, usuario.getEstado());
			pstmt.setInt(9, usuario.getTipoDocumentoId());
			pstmt.setInt(10, usuario.getProyectoId());
			pstmt.setInt(11, usuario.getRolId());
			pstmt.executeUpdate();
		}
	}

	public void actualizarUsuario(Usuarios usuario) throws SQLException {
		String sql = "UPDATE Usuarios SET nombre = ?, apellido = ?, documento = ?, "
				+ "email = ?, telefono = ?, usuario = ?, contraseña = ?, estado = ?, "
				+ "tipo_documento_id_usuario = ?, proyecto_id_usuario = ?," + "rol_id_usuario = ? WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usuario.getNombre());
			pstmt.setString(2, usuario.getApellido());
			pstmt.setString(3, usuario.getDocumento());
			pstmt.setString(4, usuario.getEmail());
			pstmt.setString(5, usuario.getTelefono());
			pstmt.setString(6, usuario.getUsuario());
			pstmt.setString(7, usuario.getPassword());
			pstmt.setString(8, usuario.getEstado());
			pstmt.setInt(9, usuario.getTipoDocumentoId());
			pstmt.setInt(10, usuario.getProyectoId());
			pstmt.setInt(11, usuario.getRolId());
			pstmt.setInt(12, usuario.getId());
			pstmt.executeUpdate();
		}
	}

	public void eliminarUsuario(int id) throws SQLException {
		String sql = "DELETE FROM Usuarios WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
	}

	public List<Usuarios> obtenerUsuarios() throws SQLException {
		List<Usuarios> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM Usuarios";
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Usuarios usuario = new Usuarios(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("documento"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("usuario"), rs.getString("contraseña"), rs.getString("estado"), rs.getInt("tipo_documento_id_usuario"),
						rs.getInt("proyecto_id_usuario"), rs.getInt("rol_id_usuario"));
				usuarios.add(usuario);
			}
		}
		return usuarios;
	}

	public List<Usuarios> buscarUsuario(int id) throws SQLException {
		List<Usuarios> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM Usuarios WHERE id = ?";
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Usuarios usuario = new Usuarios(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("documento"), rs.getString("email"), rs.getString("telefono"),
						rs.getString("usuario"), rs.getString("contraseña"), rs.getString("estado"), rs.getInt("tipo_documento_id_usuario"),
						rs.getInt("proyecto_id_usuario"), rs.getInt("rol_id_usuario"));
				usuarios.add(usuario);
			}
		}
		return usuarios;
	}
}
