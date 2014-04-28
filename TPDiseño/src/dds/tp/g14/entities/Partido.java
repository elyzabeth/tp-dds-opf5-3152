package dds.tp.g14.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido {
	static private int CANT_MAX_JUGADORES = 10;
	
	List<Jugador> integrantes = new ArrayList<Jugador>();
	
	public Partido(Date fecha,Jugador...jugadores){
		for (Jugador jugador : jugadores) {
			this.addJugador(jugador);
		}
	}
	
	public void addJugador(Jugador jugador){
		if(isAdditionPosible())
			integrantes.add(jugador);
	}
	
	public boolean getJugador(Jugador jugador){
		return integrantes.contains(jugador);
	}
	
	public boolean isAdditionPosible(){
		if(integrantes.size() < CANT_MAX_JUGADORES){
			return true;
		}else{
			return isAnyPlaceAvaiable();
		}
	}
	
	private boolean isAnyPlaceAvaiable(){
		for (Jugador jugador : integrantes) {
			if(jugador.retirarseDelPartido()){
				integrantes.remove(jugador);
				return true;
			}
		}
		return false;
	}
}
