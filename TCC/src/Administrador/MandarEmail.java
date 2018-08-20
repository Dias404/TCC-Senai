package Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import CRUD.CRUDClientes;
import CRUD.CRUDUsuarios;
import Email.Email;
import Telas.TelaPrincipal;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;
import java.awt.Component;

public class MandarEmail {

	private JFrame frmMandarEmail;
	private JComboBox cbEmail;
	private JEditorPane epMsg;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MandarEmail window = new MandarEmail();
					window.frmMandarEmail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MandarEmail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMandarEmail = new JFrame();
		frmMandarEmail.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmMandarEmail.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmMandarEmail.setIconImage(Toolkit.getDefaultToolkit().getImage(MandarEmail.class.getResource("/Img/SIG 16x16.png")));
		frmMandarEmail.setTitle("SIG - Enviar E-mail");
		frmMandarEmail.setBounds(100, 100, 550, 439);
		frmMandarEmail.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMandarEmail.setResizable(false);
		frmMandarEmail.setLocationRelativeTo(null);
		frmMandarEmail.getContentPane().setLayout(null);
		
		JLabel lblMandarEmail = new JLabel("Enviar E-mail");
		lblMandarEmail.setBounds(10, 11, 125, 17);
		lblMandarEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMandarEmail.getContentPane().add(lblMandarEmail);
		
		JButton btnMandar = new JButton("Mandar");
		btnMandar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha = JOptionPane.showInputDialog("Insira a senha de seu e-mail.");
				Email.enviarEmailAdmin(cbEmail, epMsg, senha);
				epMsg.setText(null);
			}
		});
		btnMandar.setBounds(445, 377, 89, 23);
		frmMandarEmail.getContentPane().add(btnMandar);
		btnMandar.setForeground(Color.WHITE);
		btnMandar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnMandar.setFocusable(false);
		btnMandar.setBackground(new Color(0, 73, 170));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.frmPrincipal.setVisible(true);
				frmMandarEmail.dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 377, 89, 23);
		frmMandarEmail.getContentPane().add(btnVoltar);
		
		JPanel pnEmail = new JPanel();
		pnEmail.setOpaque(false);
		pnEmail.setBounds(10, 39, 524, 327);
		frmMandarEmail.getContentPane().add(pnEmail);
		pnEmail.setLayout(null);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPara.setBounds(10, 14, 31, 14);
		pnEmail.add(lblPara);
		
		cbEmail = new JComboBox();
		cbEmail.setBounds(51, 11, 201, 23);
		pnEmail.add(cbEmail);
		
		epMsg = new JEditorPane();
		epMsg.setText("Prezado(a) cliente,");
		epMsg.setFont(new Font("Arial", Font.PLAIN, 12));
		epMsg.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		epMsg.setBounds(51, 45, 463, 271);
		pnEmail.add(epMsg);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(544, 411, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 544, 411);
		frmMandarEmail.getContentPane().add(lblBG);
		
		preencherEmailUsuarios();
	}

	public void preencherEmailUsuarios() {
		CRUDUsuarios select = new CRUDUsuarios();
		select.selectUsuarios();
		try {
			while(select.dadosSelect.next()) {
				cbEmail.addItem(/*select.dadosSelect.getString("nome")+" - "+*/select.dadosSelect.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void preencherEmailClientes() {
		CRUDClientes select = new CRUDClientes();
		select.selectClientesByEmail();
		try {
			while(select.dadosSelect.next()) {
				cbEmail.addItem(/*select.dadosSelect.getString("nome")+" - "+*/select.dadosSelect.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
