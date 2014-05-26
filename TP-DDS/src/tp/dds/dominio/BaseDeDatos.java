package tp.dds.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import tp.dds.interfaces.CheckCandidato;

public class BaseDeDatos {

	private List<Jugador> jugadoresPendientes;
	private List<Jugador> jugadoresAprobados;
	private List<Denegacion> denegaciones;
	private CheckCandidato evaluador;

	public BaseDeDatos(){
		this(null);
	}

	public BaseDeDatos(CheckCandidato checker){
		inicializar();
		this.evaluador = checker;
	}

	private void inicializar(){
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

	public void evaluarJugadoresPendientes() { 

		for (Jugador candidato : this.jugadoresPendientes) {
			if(evaluador.cumpleCondicion(candidato)){
				this.jugadoresAprobados.add(candidato);
			} else {
				this.denegaciones.add(new Denegacion(LocalDateTime.now(), "No cumple condicion", candidato));
			}
		}
		this.jugadoresPendientes.clear();
	}

	public void evaluarJugadoresPendientes2(CheckCandidato evaluador) {

		for (Jugador candidato : this.jugadoresPendientes) {
			if(evaluador.cumpleCondicion(candidato)){
				this.jugadoresAprobados.add(candidato);
			} else {
				this.denegaciones.add(new Denegacion(LocalDateTime.now(), "No cumple condicion", candidato));
			}
		}
		this.jugadoresPendientes.clear();
	}

}
