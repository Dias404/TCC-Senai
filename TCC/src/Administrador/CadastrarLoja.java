package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import CRUD.CRUDClientes;
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
import java.sql.SQLException;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class CadastrarLoja {

	private JFrame frmCadastrarLoja;
	private JTextField tfCNPJ;
	private JTextField tfIE;
	private JTextField tfNum;
	private JTextField tfTel1;
	private JComboBox cbUF;
	private JComboBox cbCidade;
	private JLabel lblBG;
	private JComboBox cbRua;
	private JButton btnAddCidade;
	private JButton btnAddBairro;
	private JButton btnAddRua;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JPanel panel;
	private JTextField tfNome;
	private JTextField tfTel2;
	private JTextField tfCel1;
	private JTextField tfCel2;

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
		
		tfIE = new JTextField();
		tfIE.setBounds(310, 133, 200, 20);
		panel.add(tfIE);
		tfIE.setColumns(10);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(13, 135, 35, 14);
		panel.add(lblCNPJ);
		lblCNPJ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCNPJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfCNPJ = new JTextField();
		tfCNPJ.setBounds(58, 133, 200, 20);
		panel.add(tfCNPJ);
		tfCNPJ.setColumns(10);
		
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
		
		cbUF = new JComboBox();
		cbUF.setBounds(58, 42, 163, 20);
		panel.add(cbUF);
		cbUF.setSelectedItem("São Paulo");
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 74, 40, 14);
		panel.add(lblBairro);
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cbBairro = new JComboBox();
		cbBairro.setBounds(58, 73, 232, 19);
		panel.add(cbBairro);
		
		btnAddBairro = new JButton("...");
		btnAddBairro.setBounds(300, 70, 27, 23);
		panel.add(btnAddBairro);
		btnAddBairro.setForeground(Color.WHITE);
		btnAddBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBairro.setFocusable(false);
		btnAddBairro.setBackground(new Color(0, 73, 170));
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(249, 44, 51, 14);
		panel.add(lblCidade);
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		cbCidade = new JComboBox();
		cbCidade.setBounds(310, 42, 163, 19);
		panel.add(cbCidade);
		
		btnAddCidade = new JButton("...");
		btnAddCidade.setBounds(483, 40, 27, 23);
		panel.add(btnAddCidade);
		btnAddCidade.setForeground(Color.WHITE);
		btnAddCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddCidade.setFocusable(false);
		btnAddCidade.setBackground(new Color(0, 73, 170));
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 104, 38, 14);
		panel.add(lblRua);
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		cbRua = new JComboBox();
		cbRua.setBounds(58, 103, 232, 19);
		panel.add(cbRua);
		
		btnAddRua = new JButton("...");
		btnAddRua.setBounds(300, 100, 27, 23);
		panel.add(btnAddRua);
		btnAddRua.setForeground(Color.WHITE);
		btnAddRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddRua.setFocusable(false);
		btnAddRua.setBackground(new Color(0, 73, 170));
		
		JLabel lblNum = new JLabel("Número:");
		lblNum.setBounds(335, 104, 62, 14);
		panel.add(lblNum);
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfNum = new JTextField();
		tfNum.setBounds(407, 102, 103, 20);
		panel.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel 1:");
		lblTel.setBounds(13, 166, 35, 14);
		panel.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfTel1 = new JTextField();
		tfTel1.setBounds(57, 164, 201, 20);
		panel.add(tfTel1);
		tfTel1.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(102, 11, 410, 20);
		panel.add(tfNome);
		
		tfTel2 = new JTextField();
		tfTel2.setColumns(10);
		tfTel2.setBounds(57, 195, 201, 20);
		panel.add(tfTel2);
		
		tfCel1 = new JTextField();
		tfCel1.setColumns(10);
		tfCel1.setBounds(310, 164, 201, 20);
		panel.add(tfCel1);
		
		tfCel2 = new JTextField();
		tfCel2.setColumns(10);
		tfCel2.setBounds(310, 195, 201, 20);
		panel.add(tfCel2);
		
		JLabel lblTel_1 = new JLabel("Tel 2:");
		lblTel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel_1.setBounds(13, 198, 35, 14);
		panel.add(lblTel_1);
		
		JLabel lblCel = new JLabel("Cel 2:");
		lblCel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(265, 198, 35, 14);
		panel.add(lblCel);
		
		JLabel lblTel_2 = new JLabel("Tel 1:");
		lblTel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel_2.setBounds(265, 167, 35, 14);
		panel.add(lblTel_2);
		
		JLabel lblCadastroLoja = new JLabel("Cadastro de Lojas");
		lblCadastroLoja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroLoja.setBounds(10, 11, 125, 17);
		frmCadastrarLoja.getContentPane().add(lblCadastroLoja);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				tfNome.setText(null);
				cbUF.setSelectedIndex(0);
				cbCidade.setSelectedIndex(0);
				cbBairro.setSelectedIndex(0);
				cbRua.setSelectedIndex(0);
				tfNum.setText(null);
				tfCNPJ.setText(null);
				tfIE.setText(null);
				tfTel1.setText(null);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(344, 279, 89, 23);
		frmCadastrarLoja.getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
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
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private boolean preencherComboUF() {
		CRUDClientes selecionar = new CRUDClientes();
		selecionar.selectUF();
		cbUF.removeAllItems();
		try {
			while (selecionar.dadosEstados.next()) {
				cbUF.addItem(selecionar.dadosEstados.getString("nome_estado"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
