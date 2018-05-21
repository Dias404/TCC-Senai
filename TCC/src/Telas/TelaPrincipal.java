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
	private Panel pnCliente;
	private Panel pnEstoque;
	private Panel pnCaixa;

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
		
		JLabel lblAdmin = new JLabel("Op\u00E7\u00F5es do Administrador:");
		lblAdmin.setBounds(192, 8, 168, 16);
		frmPrincipal.getContentPane().add(lblAdmin);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin.setBorder(null);
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.setBounds(192, 30, 151, 23);
		frmPrincipal.getContentPane().add(btnCadastrarUsuario);
		btnCadastrarUsuario.setForeground(Color.WHITE);
		btnCadastrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarUsuario.setBackground(SystemColor.textHighlight);
		btnCadastrarUsuario.setFocusable(false);
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setBounds(192, 61, 151, 23);
		frmPrincipal.getContentPane().add(btnCadastrarLoja);
		btnCadastrarLoja.setForeground(Color.WHITE);
		btnCadastrarLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarLoja.setBackground(SystemColor.textHighlight);
		btnCadastrarLoja.setFocusable(false);
		
		JButton btnMandarEmail = new JButton("Mandar Email");
		btnMandarEmail.setBounds(192, 92, 151, 23);
		frmPrincipal.getContentPane().add(btnMandarEmail);
		btnMandarEmail.setForeground(Color.WHITE);
		btnMandarEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMandarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMandarEmail.setFocusable(false);
		btnMandarEmail.setBackground(SystemColor.textHighlight);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setBackground(SystemColor.textHighlight);
		btnCliente.setFocusable(false);
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnCliente.setVisible(true);
				pnCaixa.setVisible(false);
				pnEstoque.setVisible(false);
			}
		});
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterarSenha.setForeground(Color.WHITE);
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterarSenha.setFocusable(false);
		btnAlterarSenha.setBackground(SystemColor.textHighlight);
		btnAlterarSenha.setBounds(192, 123, 151, 23);
		frmPrincipal.getContentPane().add(btnAlterarSenha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 466, 2);
		frmPrincipal.getContentPane().add(separator);
		btnCliente.setBounds(10, 173, 89, 23);
		frmPrincipal.getContentPane().add(btnCliente);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setForeground(Color.WHITE);
		btnCaixa.setBackground(SystemColor.textHighlight);
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnCaixa.setVisible(true);
				pnCliente.setVisible(false);
				pnEstoque.setVisible(false);
			}
		});
		btnCaixa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCaixa.setFocusable(false);
		btnCaixa.setBounds(10, 207, 89, 23);
		frmPrincipal.getContentPane().add(btnCaixa);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setForeground(Color.WHITE);
		btnEstoque.setBackground(SystemColor.textHighlight);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnEstoque.setVisible(true);
				pnCliente.setVisible(false);
				pnCaixa.setVisible(false);
			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEstoque.setFocusable(false);
		btnEstoque.setBounds(10, 241, 89, 23);
		frmPrincipal.getContentPane().add(btnEstoque);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPrincipal.dispose();
			}
		});
		btnSair.setBackground(SystemColor.textHighlight);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBounds(10, 275, 89, 23);
		frmPrincipal.getContentPane().add(btnSair);
		
		pnCliente = new Panel();
		pnCliente.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnCliente);
		pnCliente.setLayout(null);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setFocusable(false);
		btnClientes.setBackground(SystemColor.menu);
		btnClientes.setBounds(10, 11, 94, 59);
		pnCliente.add(btnClientes);
		
		JButton btnTroca = new JButton("Troca");
		btnTroca.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTroca.setFocusable(false);
		btnTroca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnBaixaDemonstracao = new JButton("Baixa");
		btnBaixaDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaixaDemonstracao.setFocusable(false);
		btnBaixaDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaixaDemonstracao.setBackground(SystemColor.menu);
		btnBaixaDemonstracao.setBounds(114, 81, 94, 59);
		pnCliente.add(btnBaixaDemonstracao);
		btnTroca.setBackground(SystemColor.menu);
		btnTroca.setBounds(114, 11, 94, 59);
		pnCliente.add(btnTroca);
		
		JButton btnDemonstracao = new JButton("Demonstracao");
		btnDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDemonstracao.setFocusable(false);
		btnDemonstracao.setBackground(SystemColor.menu);
		btnDemonstracao.setBounds(10, 81, 94, 59);
		pnCliente.add(btnDemonstracao);
		
		pnCaixa = new Panel();
		pnCaixa.setLayout(null);
		pnCaixa.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnCaixa);
		
		JButton btnVenda = new JButton("Venda");
		btnVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVenda.setFocusable(false);
		btnVenda.setBackground(SystemColor.menu);
		btnVenda.setBounds(10, 11, 94, 59);
		pnCaixa.add(btnVenda);
		
		JButton btnRecebimento = new JButton("Recebimento");
		btnRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecebimento.setFocusable(false);
		btnRecebimento.setBackground(SystemColor.menu);
		btnRecebimento.setBounds(114, 11, 94, 59);
		pnCaixa.add(btnRecebimento);
		
		JButton btnCorrecao = new JButton("Corre\u00E7\u00E3o");
		btnCorrecao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecao.setFocusable(false);
		btnCorrecao.setBackground(SystemColor.menu);
		btnCorrecao.setBounds(218, 11, 94, 59);
		pnCaixa.add(btnCorrecao);
		
		JButton btnLancamento = new JButton("Lan\u00E7amento");
		btnLancamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLancamento.setFocusable(false);
		btnLancamento.setBackground(SystemColor.menu);
		btnLancamento.setBounds(10, 81, 94, 59);
		pnCaixa.add(btnLancamento);
		
		JButton btnConferencia = new JButton("Confer\u00EAncia");
		btnConferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConferencia.setFocusable(false);
		btnConferencia.setBackground(SystemColor.menu);
		btnConferencia.setBounds(114, 81, 94, 59);
		pnCaixa.add(btnConferencia);
		
		JButton btnContas = new JButton("Contas a Pagar");
		btnContas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnContas.setFocusable(false);
		btnContas.setBackground(SystemColor.menu);
		btnContas.setBounds(218, 81, 94, 59);
		pnCaixa.add(btnContas);
		
		pnEstoque = new Panel();
		pnEstoque.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnEstoque);
		pnEstoque.setLayout(null);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsulta.setFocusable(false);
		btnConsulta.setBackground(SystemColor.menu);
		btnConsulta.setBounds(10, 11, 94, 59);
		pnEstoque.add(btnConsulta);
		
		JButton btnEntrada = new JButton("Entrada");
		btnEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrada.setFocusable(false);
		btnEntrada.setBackground(SystemColor.menu);
		btnEntrada.setBounds(114, 11, 94, 59);
		pnEstoque.add(btnEntrada);
		
		JButton btnManutencao = new JButton("Manuten\u00E7\u00E3o");
		btnManutencao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnManutencao.setFocusable(false);
		btnManutencao.setBackground(SystemColor.menu);
		btnManutencao.setBounds(10, 81, 94, 59);
		pnEstoque.add(btnManutencao);
		
		JButton btnTransferencia = new JButton("Transfer\u00EAncia");
		btnTransferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTransferencia.setFocusable(false);
		btnTransferencia.setBackground(SystemColor.menu);
		btnTransferencia.setBounds(114, 81, 94, 59);
		pnEstoque.add(btnTransferencia);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
