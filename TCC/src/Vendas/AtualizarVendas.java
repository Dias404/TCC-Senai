package Vendas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

import Administrador.CadastrarUsuario;
import CRUD.CRUDClientes;
import CRUD.CRUDLojas;
import CRUD.CRUDProdutos;
import CRUD.CRUDVendas;
import DAO.Vendas;
import Produtos.ConsultarProdutos;

import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AtualizarVendas {

	private JFrame frmAtualizarVendas;

	
	private MaskFormatter mascara;
	private JTextField tfPrecoTotal;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnCancelar;
	private JButton btnRemover;
	private JComboBox comboLojaEmitente;
	private JComboBox comboCliente;
	private JComboBox comboProduto;
	private JSpinner spinnerQuantidade;
	private JFormattedTextField ftfDesconto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarVendas window = new AtualizarVendas();
					window.frmAtualizarVendas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AtualizarVendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			mascara = new MaskFormatter("##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmAtualizarVendas = new JFrame();
		frmAtualizarVendas.setTitle("SIG - Atualizar Vendas");
		frmAtualizarVendas.setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarVendas.class.getResource("/Img/SIG 16x16.png")));
		frmAtualizarVendas.setBounds(100, 100, 538, 279);
		frmAtualizarVendas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAtualizarVendas.getContentPane().setLayout(null);
		frmAtualizarVendas.setResizable(false);
		frmAtualizarVendas.setLocationRelativeTo(null);
		
		JLabel lblAtualizarVendas = new JLabel("Atualizar Vendas");
		lblAtualizarVendas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtualizarVendas.setBounds(10, 11, 157, 17);
		frmAtualizarVendas.getContentPane().add(lblAtualizarVendas);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		panel.setBounds(10, 39, 512, 166);
		frmAtualizarVendas.getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("Loja:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 42, 75, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Produto:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 75, 75, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Quantidade:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(10, 106, 75, 14);
		panel.add(label_3);
		
		comboLojaEmitente = new JComboBox();
		comboLojaEmitente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				preencherComboProdutos();
			}
		});
		comboLojaEmitente.setEnabled(false);
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
		comboProduto.setEnabled(false);
		comboProduto.setBounds(95, 73, 407, 20);
		panel.add(comboProduto);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				preencherCampoPreco();
			}
		});
		spinnerQuantidade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerQuantidade.setEnabled(false);
		spinnerQuantidade.setBounds(95, 104, 100, 20);
		panel.add(spinnerQuantidade);
		
		JLabel label_4 = new JLabel("Preço Total:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(246, 106, 75, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Cliente:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 11, 75, 14);
		panel.add(label_5);
		
		comboCliente = new JComboBox();
		comboCliente.setEnabled(false);
		comboCliente.setBounds(95, 9, 407, 20);
		panel.add(comboCliente);
		
		tfPrecoTotal = new JTextField();
		tfPrecoTotal.setEnabled(false);
		tfPrecoTotal.setColumns(10);
		tfPrecoTotal.setBounds(331, 104, 171, 20);
		panel.add(tfPrecoTotal);
		
		JLabel label_6 = new JLabel("Desconto:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(10, 137, 75, 14);
		panel.add(label_6);
		
		ftfDesconto = new JFormattedTextField(mascara);
		ftfDesconto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				preencherCampoPreco();
			}
		});
		ftfDesconto.setEnabled(false);
		ftfDesconto.setToolTipText("Em porcentagem");
		ftfDesconto.setBounds(95, 135, 100, 20);
		panel.add(ftfDesconto);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAtualizarVendas.dispose();
				ConsultarVendas.main(null);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 216, 89, 23);
		frmAtualizarVendas.getContentPane().add(btnVoltar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar os dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					btnAlterar.setVisible(false);
					btnRemover.setVisible(true);
					btnCancelar.setVisible(true);
					btnSalvar.setVisible(true);
					
					comboCliente.setEnabled(true);
					comboLojaEmitente.setEnabled(true);
					comboProduto.setEnabled(true);
					spinnerQuantidade.setEnabled(true);
					ftfDesconto.setEnabled(true);
				}
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnAlterar.setFocusable(false);
		btnAlterar.setBackground(new Color(0, 73, 170));
		btnAlterar.setBounds(433, 216, 89, 23);
		frmAtualizarVendas.getContentPane().add(btnAlterar);
		
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
					
					CRUDVendas update = new CRUDVendas();
					update.updateVenda(venda, ConsultarVendas.vendaSelecionada);
					JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
					btnCancelar.doClick();
				}
			}
		});
		btnSalvar.setVisible(false);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(433, 216, 89, 23);
		frmAtualizarVendas.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAlterar.setVisible(true);
				btnRemover.setVisible(false);
				btnCancelar.setVisible(false);
				btnSalvar.setVisible(false);
				
				comboCliente.setEnabled(false);
				comboLojaEmitente.setEnabled(false);
				comboProduto.setEnabled(false);
				spinnerQuantidade.setEnabled(false);
				ftfDesconto.setEnabled(false);
			}
		});
		btnCancelar.setVisible(false);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(new Color(0, 73, 170));
		btnCancelar.setBounds(334, 216, 89, 23);
		frmAtualizarVendas.getContentPane().add(btnCancelar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja romover os dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					CRUDVendas delete = new CRUDVendas();
					delete.deleteVenda(ConsultarVendas.vendaSelecionada);
					
					JOptionPane.showMessageDialog(null, "Os dados foram removidos com sucesso!");
					ConsultarVendas.main(null);
					frmAtualizarVendas.dispose();
				}
			}
		});
		btnRemover.setVisible(false);
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Impact", Font.PLAIN, 13));
		btnRemover.setFocusable(false);
		btnRemover.setBackground(new Color(0, 73, 170));
		btnRemover.setBounds(235, 216, 89, 23);
		frmAtualizarVendas.getContentPane().add(btnRemover);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(532, 251, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 532, 251);
		frmAtualizarVendas.getContentPane().add(lblBG);

	
		preencherComboClientes();
		preencherComboLojas();
		preencherComboProdutos();
		preencherCampos();
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
	
	private boolean preencherCampos() {
		CRUDVendas select = new CRUDVendas();
		select.selectVendaEspecifica(ConsultarVendas.vendaSelecionada);
		try {
			if (select.dados.first()) {
				comboCliente.setSelectedItem(select.dados.getString("cliente"));
				comboLojaEmitente.setSelectedItem(select.dados.getString("loja_emitente"));
				comboProduto.setSelectedItem(select.dados.getString("produto"));
				spinnerQuantidade.setValue(select.dados.getInt("quantidade"));
				ftfDesconto.setText(select.dados.getString("desconto"));
				tfPrecoTotal.setText(select.dados.getString("preco_total"));
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
					float preco = Integer.parseInt(select.dados.getString("preco"));
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
