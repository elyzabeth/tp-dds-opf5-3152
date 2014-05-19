package tp.dds.test.e1;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.dds.entidades.CondMaxCantJugxEdad;
import tp.dds.entidades.InsEstandar;
import tp.dds.entidades.InsSolidaria;
import tp.dds.entidades.Inscripcion;
import tp.dds.entidades.Jugador;
import tp.dds.entidades.Partido;
import tp.dds.excepciones.NoHayLugarException;

/**
 * Tengo 1 partido con 10 jugadores estandar. 
 * No se debe poder agregar ningun tipo de inscripcion
 */
public class TPE1Prioridad1 {

	Jugador jugador1, jugador2, jugador3, jugador4, jugador5;
	Jugador jugador6, jugador7, jugador8, jugador9, jugador10, jugador11,
			jugador12;
	Partido partido;

	@Before
	public void initObjects() {
		Date fechaPartido = new Date();
		partido = new Partido(fechaPartido);

		jugador1 = new Jugador("Martin", 1970);
		jugador2 = new Jugador("Marcelo", 1974);
		jugador3 = new Jugador("Matias", 1992);
		jugador4 = new Jugador("Federico", 1984);
		jugador5 = new Jugador("Patricio", 1981);
		jugador6 = new Jugador("Fabrizio", 1979);
		jugador7 = new Jugador("Esteban", 1978);
		jugador8 = new Jugador("Mariano", 1982);
		jugador9 = new Jugador("Walter", 1980);
		jugador10 = new Jugador("Cornelio", 1975);
		jugador11 = new Jugador("Demian", 1978);
		jugador12 = new Jugador("Gregorio", 1977);


		partido.inscribir(new InsEstandar(jugador1));
		partido.inscribir(new InsEstandar(jugador2));
		partido.inscribir(new InsEstandar(jugador3));
		partido.inscribir(new InsEstandar(jugador4));
		partido.inscribir(new InsEstandar(jugador5));
		partido.inscribir(new InsEstandar(jugador6));
		partido.inscribir(new InsEstandar(jugador7));
		partido.inscribir(new InsEstandar(jugador8));
		partido.inscribir(new InsEstandar(jugador9));
		partido.inscribir(new InsEstandar(jugador10));

		System.out.println("Cant Jugadores estandar: "+ partido.cantJugadoresEstandar());

	}

	@Test
	public void prioridad1(){

		Inscripcion ins1 = new InsEstandar(jugador11);
		Inscripcion ins2 = new InsSolidaria(jugador12);
		System.out.println("Estandar: "+ ins1.prioridad() + " Solidaria: "+ ins2.prioridad());
		Assert.assertTrue(ins1.prioridad()>ins2.prioridad());
	}

	@Test
	public void prioridad2(){

		Inscripcion ins1 = new InsEstandar(jugador11);
		Inscripcion ins2 = new CondMaxCantJugxEdad(jugador12, 5, 20);
		System.out.println("Estandar: "+ ins1.prioridad() + " Condicional: "+ ins2.prioridad());
		Assert.assertTrue(ins1.prioridad()>ins2.prioridad());
	}

	@Test
	public void prioridad3(){

		Inscripcion ins1 = new InsSolidaria(jugador11);
		Inscripcion ins2 = new CondMaxCantJugxEdad(jugador12, 5, 20);
		System.out.println("Solidaria: "+ ins1.prioridad() + " Condicional: "+ ins2.prioridad());
		Assert.assertTrue(ins1.prioridad()>ins2.prioridad());
	}


	@Test(expected=NoHayLugarException.class)
	public void agregarJugadorEstandar() {
		System.out.println("Agrego jugador Estandar: No debe poder inscribirse");
		Inscripcion ins = new InsEstandar(jugador11);
		partido.inscribir(ins);
		Assert.assertFalse(partido.contieneJugador(ins));
	}

	@Test(expected = NoHayLugarException.class)
	public void agregarJugadorSolidario() {
		System.out.println("Agrego jugador Solidario: No debe poder inscribirse");
		Inscripcion ins = new InsSolidaria(jugador11);
		partido.inscribir(ins);
		Assert.assertFalse(partido.contieneJugador(ins));
	}

	@Test(expected = NoHayLugarException.class)
	public void agregarJugadorCondicional() {
		System.out.println("Agrego jugador Condicional: No debe poder inscribirse");
		Inscripcion ins = new CondMaxCantJugxEdad(jugador11, 5, 20);
		partido.inscribir(ins);
		Assert.assertFalse(partido.contieneJugador(ins));
	}

}
