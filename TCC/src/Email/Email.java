package Email;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import CRUD.CRUDUsuarios;
import Telas.TelaPrincipal;

public class Email {
	
	public static String enviarEmailAdmin(JComboBox cbEmail, JEditorPane epMsg, String senha) {
		CRUDUsuarios select = new CRUDUsuarios();
		select.selectCondicao1(TelaPrincipal.usuario, TelaPrincipal.senha);
		try {
			if(select.dadosLogin.next()) {
				String para = cbEmail.getSelectedItem().toString();
				String emailLogado = select.dadosLogin.getString("email");
				String usuarioEmailLogado = TelaPrincipal.usuario;
				String msg = epMsg.getText();
				
				SimpleEmail enviarEmail = new SimpleEmail();
				enviarEmail.setHostName("smtp.gmail.com"); 
				enviarEmail.setSmtpPort(465);
				enviarEmail.setAuthentication(emailLogado, senha);
				enviarEmail.setSSLOnConnect(true);
				//enviarEmail.setTLSOnConnect(true); <-- Se precisar
				//enviarEmail.setHostName("smtp-mail.outlook.com"); 
				//enviarEmail.setSmtpPort(587); //25
				enviarEmail.setFrom(emailLogado);
				enviarEmail.setSubject("SIG - "+usuarioEmailLogado);
				enviarEmail.setMsg(msg);
				enviarEmail.addTo(para);
				enviarEmail.send();
				JOptionPane.showMessageDialog(null, "Email Enviado com sucesso!");
				return "Success";
			}else {
				JOptionPane.showMessageDialog(null, "Erro.");
				return "Fail";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Email Inválido.");
			return "Fail";
		} catch (EmailException arg0) {
			arg0.printStackTrace();
			JOptionPane.showMessageDialog(null, "Email Inválido ou senha incorreta.\nVerifique se seu e-mail permite\no uso dele neste aplicativo.");
			return "Fail";
		}
	
	}
	
	public static String enviarEmailRecuperarSenha(String nome, String email) {
		ResultSet rs = CRUDUsuarios.selectCondicao2(nome, email);
		try {
			if(rs.next()) {
				SimpleEmail enviarEmail = new SimpleEmail();
				enviarEmail.setHostName("smtp.gmail.com");
				enviarEmail.setSmtpPort(465);
				enviarEmail.setAuthentication("tccsig0@gmail.com", "siganadiasribeirojere");
				enviarEmail.setSSLOnConnect(true);
				enviarEmail.setFrom("tccsig0@gmail.com");
				enviarEmail.setSubject("SIG - Recuperação de Senha");
				try {
					enviarEmail.setMsg("Recuperação de Senha\n"
						+ "Sua senha é: "+rs.getString("senha")
						+"\n\nNão responda a este email. email automático.\n"
						+ "SIG");
				} catch (SQLException e) {e.printStackTrace();}
				enviarEmail.addTo(email);
				enviarEmail.send();
				JOptionPane.showMessageDialog(null, "Um email contendo sua\nsenha foi enviado a \n"+email);
			}else {
				JOptionPane.showMessageDialog(null, nome+" ou "+email+"\nnão foi encontrado no banco.");
			}
			}catch(EmailException e){e.printStackTrace();
			}catch (SQLException e) {e.printStackTrace();}
	return "E-mail enviado com sucesso!";
	}
	
}
