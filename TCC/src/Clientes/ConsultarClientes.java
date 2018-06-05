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

public class ConsultarClientes {

	private JFrame frmConsultaDeClientes;
	private JTable tbDados;

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
		
		tbDados = new JTable();
		tbDados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbDados);
		tbDados.setEnabled(false);
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome/Raz\u00E3o", "Sexo", "E-mail", "UF", "Cidade", "Bairro", "Rua", "N\u00FAmero", "CPF/CNPJ", "RG/IE", "M\u00E3e", "Pai", "Data de Nascimento", "Estado Civil", "Tel 1", "Tel 2", "Cel 1", "Cel 2"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDados.getColumnModel().getColumn(0).setResizable(false);
		tbDados.getColumnModel().getColumn(1).setResizable(false);
		tbDados.getColumnModel().getColumn(2).setResizable(false);
		tbDados.getColumnModel().getColumn(3).setResizable(false);
		tbDados.getColumnModel().getColumn(4).setResizable(false);
		tbDados.getColumnModel().getColumn(5).setResizable(false);
		tbDados.getColumnModel().getColumn(6).setResizable(false);
		tbDados.getColumnModel().getColumn(7).setResizable(false);
		tbDados.getColumnModel().getColumn(8).setResizable(false);
		tbDados.getColumnModel().getColumn(9).setResizable(false);
		tbDados.getColumnModel().getColumn(10).setResizable(false);
		tbDados.getColumnModel().getColumn(11).setResizable(false);
		tbDados.getColumnModel().getColumn(12).setResizable(false);
		tbDados.getColumnModel().getColumn(13).setResizable(false);
		tbDados.getColumnModel().getColumn(14).setResizable(false);
		tbDados.getColumnModel().getColumn(15).setResizable(false);
		tbDados.getColumnModel().getColumn(16).setResizable(false);
		tbDados.getColumnModel().getColumn(17).setResizable(false);
		tbDados.getColumnModel().getColumn(18).setResizable(false);
		preencherTabela();
	}
	
	public boolean preencherTabela() {
		CRUDClientes select = new CRUDClientes();
		select.selectClientes();
		try {
			while (select.dadosSelect.next()) {
				System.out.println(select.dadosSelect.getInt("id_cliente")+" / "+select.dadosSelect.getString("nome_razao"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
