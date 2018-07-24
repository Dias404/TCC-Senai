package Vendas;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDVendas;
import Produtos.AtualizarProdutos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarVendas {

	private JFrame frmConsultaDeVendas;
	private JTable tabela;

	static int vendaSelecionada;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarVendas window = new ConsultarVendas();
					window.frmConsultaDeVendas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultarVendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeVendas = new JFrame();
		frmConsultaDeVendas.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarVendas.class.getResource("/Img/SIG 16x16.png")));
		frmConsultaDeVendas.setTitle("SIG - Consulta de Vendas");
		frmConsultaDeVendas.setBounds(100, 100, 538, 463);
		frmConsultaDeVendas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeVendas.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeVendas = new JLabel("Consulta de Vendas");
		lblConsultaDeVendas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeVendas.setBounds(10, 11, 167, 17);
		frmConsultaDeVendas.getContentPane().add(lblConsultaDeVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 512, 350);
		frmConsultaDeVendas.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar esses dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					int indexLinha = tabela.getSelectedRow();
					vendaSelecionada = Integer.parseInt(tabela.getValueAt(indexLinha, 0).toString());
					frmConsultaDeVendas.dispose();
					AtualizarVendas.main(null);
				}
			}
		});
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cliente", "Loja", "Produto", "Quantidade", "Pre\u00E7o Total", "Desconto", "Data"
			}
		));
		scrollPane.setViewportView(tabela);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmConsultaDeVendas.dispose();
				CadastroDeVendas.main(null);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(10, 400, 89, 23);
		frmConsultaDeVendas.getContentPane().add(button);
		
		JButton button_1 = new JButton("Pesquisar");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Impact", Font.PLAIN, 13));
		button_1.setFocusable(false);
		button_1.setBackground(new Color(0, 73, 170));
		button_1.setBounds(424, 400, 98, 23);
		frmConsultaDeVendas.getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(310, 400, 104, 23);
		frmConsultaDeVendas.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("Pesquisar por:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(213, 406, 87, 15);
		frmConsultaDeVendas.getContentPane().add(label);
		frmConsultaDeVendas.setResizable(false);
		frmConsultaDeVendas.setLocationRelativeTo(null);
		
		preencherTabela();
	}
	
	private boolean preencherTabela() {
		CRUDVendas select = new CRUDVendas();
		select.selectVenda();
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (select.dados.next()) {
				modelo.addRow(new Object[]{select.dados.getInt("id_venda"), select.dados.getString("cliente"), select.dados.getString("loja_emitente"), select.dados.getString("produto"), select.dados.getInt("quantidade"), select.dados.getString("preco_total"), select.dados.getString("desconto"), select.dados.getString("data_venda")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/*private boolean preencherTabelaWhere() {
		
	}*/
}
