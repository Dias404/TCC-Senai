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

public class AlterarDados {

	private JFrame frmAlterarDados;
	private JTable table;
	private JLabel lblAlterarDados;
	
	public static String campoSelecionado;

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
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(220);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indexLinha = table.getSelectedRow();
				int indexColuna = table.getSelectedColumn();
				String nomeColuna = table.getColumnName(indexColuna);
				campoSelecionado = (String) table.getValueAt(indexLinha, indexColuna);
				String email = (String) table.getValueAt(indexLinha, 2);
				String senha = (String) table.getValueAt(indexLinha, 1);
				String nome = (String) table.getValueAt(indexLinha, 0);
				String fone = (String) table.getValueAt(indexLinha, 3);
				String cel = (String) table.getValueAt(indexLinha, 4);
				if(nomeColuna.equals("Nome")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo nome para este usuário.");
						CRUDUsuarios.updateNome(input, email);
						table.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Senha")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar a "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira uma nova senha para este usuário.");
						CRUDUsuarios.updateSenha(input, email);
						table.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Email")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo email para este usuário.");
						CRUDUsuarios.updateEmail(input, senha, nome);
						table.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Telefone")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o número de "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo número de telefone para este usuário.");
						CRUDUsuarios.updateFone(input, email);
						table.setValueAt(input, indexLinha, indexColuna);
					}
				}
				if(nomeColuna.equals("Celular")) {
					int escolha = JOptionPane.showConfirmDialog(frmAlterarDados, 
					"Você deseja alterar o número de "+nomeColuna.toLowerCase()+" deste usuário?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
					
					if(escolha==0) {
						String input = JOptionPane.showInputDialog("Insira um novo número de celular para este usuário.");
						CRUDUsuarios.updateCel(input, email);
						table.setValueAt(input, indexLinha, indexColuna);
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
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
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
}
