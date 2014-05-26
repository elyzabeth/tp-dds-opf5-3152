package tp.dds.dominio;

import tp.dds.interfaces.CheckCandidato;

public class CandidatoMayorDeEdad implements CheckCandidato {

	@Override
	public boolean cumpleCondicion(Jugador jugador) {
		return jugador.edad() >= 18;
	}

}
