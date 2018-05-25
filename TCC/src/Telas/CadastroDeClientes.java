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
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblTel;
	private JTextField textField_2;
	private JLabel lblTel_1;
	private JLabel lblCel;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblCel_1;
	private JTextField textField_5;
	private JLabel lblObs;

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
		
		JPanel pnFisica = new JPanel();
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
		
		btnAdicionarCidade = new JButton("...");
		btnAdicionarCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Entre com o nome da nova cidade:");
			}
		});
		btnAdicionarCidade.setFocusable(false);
		btnAdicionarCidade.setBackground(new Color(0, 73, 170));
		btnAdicionarCidade.setForeground(Color.WHITE);
		btnAdicionarCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidade.setBounds(483, 72, 27, 23);
		pnFisica.add(btnAdicionarCidade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(255, 76, 45, 14);
		pnFisica.add(lblCidade);
		
		JComboBox comboUF = new JComboBox();
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		comboUF.setBounds(58, 73, 133, 20);
		comboUF.setSelectedItem("São Paulo");
		pnFisica.add(comboUF);
		
		rbFisica = new JRadioButton("Física");
		rbFisica.setOpaque(false);
		rbFisica.setFocusable(false);
		rbFisica.setSelected(true);
		rbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFisica.setBounds(10, 35, 57, 23);
		frmCadastroDeClientes.getContentPane().add(rbFisica);
		
		rbJuridica = new JRadioButton("Jurídica");
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
		
		btnAdicionarBairro = new JButton("...");
		btnAdicionarBairro.setForeground(Color.WHITE);
		btnAdicionarBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarBairro.setFocusable(false);
		btnAdicionarBairro.setBackground(new Color(0, 73, 170));
		btnAdicionarBairro.setBounds(300, 102, 27, 23);
		pnFisica.add(btnAdicionarBairro);
		
		btnAdicionarRua = new JButton("...");
		btnAdicionarRua.setForeground(Color.WHITE);
		btnAdicionarRua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarRua.setFocusable(false);
		btnAdicionarRua.setBackground(new Color(0, 73, 170));
		btnAdicionarRua.setBounds(300, 134, 27, 23);
		pnFisica.add(btnAdicionarRua);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(157, 229, 153, 20);
		pnFisica.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(58, 260, 200, 20);
		pnFisica.add(textField_1);
		
		lblTel = new JLabel("Tel 1:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTel.setBounds(10, 262, 38, 14);
		pnFisica.add(lblTel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(58, 291, 200, 20);
		pnFisica.add(textField_2);
		
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(310, 260, 200, 20);
		pnFisica.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(310, 291, 200, 20);
		pnFisica.add(textField_4);
		
		lblCel_1 = new JLabel("Cel 2");
		lblCel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel_1.setBounds(262, 294, 38, 14);
		pnFisica.add(lblCel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(58, 322, 452, 83);
		pnFisica.add(textField_5);
		
		lblObs = new JLabel("Obs:");
		lblObs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObs.setBounds(10, 325, 38, 14);
		pnFisica.add(lblObs);
	}
}
