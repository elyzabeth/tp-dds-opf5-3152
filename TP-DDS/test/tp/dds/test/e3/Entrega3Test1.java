package tp.dds.test.e3;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.dds.dominio.Administrador;
import tp.dds.dominio.InsEstandar;
import tp.dds.dominio.Jugador;
import tp.dds.dominio.Partido;
import tp.dds.observer.BajaJugador;
import tp.dds.observer.InscripcionAmigo;
import tp.dds.observer.PartidoConfirmado;
import tp.dds.test.MailSenderStub;


public class Entrega3Test1 {

	MailSenderStub mailSender;
	Partido partido;

	Jugador jugador1, jugador2, jugador3, jugador4, jugador5;
	Jugador jugador6, jugador7, jugador8, jugador9, jugador10, jugador11,
			jugador12;

	@Before
	public void initObjects() {

		Date fechaPartido = new Date();
		partido = new Partido(fechaPartido, new Administrador("Elizabeth", "elyzabeth@ddsutn.com"));
		mailSender = new MailSenderStub();

		jugador1 = new Jugador("Martin", "martin@ddsutn.com", 1970);
		jugador2 = new Jugador("Marcelo", "marcelo@ddsutn.com", 1974);
		jugador3 = new Jugador("Matias", "matias@ddsutn.com", 1992);
		jugador4 = new Jugador("Federico", "federico@ddsutn.com", 1984);
		jugador5 = new Jugador("Patricio", "patricio@ddsutn.com", 1981);
		jugador6 = new Jugador("Fabrizio", "fabrizio@ddsutn.com", 1979);
		jugador7 = new Jugador("Esteban", "esteban@ddsutn.com", 1978);
		jugador8 = new Jugador("Mariano", "mariano@ddsutn.com", 1982);
		jugador9 = new Jugador("Walter", "walter@ddsutn.com", 1980);
		jugador10 = new Jugador("Cornelio", "cornelio@ddsutn.com", 1975);
		jugador11 = new Jugador("Demian", "demian@ddsutn.com", 1978);
		jugador12 = new Jugador("Gregorio", "gregorio@ddsutn.com", 1977);
		
		//Agrego amigos a algunos jugadores
		jugador11.agregarAmigo(jugador2);
		jugador11.agregarAmigo(jugador3);
		jugador11.agregarAmigo(jugador4);
		jugador11.agregarAmigo(jugador7);

		//Agrego observadores
		partido.agregarObservador(new BajaJugador(partido, mailSender));
		partido.agregarObservador(new InscripcionAmigo(partido, mailSender));
		partido.agregarObservador(new PartidoConfirmado(partido, mailSender));

		// Inscribo 10 jugadores estandar sin amigos se envia 1 mail al admin
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
	public void agregoUnaCalificacion() {
		System.out.println("Obtengo 1 jugador del partido y le agrego una calificacion");
		partido.bajaJugador(jugador1, null);
		Assert.assertEquals(2, mailSender.listaMails().size());
	}

}
