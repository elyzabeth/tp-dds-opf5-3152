package dds.g14.tp.entities;

public class Mail {

	private String mensaje;
	private String destinatario;
	private String origen;

	public Mail(String origen, String mensaje, String destinatario) {
		this.origen	= origen;
		this.mensaje = mensaje;
		this.destinatario = destinatario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDestinatario() {
		return destinatario;
	}
	
	public String getOrigen(){
		return origen;
	}

}
