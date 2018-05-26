package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class CadastrarUsuario {

	private JFrame frmCadastroUsu;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JTextField tfEmail;
	private JTextField tfFone;
	private JTextField tfCel;
	private JPasswordField pfConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuario window = new CadastrarUsuario();
					window.frmCadastroUsu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroUsu = new JFrame();
		frmCadastroUsu.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarUsuario.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroUsu.setTitle("SIG - Cadastro de Usuários");
		frmCadastroUsu.setResizable(false);
		frmCadastroUsu.setBounds(100, 100, 344, 290);
		frmCadastroUsu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroUsu.setLocationRelativeTo(null);
		frmCadastroUsu.getContentPane().setLayout(null);
		frmCadastroUsu.setFocusableWindowState(false);
		
		JLabel lblCadastroUsu = new JLabel("Cadastro de Usuários");
		lblCadastroUsu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroUsu.setBounds(10, 11, 149, 17);
		frmCadastroUsu.getContentPane().add(lblCadastroUsu);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setOpaque(false);
		pnlInfo.setBounds(10, 32, 319, 186);
		frmCadastroUsu.getContentPane().add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(10, 11, 49, 14);
		pnlInfo.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(69, 9, 228, 20);
		pnlInfo.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(10, 42, 42, 14);
		pnlInfo.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(62, 40, 228, 20);
		pnlInfo.add(pfSenha);
		
		JLabel lblConfirmar = new JLabel("Confirmar:");
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmar.setBounds(10, 73, 64, 14);
		pnlInfo.add(lblConfirmar);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(84, 71, 228, 20);
		pnlInfo.add(pfConfirmar);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 100, 35, 14);
		pnlInfo.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(55, 98, 228, 20);
		pnlInfo.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblFone = new JLabel("Fone:");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(10, 131, 35, 14);
		pnlInfo.add(lblFone);
		
		tfFone = new JTextField();
		tfFone.setBounds(55, 129, 228, 20);
		pnlInfo.add(tfFone);
		tfFone.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel:");
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(10, 162, 22, 14);
		pnlInfo.add(lblCel);
		
		tfCel = new JTextField();
		tfCel.setColumns(10);
		tfCel.setBounds(42, 160, 228, 20);
		pnlInfo.add(tfCel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFocusable(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setBounds(240, 222, 89, 23);
		btnSalvar.setBackground(new Color(0,73,170));
		frmCadastroUsu.getContentPane().add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCadastroUsu.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 222, 89, 23);
		frmCadastroUsu.getContentPane().add(btnVoltar);
		
		JButton button = new JButton("Salvar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(125, 222, 89, 23);
		frmCadastroUsu.getContentPane().add(button);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(338, 261, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 338, 261);
		frmCadastroUsu.getContentPane().add(lblBG);
	}
}
