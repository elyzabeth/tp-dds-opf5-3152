package dds.g14.tp.observers;

import dds.g14.tp.entities.MailSender;
import dds.g14.tp.entities.Partido;

public abstract class Observer {
	
	public Partido partido;
	
	public MailSender mailSender;
	
	public Observer(Partido partido) {
		this.partido = partido;
		mailSender = new MailSender();
	}
	
	public abstract void realizarObservacion();
	
}
