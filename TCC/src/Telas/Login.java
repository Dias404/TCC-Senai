package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

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

import Administrador.CadastrarUsuario;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

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
		frmLogin.setBounds(100, 100, 596, 525);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(frmLogin);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(140, 150, 30, 30);
		frmLogin.getContentPane().add(lblUser);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setBounds(140, 179, 30, 30);
		frmLogin.getContentPane().add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBorder(new LineBorder(new Color(0, 73, 170)));
		tfUsuario.setText("ASDFASDF");
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
		tfUsuario.setBounds(170, 150, 270, 30);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBorder(new LineBorder(new Color(0, 73, 170)));
		pfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
		pfSenha.setBounds(170, 179, 270, 30);
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
		btnFechar.setBounds(10, 368, 79, 23);
		frmLogin.getContentPane().add(btnFechar);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = 0;
				user = tfUsuario.getText().toString();
				senha = pfSenha.getText().toString();
				ResultSet verifica = CRUDUsuarios.selectUsuarios();
				try {
					while(verifica.next()) {
						if (tfUsuario.getText().toString().isEmpty() || tfUsuario.getText().toString().equals("Ou E-mail")) {
							JOptionPane.showMessageDialog(null, "Campo usuário vazio!");
							pfSenha.setText(null);
							x=1;
							break;
						}else {
							ResultSet rs = CRUDUsuarios.selectCondicao1(user, senha);
							if(rs.next() && x ==0) {
								JOptionPane.showMessageDialog(frmLogin, "Bem-vindo "+user);
								TelaPrincipal.usuario = user;
								TelaPrincipal.senha = senha;
								TelaPrincipal.main(null);
								CRUDUsuarios.login(user, senha);
								frmLogin.dispose();
							}else if(x==0){
								JOptionPane.showMessageDialog(frmLogin, "Senha ou(e) Usuário Incorreto(s)!");
								tfUsuario.setText(null);
								pfSenha.setText(null);
							}
						break;
						}	
					}
				} catch (HeadlessException e1) {e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frmLogin, "Ocorreu um erro ao logar!");
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
		btnEntrar.setBounds(140, 220, 300, 30);
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
		lblRecuperarSenha.setBounds(336, 261, 104, 15);
		frmLogin.getContentPane().add(lblRecuperarSenha);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundPrincipal.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(702, 506, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 590, 497);
		frmLogin.getContentPane().add(lblBG);
	}
}
