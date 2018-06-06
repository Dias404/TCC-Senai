package Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarClientes {

	private JFrame frmSigAtualizar;
	private JTextField tfRazaoSocial;
	private JTextField tfEmailJ;
	private JTextField tfNumeroJ;
	private JTextField tfCNPJ;
	private JTextField tfIE;
	private JTextField tfTel1J;
	private JTextField tfTel2J;
	private JTextField tfCel1J;
	private JTextField tfCel2J;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btnSalvar;
	private JComboBox comboUFJ;
	private JComboBox comboCidadeJ;
	private JComboBox comboBairroJ;
	private JButton btnAdicionarBairroJ;
	private JComboBox comboRuaJ;
	private JButton btnAdicionarRuaJ;
	private JTextPane tpObservacoesJ;
	private JRadioButton rbFisica;
	private JRadioButton rbJuridica;
	private JTextField tfNome;
	private JTextField tfEmailF;
	private JTextField tfNumeroF;
	private JTextField tfCPF;
	private JTextField tfRG;
	private JTextField tfMae;
	private JTextField tfPai;
	private JTextField tfDataDeNascimento;
	private JTextField tfTel1F;
	private JTextField tfTel2F;
	private JTextField tfCel1F;
	private JTextField tfCel2F;
	private JPanel pnFisica;
	private JPanel pnJuridica;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JTextPane tpObservacoesF;
	private JComboBox comboUFF;
	private JButton btnAdicionarCidadeF;
	private JComboBox comboCidadeF;
	private JComboBox comboBairroF;
	private JComboBox comboRuaF;
	private JComboBox comboEstadoCivil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarClientes window = new AtualizarClientes();
					window.frmSigAtualizar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AtualizarClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSigAtualizar = new JFrame();
		frmSigAtualizar.setTitle("SIG - Atualizar Clientes");
		frmSigAtualizar.setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarClientes.class.getResource("/Img/SIG 16x16.png")));
		frmSigAtualizar.setBounds(100, 100, 559, 575);
		frmSigAtualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSigAtualizar.setResizable(false);
		frmSigAtualizar.setLocationRelativeTo(null);
		frmSigAtualizar.getContentPane().setLayout(null);
		
		JLabel lblAtualizarClientes = new JLabel("Atualizar Clientes");
		lblAtualizarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtualizarClientes.setBounds(10, 11, 149, 17);
		frmSigAtualizar.getContentPane().add(lblAtualizarClientes);
		
		rbFisica = new JRadioButton("Física");
		rbFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnFisica.setVisible(true);
				pnJuridica.setVisible(false);
			}
		});
		rbFisica.setSelected(true);
		rbFisica.setOpaque(false);
		rbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFisica.setFocusable(false);
		rbFisica.setBounds(10, 35, 57, 23);
		frmSigAtualizar.getContentPane().add(rbFisica);
		
		rbJuridica = new JRadioButton("Jurídica");
		rbJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnFisica.setVisible(false);
				pnJuridica.setVisible(true);
			}
		});
		rbJuridica.setOpaque(false);
		rbJuridica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbJuridica.setFocusable(false);
		rbJuridica.setBounds(69, 35, 71, 23);
		frmSigAtualizar.getContentPane().add(rbJuridica);
		
		pnFisica = new JPanel();
		pnFisica.setBounds(10, 65, 521, 416);
		frmSigAtualizar.getContentPane().add(pnFisica);
		pnFisica.setLayout(null);
		pnFisica.setOpaque(false);
		pnFisica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label = new JLabel("Nome:");
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
		
		JLabel label_1 = new JLabel("Sexo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(367, 13, 34, 14);
		pnFisica.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(58, 11, 266, 20);
		pnFisica.add(tfNome);
		
		JLabel label_8 = new JLabel("E-mail:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 44, 40, 14);
		pnFisica.add(label_8);
		
		tfEmailF = new JTextField();
		tfEmailF.setColumns(10);
		tfEmailF.setBounds(58, 42, 232, 20);
		pnFisica.add(tfEmailF);
		
		JLabel label_9 = new JLabel("UF:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(30, 76, 18, 14);
		pnFisica.add(label_9);
		
		JLabel label_10 = new JLabel("Cidade:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(255, 76, 45, 14);
		pnFisica.add(label_10);
		
		JLabel label_11 = new JLabel("Bairro:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(8, 106, 40, 14);
		pnFisica.add(label_11);
		
		JLabel label_12 = new JLabel("Rua:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(18, 138, 32, 14);
		pnFisica.add(label_12);
		
		JLabel label_13 = new JLabel("Número:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(346, 137, 51, 14);
		pnFisica.add(label_13);
		
		tfNumeroF = new JTextField();
		tfNumeroF.setColumns(10);
		tfNumeroF.setBounds(407, 135, 103, 20);
		pnFisica.add(tfNumeroF);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(58, 166, 200, 20);
		pnFisica.add(tfCPF);
		
		JLabel label_19 = new JLabel("CPF:");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(21, 168, 27, 14);
		pnFisica.add(label_19);
		
		tfRG = new JTextField();
		tfRG.setColumns(10);
		tfRG.setBounds(58, 197, 200, 20);
		pnFisica.add(tfRG);
		
		JLabel label_20 = new JLabel("RG:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setBounds(21, 199, 27, 14);
		pnFisica.add(label_20);
		
		tfMae = new JTextField();
		tfMae.setColumns(10);
		tfMae.setBounds(310, 168, 200, 20);
		pnFisica.add(tfMae);
		
		tfPai = new JTextField();
		tfPai.setColumns(10);
		tfPai.setBounds(310, 197, 200, 20);
		pnFisica.add(tfPai);
		
		JLabel label_21 = new JLabel("Mãe:");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_21.setBounds(262, 168, 38, 14);
		pnFisica.add(label_21);
		
		JLabel label_22 = new JLabel("Pai:");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_22.setBounds(262, 199, 38, 14);
		pnFisica.add(label_22);
		
		JLabel label_23 = new JLabel("Data de nascimento:");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_23.setBounds(21, 231, 126, 14);
		pnFisica.add(label_23);
		
		JLabel label_24 = new JLabel("Estado Civil:");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_24.setBounds(320, 232, 77, 14);
		pnFisica.add(label_24);
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(157, 229, 153, 20);
		pnFisica.add(tfDataDeNascimento);
		
		tfTel1F = new JTextField();
		tfTel1F.setColumns(10);
		tfTel1F.setBounds(58, 260, 200, 20);
		pnFisica.add(tfTel1F);
		
		JLabel label_25 = new JLabel("Tel 1:");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_25.setBounds(10, 262, 38, 14);
		pnFisica.add(label_25);
		
		tfTel2F = new JTextField();
		tfTel2F.setColumns(10);
		tfTel2F.setBounds(58, 291, 200, 20);
		pnFisica.add(tfTel2F);
		
		JLabel label_26 = new JLabel("Tel 2:");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_26.setBounds(10, 294, 38, 14);
		pnFisica.add(label_26);
		
		JLabel label_27 = new JLabel("Cel 1:");
		label_27.setHorizontalAlignment(SwingConstants.RIGHT);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_27.setBounds(262, 262, 38, 14);
		pnFisica.add(label_27);
		
		tfCel1F = new JTextField();
		tfCel1F.setColumns(10);
		tfCel1F.setBounds(310, 260, 200, 20);
		pnFisica.add(tfCel1F);
		
		tfCel2F = new JTextField();
		tfCel2F.setColumns(10);
		tfCel2F.setBounds(310, 291, 200, 20);
		pnFisica.add(tfCel2F);
		
		JLabel label_28 = new JLabel("Cel 2:");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_28.setBounds(262, 294, 38, 14);
		pnFisica.add(label_28);
		
		JLabel label_29 = new JLabel("Obs:");
		label_29.setHorizontalAlignment(SwingConstants.RIGHT);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_29.setBounds(10, 325, 38, 14);
		pnFisica.add(label_29);
		
		comboUFF = new JComboBox();
		comboUFF.setBounds(58, 74, 163, 20);
		pnFisica.add(comboUFF);
		
		btnAdicionarCidadeF = new JButton("...");
		btnAdicionarCidadeF.setForeground(Color.WHITE);
		btnAdicionarCidadeF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidadeF.setFocusable(false);
		btnAdicionarCidadeF.setBackground(new Color(0, 73, 170));
		btnAdicionarCidadeF.setBounds(483, 73, 27, 23);
		pnFisica.add(btnAdicionarCidadeF);
		
		JButton btnAdicionarBairroF = new JButton("...");
		btnAdicionarBairroF.setForeground(Color.WHITE);
		btnAdicionarBairroF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairroF.setFocusable(false);
		btnAdicionarBairroF.setBackground(new Color(0, 73, 170));
		btnAdicionarBairroF.setBounds(297, 102, 27, 23);
		pnFisica.add(btnAdicionarBairroF);
		
		JButton btnAdicionarRuaF = new JButton("...");
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
		tpObservacoesF.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tpObservacoesF.setBounds(58, 322, 453, 83);
		pnFisica.add(tpObservacoesF);
		
		comboEstadoCivil = new JComboBox();
		comboEstadoCivil.setBounds(407, 229, 103, 20);
		pnFisica.add(comboEstadoCivil);
		
		pnJuridica = new JPanel();
		pnJuridica.setLayout(null);
		pnJuridica.setOpaque(false);
		pnJuridica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnJuridica.setBounds(10, 65, 521, 416);
		frmSigAtualizar.getContentPane().add(pnJuridica);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		lblRazoSocial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRazoSocial.setBounds(10, 13, 80, 14);
		pnJuridica.add(lblRazoSocial);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBounds(100, 11, 410, 20);
		pnJuridica.add(tfRazaoSocial);
		
		JLabel label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 44, 40, 14);
		pnJuridica.add(label_2);
		
		tfEmailJ = new JTextField();
		tfEmailJ.setColumns(10);
		tfEmailJ.setBounds(58, 42, 232, 20);
		pnJuridica.add(tfEmailJ);
		
		JLabel label_3 = new JLabel("UF:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(30, 76, 18, 14);
		pnJuridica.add(label_3);
		
		JLabel label_4 = new JLabel("Cidade:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(255, 76, 45, 14);
		pnJuridica.add(label_4);
		
		JLabel label_5 = new JLabel("Bairro:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(8, 106, 40, 14);
		pnJuridica.add(label_5);
		
		JLabel label_6 = new JLabel("Rua:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(18, 138, 32, 14);
		pnJuridica.add(label_6);
		
		JLabel label_7 = new JLabel("Número:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(346, 137, 51, 14);
		pnJuridica.add(label_7);
		
		tfNumeroJ = new JTextField();
		tfNumeroJ.setColumns(10);
		tfNumeroJ.setBounds(407, 135, 103, 20);
		pnJuridica.add(tfNumeroJ);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(58, 166, 200, 20);
		pnJuridica.add(tfCNPJ);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(10, 168, 38, 14);
		pnJuridica.add(lblCnpj);
		
		tfIE = new JTextField();
		tfIE.setColumns(10);
		tfIE.setBounds(310, 168, 200, 20);
		pnJuridica.add(tfIE);
		
		JLabel lblIe = new JLabel("IE:");
		lblIe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIe.setBounds(262, 168, 38, 14);
		pnJuridica.add(lblIe);
		
		tfTel1J = new JTextField();
		tfTel1J.setColumns(10);
		tfTel1J.setBounds(58, 197, 200, 20);
		pnJuridica.add(tfTel1J);
		
		JLabel label_14 = new JLabel("Tel 1:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(12, 199, 38, 14);
		pnJuridica.add(label_14);
		
		tfTel2J = new JTextField();
		tfTel2J.setColumns(10);
		tfTel2J.setBounds(58, 228, 200, 20);
		pnJuridica.add(tfTel2J);
		
		JLabel label_15 = new JLabel("Tel 2:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(12, 230, 38, 14);
		pnJuridica.add(label_15);
		
		JLabel label_16 = new JLabel("Cel 1:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(262, 199, 38, 14);
		pnJuridica.add(label_16);
		
		tfCel1J = new JTextField();
		tfCel1J.setColumns(10);
		tfCel1J.setBounds(310, 199, 200, 20);
		pnJuridica.add(tfCel1J);
		
		tfCel2J = new JTextField();
		tfCel2J.setColumns(10);
		tfCel2J.setBounds(310, 230, 200, 20);
		pnJuridica.add(tfCel2J);
		
		JLabel label_17 = new JLabel("Cel 2:");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(262, 230, 38, 14);
		pnJuridica.add(label_17);
		
		JLabel label_18 = new JLabel("Obs:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(12, 261, 38, 14);
		pnJuridica.add(label_18);
		
		comboUFJ = new JComboBox();
		comboUFJ.setBounds(58, 74, 163, 20);
		pnJuridica.add(comboUFJ);
		
		JButton btnAdicionarCidadeJ = new JButton("...");
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
		btnAdicionarBairroJ.setBounds(297, 102, 27, 23);
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
		tpObservacoesJ.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tpObservacoesJ.setBounds(58, 259, 453, 146);
		pnJuridica.add(tpObservacoesJ);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 492, 89, 23);
		frmSigAtualizar.getContentPane().add(btnVoltar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnAlterar.setFocusable(false);
		btnAlterar.setBackground(new Color(0, 73, 170));
		btnAlterar.setBounds(442, 492, 89, 23);
		frmSigAtualizar.getContentPane().add(btnAlterar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(new Color(0, 73, 170));
		btnCancelar.setBounds(343, 492, 89, 23);
		frmSigAtualizar.getContentPane().add(btnCancelar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setVisible(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(442, 492, 89, 23);
		frmSigAtualizar.getContentPane().add(btnSalvar);
		
		ButtonGroup grupoTipoDePessoa = new ButtonGroup();
		grupoTipoDePessoa.add(rbFisica);
		grupoTipoDePessoa.add(rbJuridica);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rbMasculino);
		grupoSexo.add(rbFeminino);
	}
}
