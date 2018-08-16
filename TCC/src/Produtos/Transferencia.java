package Produtos;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Administrador.CadastrarUsuario;
import Telas.TelaPrincipal;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Transferencia {

	private JFrame frmTransferencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferencia window = new Transferencia();
					window.frmTransferencia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transferencia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTransferencia = new JFrame();
		frmTransferencia.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmTransferencia.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		frmTransferencia.setTitle("SIG - Transferência de Produtos");
		frmTransferencia.setIconImage(Toolkit.getDefaultToolkit().getImage(Transferencia.class.getResource("/Img/SIG 16x16.png")));
		frmTransferencia.setResizable(false);
		frmTransferencia.setBounds(100, 100, 450, 243);
		frmTransferencia.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTransferencia.getContentPane().setLayout(null);
		
		int frmWidth = frmTransferencia.getWidth();
		int frmHeight = frmTransferencia.getHeight();
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundSecundario.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(frmWidth, frmHeight, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblTransferencia = new JLabel("Transferência");
		lblTransferencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransferencia.setBounds(10, 11, 157, 17);
		frmTransferencia.getContentPane().add(lblTransferencia);
		
		JPanel pnTransferecia = new JPanel();
		pnTransferecia.setOpaque(false);
		pnTransferecia.setBounds(10, 39, 424, 131);
		frmTransferencia.getContentPane().add(pnTransferecia);
		pnTransferecia.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProduto.setBounds(10, 11, 75, 14);
		pnTransferecia.add(lblProduto);
		
		JComboBox cbProduto = new JComboBox();
		cbProduto.setBounds(95, 9, 319, 20);
		pnTransferecia.add(cbProduto);
		
		JLabel label = new JLabel("Quantidade:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 41, 75, 14);
		pnTransferecia.add(label);
		
		JSpinner spnQtd = new JSpinner();
		spnQtd.setBounds(95, 40, 100, 20);
		pnTransferecia.add(spnQtd);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDe.setBounds(10, 73, 75, 14);
		pnTransferecia.add(lblDe);
		
		JComboBox cbDe = new JComboBox();
		cbDe.setBounds(95, 71, 319, 20);
		pnTransferecia.add(cbDe);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPara.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPara.setBounds(10, 105, 75, 14);
		pnTransferecia.add(lblPara);
		
		JComboBox cbPara = new JComboBox();
		cbPara.setBounds(95, 102, 319, 20);
		pnTransferecia.add(cbPara);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmTransferencia.dispose();
				TelaPrincipal.frmPrincipal.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnVoltar.setFocusable(false);
		btnVoltar.setBackground(new Color(0, 73, 170));
		btnVoltar.setBounds(10, 181, 89, 23);
		frmTransferencia.getContentPane().add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbProduto.setSelectedIndex(0);
				spnQtd.setValue(0);
				cbDe.setSelectedIndex(0);
				cbPara.setSelectedIndex(0);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Impact", Font.PLAIN, 13));
		btnLimpar.setFocusable(false);
		btnLimpar.setBackground(new Color(0, 73, 170));
		btnLimpar.setBounds(246, 181, 89, 23);
		frmTransferencia.getContentPane().add(btnLimpar);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransferir.setForeground(Color.WHITE);
		btnTransferir.setFont(new Font("Impact", Font.PLAIN, 13));
		btnTransferir.setFocusable(false);
		btnTransferir.setBackground(new Color(0, 73, 170));
		btnTransferir.setBounds(345, 181, 89, 23);
		frmTransferencia.getContentPane().add(btnTransferir);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, frmWidth, frmHeight);
		lblBG.setIcon(BG);
		frmTransferencia.getContentPane().add(lblBG);
	}
}
