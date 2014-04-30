package dds.tp.g14.entities;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PrimeraEntregaTest {

	Jugador confiable1, confiable2, confiable3 , confiable4, confiable5;
	Jugador casual1, casual2, casual3, casual4, casual5;
	Partido partido;
	Confiable confiable = new Confiable();;
	Casual casual = new Casual();
	
	@Before
	public void initObjects(){
		confiable1 = new Jugador(16, confiable, new Solidario());
		confiable2 = new Jugador(17, confiable, new Estandar());
		confiable3 = new Jugador(18, confiable, new Estandar());
		confiable4 = new Jugador(19, confiable, new Estandar());
		confiable5 = new Jugador(20, confiable, new Estandar());
		casual2 = new Jugador(22, casual, new Solidario());
		casual3 = new Jugador(23, casual, new Estandar());
		casual4 = new Jugador(24, casual, new Estandar());
		casual5 = new Jugador(25, casual, new Solidario());
		Date fechaPartido = new Date();
		partido = new Partido(fechaPartido,confiable1, confiable2, confiable3, confiable4, confiable5, casual2, casual3, casual4, casual5);
	}
	
	@Test
	public void agregarCondicionEdadMax(){
		System.out.println("agregarCondicionEdadMax");
		Jugador condicionado = new Jugador(21, casual, new Condicional(new EdadMaxJugadores(partido, 20)));
		partido.agregarJugador(condicionado);
		Assert.assertFalse(partido.contieneJugador(condicionado));
	}
	
	@Test
	public void nuevoJugadorConfiableAlPartido(){
		Jugador interesado = new Jugador(26, confiable, new Estandar());
		partido.agregarJugador(interesado);
		Assert.assertTrue(partido.contieneJugador(interesado));
	}
	
	@Test
	public void nuevoJugadorCasualAlPartido(){
		Jugador interesado = new Jugador(18, casual, new Solidario());
		partido.agregarJugador(interesado);
		Assert.assertTrue(partido.contieneJugador(interesado));
	}
}
