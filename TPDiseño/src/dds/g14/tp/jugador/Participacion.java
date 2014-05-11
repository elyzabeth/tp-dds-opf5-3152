package dds.g14.tp.jugador;

import dds.g14.tp.partido.Partido;


public interface Participacion {

	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador);
		
	public JerarquiaParticipacion prioridad();
	
	public boolean puedeEstarEnPartido(Partido partido);
}
