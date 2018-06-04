package Testes;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail; 

public class TesteEmail {

	public String enviarEmail() {
		try {
			SimpleEmail enviarEmail = new SimpleEmail();
			enviarEmail.setHostName("smtp.gmail.com"); //smtp-mail.outlook.com para hotmail
			enviarEmail.setSmtpPort(465); //25 ou 587 caso não funcione
			enviarEmail.setAuthentication("projetojavasenai@gmail.com", "senai123");
			enviarEmail.setSSLOnConnect(true);
			//enviarEmail.setTLSOnConnect(true); <-- Se precisar
			enviarEmail.setFrom("projetojavasenai@gmail.com");
			enviarEmail.setSubject("Teste");
			enviarEmail.setMsg("Teste: Mandar Email - TCC: Projeto SIG");
			enviarEmail.addTo("carol.dragneel14@gmail.com");
			enviarEmail.send();
			return "E-mail enviado";
		} catch (EmailException arg0) {
			// TODO Auto-generated catch block
			arg0.printStackTrace();
			return "Fail";
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new TesteEmail().enviarEmail());
	}

}
