package dds.g14.tp.observers;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.MailSender;
import dds.g14.tp.entities.Partido;

public class NuevoJugadorEnPartido extends Observer{

	public NuevoJugadorEnPartido(Partido partido, MailSender mailSender) {
		super(partido,mailSender);
	}

	@Override
	public void realizarObservacion() {
		for (Jugador amigo : partido.ultimoAgregado.amigos) {
			mailSender.sendMail(partido.ultimoAgregado.getDireccionMail(),"Se sumo un nuevo jugador", amigo.getDireccionMail());
		}
	}

}
