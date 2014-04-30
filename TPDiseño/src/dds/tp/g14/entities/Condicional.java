package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Condicion;
import dds.tp.g14.interfaces.Participacion;

public class Condicional implements Participacion{

	public Condicion condicion;
	
	public Condicional(Condicion c){
		this.condicion = c;
	}
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador() {
		return true;
	}

	@Override
	public boolean mantenerseEnPartido() {
		return condicion.evaluarCondicion();
	}

}
