package Produtos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import CRUD.CRUDLojas;
import CRUD.CRUDProdutos;
import DAO.Produtos;
import Telas.TelaPrincipal;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;

import Administrador.CadastrarUsuario;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CadastrosDeProdutos {

	private JFrame frmCadastroDeProdutos;
	private JTextField tfFornecedor;
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
	private JButton btnPreto;
	private JButton btnCinza1;
	private JButton btnCinza2;
	private JButton btnCinza3;
	private JButton btnCinza4;
	private JButton btnCinza5;
	private JButton btnCinza6;
	private JButton btnBranco;
	private JButton btnVermelho1;
	private JButton btnLaranja1;
	private JButton btnAmarelo1;
	private JButton btnVerde1;
	private JButton btnCiano1;
	private JButton btnAzul1;
	private JButton btnVioleta1;
	private JButton btnRosa1;
	private JButton btnVermelho2;
	private JButton btnLaranja2;
	private JButton btnAmarelo2;
	private JButton btnVerde2;
	private JButton btnCiano2;
	private JButton btnAzul2;
	private JButton btnVioleta2;
	private JButton btnRosa2;
	private JButton btnVermelho3;
	private JButton btnLaranja3;
	private JButton btnAmarelo3;
	private JButton btnVerde3;
	private JButton btnCiano3;
	private JButton btnAzul3;
	private JButton btnVioleta3;
	private JButton btnRosa3;
	private JButton btnVermelho4;
	private JButton btnLaranja4;
	private JButton btnAmarelo4;
	private JButton btnVerde4;
	private JButton btnCiano4;
	private JButton btnAzul4;
	private JButton btnVioleta4;
	private JButton btnRosa4;
	private JPanel pnCalendario;
	private JButton btnLimpar;
	private JButton btnConsultarProdutos;
	private JFormattedTextField ftfCodigo;
	private MaskFormatter mascara;
	
	private String corPreto = "#000000";
	private String corBranco = "#ffffff";
	private String corCinza1 = "#333333";
	private String corCinza2 = "#666666";
	private String corCinza3 = "#999999";
	private String corCinza4 = "#cccccc";
	private String corCinza5 = "#dddddd";
	private String corCinza6 = "#eeeeee";
	private String corVermelho1 = "#ca0808";
	private String corVermelho2 = "#de6868";
	private String corVermelho3 = "#cd1f1f";
	private String corVermelho4 = "#650202";
	private String corLaranja1 = "#fd9828";
	private String corLaranja2 = "#f4b171";
	private String corLaranja3 = "#e49042";
	private String corLaranja4 = "#773f0e";
	private String corAmarelo1 = "#fffd38";
	private String corAmarelo2 = "#fed86f";
	private String corAmarelo3 = "#f0c142";
	private String corAmarelo4 = "#7e5f11";
	private String corVerde1 = "#159c1f";
	private String corVerde2 = "#94c380";
	private String corVerde3 = "#6ca754";
	private String corVerde4 = "#284d17";
	private String corCiano1 = "#2dfffe";
	private String corCiano2 = "#78a5ae";
	private String corCiano3 = "#47818d";
	private String corCiano4 = "#0e343c";
	private String corAzul1 = "#307be1";
	private String corAzul2 = "#71a9da";
	private String corAzul3 = "#5a7fa8";
	private String corAzul4 = "#0a3862";
	private String corVioleta1 = "#9825fb";
	private String corVioleta2 = "#8e7ec1";
	private String corVioleta3 = "#6751a5";
	private String corVioleta4 = "#20144c";
	private String corRosa1 = "#fc28fc";
	private String corRosa2 = "#c17ca0";
	private String corRosa3 = "#a44f79";
	private String corRosa4 = "#4b1230";
	static String corSelecionada = "#ffffff";
	private JLabel lblPreo;
	private JTextField tfPreco;
	private JSpinner spinnerQuantidade;
	
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
			mascara = new MaskFormatter("#############");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmCadastroDeProdutos = new JFrame();
		frmCadastroDeProdutos.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmCadastroDeProdutos.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmCadastroDeProdutos.setTitle("SIG - Cadastro de Produtos");
		frmCadastroDeProdutos.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrosDeProdutos.class.getResource("/Img/SIG 16x16.png")));
		frmCadastroDeProdutos.setBounds(100, 100, 538, 311);
		frmCadastroDeProdutos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCadastroDeProdutos.setResizable(false);
		frmCadastroDeProdutos.setLocationRelativeTo(null);
		frmCadastroDeProdutos.getContentPane().setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeProdutos.setBounds(10, 11, 157, 17);
		frmCadastroDeProdutos.getContentPane().add(lblCadastroDeProdutos);
		
		pnCalendario = new JPanel();
		pnCalendario.setVerifyInputWhenFocusTarget(false);
		pnCalendario.setVisible(false);
		
		pnColorPicker = new JPanel();
		pnColorPicker.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnColorPicker.setVisible(false);
		pnColorPicker.setBounds(262, 78, 250, 165);
		frmCadastroDeProdutos.getContentPane().add(pnColorPicker);
		pnColorPicker.setLayout(null);
		
		btnPreto = new JButton("");
		btnPreto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corPreto;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnPreto.setForeground(Color.WHITE);
		btnPreto.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPreto.setFocusable(false);
		btnPreto.setBackground(Color.decode(corPreto));
		btnPreto.setBounds(10, 10, 20, 20);
		pnColorPicker.add(btnPreto);
		
		btnCinza1 = new JButton("");
		btnCinza1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCinza1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCinza1.setForeground(Color.WHITE);
		btnCinza1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCinza1.setFocusable(false);
		btnCinza1.setBackground(Color.decode(corCinza1));
		btnCinza1.setBounds(40, 10, 20, 20);
		pnColorPicker.add(btnCinza1);
		
		btnCinza2 = new JButton("");
		btnCinza2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCinza2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCinza2.setForeground(Color.WHITE);
		btnCinza2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCinza2.setFocusable(false);
		btnCinza2.setBackground(Color.decode(corCinza2));
		btnCinza2.setBounds(70, 10, 20, 20);
		pnColorPicker.add(btnCinza2);
		
		btnCinza3 = new JButton("");
		btnCinza3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCinza3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCinza3.setForeground(Color.WHITE);
		btnCinza3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCinza3.setFocusable(false);
		btnCinza3.setBackground(Color.decode(corCinza3));
		btnCinza3.setBounds(100, 10, 20, 20);
		pnColorPicker.add(btnCinza3);
		
		btnCinza4 = new JButton("");
		btnCinza4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCinza4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCinza4.setForeground(Color.WHITE);
		btnCinza4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCinza4.setFocusable(false);
		btnCinza4.setBackground(Color.decode(corCinza4));
		btnCinza4.setBounds(130, 10, 20, 20);
		pnColorPicker.add(btnCinza4);
		
		btnCinza5 = new JButton("");
		btnCinza5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCinza5;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCinza5.setForeground(Color.WHITE);
		btnCinza5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCinza5.setFocusable(false);
		btnCinza5.setBackground(Color.decode(corCinza5));
		btnCinza5.setBounds(160, 10, 20, 20);
		pnColorPicker.add(btnCinza5);
		
		btnCinza6 = new JButton("");
		btnCinza6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCinza6;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCinza6.setForeground(Color.WHITE);
		btnCinza6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCinza6.setFocusable(false);
		btnCinza6.setBackground(Color.decode(corCinza6));
		btnCinza6.setBounds(190, 10, 20, 20);
		pnColorPicker.add(btnCinza6);
		
		btnBranco = new JButton("");
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corBranco;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnBranco.setForeground(Color.WHITE);
		btnBranco.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBranco.setFocusable(false);
		btnBranco.setBackground(Color.decode(corBranco));
		btnBranco.setBounds(220, 10, 20, 20);
		pnColorPicker.add(btnBranco);
		
		btnVermelho1 = new JButton("");
		btnVermelho1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVermelho1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVermelho1.setForeground(Color.WHITE);
		btnVermelho1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVermelho1.setFocusable(false);
		btnVermelho1.setBackground(Color.decode(corVermelho1));
		btnVermelho1.setBounds(10, 41, 20, 20);
		pnColorPicker.add(btnVermelho1);
		
		btnLaranja1 = new JButton("");
		btnLaranja1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corLaranja1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnLaranja1.setForeground(Color.WHITE);
		btnLaranja1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLaranja1.setFocusable(false);
		btnLaranja1.setBackground(Color.decode(corLaranja1));
		btnLaranja1.setBounds(40, 41, 20, 20);
		pnColorPicker.add(btnLaranja1);
		
		btnAmarelo1 = new JButton("");
		btnAmarelo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAmarelo1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAmarelo1.setForeground(Color.WHITE);
		btnAmarelo1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAmarelo1.setFocusable(false);
		btnAmarelo1.setBackground(Color.decode(corAmarelo1));
		btnAmarelo1.setBounds(70, 41, 20, 20);
		pnColorPicker.add(btnAmarelo1);
		
		btnVerde1 = new JButton("");
		btnVerde1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVerde1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVerde1.setForeground(Color.WHITE);
		btnVerde1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerde1.setFocusable(false);
		btnVerde1.setBackground(Color.decode(corVerde1));
		btnVerde1.setBounds(100, 41, 20, 20);
		pnColorPicker.add(btnVerde1);
		
		btnCiano1 = new JButton("");
		btnCiano1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCiano1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCiano1.setForeground(Color.WHITE);
		btnCiano1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCiano1.setFocusable(false);
		btnCiano1.setBackground(Color.decode(corCiano1));
		btnCiano1.setBounds(130, 41, 20, 20);
		pnColorPicker.add(btnCiano1);
		
		btnAzul1 = new JButton("");
		btnAzul1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAzul1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAzul1.setForeground(Color.WHITE);
		btnAzul1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAzul1.setFocusable(false);
		btnAzul1.setBackground(Color.decode(corAzul1));
		btnAzul1.setBounds(160, 41, 20, 20);
		pnColorPicker.add(btnAzul1);
		
		btnVioleta1 = new JButton("");
		btnVioleta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVioleta1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVioleta1.setForeground(Color.WHITE);
		btnVioleta1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVioleta1.setFocusable(false);
		btnVioleta1.setBackground(Color.decode(corVioleta1));
		btnVioleta1.setBounds(190, 41, 20, 20);
		pnColorPicker.add(btnVioleta1);
		
		btnRosa1 = new JButton("");
		btnRosa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corRosa1;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnRosa1.setForeground(Color.WHITE);
		btnRosa1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRosa1.setFocusable(false);
		btnRosa1.setBackground(Color.decode(corRosa1));
		btnRosa1.setBounds(220, 41, 20, 20);
		pnColorPicker.add(btnRosa1);
		
		btnVermelho2 = new JButton("");
		btnVermelho2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVermelho2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVermelho2.setForeground(Color.WHITE);
		btnVermelho2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVermelho2.setFocusable(false);
		btnVermelho2.setBackground(Color.decode(corVermelho2));
		btnVermelho2.setBounds(10, 72, 20, 20);
		pnColorPicker.add(btnVermelho2);
		
		btnLaranja2 = new JButton("");
		btnLaranja2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corLaranja2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnLaranja2.setForeground(Color.WHITE);
		btnLaranja2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLaranja2.setFocusable(false);
		btnLaranja2.setBackground(Color.decode(corLaranja2));
		btnLaranja2.setBounds(40, 72, 20, 20);
		pnColorPicker.add(btnLaranja2);
		
		btnAmarelo2 = new JButton("");
		btnAmarelo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAmarelo2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAmarelo2.setForeground(Color.WHITE);
		btnAmarelo2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAmarelo2.setFocusable(false);
		btnAmarelo2.setBackground(Color.decode(corAmarelo2));
		btnAmarelo2.setBounds(70, 72, 20, 20);
		pnColorPicker.add(btnAmarelo2);
		
		btnVerde2 = new JButton("");
		btnVerde2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVerde2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVerde2.setForeground(Color.WHITE);
		btnVerde2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerde2.setFocusable(false);
		btnVerde2.setBackground(Color.decode(corVerde2));
		btnVerde2.setBounds(100, 72, 20, 20);
		pnColorPicker.add(btnVerde2);
		
		btnCiano2 = new JButton("");
		btnCiano2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCiano2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCiano2.setForeground(Color.WHITE);
		btnCiano2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCiano2.setFocusable(false);
		btnCiano2.setBackground(Color.decode(corCiano2));
		btnCiano2.setBounds(130, 72, 20, 20);
		pnColorPicker.add(btnCiano2);
		
		btnAzul2 = new JButton("");
		btnAzul2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAzul2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAzul2.setForeground(Color.WHITE);
		btnAzul2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAzul2.setFocusable(false);
		btnAzul2.setBackground(Color.decode(corAzul2));
		btnAzul2.setBounds(160, 72, 20, 20);
		pnColorPicker.add(btnAzul2);
		
		btnVioleta2 = new JButton("");
		btnVioleta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVioleta2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVioleta2.setForeground(Color.WHITE);
		btnVioleta2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVioleta2.setFocusable(false);
		btnVioleta2.setBackground(Color.decode(corVioleta2));
		btnVioleta2.setBounds(190, 72, 20, 20);
		pnColorPicker.add(btnVioleta2);
		
		btnRosa2 = new JButton("");
		btnRosa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corRosa2;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnRosa2.setForeground(Color.WHITE);
		btnRosa2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRosa2.setFocusable(false);
		btnRosa2.setBackground(Color.decode(corRosa2));
		btnRosa2.setBounds(220, 72, 20, 20);
		pnColorPicker.add(btnRosa2);
		
		btnVermelho3 = new JButton("");
		btnVermelho3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVermelho3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVermelho3.setForeground(Color.WHITE);
		btnVermelho3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVermelho3.setFocusable(false);
		btnVermelho3.setBackground(Color.decode(corVermelho3));
		btnVermelho3.setBounds(10, 103, 20, 20);
		pnColorPicker.add(btnVermelho3);
		
		btnLaranja3 = new JButton("");
		btnLaranja3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corLaranja3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnLaranja3.setForeground(Color.WHITE);
		btnLaranja3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLaranja3.setFocusable(false);
		btnLaranja3.setBackground(Color.decode(corLaranja3));
		btnLaranja3.setBounds(40, 103, 20, 20);
		pnColorPicker.add(btnLaranja3);
		
		btnAmarelo3 = new JButton("");
		btnAmarelo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAmarelo3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAmarelo3.setForeground(Color.WHITE);
		btnAmarelo3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAmarelo3.setFocusable(false);
		btnAmarelo3.setBackground(Color.decode(corAmarelo3));
		btnAmarelo3.setBounds(70, 103, 20, 20);
		pnColorPicker.add(btnAmarelo3);
		
		btnVerde3 = new JButton("");
		btnVerde3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVerde3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVerde3.setForeground(Color.WHITE);
		btnVerde3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerde3.setFocusable(false);
		btnVerde3.setBackground(Color.decode(corVerde3));
		btnVerde3.setBounds(100, 103, 20, 20);
		pnColorPicker.add(btnVerde3);
		
		btnCiano3 = new JButton("");
		btnCiano3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCiano3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCiano3.setForeground(Color.WHITE);
		btnCiano3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCiano3.setFocusable(false);
		btnCiano3.setBackground(Color.decode(corCiano3));
		btnCiano3.setBounds(130, 103, 20, 20);
		pnColorPicker.add(btnCiano3);
		
		btnAzul3 = new JButton("");
		btnAzul3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAzul3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAzul3.setForeground(Color.WHITE);
		btnAzul3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAzul3.setFocusable(false);
		btnAzul3.setBackground(Color.decode(corAzul3));
		btnAzul3.setBounds(160, 103, 20, 20);
		pnColorPicker.add(btnAzul3);
		
		btnVioleta3 = new JButton("");
		btnVioleta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVioleta3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVioleta3.setForeground(Color.WHITE);
		btnVioleta3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVioleta3.setFocusable(false);
		btnVioleta3.setBackground(Color.decode(corVioleta3));
		btnVioleta3.setBounds(190, 103, 20, 20);
		pnColorPicker.add(btnVioleta3);
		
		btnRosa3 = new JButton("");
		btnRosa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corRosa3;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnRosa3.setForeground(Color.WHITE);
		btnRosa3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRosa3.setFocusable(false);
		btnRosa3.setBackground(Color.decode(corRosa3));
		btnRosa3.setBounds(220, 103, 20, 20);
		pnColorPicker.add(btnRosa3);
		
		btnVermelho4 = new JButton("");
		btnVermelho4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVermelho4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVermelho4.setForeground(Color.WHITE);
		btnVermelho4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVermelho4.setFocusable(false);
		btnVermelho4.setBackground(Color.decode(corVermelho4));
		btnVermelho4.setBounds(10, 134, 20, 20);
		pnColorPicker.add(btnVermelho4);
		
		btnLaranja4 = new JButton("");
		btnLaranja4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corLaranja4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnLaranja4.setForeground(Color.WHITE);
		btnLaranja4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLaranja4.setFocusable(false);
		btnLaranja4.setBackground(Color.decode(corLaranja4));
		btnLaranja4.setBounds(40, 134, 20, 20);
		pnColorPicker.add(btnLaranja4);
		
		btnAmarelo4 = new JButton("");
		btnAmarelo4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAmarelo4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAmarelo4.setForeground(Color.WHITE);
		btnAmarelo4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAmarelo4.setFocusable(false);
		btnAmarelo4.setBackground(Color.decode(corAmarelo4));
		btnAmarelo4.setBounds(70, 134, 20, 20);
		pnColorPicker.add(btnAmarelo4);
		
		btnVerde4 = new JButton("");
		btnVerde4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVerde4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVerde4.setForeground(Color.WHITE);
		btnVerde4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerde4.setFocusable(false);
		btnVerde4.setBackground(Color.decode(corVerde4));
		btnVerde4.setBounds(100, 134, 20, 20);
		pnColorPicker.add(btnVerde4);
		
		btnCiano4 = new JButton("");
		btnCiano4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corCiano4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnCiano4.setForeground(Color.WHITE);
		btnCiano4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCiano4.setFocusable(false);
		btnCiano4.setBackground(Color.decode(corCiano4));
		btnCiano4.setBounds(130, 134, 20, 20);
		pnColorPicker.add(btnCiano4);
		
		btnAzul4 = new JButton("");
		btnAzul4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corAzul4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnAzul4.setForeground(Color.WHITE);
		btnAzul4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAzul4.setFocusable(false);
		btnAzul4.setBackground(Color.decode(corAzul4));
		btnAzul4.setBounds(160, 134, 20, 20);
		pnColorPicker.add(btnAzul4);
		
		btnVioleta4 = new JButton("");
		btnVioleta4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corVioleta4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnVioleta4.setForeground(Color.WHITE);
		btnVioleta4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVioleta4.setFocusable(false);
		btnVioleta4.setBackground(Color.decode(corVioleta4));
		btnVioleta4.setBounds(190, 134, 20, 20);
		pnColorPicker.add(btnVioleta4);
		
		btnRosa4 = new JButton("");
		btnRosa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				corSelecionada = corRosa4;
				pnColorPicker.setVisible(false);
				pnCor.setBackground(Color.decode(corSelecionada));
			}
		});
		btnRosa4.setForeground(Color.WHITE);
		btnRosa4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRosa4.setFocusable(false);
		btnRosa4.setBackground(Color.decode(corRosa4));
		btnRosa4.setBounds(220, 134, 20, 20);
		pnColorPicker.add(btnRosa4);
		
		pnCalendario.setBounds(262, 11, 250, 122);
		frmCadastroDeProdutos.getContentPane().add(pnCalendario);
		pnCalendario.setLayout(null);
		
		JCalendar calendario = new JCalendar();
		calendario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				Date dataInformada = new Date();
				dataInformada = calendario.getDate();
				
				if (dataInformada.before(dataDeHoje) || dataInformada.getDate() == dataDeHoje.getDate()) { // Testa se a data informada é válida
					String data = formatoBR.format(calendario.getDate());
					ftfDataDeEmissao.setText(data);
				} else {
					JOptionPane.showMessageDialog(null, "A data informada precisa ser igual ou posterior à data de hoje!", "Data Inválida", JOptionPane.ERROR_MESSAGE);
					calendario.setDate(dataDeHoje);
					String data = formatoBR.format(dataDeHoje);
					ftfDataDeEmissao.setText(data);
				}
			}
		});
		calendario.setBounds(0, 0, 250, 122);
		pnCalendario.add(calendario);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		panel.setBounds(10, 39, 512, 199);
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
		btnCalendario.setFocusable(false);
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pnCalendario.isVisible()) {
					pnCalendario.setVisible(false);
				} else {
					if (pnColorPicker.isVisible()) {
						return;
					} else {
						pnCalendario.setVisible(true);
					}
				}
			}
		});
		btnCalendario.setBounds(215, 73, 27, 23);
		panel.add(btnCalendario);
		btnCalendario.setForeground(Color.WHITE);
		btnCalendario.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		pnCor.setBackground(Color.decode(corSelecionada));
		
		btnSelecionarCor = new JButton("...");
		btnSelecionarCor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pnColorPicker.setVisible(false);
			}
		});
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
		btnSelecionarCor.setBackground(new Color(0, 73, 170));
		
		lblCor = new JLabel("Cor:");
		lblCor.setBounds(10, 140, 70, 14);
		panel.add(lblCor);
		lblCor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ftfCodigo = new JFormattedTextField(mascara);
		ftfCodigo.setBounds(331, 74, 171, 20);
		panel.add(ftfCodigo);
		
		lblPreo = new JLabel("Preço:");
		lblPreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPreo.setBounds(267, 138, 54, 14);
		panel.add(lblPreo);
		
		tfPreco = new JTextField();
		tfPreco.setToolTipText("Por unidade");
		tfPreco.setColumns(10);
		tfPreco.setBounds(331, 137, 171, 20);
		panel.add(tfPreco);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerQuantidade.setBounds(92, 168, 113, 20);
		panel.add(spinnerQuantidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(0, 171, 82, 14);
		panel.add(lblQuantidade);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCadastroDeProdutos.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 249, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnVoltar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fornecedor = tfFornecedor.getText().toString();
				String lojaEmitente = comboLojaEmitente.getSelectedItem().toString();
				String dataDeEmissao = ftfDataDeEmissao.getText().toString();
				String codigo = ftfCodigo.getText().toString();
				String descricao = tfDescricao.getText().toString();
				String preco = tfPreco.getText().toString();
				int quantidade = Integer.parseInt(spinnerQuantidade.getValue().toString());
				
				if (fornecedor.isEmpty() || codigo.trim().isEmpty() || descricao.isEmpty()  || preco.isEmpty() || comboLojaEmitente.getItemCount() == 0) {
					JOptionPane.showMessageDialog(null, "Existe um campo vazio!",null, JOptionPane.WARNING_MESSAGE);
				} else {
					Produtos produto = new Produtos();
					produto.setFornecedor(fornecedor);
					produto.setLojaEmitente(lojaEmitente);
					produto.setDataDeEmissao(dataDeEmissao);
					produto.setCodigo(codigo);
					produto.setDescricao(descricao);
					produto.setCorSelecionada(corSelecionada);
					produto.setPreco(preco);
					produto.setQuantidade(quantidade);
					
					CRUDProdutos insert = new CRUDProdutos();
					insert.insertProduto(produto);
					JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
					btnLimpar.doClick();
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnSalvar.setFocusable(false);
		btnSalvar.setBackground(new Color(0, 73, 170));
		btnSalvar.setBounds(433, 249, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataDeHoje = new Date();
				SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
				String data = formatoBR.format(dataDeHoje);
				ftfDataDeEmissao.setText(data);
				
				tfFornecedor.setText(null);
				ftfCodigo.setValue(null);
				tfDescricao.setText(null);
				tfPreco.setText(null);
				spinnerQuantidade.setValue(1);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(334, 249, 89, 23);
		frmCadastroDeProdutos.getContentPane().add(btnLimpar);
		
		btnConsultarProdutos = new JButton("Consultar Produtos");
		btnConsultarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCadastroDeProdutos.dispose();
				ConsultarProdutos.main(null);
			}
		});
		btnConsultarProdutos.setForeground(Color.WHITE);
		btnConsultarProdutos.setFont(new Font("Impact", Font.PLAIN, 13));
		btnConsultarProdutos.setFocusable(false);
		btnConsultarProdutos.setBackground(new Color(0, 73, 170));
		btnConsultarProdutos.setBounds(371, 8, 151, 23);
		frmCadastroDeProdutos.getContentPane().add(btnConsultarProdutos);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(532, 283, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("New label");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 532, 283);
		frmCadastroDeProdutos.getContentPane().add(lblBG);
		
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
