package dds.g14.tp.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailMocker extends MailSender{

	private Map<String, List<Mail>>  mailsEnviados ;
	
	public MailMocker(){
		mailsEnviados = new HashMap<String, List<Mail>>();
	}
	
	@Override
	public void sendMail(String origen, String mensaje, String destinatario) {
		List<Mail> mailsParticulares = mailsEnviados.get(origen);
		if( mailsParticulares== null){
			mailsParticulares = new ArrayList<Mail>();
		}
		mailsParticulares.add(new Mail(origen,mensaje,destinatario));
		mailsEnviados.put(origen, mailsParticulares);
	}
	
	public List<Mail> getMailsSentFrom(String origen){
		if(mailsEnviados.get(origen) != null){
			return mailsEnviados.get(origen);
		}
		return new ArrayList<Mail>();
	};
}
