package tp.dds.dominio;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

	private List<Jugador> jugadoresAprobados;
	private List<Denegacion> denegaciones;
	private List<Jugador> jugadoresPendientes;

	public BaseDeDatos(){
		inicializar();
	}
	public void inicializar(){
		this.jugadoresAprobados = new ArrayList<Jugador>();
		this.denegaciones = new ArrayList<Denegacion>();
		this.jugadoresPendientes = new ArrayList<Jugador>();
	}

	public List<Jugador> jugadoresAprobados() {
		return this.jugadoresAprobados;
	}

	public List<Denegacion> denegaciones() {
		return this.denegaciones;
	}

	public List<Jugador> jugadoresPendientes() {
		return this.jugadoresPendientes;
	}

	public boolean proponerJugador(Jugador jugador) {
		
		return this.jugadoresPendientes.add(jugador);
	}

}
