package dds.tp.g14.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.MailMocker;
import dds.g14.tp.entities.Mensajero;
import dds.g14.tp.entities.Partido;
import dds.g14.tp.entities.participacion.Estandar;

public class SegundaEntregaTest {
	
	Jugador estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9;
	Mensajero mensajero;
	
	@Before
	public void initObjects(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaPartido;
		try {
			fechaPartido = sdf.parse("5/5/2104");
			mensajero = new Mensajero(new Partido("adminMailAddress", fechaPartido), new MailMocker());
			mensajero.agregarJugador(new Jugador(17, true, new Estandar(), "direccionMail1"));
			mensajero.agregarJugador(new Jugador(18, false, new Estandar(), "direccionMail2"));
			mensajero.agregarJugador(new Jugador(19, true, new Estandar(), "direccionMail3"));
			mensajero.agregarJugador(new Jugador(20, false, new Estandar(), "direccionMail4"));
			mensajero.agregarJugador(new Jugador(21, true, new Estandar(), "direccionMail5"));
			mensajero.agregarJugador(new Jugador(22, false, new Estandar(), "direccionMail6"));
			mensajero.agregarJugador(new Jugador(23, true, new Estandar(), "direccionMail7"));
			mensajero.agregarJugador(new Jugador(24, false, new Estandar(), "direccionMail8"));
			mensajero.agregarJugador(new Jugador(25, true, new Estandar(), "direccionMail9"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void darBajaJugadorConReemplazo(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		mensajero.agregarJugador(estandar);
		Jugador reemplazo = new Jugador(21, true, new Estandar(), "direccionNueva");
		mensajero.presentarReemplazoAnteBaja(estandar, reemplazo);
		Assert.assertTrue(mensajero.integrantes.contains(reemplazo));
	}

	@Test
	public void darBajaJugadorSinReemplazo(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		mensajero.agregarJugador(estandar);
		mensajero.presentarReemplazoAnteBaja(estandar, null);
		Assert.assertTrue(estandar.getInfracciones().size() == 1);
	}

	@Test
	public void mandarMailAAmigosAnteNuevoIngresoAPartido(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		estandar.amigos.add(new Jugador(21, true, new Estandar(), "dirMail1"));
		estandar.amigos.add(new Jugador(22, true, new Estandar(), "dirMail2"));
		estandar.amigos.add(new Jugador(23, true, new Estandar(), "dirMail3"));
		mensajero.agregarJugador(estandar);
		Assert.assertEquals(3, mensajero.mailSender.getMailsSentFrom(estandar.getDireccionMail()).size());
	}
	
	@Test
	public void mandarMailAlAdminAntePartidoCompleto(){
		Jugador estandar = new Jugador(21, true, new Estandar(), "direccionNueva");
		mensajero.agregarJugador(estandar);
		Assert.assertTrue(mensajero.CANT_MAX_JUGADORES == mensajero.integrantes.size());
		Assert.assertEquals(1, mensajero.mailSender.getMailsSentFrom(mensajero.toString()).size());
	}
	
}
