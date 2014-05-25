package tp.dds.dominio;

public class Calificacion {
	
	private Jugador jugador;
	private Integer calificacion;

	public Calificacion (Jugador jugador, Integer calificacion) {
		this.jugador = jugador;
		this.calificacion = calificacion;
	}

	public Jugador jugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Integer calificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	
}
