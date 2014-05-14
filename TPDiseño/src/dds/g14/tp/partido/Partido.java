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
	
	public List<Jugador> integrantes;
	
	public Partido(Date fecha,Jugador...jugadores){
		this.fechaInicio = fecha;
		this.integrantes = new ArrayList<Jugador>();
		for (Jugador jugador : jugadores) {
			this.agregarJugador(jugador);
		}
	}
	
	public void agregarJugador(Jugador interesado){
		try {
			interesado.puedeJugarEn(this);
			puedoAgregar(interesado);
			integrantes.add(interesado);
			comprobarCondicionesDeParticipantes();
			verificarCantidadDeJugadoresInscriptos();
			notificarRestoParticipantes();
		} catch (Exception e) {
			System.out.println("Ocurrio un error agregando un jugador: " + e);
		}
		
	}
	
	public void retirarJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		contieneJugador(jugador);
		integrantes.remove(jugador);
		verificarCantidadDeJugadoresInscriptos();
	}
	
	public void contieneJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		if( !integrantes.contains(jugador) )
			throw new JugadorNoEsParticipanteException();
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
		/* si hay espacio, listo
		 * si no hay espacio, sacar a alguien, listo
		 * */
		if( !(integrantes.size() < CANT_MAX_JUGADORES)){
			liberarEspacioEnIntegrantesPara(jugador);
		}
	}
	
	private void liberarEspacioEnIntegrantesPara(Jugador interesado) throws ImposibleAgregarJugadorAPartidoException{
		Jugador jugadorASacar = null;
		for (Jugador jugador : integrantes) {
			if(jugador.retirarseAnteIngresoNuevoJugador(interesado)){
				jugadorASacar = jugador;
				break;
			}
		}
		if(jugadorASacar == null){
			throw new ImposibleAgregarJugadorAPartidoException();
		}else{
			integrantes.remove(jugadorASacar);
		}
	}
	
	private void verificarCantidadDeJugadoresInscriptos(){
		System.out.println("Cantidad de jugadores ahora es: " + integrantes.size());
	}
	
	public void notificarRestoParticipantes(){
		System.out.println("Se ha enviado un mail a los (" + integrantes.size() + ") integrantes ");
	}
}
