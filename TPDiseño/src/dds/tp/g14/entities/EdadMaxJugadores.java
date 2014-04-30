package dds.tp.g14.entities;

import dds.tp.g14.interfaces.Condicion;

public class EdadMaxJugadores extends Condicion{

	private int EDAD_MAXIMA;
	
	public EdadMaxJugadores(Partido p, int e) {
		super(p);
		this.EDAD_MAXIMA = e;
	}

	@Override
	public boolean evaluarCondicion() {
		for (Jugador jugador: partido.integrantes) {
			if(jugador.edad > EDAD_MAXIMA){
				return false;
			}
		}
		return true;
	}
}
