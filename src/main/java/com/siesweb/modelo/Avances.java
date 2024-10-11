package com.siesweb.modelo;

public class Avances {
	private int id;
	private String fecha;
	private String tramo_amp;
	private String tramo_mej;
	private String tramo_sub;
	private String tramo_bas;
	private String tramo_asf;
	private String cunetas;
	private String muros;
	private String porcentaje_ejecucion;
	private int proyectoId;
	
	public Avances(int id, String fecha, String tramo_amp, String tramo_mej, String tramo_sub, String tramo_bas,
			String tramo_asf, String cunetas, String muros, String porcentaje_ejecucion, int proyectoId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tramo_amp = tramo_amp;
		this.tramo_mej = tramo_mej;
		this.tramo_sub = tramo_sub;
		this.tramo_bas = tramo_bas;
		this.tramo_asf = tramo_asf;
		this.cunetas = cunetas;
		this.muros = muros;
		this.porcentaje_ejecucion = porcentaje_ejecucion;
		this.proyectoId = proyectoId;
	}

	public int getId() {return id;}
	public String getFecha() {return fecha;}
	public String getTramo_amp() {return tramo_amp;}
	public String getTramo_mej() {return tramo_mej;}
	public String getTramo_sub() {return tramo_sub;}
	public String getTramo_bas() {return tramo_bas;}
	public String getTramo_asf() {return tramo_asf;}
	public String getCunetas() {return cunetas;}
	public String getMuros() {return muros;}
	public String getPorcentaje_ejecucion() {return porcentaje_ejecucion;}
	public int getProyectoId() {return proyectoId;}

	@Override
	public String toString() {
		return "Avances [id=" + id + ", fecha=" + fecha + ", tramo_amp=" + tramo_amp + ", tramo_mej=" + tramo_mej
				+ ", tramo_sub=" + tramo_sub + ", tramo_bas=" + tramo_bas + ", tramo_asf=" + tramo_asf + ", cunetas="
				+ cunetas + ", muros=" + muros + ", porcentaje_ejecucion=" + porcentaje_ejecucion + "]";
	}
}
