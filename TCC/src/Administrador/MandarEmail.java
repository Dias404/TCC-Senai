package Administrador;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import Telas.TelaPrincipal;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MandarEmail {

	private JFrame frmMandarEmail;
	private JComboBox cbEmail;
	private JEditorPane epMsg;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MandarEmail window = new MandarEmail();
					window.frmMandarEmail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MandarEmail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(550, 397, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		frmMandarEmail = new JFrame();
		frmMandarEmail.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaPrincipal.frmPrincipal.setEnabled(true);
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmMandarEmail.setIconImage(Toolkit.getDefaultToolkit().getImage(MandarEmail.class.getResource("/Img/SIG 16x16.png")));
		frmMandarEmail.setTitle("SIG - Mandar E-mail");
		frmMandarEmail.setBounds(100, 100, 550, 425);
		frmMandarEmail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMandarEmail.setResizable(false);
		frmMandarEmail.setLocationRelativeTo(null);
		frmMandarEmail.getContentPane().setLayout(null);
		
		JLabel lblMandarEmail = new JLabel("Mandar E-mail");
		lblMandarEmail.setBounds(10, 11, 125, 17);
		lblMandarEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMandarEmail.getContentPane().add(lblMandarEmail);
		
		JButton btnMandar = new JButton("Mandar");
		btnMandar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enviarEmail();
			}
		});
		btnMandar.setBounds(445, 363, 89, 23);
		frmMandarEmail.getContentPane().add(btnMandar);
		btnMandar.setForeground(Color.WHITE);
		btnMandar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnMandar.setFocusable(false);
		btnMandar.setBackground(new Color(0, 73, 170));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMandarEmail.dispose();
				
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 363, 89, 23);
		frmMandarEmail.getContentPane().add(btnVoltar);
		
		JPanel pnEmail = new JPanel();
		pnEmail.setOpaque(false);
		pnEmail.setBounds(10, 39, 524, 319);
		frmMandarEmail.getContentPane().add(pnEmail);
		pnEmail.setLayout(null);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPara.setBounds(10, 11, 31, 14);
		pnEmail.add(lblPara);
		
		cbEmail = new JComboBox();
		cbEmail.setBounds(51, 9, 313, 20);
		pnEmail.add(cbEmail);
		cbEmail.addItem("carol.dragneel14@gmail.com");
		
		epMsg = new JEditorPane();
		epMsg.setBorder(new LineBorder(Color.decode("#0049aa"), 2));
		epMsg.setBounds(10, 36, 504, 272);
		pnEmail.add(epMsg);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 544, 397);
		frmMandarEmail.getContentPane().add(lblBG);
	}
	
	public String enviarEmail() {
		String para = cbEmail.getSelectedItem().toString();
		
		String emailLogado = "projetojavasenai@gmail.com";
		String senhaEmailLogado = "senai123";
		String usuarioEmailLogado = "Jão";
		String msg = epMsg.getText();
		
		try {
			SimpleEmail enviarEmail = new SimpleEmail();
			if(para.contains("@gmail.com")) { // para gmail
				enviarEmail.setHostName("smtp.gmail.com"); 
				enviarEmail.setSmtpPort(465);
			}if(para.contains("@hotmail.com") || para.contains("@outlook.com")) { // para hotmail
				enviarEmail.setHostName("smtp-mail.outlook.com"); 
				enviarEmail.setSmtpPort(587);
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
			// TODO Auto-generated catch block
			arg0.printStackTrace();
			JOptionPane.showMessageDialog(null, "Email Inválido");
			return "Fail";
		}
		
	}
	
}
