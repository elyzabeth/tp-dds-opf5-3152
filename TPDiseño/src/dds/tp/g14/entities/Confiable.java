package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Confiabilidad;

public class Confiable implements Confiabilidad	{

	@Override
	public boolean esConfiable() {
		return true;
	}

}
