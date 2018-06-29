package Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Administrador.CadastrarUsuario;
import CRUD.CRUDClientes;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConsultarClientes {

	private JFrame frmConsultaDeClientes;
	private JTable tabela;
	private JButton btnVoltar;
	private JLabel lblBG;
	private JButton btnPesquisar;
	private JComboBox comboPesquisa;
	private JButton btnRefresh;
	
	public static String cliSelecionado;
	
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
		frmConsultaDeClientes.setBounds(100, 100, 626, 497);
		frmConsultaDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeClientes.setResizable(false);
		frmConsultaDeClientes.setLocationRelativeTo(null);
		frmConsultaDeClientes.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeClientes = new JLabel("Consulta de Clientes");
		lblConsultaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeClientes.setBounds(10, 11, 149, 17);
		frmConsultaDeClientes.getContentPane().add(lblConsultaDeClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setOpaque(false);					// SCROLL PANE
		//scrollPane.getViewport().setOpaque(false);	// TRANSPARENTE
		scrollPane.setBounds(10, 39, 600, 385);
		frmConsultaDeClientes.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.setRowSelectionAllowed(false);
		tabela.setOpaque(false);
		//((JComponent) tabela.getDefaultRenderer(Object.class)).setOpaque(false); // TABLE TRANSPARENTE
		tabela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int respostaJOP = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar esses dados?",null, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (respostaJOP == JOptionPane.YES_OPTION) {
					int indexLinha = tabela.getSelectedRow();
					cliSelecionado = (String) tabela.getValueAt(indexLinha, 9);
					frmConsultaDeClientes.dispose();
					AtualizarClientes.main(null);
				} else {
					return;
				}
			}
		});
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabela);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome/Raz\u00E3o", "Tipo", "Sexo", "E-mail", "UF", "Cidade", "Bairro", "Rua", "N\u00FAmero", "CPF/CNPJ", "RG/IE", "M\u00E3e", "Pai", "Data de Nascimento", "Estado Civil", "Tel 1", "Tel 2", "Cel 1", "Cel 2"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(0).setMinWidth(200);
		tabela.getColumnModel().getColumn(0).setMaxWidth(200);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(1).setMinWidth(60);
		tabela.getColumnModel().getColumn(1).setMaxWidth(60);
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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeClientes.main(null);
				frmConsultaDeClientes.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 435, 89, 23);
		frmConsultaDeClientes.getContentPane().add(btnVoltar);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(682, 598, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		comboPesquisa = new JComboBox();
		comboPesquisa.setBounds(339, 435, 163, 23);
		frmConsultaDeClientes.getContentPane().add(comboPesquisa);
		comboPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Nome/Razão Social", "Tipo de Pessoa", "Sexo", "E-mail", "UF", "Cidade", "Bairro", "Rua", "Número", "CPF/CNPJ", "RG/IE", "Mãe", "Pai", "Estado Civil"}));
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String variavelSelect = null;
				String valorSelect = null;
				
				if (comboPesquisa.getSelectedItem().toString().equals("Nome/Razão Social")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome ou a razão social que deseja procurar:");
					variavelSelect = "nome_razao";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Tipo de Pessoa")) {
					Object[] valoresComboBox = { "Física", "Jurídica" };
			        Object valorSelecionado = JOptionPane.showInputDialog(null, "Entre com o tipo de pessoa que deseja procurar:", null, JOptionPane.INFORMATION_MESSAGE, null, valoresComboBox, valoresComboBox [0]);
			        if (valorSelecionado.equals("Física")) {
						valorSelect = "Física";
					}
			        if (valorSelecionado.equals("Jurídica")) {
						valorSelect = "Jurídica";
					}
			        variavelSelect = "tipo_de_pessoa";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Sexo")) {
					Object[] valoresComboBox = { "Masculino", "Feminino" };
			        Object valorSelecionado = JOptionPane.showInputDialog(null, "Entre com o sexo que deseja procurar:", null, JOptionPane.INFORMATION_MESSAGE, null, valoresComboBox, valoresComboBox [0]);
			        if (valorSelecionado.equals("Masculino")) {
						valorSelect = "m";
					}
			        if (valorSelecionado.equals("Feminino")) {
						valorSelect = "f";
					}
			        variavelSelect = "sexo";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("E-mail")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o e-mail que deseja procurar:");
					variavelSelect = "email";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("UF")) {
					//Object[] possiveisValores = {"Acre", "Alagoas", "Amapá" , "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Raraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
					//Object selectedValue = JOptionPane.showInputDialog(null, "Entre com o estado que deseja procurar:", null, JOptionPane.INFORMATION_MESSAGE, null, possiveisValores, possiveisValores [0]);
					valorSelect = JOptionPane.showInputDialog("Entre com o estado que deseja procurar:");
					variavelSelect = "uf";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Cidade")) {
					valorSelect = JOptionPane.showInputDialog("Entre com a cidade que deseja procurar:");
					variavelSelect = "cidade";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Bairro")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o bairro que deseja procurar:");
					variavelSelect = "bairro";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Rua")) {
					valorSelect = JOptionPane.showInputDialog("Entre com a rua que deseja procurar:");
					variavelSelect = "rua";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Número")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o número da casa que deseja procurar:");
					variavelSelect = "numero";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("CPF/CNPJ")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o CPF ou o CPNJ que deseja procurar:");
					variavelSelect = "cpf_cnpj";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("RG/IE")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o RG ou o IE que deseja procurar:");
					variavelSelect = "rg_ie";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Mãe")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome da filiação que deseja procurar:");
					variavelSelect = "mae";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Pai")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome da filiação que deseja procurar:");
					variavelSelect = "pai";
				}
				
				if (comboPesquisa.getSelectedItem().toString().equals("Estado Civil")) {
					Object[] valoresComboBox = {"Solteiro(a)","Casado(a)","Separado(a)","Divorciado","Viúvo(a)"};
			        Object valorSelecionado = JOptionPane.showInputDialog(null, "Entre com o estado civil que deseja procurar:", null, JOptionPane.INFORMATION_MESSAGE, null, valoresComboBox, valoresComboBox [0]);	
			        if (valoresComboBox.equals("Solteiro(a)")) {
			        	valorSelect = "Solteiro(a)";
					}
			        if (valoresComboBox.equals("Casado(a)")) {
			        	valorSelect = "Casado(a)";
					}
			        if (valoresComboBox.equals("Separado(a)")) {
			        	valorSelect = "Separado(a)";
					}
			        if (valoresComboBox.equals("Divorciado(a)")) {
			        	valorSelect = "Divorciado(a)";
					}
			        if (valoresComboBox.equals("Viúvo(a)")) {
			        	valorSelect = "Viúvo(a)";
					}
			        variavelSelect = "estado_civil";
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
		btnPesquisar.setBounds(512, 435, 98, 23);
		frmConsultaDeClientes.getContentPane().add(btnPesquisar);
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnPesquisar.setFocusable(false);
		btnPesquisar.setBackground(new Color(0, 73, 170));
		
		btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencherTabela();
				btnRefresh.setVisible(false);
				new Thread(sleep).start();
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Impact", Font.PLAIN, 13));
		btnRefresh.setFocusable(false);
		btnRefresh.setBackground(new Color(0, 73, 170));
		btnRefresh.setBounds(587, 8, 23, 23);
		frmConsultaDeClientes.getContentPane().add(btnRefresh);
		
		JLabel lblPesquisarPor = new JLabel("Pesquisar por:");
		lblPesquisarPor.setBounds(242, 440, 87, 15);
		frmConsultaDeClientes.getContentPane().add(lblPesquisarPor);
		lblPesquisarPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 620, 469);
		frmConsultaDeClientes.getContentPane().add(lblBG);
		tabela.getTableHeader().setReorderingAllowed(false);
		
		preencherTabela();
	}
	
	private boolean preencherTabela() {
		String sexo = null;
		CRUDClientes selecionar = new CRUDClientes();
		selecionar.selectClientes();
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (selecionar.dadosSelect.next()) {
				if (selecionar.dadosSelect.getString("sexo").equalsIgnoreCase("M")) {
					sexo = "Masculino";
				}
				if (selecionar.dadosSelect.getString("sexo").equalsIgnoreCase("F")) {
					sexo = "Feminino";
				}
				if (selecionar.dadosSelect.getString("sexo").equalsIgnoreCase("-")) {
					sexo = "----------";
				}
				modelo.addRow(new Object[]{selecionar.dadosSelect.getString("nome_razao"), selecionar.dadosSelect.getString("tipo_de_pessoa"), sexo, selecionar.dadosSelect.getString("email"), selecionar.dadosSelect.getString("uf"), selecionar.dadosSelect.getString("cidade"), selecionar.dadosSelect.getString("bairro"), selecionar.dadosSelect.getString("rua"), selecionar.dadosSelect.getString("numero"), selecionar.dadosSelect.getString("cpf_cnpj"), selecionar.dadosSelect.getString("rg_ie"), selecionar.dadosSelect.getString("mae"), selecionar.dadosSelect.getString("pai"), selecionar.dadosSelect.getString("data_de_nascimento"), selecionar.dadosSelect.getString("estado_civil"), selecionar.dadosSelect.getString("tel1"), selecionar.dadosSelect.getString("tel2"), selecionar.dadosSelect.getString("cel1"), selecionar.dadosSelect.getString("cel2")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean preencherTabelaWhere(String variavelSelect, String valorSelect) {
		String sexo = null;
		CRUDClientes selecionar = new CRUDClientes();
		selecionar.selectComWhere(variavelSelect, valorSelect);
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (selecionar.dadosSelect.next()) {
				if (selecionar.dadosSelect.getString("sexo").equalsIgnoreCase("M")) {
					sexo = "Masculino";
				}
				if (selecionar.dadosSelect.getString("sexo").equalsIgnoreCase("F")) {
					sexo = "Feminino";
				}
				if (selecionar.dadosSelect.getString("sexo").equalsIgnoreCase("-")) {
					sexo = "----------";
				}
				modelo.addRow(new Object[]{selecionar.dadosSelect.getString("nome_razao"), selecionar.dadosSelect.getString("tipo_de_pessoa"), sexo, selecionar.dadosSelect.getString("email"), selecionar.dadosSelect.getString("uf"), selecionar.dadosSelect.getString("cidade"), selecionar.dadosSelect.getString("bairro"), selecionar.dadosSelect.getString("rua"), selecionar.dadosSelect.getString("numero"), selecionar.dadosSelect.getString("cpf_cnpj"), selecionar.dadosSelect.getString("rg_ie"), selecionar.dadosSelect.getString("mae"), selecionar.dadosSelect.getString("pai"), selecionar.dadosSelect.getString("data_de_nascimento"), selecionar.dadosSelect.getString("estado_civil"), selecionar.dadosSelect.getString("tel1"), selecionar.dadosSelect.getString("tel2"), selecionar.dadosSelect.getString("cel1"), selecionar.dadosSelect.getString("cel2")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	Runnable sleep = new Runnable() {	
		@Override
		public void run() {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btnRefresh.setVisible(true);
		}
	};
}
