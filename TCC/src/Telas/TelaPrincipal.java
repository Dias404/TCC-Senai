package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class TelaPrincipal {

	private JFrame frmPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("SIG");
		frmPrincipal.setBounds(100, 100, 492, 346);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.setResizable(false);
		frmPrincipal.setLocationRelativeTo(null);
		frmPrincipal.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("Dias coloca o Logo");
		lblLogo.setBounds(10, 11, 172, 129);
		frmPrincipal.getContentPane().add(lblLogo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 466, 2);
		frmPrincipal.getContentPane().add(separator);
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setFocusable(false);
		btnCadastrarLoja.setBounds(192, 117, 141, 23);
		frmPrincipal.getContentPane().add(btnCadastrarLoja);
	}
}
