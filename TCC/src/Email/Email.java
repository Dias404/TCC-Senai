package Email;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	public static String enviarEmailAdmin(JComboBox cbEmail, JEditorPane epMsg) {
		String para = cbEmail.getSelectedItem().toString();
		String emailLogado = "tccsig0@gmail.com";
		String senhaEmailLogado = "siganadiasribeirojere";
		String usuarioEmailLogado = "SIG";
		String msg = epMsg.getText();
		
		try {
			SimpleEmail enviarEmail = new SimpleEmail();
			if(para.contains("@gmail.com")) { // para gmail
				enviarEmail.setHostName("smtp.gmail.com"); 
				enviarEmail.setSmtpPort(465);
			}if(para.contains("@hotmail.com") || para.contains("@outlook.com")) { // para hotmail
				enviarEmail.setHostName("smtp-mail.outlook.com"); 
				enviarEmail.setSmtpPort(587); //25
			}
			enviarEmail.setAuthentication(emailLogado, senhaEmailLogado);
			enviarEmail.setSSLOnConnect(true);
			//enviarEmail.setTLSOnConnect(true); <-- Se precisar
			enviarEmail.setFrom(emailLogado);
			enviarEmail.setSubject("SIG - "+usuarioEmailLogado);
			enviarEmail.setMsg(msg);
			enviarEmail.addTo(para);
			enviarEmail.send();
			JOptionPane.showMessageDialog(null, "Email Enviado com sucesso!");
			return "certo";
		} catch (EmailException arg0) {
			arg0.printStackTrace();
			JOptionPane.showMessageDialog(null, "Email Inválido");
			return "Fail";
		}
	
	}
	
}
