package com.siesweb.modelo;

public class Temas {
	private final int id;
	private final String descripcion_tema;
	
	public Temas(int id, String descripcion_tema) {
		super();
		this.id = id;
		this.descripcion_tema = descripcion_tema;
	}

	public int getId() {return id;}
	public String getDescripcion_tema() {return descripcion_tema;}

	@Override
	public String toString() {
		return "Temas [id=" + id + ", descripcion_tema=" + descripcion_tema + "]";
	}
}
