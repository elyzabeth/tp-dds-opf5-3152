package dds.g14.tp.entities;

public class MailSender {
	
	public MailSender() {
	}
	
	public void sendMail(String mensaje, String destinatario){
		Mail mail = new Mail(mensaje, destinatario);
		System.out.println("Se envio un mail a: " + mail.getDestinatario() +
							" con mensaje: " + mail.getMensaje());
	};
}
