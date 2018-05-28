package Testes;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TesteEmail {

	public String enviarEmail() {
		try {
			SimpleEmail enviarEmail = new SimpleEmail();
			enviarEmail.setHostName("smtp.gmail.com");
			enviarEmail.setSmtpPort(465);
			enviarEmail.setAuthentication("projetojavasenai@gmail.com", "senai123");
			enviarEmail.setSSLOnConnect(true);
			enviarEmail.setFrom("projetojavasenai@gmail.com");
			enviarEmail.setSubject("Teste");
			enviarEmail.setMsg("Teste: Mandar Email - TCC: Projeto SIG");
			enviarEmail.addTo("ruldi.borges@gmail.com");
			enviarEmail.send();
			return "E-mail enviado";
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new TesteEmail().enviarEmail());
	}

}
