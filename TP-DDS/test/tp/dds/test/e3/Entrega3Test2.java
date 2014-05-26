package tp.dds.test.e3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.dds.dominio.Administrador;
import tp.dds.dominio.BaseDeDatos;
import tp.dds.dominio.CandidatoMayorDeEdad;
import tp.dds.dominio.Jugador;


public class Entrega3Test2 {
	
	Administrador admin;
	BaseDeDatos baseDeDatos;

	Jugador jugador1, jugador2, jugador3 , jugador4, jugador5;
	Jugador jugador6, jugador7, jugador8, jugador9, jugador10, jugador11, jugador12;


	@Before
	public void initObjects(){

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

		admin = new Administrador("Julian", "admin@ddsutn.com");
		baseDeDatos = new BaseDeDatos(new CandidatoMayorDeEdad());

		baseDeDatos.proponerJugador(jugador1);
		baseDeDatos.proponerJugador(jugador2);
		baseDeDatos.proponerJugador(jugador3);
		baseDeDatos.proponerJugador(jugador4);
		baseDeDatos.proponerJugador(jugador5);
		baseDeDatos.proponerJugador(jugador6);
		baseDeDatos.proponerJugador(jugador7);
		baseDeDatos.proponerJugador(jugador8);
		baseDeDatos.proponerJugador(jugador9);
		baseDeDatos.proponerJugador(jugador10);
		baseDeDatos.proponerJugador(jugador11);
		baseDeDatos.proponerJugador(jugador12);
	}


	@Test
	public void evaluarJugadores() {
		
		System.out.println("Tiene que aprobar a todos");
		baseDeDatos.evaluarJugadoresPendientes();
		Assert.assertEquals(12, baseDeDatos.jugadoresAprobados().size());
		Assert.assertEquals(0, baseDeDatos.denegaciones().size());
		Assert.assertEquals(0, baseDeDatos.jugadoresPendientes().size());
	}


	@Test
	public void evaluarJugadores2() {
		System.out.println("Tiene que desaprobar 1");
		baseDeDatos.evaluarJugadoresPendientes2( (Jugador j) -> j.edad() >= 23  );
		Assert.assertEquals(11, baseDeDatos.jugadoresAprobados().size());
		Assert.assertEquals(1, baseDeDatos.denegaciones().size());
		Assert.assertEquals(0, baseDeDatos.jugadoresPendientes().size());
	}

}
