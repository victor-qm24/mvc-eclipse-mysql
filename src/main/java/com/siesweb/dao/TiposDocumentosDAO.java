package com.siesweb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.siesweb.modelo.TiposDocumentos;
import com.siesweb.modelo.Usuarios;

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

}
