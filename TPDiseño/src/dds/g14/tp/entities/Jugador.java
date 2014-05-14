package dds.g14.tp.entities;

import java.util.ArrayList;
import java.util.List;

import dds.g14.tp.entities.infraccion.Infraccion;
import dds.g14.tp.entities.participacion.Participacion;
import dds.g14.tp.exceptions.ImposibleJugarEnPartidoException;


public class Jugador {
	
	public int edad;
	private boolean confiabilidad;
	public Participacion participacion;
	private List<Infraccion> infracciones;
	private String direccionMail;
	
	public Jugador(int edad, boolean confiable, Participacion p, String direccionMail){
		this.confiabilidad = confiable;
		this.edad = edad;
		this.participacion = p;
		this.direccionMail = direccionMail;
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

	public String getDireccionMail() {
		return direccionMail;
	}
	
}
