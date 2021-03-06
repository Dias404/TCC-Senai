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
import java.awt.Image;
import Administrador.AlterarDados;
import Administrador.CadastrarLoja;
import Administrador.CadastrarUsuario;
import Administrador.MandarEmail;
import CRUD.CRUDUsuarios;
import Clientes.CadastroDeClientes;
import Lancamento.LancamentoDeGastos;
import Produtos.CadastrosDeProdutos;
import Produtos.Transferencia;
import Vendas.CadastroDeVendas;
import Vendas.ConsultarVendas;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.border.EtchedBorder;

public class TelaPrincipal {

	public static JFrame frmPrincipal;
	
	private JButton btnClientes;
	private JButton btnTroca;
	private JButton btnBaixaDemonstracao;
	private JButton btnDemonstracao;
	private JButton btnVenda;
	private JButton btnRecebimento;
	private JButton btnCorrecaoParcela;
	private JButton btnLancamento;
	private JButton btnConsulta;
	private JButton btnEntrada;
	private JButton btnTransferencia;
	private JLabel lblUsuario;
	private JLabel lblNivel;
	private JLabel lblOpcoeslAdmin;
	private JButton btnCadastrarUsuario;
	private JButton btnCadastrarLoja;
	private JButton btnMandarEmail;
	private JButton btnAlterarDados;
	private JButton btnCorrecaoProduto;
	private JButton btnConferencia;
	private JButton btnContas;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblEmail;
	
	
	static String nivel = null;
	static String email = null;
	public static String usuario;
	public static String senha;
	

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
		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int escolha = JOptionPane.showConfirmDialog(frmPrincipal, "Você deseja desconectar desta conta?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if(escolha == JOptionPane.YES_OPTION) {
						usuario = null;
						senha = null;
						CRUDUsuarios.logoff(usuario, senha);
						frmPrincipal.dispose();
						Login.main(null);
					}
			}
		});
		frmPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/Img/SIG 16x16.png")));
		frmPrincipal.setTitle("SIG - Menu Principal");
		frmPrincipal.setBounds(100, 100, 727, 435);
		frmPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmPrincipal.setResizable(false);
		frmPrincipal.setLocationRelativeTo(null);
		frmPrincipal.getContentPane().setLayout(null);
		
		ImageIcon logo = new ImageIcon(CadastrarUsuario.class.getResource("/Img/logoHD.png"));
		Image logo2 = logo.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
		logo = new ImageIcon(logo2);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(logo);
		lblLogo.setBounds(10, 11, 199, 176);
		frmPrincipal.getContentPane().add(lblLogo);
		
		JPanel pnCliente = new JPanel();
		pnCliente.setOpaque(false);
		pnCliente.setBounds(176, 245, 322, 151);
		frmPrincipal.getContentPane().add(pnCliente);
		pnCliente.setLayout(null);
		
		JPanel pnCaixa = new JPanel();
		pnCaixa.setVisible(false);
		pnCaixa.setOpaque(false);
		pnCaixa.setLayout(null);
		pnCaixa.setBounds(176, 245, 322, 151);
		frmPrincipal.getContentPane().add(pnCaixa);
		
		JPanel pnEstoque = new JPanel();
		pnEstoque.setVisible(false);
		pnEstoque.setOpaque(false);
		pnEstoque.setBounds(176, 245, 322, 151);
		frmPrincipal.getContentPane().add(pnEstoque);
		pnEstoque.setLayout(null);
		
		lblOpcoeslAdmin = new JLabel("<html>&nbsp;&nbsp;&nbsp;Opções do<br/>Administrador</html>");
		lblOpcoeslAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcoeslAdmin.setBounds(219, 11, 290, 34);
		frmPrincipal.getContentPane().add(lblOpcoeslAdmin);
		lblOpcoeslAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOpcoeslAdmin.setBorder(null);
			
		btnConferencia = new JButton("");
		btnConferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarVendas.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnConferencia.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/conferencia.jpg")));
		btnConferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConferencia.setFocusable(false);
		btnConferencia.setBackground(Color.decode("#0049aa"));
		btnConferencia.setBounds(114, 81, 94, 59);
		pnCaixa.add(btnConferencia);
			
		btnContas = new JButton("");
		btnContas.setEnabled(false);
		btnContas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/contasAPagar.jpg")));
		btnContas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnContas.setFocusable(false);
		btnContas.setBackground(Color.decode("#0049aa"));
		btnContas.setBounds(218, 81, 94, 59);
		pnCaixa.add(btnContas);
			
		btnCorrecaoProduto = new JButton("");
		btnCorrecaoProduto.setEnabled(false);
		btnCorrecaoProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/correcao.png")));
		btnCorrecaoProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecaoProduto.setFocusable(false);
		btnCorrecaoProduto.setBackground(Color.decode("#0049aa"));
		btnCorrecaoProduto.setBounds(63, 81, 94, 59);
		pnEstoque.add(btnCorrecaoProduto);
		
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
		
		btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarUsuario.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnCadastrarUsuario.setBounds(219, 56, 140, 25);
		frmPrincipal.getContentPane().add(btnCadastrarUsuario);
		btnCadastrarUsuario.setForeground(Color.WHITE);
		btnCadastrarUsuario.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCadastrarUsuario.setBackground(Color.decode("#0049aa"));
		btnCadastrarUsuario.setFocusable(false);
		
		btnCadastrarLoja = new JButton("Cadastrar Loja");
		btnCadastrarLoja.setBounds(369, 56, 140, 25);
		frmPrincipal.getContentPane().add(btnCadastrarLoja);
		btnCadastrarLoja.setForeground(Color.WHITE);
		btnCadastrarLoja.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCadastrarLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarLoja.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnCadastrarLoja.setBackground(Color.decode("#0049aa"));
		btnCadastrarLoja.setFocusable(false);
		
		btnMandarEmail = new JButton("Mandar Email");
		btnMandarEmail.setBounds(219, 92, 140, 25);
		frmPrincipal.getContentPane().add(btnMandarEmail);
		btnMandarEmail.setForeground(Color.WHITE);
		btnMandarEmail.setFont(new Font("Impact", Font.PLAIN, 13));
		btnMandarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MandarEmail.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnMandarEmail.setFocusable(false);
		btnMandarEmail.setBackground(Color.decode("#0049aa"));
		
		btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarDados.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnAlterarDados.setForeground(Color.WHITE);
		btnAlterarDados.setFont(new Font("Impact", Font.PLAIN, 13));
		btnAlterarDados.setFocusable(false);
		btnAlterarDados.setBackground(Color.decode("#0049aa"));
		btnAlterarDados.setBounds(369, 92, 140, 25);
		frmPrincipal.getContentPane().add(btnAlterarDados);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(10, 218, 510, 2);
		frmPrincipal.getContentPane().add(separator);
		btnCliente.setBounds(10, 245, 137, 25);
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
		btnCaixa.setBounds(10, 281, 137, 25);
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
		btnEstoque.setBounds(10, 317, 137, 25);
		frmPrincipal.getContentPane().add(btnEstoque);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(frmPrincipal,
						"Você deseja desconectar desta conta?", "Aviso", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(escolha==0) {
							CRUDUsuarios.logoff(usuario, senha);
							frmPrincipal.dispose();
							Login.main(null);
						}else {
							
						}
			}
		});
		btnSair.setBackground(Color.decode("#0049aa"));
		btnSair.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSair.setFocusable(false);
		btnSair.setBounds(10, 371, 137, 25);
		frmPrincipal.getContentPane().add(btnSair);
		
		btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeClientes.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/clientes.jpg")));
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setFocusable(false);
		btnClientes.setBackground(Color.decode("#0049aa"));
		btnClientes.setBounds(63, 11, 94, 59);
		pnCliente.add(btnClientes);
		
		btnTroca = new JButton("");
		btnTroca.setEnabled(false);
		btnTroca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/troca.jpg")));
		btnTroca.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTroca.setFocusable(false);
		btnTroca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTroca.setBackground(Color.decode("#0049aa"));
		btnTroca.setBounds(167, 11, 94, 59);
		pnCliente.add(btnTroca);
		
		btnBaixaDemonstracao = new JButton("");
		btnBaixaDemonstracao.setEnabled(false);
		btnBaixaDemonstracao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/baixaDemonstracao.jpg")));
		btnBaixaDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaixaDemonstracao.setFocusable(false);
		btnBaixaDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaixaDemonstracao.setBackground(Color.decode("#0049aa"));
		btnBaixaDemonstracao.setBounds(167, 81, 94, 59);
		pnCliente.add(btnBaixaDemonstracao);
		
		btnDemonstracao = new JButton("");
		btnDemonstracao.setEnabled(false);
		btnDemonstracao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/demonstracao.jpg")));
		btnDemonstracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDemonstracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDemonstracao.setFocusable(false);
		btnDemonstracao.setBackground(Color.decode("#0049aa"));
		btnDemonstracao.setBounds(63, 81, 94, 59);
		pnCliente.add(btnDemonstracao);
		
		btnVenda = new JButton("");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDeVendas.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnVenda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/vendas.jpg")));
		btnVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVenda.setFocusable(false);
		btnVenda.setBackground(Color.decode("#0049aa"));
		btnVenda.setBounds(10, 11, 94, 59);
		pnCaixa.add(btnVenda);
		
		btnRecebimento = new JButton("");
		btnRecebimento.setEnabled(false);
		btnRecebimento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/recebimento.jpg")));
		btnRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRecebimento.setFocusable(false);
		btnRecebimento.setBackground(Color.decode("#0049aa"));
		btnRecebimento.setBounds(114, 11, 94, 59);
		pnCaixa.add(btnRecebimento);
		
		btnCorrecaoParcela = new JButton("");
		btnCorrecaoParcela.setEnabled(false);
		btnCorrecaoParcela.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/correcao.png")));
		btnCorrecaoParcela.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCorrecaoParcela.setFocusable(false);
		btnCorrecaoParcela.setBackground(Color.decode("#0049aa"));
		btnCorrecaoParcela.setBounds(218, 11, 94, 59);
		pnCaixa.add(btnCorrecaoParcela);
		
		btnLancamento = new JButton("");
		btnLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancamentoDeGastos.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnLancamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/lancamento.jpg")));
		btnLancamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLancamento.setFocusable(false);
		btnLancamento.setBackground(Color.decode("#0049aa"));
		btnLancamento.setBounds(10, 81, 94, 59);
		pnCaixa.add(btnLancamento);
		
		btnConsulta = new JButton("");
		btnConsulta.setEnabled(false);
		btnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/consulta.jpg")));
		btnConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsulta.setFocusable(false);
		btnConsulta.setBackground(Color.decode("#0049aa"));
		btnConsulta.setBounds(63, 11, 94, 59);
		pnEstoque.add(btnConsulta);
		
		btnEntrada = new JButton("");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrosDeProdutos.main(null);
				frmPrincipal.setVisible(false);
			}
		});
		btnEntrada.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/entrada.jpg")));
		btnEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrada.setFocusable(false);
		btnEntrada.setBackground(Color.decode("#0049aa"));
		btnEntrada.setBounds(167, 11, 94, 59);
		pnEstoque.add(btnEntrada);
		
		btnTransferencia = new JButton("");
		btnTransferencia.setEnabled(false);
		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPrincipal.setVisible(false);
				Transferencia.main(null);
			}
		});
		btnTransferencia.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Img/transferencia.jpg")));
		btnTransferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTransferencia.setFocusable(false);
		btnTransferencia.setBackground(Color.decode("#0049aa"));
		btnTransferencia.setBounds(167, 81, 94, 59);
		pnEstoque.add(btnTransferencia);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(519, 11, 2, 385);
		frmPrincipal.getContentPane().add(separator_1);
		
		lblNewLabel_1 = new JLabel("N\u00EDvel:");
		lblNewLabel_1.setBounds(531, 70, 60, 17);
		frmPrincipal.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNivel = new JLabel("");
		lblNivel.setBounds(541, 97, 170, 20);
		frmPrincipal.getContentPane().add(lblNivel);
		lblNivel.setForeground(Color.decode("#0049aa"));
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(531, 11, 60, 17);
		frmPrincipal.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblUsuario = new JLabel("");
		lblUsuario.setBounds(541, 39, 170, 20);
		frmPrincipal.getContentPane().add(lblUsuario);
		lblUsuario.setForeground(Color.decode("#0049aa"));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(531, 128, 60, 17);
		frmPrincipal.getContentPane().add(lblNewLabel_2);
		
		lblEmail = new JLabel("");
		lblEmail.setForeground(new Color(0, 73, 170));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(541, 156, 170, 20);
		frmPrincipal.getContentPane().add(lblEmail);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundPrincipal.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(721, 407, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 721, 407);
		frmPrincipal.getContentPane().add(lblBG);
		
		verificarNivelUsuario();
	}
	
	public boolean verificarNivelUsuario() {
		CRUDUsuarios select = new CRUDUsuarios();
		select.selectCondicao1(usuario, senha);
		try {
			if (select.dadosLogin.first()) {
				usuario = select.dadosLogin.getString("nome");
				nivel = select.dadosLogin.getString("nivel");
				email = select.dadosLogin.getString("email");
				
				if (nivel.equals("Autorizado")) {
					btnCadastrarUsuario.setEnabled(false);
					btnCadastrarLoja.setEnabled(false);
					btnMandarEmail.setEnabled(false);
					btnAlterarDados.setEnabled(false);
					
					btnContas.setVisible(false);
				}
				
				if (nivel.equals("Básico")) {
					btnTransferencia.setLocation(63, 81);
					
					btnCadastrarUsuario.setEnabled(false);
					btnCadastrarLoja.setEnabled(false);
					btnMandarEmail.setEnabled(false);
					btnAlterarDados.setEnabled(false);
					
					btnConferencia.setVisible(false);
					btnContas.setVisible(false);
					btnCorrecaoProduto.setVisible(false);
				}
				
				lblUsuario.setText(usuario);
				lblNivel.setText(nivel);
				lblEmail.setText(email);
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
