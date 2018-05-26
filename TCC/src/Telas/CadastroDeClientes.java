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

public class CadastroDeClientes {

	private JFrame frmCadastroDeClientes;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfCidade;
	private JButton btnAdicionarCidade;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JRadioButton rbFisica;
	private JRadioButton rbJuridica;
	private JTextField tfBairro;
	private JTextField tfRua;
	private JButton btnAdicionarBairro;
	private JButton btnAdicionarRua;
	private JTextField tfNumero;
	private JTextField tfCPF;
	private JLabel lblCpf;
	private JTextField tfRG;
	private JLabel lblRg;
	private JTextField tfMae;
	private JTextField tfPai;
	private JLabel lblMe;
	private JLabel lblPai;
	private JTextField tfEstadoCivil;
	private JLabel lblData;
	private JLabel lblEstadoCivil;
	private JTextField tfDataDeNascimento;
	private JTextField tfTelefone1;
	private JLabel lblTel;
	private JTextField tfTelefone2;
	private JLabel lblTel_1;
	private JLabel lblCel;
	private JTextField tfCelular1;
	private JTextField tfCelular2;
	private JLabel lblCel_1;
	private JTextField tfObservações;
	private JLabel lblObs;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JPanel pnJuridica;
	private JLabel label;
	private JTextField tfRazaoSocial;
	private JLabel label_1;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField tfEmailJ;
	private JLabel label_3;
	private JTextField textField_3;
	private JLabel label_4;
	private JTextField textField_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel label_7;
	private JTextField textField_7;
	private JLabel label_8;
	private JTextField textField_8;
	private JLabel label_9;
	private JTextField textField_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel label_12;
	private JTextField textField_12;
	private JLabel label_13;
	private JPanel pnFisica;

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
		
		pnJuridica = new JPanel();
		pnJuridica.setVisible(false);
		
