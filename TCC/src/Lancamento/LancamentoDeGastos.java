package Lancamento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import CRUD.CRUDGastos;
import CRUD.CRUDLojas;
import Clientes.AtualizarClientes;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LancamentoDeGastos {

	private JFrame frmLancamentoDeCaixa;
	private JTextField tfDescricao;
	private JTextField tfValorTotal;
	private JTextField tfNotaFiscal;
	private JButton btnLimpar;
	private JButton btnSalvarInsert;
	private JFormattedTextField ftfData;
	private JComboBox comboLojas;
	private JComboBox comboPesquisar;
	private JTable tabela;
	
	private MaskFormatter mascara;
	private ResultSet dadosBackup = null;
	public int idGasto;
	private JButton btnPesquisar;
	private JButton btnRemover;
	private JButton btnCancelar;
	private JButton btnSalvarUpdate;
	private int desabilitarTabela = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LancamentoDeGastos window = new LancamentoDeGastos();
					window.frmLancamentoDeCaixa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LancamentoDeGastos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmLancamentoDeCaixa = new JFrame();
		frmLancamentoDeCaixa.setIconImage(Toolkit.getDefaultToolkit().getImage(LancamentoDeGastos.class.getResource("/Img/SIG 16x16.png")));
		frmLancamentoDeCaixa.setTitle("SIG - Lançamento de Gastos");
		frmLancamentoDeCaixa.setBounds(100, 100, 497, 607);
		frmLancamentoDeCaixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLancamentoDeCaixa.setResizable(false);
		frmLancamentoDeCaixa.setLocationRelativeTo(null);
		frmLancamentoDeCaixa.getContentPane().setLayout(null);
		
		JLabel lblLanamentoDeCaixa = new JLabel("Lançamento de Gastos");
		lblLanamentoDeCaixa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLanamentoDeCaixa.setBounds(10, 11, 157, 17);
		frmLancamentoDeCaixa.getContentPane().add(lblLanamentoDeCaixa);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrio.setBounds(10, 101, 70, 14);
		frmLancamentoDeCaixa.getContentPane().add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor Total:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(10, 132, 70, 14);
		frmLancamentoDeCaixa.getContentPane().add(lblValor);
		
		JLabel lblNotaFiscal = new JLabel("Nota Fiscal:");
		lblNotaFiscal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotaFiscal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNotaFiscal.setBounds(250, 132, 70, 14);
		frmLancamentoDeCaixa.getContentPane().add(lblNotaFiscal);
		
		JLabel lblLoja = new JLabel("Loja:");
		lblLoja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoja.setBounds(10, 41, 70, 14);
		frmLancamentoDeCaixa.getContentPane().add(lblLoja);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(10, 70, 70, 14);
		frmLancamentoDeCaixa.getContentPane().add(lblData);
		
		tfDescricao = new JTextField();
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(90, 99, 390, 20);
		frmLancamentoDeCaixa.getContentPane().add(tfDescricao);
		
		tfValorTotal = new JTextField();
		tfValorTotal.setColumns(10);
		tfValorTotal.setBounds(90, 130, 150, 20);
		frmLancamentoDeCaixa.getContentPane().add(tfValorTotal);
		
		tfNotaFiscal = new JTextField();
		tfNotaFiscal.setColumns(10);
		tfNotaFiscal.setBounds(330, 130, 150, 20);
		frmLancamentoDeCaixa.getContentPane().add(tfNotaFiscal);
		
		btnSalvarInsert = new JButton("Salvar");
		btnSalvarInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loja = comboLojas.getSelectedItem().toString();
				String data = ftfData.getText().toString();
				String descricao = tfDescricao.getText().toString();
				String valorTotal = tfValorTotal.getText().toString();
				String notaFiscal = tfNotaFiscal.getText().toString();
				if (loja.isEmpty() || data.isEmpty() || descricao.isEmpty() ||valorTotal.isEmpty() || notaFiscal.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
				}else {
					CRUDGastos insert = new CRUDGastos();
					insert.insertGastos(loja, data, descricao, valorTotal, notaFiscal);
					JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
				}
				preencherTabela();
				btnLimpar.doClick();
			}
		});
		btnSalvarInsert.setForeground(Color.WHITE);
		btnSalvarInsert.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvarInsert.setFocusable(false);
		btnSalvarInsert.setBackground(new Color(0, 73, 170));
		btnSalvarInsert.setBounds(391, 161, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnSalvarInsert);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ftfData.setValue(null);
				tfDescricao.setText(null);
				tfValorTotal.setText(null);
				tfNotaFiscal.setText(null);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(292, 161, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnLimpar);
		
		ftfData = new JFormattedTextField(mascara);
		ftfData.setBounds(90, 68, 150, 20);
		frmLancamentoDeCaixa.getContentPane().add(ftfData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 195, 470, 2);
		frmLancamentoDeCaixa.getContentPane().add(separator);
		
		JLabel lblConsultarDados = new JLabel("Consultar Gastos");
		lblConsultarDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarDados.setBounds(10, 208, 118, 17);
		frmLancamentoDeCaixa.getContentPane().add(lblConsultarDados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 471, 293);
		frmLancamentoDeCaixa.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (desabilitarTabela == 0) {
					int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar esses dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if (respostaJOP == JOptionPane.YES_OPTION) {
						int indexLinha = tabela.getSelectedRow();
						idGasto = Integer.parseInt(tabela.getValueAt(indexLinha, 0).toString());
						
						CRUDGastos select = new CRUDGastos();
						select.selectGastosComWhere(idGasto);
						try {
							if (select.dadosEspecificos.first()) {
								comboLojas.setSelectedItem(select.dadosEspecificos.getString("loja"));
								ftfData.setText(select.dadosEspecificos.getString("data"));
								tfDescricao.setText(select.dadosEspecificos.getString("descricao"));
								tfValorTotal.setText(select.dadosEspecificos.getString("valor_total"));
								tfNotaFiscal.setText(select.dadosEspecificos.getString("nota_fiscal"));
								
								btnLimpar.setVisible(false);
								btnSalvarInsert.setVisible(false);
								comboPesquisar.setEnabled(false);
								btnPesquisar.setEnabled(false);
								btnRemover.setVisible(true);
								btnCancelar.setVisible(true);
								btnSalvarUpdate.setVisible(true);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						return;
					}
					desabilitarTabela = 1;
				}
				if (desabilitarTabela == 1) {
					return;
				}
			}
		});
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Loja", "Data", "Descri\u00E7\u00E3o", "Valor Total", "Nota Fiscal"
			}
		));
		scrollPane.setViewportView(tabela);
		
		JButton button = new JButton("Salvar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(10, 540, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(button);
		
		comboLojas = new JComboBox();
		comboLojas.setBounds(90, 39, 390, 20);
		frmLancamentoDeCaixa.getContentPane().add(comboLojas);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String variavelSelect = null;
				String valorSelect = null;
				
				if (comboPesquisar.getSelectedItem().toString().equals("Loja")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome da loja que deseja procurar:");
					variavelSelect = "loja";
				}
				
				if (comboPesquisar.getSelectedItem().toString().equals("Data")) {
					valorSelect = JOptionPane.showInputDialog("Entre com a data que deseja procurar:");
					variavelSelect = "data";	
				}
				
				if (comboPesquisar.getSelectedItem().toString().equals("Descrição")) {
					valorSelect = JOptionPane.showInputDialog("Entre com a descrição do produto que deseja procurar:");
					variavelSelect = "descricao";		
				}
				
				if (comboPesquisar.getSelectedItem().toString().equals("Valor Total")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o valor total que deseja procurar:");
					variavelSelect = "valor_total";
				}
				
				if (comboPesquisar.getSelectedItem().toString().equals("Notal Fiscal")) {
					valorSelect = JOptionPane.showInputDialog("Entre com a Nota Fiscal que deseja procurar:");
					variavelSelect = "nota_fiscal";	
				}
				
				preencherTabelaWhere(variavelSelect, valorSelect);
			}
		});
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnPesquisar.setFocusable(false);
		btnPesquisar.setBackground(new Color(0, 73, 170));
		btnPesquisar.setBounds(382, 540, 98, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnPesquisar);
		
		comboPesquisar = new JComboBox();
		comboPesquisar.setModel(new DefaultComboBoxModel(new String[] {"Loja", "Data", "Descrição", "Valor Total", "Nota Fiscal"}));
		comboPesquisar.setBounds(274, 542, 98, 23);
		frmLancamentoDeCaixa.getContentPane().add(comboPesquisar);
		
		JLabel label = new JLabel("Pesquisar por:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(177, 545, 87, 15);
		frmLancamentoDeCaixa.getContentPane().add(label);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esses dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					CRUDGastos delete = new CRUDGastos();
					delete.deleteGastos(idGasto);
					JOptionPane.showMessageDialog(null, "Dados removidos com sucesso!");
					btnCancelar.doClick();
					preencherTabela();
				} else {
					return;
				}
			}
		});
		btnRemover.setVisible(false);
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Impact", Font.PLAIN, 13));
		btnRemover.setFocusable(false);
		btnRemover.setBackground(new Color(0, 73, 170));
		btnRemover.setBounds(193, 161, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnRemover);
		
		btnSalvarUpdate = new JButton("Salvar");
		btnSalvarUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar esses dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					String loja = comboLojas.getSelectedItem().toString();
					String data = ftfData.getText().toString();
					String descricao = tfDescricao.getText().toString();
					String valorTotal = tfValorTotal.getText().toString();
					String notaFiscal = tfNotaFiscal.getText().toString();
					if (loja.isEmpty() || data.equals("  /  /    ") || descricao.isEmpty() || valorTotal.isEmpty() || notaFiscal.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Existe um campo vazio!");
					} else {
						CRUDGastos update = new CRUDGastos();
						update.updateGastos(loja, data, descricao, valorTotal, notaFiscal, idGasto);
						JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
						btnCancelar.doClick();
						preencherTabela();
					}
				} else {
					return;
				}
			}
		});
		btnSalvarUpdate.setVisible(false);
		btnSalvarUpdate.setForeground(Color.WHITE);
		btnSalvarUpdate.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvarUpdate.setFocusable(false);
		btnSalvarUpdate.setBackground(new Color(0, 73, 170));
		btnSalvarUpdate.setBounds(391, 161, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnSalvarUpdate);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRemover.setVisible(false);
				btnCancelar.setVisible(false);
				btnSalvarUpdate.setVisible(false);
				btnLimpar.setVisible(true);
				btnSalvarInsert.setVisible(true);
				comboPesquisar.setEnabled(true);
				btnPesquisar.setEnabled(true);
				btnLimpar.doClick();
				desabilitarTabela = 0;
			}
		});
		btnCancelar.setVisible(false);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(new Color(0, 73, 170));
		btnCancelar.setBounds(292, 161, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnCancelar);
		
		preencherTabela();
		preencherComboLojas();
	}
	
	public boolean preencherComboLojas() {
		CRUDLojas select = new CRUDLojas();
		select.selectLoja();
		comboLojas.removeAllItems();
		try {
			while (select.dadosSelect.next()) {
				comboLojas.addItem(select.dadosSelect.getString("razao"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean preencherTabela() {
		CRUDGastos select = new CRUDGastos();
		select.selectGastos();
		dadosBackup = select.dados;
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (select.dados.next()) {
				modelo.addRow(new Object[] {select.dados.getString("id_gasto"), select.dados.getString("loja"), select.dados.getString("data"), select.dados.getString("descricao"), "R$ "+select.dados.getString("valor_total"), select.dados.getString("nota_fiscal")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean preencherTabelaWhere(String variavelSelect, String valorSelect) {
		CRUDGastos select = new CRUDGastos();
		select.selectGastosComLike(variavelSelect, valorSelect);
		dadosBackup = select.dados;
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (select.dados.next()) {
				modelo.addRow(new Object[]{select.dados.getString("id_gasto"), select.dados.getString("loja"), select.dados.getString("data"), select.dados.getString("descricao"), "R$ "+select.dados.getString("valor_total"), select.dados.getString("nota_fiscal")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
