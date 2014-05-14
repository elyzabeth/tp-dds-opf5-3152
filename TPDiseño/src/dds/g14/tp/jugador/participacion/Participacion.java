package dds.g14.tp.jugador.participacion;

import dds.g14.tp.jugador.Jugador;
import dds.g14.tp.partido.Partido;


public interface Participacion {

	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador);
		
	public JerarquiaParticipacion prioridad();
	
	public boolean puedeEstarEnPartido(Partido partido);
}
