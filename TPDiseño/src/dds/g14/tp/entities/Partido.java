package dds.g14.tp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dds.g14.tp.entities.infraccion.JugadorNoPresentoReemplazo;
import dds.g14.tp.exceptions.ExpectedException;
import dds.g14.tp.exceptions.ImposibleAgregarJugadorAPartidoException;
import dds.g14.tp.exceptions.ImposibleJugarEnPartidoException;
import dds.g14.tp.exceptions.JugadorNoEsParticipanteException;

public class Partido {
	
	static public int CANT_MAX_JUGADORES = 10;
	
	public Date fechaInicio;
	
	public List<Jugador> integrantes;
	
	private String direccionMailAdminitrador;
	
	public Partido(String direccionMailAdmin, Date fecha){
		this.fechaInicio = fecha;
		this.direccionMailAdminitrador = direccionMailAdmin;
		this.integrantes = new ArrayList<Jugador>();
	}
	
	public void agregarJugador(Jugador interesado) throws ExpectedException{
		interesado.puedeJugarEn(this);
		puedoAgregar(interesado);
		integrantes.add(interesado);
		comprobarCondicionesDeParticipantes();
	}
	
	public void retirarJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		contieneJugador(jugador);
		integrantes.remove(jugador);	
	}
	
	public void contieneJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		if( !integrantes.contains(jugador) )
			throw new JugadorNoEsParticipanteException();
	}
	
	public String getDireccionMailAdminitrador() {
		return direccionMailAdminitrador;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void presentarReemplazoAnteBaja(Jugador baja, Jugador reemplazo){
		try {
			retirarJugador(baja);
			if(reemplazo != null){
				agregarJugador(reemplazo);
			}else{
				baja.imponerInfraccion(new JugadorNoPresentoReemplazo(new Date()));
			}
		} catch (JugadorNoEsParticipanteException e) {
			System.out.println("Se intento dar de baja un jugador que no es participante");
		}
	}
	
	/*  -----  Metodos privados  -----  */

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
	
	private void puedoAgregar(Jugador jugador) throws ImposibleAgregarJugadorAPartidoException, JugadorNoEsParticipanteException{
		/* si hay espacio, listo
		 * si no hay espacio, sacar a alguien, listo
		 * */
		if( !(integrantes.size() < CANT_MAX_JUGADORES)){
			liberarEspacioEnIntegrantesPara(jugador);
		}
	}
	
	private void liberarEspacioEnIntegrantesPara(Jugador interesado) throws ImposibleAgregarJugadorAPartidoException, JugadorNoEsParticipanteException{
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
			retirarJugador(jugadorASacar);
		}
	}
}
