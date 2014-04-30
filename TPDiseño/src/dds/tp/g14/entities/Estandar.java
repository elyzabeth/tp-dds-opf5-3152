package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Participacion;

public class Estandar implements Participacion{

	@Override
	public boolean retirarseAnteIngresoNuevoJugador() {
		return false;
	}

	@Override
	public boolean mantenerseEnPartido() {
		return true;
	}

}
