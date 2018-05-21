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
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/SIG 129.png")));
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
		btnCadastrarUsuario.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCadastrarUsuario.setBackground(SystemColor.textHighlight);
		btnCadastrarUsuario.setFocusable(false);
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setBounds(192, 61, 151, 23);
		frmPrincipal.getContentPane().add(btnCadastrarLoja);
		btnCadastrarLoja.setForeground(Color.WHITE);
		btnCadastrarLoja.setFont(new Font("Impact", Font.PLAIN, 13));
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
		btnMandarEmail.setFont(new Font("Impact", Font.PLAIN, 13));
		btnMandarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMandarEmail.setFocusable(false);
		btnMandarEmail.setBackground(SystemColor.textHighlight);
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setBackground(SystemColor.textHighlight);
		btnCliente.setFocusable(false);
		btnCliente.setFont(new Font("Impact", Font.PLAIN, 13));
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
		btnAlterarSenha.setFont(new Font("Impact", Font.PLAIN, 13));
		btnAlterarSenha.setFocusable(false);
		btnAlterarSenha.setBackground(SystemColor.textHighlight);
		btnAlterarSenha.setBounds(192, 123, 151, 23);
		frmPrincipal.getContentPane().add(btnAlterarSenha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 466, 2);
		frmPrincipal.getContentPane().add(separator);
		btnCliente.setBounds(10, 173, 89, 23);
		frmPrincipal.getContentPane().add(btnCliente);
		
		JButton btnCaixa = new JButton("CAIXA");
		btnCaixa.setForeground(Color.WHITE);
		btnCaixa.setBackground(SystemColor.textHighlight);
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnCaixa.setVisible(true);
				pnCliente.setVisible(false);
				pnEstoque.setVisible(false);
			}
		});
		btnCaixa.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCaixa.setFocusable(false);
		btnCaixa.setBounds(10, 207, 89, 23);
		frmPrincipal.getContentPane().add(btnCaixa);
		
		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setForeground(Color.WHITE);
		btnEstoque.setBackground(SystemColor.textHighlight);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnEstoque.setVisible(true);
				pnCliente.setVisible(false);
				pnCaixa.setVisible(false);
			}
		});
		btnEstoque.setFont(new Font("Impact", Font.PLAIN, 13));
		btnEstoque.setFocusable(false);
		btnEstoque.setBounds(10, 241, 89, 23);
		frmPrincipal.getContentPane().add(btnEstoque);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.WHITE);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPrincipal.dispose();
			}
		});
		btnSair.setBackground(SystemColor.textHighlight);
		btnSair.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSair.setFocusable(false);
		btnSair.setBounds(10, 275, 89, 23);
		frmPrincipal.getContentPane().add(btnSair);
		
		pnCliente = new Panel();
		pnCliente.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnCliente);
		pnCliente.setLayout(null);
		
		JButton btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/clientes.png")));
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setFocusable(false);
		btnClientes.setBackground(SystemColor.menu);
		btnClientes.setBounds(10, 11, 94, 59);
		pnCliente.add(btnClientes);
		
		JButton btnTroca = new JButton("");
		btnTroca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/troca.png")));
		btnTroca.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTroca.setFocusable(false);
		btnTroca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnBaixaDemonstracao = new JButton("");
		btnBaixaDemonstracao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/baixaDemonstracao.png")));
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
		
		JButton btnDemonstracao = new JButton("");
		btnDemonstracao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/demonstracao.png")));
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
		
		JButton btnVenda = new JButton("");
		btnVenda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/vendas.png")));
		btnVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVenda.setFocusable(false);
		btnVenda.setBackground(SystemColor.menu);
		btnVenda.setBounds(10, 11, 94, 59);
		pnCaixa.add(btnVenda);
		
		JButton btnRecebimento = new JButton("");
		btnRecebimento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/recebimento.png")));
		btnRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecebimento.setFocusable(false);
		btnRecebimento.setBackground(SystemColor.menu);
		btnRecebimento.setBounds(114, 11, 94, 59);
		pnCaixa.add(btnRecebimento);
		
		JButton btnCorrecaoParcela = new JButton("");
		btnCorrecaoParcela.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/correcao.png")));
		btnCorrecaoParcela.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecaoParcela.setFocusable(false);
		btnCorrecaoParcela.setBackground(SystemColor.menu);
		btnCorrecaoParcela.setBounds(218, 11, 94, 59);
		pnCaixa.add(btnCorrecaoParcela);
		
		JButton btnLancamento = new JButton("");
		btnLancamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/lancamento.png")));
		btnLancamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLancamento.setFocusable(false);
		btnLancamento.setBackground(SystemColor.menu);
		btnLancamento.setBounds(10, 81, 94, 59);
		pnCaixa.add(btnLancamento);
		
		JButton btnConferencia = new JButton("");
		btnConferencia.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/conferencia.png")));
		btnConferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConferencia.setFocusable(false);
		btnConferencia.setBackground(SystemColor.menu);
		btnConferencia.setBounds(114, 81, 94, 59);
		pnCaixa.add(btnConferencia);
		
		JButton btnContas = new JButton("");
		btnContas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/contasAPagar.png")));
		btnContas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnContas.setFocusable(false);
		btnContas.setBackground(SystemColor.menu);
		btnContas.setBounds(218, 81, 94, 59);
		pnCaixa.add(btnContas);
		
		pnEstoque = new Panel();
		pnEstoque.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnEstoque);
		pnEstoque.setLayout(null);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/consulta.png")));
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsulta.setFocusable(false);
		btnConsulta.setBackground(SystemColor.menu);
		btnConsulta.setBounds(10, 11, 94, 59);
		pnEstoque.add(btnConsulta);
		
		JButton btnEntrada = new JButton("");
		btnEntrada.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/entrada.png")));
		btnEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrada.setFocusable(false);
		btnEntrada.setBackground(SystemColor.menu);
		btnEntrada.setBounds(114, 11, 94, 59);
		pnEstoque.add(btnEntrada);
		
		JButton btnCorrecaoProduto = new JButton("");
		btnCorrecaoProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/correcao.png")));
		btnCorrecaoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecaoProduto.setFocusable(false);
		btnCorrecaoProduto.setBackground(SystemColor.menu);
		btnCorrecaoProduto.setBounds(10, 81, 94, 59);
		pnEstoque.add(btnCorrecaoProduto);
		
		JButton btnTransferencia = new JButton("");
		btnTransferencia.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/transferencia.png")));
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
