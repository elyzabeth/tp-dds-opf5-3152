package dds.tp.g14.interfaces;

import dds.tp.g14.entities.JerarquiaParticipacion;
import dds.tp.g14.entities.Jugador;

public interface Participacion {

	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador);
	
	public boolean mantenerseEnPartido();
	
	public JerarquiaParticipacion prioridad();

}
