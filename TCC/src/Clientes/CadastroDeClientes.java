package Clientes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import Administrador.CadastrarUsuario;
import CRUD.CRUDClientes;
import CRUD.CRUDLugar;
import DAO.Clientes;
import Telas.Login;
import Telas.TelaPrincipal;
import javax.swing.JFormattedTextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowAdapter;

public class CadastroDeClientes {

	public static JFrame frmCadastroDeClientes;
	private JRadioButton rbFisica;
	private JRadioButton rbJuridica;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JPanel pnFisica;
	private JLabel label;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JLabel label_1;
	private JTextField tfNome;
	private JLabel label_2;
	private JTextField tfEmailF;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblN;
	private JTextField tfNumeroF;
	private JFormattedTextField ftfCPF;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField tfMae;
	private JTextField tfPai;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JTextField tfTel1F;
	private JLabel label_14;
	private JTextField tfTel2F;
	private JLabel label_15;
	private JLabel label_16;
	private JTextField tfCel1F;
	private JTextField tfCel2F;
	private JLabel lblCel;
	public static JComboBox comboUFF;
	private JPanel pnJuridica;
	private JLabel label_17;
	private JTextField tfRazaoSocial;
	private JLabel label_19;
	private JTextField tfEmailJ;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel lblN_1;
	private JTextField tfNumeroJ;
	private JLabel label_25;
	private JLabel label_26;
	private JTextField tfTel1J;
	private JLabel label_27;
	private JTextField tfTel2J;
	private JLabel label_28;
	private JLabel label_29;
	private JTextField tfCel1J;
	private JTextField tfCel2J;
	private JLabel label_30;
	private JComboBox comboUFJ;
	private JComboBox comboEstadoCivil;
	private JButton btnConsultarClientes;
	private JTextField tfDataDeNascimento;
	private JFormattedTextField ftfCNPJ;
	private JFormattedTextField ftfRG;
	private JFormattedTextField ftfIE;
	private JTextField tfBairroF;
	private JTextField tfRuaF;
	private JTextField tfCidadeF;
	private JTextField tfBairroJ;
	private JTextField tfRuaJ;
	private JTextField tfCidadeJ;
	private JButton btnCalendario;
	private JPanel pnCalendario;
	
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraCPF;
	private MaskFormatter mascaraCNPJ;
	private MaskFormatter mascaraRG;
	private MaskFormatter mascaraIE;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeClientes window = new CadastroDeClientes();
					window.frmCadastroDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroDeClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraRG = new MaskFormatter("##.###.###-#");
			mascaraIE = new MaskFormatter("###.###.###.###");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmCadastroDeClientes = new JFrame();
		frmCadastroDeClientes.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frmCadastroDeClientes.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmCadastroDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroDeClientes.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroDeClientes.setTitle("SIG - Cadastro de Clientes");
		frmCadastroDeClientes.setBounds(100, 100, 548, 464);
		frmCadastroDeClientes.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCadastroDeClientes.getContentPane().setLayout(null);
		
		JLabel lblCadastrosDeClientes = new JLabel("Cadastros de Clientes");
		lblCadastrosDeClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrosDeClientes.setBounds(10, 11, 149, 17);
		frmCadastroDeClientes.getContentPane().add(lblCadastrosDeClientes);
		
