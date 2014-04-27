package dds.tp.g14.entities;

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
		confiable1 = new Jugador(confiable);
		confiable2 = new Jugador(confiable);
		confiable3 = new Jugador(confiable);
		confiable4 = new Jugador(confiable);
		confiable5 = new Jugador(confiable);
		casual1 = new Jugador(casual);
		casual2 = new Jugador(casual);
		casual3 = new Jugador(casual);
		casual4 = new Jugador(casual);
		casual5 = new Jugador(casual);
		partido = new Partido(confiable1,confiable2,confiable3,confiable4,confiable5,casual1,casual2,casual3,casual4,casual5);
	}
	
	
	@Test
	public void nuevoJugadorConfiableAlPartido(){
		Jugador interesado = new Jugador(confiable);
		partido.addJugador(interesado);
		Assert.assertTrue(partido.getJugador(interesado));
	}
	
	@Test
	public void nuevoJugadorCasualAlPartido(){
		Jugador interesado = new Jugador(casual);
		partido.addJugador(interesado);
		Assert.assertFalse(partido.getJugador(interesado));
	}
}
