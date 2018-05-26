package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CadastrarUsuario {

	private JFrame frmCadastroUsu;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JTextField tfEmail;
	private JTextField tfFone;
	private JTextField tfCel;

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
		frmCadastroUsu.setBounds(100, 100, 336, 233);
		frmCadastroUsu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroUsu.setLocationRelativeTo(null);
		frmCadastroUsu.getContentPane().setLayout(null);
		
		JLabel lblCadastroUsu = new JLabel("Cadastro de Usuários");
		lblCadastroUsu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroUsu.setBounds(10, 11, 149, 17);
		frmCadastroUsu.getContentPane().add(lblCadastroUsu);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setOpaque(false);
		pnlInfo.setBounds(10, 32, 308, 162);
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
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 73, 35, 14);
		pnlInfo.add(lblNewLabel);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(55, 71, 228, 20);
		pnlInfo.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblFone = new JLabel("Fone:");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(10, 104, 35, 14);
		pnlInfo.add(lblFone);
		
		tfFone = new JTextField();
		tfFone.setBounds(55, 102, 228, 20);
		pnlInfo.add(tfFone);
		tfFone.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel:");
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(10, 135, 22, 14);
		pnlInfo.add(lblCel);
		
		tfCel = new JTextField();
		tfCel.setColumns(10);
		tfCel.setBounds(42, 133, 228, 20);
		pnlInfo.add(tfCel);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg")));
		lblBG.setBounds(0, 0, 486, 317);
		frmCadastroUsu.getContentPane().add(lblBG);
	}
}
