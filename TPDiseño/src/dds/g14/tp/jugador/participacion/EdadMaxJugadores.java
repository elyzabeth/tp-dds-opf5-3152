package dds.g14.tp.jugador.participacion;

import dds.g14.tp.jugador.Jugador;
import dds.g14.tp.partido.Partido;


public class EdadMaxJugadores extends Condicional{

	private int EDAD_MAXIMA;
	
	public EdadMaxJugadores(int e) {
		super();
		this.EDAD_MAXIMA = e;
	}

	@Override
	public boolean evaluarCondicion(Partido partido) {
		for (Jugador jugador: partido.integrantes) {
			if(jugador.edad > EDAD_MAXIMA){
				return false;
			}
		}
		return true;
	}
}
