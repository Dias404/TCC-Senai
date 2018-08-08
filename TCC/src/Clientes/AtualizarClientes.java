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
import javax.swing.text.MaskFormatter;

import Administrador.CadastrarUsuario;
import CRUD.CRUDClientes;
import CRUD.CRUDLugar;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AtualizarClientes {

	private JFrame frmAtualizarClientes;
	private JTextField tfRazaoSocial;
	private JTextField tfEmailJ;
	private JTextField tfNumeroJ;
	private JFormattedTextField ftfCNPJ;
	private JFormattedTextField ftfIE;
	private JTextField tfTel1J;
	private JTextField tfTel2J;
	private JTextField tfCel1J;
	private JTextField tfCel2J;
	private JButton btnCancelar;
	private JButton btnVoltar;
	private JButton btnAlterar;
	private JButton btnSalvar;
	private JComboBox comboUFJ;
	private JRadioButton rbFisica;
	private JRadioButton rbJuridica;
	private JTextField tfNome;
	private JTextField tfEmailF;
	private JTextField tfNumeroF;
	private JFormattedTextField ftfCPF;
	private JFormattedTextField ftfRG;
	private JTextField tfMae;
	private JTextField tfPai;
	private JTextField tfTel1F;
	private JTextField tfTel2F;
	private JTextField tfCel1F;
	private JTextField tfCel2F;
	private JPanel pnFisica;
	private JPanel pnJuridica;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JComboBox comboUFF;
	private JComboBox comboEstadoCivil;
	private JButton btnRemover;
	private JLabel lblBG;
	private JTextField tfDataDeNascimento;
	private JTextField tfBairroF;
	private JTextField tfRuaF;
	private JTextField tfCidadeF;
	private JTextField tfBairroJ;
	private JTextField tfRuaJ;
	private JTextField tfCidadeJ;
	
	private int idCliente = 0;
	private JButton btnCalendario;
	private JPanel pnCalendario;
	
	static String dataDeNascimento = null;
	
	Date dataSelect = new Date();
	Date dataInformada = new Date();
	Date datateste = new Date();
	
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraCNPJ;
	private MaskFormatter mascaraRG;
	private MaskFormatter mascaraIE;
	
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
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraRG = new MaskFormatter("##.###.###-#");
			mascaraIE = new MaskFormatter("###.###.###.###");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		pnCalendario = new JPanel();
		pnCalendario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnCalendario.setVisible(false);
		pnCalendario.setBounds(320, 228, 201, 97);
		pnFisica.add(pnCalendario);
		pnCalendario.setLayout(null);
		
		JCalendar calendario = new JCalendar();

		//calendario.setDate();
		
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				String data = formatoBR.format(calendario.getDate());
				tfDataDeNascimento.setText(data);
			}
		});
		
		calendario.setBounds(0, 0, 201, 97);
		pnCalendario.add(calendario);
		
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
		
		JLabel lblN = new JLabel("N°:");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblN.setBounds(262, 138, 38, 14);
		pnFisica.add(lblN);
		
		tfNumeroF = new JTextField();
		tfNumeroF.setEnabled(false);
		tfNumeroF.setColumns(10);
		tfNumeroF.setBounds(310, 135, 200, 20);
		pnFisica.add(tfNumeroF);
		
		ftfCPF = new JFormattedTextField(mascaraCPF);
		ftfCPF.setEnabled(false);
		ftfCPF.setColumns(10);
		ftfCPF.setBounds(58, 166, 200, 20);
		pnFisica.add(ftfCPF);
		
		JLabel label_19 = new JLabel("CPF:");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(21, 168, 27, 14);
		pnFisica.add(label_19);
		
		ftfRG = new JFormattedTextField(mascaraRG);
		ftfRG.setEnabled(false);
		ftfRG.setColumns(10);
		ftfRG.setBounds(58, 197, 200, 20);
		pnFisica.add(ftfRG);
		
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
		
		JLabel lblN_1 = new JLabel("N°:");
		lblN_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblN_1.setBounds(249, 137, 51, 14);
		pnJuridica.add(lblN_1);
		
		tfNumeroJ = new JTextField();
		tfNumeroJ.setEnabled(false);
		tfNumeroJ.setColumns(10);
		tfNumeroJ.setBounds(310, 135, 200, 20);
		pnJuridica.add(tfNumeroJ);
		
		ftfCNPJ = new JFormattedTextField(mascaraCNPJ);
		ftfCNPJ.setEnabled(false);
		ftfCNPJ.setColumns(10);
		ftfCNPJ.setBounds(58, 166, 200, 20);
		pnJuridica.add(ftfCNPJ);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCnpj.setBounds(10, 168, 38, 14);
		pnJuridica.add(lblCnpj);
		
		ftfIE = new JFormattedTextField(mascaraIE);
		ftfIE.setEnabled(false);
		ftfIE.setColumns(10);
		ftfIE.setBounds(310, 168, 200, 20);
		pnJuridica.add(ftfIE);
		
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
		tfCel1J.setBounds(310, 197, 200, 20);
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
		
		tfBairroJ = new JTextField();
		tfBairroJ.setEnabled(false);
		tfBairroJ.setColumns(10);
		tfBairroJ.setBounds(58, 104, 200, 20);
		pnJuridica.add(tfBairroJ);
		
		tfRuaJ = new JTextField();
		tfRuaJ.setEnabled(false);
		tfRuaJ.setColumns(10);
		tfRuaJ.setBounds(58, 136, 200, 20);
		pnJuridica.add(tfRuaJ);
		
		tfCidadeJ = new JTextField();
		tfCidadeJ.setEnabled(false);
		tfCidadeJ.setColumns(10);
		tfCidadeJ.setBounds(313, 74, 200, 20);
		pnJuridica.add(tfCidadeJ);
		
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
					tfCidadeF.setEnabled(true);
					tfCidadeJ.setEnabled(true);
					tfBairroF.setEnabled(true);
					tfBairroJ.setEnabled(true);
					tfRuaF.setEnabled(true);
					tfRuaJ.setEnabled(true);
					tfNumeroF.setEnabled(true);
					tfNumeroJ.setEnabled(true);
					ftfCPF.setEnabled(true);
					ftfCNPJ.setEnabled(true);
					ftfRG.setEnabled(true);
					ftfIE.setEnabled(true);
					tfMae.setEnabled(true);
					tfPai.setEnabled(true);
					tfDataDeNascimento.setEnabled(true);
					btnCalendario.setEnabled(true);
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
				tfCidadeF.setEnabled(false);
				tfCidadeJ.setEnabled(false);
				tfBairroF.setEnabled(false);
				tfBairroJ.setEnabled(false);
				tfRuaF.setEnabled(false);
				tfRuaJ.setEnabled(false);
				tfNumeroF.setEnabled(false);
				tfNumeroJ.setEnabled(false);
				ftfCPF.setEnabled(false);
				ftfCNPJ.setEnabled(false);
				ftfRG.setEnabled(false);
				ftfIE.setEnabled(false);
				tfMae.setEnabled(false);
				tfPai.setEnabled(false);
				tfDataDeNascimento.setEnabled(false);
				btnCalendario.setEnabled(false);
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
					String nome = tfNome.getText().toString();
					String email = tfEmailF.getText().toString();
					String estado = comboUFF.getSelectedItem().toString();
					String cidade = tfCidadeF.getText().toString();
					String bairro = tfBairroF.getText().toString();
					String rua = tfRuaF.getText().toString();
					String numero = tfNumeroF.getText().trim().toString();
					String cpf = ftfCPF.getText().toString();
					String rg = ftfRG.getText().toString();
					String mae = tfMae.getText().toString();
					String pai = tfPai.getText().toString();
					String dataDeNascimento = tfDataDeNascimento.getText().toString();
					String tel1 = tfTel1F.getText().toString();
					String tel2 = tfTel2F.getText().toString();
					String cel1 = tfCel1F.getText().toString();
					String cel2 = tfCel2F.getText().toString();
					
					if (nome.trim().isEmpty() || email.trim().isEmpty() || cidade.trim().isEmpty() || bairro.trim().isEmpty() || rua.trim().isEmpty() || numero.trim().isEmpty() || cpf.trim().isEmpty() || rg.trim().isEmpty() || mae.trim().isEmpty() || pai.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
					} else {
						if (tel1.trim().isEmpty() && tel2.trim().isEmpty() && cel1.trim().isEmpty() && cel2.trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "É necessário preencher no mínimo um campo de contato!",null, JOptionPane.WARNING_MESSAGE);
						} else {
							Clientes cliFi = new Clientes();
							cliFi.setTipoDePessoa("Física");
							cliFi.setNomeRazao(nome);
							if (rbMasculino.isSelected()) {
								cliFi.setSexo("M");
							}else {
								cliFi.setSexo("F");
							}
							cliFi.setEmail(email);
							cliFi.setUF(estado);
							cliFi.setCidade(cidade);
							cliFi.setBairro(bairro);
							cliFi.setRua(rua);
							cliFi.setNumero(numero);
							cliFi.setCPF_CNPJ(cpf);
							cliFi.setRG_IE(rg);
							cliFi.setMae(mae);
							cliFi.setPai(pai);
							cliFi.setDataDeNascimento(dataDeNascimento);
							cliFi.setEstadoCivil(comboEstadoCivil.getSelectedItem().toString());
							cliFi.setTel1(tel1);
							cliFi.setTel2(tel2);
							cliFi.setCel1(cel1);
							cliFi.setCel2(cel2);
							
							CRUDClientes update = new CRUDClientes();
							update.updateCliente(cliFi, idCliente);
							JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
							btnCancelar.doClick();
						}
					}
				}else {
					String razaoSocial = tfRazaoSocial.getText().toString();
					String email = tfEmailJ.getText().toString();
					String estado = comboUFJ.getSelectedItem().toString();
					String cidade = tfCidadeJ.getText().toString();
					String bairro = tfBairroJ.getText().toString();
					String rua = tfRuaJ.getText().toString();
					String numero = tfNumeroJ.getText().trim().toString();
					String cnpj = ftfCNPJ.getText().toString();
					String ie = ftfIE.getText().toString();
					String tel1 = tfTel1J.getText().toString();
					String tel2 = tfTel2J.getText().toString();
					String cel1 = tfCel1J.getText().toString();
					String cel2 = tfCel2J.getText().toString();
					
					if (razaoSocial.trim().isEmpty() || email.trim().isEmpty() || cidade.trim().isEmpty() || bairro.trim().isEmpty() || rua.trim().isEmpty() || numero.trim().isEmpty() || cnpj.trim().isEmpty() || ie.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
					} else {
						if (tel1.trim().isEmpty() && tel2.trim().isEmpty() && cel1.trim().isEmpty() && cel2.trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "É necessário preencher no mínimo um campo de contato!",null, JOptionPane.WARNING_MESSAGE);
						} else {
							Clientes cliJu = new Clientes();
							cliJu.setNomeRazao(razaoSocial);
							cliJu.setSexo("-");
							cliJu.setEmail(email);
							cliJu.setUF(estado);
							cliJu.setCidade(cidade);
							cliJu.setBairro(bairro);
							cliJu.setRua(rua);
							cliJu.setNumero(numero);
							cliJu.setCPF_CNPJ(cnpj);
							cliJu.setRG_IE(ie);
							cliJu.setMae("-");
							cliJu.setPai("-");
							cliJu.setDataDeNascimento("-");
							cliJu.setEstadoCivil("-");
							cliJu.setTel1(tel1);
							cliJu.setTel2(tel2);
							cliJu.setCel1(cel1);
							cliJu.setCel2(cel2);
							
							CRUDClientes update = new CRUDClientes();
							update.updateCliente(cliJu, idCliente);
							JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
							btnCancelar.doClick();
						}
					}
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
		
		btnCalendario = new JButton("...");
		btnCalendario.setFocusable(false);
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnCalendario.isVisible()) {
					pnCalendario.setVisible(false);
				} else {
					pnCalendario.setVisible(true);
				}
			}
		});
		btnCalendario.setForeground(Color.WHITE);
		btnCalendario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalendario.setEnabled(false);
		btnCalendario.setBackground(new Color(0, 73, 170));
		btnCalendario.setBounds(283, 228, 27, 23);
		pnFisica.add(btnCalendario);
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setEnabled(false);
		tfDataDeNascimento.setFocusable(false);
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(157, 228, 116, 20);
		pnFisica.add(tfDataDeNascimento);
		
		tfBairroF = new JTextField();
		tfBairroF.setEnabled(false);
		tfBairroF.setColumns(10);
		tfBairroF.setBounds(58, 104, 200, 20);
		pnFisica.add(tfBairroF);
		
		tfRuaF = new JTextField();
		tfRuaF.setEnabled(false);
		tfRuaF.setColumns(10);
		tfRuaF.setBounds(58, 136, 200, 20);
		pnFisica.add(tfRuaF);
		
		tfCidadeF = new JTextField();
		tfCidadeF.setEnabled(false);
		tfCidadeF.setColumns(10);
		tfCidadeF.setBounds(310, 74, 200, 20);
		pnFisica.add(tfCidadeF);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja romover o cliente?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					CRUDClientes delete = new CRUDClientes();
					delete.deleteCliente(ConsultarClientes.cliSelecionado);
							
					JOptionPane.showMessageDialog(null, "O cliente foi removido com sucesso!");
					ConsultarClientes.main(null);
					frmAtualizarClientes.dispose();
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
		Image BG2 = BG.getImage().getScaledInstance(542, 436, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 542, 436);
		frmAtualizarClientes.getContentPane().add(lblBG);
		
		preencherComboUF();
		preencherCampos();
	}
	
	private boolean preencherComboUF() {
		CRUDLugar selecionar = new CRUDLugar();
		selecionar.selectEstados();
		comboUFF.removeAllItems();
		comboUFJ.removeAllItems();
		try {
			while (selecionar.dados.next()) {
				comboUFF.addItem(selecionar.dados.getString("nome_estado"));
				comboUFJ.addItem(selecionar.dados.getString("nome_estado"));
			}
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean preencherCampos() {
		CRUDClientes select = new CRUDClientes();
		select.selectDadosClienteEspecifico(ConsultarClientes.cliSelecionado);
		
		try {
			if (select.dadosEspecificos.first()) {
				idCliente = select.dadosEspecificos.getInt("id_cliente");
				if (select.dadosEspecificos.getString("tipo_de_pessoa").equals("Física")) {
					String nome = select.dadosEspecificos.getString("nome_razao").toString();
					String sexo = select.dadosEspecificos.getString("sexo");
					String email = select.dadosEspecificos.getString("email").toString();
					String estado = select.dadosEspecificos.getString("uf").toString();
					String cidade = select.dadosEspecificos.getString("cidade").toString();
					String bairro = select.dadosEspecificos.getString("bairro").toString();
					String rua = select.dadosEspecificos.getString("rua").toString();
					String numero = select.dadosEspecificos.getString("numero").toString();
					String cpf = select.dadosEspecificos.getString("cpf_cnpj").toString();
					String rg = select.dadosEspecificos.getString("rg_ie").toString();
					String mae = select.dadosEspecificos.getString("mae").toString();
					String pai = select.dadosEspecificos.getString("pai").toString();
					dataDeNascimento = select.dadosEspecificos.getString("data_de_nascimento").toString();
					String estadoCivil = select.dadosEspecificos.getString("estado_civil").toString();
					String tel1 = select.dadosEspecificos.getString("tel1").toString();
					String tel2 = select.dadosEspecificos.getString("tel2").toString();
					String cel1 = select.dadosEspecificos.getString("cel1").toString();
					String cel2 = select.dadosEspecificos.getString("cel2").toString();
					
					rbFisica.setSelected(true);
					pnFisica.setVisible(true);
					pnJuridica.setVisible(false);
					
					if (sexo.equalsIgnoreCase("M")) {
						rbMasculino.setSelected(true);
						rbFeminino.setSelected(false);
					}
					if (sexo.equalsIgnoreCase("F")) {
						rbMasculino.setSelected(false);
						rbFeminino.setSelected(true);
					}
					tfNome.setText(nome);
					tfEmailF.setText(email);
					comboUFF.setSelectedItem(estado);
					tfCidadeF.setText(cidade);
					tfBairroF.setText(bairro);
					tfRuaF.setText(rua);
					tfNumeroF.setText(numero);
					ftfCPF.setText(cpf);
					ftfRG.setText(rg);
					tfMae.setText(mae);
					tfPai.setText(pai);
					tfDataDeNascimento.setText(dataDeNascimento);
					comboEstadoCivil.setSelectedItem(estadoCivil);
					tfTel1F.setText(tel1);
					tfTel2F.setText(tel2);
					tfCel1F.setText(cel1);
					tfCel2F.setText(cel2);
				}
				if (select.dadosEspecificos.getString("tipo_de_pessoa").equals("Jurídica")) {
					String razaoSocial = select.dadosEspecificos.getString("nome_razao").toString();
					String email = select.dadosEspecificos.getString("email").toString();
					String estado = select.dadosEspecificos.getString("uf").toString();
					String cidade = select.dadosEspecificos.getString("cidade").toString();
					String bairro = select.dadosEspecificos.getString("bairro").toString();
					String rua = select.dadosEspecificos.getString("rua").toString();
					String numero = select.dadosEspecificos.getString("numero").toString();
					String cnpj = select.dadosEspecificos.getString("cpf_cnpj").toString();
					String ie = select.dadosEspecificos.getString("rg_ie").toString();
					String tel1 = select.dadosEspecificos.getString("tel1").toString();
					String tel2 = select.dadosEspecificos.getString("tel2").toString();
					String cel1 = select.dadosEspecificos.getString("cel1").toString();
					String cel2 = select.dadosEspecificos.getString("cel2").toString();
					
					rbJuridica.setSelected(true);
					pnJuridica.setVisible(true);
					pnFisica.setVisible(false);
					
					tfRazaoSocial.setText(razaoSocial);
					tfEmailJ.setText(email);
					comboUFJ.setSelectedItem(estado);
					tfCidadeF.setText(cidade);
					tfBairroF.setText(bairro);
					tfRuaF.setText(rua);
					tfNumeroJ.setText(numero);
					ftfCNPJ.setText(cnpj);
					ftfIE.setText(ie);
					tfTel1J.setText(tel1);
					tfTel2J.setText(tel2);
					tfCel1J.setText(cel1);
					tfCel2J.setText(cel2);
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
