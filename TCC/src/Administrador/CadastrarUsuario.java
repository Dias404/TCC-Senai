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
		frmCadastroUsu.setBounds(100, 100, 374, 329);
		frmCadastroUsu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		pnlInfo.setBounds(10, 39, 348, 221);
		frmCadastroUsu.getContentPane().add(pnlInfo);
		pnlInfo.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(25, 11, 49, 14);
		pnlInfo.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(84, 9, 254, 20);
		pnlInfo.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBounds(32, 42, 42, 14);
		pnlInfo.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(84, 40, 254, 20);
		pnlInfo.add(pfSenha);
		
		JLabel lblConfirmar = new JLabel("Confirmar:");
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmar.setBounds(10, 73, 64, 14);
		pnlInfo.add(lblConfirmar);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(84, 71, 254, 20);
		pnlInfo.add(pfConfirmar);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(39, 104, 35, 14);
		pnlInfo.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(84, 102, 254, 20);
		pnlInfo.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblFone = new JLabel("Telefone:");
		lblFone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFone.setBounds(10, 135, 64, 14);
		pnlInfo.add(lblFone);
		
		tfFone = new JTextField();
		tfFone.setBounds(84, 133, 254, 20);
		pnlInfo.add(tfFone);
		tfFone.setColumns(10);
		
		JLabel lblCel = new JLabel("Celular:");
		lblCel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(23, 166, 51, 14);
		pnlInfo.add(lblCel);
		
		tfCel = new JTextField();
		tfCel.setColumns(10);
		tfCel.setBounds(84, 164, 254, 20);
		pnlInfo.add(tfCel);
		
		ButtonGroup btnG = new ButtonGroup();
		
		JLabel lblNivel = new JLabel("Nível:");
		lblNivel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNivel.setBounds(23, 197, 51, 14);
		pnlInfo.add(lblNivel);
		
		rbAutorizado = new JRadioButton("Autorizado");
		rbAutorizado.setSelected(true);
		rbAutorizado.setOpaque(false);
		rbAutorizado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbAutorizado.setFocusable(false);
		rbAutorizado.setBackground(new Color(119, 136, 153));
		rbAutorizado.setBounds(84, 197, 83, 14);
		pnlInfo.add(rbAutorizado);
		
		rbBasico = new JRadioButton("Básico");
		rbBasico.setSelected(true);
		rbBasico.setOpaque(false);
		rbBasico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbBasico.setFocusable(false);
		rbBasico.setBackground(new Color(119, 136, 153));
		rbBasico.setBounds(169, 197, 64, 14);
		pnlInfo.add(rbBasico);
		
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
		btnVoltar.setBounds(10, 271, 89, 23);
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
		btnLimpar.setBounds(170, 271, 89, 23);
		frmCadastroUsu.getContentPane().add(btnLimpar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(frmWidth, frmLength, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!tfUsuario.getText().isEmpty()) && (!pfSenha.getText().isEmpty()) && (!tfEmail.getText().isEmpty())
				&& (pfSenha.getText().equals(pfConfirmar.getText()))) {
					CRUDUsuarios insert = new CRUDUsuarios();
					Usuarios u = new Usuarios();
					u.setNome(tfUsuario.getText().toString());
					u.setSenha(pfSenha.getText().toString());
					u.setEmail(tfEmail.getText().toString());
					u.setFone(tfFone.getText().toString());
					u.setCel(tfCel.getText().toString());
					if(rbAutorizado.isSelected()) {
						u.setNivel("Autorizado");
					}else {
						u.setNivel("Básico");
					}
					insert.insertUsuario(u);
					JOptionPane.showMessageDialog(null, "O Usuário foi cadastrado!");
					btnLimpar.doClick();
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Usuário!");
				}
			}
		});
		btnSalvar.setFocusable(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setBounds(269, 271, 89, 23);
		btnSalvar.setBackground(new Color(0,73,170));
		frmCadastroUsu.getContentPane().add(btnSalvar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 368, 301);
		frmCadastroUsu.getContentPane().add(lblBG);
	}
}
