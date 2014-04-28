package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Confiabilidad;
import dds.tp.g14.interfaces.Participacion;

public class Jugador {
	
	public Confiabilidad confiabilidad;
	
	public Participacion participacion;
	
	public Jugador(Confiabilidad conf){
		this.confiabilidad = conf;
	}
	
	public boolean retirarseDelPartido(){
		return participacion.retirarseDelPartido();
	}
	
	public void changeConfiabilidad(Confiabilidad conf){
		this.confiabilidad = conf;
	}
}