		rbFisica = new JRadioButton("Física");
		rbFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnJuridica.setVisible(false);
				pnFisica.setVisible(true);
			}
		});
		rbFisica.setBackground(new Color(119, 136, 153));
		rbFisica.setOpaque(false);
		rbFisica.setFocusable(false);
		rbFisica.setSelected(true);
		rbFisica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFisica.setBounds(10, 35, 57, 23);
		frmCadastroDeClientes.getContentPane().add(rbFisica);
		
		rbJuridica = new JRadioButton("Jurídica");
		rbJuridica.setBackground(new Color(119, 136, 153));
		rbJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnJuridica.setVisible(true);
				pnFisica.setVisible(false);
			}
		});
		rbJuridica.setOpaque(false);
		rbJuridica.setFocusable(false);
		rbJuridica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbJuridica.setBounds(69, 35, 71, 23);
		frmCadastroDeClientes.getContentPane().add(rbJuridica);
		frmCadastroDeClientes.setResizable(false);
		frmCadastroDeClientes.setLocationRelativeTo(null);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.frmPrincipal.setVisible(true);
				frmCadastroDeClientes.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 401, 89, 23);
		frmCadastroDeClientes.getContentPane().add(btnVoltar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbFisica.isSelected()) {
					String nome = tfNome.getText().toString();
					String email = tfEmailF.getText().toString();
					String estado = comboUFF.getSelectedItem().toString();
					String cidade = tfCidadeF.getText().toString();
					String bairro = tfBairroF.getText().toString();
					String rua = tfRuaF.getText().toString();
					String numero = tfNumeroF.getText().trim().toString();
					String cpf = ftfCPF.getText().toString();
					String rg = ftfRG.getText().toString();
					String mae = tfMae.getText().toString();
					String pai = tfPai.getText().toString();
					String dataDeNascimento = tfDataDeNascimento.getText().toString();
					
					String tel1 = tfTel1F.getText().trim().toString();
					if (tel1.isEmpty()) {
						tel1 = "-";
					}
					String tel2 = tfTel2F.getText().trim().toString();
					if (tel2.isEmpty()) {
						tel2 = "-";
					}
					String cel1 = tfCel1F.getText().trim().toString();
					if (cel1.isEmpty()) {
						cel1 = "-";
					}
					String cel2 = tfCel2F.getText().trim().toString();
					if (cel2.isEmpty()) {
						cel2 = "-";
					}
					
					if (nome.trim().isEmpty() || email.trim().isEmpty() || cidade.trim().isEmpty() || bairro.trim().isEmpty() || rua.trim().isEmpty() || numero.trim().isEmpty() || cpf.trim().isEmpty() || rg.trim().isEmpty() || mae.trim().isEmpty() || pai.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
					} else {
						if (tel1.equals("-") && tel2.equals("-") && cel1.equals("-") && cel2.equals("-")) {
							JOptionPane.showMessageDialog(null, "É necessário preencher no mínimo um campo de contato!",null, JOptionPane.WARNING_MESSAGE);
						} else {
							Clientes cliFi = new Clientes();
							cliFi.setTipoDePessoa("Física");
							cliFi.setNomeRazao(nome);
							if (rbMasculino.isSelected()) {
								cliFi.setSexo("m");
							}else {
								cliFi.setSexo("f");
							}
							cliFi.setEmail(email);
							cliFi.setUF(estado);
							cliFi.setCidade(cidade);
							cliFi.setBairro(bairro);
							cliFi.setRua(rua);
							cliFi.setNumero(numero);
							cliFi.setCPF_CNPJ(cpf);
							cliFi.setRG_IE(rg);
							cliFi.setMae(mae);
							cliFi.setPai(pai);
							cliFi.setDataDeNascimento(dataDeNascimento);
							cliFi.setEstadoCivil(comboEstadoCivil.getSelectedItem().toString());
							cliFi.setTel1(tel1);
							cliFi.setTel2(tel2);
							cliFi.setCel1(cel1);
							cliFi.setCel2(cel2);
							
							CRUDClientes insert = new CRUDClientes();
							insert.insertCliente(cliFi);
							JOptionPane.showMessageDialog(null, "Novo cliente cadastrado com sucesso!");
							btnLimpar.doClick();
						}
					}
				}else {
					String razaoSocial = tfRazaoSocial.getText().toString();
					String email = tfEmailJ.getText().toString();
					String estado = comboUFJ.getSelectedItem().toString();
					String cidade = tfCidadeJ.getText().toString();
					String bairro = tfBairroJ.getText().toString();
					String rua = tfRuaJ.getText().toString();
					String numero = tfNumeroJ.getText().trim().toString();
					String cnpj = ftfCNPJ.getText().toString();
					String ie = ftfIE.getText().toString();
					
					String tel1 = tfTel1J.getText().trim().toString();
					if (tel1.isEmpty()) {
						tel1 = "-";
					}
					String tel2 = tfTel2J.getText().trim().toString();
					if (tel2.isEmpty()) {
						tel2 = "-";
					}
					String cel1 = tfCel1J.getText().trim().toString();
					if (cel1.isEmpty()) {
						cel1 = "-";
					}
					String cel2 = tfCel2J.getText().trim().toString();
					if (cel2.isEmpty()) {
						cel2 = "-";
					}

					if (razaoSocial.trim().isEmpty() || email.trim().isEmpty() || cidade.trim().isEmpty() || bairro.trim().isEmpty() || rua.trim().isEmpty() || numero.trim().isEmpty() || cnpj.trim().isEmpty() || ie.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
					} else {
						if (tel1.equals("-") && tel2.equals("-") && cel1.equals("-") && cel2.equals("-")) {
							JOptionPane.showMessageDialog(null, "É necessário preencher no mínimo um campo de contato!",null, JOptionPane.WARNING_MESSAGE);
						} else {
							Clientes cliJu = new Clientes();
							cliJu.setTipoDePessoa("Jurídica");
							cliJu.setNomeRazao(razaoSocial);
							cliJu.setSexo("-");
							cliJu.setEmail(email);
							cliJu.setUF(estado);
							cliJu.setCidade(cidade);
							cliJu.setBairro(bairro);
							cliJu.setRua(rua);
							cliJu.setNumero(numero);
							cliJu.setCPF_CNPJ(cnpj);
							cliJu.setRG_IE(ie);
							cliJu.setMae("-");
							cliJu.setPai("-");
							cliJu.setDataDeNascimento("-");
							cliJu.setEstadoCivil("-");
							cliJu.setTel1(tel1);
							cliJu.setTel2(tel2);
							cliJu.setCel1(cel1);
							cliJu.setCel2(cel2);
							
							CRUDClientes insert = new CRUDClientes();
							insert.insertCliente(cliJu);
							JOptionPane.showMessageDialog(null, "Novo cliente cadastrado com sucesso!");
							btnLimpar.doClick();
						}
					}
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(442, 401, 89, 23);
		frmCadastroDeClientes.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				String data = formatoBR.format(dataDeHoje);
				tfDataDeNascimento.setText(data);
				
				tfNome.setText(null);
				tfRazaoSocial.setText(null);
				tfEmailF.setText(null);
				tfEmailJ.setText(null);
				tfCidadeF.setText(null);
				tfCidadeJ.setText(null);
				tfBairroF.setText(null);
				tfBairroJ.setText(null);
				tfRuaF.setText(null);
				tfRuaJ.setText(null);
				tfNumeroF.setText(null);
				tfNumeroJ.setText(null);
				ftfCPF.setValue(null);
				ftfCNPJ.setValue(null);
				ftfRG.setValue(null);
				ftfIE.setValue(null);
				tfMae.setText(null);
				tfPai.setText(null);
				tfTel1F.setText(null);
				tfTel2F.setText(null);
				tfTel1J.setText(null);
				tfTel2J.setText(null);
				tfCel1F.setText(null);
				tfCel2F.setText(null);
				tfCel1J.setText(null);
				tfCel2J.setText(null);
				rbMasculino.setSelected(true);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(343, 401, 89, 23);
		frmCadastroDeClientes.getContentPane().add(btnLimpar);
		
		pnFisica = new JPanel();
		pnFisica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		pnFisica.setLayout(null);
		pnFisica.setOpaque(false);
		pnFisica.setBounds(10, 65, 521, 325);
		frmCadastroDeClientes.getContentPane().add(pnFisica);
		
		pnCalendario = new JPanel();
		pnCalendario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnCalendario.setVisible(false);
		pnCalendario.setBounds(300, 228, 221, 97);
		pnFisica.add(pnCalendario);
		pnCalendario.setLayout(null);
		
		JCalendar calendario = new JCalendar();
		calendario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				Date dataInformada = new Date();
				dataInformada = calendario.getDate();
				
				if (dataInformada.before(dataDeHoje) || dataInformada.getDate() == dataDeHoje.getDate()) { // Testa se a data informada é válida
					String data = formatoBR.format(calendario.getDate());
					tfDataDeNascimento.setText(data);
				} else {
					JOptionPane.showMessageDialog(null, "A data informada precisa ser igual ou posterior à data de hoje!", "Data Inválida", JOptionPane.ERROR_MESSAGE);
					calendario.setDate(dataDeHoje);
					String data = formatoBR.format(dataDeHoje);
					tfDataDeNascimento.setText(data);
				}
			}
		});
		calendario.setBounds(0, 0, 221, 97);
		pnCalendario.add(calendario);
		
		label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 13, 38, 14);
		pnFisica.add(label);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBackground(new Color(119, 136, 153));
		rbMasculino.setSelected(true);
		rbMasculino.setOpaque(false);
		rbMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMasculino.setFocusable(false);
		rbMasculino.setBounds(407, 4, 77, 14);
		pnFisica.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBackground(new Color(119, 136, 153));
		rbFeminino.setOpaque(false);
		rbFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFeminino.setFocusable(false);
		rbFeminino.setBounds(407, 21, 77, 14);
		pnFisica.add(rbFeminino);
		
		label_1 = new JLabel("Sexo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(367, 13, 34, 14);
		pnFisica.add(label_1);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(58, 11, 266, 20);
		pnFisica.add(tfNome);
		
		label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 44, 40, 14);
		pnFisica.add(label_2);
		
		tfEmailF = new JTextField();
		tfEmailF.setColumns(10);
		tfEmailF.setBounds(58, 42, 232, 20);
		pnFisica.add(tfEmailF);
		
		label_3 = new JLabel("UF:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(30, 76, 18, 14);
		pnFisica.add(label_3);
		
		label_4 = new JLabel("Cidade:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(255, 76, 45, 14);
		pnFisica.add(label_4);
		
		label_5 = new JLabel("Bairro:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(8, 106, 40, 14);
		pnFisica.add(label_5);
		
		label_6 = new JLabel("Rua:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(18, 138, 32, 14);
		pnFisica.add(label_6);
		
		lblN = new JLabel("N°:");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblN.setBounds(268, 138, 32, 14);
		pnFisica.add(lblN);
		
		tfNumeroF = new JTextField();
		tfNumeroF.setColumns(10);
		tfNumeroF.setBounds(310, 136, 200, 20);
		pnFisica.add(tfNumeroF);
		
		ftfCPF = new JFormattedTextField(mascaraCPF);
		ftfCPF.setColumns(10);
		ftfCPF.setBounds(58, 166, 200, 20);
		pnFisica.add(ftfCPF);
		
		label_8 = new JLabel("CPF:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(21, 168, 27, 14);
		pnFisica.add(label_8);
		
		ftfRG = new JFormattedTextField(mascaraRG);
		ftfRG.setColumns(10);
		ftfRG.setBounds(58, 197, 200, 20);
		pnFisica.add(ftfRG);
		
		label_9 = new JLabel("RG:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(21, 199, 27, 14);
		pnFisica.add(label_9);
		
		tfMae = new JTextField();
		tfMae.setColumns(10);
		tfMae.setBounds(310, 168, 200, 20);
		pnFisica.add(tfMae);
		
		tfPai = new JTextField();
		tfPai.setColumns(10);
		tfPai.setBounds(310, 197, 200, 20);
		pnFisica.add(tfPai);
		
		label_10 = new JLabel("Mãe:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(262, 168, 38, 14);
		pnFisica.add(label_10);
		
		label_11 = new JLabel("Pai:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(262, 199, 38, 14);
		pnFisica.add(label_11);
		
		label_12 = new JLabel("Data de nascimento:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(21, 231, 126, 14);
		pnFisica.add(label_12);
		
		label_13 = new JLabel("Estado Civil:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(320, 232, 77, 14);
		pnFisica.add(label_13);
		
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setFocusable(false);
		tfDataDeNascimento.setColumns(10);
		tfDataDeNascimento.setBounds(157, 229, 101, 20);
		pnFisica.add(tfDataDeNascimento);
		
		tfTel1F = new JTextField();
		tfTel1F.setColumns(10);
		tfTel1F.setBounds(58, 260, 200, 20);
		pnFisica.add(tfTel1F);
		
		label_14 = new JLabel("Tel 1:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(10, 262, 38, 14);
		pnFisica.add(label_14);
		
		tfTel2F = new JTextField();
		tfTel2F.setColumns(10);
		tfTel2F.setBounds(58, 291, 200, 20);
		pnFisica.add(tfTel2F);
		
		label_15 = new JLabel("Tel 2:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(10, 294, 38, 14);
		pnFisica.add(label_15);
		
		label_16 = new JLabel("Cel 1:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(262, 262, 38, 14);
		pnFisica.add(label_16);
		
		tfCel1F = new JTextField();
		tfCel1F.setColumns(10);
		tfCel1F.setBounds(310, 260, 200, 20);
		pnFisica.add(tfCel1F);
		
		tfCel2F = new JTextField();
		tfCel2F.setColumns(10);
		tfCel2F.setBounds(310, 291, 200, 20);
		pnFisica.add(tfCel2F);
		
		lblCel = new JLabel("Cel 2:");
		lblCel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCel.setBounds(262, 294, 38, 14);
		pnFisica.add(lblCel);
		
		comboUFF = new JComboBox();
		comboUFF.setBounds(58, 74, 163, 20);
		comboUFF.setSelectedItem("São Paulo");
		pnFisica.add(comboUFF);
		
		pnJuridica = new JPanel();
		pnJuridica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		pnJuridica.setVisible(false);
		pnJuridica.setBounds(10, 65, 521, 325);
		frmCadastroDeClientes.getContentPane().add(pnJuridica);
		pnJuridica.setLayout(null);
		pnJuridica.setOpaque(false);
		
		label_17 = new JLabel("Razão Social:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(10, 13, 80, 14);
		pnJuridica.add(label_17);
		
		tfNumeroJ = new JTextField();
		tfNumeroJ.setBounds(310, 136, 200, 20);
		pnJuridica.add(tfNumeroJ);
		tfNumeroJ.setColumns(10);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setColumns(10);
		tfRazaoSocial.setBounds(100, 11, 410, 20);
		pnJuridica.add(tfRazaoSocial);
		
		label_19 = new JLabel("E-mail:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(10, 44, 40, 14);
		pnJuridica.add(label_19);
		
		tfEmailJ = new JTextField();
		tfEmailJ.setColumns(10);
		tfEmailJ.setBounds(58, 42, 232, 20);
		pnJuridica.add(tfEmailJ);
		
		label_20 = new JLabel("UF:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setBounds(30, 76, 18, 14);
		pnJuridica.add(label_20);
		
		label_21 = new JLabel("Cidade:");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_21.setBounds(255, 76, 45, 14);
		pnJuridica.add(label_21);
		
		label_22 = new JLabel("Bairro:");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_22.setBounds(8, 106, 40, 14);
		pnJuridica.add(label_22);
		
		label_23 = new JLabel("Rua:");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_23.setBounds(18, 138, 32, 14);
		pnJuridica.add(label_23);
		
		ftfCNPJ = new JFormattedTextField(mascaraCNPJ);
		ftfCNPJ.setColumns(10);
		ftfCNPJ.setBounds(58, 166, 200, 20);
		pnJuridica.add(ftfCNPJ);
		
		label_25 = new JLabel("CNPJ:");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_25.setBounds(10, 168, 38, 14);
		pnJuridica.add(label_25);
		
		ftfIE = new JFormattedTextField(mascaraIE);
		ftfIE.setColumns(10);
		ftfIE.setBounds(310, 168, 200, 20);
		pnJuridica.add(ftfIE);
		
		label_26 = new JLabel("IE:");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_26.setBounds(262, 168, 38, 14);
		pnJuridica.add(label_26);
		
		tfTel1J = new JTextField();
		tfTel1J.setColumns(10);
		tfTel1J.setBounds(58, 197, 200, 20);
		pnJuridica.add(tfTel1J);
		
		label_27 = new JLabel("Tel 1:");
		label_27.setHorizontalAlignment(SwingConstants.RIGHT);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_27.setBounds(12, 199, 38, 14);
		pnJuridica.add(label_27);
		
		tfTel2J = new JTextField();
		tfTel2J.setColumns(10);
		tfTel2J.setBounds(58, 229, 200, 20);
		pnJuridica.add(tfTel2J);
		
		label_28 = new JLabel("Tel 2:");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_28.setBounds(12, 230, 38, 14);
		pnJuridica.add(label_28);
		
		label_29 = new JLabel("Cel 1:");
		label_29.setHorizontalAlignment(SwingConstants.RIGHT);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_29.setBounds(262, 199, 38, 14);
		pnJuridica.add(label_29);
		
		tfCel1J = new JTextField();
		tfCel1J.setColumns(10);
		tfCel1J.setBounds(310, 197, 200, 20);
		pnJuridica.add(tfCel1J);
		
		tfCel2J = new JTextField();
		tfCel2J.setColumns(10);
		tfCel2J.setBounds(310, 229, 200, 20);
		pnJuridica.add(tfCel2J);
		
		label_30 = new JLabel("Cel 2:");
		label_30.setHorizontalAlignment(SwingConstants.RIGHT);
		label_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_30.setBounds(262, 230, 38, 14);
		pnJuridica.add(label_30);
		
		comboUFJ = new JComboBox();
		comboUFJ.setBounds(58, 74, 163, 20);
		comboUFJ.setSelectedItem("São Paulo");
		pnJuridica.add(comboUFJ);
		
		ButtonGroup grupoTipoDePessoa = new ButtonGroup();
		grupoTipoDePessoa.add(rbFisica);
		grupoTipoDePessoa.add(rbJuridica);
		
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rbMasculino);
		grupoSexo.add(rbFeminino);
		
		comboEstadoCivil = new JComboBox();
		comboEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro(a)", "Casado(a)", "Separado(a)", "Divorciado(a)", "Viúvo(a)"}));
		comboEstadoCivil.setBounds(407, 229, 103, 20);
		pnFisica.add(comboEstadoCivil);
		
		btnCalendario = new JButton("...");
		btnCalendario.setFocusable(false);
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pnCalendario.isVisible()) {
					pnCalendario.setVisible(false);
				} else {
					pnCalendario.setVisible(true);
				}
			}
		});
		btnCalendario.setForeground(Color.WHITE);
		btnCalendario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalendario.setBackground(new Color(0, 73, 170));
		btnCalendario.setBounds(263, 227, 27, 23);
		pnFisica.add(btnCalendario);
		comboUFJ.setSelectedItem("São Paulo");
		
		btnConsultarClientes = new JButton("<html>Consultar<br/>&nbsp;&nbsp;Clientes</html>");
		btnConsultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarClientes.main(null);
				frmCadastroDeClientes.dispose();
			}
		});
		btnConsultarClientes.setForeground(Color.WHITE);
		btnConsultarClientes.setFont(new Font("Impact", Font.PLAIN, 13));
		btnConsultarClientes.setFocusable(false);
		btnConsultarClientes.setBackground(new Color(0, 73, 170));
		btnConsultarClientes.setBounds(442, 10, 89, 48);
		frmCadastroDeClientes.getContentPane().add(btnConsultarClientes);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(542, 436, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 542, 436);
		frmCadastroDeClientes.getContentPane().add(lblBG);
		
		preencherComboUF();
		comboUFF.setSelectedItem("São Paulo");
		
		tfBairroF = new JTextField();
		tfBairroF.setColumns(10);
		tfBairroF.setBounds(58, 104, 201, 20);
		pnFisica.add(tfBairroF);
		
		tfRuaF = new JTextField();
		tfRuaF.setColumns(10);
		tfRuaF.setBounds(58, 136, 201, 20);
		pnFisica.add(tfRuaF);
		
		tfCidadeF = new JTextField();
		tfCidadeF.setColumns(10);
		tfCidadeF.setBounds(310, 74, 201, 20);
		pnFisica.add(tfCidadeF);
		comboUFJ.setSelectedItem("São Paulo");
		
		tfBairroJ = new JTextField();
		tfBairroJ.setColumns(10);
		tfBairroJ.setBounds(58, 104, 201, 20);
		pnJuridica.add(tfBairroJ);
		
		tfRuaJ = new JTextField();
		tfRuaJ.setColumns(10);
		tfRuaJ.setBounds(58, 136, 201, 20);
		pnJuridica.add(tfRuaJ);
		
		tfCidadeJ = new JTextField();
		tfCidadeJ.setColumns(10);
		tfCidadeJ.setBounds(310, 74, 201, 20);
		pnJuridica.add(tfCidadeJ);
		
		lblN_1 = new JLabel("N°:");
		lblN_1.setBounds(268, 138, 32, 14);
		pnJuridica.add(lblN_1);
		lblN_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	}
	
	private boolean preencherComboUF() {
		CRUDLugar selecionar = new CRUDLugar();
		selecionar.selectEstados();
		comboUFF.removeAllItems();
		comboUFJ.removeAllItems();
		try {
			while (selecionar.dados.next()) {
				comboUFF.addItem(selecionar.dados.getString("nome_estado"));
				comboUFJ.addItem(selecionar.dados.getString("nome_estado"));
			}
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
