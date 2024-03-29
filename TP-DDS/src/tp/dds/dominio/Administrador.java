package tp.dds.dominio;

import java.util.Date;

import tp.dds.interfaces.Persona;

public class Administrador implements Persona {

	private String nombre;
	private String mail;

	public Administrador(String nombre, String mail) {
		this.nombre = nombre;
		this.mail = mail;
	}

	public String nombre() {
		return this.nombre;
	}

	public String mail() {
		return this.mail;
	}
	
	public void evaluarJugadoresPendientes(BaseDeDatos baseDeDatos) { 
		
		while(baseDeDatos.jugadoresPendientes().size() > 0) {
			
			Jugador jugador = baseDeDatos.jugadoresPendientes().remove(0);		
			if (this.esAprobable(jugador)) {
				
				baseDeDatos.jugadoresAprobados().add(jugador);
				System.out.println(jugador.nombre()+ " fue aceptado.");
				
			} else {
				
				String motivo = "No me cae bien";
				Denegacion denegacion = new Denegacion(new Date(), motivo, jugador);
				baseDeDatos.denegaciones().add(denegacion);
				System.out.println(jugador.nombre()+ " fue rechazado.");
			} 
		}
	}

	public boolean esAprobable(Jugador jugador) {
		if (jugador.nombre().length() > 6) return true;
		else return false;
	}
}