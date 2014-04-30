package dds.tp.g14.interfaces;

import dds.tp.g14.entities.Partido;

public abstract class Condicion {
	
	public Partido partido;
	
	public Condicion(Partido p){
		this.partido = p;
	}
	
	public boolean evaluarCondicion(){
		return true;
	}
}
