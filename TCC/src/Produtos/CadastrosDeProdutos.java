package Produtos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import CRUD.CRUDLojas;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class CadastrosDeProdutos {

	private JFrame frmCadastroDeProdutos;
	private JTextField tfFornecedor;
	
	private MaskFormatter mascara;
	private JFormattedTextField ftfCodigo;
	private JFormattedTextField ftfDataDeEmissao;
	private JButton btnCalendario;
	private JTextField tfDescricao;
	private JPanel pnCor;
	private JButton btnSelecionarCor;
	private JLabel lblCor;
	private JComboBox comboLojaEmitente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrosDeProdutos window = new CadastrosDeProdutos();
					window.frmCadastroDeProdutos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastrosDeProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			mascara = new MaskFormatter("# ###### ######");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmCadastroDeProdutos = new JFrame();
		frmCadastroDeProdutos.setTitle("SIG - Cadastro de Produtos");
		frmCadastroDeProdutos.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrosDeProdutos.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroDeProdutos.setBounds(100, 100, 497, 607);
		frmCadastroDeProdutos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeProdutos.setResizable(false);
		frmCadastroDeProdutos.setLocationRelativeTo(null);
		frmCadastroDeProdutos.getContentPane().setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeProdutos.setBounds(10, 11, 157, 17);
		frmCadastroDeProdutos.getContentPane().add(lblCadastroDeProdutos);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFornecedor.setBounds(10, 39, 72, 14);
		frmCadastroDeProdutos.getContentPane().add(lblFornecedor);
		
		tfFornecedor = new JTextField();
		tfFornecedor.setColumns(10);
		tfFornecedor.setBounds(92, 37, 389, 20);
		frmCadastroDeProdutos.getContentPane().add(tfFornecedor);
		
		comboLojaEmitente = new JComboBox();
		comboLojaEmitente.setBounds(92, 68, 389, 20);
		frmCadastroDeProdutos.getContentPane().add(comboLojaEmitente);
		
		JLabel lblEmitente = new JLabel("Emitente:");
		lblEmitente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmitente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmitente.setBounds(10, 71, 72, 14);
		frmCadastroDeProdutos.getContentPane().add(lblEmitente);
		
		ftfCodigo = new JFormattedTextField(mascara);
		ftfCodigo.setBounds(331, 100, 150, 20);
		frmCadastroDeProdutos.getContentPane().add(ftfCodigo);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigo.setBounds(267, 102, 54, 14);
		frmCadastroDeProdutos.getContentPane().add(lblCdigo);
		
		ftfDataDeEmissao = new JFormattedTextField();
		ftfDataDeEmissao.setFocusable(false);
		ftfDataDeEmissao.setBounds(92, 100, 113, 20);
		frmCadastroDeProdutos.getContentPane().add(ftfDataDeEmissao);
		
		btnCalendario = new JButton("...");
		btnCalendario.setForeground(Color.WHITE);
		btnCalendario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalendario.setFocusable(false);
		btnCalendario.setBackground(new Color(0, 73, 170));
		btnCalendario.setBounds(215, 99, 27, 23);
		frmCadastroDeProdutos.getContentPane().add(btnCalendario);
		
		JLabel label = new JLabel("Data:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(12, 103, 70, 14);
		frmCadastroDeProdutos.getContentPane().add(label);
		
		tfDescricao = new JTextField();
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(92, 131, 390, 20);
		frmCadastroDeProdutos.getContentPane().add(tfDescricao);
		
		JLabel label_1 = new JLabel("Descrição:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 134, 70, 14);
		frmCadastroDeProdutos.getContentPane().add(label_1);
		
		pnCor = new JPanel();
		pnCor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnCor.setBackground(Color.WHITE);
		pnCor.setBounds(92, 163, 113, 20);
		frmCadastroDeProdutos.getContentPane().add(pnCor);
		
		btnSelecionarCor = new JButton("...");
		btnSelecionarCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelecionarCor.setForeground(Color.WHITE);
		btnSelecionarCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelecionarCor.setFocusable(false);
		btnSelecionarCor.setBackground(new Color(0, 73, 170));
		btnSelecionarCor.setBounds(215, 162, 27, 23);
		frmCadastroDeProdutos.getContentPane().add(btnSelecionarCor);
		
		lblCor = new JLabel("Cor:");
		lblCor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCor.setBounds(10, 166, 70, 14);
		frmCadastroDeProdutos.getContentPane().add(lblCor);
		
		preencherComboLojas();
	}
	
	public boolean preencherComboLojas() {
		CRUDLojas select = new CRUDLojas();
		select.selectLoja();
		comboLojaEmitente.removeAllItems();
		try {
			while (select.dadosSelect.next()) {
				comboLojaEmitente.addItem(select.dadosSelect.getString("razao"));
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
