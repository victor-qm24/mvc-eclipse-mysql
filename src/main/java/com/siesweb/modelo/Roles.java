package com.siesweb.modelo;

public class Roles {
	private final int id;
	private final String descripcion_rol;

	public Roles(int id, String descripcion_rol) {
		this.id = id;
		this.descripcion_rol = descripcion_rol;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion_rol() {
		return descripcion_rol;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", descripcion_rol=" + descripcion_rol + "]";
	}
}
