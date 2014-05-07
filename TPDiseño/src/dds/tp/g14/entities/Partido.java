package dds.tp.g14.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido {
	
	static private int CANT_MAX_JUGADORES = 10;
	
	public Date fechaInicio;
	
	List<Jugador> integrantes = new ArrayList<Jugador>();
	
	public Partido(Date fecha,Jugador...jugadores){
		this.fechaInicio = fecha;
		for (Jugador jugador : jugadores) {
			this.agregarJugador(jugador);
		}
	}
	
	public void agregarJugador(Jugador jugador){
		if(esPosibleIngreso(jugador)){
			integrantes.add(jugador);
			comprobarCondicionesJugadores();
		}
			
	}
	
	private void comprobarCondicionesJugadores() {
		List<Jugador> jugadoresAEliminar = new ArrayList<Jugador>();
		for (Jugador jugador : integrantes) {
			if(!jugador.mantenerseEnPartido())
				jugadoresAEliminar.add(jugador);
		}
		for (Jugador jugador : jugadoresAEliminar) {
			integrantes.remove(jugador);
		}
	}

	public boolean contieneJugador(Jugador jugador){
		return integrantes.contains(jugador);
	}
	
	public boolean esPosibleIngreso(Jugador interesado){
		if(integrantes.size() < CANT_MAX_JUGADORES){
			return true;
		}else{
			return hayLugarDisponible(interesado);
		}
	}
	
	private boolean hayLugarDisponible(Jugador interesado){
		for (Jugador jugador : integrantes) {
			if(jugador.retirarseAnteIngresoNuevoJugador(interesado)){
				integrantes.remove(jugador);
				return true;
			}
		}
		return false;
	}
}
