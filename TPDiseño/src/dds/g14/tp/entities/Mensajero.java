package dds.g14.tp.entities;

import dds.g14.tp.exceptions.JugadorNoEsParticipanteException;

public class Mensajero extends Partido{
	
	public MailSender mailSender;
	
	public Mensajero(Partido part, MailSender mailSender){
		super(part.getDireccionMailAdminitrador(), part.getFechaInicio());
		for (Jugador jugador : part.integrantes) {
			super.agregarJugador(jugador);
		}
		this.mailSender = mailSender;
	}
	
	@Override
	public void agregarJugador(Jugador interesado) {
		super.agregarJugador(interesado);
		if(integrantes.size() == CANT_MAX_JUGADORES)
			enviarMailAlAdmin("El partido se completo");
		enviarMailALosAmigos(interesado,"Se agrego un nuevo jugador al partido");
	}

	@Override
	public void retirarJugador(Jugador jugador) throws JugadorNoEsParticipanteException {
		super.retirarJugador(jugador);
		if(integrantes.size() == (CANT_MAX_JUGADORES-1))
			enviarMailAlAdmin("El partido dejo de estar completo");
	}
	
	@Override
	public void contieneJugador(Jugador jugador) throws JugadorNoEsParticipanteException {
		super.contieneJugador(jugador);
	}
	
	@Override
	public String getDireccionMailAdminitrador() {
		return super.getDireccionMailAdminitrador();
	}
	
	@Override
	public void presentarReemplazoAnteBaja(Jugador baja, Jugador reemplazo) {
		super.presentarReemplazoAnteBaja(baja, reemplazo);
	}
	
	private void enviarMailAlAdmin(String mensaje){
		mailSender.sendMail(this.toString(), mensaje, getDireccionMailAdminitrador());
	}
	
	private void enviarMailALosAmigos(Jugador jugador, String mensaje){
		for (Jugador amigo : jugador.amigos) {
			mailSender.sendMail(jugador.getDireccionMail(), mensaje, amigo.getDireccionMail());
		}
	}
}
