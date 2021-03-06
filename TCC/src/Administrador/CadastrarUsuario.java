package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;

import CRUD.CRUDUsuarios;
import DAO.Usuarios;
import Telas.TelaPrincipal;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class CadastrarUsuario {

	private JFrame frmCadastroUsu;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JTextField tfEmail;
	private JTextField tfFone;
	private JTextField tfCel;
	private JPasswordField pfConfirmar;
	private JRadioButton rbAutorizado;
	private JRadioButton rbBasico;
	private JRadioButton rbAdmin;

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
			public void windowClosing(WindowEvent e) {
				frmCadastroUsu.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmCadastroUsu.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarUsuario.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroUsu.setTitle("SIG - Cadastro de Usuários");
		frmCadastroUsu.setResizable(false);
		frmCadastroUsu.setBounds(100, 100, 593, 245);
		frmCadastroUsu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCadastroUsu.setLocationRelativeTo(TelaPrincipal.frmPrincipal);
		frmCadastroUsu.getContentPane().setLayout(null);
		int frmWidth = frmCadastroUsu.getWidth();
		int frmLength = frmCadastroUsu.getHeight();
		
		JLabel lblCadastroUsu = new JLabel("Cadastro de Usuários");
		lblCadastroUsu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroUsu.setBounds(10, 11, 149, 17);
		frmCadastroUsu.getContentPane().add(lblCadastroUsu);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		pnlInfo.setOpaque(false);
		pnlInfo.setBounds(10, 39, 567, 133);
		frmCadastroUsu.getContentPane().add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(25, 11, 49, 14);
		pnlInfo.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(84, 9, 195, 20);
		pnlInfo.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(32, 42, 42, 14);
		pnlInfo.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(84, 40, 195, 20);
		pnlInfo.add(pfSenha);
		
		JLabel lblConfirmar = new JLabel("Confirmar:");
		lblConfirmar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmar.setBounds(278, 42, 74, 14);
		pnlInfo.add(lblConfirmar);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(362, 40, 195, 20);
		pnlInfo.add(pfConfirmar);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(39, 73, 35, 14);
		pnlInfo.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(84, 71, 195, 20);
		pnlInfo.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(10, 104, 64, 14);
		pnlInfo.add(lblFone);
		
		tfFone = new JTextField();
		tfFone.setBounds(84, 102, 195, 20);
		pnlInfo.add(tfFone);
		tfFone.setColumns(10);
		
		JLabel lblCel = new JLabel("Celular:");
		lblCel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(301, 104, 51, 14);
		pnlInfo.add(lblCel);
		
		tfCel = new JTextField();
		tfCel.setColumns(10);
		tfCel.setBounds(362, 102, 195, 20);
		pnlInfo.add(tfCel);
		
		JLabel lblNivel = new JLabel("Nível:");
		lblNivel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNivel.setBounds(301, 11, 51, 14);
		pnlInfo.add(lblNivel);
		
		rbAutorizado = new JRadioButton("Autorizado");
		rbAutorizado.setOpaque(false);
		rbAutorizado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbAutorizado.setFocusable(false);
		rbAutorizado.setBackground(new Color(119, 136, 153));
		rbAutorizado.setBounds(419, 11, 83, 14);
		pnlInfo.add(rbAutorizado);
		
		rbBasico = new JRadioButton("Básico");
		rbBasico.setSelected(true);
		rbBasico.setOpaque(false);
		rbBasico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbBasico.setFocusable(false);
		rbBasico.setBackground(new Color(119, 136, 153));
		rbBasico.setBounds(358, 11, 59, 14);
		pnlInfo.add(rbBasico);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.frmPrincipal.setVisible(true);
				frmCadastroUsu.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 183, 89, 23);
		frmCadastroUsu.getContentPane().add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfUsuario.setText(null);
				pfSenha.setText(null);
				pfConfirmar.setText(null);
				tfEmail.setText(null);
				tfFone.setText(null);
				tfCel.setText(null);
				rbBasico.setSelected(true);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(389, 183, 89, 23);
		frmCadastroUsu.getContentPane().add(btnLimpar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(frmWidth, frmLength, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = tfUsuario.getText().toString();
				String senha = pfSenha.getText().toString();
				String email = tfEmail.getText().toString();
				
				String telefone = tfFone.getText().trim().toString();
				if (telefone.isEmpty()) {
					telefone = "-";
				}
				String celular = tfCel.getText().trim().toString();
				if (celular.isEmpty()) {
					celular = "-";
				}
				
				String nivel;
				if (rbBasico.isSelected()) {
					nivel = "Básico";
				} else {
					if (rbAutorizado.isSelected()) {
						nivel = "Autorizado";
					} else {
						nivel = "Admin";
					}
				}
				
				if(usuario.trim().isEmpty() || senha.trim().isEmpty() || email.trim().isEmpty() || telefone.trim().isEmpty() || celular.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
				} else {
					if (telefone.isEmpty() && celular.isEmpty()) {
						JOptionPane.showMessageDialog(null, "É necessário preencher no mínimo um campo de contato!",null, JOptionPane.WARNING_MESSAGE);
						} else {
							Usuarios u = new Usuarios();
							u.setNome(usuario);
							u.setSenha(senha);
							u.setEmail(email);
							u.setFone(telefone);
							u.setCel(celular);
							u.setNivel(nivel);
							
							CRUDUsuarios insert = new CRUDUsuarios();
							insert.insertUsuario(u);
							JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso!");
							btnLimpar.doClick();
						}
				}
			}
		});
		btnSalvar.setFocusable(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setBounds(488, 183, 89, 23);
		btnSalvar.setBackground(new Color(0,73,170));
		frmCadastroUsu.getContentPane().add(btnSalvar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 587, 217);
		frmCadastroUsu.getContentPane().add(lblBG);
		
		rbAdmin = new JRadioButton("Admin");
		rbAdmin.setOpaque(false);
		rbAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbAdmin.setFocusable(false);
		rbAdmin.setBackground(new Color(119, 136, 153));
		rbAdmin.setBounds(502, 11, 59, 14);
		pnlInfo.add(rbAdmin);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbAutorizado);
		grupo.add(rbBasico);
		grupo.add(rbAdmin);
	}
}
