package dds.g14.tp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dds.g14.tp.entities.infraccion.JugadorNoPresentoReemplazo;
import dds.g14.tp.exceptions.ImposibleAgregarJugadorAPartidoException;
import dds.g14.tp.exceptions.JugadorNoEsParticipanteException;

public class Partido {
	
	static private int CANT_MAX_JUGADORES = 10;
	
	public Date fechaInicio;
	
	public List<Jugador> integrantes;
	
	private String direccionMailAdminitrador;
	
	private MailSender mailSender;
	
	public Partido(String direccionMailAdmin, Date fecha,Jugador...jugadores){
		this.fechaInicio = fecha;
		this.direccionMailAdminitrador = direccionMailAdmin;
		this.integrantes = new ArrayList<Jugador>();
		this.mailSender = new MailSender();
		for (Jugador jugador : jugadores) {
			this.agregarJugador(jugador);
		}
	}
	
	public void agregarJugador(Jugador interesado){
		try {
			interesado.puedeJugarEn(this);
			puedoAgregar(interesado);
			integrantes.add(interesado);
			enviarMailAIntegrantes();
			if(integrantes.size() == CANT_MAX_JUGADORES)
				enviarMailAdmin("Se completo el partido");
			comprobarCondicionesDeParticipantes();
		} catch (Exception e) {
			System.out.println("Ocurrio un error agregando un jugador: " + e);
		}
		
	}
	
	public void retirarJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		contieneJugador(jugador);
		int cantAnt = integrantes.size();
		integrantes.remove(jugador);
		if(cantAnt == CANT_MAX_JUGADORES && (integrantes.size() == CANT_MAX_JUGADORES-1)){
			enviarMailAdmin("El partido esta incompleto de nuevo");
		}	
	}
	
	public void contieneJugador(Jugador jugador) throws JugadorNoEsParticipanteException{
		if( !integrantes.contains(jugador) )
			throw new JugadorNoEsParticipanteException();
	}
	
	public String getDireccionMailAdminitrador() {
		return direccionMailAdminitrador;
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
	
	private void mandarMail(String mensaje, List<String> destinatarios){
		for (String destinatario : destinatarios) {
			mailSender.sendMail(mensaje, destinatario);
		}
	}
	
	private void enviarMailAIntegrantes(){
		List<String> direcciones = new ArrayList<String>();
		for (Jugador jugador : integrantes) {
			direcciones.add(jugador.getDireccionMail());
		}
		mandarMail("Se agrego un nuevo jugador", direcciones);
	}
	
	private void enviarMailAdmin(String mensaje){
		List<String> direcciones = new ArrayList<String>();
		direcciones.add(getDireccionMailAdminitrador());
		mandarMail(mensaje, direcciones);
	}
}
