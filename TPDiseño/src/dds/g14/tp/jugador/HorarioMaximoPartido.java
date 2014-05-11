package dds.g14.tp.jugador;

import java.util.Date;

import dds.g14.tp.partido.Partido;

public class HorarioMaximoPartido extends Condicional{

	private Date horarioMaximo;
	
	public HorarioMaximoPartido(Date horaMax) {
		super();
		this.horarioMaximo = horaMax;
	}

	@Override
	public boolean evaluarCondicion(Partido partido) {
		return horarioMaximo.compareTo(partido.fechaInicio) <= 0;
	}
}
