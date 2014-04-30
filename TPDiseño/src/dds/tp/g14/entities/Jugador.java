package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Confiabilidad;
import dds.tp.g14.interfaces.Participacion;

public class Jugador {
	
	public int edad;
	
	public Confiabilidad confiabilidad;
	
	public Participacion participacion;
	
	public Jugador(int edad, Confiabilidad conf, Participacion p){
		this.confiabilidad = conf;
		this.edad = edad;
		this.participacion = p;
	}
	
	public boolean retirarseAnteIngresoNuevoJugador(){
		return participacion.retirarseAnteIngresoNuevoJugador();
	}
	
	public boolean mantenerseEnPartido(){
		return participacion.mantenerseEnPartido();
	}
	
	public void changeConfiabilidad(Confiabilidad conf){
		this.confiabilidad = conf;
	}
}
