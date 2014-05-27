package dds.g14.tp.observers;

import dds.g14.tp.entities.MailSender;
import dds.g14.tp.entities.Partido;

public class PartidoIncompleto extends Observer{

	public PartidoIncompleto(Partido partido, MailSender mailSender) {
		super(partido,mailSender);
	}

	@Override
	public void realizarObservacion() {
		//TODO falta definir como darse cuenta que paso de 10 a 9
		mailSender.sendMail(partido.toString(), "Partido nuevamente incompleto", partido.getDireccionMailAdminitrador());
	}

}
