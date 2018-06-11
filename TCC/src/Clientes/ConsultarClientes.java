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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class ConsultarClientes {

	private JFrame frmConsultaDeClientes;
	private JTable tabela;
	public static String cliSelecionado;
	private JButton btnVoltar;
	private JPanel panel;

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
		frmConsultaDeClientes.setBounds(100, 100, 688, 626);
		frmConsultaDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeClientes.setResizable(false);
		frmConsultaDeClientes.setLocationRelativeTo(null);
		frmConsultaDeClientes.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeClientes = new JLabel("Consulta de Clientes");
		lblConsultaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeClientes.setBounds(10, 11, 149, 17);
		frmConsultaDeClientes.getContentPane().add(lblConsultaDeClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 662, 385);
		frmConsultaDeClientes.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indexLinha = tabela.getSelectedRow();
				cliSelecionado = (String) tabela.getValueAt(indexLinha, 9);
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
				"Nome/Raz\u00E3o", "Tipo de Pessoa", "Sexo", "E-mail", "UF", "Cidade", "Bairro", "Rua", "N\u00FAmero", "CPF/CNPJ", "RG/IE", "M\u00E3e", "Pai", "Data de Nascimento", "Estado Civil", "Tel 1", "Tel 2", "Cel 1", "Cel 2"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 563, 89, 23);
		frmConsultaDeClientes.getContentPane().add(btnVoltar);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 39, 662, 117);
		frmConsultaDeClientes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisarPor = new JLabel("Pesquisar por:");
		lblPesquisarPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPesquisarPor.setBounds(10, 11, 87, 15);
		panel.add(lblPesquisarPor);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 37, 87, 15);
		panel.add(lblNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnPesquisar.setFocusable(false);
		btnPesquisar.setBackground(new Color(0, 73, 170));
		btnPesquisar.setBounds(554, 83, 98, 23);
		panel.add(btnPesquisar);
		
		JLabel label = new JLabel("Nome:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 63, 87, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(263, 37, 87, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(263, 63, 87, 15);
		panel.add(label_2);
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
				modelo.addRow(new Object[]{selecionar.dadosSelect.getString("nome_razao"), selecionar.dadosSelect.getString("tipo_de_pessoa"), selecionar.dadosSelect.getString("sexo"), selecionar.dadosSelect.getString("email"), selecionar.dadosSelect.getString("uf"), selecionar.dadosSelect.getString("cidade"), selecionar.dadosSelect.getString("bairro"), selecionar.dadosSelect.getString("rua"), selecionar.dadosSelect.getString("numero"), selecionar.dadosSelect.getString("cpf_cnpj"), selecionar.dadosSelect.getString("rg_ie"), selecionar.dadosSelect.getString("mae"), selecionar.dadosSelect.getString("pai"), selecionar.dadosSelect.getString("data_de_nascimento"), selecionar.dadosSelect.getString("estado_civil"), selecionar.dadosSelect.getString("tel1"), selecionar.dadosSelect.getString("tel2"), selecionar.dadosSelect.getString("cel1"), selecionar.dadosSelect.getString("cel2")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
