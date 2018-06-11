package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Img/SIG 16x16.png")));
		frmLogin.setResizable(false);
		frmLogin.setTitle("SIG - Login");
		frmLogin.setBounds(100, 100, 351, 153);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(frmLogin);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(10, 11, 38, 17);
		frmLogin.getContentPane().add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(10, 39, 49, 14);
		frmLogin.getContentPane().add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(69, 37, 187, 20);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(10, 70, 42, 14);
		frmLogin.getContentPane().add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(62, 68, 194, 20);
		frmLogin.getContentPane().add(pfSenha);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
			}
		});
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnFechar.setFocusable(false);
		btnFechar.setBackground(new Color(0, 73, 170));
		btnFechar.setBounds(10, 95, 89, 23);
		frmLogin.getContentPane().add(btnFechar);
		
		JButton btnRecuperarSenha = new JButton("Recuperar Senha");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane.showInputDialog("Entre com um email cadastrado.");
			}
		});
		btnRecuperarSenha.setForeground(Color.WHITE);
		btnRecuperarSenha.setFont(new Font("Impact", Font.PLAIN, 13));
		btnRecuperarSenha.setFocusable(false);
		btnRecuperarSenha.setBackground(new Color(0, 73, 170));
		btnRecuperarSenha.setBounds(109, 95, 127, 23);
		frmLogin.getContentPane().add(btnRecuperarSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnEntrar.setFocusable(false);
		btnEntrar.setBackground(new Color(0, 73, 170));
		btnEntrar.setBounds(246, 95, 89, 23);
		frmLogin.getContentPane().add(btnEntrar);
		
		JLabel lblOuEmail = new JLabel("ou Email");
		lblOuEmail.setBounds(266, 40, 69, 14);
		frmLogin.getContentPane().add(lblOuEmail);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(Login.class.getResource("/backgroundPrincipal.jpg")));
		lblBG.setBounds(0, 0, 346, 127);
		frmLogin.getContentPane().add(lblBG);
	}
}
