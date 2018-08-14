package Vendas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import CRUD.CRUDClientes;
import CRUD.CRUDLojas;
import CRUD.CRUDProdutos;
import CRUD.CRUDVendas;
import DAO.Vendas;
import Telas.TelaPrincipal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;

import Administrador.CadastrarUsuario;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	
	private MaskFormatter mascara;

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
		try {
			mascara = new MaskFormatter("##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		frmCadastroDeVendas = new JFrame();
		frmCadastroDeVendas.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroDeVendas.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroDeVendas.setTitle("SIG - Vendas");
		frmCadastroDeVendas.setBounds(100, 100, 538, 279);
		frmCadastroDeVendas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeVendas.getContentPane().setLayout(null);
		frmCadastroDeVendas.setResizable(false);
		frmCadastroDeVendas.setLocationRelativeTo(null);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVendas.setBounds(10, 11, 157, 17);
		frmCadastroDeVendas.getContentPane().add(lblVendas);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
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
		comboLojaEmitente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				preencherComboProdutos();
			}
		});
		comboLojaEmitente.setBounds(95, 40, 407, 20);
		panel.add(comboLojaEmitente);
		
		comboProduto = new JComboBox();
		comboProduto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				spinnerQuantidade.setValue(1);
				ftfDesconto.setValue(null);
				preencherCampoPreco();
			}
		});
		comboProduto.setBounds(95, 73, 407, 20);
		panel.add(comboProduto);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				preencherCampoPreco();
			}
		});
		spinnerQuantidade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
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
		tfPrecoTotal.setEnabled(false);
		tfPrecoTotal.setColumns(10);
		tfPrecoTotal.setBounds(331, 104, 171, 20);
		panel.add(tfPrecoTotal);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesconto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesconto.setBounds(10, 137, 75, 14);
		panel.add(lblDesconto);
		
		ftfDesconto = new JFormattedTextField(mascara);
		ftfDesconto.setToolTipText("Em porcentagem");
		ftfDesconto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				preencherCampoPreco();
			}
		});
		ftfDesconto.setBounds(95, 135, 100, 20);
		panel.add(ftfDesconto);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.frmPrincipal.setVisible(true);
				frmCadastroDeVendas.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 216, 89, 23);
		frmCadastroDeVendas.getContentPane().add(btnVoltar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int quantidade = Integer.parseInt(spinnerQuantidade.getValue().toString());
				String preco = tfPrecoTotal.getText().toString();
				String desconto = null;
				
				if (ftfDesconto.getText().trim().toString().equals("")) {
					desconto = "0";
				} else {
					desconto = ftfDesconto.getText().trim().toString();
				}
				
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				String data = formatoBR.format(dataDeHoje);
				
				if (comboCliente.getItemCount() == 0 || comboProduto.getItemCount() == 0) {
					JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
				} else {
					String cliente = comboCliente.getSelectedItem().toString();
					String loja = comboLojaEmitente.getSelectedItem().toString();
					String produto = comboProduto.getSelectedItem().toString();
					
					Vendas venda = new Vendas();
					venda.setCliente(cliente);
					venda.setLoja(loja);
					venda.setProduto(produto);
					venda.setQuantidade(quantidade);
					venda.setPreco(preco);
					venda.setDesconto(desconto);
					venda.setData(data);
					
					CRUDVendas insert = new CRUDVendas();
					insert.insertVenda(venda);
					JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
					btnLimpar.doClick();
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(433, 216, 89, 23);
		frmCadastroDeVendas.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spinnerQuantidade.setValue(1);
				ftfDesconto.setValue(null);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(334, 216, 89, 23);
		frmCadastroDeVendas.getContentPane().add(btnLimpar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(532, 251, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 532, 251);
		frmCadastroDeVendas.getContentPane().add(lblBG);
		
		preencherComboClientes();
		preencherComboLojas();
		preencherComboProdutos();
		preencherCampoPreco();
	}
	
	private boolean preencherComboClientes() {
		CRUDClientes select = new CRUDClientes();
		select.selectClientes();
		comboCliente.removeAllItems();
		try {
			while (select.dadosSelect.next()) {
				comboCliente.addItem(select.dadosSelect.getString("nome_razao"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean preencherComboLojas() {
		CRUDLojas select = new CRUDLojas();
		select.selectLoja();
		comboLojaEmitente.removeAllItems();
		try {
			while (select.dadosSelect.next()) {
				comboLojaEmitente.addItem(select.dadosSelect.getString("razao"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean preencherComboProdutos() {
		CRUDProdutos select = new CRUDProdutos();
		select.selectComWhere("loja_emitente", comboLojaEmitente.getSelectedItem().toString());
		comboProduto.removeAllItems();
		try {
			while (select.dados.next()) {
				comboProduto.addItem(select.dados.getString("descricao"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean preencherCampoPreco() {
		int quantidade = Integer.parseInt(spinnerQuantidade.getValue().toString());
		float desconto = 0;
		
		if ((comboProduto.getItemCount() == 0)) {
			tfPrecoTotal.setText("00.0");
		} else {
			String produto = comboProduto.getSelectedItem().toString();
			CRUDProdutos select = new CRUDProdutos();
			select.selectComWhere("descricao", produto);
			try {
				if (select.dados.first()) {
					if (ftfDesconto.getText().trim().toString().equals("")) {
						desconto = 0;
					} else {
						desconto = Integer.parseInt(ftfDesconto.getText().trim().toString());
						desconto = desconto / 100;
					}
					float preco = Float.parseFloat(select.dados.getString("preco"));
					float precoTotal = preco * quantidade;
					precoTotal = precoTotal - (precoTotal * desconto);
					tfPrecoTotal.setText(String.valueOf(precoTotal));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
