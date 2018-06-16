package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;

import CRUD.CRUDUsuarios;
import Email.Email;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	
	public String user;
	public String senha;

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
		frmLogin.setBounds(100, 100, 396, 159);
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
		/*
		tfUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (tfUsuario.getText().toString().equals("Ou E-mail")) {
					tfUsuario.setText(null);
					tfUsuario.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfUsuario.getText().toString().isEmpty()) {
					tfUsuario.setText("Ou E-mail");
					tfUsuario.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		*/
		tfUsuario.setBounds(69, 37, 308, 20);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(10, 70, 49, 14);
		frmLogin.getContentPane().add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
		pfSenha.setBounds(69, 68, 148, 20);
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
		btnFechar.setBounds(10, 95, 79, 23);
		frmLogin.getContentPane().add(btnFechar);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = 0;
				user = tfUsuario.getText().toString();
				senha = pfSenha.getText().toString();
				ResultSet verifica = CRUDUsuarios.selectUsuarioLogado();
				try {
					if (tfUsuario.getText().toString().isEmpty() || tfUsuario.getText().toString().equals("Ou E-mail")) {
						JOptionPane.showMessageDialog(null, "Campo usuário vazio!");
						pfSenha.setText(null);
						x=1;
					}
					if(verifica.next() && x ==0) {
						JOptionPane.showMessageDialog(frmLogin, "Já existe um usuário logado!");
					}else {
						ResultSet rs = CRUDUsuarios.selectCondicao1(user, senha);
						if(rs.next() && x ==0) {
							CRUDUsuarios.login(user, senha);
							JOptionPane.showMessageDialog(frmLogin, "Bem-vindo "+user);
							TelaPrincipal.usuario = user;
							TelaPrincipal.senha = senha;
							TelaPrincipal.main(null);
							frmLogin.dispose();
						}else if(x==0){
							JOptionPane.showMessageDialog(frmLogin, "Senha ou(e) Usuário Incorreto(s)!");
							tfUsuario.setText(null);
							pfSenha.setText(null);
						}
					}
				} catch (HeadlessException e1) {e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frmLogin, "An error has occured while logging in!");
					tfUsuario.setText(null);
					pfSenha.setText(null);
				}
				x=0;
			}
		});
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnEntrar.setFocusable(false);
		btnEntrar.setBackground(new Color(0, 73, 170));
		btnEntrar.setBounds(298, 95, 79, 23);
		frmLogin.getContentPane().add(btnEntrar);
		
		JLabel lblRecuperarSenha = new JLabel("Recuperar Senha");
		lblRecuperarSenha.setForeground(new Color(0, 73, 170));
		lblRecuperarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblRecuperarSenha.setText("<html><u>Recuperar Senha<u/></html>");
				lblRecuperarSenha.setForeground(new Color(255, 255, 0));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				JLabel lblRecuperarSenha = new JLabel("Recuperar Senha");
				lblRecuperarSenha.setForeground(new Color(0, 73, 170));
				String nome = JOptionPane.showInputDialog("Entre com o nome do usuário cadastrado.");
				String email = JOptionPane.showInputDialog("Entre com o email cadastrado neste usuário.");
				if(nome.isEmpty() || email.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Usuário e(ou) Email inválido(s)");
				}else {
					Email.enviarEmailRecuperarSenha(nome, email);
					nome = null;
					email = null;
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRecuperarSenha.setText("Recuperar Senha");
				lblRecuperarSenha.setForeground(new Color(0, 73, 170));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRecuperarSenha.setText("<html><u>Recuperar Senha<u/></html>");
				lblRecuperarSenha.setForeground(new Color(0, 0, 102));
			}
		});
		lblRecuperarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRecuperarSenha.setBounds(227, 68, 104, 15);
		frmLogin.getContentPane().add(lblRecuperarSenha);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(Login.class.getResource("/backgroundPrincipal.jpg")));
		lblBG.setBounds(0, 0, 390, 130);
		frmLogin.getContentPane().add(lblBG);
	}
}
