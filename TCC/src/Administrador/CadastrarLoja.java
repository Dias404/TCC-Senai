package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import CRUD.CRUDClientes;
import CRUD.CRUDLojas;
import CRUD.CRUDLugar;
import CRUD.CRUDUsuarios;
import DAO.Lojas;
import DAO.Lugar;
import DAO.Usuarios;
import Telas.TelaPrincipal;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CadastrarLoja {

	public static JFrame frmCadastrarLoja;
	private JFormattedTextField ftfCNPJ;
	private JFormattedTextField ftfIE;
	private JTextField tfNumero;
	private JTextField tfTel1;
	private static JComboBox comboUF;
	private JLabel lblBG;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JPanel panel;
	private static JTextField tfRazao;
	private JTextField tfTel2;
	private JTextField tfCel1;
	private JTextField tfCel2;
	private JTextField tfBairro;
	private JTextField tfRua;
	private JTextField tfCidade;
	
	private static int idUF;
	private static int idCidade;
	private static ResultSet backupCidade = null;
	
	private MaskFormatter mascaraCNPJ;
	private MaskFormatter mascaraIE;
	
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
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraIE = new MaskFormatter("###.###.###.###");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmCadastrarLoja = new JFrame();
		frmCadastrarLoja.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarLoja.class.getResource("/Img/SIG 16x16.png")));
		frmCadastrarLoja.setTitle("SIG - Cadastrar Loja");
		frmCadastrarLoja.setResizable(false);
		frmCadastrarLoja.setBounds(100, 100, 548, 343);
		frmCadastrarLoja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastrarLoja.getContentPane().setLayout(null);
		frmCadastrarLoja.setLocationRelativeTo(TelaPrincipal.frmPrincipal);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, new Color(64, 64, 64)));
		panel.setBounds(10, 39, 522, 229);
		frmCadastrarLoja.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIE = new JLabel("IE:");
		lblIE.setBounds(262, 135, 38, 14);
		panel.add(lblIE);
		lblIE.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIE.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ftfIE = new JFormattedTextField(mascaraIE);
		ftfIE.setBounds(310, 133, 200, 20);
		panel.add(ftfIE);
		ftfIE.setColumns(10);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(13, 135, 35, 14);
		panel.add(lblCNPJ);
		lblCNPJ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNPJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ftfCNPJ = new JFormattedTextField(mascaraCNPJ);
		ftfCNPJ.setBounds(58, 133, 200, 20);
		panel.add(ftfCNPJ);
		ftfCNPJ.setColumns(10);
		
		JLabel lblNome = new JLabel("Razão Social:");
		lblNome.setBounds(10, 13, 82, 14);
		panel.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(10, 44, 38, 14);
		panel.add(lblUf);
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		comboUF = new JComboBox();
		comboUF.setBounds(58, 42, 163, 20);
		panel.add(comboUF);
		comboUF.setSelectedItem("São Paulo");
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 74, 40, 14);
		panel.add(lblBairro);
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(249, 44, 51, 14);
		panel.add(lblCidade);
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 104, 38, 14);
		panel.add(lblRua);
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNum = new JLabel("N°:");
		lblNum.setBounds(238, 104, 62, 14);
		panel.add(lblNum);
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfNumero = new JTextField();
		tfNumero.setBounds(310, 102, 200, 20);
		panel.add(tfNumero);
		tfNumero.setColumns(10);
		
		tfRazao = new JTextField();
		tfRazao.setColumns(10);
		tfRazao.setBounds(102, 11, 410, 20);
		panel.add(tfRazao);
		
		JLabel lblTel = new JLabel("Tel 1:");
		lblTel.setBounds(13, 166, 35, 14);
		panel.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfTel1 = new JTextField();
		tfTel1.setBounds(57, 164, 201, 20);
		panel.add(tfTel1);
		tfTel1.setColumns(10);
		
		JLabel lblTel2 = new JLabel("Tel 2:");
		lblTel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel2.setBounds(13, 198, 35, 14);
		panel.add(lblTel2);
		
		tfTel2 = new JTextField();
		tfTel2.setColumns(10);
		tfTel2.setBounds(57, 195, 201, 20);
		panel.add(tfTel2);
		
		JLabel lblCel1 = new JLabel("Cel 1:");
		lblCel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel1.setBounds(265, 167, 35, 14);
		panel.add(lblCel1);
		
		tfCel1 = new JTextField();
		tfCel1.setColumns(10);
		tfCel1.setBounds(310, 164, 201, 20);
		panel.add(tfCel1);
		
		JLabel lblCel2 = new JLabel("Cel 2:");
		lblCel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel2.setBounds(265, 198, 35, 14);
		panel.add(lblCel2);
		
		tfCel2 = new JTextField();
		tfCel2.setColumns(10);
		tfCel2.setBounds(310, 195, 201, 20);
		panel.add(tfCel2);
		
		JLabel lblCadastroLoja = new JLabel("Cadastro de Lojas");
		lblCadastroLoja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroLoja.setBounds(10, 11, 125, 17);
		frmCadastrarLoja.getContentPane().add(lblCadastroLoja);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.frmPrincipal.setVisible(true);
				frmCadastrarLoja.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 279, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnVoltar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfRazao.setText(null);
				tfNumero.setText(null);
				ftfCNPJ.setValue(null);
				ftfIE.setValue(null);
				tfTel1.setText(null);
				tfTel2.setText(null);
				tfCel1.setText(null);
				tfCel2.setText(null);
				
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(344, 279, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String razaoSocial = tfRazao.getText().toString();
				String estado = comboUF.getSelectedItem().toString();
				String cidade = tfCidade.getText().toString();
				String bairro = tfBairro.getText().toString();
				String rua = tfRua.getText().toString();
				String numero = tfNumero.getText().trim().toString();
				String cnpj = ftfCNPJ.getText().toString();
				String ie = ftfIE.getText().toString();
				String tel1 = tfTel1.getText().toString();
				String tel2 = tfTel2.getText().toString();
				String cel1 = tfCel1.getText().toString();
				String cel2 = tfCel2.getText().toString();
				
				if(razaoSocial.trim().isEmpty() || cidade.trim().isEmpty() || bairro.trim().isEmpty() || rua.trim().isEmpty() || numero.trim().isEmpty() || cnpj.trim().isEmpty() || ie.trim().isEmpty()) {
					JOptionPane.showMessageDialog(frmCadastrarLoja, "Existe um campo vazio!");
				} else {
					if (tel1.trim().isEmpty() && tel2.trim().isEmpty() && cel1.trim().isEmpty() && cel2.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "É necessário preencher no mínimo um campo de contato!",null, JOptionPane.WARNING_MESSAGE);
					} else {
						Lojas loja = new Lojas();
						loja.setRazao(razaoSocial);
						loja.setEstado(estado);
						loja.setCidade(cidade);
						loja.setBairro(bairro);
						loja.setRua(rua);
						loja.setNumero(numero);
						loja.setCnpj(cnpj);
						loja.setIe(ie);
						loja.setTel1(tel1);
						loja.setTel2(tel2);
						loja.setCel1(cel1);
						loja.setCel2(cel2);
						
						CRUDLojas insert = new CRUDLojas();
						insert.insertLoja(loja);
						JOptionPane.showMessageDialog(null, "A Loja foi cadastrada!");
						btnLimpar.doClick();
					}
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(443, 279, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnSalvar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(542, 315, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 542, 315);
		frmCadastrarLoja.getContentPane().add(lblBG);
		
		preencherComboUF();
		comboUF.setSelectedItem("São Paulo");
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(58, 72, 200, 20);
		panel.add(tfBairro);
		
		tfRua = new JTextField();
		tfRua.setColumns(10);
		tfRua.setBounds(58, 102, 200, 20);
		panel.add(tfRua);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(310, 42, 200, 20);
		panel.add(tfCidade);
	}
	
	private boolean preencherComboUF() {
		CRUDLugar selecionar = new CRUDLugar();
		selecionar.selectEstados();
		comboUF.removeAllItems();
		try {
			while (selecionar.dados.next()) {
				comboUF.addItem(selecionar.dados.getString("nome_estado"));
			}
			//UF = selecionar.dadosSelect;
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*public static boolean preencherComboCidade() {
		idUF = comboUF.getSelectedIndex()+1;
		CRUDLugar select = new CRUDLugar();
		select.selectCidadeCondicao2(idUF);
		backupCidade = select.dadosSelect;
		try {
			while (select.dadosSelect.next()) {
				comboCidade.addItem(select.dadosSelect.getString("nome_cidade"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void preencherComboBairro() {
		CRUDLugar select = new CRUDLugar();
		select.selectBairroCondicao2(idCidade, idUF);
		
		
		ResultSet idCidade = CRUDLugar.selectCidadeCondicao1(comboCidade.getSelectedItem().toString(), comboUF.getSelectedIndex()+1);
		try {
			ResultSet dados = CRUDLugar.selectBairroCondicao2(idCidade.getInt("id_cidade"));
			comboBairro.removeAllItems();
			if(dados.first()) {
				while (dados.next()) {
					comboBairro.addItem(dados.getString("nome_bairro"));
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean preencherComboRua() {
		ResultSet selecionar = new CRUDLugar().selectRua(idCidade);
		try {
			comboRua.removeAllItems();
			if(selecionar.first()) {
				while (selecionar.next()) {
					comboRua.addItem(selecionar.getString("nome_rua"));
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}*/
}
