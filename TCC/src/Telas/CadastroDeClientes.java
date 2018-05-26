package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;

public class CadastroDeClientes {

	private JFrame frmCadastroDeClientes;
	private JRadioButton rbFisica;
	private JRadioButton rbJuridica;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JPanel pnFisica;
	private JLabel label;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JLabel label_1;
	private JTextField tfNome;
	private JLabel label_2;
	private JTextField tfEmailF;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField tfNumeroF;
	private JTextField tfCPF;
	private JLabel label_8;
	private JTextField tfRG;
	private JLabel label_9;
	private JTextField tfMae;
	private JTextField tfPai;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField tfEstadoCivil;
	private JLabel label_12;
	private JLabel label_13;
	private JTextField tfDataDeNascimento;
	private JTextField tfTel1F;
	private JLabel label_14;
	private JTextField tfTel2F;
	private JLabel label_15;
	private JLabel label_16;
	private JTextField tfCel1F;
	private JTextField tfCel2F;
	private JLabel lblCel;
	private JLabel label_18;
	private JComboBox comboUFF;
	private JButton btnAdicionarCidadeF;
	private JButton btnAdicionarBairroF;
	private JButton btnAdicionarRuaF;
	private JComboBox comboCidadeF;
	private JComboBox comboBairroF;
	private JComboBox comboRuaF;
	private JTextPane tpObservacoesF;
	private JPanel pnJuridica;
	private JLabel label_17;
	private JTextField tfRazaoSocial;
	private JLabel label_19;
	private JTextField tfEmailJ;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JTextField tfNumeroJ;
	private JTextField tfCNPJ;
	private JLabel label_25;
	private JTextField tfIE;
	private JLabel label_26;
	private JTextField tfTel1J;
	private JLabel label_27;
	private JTextField tfTel2J;
	private JLabel label_28;
	private JLabel label_29;
	private JTextField tfCel1J;
	private JTextField tfCel2J;
	private JLabel label_30;
	private JLabel label_31;
	private JComboBox comboUFJ;
	private JButton btnAdicionarCidadeJ;
	private JButton btnAdicionarBairroJ;
	private JButton btnAdicionarRuaJ;
	private JComboBox comboCidadeJ;
	private JComboBox comboBairroJ;
	private JComboBox comboRuaJ;
	private JTextPane tpObservacoesJ;

