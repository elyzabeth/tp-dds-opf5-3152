package dds.g14.tp.observers;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.Partido;

public class NuevoJugadorEnPartido extends Observer{

	public NuevoJugadorEnPartido(Partido partido) {
		super(partido);
	}

	@Override
	public void realizarObservacion() {
		System.out.println("Se enviaran mails a las siguientes direcciones");
		for (Jugador jugador : partido.integrantes) {
			System.out.println("	direccion: " + jugador.getDireccionMail());
		}
		System.out.println("Fin de envio de mails a jugadores");
	}

}
