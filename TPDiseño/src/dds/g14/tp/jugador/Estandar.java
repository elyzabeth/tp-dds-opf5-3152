package dds.g14.tp.jugador;

import dds.g14.tp.partido.Partido;


public class Estandar implements Participacion{
	
	private JerarquiaParticipacion ESTANDAR;
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return this.prioridad().getValue() < jugador.participacion.prioridad().getValue();
	}

	@Override
	public JerarquiaParticipacion prioridad() {
		return ESTANDAR;
	}

	@Override
	public boolean puedeEstarEnPartido(Partido partido) {
		return true;
	}

}
