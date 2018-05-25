package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroDeClientes {

	private JFrame frmCadastroDeClientes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMasculino.setBounds(383, 4, 77, 14);
		panel.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFeminino.setBounds(383, 21, 77, 14);
		panel.add(rdbtnFeminino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(343, 13, 34, 14);
		panel.add(lblSexo);
		
		textField = new JTextField();
		textField.setBounds(58, 11, 266, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 44, 40, 14);
		panel.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(58, 42, 266, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(58, 73, 133, 20);
		panel.add(textField_2);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUf.setBounds(8, 76, 40, 14);
		panel.add(lblUf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 73, 133, 20);
		panel.add(textField_3);
		
		JButton button = new JButton("...");
		button.setBackground(new Color(0, 73, 170));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(433, 71, 27, 23);
		panel.add(button);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(235, 76, 45, 14);
		panel.add(lblCidade);
		
		JRadioButton rdbtnFsica = new JRadioButton("Física");
		rdbtnFsica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFsica.setBounds(10, 35, 57, 23);
		frmCadastroDeClientes.getContentPane().add(rdbtnFsica);
		
		JRadioButton rdbtnJurdica = new JRadioButton("Jurídica");
		rdbtnJurdica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnJurdica.setBounds(69, 35, 71, 23);
		frmCadastroDeClientes.getContentPane().add(rdbtnJurdica);
		frmCadastroDeClientes.setResizable(false);
		frmCadastroDeClientes.setLocationRelativeTo(null);
	}
}
