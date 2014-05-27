package dds.tp.g14.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.Partido;
import dds.g14.tp.entities.participacion.EdadMaxJugadores;
import dds.g14.tp.entities.participacion.Estandar;
import dds.g14.tp.entities.participacion.Solidario;
import dds.g14.tp.exceptions.ImposibleAgregarJugadorAPartidoException;
import dds.g14.tp.exceptions.ImposibleJugarEnPartidoException;


public class PrimeraEntregaTest {

	Jugador estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9;
	Partido partido;
	
	@Before
	public void initObjects(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaPartido;
		try {
			fechaPartido = sdf.parse("5/5/2104");
			partido = new Partido("direccionMailAdmin",fechaPartido);
			partido.agregarJugador(new Jugador(17, true, new Estandar(), "direccionMail1"));
			partido.agregarJugador(new Jugador(18, false, new Estandar(), "direccionMail2"));
			partido.agregarJugador(new Jugador(19, true, new Estandar(), "direccionMail3"));
			partido.agregarJugador(new Jugador(20, false, new Estandar(), "direccionMail4"));
			partido.agregarJugador(new Jugador(21, true, new Estandar(), "direccionMail5"));
			partido.agregarJugador(new Jugador(22, false, new Estandar(), "direccionMail6"));
			partido.agregarJugador(new Jugador(23, true, new Estandar(), "direccionMail7"));
			partido.agregarJugador(new Jugador(24, false, new Estandar(), "direccionMail8"));
			partido.agregarJugador(new Jugador(25, true, new Estandar(), "direccionMail9"));		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void agregarJugadorEstandar(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionMailEstandar");
		partido.agregarJugador(estandar);
		Assert.assertTrue(partido.integrantes.contains(estandar));
	}
	
	@Test
	public void agregarJugadorSolidario(){
		Jugador solidario = new Jugador(21, true, new Solidario(), "direccionMailSolirio");
		partido.agregarJugador(solidario);
		Assert.assertTrue(partido.integrantes.contains(solidario));
	}
	
	@Test
	public void agregarJugadorCondicionalCondicionValida(){
		Jugador condicional = new Jugador(21, true, new EdadMaxJugadores(30), "direccionMailCondicionValida");
		partido.agregarJugador(condicional);
		Assert.assertTrue(partido.integrantes.contains(condicional));
	}
	
	@Test(expected=ImposibleJugarEnPartidoException.class)
	public void agregarJugadorCondicionalCondicionInvalida(){
		Jugador condicional = new Jugador(21, true, new EdadMaxJugadores(22), "direccionMailCondicionInvalida");
		partido.agregarJugador(condicional);
	}
	
	@Test
	public void agregarJugadorEstandarAPartidoLlenoConSolidario(){
		Jugador estandar10 = new Jugador(21, true, new Estandar(), "direccionMailEstandar");
		Jugador solidarioRelleno = new Jugador(22, true, new Solidario(), "direccionMailSolidario");
		partido.agregarJugador(solidarioRelleno);
		partido.agregarJugador(estandar10);
		Assert.assertTrue(partido.integrantes.contains(estandar10));
	}
	
	@Test(expected=ImposibleAgregarJugadorAPartidoException.class)
	public void agregarJugadorEstandarAPartidoLlenoConEstandars(){
		Jugador estandar10 = new Jugador(21, true, new Estandar(), "direccionMailEstandar");
		Jugador estandarRelleno = new Jugador(22, true, new Estandar(), "direccionMailSolidario");
		partido.agregarJugador(estandarRelleno);
		partido.agregarJugador(estandar10);
	}
	
}
