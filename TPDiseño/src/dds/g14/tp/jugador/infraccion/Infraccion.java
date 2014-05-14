package dds.g14.tp.jugador.infraccion;

import java.util.Date;

import dds.g14.tp.exceptions.TiempoIndeterminadoInfraccionException;

public abstract class Infraccion {

	private Date fechaFinalizacion;
	
	public Infraccion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	public abstract void finalizo() throws TiempoIndeterminadoInfraccionException;
}
