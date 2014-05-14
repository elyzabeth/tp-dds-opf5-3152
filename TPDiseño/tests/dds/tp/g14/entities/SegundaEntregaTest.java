package dds.tp.g14.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.g14.tp.entities.Jugador;
import dds.g14.tp.entities.Partido;
import dds.g14.tp.entities.participacion.Estandar;

public class SegundaEntregaTest {
	
	Jugador estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9;
	Partido partido;
	
	@Before
	public void initObjects(){
		estandar1 = new Jugador(17, true, new Estandar(), "direccionMail1");
		estandar2 = new Jugador(18, false, new Estandar(), "direccionMail2");
		estandar3 = new Jugador(19, true, new Estandar(), "direccionMail3");
		estandar4 = new Jugador(20, false, new Estandar(), "direccionMail4");
		estandar5 = new Jugador(21, true, new Estandar(), "direccionMail5");
		estandar6 = new Jugador(22, false, new Estandar(), "direccionMail6");
		estandar7 = new Jugador(23, true, new Estandar(), "direccionMail7");
		estandar8 = new Jugador(24, false, new Estandar(), "direccionMail8");
		estandar9 = new Jugador(25, true, new Estandar(), "direccionMail9");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaPartido;
		try {
			fechaPartido = sdf.parse("5/5/2104");
			partido = new Partido("direccionMailAdmin",fechaPartido, estandar1, estandar2, estandar3, estandar4, estandar5, estandar6, estandar7, estandar8, estandar9);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
