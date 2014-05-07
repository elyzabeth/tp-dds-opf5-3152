package dds.tp.g14.entities;

import java.util.Date;

public class HorarioMaximoPartido extends Condicional{

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
