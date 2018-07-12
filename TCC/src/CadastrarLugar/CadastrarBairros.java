package CadastrarLugar;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Administrador.CadastrarLoja;
import Administrador.CadastrarUsuario;
import CRUD.CRUDLugar;
import Clientes.CadastroDeClientes;
import DAO.Lugar;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CadastrarBairros {

	private JFrame frmCadBairro;
	private JLabel lblBG;
	
	static String janela;
	public static boolean x = false;
	private JTextField tfNome;
	private JLabel lblEstado;
	private static JComboBox cbEstado;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private static JComboBox cbCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		janela = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarBairros window = new CadastrarBairros();
					window.frmCadBairro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarBairros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadBairro = new JFrame();
		frmCadBairro.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
				if(x) {
					return;
				}else {
					JOptionPane.showMessageDialog(null, "Feche a janela de cadastrar bairros\nantes de voltar para a janela\n"+janela);
					frmCadBairro.requestFocus();
				}
			}
		});
		frmCadBairro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				x = true;
				int escolha = JOptionPane.showConfirmDialog(null,
						"Você deseja sair desta tela?", "Aviso", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(escolha==0) {
							x = false;
							frmCadBairro.dispose();
						}else {
							x = false;
							return;
						}
			}
			@Override
			public void windowClosed(WindowEvent e) {
				if(janela.equals("Cadastro de Loja")) {
					CadastrarLoja.frmCadastrarLoja.setEnabled(true);
					CadastrarLoja.frmCadastrarLoja.setVisible(true);
				}
				if(janela.equals("Cadastro de Cliente")) {
					CadastroDeClientes.frmCadastroDeClientes.setEnabled(true);
					CadastroDeClientes.frmCadastroDeClientes.setVisible(true);
				}
			}
		});
		frmCadBairro.setTitle("Cadastrar Bairros");
		frmCadBairro.setBounds(100, 100, 284, 164);
		frmCadBairro.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCadBairro.setResizable(false);
		frmCadBairro.setLocationRelativeTo(null);
		frmCadBairro.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarCidades.class.getResource("/Img/SIG 16x16.png")));
		frmCadBairro.getContentPane().setLayout(null);
		
		int frameWidth = frmCadBairro.getWidth();
		int frameHeight = frmCadBairro.getHeight();
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 11, 46, 14);
		frmCadBairro.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(66, 9, 205, 20);
		frmCadBairro.getContentPane().add(tfNome);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(10, 42, 46, 14);
		frmCadBairro.getContentPane().add(lblEstado);
		
		cbEstado = new JComboBox();
		cbEstado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				preencherCidades();
			}
		});
		cbEstado.setBounds(66, 40, 205, 20);
		frmCadBairro.getContentPane().add(cbEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(10, 73, 46, 14);
		frmCadBairro.getContentPane().add(lblCidade);
		
		cbCidade = new JComboBox();
		cbCidade.setBounds(66, 71, 205, 20);
		frmCadBairro.getContentPane().add(cbCidade);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = true;
				int escolha = JOptionPane.showConfirmDialog(null,
					"Você deseja sair desta tela?", "Aviso", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(escolha==0) {
					x = false;
					frmCadBairro.dispose();
				}else {
					x = false;
					return;		
				}
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(8, 103, 89, 23);
		frmCadBairro.getContentPane().add(btnVoltar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().isEmpty() /*|| cbCidade.getSelectedItem().toString().isEmpty()*/) {
					x = true;
					JOptionPane.showMessageDialog(frmCadBairro, "Um ou mais campos estão vazios!");
					x = false;
				}else {
					try {
						CRUDLugar pegaIdCidade = new CRUDLugar();
						CRUDLugar verificaExistencia = new CRUDLugar();
						int idEstado = cbEstado.getSelectedIndex()+1;
						String nomeCidade = cbCidade.getSelectedItem().toString();
						String nomeBairro = tfNome.getText().toString();
						ResultSet rsIdCidade = pegaIdCidade.selectCidadeCondicao1(nomeCidade, idEstado);
						int idCidade = 0;
						if(rsIdCidade.next()) {
							idCidade = rsIdCidade.getInt("id_cidade");
						}
						ResultSet rsVerifica = verificaExistencia.selectBairroCondicao1(nomeBairro, idCidade);
						if(rsVerifica.next()) {
							x = true; 
							JOptionPane.showMessageDialog(frmCadBairro, "Este bairro já foi cadastrado!");
							x = false;
						}else {
							x = true;
							CRUDLugar insert = new CRUDLugar();
							insert.insertBairro(nomeBairro, idCidade);
							if(janela.equals("Cadastro de Loja")) {
								CadastrarLoja.preencherComboBairro();
							}
							if(janela.equals("Cadastro de Cliente")) {
								if(CadastroDeClientes.UF != null) {
									try {
										CadastroDeClientes.UF.absolute(CadastroDeClientes.comboUFF.getSelectedIndex());
										CadastroDeClientes.preencherCidade(CadastroDeClientes.UF.getInt("id_estado")+1);
									} catch (SQLException e2) {
										e2.printStackTrace();
									}
								}
							}
							x = false; 
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					/*int idEstado = cbEstado.getSelectedIndex()+1;
					String nomeCidade = cbCidade.getSelectedItem().toString();
					String nomeBairro = tfNome.getText().toString();
					try {
						ResultSet dados0 = CRUDLugar.selectCidadeCondicao1(nomeCidade, idEstado);
						ResultSet dados1 = CRUDLugar.selectBairroCondicao1(nomeBairro, dados0.getInt("id_cidade"));
						if(dados1.next()) {
							x = true; 
							JOptionPane.showMessageDialog(frmCadBairro, "Este bairro já foi cadastrado!");
							x = false;
						}else {
							x = true;
							CRUDLugar.insertBairro(nomeBairro, dados0.getInt("id_cidade"));
							x = false;
						}
					}catch (HeadlessException | SQLException e1) {
						e1.printStackTrace();
						x = true;
						JOptionPane.showMessageDialog(frmCadBairro, "Erro ao verificar no banco!");
						x = false;
					}*/
				}
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCadastrar.setFocusable(false);
		btnCadastrar.setBackground(new Color(0, 73, 170));
		btnCadastrar.setBounds(182, 103, 89, 23);
		frmCadBairro.getContentPane().add(btnCadastrar);
		
		lblBG = new JLabel("");
		lblBG.setBounds(0, 0, frameWidth, frameHeight);
		lblBG.setIcon(BG);
		frmCadBairro.getContentPane().add(lblBG);
		
		preencherEstados();
		preencherCidades();
	}
	
	public static void preencherEstados() {
		CRUDLugar select = new CRUDLugar();
		select.selectEstados();
		cbEstado.removeAllItems();
		try {
			while(select.dados.next()) {
				cbEstado.addItem(select.dados.getString("nome_estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void preencherCidades() {
		int idEstado = cbEstado.getSelectedIndex()+1;
		CRUDLugar select = new CRUDLugar();
		select.selectCidadeCondicao2(idEstado);
		try {
			cbCidade.removeAllItems();
			while(select.dadosSelect.next()) {
				cbCidade.addItem(select.dadosSelect.getString("nome_cidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
