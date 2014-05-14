package dds.g14.tp.observers;

import dds.g14.tp.entities.Partido;

public class PartidoCompleto extends Observer{

	public PartidoCompleto(Partido partido) {
		super(partido);
	}

	@Override
	public void realizarObservacion() {
		System.out.println("Se mando un mail " + this.toString() + " al admin con la direccion: " + partido.getDireccionMailAdminitrador());
	}

}
