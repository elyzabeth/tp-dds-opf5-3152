package tp.dds.dominio;

import java.util.Date;

public class Denegacion {

		private Date fecha;
		private String motivo;
		private Jugador jugador;

		public Denegacion (Date fecha, String motivo, Jugador jugador) {
			this.fecha = fecha;
			this.motivo = motivo;
			this.jugador = jugador;
		}

		public Date fecha() {
			return fecha;
		}

		public String motivo() {
			return motivo;
		}
		
		public Jugador jugador(){
			return jugador;
	}
}
