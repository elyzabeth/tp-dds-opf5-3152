package tp.dds.test.e2;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.dds.dominio.Administrador;
import tp.dds.dominio.CondMaxCantJugxEdad;
import tp.dds.dominio.InsEstandar;
import tp.dds.dominio.InsSolidaria;
import tp.dds.dominio.Inscripcion;
import tp.dds.dominio.Jugador;
import tp.dds.dominio.Mail;
import tp.dds.dominio.Partido;
import tp.dds.excepciones.NoExisteJugadorEnPartidoException;
import tp.dds.observer.BajaJugador;
import tp.dds.observer.InscripcionAmigo;
import tp.dds.observer.PartidoConfirmado;
import tp.dds.test.MailSenderStub;


public class Entrega2Test1 {

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
		jugador10.agregarAmigo(jugador1);
		jugador10.agregarAmigo(jugador3);
		jugador10.agregarAmigo(jugador6);

		jugador11.agregarAmigo(jugador2);
		jugador11.agregarAmigo(jugador3);
		jugador11.agregarAmigo(jugador4);
		jugador11.agregarAmigo(jugador7);

		//Agrego observadores
		partido.agregarObservador(new BajaJugador(partido, mailSender));
		partido.agregarObservador(new InscripcionAmigo(partido, mailSender));
		partido.agregarObservador(new PartidoConfirmado(partido, mailSender));
		
		partido.inscribir(new InsEstandar(jugador1));
		partido.inscribir(new InsEstandar(jugador2));
		partido.inscribir(new InsEstandar(jugador3));
		partido.inscribir(new InsEstandar(jugador4));
		partido.inscribir(new InsEstandar(jugador5));
		partido.inscribir(new InsEstandar(jugador6));
		partido.inscribir(new InsEstandar(jugador7));
		partido.inscribir(new InsEstandar(jugador8));
		partido.inscribir(new InsEstandar(jugador9));

		System.out.println("Cant Jugadores estandar: "+ partido.cantJugadoresEstandar());

	}

	@Test
	public void crearMail(){
		Mail mail = new Mail("sistema@ddsutn.com", partido.administrador().mail(), "Partido Confirmado", "El partido tiene 10 jugadores");
		//Mail mail = new Mail("remitente", partido.administrador().mail(), "asunto", "mensaje");
		Assert.assertNotNull(mail); 
	}

	@Test
	public void agregarJugadorEstandar() {
		System.out.println("Agrego jugador Estandar sin amigos: Notificar al administrador Partido Confirmado");
		Inscripcion ins = new InsEstandar(jugador12);
		partido.inscribir(ins);
		System.out.println("---");
		Assert.assertEquals(1, mailSender.listaMails().size());
	}

	@Test
	public void agregarJugadorSolidario() {
		System.out.println("Agrego jugador Solidario: con 3 amigos, envia mail al admin y a los amigos");
		Inscripcion ins = new InsSolidaria(jugador10);
		partido.inscribir(ins);
		Assert.assertEquals(4, mailSender.listaMails().size());
	}

	@Test//(expected=NoHayLugarException.class)
	public void agregarJugadorCondicional() {
		System.out.println("Agrego jugador Condicional: con 4 amigos, envia mail al admin y a los amigos");
		Inscripcion ins = new CondMaxCantJugxEdad(jugador11, 5, 20);
		partido.inscribir(ins);
		Assert.assertEquals(5, mailSender.listaMails().size());
	}

	@Test
	public void borroJugador() {
		System.out.println("Borro jugador sin reemplazo: no envio mails");
		partido.bajaJugador(jugador1, null);
		Assert.assertEquals(0, mailSender.listaMails().size());
	}

	@Test(expected = NoExisteJugadorEnPartidoException.class)
	public void borroJugadorInexistente() {
		System.out.println("Borro jugador que no existe en el partido: no envio mails, arroja excepcion");
		partido.bajaJugador(jugador10, null);
		Assert.assertEquals(0, mailSender.listaMails().size());
	}
}
