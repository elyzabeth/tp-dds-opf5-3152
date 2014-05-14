package dds.g14.tp.observers;

import dds.g14.tp.entities.Partido;

public class PartidoCompleto extends Observer{

	public PartidoCompleto(Partido partido) {
		super(partido);
	}

	@Override
	public void realizarObservacion() {
		if(partido.integrantes.size() == Partido.CANT_MAX_JUGADORES)
			mailSender.sendMail("Partido completo", partido.getDireccionMailAdminitrador());
	}

}
