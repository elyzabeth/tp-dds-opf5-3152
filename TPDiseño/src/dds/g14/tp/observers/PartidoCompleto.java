package dds.g14.tp.observers;

import dds.g14.tp.entities.MailSender;
import dds.g14.tp.entities.Partido;

public class PartidoCompleto extends Observer{

	public PartidoCompleto(Partido partido, MailSender mailSender) {
		super(partido,mailSender);
	}

	@Override
	public void realizarObservacion() {
		if(partido.integrantes.size() == Partido.CANT_MAX_JUGADORES)
			mailSender.sendMail(partido.toString(),"Partido completo", partido.getDireccionMailAdminitrador());
	}

}
