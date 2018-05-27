package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Telas.TelaPrincipal;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

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
		frmCadastroUsu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaPrincipal.frmPrincipal.setEnabled(true);
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmCadastroUsu.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarUsuario.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroUsu.setTitle("SIG - Cadastro de Usuários");
		frmCadastroUsu.setResizable(false);
		frmCadastroUsu.setBounds(100, 100, 326, 290);
		frmCadastroUsu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroUsu.setLocationRelativeTo(TelaPrincipal.frmPrincipal);
		frmCadastroUsu.getContentPane().setLayout(null);
		
		JLabel lblCadastroUsu = new JLabel("Cadastro de Usuários");
		lblCadastroUsu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroUsu.setBounds(10, 11, 149, 17);
		frmCadastroUsu.getContentPane().add(lblCadastroUsu);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setOpaque(false);
		pnlInfo.setBounds(0, 32, 309, 186);
		frmCadastroUsu.getContentPane().add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(10, 11, 49, 14);
		pnlInfo.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(69, 9, 243, 20);
		pnlInfo.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(17, 42, 42, 14);
		pnlInfo.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(69, 40, 243, 20);
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
		lblEmail.setBounds(10, 104, 35, 14);
		pnlInfo.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(55, 102, 257, 20);
		pnlInfo.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblFone = new JLabel("Fone:");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(10, 135, 35, 14);
		pnlInfo.add(lblFone);
		
		tfFone = new JTextField();
		tfFone.setBounds(55, 133, 257, 20);
		pnlInfo.add(tfFone);
		tfFone.setColumns(10);
		
		JLabel lblCel = new JLabel("Cel:");
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(23, 166, 22, 14);
		pnlInfo.add(lblCel);
		
		tfCel = new JTextField();
		tfCel.setColumns(10);
		tfCel.setBounds(55, 164, 257, 20);
		pnlInfo.add(tfCel);
		
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
		btnVoltar.setBounds(10, 229, 89, 23);
		frmCadastroUsu.getContentPane().add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(tfUsuario.getText().isEmpty() && pfSenha.getText().isEmpty() && pfConfirmar.getText().isEmpty() && 
				tfEmail.getText().isEmpty() && tfFone.getText().isEmpty() && tfCel.getText().isEmpty())) {
					tfUsuario.setText(null);
					pfSenha.setText(null);
					pfConfirmar.setText(null);
					tfEmail.setText(null);
					tfFone.setText(null);
					tfCel.setText(null);
					JOptionPane.showMessageDialog(null, "Os campos foram esvaziados!");
				}else {
					JOptionPane.showMessageDialog(null, "Os campos já estão vazios!");
				}
				
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(115, 229, 89, 23);
		frmCadastroUsu.getContentPane().add(btnLimpar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(320, 261, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFocusable(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setBounds(220, 229, 89, 23);
		btnSalvar.setBackground(new Color(0,73,170));
		frmCadastroUsu.getContentPane().add(btnSalvar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 320, 261);
		frmCadastroUsu.getContentPane().add(lblBG);
	}
}
