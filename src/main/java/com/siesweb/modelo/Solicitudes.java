package com.siesweb.modelo;

public class Solicitudes {
	private final int id;
	private final String fecha;
	private final String observacion;
	private final String estado;
	private final int proyectoId;
	private final int temaId;
	private final int usuarioId;

	public Solicitudes(int id, String fecha, String observacion, String estado, int proyectoId, int temaId,
			int usuarioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.observacion = observacion;
		this.estado = estado;
		this.proyectoId = proyectoId;
		this.temaId = temaId;
		this.usuarioId = usuarioId;
	}

	public int getId() {
		return id;
	}

	public String getFecha() {
		return fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public String getEstado() {
		return estado;
	}

	public int getProyectoId() {
		return proyectoId;
	}

	public int getTemaId() {
		return temaId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	@Override
	public String toString() {
		return "Solicitudes [id=" + id + ", fecha" + fecha + ", observacion=" + observacion + ", estado=" + estado
				+ ", proyectoId=" + proyectoId + ", temaId=" + temaId + ", usuarioId=" + usuarioId + "]";
	}
}
