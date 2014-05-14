package dds.g14.tp.entities;

public class Mail {
	
	private String mensaje;
	private String destinatario;
	
	public Mail(String mensaje, String destinatario) {
		this.mensaje = mensaje;
		this.destinatario = destinatario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDestinatario() {
		return destinatario;
	}
	
	
}
