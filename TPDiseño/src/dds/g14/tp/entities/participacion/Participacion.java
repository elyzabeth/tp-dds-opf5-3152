package dds.g14.tp.entities.participacion;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.Partido;


public interface Participacion {

	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador);
		
	public JerarquiaParticipacion prioridad();
	
	public boolean puedeEstarEnPartido(Partido partido);
}
