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
import Telas.TelaPrincipal;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.border.EtchedBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class LancamentoDeGastos {

	private JFrame frmLancamentoDeGastos;
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
	private JButton btnPesquisar;
	private JButton btnRemover;
	private JButton btnCancelar;
	private JButton btnSalvarUpdate;
	private JButton btnVoltar;
	private JButton btnMostrarCalendario;
	
	private ResultSet dadosBackup = null;
	public int idGasto;
	private int desabilitarTabela = 0;
	private JPanel pnCalendario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LancamentoDeGastos window = new LancamentoDeGastos();
					window.frmLancamentoDeGastos.setVisible(true);
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
		
		frmLancamentoDeGastos = new JFrame();
		frmLancamentoDeGastos.setIconImage(Toolkit.getDefaultToolkit().getImage(LancamentoDeGastos.class.getResource("/Img/SIG 16x16.png")));
		frmLancamentoDeGastos.setTitle("SIG - Lançamento de Gastos");
		frmLancamentoDeGastos.setBounds(100, 100, 497, 607);
		frmLancamentoDeGastos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLancamentoDeGastos.setResizable(false);
		frmLancamentoDeGastos.setLocationRelativeTo(null);
		frmLancamentoDeGastos.getContentPane().setLayout(null);
		
		pnCalendario = new JPanel();
		pnCalendario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnCalendario.setOpaque(false);
		pnCalendario.setVisible(false);
		pnCalendario.setBounds(250, 68, 231, 116);
		frmLancamentoDeGastos.getContentPane().add(pnCalendario);
		pnCalendario.setLayout(null);
		
		JCalendar calendario = new JCalendar();
		calendario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				Date dataInformada = new Date();
				dataInformada = calendario.getDate();
				
				if (dataInformada.after(dataDeHoje) || dataInformada.getDate() == dataDeHoje.getDate()) { // Testa se a data informada é válida
					String data = formatoBR.format(calendario.getDate());
					ftfData.setText(data);
				} else {
					JOptionPane.showMessageDialog(null, "A data informada precisa ser igual ou superior à data de hoje!", "Data Inválida", JOptionPane.ERROR_MESSAGE);
					String data = formatoBR.format(dataDeHoje);
					ftfData.setText(data);
				}
			}
		});
		calendario.setBounds(0, 0, 231, 116);
		pnCalendario.add(calendario);
		
		JLabel lblLanamentoDeCaixa = new JLabel("Lançamento de Gastos");
		lblLanamentoDeCaixa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLanamentoDeCaixa.setBounds(10, 11, 157, 17);
		frmLancamentoDeGastos.getContentPane().add(lblLanamentoDeCaixa);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrio.setBounds(10, 101, 70, 14);
		frmLancamentoDeGastos.getContentPane().add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor Total:");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValor.setBounds(10, 132, 70, 14);
		frmLancamentoDeGastos.getContentPane().add(lblValor);
		
		JLabel lblNotaFiscal = new JLabel("Nota Fiscal:");
		lblNotaFiscal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotaFiscal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNotaFiscal.setBounds(250, 132, 70, 14);
		frmLancamentoDeGastos.getContentPane().add(lblNotaFiscal);
		
		JLabel lblLoja = new JLabel("Loja:");
		lblLoja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoja.setBounds(10, 41, 70, 14);
		frmLancamentoDeGastos.getContentPane().add(lblLoja);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(10, 70, 70, 14);
		frmLancamentoDeGastos.getContentPane().add(lblData);
		
		tfDescricao = new JTextField();
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(90, 99, 390, 20);
		frmLancamentoDeGastos.getContentPane().add(tfDescricao);
		
		tfValorTotal = new JTextField();
		tfValorTotal.setColumns(10);
		tfValorTotal.setBounds(90, 130, 150, 20);
		frmLancamentoDeGastos.getContentPane().add(tfValorTotal);
		
		tfNotaFiscal = new JTextField();
		tfNotaFiscal.setColumns(10);
		tfNotaFiscal.setBounds(330, 130, 150, 20);
		frmLancamentoDeGastos.getContentPane().add(tfNotaFiscal);
		
		btnSalvarInsert = new JButton("Salvar");
		btnSalvarInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loja = comboLojas.getSelectedItem().toString();
				String data = ftfData.getText().toString();
				String descricao = tfDescricao.getText().toString();
				String valorTotal = tfValorTotal.getText().toString();
				String notaFiscal = tfNotaFiscal.getText().toString();
				
				if (loja.isEmpty() || descricao.isEmpty() ||valorTotal.isEmpty() || notaFiscal.isEmpty()) {
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
		frmLancamentoDeGastos.getContentPane().add(btnSalvarInsert);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				String data = formatoBR.format(dataDeHoje);
				ftfData.setText(data);
				
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
		frmLancamentoDeGastos.getContentPane().add(btnLimpar);
		
		ftfData = new JFormattedTextField(mascara);
		ftfData.setFocusable(false);
		ftfData.setBounds(90, 68, 113, 20);
		frmLancamentoDeGastos.getContentPane().add(ftfData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 195, 470, 2);
		frmLancamentoDeGastos.getContentPane().add(separator);
		
		JLabel lblConsultarDados = new JLabel("Consultar Gastos");
		lblConsultarDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarDados.setBounds(10, 208, 118, 17);
		frmLancamentoDeGastos.getContentPane().add(lblConsultarDados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 471, 293);
		frmLancamentoDeGastos.getContentPane().add(scrollPane);
		
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
								btnVoltar.setEnabled(false);
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
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.frmPrincipal.setVisible(true);
				frmLancamentoDeGastos.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 540, 89, 23);
		frmLancamentoDeGastos.getContentPane().add(btnVoltar);
		
		comboLojas = new JComboBox();
		comboLojas.setBounds(90, 39, 390, 20);
		frmLancamentoDeGastos.getContentPane().add(comboLojas);
		
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
				if(valorSelect == null) {
					preencherTabela();
				}else{
					if(valorSelect.trim().equals("")){
						preencherTabela();
					}else {
						valorSelect = valorSelect.trim();
						preencherTabelaWhere(variavelSelect, valorSelect);
					}
				}
			}
		});
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnPesquisar.setFocusable(false);
		btnPesquisar.setBackground(new Color(0, 73, 170));
		btnPesquisar.setBounds(382, 540, 98, 23);
		frmLancamentoDeGastos.getContentPane().add(btnPesquisar);
		
		comboPesquisar = new JComboBox();
		comboPesquisar.setModel(new DefaultComboBoxModel(new String[] {"Loja", "Data", "Descrição", "Valor Total", "Nota Fiscal"}));
		comboPesquisar.setBounds(274, 542, 98, 23);
		frmLancamentoDeGastos.getContentPane().add(comboPesquisar);
		
		JLabel label = new JLabel("Pesquisar por:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(177, 545, 87, 15);
		frmLancamentoDeGastos.getContentPane().add(label);
		
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
		frmLancamentoDeGastos.getContentPane().add(btnRemover);
		
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
		frmLancamentoDeGastos.getContentPane().add(btnSalvarUpdate);
		
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
				btnVoltar.setEnabled(true);
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
		frmLancamentoDeGastos.getContentPane().add(btnCancelar);
		
		btnMostrarCalendario = new JButton("...");
		btnMostrarCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pnCalendario.isVisible()) {
					pnCalendario.setVisible(false);
				} else {
					pnCalendario.setVisible(true);
				}
			}
		});
		btnMostrarCalendario.setForeground(Color.WHITE);
		btnMostrarCalendario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMostrarCalendario.setFocusable(false);
		btnMostrarCalendario.setBackground(new Color(0, 73, 170));
		btnMostrarCalendario.setBounds(213, 66, 27, 23);
		frmLancamentoDeGastos.getContentPane().add(btnMostrarCalendario);
		
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
