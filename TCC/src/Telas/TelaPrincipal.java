package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Panel;

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
		btnCadastrarLoja.setBackground(Color.LIGHT_GRAY);
		btnCadastrarLoja.setFocusable(false);
		btnCadastrarLoja.setBounds(338, 83, 138, 23);
		frmPrincipal.getContentPane().add(btnCadastrarLoja);
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.setBackground(Color.LIGHT_GRAY);
		btnCadastrarUsuario.setFocusable(false);
		btnCadastrarUsuario.setBounds(338, 117, 138, 23);
		frmPrincipal.getContentPane().add(btnCadastrarUsuario);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBackground(SystemColor.menu);
		btnCliente.setFocusable(false);
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCliente.setBounds(10, 164, 89, 23);
		frmPrincipal.getContentPane().add(btnCliente);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setBackground(SystemColor.menu);
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCaixa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCaixa.setFocusable(false);
		btnCaixa.setBounds(10, 198, 89, 23);
		frmPrincipal.getContentPane().add(btnCaixa);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBackground(SystemColor.menu);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEstoque.setFocusable(false);
		btnEstoque.setBounds(10, 232, 89, 23);
		frmPrincipal.getContentPane().add(btnEstoque);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(SystemColor.menu);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBounds(10, 266, 89, 23);
		frmPrincipal.getContentPane().add(btnSair);
		
		Panel pnCliente = new Panel();
		pnCliente.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnCliente);
		pnCliente.setLayout(null);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.setBounds(10, 11, 59, 48);
		pnCliente.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
