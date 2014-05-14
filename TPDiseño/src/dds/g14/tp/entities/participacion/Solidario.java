package dds.g14.tp.entities.participacion;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.Partido;


public class Solidario implements Participacion{

	private JerarquiaParticipacion jerarquia = JerarquiaParticipacion.SOLIDARIO;
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return this.prioridad().getValue() <= jugador.participacion.prioridad().getValue();
	}

	@Override
	public JerarquiaParticipacion prioridad() {
		return jerarquia;
	}

	@Override
	public boolean puedeEstarEnPartido(Partido partido) {
		return true;
	}

}