		btnAdicionarRua = new JButton("...");
		btnAdicionarRua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Entre com o nome da nova rua:");
			}
		});
		btnAdicionarRua.setBounds(310, 199, 27, 23);
		frmCadastroDeClientes.getContentPane().add(btnAdicionarRua);
		btnAdicionarRua.setForeground(Color.WHITE);
		btnAdicionarRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarRua.setFocusable(false);
		btnAdicionarRua.setBackground(new Color(0, 73, 170));
		
		btnAdicionarBairro = new JButton("...");
		btnAdicionarBairro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Entre com o nome do novo bairro:");
			}
		});
		btnAdicionarBairro.setBounds(310, 167, 27, 23);
		frmCadastroDeClientes.getContentPane().add(btnAdicionarBairro);
		btnAdicionarBairro.setForeground(Color.WHITE);
		btnAdicionarBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairro.setFocusable(false);
		btnAdicionarBairro.setBackground(new Color(0, 73, 170));
		
		JComboBox comboUF = new JComboBox();
		comboUF.setBounds(68, 138, 133, 20);
		frmCadastroDeClientes.getContentPane().add(comboUF);
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		comboUF.setSelectedItem("São Paulo");
		
		btnAdicionarCidade = new JButton("...");
		btnAdicionarCidade.setBounds(493, 137, 27, 23);
		frmCadastroDeClientes.getContentPane().add(btnAdicionarCidade);
		btnAdicionarCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Entre com o nome da nova cidade:");
			}
		});
		btnAdicionarCidade.setFocusable(false);
		btnAdicionarCidade.setBackground(new Color(0, 73, 170));
		btnAdicionarCidade.setForeground(Color.WHITE);
		btnAdicionarCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnJuridica.setBounds(10, 65, 521, 416);
		frmCadastroDeClientes.getContentPane().add(pnJuridica);
		pnJuridica.setLayout(null);
		pnJuridica.setOpaque(false);
		
		label = new JLabel("Razão Social:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 13, 83, 14);
		pnJuridica.add(label);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBounds(103, 11, 407, 20);
		pnJuridica.add(tfRazaoSocial);
		
		label_1 = new JLabel("Email:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(8, 42, 40, 18);
		pnJuridica.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(58, 42, 232, 20);
		pnJuridica.add(textField_1);
		
		label_2 = new JLabel("UF:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(30, 76, 18, 14);
		pnJuridica.add(label_2);
		
		tfEmailJ = new JTextField();
		tfEmailJ.setColumns(10);
		tfEmailJ.setBounds(310, 73, 163, 20);
		pnJuridica.add(tfEmailJ);
		
		label_3 = new JLabel("Cidade:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(255, 76, 45, 14);
		pnJuridica.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(58, 104, 232, 20);
		pnJuridica.add(textField_3);
		
		label_4 = new JLabel("Bairro:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(8, 106, 40, 14);
		pnJuridica.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(58, 135, 232, 20);
		pnJuridica.add(textField_4);
		
		label_5 = new JLabel("Rua:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(18, 138, 32, 14);
		pnJuridica.add(label_5);
		
		label_6 = new JLabel("Número:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(346, 137, 51, 14);
		pnJuridica.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(407, 135, 103, 20);
		pnJuridica.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(58, 166, 200, 20);
		pnJuridica.add(textField_6);
		
		label_7 = new JLabel("CNPJ:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(10, 168, 38, 14);
		pnJuridica.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(310, 168, 200, 20);
		pnJuridica.add(textField_7);
		
		label_8 = new JLabel("IE:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(273, 168, 27, 14);
		pnJuridica.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(58, 197, 200, 20);
		pnJuridica.add(textField_8);
		
		label_9 = new JLabel("Tel 1:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(10, 199, 38, 14);
		pnJuridica.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(58, 228, 200, 20);
		pnJuridica.add(textField_9);
		
		label_10 = new JLabel("Tel 2:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(10, 230, 38, 14);
		pnJuridica.add(label_10);
		
		label_11 = new JLabel("Cel 1:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(262, 199, 38, 14);
		pnJuridica.add(label_11);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(310, 199, 200, 20);
		pnJuridica.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(310, 228, 200, 20);
		pnJuridica.add(textField_11);
		
		label_12 = new JLabel("Cel 2:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(262, 230, 38, 14);
		pnJuridica.add(label_12);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(58, 259, 452, 146);
		pnJuridica.add(textField_12);
		
		label_13 = new JLabel("Obs:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(10, 259, 38, 14);
		pnJuridica.add(label_13);
		
		pnFisica = new JPanel();
		pnFisica.setOpaque(false);
		pnFisica.setLayout(null);
		pnFisica.setBounds(10, 65, 521, 416);
		frmCadastroDeClientes.getContentPane().add(pnFisica);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 13, 38, 14);
		pnFisica.add(lblNome);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setOpaque(false);
		rbMasculino.setFocusable(false);
		rbMasculino.setSelected(true);
		rbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMasculino.setBounds(407, 4, 77, 14);
		pnFisica.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setOpaque(false);
		rbFeminino.setFocusable(false);
		rbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFeminino.setBounds(407, 21, 77, 14);
		pnFisica.add(rbFeminino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(367, 13, 34, 14);
		pnFisica.add(lblSexo);
		
		tfNome = new JTextField();
		tfNome.setBounds(58, 11, 266, 20);
		pnFisica.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 44, 40, 14);
		pnFisica.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(58, 42, 266, 20);
		pnFisica.add(tfEmail);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(30, 76, 18, 14);
		pnFisica.add(lblUf);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(310, 73, 163, 20);
		pnFisica.add(tfCidade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(255, 76, 45, 14);
		pnFisica.add(lblCidade);
		
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
		grupoMasculinoFeminino.add(rbMasculino);
		grupoMasculinoFeminino.add(rbFeminino);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(58, 104, 232, 20);
		pnFisica.add(tfBairro);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setBounds(8, 106, 40, 14);
		pnFisica.add(lblBairro);
		
		tfRua = new JTextField();
		tfRua.setColumns(10);
		tfRua.setBounds(58, 135, 232, 20);
		pnFisica.add(tfRua);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRua.setBounds(18, 138, 32, 14);
		pnFisica.add(lblRua);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNmero.setBounds(346, 137, 51, 14);
		pnFisica.add(lblNmero);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(407, 135, 103, 20);
		pnFisica.add(tfNumero);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(58, 166, 200, 20);
		pnFisica.add(tfCPF);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(21, 168, 27, 14);
		pnFisica.add(lblCpf);
		
		tfRG = new JTextField();
		tfRG.setColumns(10);
		tfRG.setBounds(58, 197, 200, 20);
		pnFisica.add(tfRG);
		
		lblRg = new JLabel("RG:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRg.setBounds(21, 199, 27, 14);
		pnFisica.add(lblRg);
		
		tfMae = new JTextField();
		tfMae.setColumns(10);
		tfMae.setBounds(310, 168, 200, 20);
		pnFisica.add(tfMae);
		
		tfPai = new JTextField();
		tfPai.setColumns(10);
		tfPai.setBounds(310, 197, 200, 20);
		pnFisica.add(tfPai);
		
		lblMe = new JLabel("Mãe:");
		lblMe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMe.setBounds(262, 168, 38, 14);
		pnFisica.add(lblMe);
		
		lblPai = new JLabel("Pai:");
		lblPai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPai.setBounds(262, 199, 38, 14);
		pnFisica.add(lblPai);
		
		tfEstadoCivil = new JTextField();
		tfEstadoCivil.setColumns(10);
		tfEstadoCivil.setBounds(407, 229, 103, 20);
		pnFisica.add(tfEstadoCivil);
		
		lblData = new JLabel("Data de nascimento:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(21, 231, 126, 14);
		pnFisica.add(lblData);
		
		lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadoCivil.setBounds(320, 232, 77, 14);
		pnFisica.add(lblEstadoCivil);
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(157, 229, 153, 20);
		pnFisica.add(tfDataDeNascimento);
		
		tfTelefone1 = new JTextField();
		tfTelefone1.setColumns(10);
		tfTelefone1.setBounds(58, 260, 200, 20);
		pnFisica.add(tfTelefone1);
		
		lblTel = new JLabel("Tel 1:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel.setBounds(10, 262, 38, 14);
		pnFisica.add(lblTel);
		
		tfTelefone2 = new JTextField();
		tfTelefone2.setColumns(10);
		tfTelefone2.setBounds(58, 291, 200, 20);
		pnFisica.add(tfTelefone2);
		
		lblTel_1 = new JLabel("Tel 2:");
		lblTel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel_1.setBounds(10, 294, 38, 14);
		pnFisica.add(lblTel_1);
		
		lblCel = new JLabel("Cel 1:");
		lblCel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(262, 262, 38, 14);
		pnFisica.add(lblCel);
		
		tfCelular1 = new JTextField();
		tfCelular1.setColumns(10);
		tfCelular1.setBounds(310, 260, 200, 20);
		pnFisica.add(tfCelular1);
		
		tfCelular2 = new JTextField();
		tfCelular2.setColumns(10);
		tfCelular2.setBounds(310, 291, 200, 20);
		pnFisica.add(tfCelular2);
		
		lblCel_1 = new JLabel("Cel 2");
		lblCel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel_1.setBounds(262, 294, 38, 14);
		pnFisica.add(lblCel_1);
		
		tfObservações = new JTextField();
		tfObservações.setColumns(10);
		tfObservações.setBounds(58, 322, 452, 83);
		pnFisica.add(tfObservações);
		
		lblObs = new JLabel("Obs:");
		lblObs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObs.setBounds(10, 325, 38, 14);
		pnFisica.add(lblObs);
		
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
	}
}
