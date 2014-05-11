package dds.g14.tp.jugador;

import dds.g14.tp.exceptions.ImposibleJugarEnPartidoException;
import dds.g14.tp.partido.Partido;


public class Jugador {
	
	public int edad;
	
	public boolean confiabilidad;
	
	public Participacion participacion;
	
	public Jugador(int edad, boolean confiable, Participacion p){
		this.confiabilidad = confiable;
		this.edad = edad;
		this.participacion = p;
	}
	
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador){
		return participacion.retirarseAnteIngresoNuevoJugador(jugador);
	}
	
	public void puedeJugarEn(Partido partido) throws ImposibleJugarEnPartidoException{
		if(! participacion.puedeEstarEnPartido(partido) ){
			throw new ImposibleJugarEnPartidoException();
		}
	}
}
