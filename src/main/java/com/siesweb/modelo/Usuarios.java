package com.siesweb.modelo;

public class Usuarios {
	private final int id;
	private final String nombre;
	private final String apellido;
	private final String documento;
	private final String email;
	private final String telefono;
	private final String usuario;
	private final String password;
	private final String estado;
	private final int tipoDocumentoId;
	private final int proyectoId;
	private final int rolId;

	public Usuarios(int id, String nombre, String apellido, String documento, String email, String telefono,
			String usuario, String password, String estado, int tipoDocumentoId, int proyectoId, int rolId) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
		this.usuario = usuario;
		this.password = password;
		this.estado = estado;
		this.tipoDocumentoId = tipoDocumentoId;
		this.proyectoId = proyectoId;
		this.rolId = rolId;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public String getEstado() {
		return estado;
	}

	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public int getProyectoId() {
		return proyectoId;
	}

	public int getRolId() {
		return rolId;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento
				+ ", email=" + email + ", telefono=" + telefono + ", usuario=" + usuario + ", password=" + password
				+ ", estado=" + estado + ", tipoDocumentoId=" + tipoDocumentoId + ", proyectoId=" + proyectoId
				+ ", rolId=" + rolId + "]";
	}
}
