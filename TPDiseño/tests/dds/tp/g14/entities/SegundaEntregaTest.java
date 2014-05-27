package dds.tp.g14.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.MailMocker;
import dds.g14.tp.entities.MailSender;
import dds.g14.tp.entities.Partido;
import dds.g14.tp.entities.participacion.EdadMaxJugadores;
import dds.g14.tp.entities.participacion.Estandar;
import dds.g14.tp.observers.NuevoJugadorEnPartido;
import dds.g14.tp.observers.PartidoCompleto;

public class SegundaEntregaTest {
	
	Jugador estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9;
	Partido partido;
	MailSender mailSender;
	
	@Before
	public void initObjects(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaPartido;
		mailSender = new MailMocker();
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
	public void observerNuevoJugadorEnPartido(){
		partido.agregarObserver(new NuevoJugadorEnPartido(partido,mailSender));
		Jugador condicional = new Jugador(21, true, new EdadMaxJugadores(30), "direccionNuevo");
		partido.agregarJugador(condicional);
		Assert.assertTrue(partido.integrantes.contains(condicional));
	}
	
	@Test
	public void observerPartidoCompleto(){
		partido.agregarObserver(new PartidoCompleto(partido,mailSender));
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		partido.agregarJugador(estandar);
		Assert.assertTrue(partido.integrantes.contains(estandar));
	}
	
	@Test
	public void darBajaJugadorConReemplazo(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		partido.agregarJugador(estandar);
		Jugador reemplazo = new Jugador(21, true, new Estandar(), "direccionNueva");
		partido.presentarReemplazoAnteBaja(estandar, reemplazo);
		Assert.assertTrue(partido.integrantes.contains(reemplazo));
	}
	
	@Test
	public void darBajaJugadorSinReemplazo(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		partido.agregarJugador(estandar);
		partido.presentarReemplazoAnteBaja(estandar, null);
		Assert.assertTrue(estandar.getInfracciones().size() == 1);
	}
	
}
