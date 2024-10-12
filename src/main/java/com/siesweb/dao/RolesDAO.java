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
}
