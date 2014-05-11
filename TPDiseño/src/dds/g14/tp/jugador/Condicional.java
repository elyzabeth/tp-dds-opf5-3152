package dds.g14.tp.jugador;

import dds.g14.tp.partido.Partido;

public abstract class Condicional implements Participacion{
	
	private JerarquiaParticipacion CONDICIONAL;
	
	@Override
	public JerarquiaParticipacion prioridad() {
		return CONDICIONAL;
	}
	
	public boolean evaluarCondicion(Partido partido){
		return true;
	}
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return jugador.participacion.prioridad().getValue() > this.prioridad().getValue();
	}
	
	@Override
	public boolean puedeEstarEnPartido(Partido partido) {
		return evaluarCondicion(partido);
	}
}
