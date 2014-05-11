package dds.g14.tp.jugador;

import dds.g14.tp.partido.Partido;


public class Solidario implements Participacion{

	private JerarquiaParticipacion SOLIDARIO;
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return jugador.participacion.prioridad().getValue() <= this.prioridad().getValue() ;
	}

	@Override
	public JerarquiaParticipacion prioridad() {
		return SOLIDARIO;
	}

	@Override
	public boolean puedeEstarEnPartido(Partido partido) {
		return true;
	}

}
