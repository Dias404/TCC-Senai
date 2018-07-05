package Produtos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JPanel panel;
	private JPanel pnColorPicker;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JButton button_25;
	private JButton button_26;
	private JButton button_27;
	private JButton button_28;
	private JButton button_29;
	private JButton button_30;
	private JButton button_31;
	private JButton button_32;
	private JButton button_33;
	private JButton button_34;
	private JButton button_35;
	private JButton button_36;
	private JButton button_37;
	private JButton button_38;
	private JButton button_39;
	
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
		frmCadastroDeProdutos.setBounds(100, 100, 538, 282);
		frmCadastroDeProdutos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeProdutos.setResizable(false);
		frmCadastroDeProdutos.setLocationRelativeTo(null);
		frmCadastroDeProdutos.getContentPane().setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeProdutos.setBounds(10, 11, 157, 17);
		frmCadastroDeProdutos.getContentPane().add(lblCadastroDeProdutos);
		
		pnColorPicker = new JPanel();
		pnColorPicker.setBounds(262, 78, 250, 165);
		frmCadastroDeProdutos.getContentPane().add(pnColorPicker);
		pnColorPicker.setLayout(null);
		
		button = new JButton("");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setFocusable(false);
		button.setBackground(Color.BLACK);
		button.setBounds(10, 10, 20, 20);
		pnColorPicker.add(button);
		
		button_1 = new JButton("");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setFocusable(false);
		button_1.setBackground(new Color(51, 51, 51));
		button_1.setBounds(40, 10, 20, 20);
		pnColorPicker.add(button_1);
		
		button_2 = new JButton("");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setFocusable(false);
		button_2.setBackground(new Color(102, 102, 102));
		button_2.setBounds(70, 10, 20, 20);
		pnColorPicker.add(button_2);
		
		button_3 = new JButton("");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setFocusable(false);
		button_3.setBackground(new Color(153, 153, 153));
		button_3.setBounds(100, 10, 20, 20);
		pnColorPicker.add(button_3);
		
		button_4 = new JButton("");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setFocusable(false);
		button_4.setBackground(new Color(204, 204, 204));
		button_4.setBounds(130, 10, 20, 20);
		pnColorPicker.add(button_4);
		
		button_5 = new JButton("");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setFocusable(false);
		button_5.setBackground(new Color(221, 221, 221));
		button_5.setBounds(160, 10, 20, 20);
		pnColorPicker.add(button_5);
		
		button_6 = new JButton("");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setFocusable(false);
		button_6.setBackground(new Color(238, 238, 238));
		button_6.setBounds(190, 10, 20, 20);
		pnColorPicker.add(button_6);
		
		button_7 = new JButton("");
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7.setFocusable(false);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(220, 10, 20, 20);
		pnColorPicker.add(button_7);
		
		button_8 = new JButton("");
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_8.setFocusable(false);
		button_8.setBackground(new Color(202, 8, 8));
		button_8.setBounds(10, 41, 20, 20);
		pnColorPicker.add(button_8);
		
		button_9 = new JButton("");
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_9.setFocusable(false);
		button_9.setBackground(new Color(253, 152, 40));
		button_9.setBounds(40, 41, 20, 20);
		pnColorPicker.add(button_9);
		
		button_10 = new JButton("");
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_10.setFocusable(false);
		button_10.setBackground(new Color(255, 253, 56));
		button_10.setBounds(70, 41, 20, 20);
		pnColorPicker.add(button_10);
		
		button_11 = new JButton("");
		button_11.setForeground(Color.WHITE);
		button_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_11.setFocusable(false);
		button_11.setBackground(new Color(21, 156, 31));
		button_11.setBounds(100, 41, 20, 20);
		pnColorPicker.add(button_11);
		
		button_12 = new JButton("");
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_12.setFocusable(false);
		button_12.setBackground(new Color(45, 255, 254));
		button_12.setBounds(130, 41, 20, 20);
		pnColorPicker.add(button_12);
		
		button_13 = new JButton("");
		button_13.setForeground(Color.WHITE);
		button_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_13.setFocusable(false);
		button_13.setBackground(new Color(48, 123, 225));
		button_13.setBounds(160, 41, 20, 20);
		pnColorPicker.add(button_13);
		
		button_14 = new JButton("");
		button_14.setForeground(Color.WHITE);
		button_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_14.setFocusable(false);
		button_14.setBackground(new Color(152, 37, 251));
		button_14.setBounds(190, 41, 20, 20);
		pnColorPicker.add(button_14);
		
		button_15 = new JButton("");
		button_15.setForeground(Color.WHITE);
		button_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_15.setFocusable(false);
		button_15.setBackground(new Color(252, 40, 252));
		button_15.setBounds(220, 41, 20, 20);
		pnColorPicker.add(button_15);
		
		button_16 = new JButton("");
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_16.setFocusable(false);
		button_16.setBackground(new Color(222, 104, 104));
		button_16.setBounds(10, 72, 20, 20);
		pnColorPicker.add(button_16);
		
		button_17 = new JButton("");
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_17.setFocusable(false);
		button_17.setBackground(new Color(244, 177, 113));
		button_17.setBounds(40, 72, 20, 20);
		pnColorPicker.add(button_17);
		
		button_18 = new JButton("");
		button_18.setForeground(Color.WHITE);
		button_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_18.setFocusable(false);
		button_18.setBackground(new Color(254, 216, 111));
		button_18.setBounds(70, 72, 20, 20);
		pnColorPicker.add(button_18);
		
		button_19 = new JButton("");
		button_19.setForeground(Color.WHITE);
		button_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_19.setFocusable(false);
		button_19.setBackground(new Color(148, 195, 128));
		button_19.setBounds(100, 72, 20, 20);
		pnColorPicker.add(button_19);
		
		button_20 = new JButton("");
		button_20.setForeground(Color.WHITE);
		button_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_20.setFocusable(false);
		button_20.setBackground(new Color(120, 165, 174));
		button_20.setBounds(130, 72, 20, 20);
		pnColorPicker.add(button_20);
		
		button_21 = new JButton("");
		button_21.setForeground(Color.WHITE);
		button_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_21.setFocusable(false);
		button_21.setBackground(new Color(113, 169, 218));
		button_21.setBounds(160, 72, 20, 20);
		pnColorPicker.add(button_21);
		
		button_22 = new JButton("");
		button_22.setForeground(Color.WHITE);
		button_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_22.setFocusable(false);
		button_22.setBackground(new Color(142, 126, 193));
		button_22.setBounds(190, 72, 20, 20);
		pnColorPicker.add(button_22);
		
		button_23 = new JButton("");
		button_23.setForeground(Color.WHITE);
		button_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_23.setFocusable(false);
		button_23.setBackground(new Color(193, 124, 160));
		button_23.setBounds(220, 72, 20, 20);
		pnColorPicker.add(button_23);
		
		button_24 = new JButton("");
		button_24.setForeground(Color.WHITE);
		button_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_24.setFocusable(false);
		button_24.setBackground(new Color(205, 31, 31));
		button_24.setBounds(10, 103, 20, 20);
		pnColorPicker.add(button_24);
		
		button_25 = new JButton("");
		button_25.setForeground(Color.WHITE);
		button_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_25.setFocusable(false);
		button_25.setBackground(new Color(228, 144, 66));
		button_25.setBounds(40, 103, 20, 20);
		pnColorPicker.add(button_25);
		
		button_26 = new JButton("");
		button_26.setForeground(Color.WHITE);
		button_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_26.setFocusable(false);
		button_26.setBackground(new Color(240, 193, 66));
		button_26.setBounds(70, 103, 20, 20);
		pnColorPicker.add(button_26);
		
		button_27 = new JButton("");
		button_27.setForeground(Color.WHITE);
		button_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_27.setFocusable(false);
		button_27.setBackground(new Color(108, 167, 84));
		button_27.setBounds(100, 103, 20, 20);
		pnColorPicker.add(button_27);
		
		button_28 = new JButton("");
		button_28.setForeground(Color.WHITE);
		button_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_28.setFocusable(false);
		button_28.setBackground(new Color(71, 129, 141));
		button_28.setBounds(130, 103, 20, 20);
		pnColorPicker.add(button_28);
		
		button_29 = new JButton("");
		button_29.setForeground(Color.WHITE);
		button_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_29.setFocusable(false);
		button_29.setBackground(new Color(90, 127, 168));
		button_29.setBounds(160, 103, 20, 20);
		pnColorPicker.add(button_29);
		
		button_30 = new JButton("");
		button_30.setForeground(Color.WHITE);
		button_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_30.setFocusable(false);
		button_30.setBackground(new Color(103, 81, 165));
		button_30.setBounds(190, 103, 20, 20);
		pnColorPicker.add(button_30);
		
		button_31 = new JButton("");
		button_31.setForeground(Color.WHITE);
		button_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_31.setFocusable(false);
		button_31.setBackground(new Color(164, 79, 121));
		button_31.setBounds(220, 103, 20, 20);
		pnColorPicker.add(button_31);
		
		button_32 = new JButton("");
		button_32.setForeground(Color.WHITE);
		button_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_32.setFocusable(false);
		button_32.setBackground(new Color(101, 2, 2));
		button_32.setBounds(10, 134, 20, 20);
		pnColorPicker.add(button_32);
		
		button_33 = new JButton("");
		button_33.setForeground(Color.WHITE);
		button_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_33.setFocusable(false);
		button_33.setBackground(new Color(119, 63, 14));
		button_33.setBounds(40, 134, 20, 20);
		pnColorPicker.add(button_33);
		
		button_34 = new JButton("");
		button_34.setForeground(Color.WHITE);
		button_34.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_34.setFocusable(false);
		button_34.setBackground(new Color(126, 95, 17));
		button_34.setBounds(70, 134, 20, 20);
		pnColorPicker.add(button_34);
		
		button_35 = new JButton("");
		button_35.setForeground(Color.WHITE);
		button_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_35.setFocusable(false);
		button_35.setBackground(new Color(40, 77, 23));
		button_35.setBounds(100, 134, 20, 20);
		pnColorPicker.add(button_35);
		
		button_36 = new JButton("");
		button_36.setForeground(Color.WHITE);
		button_36.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_36.setFocusable(false);
		button_36.setBackground(new Color(14, 52, 60));
		button_36.setBounds(130, 134, 20, 20);
		pnColorPicker.add(button_36);
		
		button_37 = new JButton("");
		button_37.setForeground(Color.WHITE);
		button_37.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_37.setFocusable(false);
		button_37.setBackground(new Color(10, 56, 98));
		button_37.setBounds(160, 134, 20, 20);
		pnColorPicker.add(button_37);
		
		button_38 = new JButton("");
		button_38.setForeground(Color.WHITE);
		button_38.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_38.setFocusable(false);
		button_38.setBackground(new Color(32, 20, 76));
		button_38.setBounds(190, 134, 20, 20);
		pnColorPicker.add(button_38);
		
		button_39 = new JButton("");
		button_39.setForeground(Color.WHITE);
		button_39.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_39.setFocusable(false);
		button_39.setBackground(new Color(75, 18, 48));
		button_39.setBounds(220, 134, 20, 20);
		pnColorPicker.add(button_39);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 220, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnVoltar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(433, 220, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				String data = formatoBR.format(dataDeHoje);
				ftfDataDeEmissao.setText(data);
				
				tfFornecedor.setText(null);
				ftfCodigo.setValue(null);
				tfDescricao.setText(null);
				
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(334, 220, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnLimpar);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 39, 512, 170);
		frmCadastroDeProdutos.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(10, 13, 72, 14);
		panel.add(lblFornecedor);
		lblFornecedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(92, 11, 410, 20);
		panel.add(tfFornecedor);
		tfFornecedor.setColumns(10);
		
		comboLojaEmitente = new JComboBox();
		comboLojaEmitente.setBounds(92, 42, 410, 20);
		panel.add(comboLojaEmitente);
		
		JLabel lblEmitente = new JLabel("Emitente:");
		lblEmitente.setBounds(10, 45, 72, 14);
		panel.add(lblEmitente);
		lblEmitente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmitente.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ftfCodigo = new JFormattedTextField(mascara);
		ftfCodigo.setBounds(331, 74, 171, 20);
		panel.add(ftfCodigo);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(267, 76, 54, 14);
		panel.add(lblCdigo);
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ftfDataDeEmissao = new JFormattedTextField();
		ftfDataDeEmissao.setBounds(92, 74, 113, 20);
		panel.add(ftfDataDeEmissao);
		ftfDataDeEmissao.setFocusable(false);
		
		btnCalendario = new JButton("...");
		btnCalendario.setBounds(215, 73, 27, 23);
		panel.add(btnCalendario);
		btnCalendario.setForeground(Color.WHITE);
		btnCalendario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalendario.setFocusable(false);
		btnCalendario.setBackground(new Color(0, 73, 170));
		
		JLabel label = new JLabel("Data:");
		label.setBounds(12, 77, 70, 14);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfDescricao = new JTextField();
		tfDescricao.setBounds(92, 105, 410, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);
		
		JLabel label_1 = new JLabel("Descrição:");
		label_1.setBounds(10, 108, 70, 14);
		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pnCor = new JPanel();
		pnCor.setBounds(92, 137, 113, 20);
		panel.add(pnCor);
		pnCor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnCor.setBackground(Color.WHITE);
		
		btnSelecionarCor = new JButton("...");
		btnSelecionarCor.setBounds(215, 136, 27, 23);
		panel.add(btnSelecionarCor);
		btnSelecionarCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnColorPicker.isVisible() ) {
					pnColorPicker.setVisible(false);
				} else {
					if (pnCalendario.isVisible()) {
						return;
					} else {
						pnColorPicker.setVisible(true);
					}
				}
			}
		});
		btnSelecionarCor.setForeground(Color.WHITE);
		btnSelecionarCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelecionarCor.setFocusable(false);
		btnSelecionarCor.setBackground(new Color(0, 73, 170));
		
		lblCor = new JLabel("Cor:");
		lblCor.setBounds(10, 140, 70, 14);
		panel.add(lblCor);
		lblCor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
