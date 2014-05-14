package dds.g14.tp.entities.infraccion;

import java.util.Date;

import dds.g14.tp.exceptions.TiempoIndeterminadoInfraccionException;

public class JugadorNoPresentoReemplazo extends Infraccion{

	public JugadorNoPresentoReemplazo(Date fechaFinalizacion) {
		super(fechaFinalizacion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void finalizo() throws TiempoIndeterminadoInfraccionException {
		throw new TiempoIndeterminadoInfraccionException();
	}

}
