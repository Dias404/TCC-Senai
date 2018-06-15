package Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import Administrador.CadastrarUsuario;
import CRUD.CRUDClientes;
import DAO.Clientes;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.sound.midi.Soundbank;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class AtualizarClientes {

	private JFrame frmAtualizarClientes;
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
	private JComboBox comboUFF;
	private JButton btnAdicionarCidadeF;
	private JComboBox comboCidadeF;
	private JComboBox comboBairroF;
	private JComboBox comboRuaF;
	private JComboBox comboEstadoCivil;
	private JButton btnAdicionarBairroF;
	private JButton btnAdicionarRuaF;
	private JButton btnAdicionarCidadeJ;
	private JButton btnRemover;
	private JLabel lblBG;
	
	private int idCliente = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarClientes window = new AtualizarClientes();
					window.frmAtualizarClientes.setVisible(true);
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
		frmAtualizarClientes = new JFrame();
		frmAtualizarClientes.setTitle("SIG - Atualizar Clientes");
		frmAtualizarClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarClientes.class.getResource("/Img/SIG 16x16.png")));
		frmAtualizarClientes.setBounds(100, 100, 548, 464);
		frmAtualizarClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAtualizarClientes.setResizable(false);
		frmAtualizarClientes.setLocationRelativeTo(null);
		frmAtualizarClientes.getContentPane().setLayout(null);
		
		JLabel lblAtualizarClientes = new JLabel("Atualizar Clientes");
		lblAtualizarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtualizarClientes.setBounds(10, 11, 149, 17);
		frmAtualizarClientes.getContentPane().add(lblAtualizarClientes);
		
		rbFisica = new JRadioButton("Física");
		rbFisica.setBackground(new Color(119, 136, 153));
		rbFisica.setEnabled(false);
		rbFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja mudar o tipo de pessoa?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					pnFisica.setVisible(true);
					pnJuridica.setVisible(false);
				}
				if (respostaJOP == JOptionPane.NO_OPTION) {
					rbJuridica.setSelected(true);
					pnFisica.setVisible(false);
					pnJuridica.setVisible(true);
				}
			}
		});
		rbFisica.setSelected(true);
		rbFisica.setOpaque(false);
		rbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFisica.setFocusable(false);
		rbFisica.setBounds(10, 35, 57, 23);
		frmAtualizarClientes.getContentPane().add(rbFisica);
		
		rbJuridica = new JRadioButton("Jurídica");
		rbJuridica.setBackground(new Color(119, 136, 153));
		rbJuridica.setEnabled(false);
		rbJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja mudar o tipo de pessoa?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					pnFisica.setVisible(false);
					pnJuridica.setVisible(true);
				}
				if (respostaJOP == JOptionPane.NO_OPTION) {
					rbFisica.setSelected(true);
					pnFisica.setVisible(true);
					pnJuridica.setVisible(false);
				}
			}
		});
		rbJuridica.setOpaque(false);
		rbJuridica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbJuridica.setFocusable(false);
		rbJuridica.setBounds(69, 35, 71, 23);
		frmAtualizarClientes.getContentPane().add(rbJuridica);
		
		pnFisica = new JPanel();
		pnFisica.setBounds(10, 65, 521, 325);
		frmAtualizarClientes.getContentPane().add(pnFisica);
		pnFisica.setLayout(null);
		pnFisica.setOpaque(false);
		pnFisica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 13, 38, 14);
		pnFisica.add(label);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBackground(new Color(119, 136, 153));
		rbMasculino.setEnabled(false);
		rbMasculino.setSelected(true);
		rbMasculino.setOpaque(false);
		rbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMasculino.setFocusable(false);
		rbMasculino.setBounds(407, 4, 77, 14);
		pnFisica.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBackground(new Color(119, 136, 153));
		rbFeminino.setEnabled(false);
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
		tfNome.setEnabled(false);
		tfNome.setColumns(10);
		tfNome.setBounds(58, 11, 266, 20);
		pnFisica.add(tfNome);
		
		JLabel label_8 = new JLabel("E-mail:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 44, 40, 14);
		pnFisica.add(label_8);
		
		tfEmailF = new JTextField();
		tfEmailF.setEnabled(false);
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
		tfNumeroF.setEnabled(false);
		tfNumeroF.setColumns(10);
		tfNumeroF.setBounds(407, 135, 103, 20);
		pnFisica.add(tfNumeroF);
		
		tfCPF = new JTextField();
		tfCPF.setEnabled(false);
		tfCPF.setColumns(10);
		tfCPF.setBounds(58, 166, 200, 20);
		pnFisica.add(tfCPF);
		
		JLabel label_19 = new JLabel("CPF:");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(21, 168, 27, 14);
		pnFisica.add(label_19);
		
		tfRG = new JTextField();
		tfRG.setEnabled(false);
		tfRG.setColumns(10);
		tfRG.setBounds(58, 197, 200, 20);
		pnFisica.add(tfRG);
		
		JLabel label_20 = new JLabel("RG:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setBounds(21, 199, 27, 14);
		pnFisica.add(label_20);
		
		tfMae = new JTextField();
		tfMae.setEnabled(false);
		tfMae.setColumns(10);
		tfMae.setBounds(310, 168, 200, 20);
		pnFisica.add(tfMae);
		
		tfPai = new JTextField();
		tfPai.setEnabled(false);
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
		tfDataDeNascimento.setEnabled(false);
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(157, 229, 153, 20);
		pnFisica.add(tfDataDeNascimento);
		
		tfTel1F = new JTextField();
		tfTel1F.setEnabled(false);
		tfTel1F.setColumns(10);
		tfTel1F.setBounds(58, 260, 200, 20);
		pnFisica.add(tfTel1F);
		
		JLabel label_25 = new JLabel("Tel 1:");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_25.setBounds(10, 262, 38, 14);
		pnFisica.add(label_25);
		
		tfTel2F = new JTextField();
		tfTel2F.setEnabled(false);
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
		tfCel1F.setEnabled(false);
		tfCel1F.setColumns(10);
		tfCel1F.setBounds(310, 260, 200, 20);
		pnFisica.add(tfCel1F);
		
		tfCel2F = new JTextField();
		tfCel2F.setEnabled(false);
		tfCel2F.setColumns(10);
		tfCel2F.setBounds(310, 291, 200, 20);
		pnFisica.add(tfCel2F);
		
		JLabel label_28 = new JLabel("Cel 2:");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_28.setBounds(262, 294, 38, 14);
		pnFisica.add(label_28);
		
		comboUFF = new JComboBox();
		comboUFF.setEnabled(false);
		comboUFF.setBounds(58, 74, 163, 20);
		pnFisica.add(comboUFF);
		
		btnAdicionarCidadeF = new JButton("...");
		btnAdicionarCidadeF.setEnabled(false);
		btnAdicionarCidadeF.setForeground(Color.WHITE);
		btnAdicionarCidadeF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidadeF.setFocusable(false);
		btnAdicionarCidadeF.setBackground(new Color(0, 73, 170));
		btnAdicionarCidadeF.setBounds(483, 73, 27, 23);
		pnFisica.add(btnAdicionarCidadeF);
		
		btnAdicionarBairroF = new JButton("...");
		btnAdicionarBairroF.setEnabled(false);
		btnAdicionarBairroF.setForeground(Color.WHITE);
		btnAdicionarBairroF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairroF.setFocusable(false);
		btnAdicionarBairroF.setBackground(new Color(0, 73, 170));
		btnAdicionarBairroF.setBounds(297, 102, 27, 23);
		pnFisica.add(btnAdicionarBairroF);
		
		btnAdicionarRuaF = new JButton("...");
		btnAdicionarRuaF.setEnabled(false);
		btnAdicionarRuaF.setForeground(Color.WHITE);
		btnAdicionarRuaF.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarRuaF.setFocusable(false);
		btnAdicionarRuaF.setBackground(new Color(0, 73, 170));
		btnAdicionarRuaF.setBounds(297, 134, 27, 23);
		pnFisica.add(btnAdicionarRuaF);
		
		comboCidadeF = new JComboBox();
		comboCidadeF.setEnabled(false);
		comboCidadeF.setBounds(310, 74, 163, 19);
		pnFisica.add(comboCidadeF);
		
		comboBairroF = new JComboBox();
		comboBairroF.setEnabled(false);
		comboBairroF.setBounds(58, 104, 232, 19);
		pnFisica.add(comboBairroF);
		
		comboRuaF = new JComboBox();
		comboRuaF.setEnabled(false);
		comboRuaF.setBounds(58, 136, 232, 19);
		pnFisica.add(comboRuaF);
		
		comboEstadoCivil = new JComboBox();
		comboEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro(a)", "Casado(a)", "Separado(a)", "Divorciado(a)", "Viúvo(a)"}));
		comboEstadoCivil.setEnabled(false);
		comboEstadoCivil.setBounds(407, 229, 103, 20);
		pnFisica.add(comboEstadoCivil);
		
		pnJuridica = new JPanel();
		pnJuridica.setVisible(false);
		pnJuridica.setLayout(null);
		pnJuridica.setOpaque(false);
		pnJuridica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		pnJuridica.setBounds(10, 65, 521, 325);
		frmAtualizarClientes.getContentPane().add(pnJuridica);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		lblRazoSocial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRazoSocial.setBounds(10, 13, 80, 14);
		pnJuridica.add(lblRazoSocial);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setEnabled(false);
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBounds(100, 11, 410, 20);
		pnJuridica.add(tfRazaoSocial);
		
		JLabel label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 44, 40, 14);
		pnJuridica.add(label_2);
		
		tfEmailJ = new JTextField();
		tfEmailJ.setEnabled(false);
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
		tfNumeroJ.setEnabled(false);
		tfNumeroJ.setColumns(10);
		tfNumeroJ.setBounds(407, 135, 103, 20);
		pnJuridica.add(tfNumeroJ);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setEnabled(false);
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(58, 166, 200, 20);
		pnJuridica.add(tfCNPJ);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(10, 168, 38, 14);
		pnJuridica.add(lblCnpj);
		
		tfIE = new JTextField();
		tfIE.setEnabled(false);
		tfIE.setColumns(10);
		tfIE.setBounds(310, 168, 200, 20);
		pnJuridica.add(tfIE);
		
		JLabel lblIe = new JLabel("IE:");
		lblIe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIe.setBounds(262, 168, 38, 14);
		pnJuridica.add(lblIe);
		
		tfTel1J = new JTextField();
		tfTel1J.setEnabled(false);
		tfTel1J.setColumns(10);
		tfTel1J.setBounds(58, 197, 200, 20);
		pnJuridica.add(tfTel1J);
		
		JLabel label_14 = new JLabel("Tel 1:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(12, 199, 38, 14);
		pnJuridica.add(label_14);
		
		tfTel2J = new JTextField();
		tfTel2J.setEnabled(false);
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
		tfCel1J.setEnabled(false);
		tfCel1J.setColumns(10);
		tfCel1J.setBounds(310, 199, 200, 20);
		pnJuridica.add(tfCel1J);
		
		tfCel2J = new JTextField();
		tfCel2J.setEnabled(false);
		tfCel2J.setColumns(10);
		tfCel2J.setBounds(310, 230, 200, 20);
		pnJuridica.add(tfCel2J);
		
		JLabel label_17 = new JLabel("Cel 2:");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(262, 230, 38, 14);
		pnJuridica.add(label_17);
		
		comboUFJ = new JComboBox();
		comboUFJ.setEnabled(false);
		comboUFJ.setBounds(58, 74, 163, 20);
		pnJuridica.add(comboUFJ);
		
		btnAdicionarCidadeJ = new JButton("...");
		btnAdicionarCidadeJ.setEnabled(false);
		btnAdicionarCidadeJ.setForeground(Color.WHITE);
		btnAdicionarCidadeJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidadeJ.setFocusable(false);
		btnAdicionarCidadeJ.setBackground(new Color(0, 73, 170));
		btnAdicionarCidadeJ.setBounds(483, 73, 27, 23);
		pnJuridica.add(btnAdicionarCidadeJ);
		
		btnAdicionarBairroJ = new JButton("...");
		btnAdicionarBairroJ.setEnabled(false);
		btnAdicionarBairroJ.setForeground(Color.WHITE);
		btnAdicionarBairroJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairroJ.setFocusable(false);
		btnAdicionarBairroJ.setBackground(new Color(0, 73, 170));
		btnAdicionarBairroJ.setBounds(297, 102, 27, 23);
		pnJuridica.add(btnAdicionarBairroJ);
		
		btnAdicionarRuaJ = new JButton("...");
		btnAdicionarRuaJ.setEnabled(false);
		btnAdicionarRuaJ.setForeground(Color.WHITE);
		btnAdicionarRuaJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarRuaJ.setFocusable(false);
		btnAdicionarRuaJ.setBackground(new Color(0, 73, 170));
		btnAdicionarRuaJ.setBounds(297, 134, 27, 23);
		pnJuridica.add(btnAdicionarRuaJ);
		
		comboCidadeJ = new JComboBox();
		comboCidadeJ.setEnabled(false);
		comboCidadeJ.setBounds(310, 74, 163, 19);
		pnJuridica.add(comboCidadeJ);
		
		comboBairroJ = new JComboBox();
		comboBairroJ.setEnabled(false);
		comboBairroJ.setBounds(58, 104, 232, 19);
		pnJuridica.add(comboBairroJ);
		
		comboRuaJ = new JComboBox();
		comboRuaJ.setEnabled(false);
		comboRuaJ.setBounds(58, 136, 232, 19);
		pnJuridica.add(comboRuaJ);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarClientes.main(null);
				frmAtualizarClientes.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 401, 89, 23);
		frmAtualizarClientes.getContentPane().add(btnVoltar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar os dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					btnAlterar.setVisible(false);
					btnRemover.setVisible(true);
					btnCancelar.setVisible(true);
					btnSalvar.setVisible(true);
					
					rbFisica.setEnabled(true);
					rbJuridica.setEnabled(true);
					tfNome.setEnabled(true);
					tfRazaoSocial.setEnabled(true);
					tfEmailF.setEnabled(true);
					tfEmailJ.setEnabled(true);
					rbMasculino.setEnabled(true);
					rbFeminino.setEnabled(true);
					comboUFF.setEnabled(true);
					comboUFJ.setEnabled(true);
					comboCidadeF.setEnabled(true);
					comboCidadeJ.setEnabled(true);
					btnAdicionarCidadeF.setEnabled(true);
					btnAdicionarCidadeJ.setEnabled(true);
					comboBairroF.setEnabled(true);
					comboBairroJ.setEnabled(true);
					btnAdicionarBairroF.setEnabled(true);
					btnAdicionarBairroJ.setEnabled(true);
					comboRuaF.setEnabled(true);
					comboRuaJ.setEnabled(true);
					btnAdicionarRuaF.setEnabled(true);
					btnAdicionarRuaJ.setEnabled(true);
					tfNumeroF.setEnabled(true);
					tfNumeroJ.setEnabled(true);
					tfCPF.setEnabled(true);
					tfCNPJ.setEnabled(true);
					tfRG.setEnabled(true);
					tfIE.setEnabled(true);
					tfMae.setEnabled(true);
					tfPai.setEnabled(true);
					tfDataDeNascimento.setEnabled(true);
					comboEstadoCivil.setEnabled(true);
					tfTel1F.setEnabled(true);
					tfTel1J.setEnabled(true);
					tfTel2F.setEnabled(true);
					tfTel2J.setEnabled(true);
					tfCel1F.setEnabled(true);
					tfCel1J.setEnabled(true);
					tfCel2F.setEnabled(true);
					tfCel2J.setEnabled(true);
				}
				if (respostaJOP == JOptionPane.NO_OPTION) {
					return;
				}
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnAlterar.setFocusable(false);
		btnAlterar.setBackground(new Color(0, 73, 170));
		btnAlterar.setBounds(442, 401, 89, 23);
		frmAtualizarClientes.getContentPane().add(btnAlterar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherCampos();
				
				btnAlterar.setVisible(true);
				btnRemover.setVisible(false);
				btnCancelar.setVisible(false);
				btnSalvar.setVisible(false);
				
				rbFisica.setEnabled(false);
				rbJuridica.setEnabled(false);
				tfNome.setEnabled(false);
				tfRazaoSocial.setEnabled(false);
				tfEmailF.setEnabled(false);
				tfEmailJ.setEnabled(false);
				rbMasculino.setEnabled(false);
				rbFeminino.setEnabled(false);
				comboUFF.setEnabled(false);
				comboUFJ.setEnabled(false);
				comboCidadeF.setEnabled(false);
				comboCidadeJ.setEnabled(false);
				btnAdicionarCidadeF.setEnabled(false);
				btnAdicionarCidadeJ.setEnabled(false);
				comboBairroF.setEnabled(false);
				comboBairroJ.setEnabled(false);
				btnAdicionarBairroF.setEnabled(false);
				btnAdicionarBairroJ.setEnabled(false);
				comboRuaF.setEnabled(false);
				comboRuaJ.setEnabled(false);
				btnAdicionarRuaF.setEnabled(false);
				btnAdicionarRuaJ.setEnabled(false);
				tfNumeroF.setEnabled(false);
				tfNumeroJ.setEnabled(false);
				tfCPF.setEnabled(false);
				tfCNPJ.setEnabled(false);
				tfRG.setEnabled(false);
				tfIE.setEnabled(false);
				tfMae.setEnabled(false);
				tfPai.setEnabled(false);
				tfDataDeNascimento.setEnabled(false);
				comboEstadoCivil.setEnabled(false);
				tfTel1F.setEnabled(false);
				tfTel1J.setEnabled(false);
				tfTel2F.setEnabled(false);
				tfTel2J.setEnabled(false);
				tfCel1F.setEnabled(false);
				tfCel1J.setEnabled(false);
				tfCel2F.setEnabled(false);
				tfCel2J.setEnabled(false);
			}
		});
		btnCancelar.setVisible(false);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(new Color(0, 73, 170));
		btnCancelar.setBounds(343, 401, 89, 23);
		frmAtualizarClientes.getContentPane().add(btnCancelar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbFisica.isSelected()) {
					Clientes cliFi = new Clientes();
					cliFi.setTipoDePessoa("Física");
					cliFi.setNomeRazao(tfNome.getText().toString());
					if (rbMasculino.isSelected()) {
						cliFi.setSexo("M");
					}else {
						cliFi.setSexo("F");
					}
					cliFi.setEmail(tfEmailF.getText().toString());
					/*
					cliFi.setUF(comboUFF.getSelectedItem().toString());
					cliFi.setCidade(comboCidadeF.getSelectedItem().toString());
					cliFi.setBairro(comboBairroF.getSelectedItem().toString());
					cliFi.setRua(comboRuaF.getSelectedItem().toString());
					*/
					cliFi.setUF("testeUF1");
					cliFi.setCidade("testeCidade1");
					cliFi.setBairro("testeBairro1");
					cliFi.setRua("testeRua1");
					
					cliFi.setNumero(tfNumeroF.getText().toString());
					cliFi.setCPF_CNPJ(tfCPF.getText().toString());
					cliFi.setRG_IE(tfRG.getText().toString());
					cliFi.setMae(tfMae.getText().toString());
					cliFi.setPai(tfPai.getText().toString());
					cliFi.setDataDeNascimento(tfDataDeNascimento.getText().toString());
					cliFi.setEstadoCivil(comboEstadoCivil.getSelectedItem().toString());
					cliFi.setTel1(tfTel1F.getText().toString());
					cliFi.setTel2(tfTel2F.getText().toString());
					cliFi.setCel1(tfCel1F.getText().toString());
					cliFi.setCel2(tfCel2F.getText().toString());
					
					CRUDClientes update = new CRUDClientes();
					update.updateCliente(cliFi, idCliente);
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
					
					btnAlterar.setVisible(true);
					btnRemover.setVisible(false);
					btnCancelar.setVisible(false);
					btnSalvar.setVisible(false);
					
					rbFisica.setEnabled(false);
					rbJuridica.setEnabled(false);
					tfNome.setEnabled(false);
					tfRazaoSocial.setEnabled(false);
					tfEmailF.setEnabled(false);
					tfEmailJ.setEnabled(false);
					rbMasculino.setEnabled(false);
					rbFeminino.setEnabled(false);
					comboUFF.setEnabled(false);
					comboUFJ.setEnabled(false);
					comboCidadeF.setEnabled(false);
					comboCidadeJ.setEnabled(false);
					btnAdicionarCidadeF.setEnabled(false);
					btnAdicionarCidadeJ.setEnabled(false);
					comboBairroF.setEnabled(false);
					comboBairroJ.setEnabled(false);
					btnAdicionarBairroF.setEnabled(false);
					btnAdicionarBairroJ.setEnabled(false);
					comboRuaF.setEnabled(false);
					comboRuaJ.setEnabled(false);
					btnAdicionarRuaF.setEnabled(false);
					btnAdicionarRuaJ.setEnabled(false);
					tfNumeroF.setEnabled(false);
					tfNumeroJ.setEnabled(false);
					tfCPF.setEnabled(false);
					tfCNPJ.setEnabled(false);
					tfRG.setEnabled(false);
					tfIE.setEnabled(false);
					tfMae.setEnabled(false);
					tfPai.setEnabled(false);
					tfDataDeNascimento.setEnabled(false);
					comboEstadoCivil.setEnabled(false);
					tfTel1F.setEnabled(false);
					tfTel1J.setEnabled(false);
					tfTel2F.setEnabled(false);
					tfTel2J.setEnabled(false);
					tfCel1F.setEnabled(false);
					tfCel1J.setEnabled(false);
					tfCel2F.setEnabled(false);
					tfCel2J.setEnabled(false);
				}else {
					Clientes cliJu = new Clientes();
					cliJu.setTipoDePessoa("Jurídica");
					cliJu.setNomeRazao(tfRazaoSocial.getText().toString());
					cliJu.setSexo("-");
					cliJu.setEmail(tfEmailJ.getText().toString());
					/*
					cliJu.setUF(comboUFJ.getSelectedItem().toString());
					cliJu.setCidade(comboCidadeJ.getSelectedItem().toString());
					cliJu.setBairro(comboBairroJ.getSelectedItem().toString());
					cliJu.setRua(comboRuaJ.getSelectedItem().toString());
					*/
					cliJu.setUF("testeUF2");
					cliJu.setCidade("testeCidade2");
					cliJu.setBairro("testeBairro2");
					cliJu.setRua("testeRua2");
					
					cliJu.setNumero(tfNumeroJ.getText().toString());
					cliJu.setCPF_CNPJ(tfCNPJ.getText().toString());
					cliJu.setRG_IE(tfIE.getText().toString());
					cliJu.setMae("----------");
					cliJu.setPai("----------");
					cliJu.setDataDeNascimento("----------");
					cliJu.setEstadoCivil("----------");
					cliJu.setTel1(tfTel1J.getText().toString());
					cliJu.setTel2(tfTel2J.getText().toString());
					cliJu.setCel1(tfCel1J.getText().toString());
					cliJu.setCel2(tfCel2J.getText().toString());
					
					CRUDClientes update = new CRUDClientes();
					update.updateCliente(cliJu, idCliente);
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
					btnCancelar.doClick();
				}
			}
		});
		btnSalvar.setVisible(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(442, 401, 89, 23);
		frmAtualizarClientes.getContentPane().add(btnSalvar);
		
		ButtonGroup grupoTipoDePessoa = new ButtonGroup();
		grupoTipoDePessoa.add(rbFisica);
		grupoTipoDePessoa.add(rbJuridica);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rbMasculino);
		grupoSexo.add(rbFeminino);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja romover o cliente?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					int idSelecionado = 0;
					CRUDClientes id = new CRUDClientes();
					id.selectDadosClienteEspecifico(ConsultarClientes.cliSelecionado);
					try {
						if (id.dadosEspecificos.first()) {
							idSelecionado = id.dadosEspecificos.getInt("id_cliente");
							id.deleteCliente(idSelecionado);
							
							JOptionPane.showMessageDialog(null, "O cliente foi removido com sucesso!");
							ConsultarClientes.main(null);
							frmAtualizarClientes.dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (respostaJOP == JOptionPane.NO_OPTION) {
					return;
				}
			}
		});
		btnRemover.setVisible(false);
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Impact", Font.PLAIN, 13));
		btnRemover.setFocusable(false);
		btnRemover.setBackground(new Color(0, 73, 170));
		btnRemover.setBounds(244, 401, 89, 23);
		frmAtualizarClientes.getContentPane().add(btnRemover);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(553, 547, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 553, 547);
		frmAtualizarClientes.getContentPane().add(lblBG);
		
		preencherCampos();
	}
	
	private boolean preencherCampos() {
		CRUDClientes select = new CRUDClientes();
		select.selectDadosClienteEspecifico(ConsultarClientes.cliSelecionado);
		try {
			if (select.dadosEspecificos.first()) {
				idCliente = select.dadosEspecificos.getInt("id_cliente");
				if (select.dadosEspecificos.getString("tipo_de_pessoa").equals("Física")) {
					rbFisica.setSelected(true);
					pnFisica.setVisible(true);
					pnJuridica.setVisible(false);
					
					tfNome.setText(select.dadosEspecificos.getString("nome_razao").toString());
					if (select.dadosEspecificos.getString("sexo").equalsIgnoreCase("M")) {
						rbMasculino.setSelected(true);
						rbFeminino.setSelected(false);
					}
					if (select.dadosEspecificos.getString("sexo").equalsIgnoreCase("F")) {
						rbMasculino.setSelected(false);
						rbFeminino.setSelected(true);
					}
					tfEmailF.setText(select.dadosEspecificos.getString("email").toString());
					//comboUFF.setSelectedItem(select.dadosEspecificos.getString("uf").toString());
					comboUFF.setSelectedItem(select.dadosEspecificos.getString("uf").toString());
					comboCidadeF.setSelectedItem(select.dadosEspecificos.getString("cidade").toString());
					comboBairroF.setSelectedItem(select.dadosEspecificos.getString("bairro").toString());
					comboRuaF.setSelectedItem(select.dadosEspecificos.getString("rua").toString());
					tfNumeroF.setText(select.dadosEspecificos.getString("numero").toString());
					tfCPF.setText(select.dadosEspecificos.getString("cpf_cnpj").toString());
					tfRG.setText(select.dadosEspecificos.getString("rg_ie").toString());
					tfMae.setText(select.dadosEspecificos.getString("mae").toString());
					tfPai.setText(select.dadosEspecificos.getString("pai").toString());
					tfDataDeNascimento.setText(select.dadosEspecificos.getString("data_de_nascimento").toString());
					comboEstadoCivil.setSelectedItem(select.dadosEspecificos.getString("estado_civil").toString());
					tfTel1F.setText(select.dadosEspecificos.getString("tel1").toString());
					tfTel2F.setText(select.dadosEspecificos.getString("tel2").toString());
					tfCel1F.setText(select.dadosEspecificos.getString("cel1").toString());
					tfCel2F.setText(select.dadosEspecificos.getString("cel2").toString());
					
				}
				if (select.dadosEspecificos.getString("tipo_de_pessoa").equals("Jurídica")) {
					rbJuridica.setSelected(true);
					pnJuridica.setVisible(true);
					pnFisica.setVisible(false);
					
					tfRazaoSocial.setText(select.dadosEspecificos.getString("nome_razao").toString());
					tfEmailJ.setText(select.dadosEspecificos.getString("email").toString());
					comboCidadeJ.setSelectedItem(select.dadosEspecificos.getString("cidade").toString());
					comboBairroJ.setSelectedItem(select.dadosEspecificos.getString("bairro").toString());
					comboRuaJ.setSelectedItem(select.dadosEspecificos.getString("rua").toString());
					tfNumeroJ.setText(select.dadosEspecificos.getString("numero").toString());
					tfCNPJ.setText(select.dadosEspecificos.getString("cpf_cnpj").toString());
					tfIE.setText(select.dadosEspecificos.getString("rg_ie").toString());
					tfTel1J.setText(select.dadosEspecificos.getString("tel1").toString());
					tfTel2J.setText(select.dadosEspecificos.getString("tel2").toString());
					tfCel1J.setText(select.dadosEspecificos.getString("cel1").toString());
					tfCel2J.setText(select.dadosEspecificos.getString("cel2").toString());
				}
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
