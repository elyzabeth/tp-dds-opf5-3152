package dds.tp.g14.entities;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PrimeraEntregaTest {

	Jugador confiable1, confiable2, confiable3 , confiable4, confiable5;
	Jugador casual1, casual2, casual3, casual4, casual5;
	Partido partido;
	
	@Before
	public void initObjects(){
		confiable1 = new Jugador(16, true, new Solidario());
		confiable2 = new Jugador(17, true, new Estandar());
		confiable3 = new Jugador(18, true, new Estandar());
		confiable4 = new Jugador(19, true, new Estandar());
		confiable5 = new Jugador(20, true, new Estandar());
		casual2 = new Jugador(22, false, new Solidario());
		casual3 = new Jugador(23, false, new Estandar());
		casual4 = new Jugador(24, false, new Estandar());
		casual5 = new Jugador(25, false, new Solidario());
		Date fechaPartido = new Date();
		partido = new Partido(fechaPartido,confiable1, confiable2, confiable3, confiable4, confiable5, casual2, casual3, casual4, casual5);
	}
	
	@Test
	public void agregarCondicionEdadMax(){
		System.out.println("agregarCondicionEdadMax");
		Jugador condicionado = new Jugador(21, false, new EdadMaxJugadores(partido, 20));
		partido.agregarJugador(condicionado);
		Assert.assertFalse(partido.contieneJugador(condicionado));
	}
	
	@Test
	public void nuevoJugadorEstandarAlPartido(){
		Jugador interesado = new Jugador(26, true, new Estandar());
		partido.agregarJugador(interesado);
		Assert.assertTrue(partido.contieneJugador(interesado));
	}
	
	@Test
	public void nuevoJugadorSolidarioAlPartido(){
		Jugador interesado = new Jugador(18, false, new Solidario());
		partido.agregarJugador(interesado);
		Assert.assertTrue(partido.contieneJugador(interesado));
	}
}
