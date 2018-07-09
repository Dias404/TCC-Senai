package Produtos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDProdutos;
import Clientes.AtualizarClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarProdutos {

	private JFrame frmConsultaDeProdutos;
	private JTable tabela;
	private JComboBox comboPesquisa;

	static int produtoSelecionado;
	
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
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar esses dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					int indexLinha = tabela.getSelectedRow();
					produtoSelecionado = Integer.parseInt(tabela.getValueAt(indexLinha, 0).toString());
					frmConsultaDeProdutos.dispose();
					AtualizarProdutos.main(null);
				} else {
					return;
				}
			}
		});
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmConsultaDeProdutos.dispose();
				CadastrosDeProdutos.main(null);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(10, 400, 89, 23);
		frmConsultaDeProdutos.getContentPane().add(button);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String variavelSelect = null;
				String valorSelect = null;
				
				if (comboPesquisa.getSelectedItem().toString().equals("Fornecedor")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome do fornecedor que deseja procurar:");
					variavelSelect = "fornecedor";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Loja")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome da loja emitente que deseja procurar:");
					variavelSelect = "loja_emitente";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Código")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome ou a razão social que deseja procurar:");
					variavelSelect = "codigo";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Descrição")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome ou a razão social que deseja procurar:");
					variavelSelect = "descricao";
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
		btnPesquisar.setBounds(424, 400, 98, 23);
		frmConsultaDeProdutos.getContentPane().add(btnPesquisar);
		
		comboPesquisa = new JComboBox();
		comboPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Fornecedor", "Loja", "Código", "Descrição"}));
		comboPesquisa.setBounds(310, 400, 104, 23);
		frmConsultaDeProdutos.getContentPane().add(comboPesquisa);
		
		JLabel label = new JLabel("Pesquisar por:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(213, 405, 87, 15);
		frmConsultaDeProdutos.getContentPane().add(label);
		
		preencherTabela();
	}
	
	private boolean preencherTabela() {
		CRUDProdutos select = new CRUDProdutos();
		select.selectProduto();
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
	
	private boolean preencherTabelaWhere(String variavelSelect, String valorSelect) {
		CRUDProdutos select = new CRUDProdutos();
		select.selectComWhere(variavelSelect, valorSelect);
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while(select.dados.next()) {
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
