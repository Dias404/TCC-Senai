package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Telas.TelaPrincipal;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CadastrarLoja {

	private JFrame frmCadastrarLoja;
	private JTextField tfNome;
	private JTextField tfCNPJ;
	private JTextField tfIE;
	private JTextField tfNum;
	private JTextField tfTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLoja window = new CadastrarLoja();
					window.frmCadastrarLoja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarLoja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarLoja = new JFrame();
		frmCadastrarLoja.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaPrincipal.frmPrincipal.setEnabled(true);
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmCadastrarLoja.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarLoja.class.getResource("/Img/SIG 16x16.png")));
		frmCadastrarLoja.setTitle("SIG - Cadastrar Loja");
		frmCadastrarLoja.setResizable(false);
		frmCadastrarLoja.setBounds(100, 100, 437, 307);
		frmCadastrarLoja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarLoja.getContentPane().setLayout(null);
		frmCadastrarLoja.setLocationRelativeTo(TelaPrincipal.frmPrincipal);
		
		JLabel lblCadastroLoja = new JLabel("Cadastro de Lojas");
		lblCadastroLoja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroLoja.setBounds(10, 11, 125, 17);
		frmCadastrarLoja.getContentPane().add(lblCadastroLoja);
		
		JLabel lblIE = new JLabel("IE:");
		lblIE.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIE.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIE.setBounds(10, 189, 38, 14);
		frmCadastrarLoja.getContentPane().add(lblIE);
		
		tfIE = new JTextField();
		tfIE.setColumns(10);
		tfIE.setBounds(58, 187, 200, 20);
		frmCadastrarLoja.getContentPane().add(tfIE);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNPJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCNPJ.setBounds(171, 164, 38, 14);
		frmCadastrarLoja.getContentPane().add(lblCNPJ);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(219, 162, 200, 20);
		frmCadastrarLoja.getContentPane().add(tfCNPJ);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 39, 38, 14);
		frmCadastrarLoja.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(58, 37, 221, 20);
		frmCadastrarLoja.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(10, 64, 38, 14);
		frmCadastrarLoja.getContentPane().add(lblUf);
		
		JComboBox cbUF = new JComboBox();
		cbUF.setBounds(58, 62, 163, 20);
		cbUF.setModel(new DefaultComboBoxModel(new String[] {"", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		frmCadastrarLoja.getContentPane().add(cbUF);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setBounds(10, 114, 40, 14);
		frmCadastrarLoja.getContentPane().add(lblBairro);
		
		JComboBox cbBairro = new JComboBox();
		cbBairro.setBounds(58, 112, 232, 19);
		frmCadastrarLoja.getContentPane().add(cbBairro);
		
		JButton btnAddBairro = new JButton("...");
		btnAddBairro.setForeground(Color.WHITE);
		btnAddBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBairro.setFocusable(false);
		btnAddBairro.setBackground(new Color(0, 73, 170));
		btnAddBairro.setBounds(300, 109, 27, 23);
		frmCadastrarLoja.getContentPane().add(btnAddBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(10, 89, 51, 14);
		frmCadastrarLoja.getContentPane().add(lblCidade);
		
		JComboBox cbCidade = new JComboBox();
		cbCidade.setBounds(71, 87, 163, 19);
		frmCadastrarLoja.getContentPane().add(cbCidade);
		
		JButton btnAddCidade = new JButton("...");
		btnAddCidade.setForeground(Color.WHITE);
		btnAddCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddCidade.setFocusable(false);
		btnAddCidade.setBackground(new Color(0, 73, 170));
		btnAddCidade.setBounds(244, 85, 27, 23);
		frmCadastrarLoja.getContentPane().add(btnAddCidade);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRua.setBounds(10, 139, 38, 14);
		frmCadastrarLoja.getContentPane().add(lblRua);
		
		JComboBox cbRua = new JComboBox();
		cbRua.setBounds(71, 137, 232, 19);
		frmCadastrarLoja.getContentPane().add(cbRua);
		
		JButton btnAddRua = new JButton("...");
		btnAddRua.setForeground(Color.WHITE);
		btnAddRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddRua.setFocusable(false);
		btnAddRua.setBackground(new Color(0, 73, 170));
		btnAddRua.setBounds(313, 135, 27, 23);
		frmCadastrarLoja.getContentPane().add(btnAddRua);
		
		JLabel lblNum = new JLabel("N°:");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNum.setBounds(10, 164, 38, 14);
		frmCadastrarLoja.getContentPane().add(lblNum);
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		tfNum.setBounds(58, 162, 103, 20);
		frmCadastrarLoja.getContentPane().add(tfNum);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel.setBounds(20, 214, 28, 14);
		frmCadastrarLoja.getContentPane().add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(58, 212, 200, 20);
		frmCadastrarLoja.getContentPane().add(tfTel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastrarLoja.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 246, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfNome.setText(null);
				cbUF.setSelectedIndex(0);
				cbCidade.setSelectedIndex(0);
				cbBairro.setSelectedIndex(0);
				cbRua.setSelectedIndex(0);
				tfNum.setText(null);
				tfCNPJ.setText(null);
				tfIE.setText(null);
				tfTel.setText(null);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(231, 246, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(330, 246, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnSalvar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(431, 278, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 431, 278);
		frmCadastrarLoja.getContentPane().add(lblBG);
	}
}
