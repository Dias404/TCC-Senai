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
import java.awt.Insets;

import javax.swing.JTextField;

import CRUD.CRUDLugar;
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
import javax.swing.JComboBox;
import java.awt.Window.Type;

public class Login {

	private JFrame frmLogin;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	
	public String user;
	public String senha;
	private JLabel lblErro1;
	private JLabel lblRecuperarSenha_1;
	private JLabel lblErro2;

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
		frmLogin.setType(Type.UTILITY);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Img/SIG 16x16.png")));
		frmLogin.setResizable(false);
		frmLogin.setTitle("SIG - Login");
		frmLogin.setBounds(100, 100, 518, 488);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(frmLogin);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/SIG 129.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 72, 492, 129);
		frmLogin.getContentPane().add(label);
		
		ImageIcon User = new ImageIcon(CadastrarUsuario.class.getResource("/Img/loginUsuario.png"));
		Image User2 = User.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		User = new ImageIcon(User2);
		
		JLabel lblUser = new JLabel("");
		lblUser.setIcon(User);
		lblUser.setBounds(112, 245, 30, 30);
		frmLogin.getContentPane().add(lblUser);
		
		ImageIcon Senha = new ImageIcon(CadastrarUsuario.class.getResource("/Img/loginSenha.png"));
		Image Senha2 = Senha.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		Senha = new ImageIcon(Senha2);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(Senha);
		lblSenha.setBounds(112, 278, 30, 30);
		frmLogin.getContentPane().add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setForeground(Color.LIGHT_GRAY);
		tfUsuario.setText("Usuário");
		tfUsuario.setBorder(new LineBorder(new Color(0, 73, 170)));
		tfUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (tfUsuario.getText().toString().equals("Usuário")) {
					tfUsuario.setText(null);
					tfUsuario.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfUsuario.getText().toString().isEmpty()) {
					tfUsuario.setText("Usuário");
					tfUsuario.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		
		tfUsuario.setBounds(142, 245, 260, 30);
		frmLogin.getContentPane().add(tfUsuario);
		
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
		pfSenha.setBounds(142, 278, 260, 30);
		frmLogin.getContentPane().add(pfSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErro1.setVisible(false);
				lblErro2.setVisible(false);
				btnEntrar.setLocation(298, 319);
				lblRecuperarSenha_1.setLocation(298, 360);
				
				int x = 0;
				user = tfUsuario.getText().toString();
				senha = pfSenha.getText().toString();
				ResultSet verifica = CRUDUsuarios.selectUsuarios();
				try {
					while(verifica.next()) {
						if (tfUsuario.getText().toString().isEmpty() || tfUsuario.getText().toString().equals("Usuário")) {
							lblErro2.setVisible(true);
							btnEntrar.setLocation(112, 345);
							lblRecuperarSenha_1.setLocation(298, 386);
							
							pfSenha.setText(null);
							x=1;
							break;
						}else {
							CRUDUsuarios select = new CRUDUsuarios();
							select.selectCondicao1(user, senha);
							if(select.dadosLogin.next() && x ==0) {
								btnEntrar.setLocation(112, 319);
								lblRecuperarSenha_1.setLocation(298, 360);
								
								JOptionPane.showMessageDialog(frmLogin, "Bem-vindo "+user);
								TelaPrincipal.usuario = user;
								TelaPrincipal.senha = senha;
								TelaPrincipal.main(null);
								CRUDUsuarios.login(user, senha);
								frmLogin.dispose();
							}else if(x==0){
								lblErro1.setVisible(true);
								btnEntrar.setLocation(112, 360);
								lblRecuperarSenha_1.setLocation(298, 401);
								
								
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
		btnEntrar.setBounds(112, 319, 290, 30);
		frmLogin.getContentPane().add(btnEntrar);
		
		lblRecuperarSenha_1 = new JLabel("Recuperar Senha");
		lblRecuperarSenha_1.setForeground(new Color(0, 73, 170));
		lblRecuperarSenha_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblRecuperarSenha_1.setText("<html><u>Recuperar Senha<u/></html>");
				lblRecuperarSenha_1.setForeground(new Color(255, 255, 0));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				JLabel lblRecuperarSenha = new JLabel("Recuperar Senha");
				lblRecuperarSenha.setForeground(new Color(0, 73, 170));
				
				String nome = JOptionPane.showInputDialog("Entre com o nome do usuário cadastrado.");
				if ((nome == null) || (nome.trim().isEmpty())) {
					return;
				}
				
				String email = JOptionPane.showInputDialog("Entre com o email cadastrado neste usuário.");
				if (email == null) {
					return;
				} else {
					if (email.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Usuário e(ou) Email inválido(s)");
					} else {
						Email.enviarEmailRecuperarSenha(nome.trim(), email);
						nome = null;
						email = null;
					}
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRecuperarSenha_1.setText("Recuperar Senha");
				lblRecuperarSenha_1.setForeground(new Color(0, 73, 170));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRecuperarSenha_1.setText("<html><u>Recuperar Senha<u/></html>");
				lblRecuperarSenha_1.setForeground(new Color(0, 0, 102));
			}
		});
		lblRecuperarSenha_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRecuperarSenha_1.setBounds(298, 360, 104, 15);
		frmLogin.getContentPane().add(lblRecuperarSenha_1);
		
		lblErro1 = new JLabel("<html>Usuário ou senha incorretos. Por favor, tente<br>novamente</html>");
		lblErro1.setVisible(false);
		lblErro1.setForeground(Color.decode("#dd0000"));
		lblErro1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErro1.setBounds(112, 319, 290, 30);
		frmLogin.getContentPane().add(lblErro1);
		
		lblErro2 = new JLabel("O preencha os campos primeiro!");
		lblErro2.setVisible(false);
		lblErro2.setBackground(new Color(51, 204, 102));
		lblErro2.setForeground(Color.decode("#dd0000"));
		lblErro2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErro2.setBounds(112, 319, 290, 15);
		frmLogin.getContentPane().add(lblErro2);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundPrincipal.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(512, 464, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 512, 464);
		frmLogin.getContentPane().add(lblBG);
	}
}
