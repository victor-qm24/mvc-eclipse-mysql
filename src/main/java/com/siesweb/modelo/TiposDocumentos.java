package com.siesweb.modelo;

public class TiposDocumentos {
	private final int id;
	private final String descripcion_tipo;

	public TiposDocumentos(int id, String descripcion_tipo) {
		this.id = id;
		this.descripcion_tipo = descripcion_tipo;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion_tipo() {
		return descripcion_tipo;
	}

	@Override
	public String toString() {
		return "TiposDocumentos [id=" + id + ", descripcion_tipo=" + descripcion_tipo + "]";
	}
}
