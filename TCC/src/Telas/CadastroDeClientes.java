package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class CadastroDeClientes {

	private JFrame frmCadastroDeClientes;

	/**
	  POSSÍVEIS CAMPOS PARA O CADASTRO:
	  - Nome Completo do Cliente ou Razão Social
	  - Tipo de Pessoa(Física ou Jurídica)
	  - Endereço(Rua e/ou CEP, Bairro, Cidade, Estado(UF), País(talvez))
	  - Naturalidade(talvez)
	  - Email de Contato
	  - Telefone e/ou Celular
	  - FAX(talvez)
	  - CPF ou CNPJ
	  - Sexo(talvez)
	  - Data de Nascimento(talvez)
	  - RG ou IE
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
		frmCadastroDeClientes.setTitle("Cadastro de Clientes");
		frmCadastroDeClientes.setBounds(100, 100, 450, 300);
		frmCadastroDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeClientes.getContentPane().setLayout(null);
		frmCadastroDeClientes.setResizable(false);
		frmCadastroDeClientes.setLocationRelativeTo(null);
	}

}
