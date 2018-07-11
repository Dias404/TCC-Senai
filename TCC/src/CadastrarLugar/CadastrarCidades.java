package CadastrarLugar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import Administrador.CadastrarLoja;
import Administrador.CadastrarUsuario;
import CRUD.CRUDLugar;
import Clientes.CadastroDeClientes;
import DAO.Lugar;
import Telas.Login;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;

public class CadastrarCidades {

	private JFrame frmCadCidade;
	private JTextField tfNome;
	private JLabel lblBG;
	private JComboBox cbEstado;
	private JButton btnCadastrar;
	private JButton btnVoltar;

	static String janela;
	public static boolean x = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		janela = args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCidades window = new CadastrarCidades();
					window.frmCadCidade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrarCidades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadCidade = new JFrame();
		frmCadCidade.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
				if(x) {
					return;
				}else {
					JOptionPane.showMessageDialog(null, "Feche a janela de cadastrar cidades\nantes de voltar para a janela\n"+janela);
					frmCadCidade.requestFocus();
				}
			}
		});
		frmCadCidade.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				x = true;
				int escolha = JOptionPane.showConfirmDialog(null,
						"Você deseja sair desta tela?", "Aviso", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(escolha==0) {
							x = false;
							frmCadCidade.dispose();
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
		frmCadCidade.setTitle("Cadastrar Cidades");
		frmCadCidade.setBounds(100, 100, 284, 130);
		frmCadCidade.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCadCidade.setResizable(false);
		frmCadCidade.setLocationRelativeTo(null);
		frmCadCidade.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarCidades.class.getResource("/Img/SIG 16x16.png")));
		frmCadCidade.getContentPane().setLayout(null);
		
		int frameWidth = frmCadCidade.getWidth();
		int frameHeight = frmCadCidade.getHeight();
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 11, 46, 14);
		frmCadCidade.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(66, 9, 205, 20);
		frmCadCidade.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(10, 42, 46, 14);
		frmCadCidade.getContentPane().add(lblEstado);
		
		cbEstado = new JComboBox();
		cbEstado.setBounds(66, 40, 205, 20);
		frmCadCidade.getContentPane().add(cbEstado);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				x = true;
				int escolha = JOptionPane.showConfirmDialog(null,
					"Você deseja sair desta tela?", "Aviso", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(escolha==0) {
					x = false;
					frmCadCidade.dispose();
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
		btnVoltar.setBounds(8, 68, 89, 23);
		frmCadCidade.getContentPane().add(btnVoltar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().isEmpty()) {
					x = true;
					JOptionPane.showMessageDialog(frmCadCidade, "O campo nome está vazio!");
					x = false;
				}else {	
					Lugar cidade = new Lugar();
					cidade.setNomeCidade(tfNome.getText().toString());
					int idEstado = cbEstado.getSelectedIndex()+1;
					String nomeCidade = tfNome.getText().toString();
					ResultSet dados = CRUDLugar.selectCidadeCondicao1(nomeCidade, idEstado);
					try {
						if(dados.next()) {
							x = true;
							JOptionPane.showMessageDialog(frmCadCidade, "Esta cidade já foi cadastrada!");
							x = false;
						}else{
							CRUDLugar.insertCidade(cidade, idEstado);
							if(janela.equals("Cadastro de Loja")) {
								CadastrarLoja.preencherComboCidade();
							}
						}
					} catch (HeadlessException | SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(frmCadCidade, "Erro ao verificar no banco!");
					}
				}
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnCadastrar.setFocusable(false);
		btnCadastrar.setBackground(new Color(0, 73, 170));
		btnCadastrar.setBounds(182, 68, 89, 23);
		frmCadCidade.getContentPane().add(btnCadastrar);
		
		lblBG = new JLabel("");
		lblBG.setBounds(0, 0, frameWidth, frameHeight);
		lblBG.setIcon(BG);
		frmCadCidade.getContentPane().add(lblBG);
		
		preencherEstados(cbEstado);
	}
	
	public static void preencherEstados(JComboBox cb) {
		CRUDLugar select = new CRUDLugar();
		select.selectEstados();
		try {
			while(select.dados.next()) {
				cb.addItem(select.dados.getString("nome_estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
