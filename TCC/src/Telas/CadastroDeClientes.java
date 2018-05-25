package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
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
		frmCadastroDeClientes.setBounds(100, 100, 492, 575);
		frmCadastroDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeClientes.getContentPane().setLayout(null);
		
		JLabel lblCadastrosDeClientes = new JLabel("Cadastros de Clientes");
		lblCadastrosDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrosDeClientes.setBounds(10, 11, 149, 17);
		frmCadastroDeClientes.getContentPane().add(lblCadastrosDeClientes);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(10, 65, 466, 471);
		frmCadastroDeClientes.getContentPane().add(panel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 13, 38, 14);
		panel.add(lblNome);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setOpaque(false);
		rbMasculino.setFocusable(false);
		rbMasculino.setSelected(true);
		rbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMasculino.setBounds(383, 4, 77, 14);
		panel.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setOpaque(false);
		rbFeminino.setFocusable(false);
		rbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFeminino.setBounds(383, 21, 77, 14);
		panel.add(rbFeminino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(343, 13, 34, 14);
		panel.add(lblSexo);
		
		tfNome = new JTextField();
		tfNome.setBounds(58, 11, 266, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 44, 40, 14);
		panel.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(58, 42, 266, 20);
		panel.add(tfEmail);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(8, 76, 40, 14);
		panel.add(lblUf);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(290, 73, 133, 20);
		panel.add(tfCidade);
		
		btnAdicionarCidade = new JButton("...");
		btnAdicionarCidade.setFocusable(false);
		btnAdicionarCidade.setBackground(new Color(0, 73, 170));
		btnAdicionarCidade.setForeground(Color.WHITE);
		btnAdicionarCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionarCidade.setBounds(433, 71, 27, 23);
		panel.add(btnAdicionarCidade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(235, 76, 45, 14);
		panel.add(lblCidade);
		
		JComboBox comboUF = new JComboBox();
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		comboUF.setBounds(58, 73, 133, 20);
		panel.add(comboUF);
		
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
	}
}
