package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Participacion;

public class Solidario implements Participacion{

	@Override
	public boolean retirarseDelPartido() {
		return true;
	}

}