	/**
	  POSSÍVEIS CAMPOS PARA O CADASTRO:
	  - Nome Completo do Cliente ou Razão Social
	  - Tipo de Pessoa(Física ou Jurídica)
	  - Endereço(Rua e/ou CEP, Bairro, Cidade, Estado(UF))
	  - Filiação(Pai e Mãe)
	  - Estado Civil
	  - Email de Contato
	  - Telefone e/ou Celular
	  - CPF e RG(Física) ou CNPJ e IE(Jurídica)
	  - Sexo(talvez)
	  - Data de Nascimento(talvez)
	  - Observações do Cliente(talvez)
	*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeClientes window = new CadastroDeClientes();
					window.frmCadastroDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroDeClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeClientes = new JFrame();
		frmCadastroDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroDeClientes.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroDeClientes.setTitle("SIG - Cadastro de Clientes");
		frmCadastroDeClientes.setBounds(100, 100, 559, 575);
		frmCadastroDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeClientes.getContentPane().setLayout(null);
		
		JLabel lblCadastrosDeClientes = new JLabel("Cadastros de Clientes");
		lblCadastrosDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrosDeClientes.setBounds(10, 11, 149, 17);
		frmCadastroDeClientes.getContentPane().add(lblCadastrosDeClientes);
		
		rbFisica = new JRadioButton("Física");
		rbFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnFisica.setVisible(true);
				pnJuridica.setVisible(false);
			}
		});
		rbFisica.setOpaque(false);
		rbFisica.setFocusable(false);
		rbFisica.setSelected(true);
		rbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFisica.setBounds(10, 35, 57, 23);
		frmCadastroDeClientes.getContentPane().add(rbFisica);
		
		rbJuridica = new JRadioButton("Jurídica");
		rbJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnJuridica.setVisible(true);
				pnFisica.setVisible(false);
			}
		});
		rbJuridica.setOpaque(false);
		rbJuridica.setFocusable(false);
		rbJuridica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbJuridica.setBounds(69, 35, 71, 23);
		frmCadastroDeClientes.getContentPane().add(rbJuridica);
		frmCadastroDeClientes.setResizable(false);
		frmCadastroDeClientes.setLocationRelativeTo(null);
		
		ButtonGroup grupoFisicaJuridica = new ButtonGroup();
		grupoFisicaJuridica.add(rbFisica);
		grupoFisicaJuridica.add(rbJuridica);
		
		ButtonGroup grupoMasculinoFeminino = new ButtonGroup();
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 492, 89, 23);
		frmCadastroDeClientes.getContentPane().add(btnVoltar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(442, 492, 89, 23);
		frmCadastroDeClientes.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(343, 492, 89, 23);
		frmCadastroDeClientes.getContentPane().add(btnLimpar);
		
		pnFisica = new JPanel();
		pnFisica.setLayout(null);
		pnFisica.setOpaque(false);
		pnFisica.setBounds(10, 65, 521, 416);
		frmCadastroDeClientes.getContentPane().add(pnFisica);
		
		label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 13, 38, 14);
		pnFisica.add(label);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setSelected(true);
		rbMasculino.setOpaque(false);
		rbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMasculino.setFocusable(false);
		rbMasculino.setBounds(407, 4, 77, 14);
		pnFisica.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setOpaque(false);
		rbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFeminino.setFocusable(false);
		rbFeminino.setBounds(407, 21, 77, 14);
		pnFisica.add(rbFeminino);
		
		label_1 = new JLabel("Sexo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(367, 13, 34, 14);
		pnFisica.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(58, 11, 266, 20);
		pnFisica.add(tfNome);
		
		label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 44, 40, 14);
		pnFisica.add(label_2);
		
		tfEmailF = new JTextField();
		tfEmailF.setColumns(10);
		tfEmailF.setBounds(58, 42, 232, 20);
		pnFisica.add(tfEmailF);
		
		label_3 = new JLabel("UF:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(30, 76, 18, 14);
		pnFisica.add(label_3);
		
		label_4 = new JLabel("Cidade:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(255, 76, 45, 14);
		pnFisica.add(label_4);
		
		label_5 = new JLabel("Bairro:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(8, 106, 40, 14);
		pnFisica.add(label_5);
		
		label_6 = new JLabel("Rua:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(18, 138, 32, 14);
		pnFisica.add(label_6);
		
		label_7 = new JLabel("Número:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(346, 137, 51, 14);
		pnFisica.add(label_7);
		
		tfNumeroF = new JTextField();
		tfNumeroF.setColumns(10);
		tfNumeroF.setBounds(407, 135, 103, 20);
		pnFisica.add(tfNumeroF);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(58, 166, 200, 20);
		pnFisica.add(tfCPF);
		
		label_8 = new JLabel("CPF:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(21, 168, 27, 14);
		pnFisica.add(label_8);
		
		tfRG = new JTextField();
		tfRG.setColumns(10);
		tfRG.setBounds(58, 197, 200, 20);
		pnFisica.add(tfRG);
		
		label_9 = new JLabel("RG:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(21, 199, 27, 14);
		pnFisica.add(label_9);
		
		tfMae = new JTextField();
		tfMae.setColumns(10);
		tfMae.setBounds(310, 168, 200, 20);
		pnFisica.add(tfMae);
		
		tfPai = new JTextField();
		tfPai.setColumns(10);
		tfPai.setBounds(310, 197, 200, 20);
		pnFisica.add(tfPai);
		
		label_10 = new JLabel("Mãe:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(262, 168, 38, 14);
		pnFisica.add(label_10);
		
		label_11 = new JLabel("Pai:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(262, 199, 38, 14);
		pnFisica.add(label_11);
		
		tfEstadoCivil = new JTextField();
		tfEstadoCivil.setColumns(10);
		tfEstadoCivil.setBounds(407, 229, 103, 20);
		pnFisica.add(tfEstadoCivil);
		
		label_12 = new JLabel("Data de nascimento:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(21, 231, 126, 14);
		pnFisica.add(label_12);
		
		label_13 = new JLabel("Estado Civil:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(320, 232, 77, 14);
		pnFisica.add(label_13);
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(157, 229, 153, 20);
		pnFisica.add(tfDataDeNascimento);
		
		tfTel1F = new JTextField();
		tfTel1F.setColumns(10);
		tfTel1F.setBounds(58, 260, 200, 20);
		pnFisica.add(tfTel1F);
		
		label_14 = new JLabel("Tel 1:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(10, 262, 38, 14);
		pnFisica.add(label_14);
		
		tfTel2F = new JTextField();
		tfTel2F.setColumns(10);
		tfTel2F.setBounds(58, 291, 200, 20);
		pnFisica.add(tfTel2F);
		
		label_15 = new JLabel("Tel 2:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(10, 294, 38, 14);
		pnFisica.add(label_15);
		
		label_16 = new JLabel("Cel 1:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(262, 262, 38, 14);
		pnFisica.add(label_16);
		
		tfCel1F = new JTextField();
		tfCel1F.setColumns(10);
		tfCel1F.setBounds(310, 260, 200, 20);
		pnFisica.add(tfCel1F);
		
		tfCel2F = new JTextField();
		tfCel2F.setColumns(10);
		tfCel2F.setBounds(310, 291, 200, 20);
		pnFisica.add(tfCel2F);
		
		lblCel = new JLabel("Cel 2:");
		lblCel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(262, 294, 38, 14);
		pnFisica.add(lblCel);
		
		label_18 = new JLabel("Obs:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(10, 325, 38, 14);
		pnFisica.add(label_18);
		
		comboUFF = new JComboBox();
		comboUFF.setBounds(58, 74, 133, 20);
		pnFisica.add(comboUFF);
		
		btnAdicionarCidadeF = new JButton("...");
		btnAdicionarCidadeF.setForeground(Color.WHITE);
		btnAdicionarCidadeF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidadeF.setFocusable(false);
		btnAdicionarCidadeF.setBackground(new Color(0, 73, 170));
		btnAdicionarCidadeF.setBounds(483, 73, 27, 23);
		pnFisica.add(btnAdicionarCidadeF);
		
		btnAdicionarBairroF = new JButton("...");
		btnAdicionarBairroF.setForeground(Color.WHITE);
		btnAdicionarBairroF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairroF.setFocusable(false);
		btnAdicionarBairroF.setBackground(new Color(0, 73, 170));
		btnAdicionarBairroF.setBounds(297, 103, 27, 23);
		pnFisica.add(btnAdicionarBairroF);
		
		btnAdicionarRuaF = new JButton("...");
		btnAdicionarRuaF.setForeground(Color.WHITE);
		btnAdicionarRuaF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarRuaF.setFocusable(false);
		btnAdicionarRuaF.setBackground(new Color(0, 73, 170));
		btnAdicionarRuaF.setBounds(297, 134, 27, 23);
		pnFisica.add(btnAdicionarRuaF);
		
		comboCidadeF = new JComboBox();
		comboCidadeF.setBounds(310, 74, 163, 19);
		pnFisica.add(comboCidadeF);
		
		comboBairroF = new JComboBox();
		comboBairroF.setBounds(58, 104, 232, 19);
		pnFisica.add(comboBairroF);
		
		comboRuaF = new JComboBox();
		comboRuaF.setBounds(58, 136, 232, 19);
		pnFisica.add(comboRuaF);
		
		tpObservacoesF = new JTextPane();
		tpObservacoesF.setBounds(58, 322, 453, 83);
		pnFisica.add(tpObservacoesF);
		
		pnJuridica = new JPanel();
		pnJuridica.setVisible(false);
		pnJuridica.setBounds(10, 65, 521, 416);
		frmCadastroDeClientes.getContentPane().add(pnJuridica);
		pnJuridica.setLayout(null);
		pnJuridica.setOpaque(false);
		
		label_17 = new JLabel("Razão Social:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(10, 13, 80, 14);
		pnJuridica.add(label_17);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBounds(100, 11, 410, 20);
		pnJuridica.add(tfRazaoSocial);
		
		label_19 = new JLabel("E-mail:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(10, 44, 40, 14);
		pnJuridica.add(label_19);
		
		tfEmailJ = new JTextField();
		tfEmailJ.setColumns(10);
		tfEmailJ.setBounds(58, 42, 232, 20);
		pnJuridica.add(tfEmailJ);
		
		label_20 = new JLabel("UF:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setBounds(30, 76, 18, 14);
		pnJuridica.add(label_20);
		
		label_21 = new JLabel("Cidade:");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_21.setBounds(255, 76, 45, 14);
		pnJuridica.add(label_21);
		
		label_22 = new JLabel("Bairro:");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_22.setBounds(8, 106, 40, 14);
		pnJuridica.add(label_22);
		
		label_23 = new JLabel("Rua:");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_23.setBounds(18, 138, 32, 14);
		pnJuridica.add(label_23);
		
		label_24 = new JLabel("Número:");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_24.setBounds(346, 137, 51, 14);
		pnJuridica.add(label_24);
		
		tfNumeroJ = new JTextField();
		tfNumeroJ.setColumns(10);
		tfNumeroJ.setBounds(407, 135, 103, 20);
		pnJuridica.add(tfNumeroJ);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(58, 166, 200, 20);
		pnJuridica.add(tfCNPJ);
		
		label_25 = new JLabel("CNPJ:");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_25.setBounds(10, 168, 38, 14);
		pnJuridica.add(label_25);
		
		tfIE = new JTextField();
		tfIE.setColumns(10);
		tfIE.setBounds(310, 168, 200, 20);
		pnJuridica.add(tfIE);
		
		label_26 = new JLabel("IE:");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_26.setBounds(262, 168, 38, 14);
		pnJuridica.add(label_26);
		
		tfTel1J = new JTextField();
		tfTel1J.setColumns(10);
		tfTel1J.setBounds(58, 197, 200, 20);
		pnJuridica.add(tfTel1J);
		
		label_27 = new JLabel("Tel 1:");
		label_27.setHorizontalAlignment(SwingConstants.RIGHT);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_27.setBounds(12, 199, 38, 14);
		pnJuridica.add(label_27);
		
		tfTel2J = new JTextField();
		tfTel2J.setColumns(10);
		tfTel2J.setBounds(58, 228, 200, 20);
		pnJuridica.add(tfTel2J);
		
		label_28 = new JLabel("Tel 2:");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_28.setBounds(12, 230, 38, 14);
		pnJuridica.add(label_28);
		
		label_29 = new JLabel("Cel 1:");
		label_29.setHorizontalAlignment(SwingConstants.RIGHT);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_29.setBounds(262, 199, 38, 14);
		pnJuridica.add(label_29);
		
		tfCel1J = new JTextField();
		tfCel1J.setColumns(10);
		tfCel1J.setBounds(310, 199, 200, 20);
		pnJuridica.add(tfCel1J);
		
		tfCel2J = new JTextField();
		tfCel2J.setColumns(10);
		tfCel2J.setBounds(310, 228, 200, 20);
		pnJuridica.add(tfCel2J);
		
		label_30 = new JLabel("Cel 2:");
		label_30.setHorizontalAlignment(SwingConstants.RIGHT);
		label_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_30.setBounds(262, 230, 38, 14);
		pnJuridica.add(label_30);
		
		label_31 = new JLabel("Obs:");
		label_31.setHorizontalAlignment(SwingConstants.RIGHT);
		label_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_31.setBounds(12, 263, 38, 14);
		pnJuridica.add(label_31);
		
		comboUFJ = new JComboBox();
		comboUFJ.setBounds(58, 74, 133, 20);
		pnJuridica.add(comboUFJ);
		
		btnAdicionarCidadeJ = new JButton("...");
		btnAdicionarCidadeJ.setForeground(Color.WHITE);
		btnAdicionarCidadeJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidadeJ.setFocusable(false);
		btnAdicionarCidadeJ.setBackground(new Color(0, 73, 170));
		btnAdicionarCidadeJ.setBounds(483, 73, 27, 23);
		pnJuridica.add(btnAdicionarCidadeJ);
		
		btnAdicionarBairroJ = new JButton("...");
		btnAdicionarBairroJ.setForeground(Color.WHITE);
		btnAdicionarBairroJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairroJ.setFocusable(false);
		btnAdicionarBairroJ.setBackground(new Color(0, 73, 170));
		btnAdicionarBairroJ.setBounds(297, 103, 27, 23);
		pnJuridica.add(btnAdicionarBairroJ);
		
		btnAdicionarRuaJ = new JButton("...");
		btnAdicionarRuaJ.setForeground(Color.WHITE);
		btnAdicionarRuaJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarRuaJ.setFocusable(false);
		btnAdicionarRuaJ.setBackground(new Color(0, 73, 170));
		btnAdicionarRuaJ.setBounds(297, 134, 27, 23);
		pnJuridica.add(btnAdicionarRuaJ);
		
		comboCidadeJ = new JComboBox();
		comboCidadeJ.setBounds(310, 74, 163, 19);
		pnJuridica.add(comboCidadeJ);
		
		comboBairroJ = new JComboBox();
		comboBairroJ.setBounds(58, 104, 232, 19);
		pnJuridica.add(comboBairroJ);
		
		comboRuaJ = new JComboBox();
		comboRuaJ.setBounds(58, 136, 232, 19);
		pnJuridica.add(comboRuaJ);
		
		tpObservacoesJ = new JTextPane();
		tpObservacoesJ.setBounds(58, 259, 452, 146);
		pnJuridica.add(tpObservacoesJ);
	}
}
