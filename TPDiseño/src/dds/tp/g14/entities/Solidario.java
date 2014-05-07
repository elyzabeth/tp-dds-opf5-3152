package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Participacion;

public class Solidario implements Participacion{

	private JerarquiaParticipacion SOLIDARIO;
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return jugador.participacion.prioridad().getValue() <= this.prioridad().getValue() ;
	}

	@Override
	public boolean mantenerseEnPartido() {
		return true;
	}

	@Override
	public JerarquiaParticipacion prioridad() {
		return SOLIDARIO;
	}

}
