package dds.g14.tp.entities.participacion;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.Partido;

public abstract class Condicional implements Participacion{
	
	private JerarquiaParticipacion jerarquia = JerarquiaParticipacion.CONDICIONAL;
	
	@Override
	public JerarquiaParticipacion prioridad() {
		return jerarquia;
	}
	
	public boolean evaluarCondicion(Partido partido){
		return true;
	}
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return this.prioridad().getValue() == jugador.participacion.prioridad().getValue();
	}
	
	@Override
	public boolean puedeEstarEnPartido(Partido partido) {
		return evaluarCondicion(partido);
	}
}
