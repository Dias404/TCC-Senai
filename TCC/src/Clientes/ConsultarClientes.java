package Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDClientes;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarClientes {

	private JFrame frmConsultaDeClientes;
	private JTable tabela;
	public int idSelecionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarClientes window = new ConsultarClientes();
					window.frmConsultaDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultarClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeClientes = new JFrame();
		frmConsultaDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarClientes.class.getResource("/Img/SIG 16x16.png")));
		frmConsultaDeClientes.setTitle("SIG - Consulta de Clientes");
		frmConsultaDeClientes.setBounds(100, 100, 688, 464);
		frmConsultaDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeClientes.setResizable(false);
		frmConsultaDeClientes.setLocationRelativeTo(null);
		frmConsultaDeClientes.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeClientes = new JLabel("Consulta de Clientes");
		lblConsultaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeClientes.setBounds(10, 11, 149, 17);
		frmConsultaDeClientes.getContentPane().add(lblConsultaDeClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 662, 385);
		frmConsultaDeClientes.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indexLinha = tabela.getSelectedRow();
				idSelecionado = (int) tabela.getValueAt(indexLinha, 0);
				frmConsultaDeClientes.dispose();
				AtualizarClientes.main(null);
			}
		});
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabela);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tipo de Pessoa", "Nome/Raz\u00E3o", "Sexo", "E-mail", "UF", "Cidade", "Bairro", "Rua", "N\u00FAmero", "CPF/CNPJ", "RG/IE", "M\u00E3e", "Pai", "Data de Nascimento", "Estado Civil", "Tel 1", "Tel 2", "Cel 1", "Cel 2"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(6).setResizable(false);
		tabela.getColumnModel().getColumn(7).setResizable(false);
		tabela.getColumnModel().getColumn(8).setResizable(false);
		tabela.getColumnModel().getColumn(9).setResizable(false);
		tabela.getColumnModel().getColumn(10).setResizable(false);
		tabela.getColumnModel().getColumn(11).setResizable(false);
		tabela.getColumnModel().getColumn(12).setResizable(false);
		tabela.getColumnModel().getColumn(13).setResizable(false);
		tabela.getColumnModel().getColumn(14).setResizable(false);
		tabela.getColumnModel().getColumn(15).setResizable(false);
		tabela.getColumnModel().getColumn(16).setResizable(false);
		tabela.getColumnModel().getColumn(17).setResizable(false);
		tabela.getColumnModel().getColumn(18).setResizable(false);
		tabela.getColumnModel().getColumn(19).setResizable(false);
		tabela.getTableHeader().setReorderingAllowed(false);
		
		preencherTabela();
	}
	
	private boolean preencherTabela() {
		CRUDClientes selecionar = new CRUDClientes();
		selecionar.selectClientes();
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (selecionar.dadosSelect.next()) {
				modelo.addRow(new Object[]{selecionar.dadosSelect.getInt("id_cliente"), selecionar.dadosSelect.getString("tipo_de_pessoa"), selecionar.dadosSelect.getString("nome_razao"), selecionar.dadosSelect.getString("sexo"), selecionar.dadosSelect.getString("email"), selecionar.dadosSelect.getString("uf"), selecionar.dadosSelect.getString("cidade"), selecionar.dadosSelect.getString("bairro"), selecionar.dadosSelect.getString("rua"), selecionar.dadosSelect.getString("numero"), selecionar.dadosSelect.getString("cpf_cnpj"), selecionar.dadosSelect.getString("rg_ie"), selecionar.dadosSelect.getString("mae"), selecionar.dadosSelect.getString("pai"), selecionar.dadosSelect.getString("estado_civil"), selecionar.dadosSelect.getString("tel1"), selecionar.dadosSelect.getString("tel2"), selecionar.dadosSelect.getString("cel1"), selecionar.dadosSelect.getString("cel2")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
