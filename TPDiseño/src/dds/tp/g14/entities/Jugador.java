package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Participacion;

public class Jugador {
	
	public int edad;
	
	public boolean confiabilidad;
	
	public Participacion participacion;
	
	public Jugador(int edad, boolean conf, Participacion p){
		this.confiabilidad = conf;
		this.edad = edad;
		this.participacion = p;
	}
	
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador){
		return participacion.retirarseAnteIngresoNuevoJugador(jugador);
	}
	
	public boolean mantenerseEnPartido(){
		return participacion.mantenerseEnPartido();
	}
	
	public boolean esConfiable(){
		return confiabilidad;
	}
}
