package com.siesweb.modelo;

public class Proyectos {
	private int id;
	private String titulo;
	private String estado;
	private String ubicacion;

	public Proyectos(int id, String titulo, String estado, String ubicacion) {
		this.id = id;
		this.titulo = titulo;
		this.estado = estado;
		this.ubicacion = ubicacion;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEstado() {
		return estado;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	@Override
	public String toString() {
		return "Proyectos [id=" + id + ", titulo=" + titulo + ", estado=" + estado + ", ubicacion=" + ubicacion + "]";
	}
}
