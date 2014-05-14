package dds.g14.tp.entities.infraccion;

import java.util.Date;

import dds.g14.tp.exceptions.TiempoIndeterminadoInfraccionException;

public class JugadorNoSePresentoAPartido extends Infraccion {
	
	public JugadorNoSePresentoAPartido(Date fechaFinalizacion) {
		super(fechaFinalizacion);
	}

	@Override
	public void finalizo() throws TiempoIndeterminadoInfraccionException {
		throw new TiempoIndeterminadoInfraccionException();
	}

	

}
