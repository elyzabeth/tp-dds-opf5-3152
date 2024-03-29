package dds.tp.g14.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.g14.tp.jugador.EdadMaxJugadores;
import dds.g14.tp.jugador.Estandar;
import dds.g14.tp.jugador.Jugador;
import dds.g14.tp.jugador.Solidario;
import dds.g14.tp.partido.Partido;


public class PrimeraEntregaTest {

	Jugador estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9;
	Partido partido;
	
	@Before
	public void initObjects(){
		estandar1 = new Jugador(17, true, new Estandar());
		estandar2 = new Jugador(18, false, new Estandar());
		estandar3 = new Jugador(19, true, new Estandar());
		estandar4 = new Jugador(20, false, new Estandar());
		estandar5 = new Jugador(21, true, new Estandar());
		estandar6 = new Jugador(22, false, new Estandar());
		estandar7 = new Jugador(23, true, new Estandar());
		estandar8 = new Jugador(24, false, new Estandar());
		estandar9 = new Jugador(25, true, new Estandar());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaPartido;
		try {
			fechaPartido = sdf.parse("5/5/2104");
			partido = new Partido(fechaPartido, estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void agregarJugadorEstandar(){
		Jugador estandar = new Jugador(21, true, new Estandar());
		partido.agregarJugador(estandar);
		Assert.assertTrue(partido.integrantes.contains(estandar));
	}
	
	@Test
	public void agregarJugadorSolidario(){
		Jugador solidario = new Jugador(21, true, new Solidario());
		partido.agregarJugador(solidario);
		Assert.assertTrue(partido.integrantes.contains(solidario));
	}
	
	@Test
	public void agregarJugadorCondicionalCondicionValida(){
		Jugador condicional = new Jugador(21, true, new EdadMaxJugadores(30));
		partido.agregarJugador(condicional);
		Assert.assertTrue(partido.integrantes.contains(condicional));
	}
	
	@Test
	public void agregarJugadorCondicionalCondicionInvalida(){
		Jugador condicional = new Jugador(21, true, new EdadMaxJugadores(22));
		partido.agregarJugador(condicional);
		Assert.assertFalse(partido.integrantes.contains(condicional));
	}
	
	@Test
	public void agregarJugadorEstandarAPartidoLlenoConSolidario(){
		Jugador estandar10 = new Jugador(21, true, new Estandar());
		Jugador solidarioRelleno = new Jugador(22, true, new Solidario());
		partido.agregarJugador(solidarioRelleno);
		partido.agregarJugador(estandar10);
		Assert.assertTrue(partido.integrantes.contains(estandar10));
	}
	
	@Test
	public void agregarJugadorEstandarAPartidoLlenoConEstandars(){
		Jugador estandar10 = new Jugador(21, true, new Estandar());
		Jugador estandarRelleno = new Jugador(22, true, new Estandar());
		partido.agregarJugador(estandarRelleno);
		partido.agregarJugador(estandar10);
		Assert.assertFalse(partido.integrantes.contains(estandar10));
	}
	
}
