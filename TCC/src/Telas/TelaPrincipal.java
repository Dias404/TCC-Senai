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
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

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
		
		Panel pnAdmin = new Panel();
		pnAdmin.setBounds(190, 11, 188, 134);
		frmPrincipal.getContentPane().add(pnAdmin);
		pnAdmin.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Op\u00E7\u00F5es do Administrador:");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin.setBounds(10, 5, 168, 16);
		pnAdmin.add(lblAdmin);
		lblAdmin.setBorder(null);
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarUsuario.setBounds(10, 32, 151, 23);
		pnAdmin.add(btnCadastrarUsuario);
		btnCadastrarUsuario.setBackground(SystemColor.menu);
		btnCadastrarUsuario.setFocusable(false);
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarLoja.setBounds(10, 66, 151, 23);
		pnAdmin.add(btnCadastrarLoja);
		btnCadastrarLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarLoja.setBackground(SystemColor.menu);
		btnCadastrarLoja.setFocusable(false);
		
		JButton btnMandarEmail = new JButton("Mandar Email");
		btnMandarEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMandarEmail.setBounds(10, 100, 151, 23);
		pnAdmin.add(btnMandarEmail);
		btnMandarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMandarEmail.setFocusable(false);
		btnMandarEmail.setBackground(SystemColor.menu);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBackground(SystemColor.menu);
		btnCliente.setFocusable(false);
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 466, 2);
		frmPrincipal.getContentPane().add(separator);
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
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setFocusable(false);
		btnClientes.setBackground(SystemColor.menu);
		btnClientes.setBounds(10, 11, 115, 48);
		pnCliente.add(btnClientes);
		
		JButton btnDemonstracao = new JButton("Demonstracao");
		btnDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDemonstracao.setFocusable(false);
		btnDemonstracao.setBackground(SystemColor.menu);
		btnDemonstracao.setBounds(10, 89, 120, 48);
		pnCliente.add(btnDemonstracao);
		
		JButton btnTroca = new JButton("Troca");
		btnTroca.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTroca.setFocusable(false);
		btnTroca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTroca.setBackground(SystemColor.menu);
		btnTroca.setBounds(199, 89, 115, 48);
		pnCliente.add(btnTroca);
		
		JButton btnBaixaDemonstracao = new JButton("Baixa");
		btnBaixaDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaixaDemonstracao.setFocusable(false);
		btnBaixaDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaixaDemonstracao.setBackground(SystemColor.menu);
		btnBaixaDemonstracao.setBounds(199, 11, 115, 48);
		pnCliente.add(btnBaixaDemonstracao);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
