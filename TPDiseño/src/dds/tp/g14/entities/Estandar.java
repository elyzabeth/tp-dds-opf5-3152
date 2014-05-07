package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Participacion;

public class Estandar implements Participacion{
	
	private JerarquiaParticipacion ESTANDAR;
	
	@Override
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador) {
		return this.prioridad().getValue() < jugador.participacion.prioridad().getValue();
	}

	@Override
	public boolean mantenerseEnPartido() {
		return true;
	}

	@Override
	public JerarquiaParticipacion prioridad() {
		return ESTANDAR;
	}

}
