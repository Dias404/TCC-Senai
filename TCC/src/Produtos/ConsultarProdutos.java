package Produtos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDProdutos;

public class ConsultarProdutos {

	private JFrame frmConsultaDeProdutos;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProdutos window = new ConsultarProdutos();
					window.frmConsultaDeProdutos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultarProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeProdutos = new JFrame();
		frmConsultaDeProdutos.setTitle("SIG - Consulta de Produtos");
		frmConsultaDeProdutos.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarProdutos.class.getResource("/Img/SIG 16x16.png")));
		frmConsultaDeProdutos.setBounds(100, 100, 538, 463);
		frmConsultaDeProdutos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeProdutos.setResizable(false);
		frmConsultaDeProdutos.setLocationRelativeTo(null);
		frmConsultaDeProdutos.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeProdutos = new JLabel("Consulta de Produtos");
		lblConsultaDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeProdutos.setBounds(10, 11, 167, 17);
		frmConsultaDeProdutos.getContentPane().add(lblConsultaDeProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 512, 350);
		frmConsultaDeProdutos.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.getTableHeader().setReorderingAllowed(false); // Bloqueia movimento do header
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fornecedor", "Loja", "Data", "C\u00F3digo", "Descri\u00E7\u00E3o", "Cor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(tabela);
		
		JButton button = new JButton("Voltar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(10, 400, 89, 23);
		frmConsultaDeProdutos.getContentPane().add(button);
		
		JButton button_1 = new JButton("Pesquisar");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Impact", Font.PLAIN, 13));
		button_1.setFocusable(false);
		button_1.setBackground(new Color(0, 73, 170));
		button_1.setBounds(424, 400, 98, 23);
		frmConsultaDeProdutos.getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fornecedor", "Loja", "Data", "Código", "Descrição", "Cor"}));
		comboBox.setBounds(310, 400, 104, 23);
		frmConsultaDeProdutos.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("Pesquisar por:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(213, 405, 87, 15);
		frmConsultaDeProdutos.getContentPane().add(label);
		
		preencherTabela();
	}
	
	private boolean preencherTabela() {
		CRUDProdutos select = new CRUDProdutos();
		select.selectProdutos();
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (select.dados.next()) {
				modelo.addRow(new Object[]{select.dados.getInt("id_produto"), select.dados.getString("fornecedor"), select.dados.getString("loja_emitente"), select.dados.getString("data_entrada"), select.dados.getString("codigo"), select.dados.getString("descricao"), select.dados.getString("cor")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
