package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Participacion;

public abstract class Condicional implements Participacion{
	
	private JerarquiaParticipacion CONDICIONAL;
	
	public Partido partido;
	
	public Condicional(Partido p){
		this.partido = p;
	}
	
	@Override
	public JerarquiaParticipacion prioridad() {
		return CONDICIONAL;
	}
	
	public boolean evaluarCondicion(){
		return true;
	}
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return jugador.participacion.prioridad().getValue() > this.prioridad().getValue();
	}

	@Override
	public boolean mantenerseEnPartido() {
		return evaluarCondicion();
	}
}
