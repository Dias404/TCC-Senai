package Vendas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Color;

public class CadastroDeVendas {

	private JFrame frmCadastroDeVendas;
	private JTextField tfPrecoTotal;
	private JComboBox comboCliente;
	private JComboBox comboProduto;
	private JComboBox comboLojaEmitente;
	private JFormattedTextField ftfDesconto;
	private JSpinner spinnerQuantidade;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeVendas window = new CadastroDeVendas();
					window.frmCadastroDeVendas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroDeVendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeVendas = new JFrame();
		frmCadastroDeVendas.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroDeVendas.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroDeVendas.setTitle("SIG - Vendas");
		frmCadastroDeVendas.setBounds(100, 100, 538, 279);
		frmCadastroDeVendas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeVendas.getContentPane().setLayout(null);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVendas.setBounds(10, 11, 157, 17);
		frmCadastroDeVendas.getContentPane().add(lblVendas);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 39, 512, 166);
		frmCadastroDeVendas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoja = new JLabel("Loja:");
		lblLoja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoja.setBounds(10, 42, 75, 14);
		panel.add(lblLoja);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProduto.setBounds(10, 75, 75, 14);
		panel.add(lblProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(10, 106, 75, 14);
		panel.add(lblQuantidade);
		
		comboLojaEmitente = new JComboBox();
		comboLojaEmitente.setBounds(95, 40, 407, 20);
		panel.add(comboLojaEmitente);
		
		comboProduto = new JComboBox();
		comboProduto.setBounds(95, 73, 407, 20);
		panel.add(comboProduto);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setBounds(95, 104, 100, 20);
		panel.add(spinnerQuantidade);
		
		JLabel lblPreoTotal = new JLabel("Preço Total:");
		lblPreoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreoTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPreoTotal.setBounds(246, 106, 75, 14);
		panel.add(lblPreoTotal);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(10, 11, 75, 14);
		panel.add(lblCliente);
		
		comboCliente = new JComboBox();
		comboCliente.setBounds(95, 9, 407, 20);
		panel.add(comboCliente);
		
		tfPrecoTotal = new JTextField();
		tfPrecoTotal.setColumns(10);
		tfPrecoTotal.setBounds(331, 104, 171, 20);
		panel.add(tfPrecoTotal);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesconto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesconto.setBounds(10, 137, 75, 14);
		panel.add(lblDesconto);
		
		ftfDesconto = new JFormattedTextField();
		ftfDesconto.setBounds(95, 135, 100, 20);
		panel.add(ftfDesconto);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 216, 89, 23);
		frmCadastroDeVendas.getContentPane().add(btnVoltar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(433, 216, 89, 23);
		frmCadastroDeVendas.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(334, 216, 89, 23);
		frmCadastroDeVendas.getContentPane().add(btnLimpar);
		frmCadastroDeVendas.setResizable(false);
		frmCadastroDeVendas.setLocationRelativeTo(null);
	}
	
	private boolean preencherComboCliente() {
		
	}
	
	private boolean preencherComboLoja() {
		
	}
	
	private boolean preencherComboProduto() {
		
	}
}













