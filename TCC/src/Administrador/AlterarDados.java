package Administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDClientes;
import CRUD.CRUDUsuarios;
import Clientes.AtualizarClientes;
import Clientes.ConsultarClientes;
import Telas.TelaPrincipal;

import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AlterarDados {

	private JFrame frmAlterarDados;
	private JTable tabela;
	private JLabel lblAlterarDados;
	
	public static String campoSelecionado;
	private JButton button_1;
	private JComboBox comboPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarDados window = new AlterarDados();
					window.frmAlterarDados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlterarDados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlterarDados = new JFrame();
		frmAlterarDados.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				TelaPrincipal.frmPrincipal.setEnabled(true);
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmAlterarDados.setTitle("SIG - Alterar Dados");
		frmAlterarDados.setIconImage(Toolkit.getDefaultToolkit().getImage(AlterarDados.class.getResource("/Img/SIG 16x16.png")));
		frmAlterarDados.setResizable(false);
		frmAlterarDados.setBounds(100, 100, 626, 379);
		frmAlterarDados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlterarDados.getContentPane().setLayout(null);
		frmAlterarDados.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 600, 267);
		frmAlterarDados.getContentPane().add(scrollPane);
		
		tabela = new JTable();
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Senha", "Email", "Telefone", "Celular"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(220);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabela.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tabela);
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indexLinha = tabela.getSelectedRow();
				int indexColuna = tabela.getSelectedColumn();
				String nomeColuna = tabela.getColumnName(indexColuna);
				campoSelecionado = (String) tabela.getValueAt(indexLinha, indexColuna);
				String email = (String) tabela.getValueAt(indexLinha, 2);
				String senha = (String) tabela.getValueAt(indexLinha, 1);
				String nome = (String) tabela.getValueAt(indexLinha, 0);
				String fone = (String) tabela.getValueAt(indexLinha, 3);
				String cel = (String) tabela.getValueAt(indexLinha, 4);
				if(nomeColuna.equals("Nome")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo nome para este usuário.");
						CRUDUsuarios.updateNome(input, email);
						tabela.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Senha")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar a "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira uma nova senha para este usuário.");
						CRUDUsuarios.updateSenha(input, email);
						tabela.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Email")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo email para este usuário.");
						CRUDUsuarios.updateEmail(input, senha, nome);
						tabela.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Telefone")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o número de "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo número de telefone para este usuário.");
						CRUDUsuarios.updateFone(input, email);
						tabela.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Celular")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o número de "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo número de celular para este usuário.");
						CRUDUsuarios.updateCel(input, email);
						tabela.setValueAt(input, indexLinha, indexColuna);
					}
				}
			}
		});
		
		lblAlterarDados = new JLabel("Alterar Dados dos Usuários");
		lblAlterarDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlterarDados.setBounds(10, 11, 186, 17);
		frmAlterarDados.getContentPane().add(lblAlterarDados);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAlterarDados.dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Impact", Font.PLAIN, 13));
		button.setFocusable(false);
		button.setBackground(new Color(0, 73, 170));
		button.setBounds(10, 316, 89, 23);
		frmAlterarDados.getContentPane().add(button);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(620, 350, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		button_1 = new JButton("Pesquisar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String variavelSelect = null;
				String valorSelect = null;
				
				if (comboPesquisar.getSelectedItem().toString().equals("Nome")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o nome que deseja procurar:");
					variavelSelect = "nome";
				}
				if (comboPesquisar.getSelectedItem().toString().equals("E-mail")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o e-mail que deseja procurar:");
					variavelSelect = "email";
				}
				if (comboPesquisar.getSelectedItem().toString().equals("Telefone")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o telefone que deseja procurar:");
					variavelSelect = "fone";
				}
				if (comboPesquisar.getSelectedItem().toString().equals("Celular")) {
					valorSelect = JOptionPane.showInputDialog("Entre com o celular que deseja procurar:");
					variavelSelect = "cel";
				}
				
				preencherTabelaWhere(variavelSelect, valorSelect);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Impact", Font.PLAIN, 13));
		button_1.setFocusable(false);
		button_1.setBackground(new Color(0, 73, 170));
		button_1.setBounds(512, 317, 98, 23);
		frmAlterarDados.getContentPane().add(button_1);
		
		comboPesquisar = new JComboBox();
		comboPesquisar.setModel(new DefaultComboBoxModel(new String[] {"Nome", "E-mail", "Telefone", "Celular"}));
		comboPesquisar.setBounds(415, 317, 87, 22);
		frmAlterarDados.getContentPane().add(comboPesquisar);
		
		JLabel label = new JLabel("Pesquisar por:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(318, 321, 87, 15);
		frmAlterarDados.getContentPane().add(label);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 620, 350);
		frmAlterarDados.getContentPane().add(lblBG);
		
		preencherTabela();
	}
	
	private boolean preencherTabela() {
		CRUDUsuarios selecionar = new CRUDUsuarios();
		selecionar.selectUsuarios();
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (selecionar.dadosSelect.next()) {
				modelo.addRow(new Object[]{selecionar.dadosSelect.getString("nome"), selecionar.dadosSelect.getString("senha"), selecionar.dadosSelect.getString("email"), selecionar.dadosSelect.getString("fone"), selecionar.dadosSelect.getString("cel")});
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean preencherTabelaWhere(String variavelSelect, String valorSelect) {
		CRUDUsuarios selecionar = new CRUDUsuarios();
		selecionar.selectComWhere(variavelSelect, valorSelect);
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.setNumRows(0);
			while (selecionar.dadosSelect.next()) {
				modelo.addRow(new Object[]{selecionar.dadosSelect.getString("nome"), selecionar.dadosSelect.getString("senha"), selecionar.dadosSelect.getString("email"), selecionar.dadosSelect.getString("fone"), selecionar.dadosSelect.getString("cel")});
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
