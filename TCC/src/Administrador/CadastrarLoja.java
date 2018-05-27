package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class CadastrarLoja {

	private JFrame frmCadastrarLoja;

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
		frmCadastrarLoja.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarLoja.class.getResource("/Img/SIG 16x16.png")));
		frmCadastrarLoja.setTitle("SIG - Cadastrar Loja");
		frmCadastrarLoja.setResizable(false);
		frmCadastrarLoja.setBounds(100, 100, 450, 300);
		frmCadastrarLoja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarLoja.getContentPane().setLayout(null);
	}

}
