package dds.g14.tp.jugador;

import java.util.ArrayList;
import java.util.List;

import dds.g14.tp.exceptions.ImposibleJugarEnPartidoException;
import dds.g14.tp.jugador.infraccion.Infraccion;
import dds.g14.tp.jugador.participacion.Participacion;
import dds.g14.tp.partido.Partido;


public class Jugador {
	
	public int edad;
	
	private boolean confiabilidad;
	
	public Participacion participacion;
	
	private List<Infraccion> infracciones;
	
	public Jugador(int edad, boolean confiable, Participacion p){
		this.confiabilidad = confiable;
		this.edad = edad;
		this.participacion = p;
		infracciones = new ArrayList<Infraccion>();
	}
	
	public boolean retirarseAnteIngresoNuevoJugador(Jugador jugador){
		return participacion.retirarseAnteIngresoNuevoJugador(jugador);
	}
	
	public void puedeJugarEn(Partido partido) throws ImposibleJugarEnPartidoException{
		if(! participacion.puedeEstarEnPartido(partido) ){
			throw new ImposibleJugarEnPartidoException();
		}
	}
	
	public void imponerInfraccion(Infraccion infraccion){
		infracciones.add(infraccion);
	}
}
