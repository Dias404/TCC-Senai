package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.border.LineBorder;

import Administrador.AlterarDados;
import Administrador.CadastrarLoja;
import Administrador.CadastrarUsuario;
import Administrador.MandarEmail;
import CRUD.CRUDUsuarios;
import Clientes.CadastroDeClientes;
import Clientes.ConsultarClientes;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaPrincipal {

	public static JFrame frmPrincipal;
	private JPanel pnCliente;
	private JPanel pnEstoque;
	private JPanel pnCaixa;

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
		ResultSet rs = CRUDUsuarios.selectUsuarioLogado();
		String nivel = null;
		String usuario = null;
		try {
			if(rs.first()) {
				nivel = rs.getString("nivel");
				usuario = rs.getString("nome");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frmPrincipal = new JFrame();
		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				
			}
			@Override
			public void windowClosing(WindowEvent arg0) {
				int escolha = JOptionPane.showConfirmDialog(frmPrincipal,
						"Você deseja desconectar desta conta?", "Aviso", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(escolha==0) {
							CRUDUsuarios.logoff();
							frmPrincipal.dispose();
							Login.main(null);
						}else {
							
						}
			}
		});
		frmPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/Img/SIG 16x16.png")));
		frmPrincipal.setTitle("SIG");
		frmPrincipal.setBounds(100, 100, 492, 346);
		frmPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmPrincipal.setResizable(false);
		frmPrincipal.setLocationRelativeTo(null);
		frmPrincipal.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/SIG 129.png")));
		lblLogo.setBounds(10, 11, 172, 129);
		frmPrincipal.getContentPane().add(lblLogo);
		
		if(nivel.equalsIgnoreCase("Admin")) {
			JLabel lblAdmin = new JLabel("Op\u00E7\u00F5es do");
			lblAdmin.setBounds(192, 11, 113, 16);
			frmPrincipal.getContentPane().add(lblAdmin);
			lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAdmin.setBorder(null);
		
			JLabel lblAdmin2 = new JLabel("Administrador->");
			lblAdmin2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAdmin2.setBorder(null);
			lblAdmin2.setBounds(192, 29, 113, 16);
			frmPrincipal.getContentPane().add(lblAdmin2);
			
			JButton btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
			btnCadastrarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CadastrarUsuario.main(null);
					frmPrincipal.setEnabled(false);
				}
			});
			btnCadastrarUsuario.setBounds(307, 11, 151, 23);
			frmPrincipal.getContentPane().add(btnCadastrarUsuario);
			btnCadastrarUsuario.setForeground(Color.WHITE);
			btnCadastrarUsuario.setFont(new Font("Impact", Font.PLAIN, 13));
			btnCadastrarUsuario.setBackground(Color.decode("#0049aa"));
			btnCadastrarUsuario.setFocusable(false);
			
			JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
			btnCadastrarLoja.setBounds(307, 45, 151, 23);
			frmPrincipal.getContentPane().add(btnCadastrarLoja);
			btnCadastrarLoja.setForeground(Color.WHITE);
			btnCadastrarLoja.setFont(new Font("Impact", Font.PLAIN, 13));
			btnCadastrarLoja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadastrarLoja.main(null);
					frmPrincipal.setEnabled(false);
				}
			});
			btnCadastrarLoja.setBackground(Color.decode("#0049aa"));
			btnCadastrarLoja.setFocusable(false);
			
			JButton btnMandarEmail = new JButton("Mandar Email");
			btnMandarEmail.setBounds(307, 79, 151, 23);
			frmPrincipal.getContentPane().add(btnMandarEmail);
			btnMandarEmail.setForeground(Color.WHITE);
			btnMandarEmail.setFont(new Font("Impact", Font.PLAIN, 13));
			btnMandarEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MandarEmail.main(null);
					frmPrincipal.setEnabled(false);
				}
			});
			btnMandarEmail.setFocusable(false);
			btnMandarEmail.setBackground(Color.decode("#0049aa"));
			
			JButton btnAlterarDados = new JButton("Alterar Dados");
			btnAlterarDados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AlterarDados.main(null);
					frmPrincipal.setEnabled(false);
				}
			});
			btnAlterarDados.setForeground(Color.WHITE);
			btnAlterarDados.setFont(new Font("Impact", Font.PLAIN, 13));
			btnAlterarDados.setFocusable(false);
			btnAlterarDados.setBackground(Color.decode("#0049aa"));
			btnAlterarDados.setBounds(307, 113, 151, 23);
			frmPrincipal.getContentPane().add(btnAlterarDados);
			
			JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsuario.setBounds(192, 56, 57, 14);
			frmPrincipal.getContentPane().add(lblUsuario);
			
			JLabel lblNomeUsuario = new JLabel(usuario);
			lblNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNomeUsuario.setBounds(192, 79, 105, 14);
			frmPrincipal.getContentPane().add(lblNomeUsuario);
			
			JLabel lblNivel = new JLabel("N\u00EDvel:");
			lblNivel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNivel.setBounds(192, 104, 57, 14);
			frmPrincipal.getContentPane().add(lblNivel);
			
			JLabel lblNivelUsuario = null;
			lblNivelUsuario = new JLabel(nivel);
			lblNivelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNivelUsuario.setBounds(192, 127, 105, 14);
			frmPrincipal.getContentPane().add(lblNivelUsuario);
			
		}else {
			JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsuario.setBounds(215, 29, 57, 14);
			frmPrincipal.getContentPane().add(lblUsuario);
			
			JLabel lblNomeUsuario = new JLabel(usuario);
			lblNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNomeUsuario.setBounds(215, 52, 105, 14);
			frmPrincipal.getContentPane().add(lblNomeUsuario);
			
			JLabel lblNivel = new JLabel("N\u00EDvel:");
			lblNivel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNivel.setBounds(215, 77, 57, 14);
			frmPrincipal.getContentPane().add(lblNivel);
			
			JLabel lblNivelUsuario = null;
			lblNivelUsuario = new JLabel(nivel);
			lblNivelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNivelUsuario.setBounds(215, 100, 105, 14);
			frmPrincipal.getContentPane().add(lblNivelUsuario);
			
		}
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setBackground(Color.decode("#0049aa"));
		btnCliente.setFocusable(false);
		btnCliente.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnCliente.setVisible(true);
				pnCaixa.setVisible(false);
				pnEstoque.setVisible(false);
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 466, 2);
		frmPrincipal.getContentPane().add(separator);
		btnCliente.setBounds(10, 173, 89, 23);
		frmPrincipal.getContentPane().add(btnCliente);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setForeground(Color.WHITE);
		btnCaixa.setBackground(Color.decode("#0049aa"));
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
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setForeground(Color.WHITE);
		btnEstoque.setBackground(Color.decode("#0049aa"));
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
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(frmPrincipal,
						"Você deseja desconectar desta conta?", "Aviso", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(escolha==0) {
							CRUDUsuarios.logoff();
							frmPrincipal.dispose();
							Login.main(null);
						}else {
							
						}
			}
		});
		btnSair.setBackground(Color.decode("#0049aa"));
		btnSair.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSair.setFocusable(false);
		btnSair.setBounds(10, 275, 89, 23);
		frmPrincipal.getContentPane().add(btnSair);
		
		pnCliente = new JPanel();
		pnCliente.setOpaque(false);
		pnCliente.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnCliente);
		pnCliente.setLayout(null);
		
		JButton btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/clientes.png")));
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setFocusable(false);
		btnClientes.setBackground(Color.decode("#0049aa"));
		btnClientes.setBounds(63, 11, 94, 59);
		pnCliente.add(btnClientes);
		
		JButton btnTroca = new JButton("");
		btnTroca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/troca.png")));
		btnTroca.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTroca.setFocusable(false);
		btnTroca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTroca.setBackground(Color.decode("#0049aa"));
		btnTroca.setBounds(167, 11, 94, 59);
		pnCliente.add(btnTroca);
		
		JButton btnBaixaDemonstracao = new JButton("");
		btnBaixaDemonstracao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/baixaDemonstracao.png")));
		btnBaixaDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaixaDemonstracao.setFocusable(false);
		btnBaixaDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaixaDemonstracao.setBackground(Color.decode("#0049aa"));
		btnBaixaDemonstracao.setBounds(167, 81, 94, 59);
		pnCliente.add(btnBaixaDemonstracao);
		
		JButton btnDemonstracao = new JButton("");
		btnDemonstracao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/demonstracao.png")));
		btnDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDemonstracao.setFocusable(false);
		btnDemonstracao.setBackground(Color.decode("#0049aa"));
		btnDemonstracao.setBounds(63, 81, 94, 59);
		pnCliente.add(btnDemonstracao);
		
		pnCaixa = new JPanel();
		pnCaixa.setVisible(false);
		pnCaixa.setOpaque(false);
		pnCaixa.setLayout(null);
		pnCaixa.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnCaixa);
		
		JButton btnVenda = new JButton("");
		btnVenda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/vendas.png")));
		btnVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVenda.setFocusable(false);
		btnVenda.setBackground(Color.decode("#0049aa"));
		btnVenda.setBounds(10, 11, 94, 59);
		pnCaixa.add(btnVenda);
		
		JButton btnRecebimento = new JButton("");
		btnRecebimento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/recebimento.png")));
		btnRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecebimento.setFocusable(false);
		btnRecebimento.setBackground(Color.decode("#0049aa"));
		btnRecebimento.setBounds(114, 11, 94, 59);
		pnCaixa.add(btnRecebimento);
		
		JButton btnCorrecaoParcela = new JButton("");
		btnCorrecaoParcela.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/correcao.png")));
		btnCorrecaoParcela.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecaoParcela.setFocusable(false);
		btnCorrecaoParcela.setBackground(Color.decode("#0049aa"));
		btnCorrecaoParcela.setBounds(218, 11, 94, 59);
		pnCaixa.add(btnCorrecaoParcela);
		
		JButton btnLancamento = new JButton("");
		btnLancamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/lancamento.png")));
		btnLancamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLancamento.setFocusable(false);
		btnLancamento.setBackground(Color.decode("#0049aa"));
		btnLancamento.setBounds(10, 81, 94, 59);
		pnCaixa.add(btnLancamento);
		
		JButton btnConferencia = new JButton("");
		btnConferencia.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/conferencia.png")));
		btnConferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConferencia.setFocusable(false);
		btnConferencia.setBackground(Color.decode("#0049aa"));
		btnConferencia.setBounds(114, 81, 94, 59);
		pnCaixa.add(btnConferencia);
		
		JButton btnContas = new JButton("");
		btnContas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/contasAPagar.png")));
		btnContas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnContas.setFocusable(false);
		btnContas.setBackground(Color.decode("#0049aa"));
		btnContas.setBounds(218, 81, 94, 59);
		pnCaixa.add(btnContas);
		
		pnEstoque = new JPanel();
		pnEstoque.setVisible(false);
		pnEstoque.setOpaque(false);
		pnEstoque.setBounds(152, 159, 324, 148);
		frmPrincipal.getContentPane().add(pnEstoque);
		pnEstoque.setLayout(null);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/consulta.png")));
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsulta.setFocusable(false);
		btnConsulta.setBackground(Color.decode("#0049aa"));
		btnConsulta.setBounds(63, 11, 94, 59);
		pnEstoque.add(btnConsulta);
		
		JButton btnEntrada = new JButton("");
		btnEntrada.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/entrada.png")));
		btnEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrada.setFocusable(false);
		btnEntrada.setBackground(Color.decode("#0049aa"));
		btnEntrada.setBounds(167, 11, 94, 59);
		pnEstoque.add(btnEntrada);
		
		JButton btnCorrecaoProduto = new JButton("");
		btnCorrecaoProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/correcao.png")));
		btnCorrecaoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecaoProduto.setFocusable(false);
		btnCorrecaoProduto.setBackground(Color.decode("#0049aa"));
		btnCorrecaoProduto.setBounds(63, 81, 94, 59);
		pnEstoque.add(btnCorrecaoProduto);
		
		JButton btnTransferencia = new JButton("");
		btnTransferencia.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/transferencia.png")));
		btnTransferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTransferencia.setFocusable(false);
		btnTransferencia.setBackground(Color.decode("#0049aa"));
		btnTransferencia.setBounds(167, 81, 94, 59);
		pnEstoque.add(btnTransferencia);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/backgroundPrincipal.jpg")));
		lblBG.setBounds(0, 0, 486, 317);
		frmPrincipal.getContentPane().add(lblBG);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeClientes.main(null);
				frmPrincipal.setVisible(false);
				frmPrincipal.setVisible(false);
			}
		});
	}
}
