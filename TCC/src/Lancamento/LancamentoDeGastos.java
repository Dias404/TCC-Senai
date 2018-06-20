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

import CRUD.CRUDGastos;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LancamentoDeGastos {

	private JFrame frmLancamentoDeCaixa;
	private JTextField tfLoja;
	private JTextField tfDescricao;
	private JTextField tfValorTotal;
	private JTextField tfNotaFiscal;
	private JButton btnLimpar;
	private JButton btnSalvar;
	private JFormattedTextField ftfData;
	private JTable tabela;

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
		frmLancamentoDeCaixa = new JFrame();
		frmLancamentoDeCaixa.setIconImage(Toolkit.getDefaultToolkit().getImage(LancamentoDeGastos.class.getResource("/Img/SIG 16x16.png")));
		frmLancamentoDeCaixa.setTitle("SIG - Lançamento de Gastos");
		frmLancamentoDeCaixa.setBounds(100, 100, 497, 600);
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
		
		tfLoja = new JTextField();
		tfLoja.setColumns(10);
		tfLoja.setBounds(90, 39, 390, 20);
		frmLancamentoDeCaixa.getContentPane().add(tfLoja);
		
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
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loja = tfLoja.getText().toString();
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
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(391, 161, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfLoja.setText(null);
				ftfData.setText(null);
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
		
		ftfData = new JFormattedTextField();
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
		scrollPane.setBounds(10, 236, 471, 291);
		frmLancamentoDeCaixa.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Loja", "Data", "Descri\u00E7\u00E3o", "Valor Total", "Nota Fiscal"
			}
		));
		scrollPane.setViewportView(tabela);
		
		JButton button = new JButton("Salvar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(10, 538, 89, 23);
		frmLancamentoDeCaixa.getContentPane().add(button);
		
		preencherTabela();
	}
	
	public boolean preencherTabela() {
		CRUDGastos select = new CRUDGastos();
		select.selectGastos();
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (select.dados.next()) {
				modelo.addRow(new Object[]{select.dados.getString("loja"), select.dados.getString("data"), select.dados.getString("descricao"), select.dados.getString("valor_total"), select.dados.getString("nota_fiscal")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
