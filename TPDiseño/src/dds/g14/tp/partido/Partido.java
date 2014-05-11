package dds.g14.tp.partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dds.g14.tp.exceptions.ImposibleAgregarJugadorAPartidoException;
import dds.g14.tp.exceptions.JugadorNoEsParticipanteException;
import dds.g14.tp.jugador.Jugador;

public class Partido {
	
	static private int CANT_MAX_JUGADORES = 10;
	
	public Date fechaInicio;
	
	public List<Jugador> integrantes = new ArrayList<Jugador>();
	
	public Partido(Date fecha,Jugador...jugadores){
		this.fechaInicio = fecha;
		for (Jugador jugador : jugadores) {
			this.agregarJugador(jugador);
		}
	}
	
	public void agregarJugador(Jugador jugador){
		esPosibleIngreso(jugador);
		integrantes.add(jugador);
		comprobarCondicionesDeParticipantes();
	}
	
	public void contieneJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		if( !integrantes.contains(jugador) )
			throw new JugadorNoEsParticipanteException();
	}
	
	private void esPosibleIngreso(Jugador interesado){
		try {
			puedoAgregar(interesado);
			interesado.puedeJugarEn(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void comprobarCondicionesDeParticipantes() {
		List<Jugador> jugadoresAEliminar = new ArrayList<Jugador>();
		for (Jugador jugador : integrantes) {
			try {
				jugador.puedeJugarEn(this);
			} catch (Exception e) {
				jugadoresAEliminar.add(jugador);
			}
		}
		for (Jugador jugador : jugadoresAEliminar) {
			integrantes.remove(jugador);
		}
	}
	
	private void puedoAgregar(Jugador jugador) throws ImposibleAgregarJugadorAPartidoException{
		if( !(integrantes.size() < CANT_MAX_JUGADORES) ){
			throw new ImposibleAgregarJugadorAPartidoException();
		}else{
			hacerLugarParaNuevoJugador(jugador);
		}
	}
	
	private void hacerLugarParaNuevoJugador(Jugador interesado) throws ImposibleAgregarJugadorAPartidoException{
		for (Jugador jugador : integrantes) {
			if(jugador.retirarseAnteIngresoNuevoJugador(interesado)){
				integrantes.remove(jugador);
				break;
			}
		}
		if( !(integrantes.size() < CANT_MAX_JUGADORES) ){
			throw new ImposibleAgregarJugadorAPartidoException();
		}
	}
}
