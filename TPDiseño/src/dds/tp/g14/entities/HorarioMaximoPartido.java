package dds.tp.g14.entities;

import java.util.Date;

import dds.tp.g14.interfaces.Condicion;

public class HorarioMaximoPartido extends Condicion{

	private Date horarioMaximo;
	
	public HorarioMaximoPartido(Partido p, Date horaMax) {
		super(p);
		this.horarioMaximo = horaMax;
	}

	@Override
	public boolean evaluarCondicion() {
		return horarioMaximo.compareTo(partido.fechaInicio) <= 0;
	}
}
