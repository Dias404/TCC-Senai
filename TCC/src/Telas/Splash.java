package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Administrador.CadastrarUsuario;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Splash implements Runnable{

	private JFrame frmSistemaIntegradoDe;
	private JProgressBar barraDeCarregamento;
	
	private int ponteiroBarra = 0;
	private Thread tarefa;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new Splash();
					window.frmSistemaIntegradoDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaIntegradoDe = new JFrame();
		frmSistemaIntegradoDe.setUndecorated(true);
		frmSistemaIntegradoDe.setIconImage(Toolkit.getDefaultToolkit().getImage(Splash.class.getResource("/Img/SIG 16x16.png")));
		frmSistemaIntegradoDe.setBounds(100, 100, 535, 289);
		frmSistemaIntegradoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaIntegradoDe.getContentPane().setLayout(null);
		frmSistemaIntegradoDe.setResizable(false);
		frmSistemaIntegradoDe.setLocationRelativeTo(null);
		
		JLabel lblVol = new JLabel("Versão 1.0");
		lblVol.setVerticalAlignment(SwingConstants.TOP);
		lblVol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVol.setForeground(new Color(0, 73, 170));
		lblVol.setFont(new Font("Impact", Font.PLAIN, 12));
		lblVol.setBounds(110, 214, 315, 14);
		frmSistemaIntegradoDe.getContentPane().add(lblVol);
		
		JLabel lblNewLabel = new JLabel("© 2018 Senai. All rights reserved.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 264, 515, 14);
		frmSistemaIntegradoDe.getContentPane().add(lblNewLabel);
		
		barraDeCarregamento = new JProgressBar();
		barraDeCarregamento.setValue(ponteiroBarra);
		barraDeCarregamento.setForeground(new Color(0, 73, 170));
		barraDeCarregamento.setBounds(10, 239, 515, 14);
		frmSistemaIntegradoDe.getContentPane().add(barraDeCarregamento);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Splash.class.getResource("/SIG 129.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 40, 515, 129);
		frmSistemaIntegradoDe.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("SISTEMA INTEGRADO DE GERENCIAMENTO");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 73, 170));
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setBounds(10, 188, 515, 26);
		frmSistemaIntegradoDe.getContentPane().add(label);
		
		ImageIcon BG = new ImageIcon(CadastrarUsuario.class.getResource("/backgroundPrincipal.jpg"));
		Image BG2 = BG.getImage().getScaledInstance(535, 289, Image.SCALE_DEFAULT);
		BG = new ImageIcon(BG2);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(BG);
		lblBG.setBounds(0, 0, 535, 289);
		frmSistemaIntegradoDe.getContentPane().add(lblBG);
		
		tarefa = new Thread(Splash.this);
		tarefa.start();
	}

	public void run() {
		try {
			for(int x=0;x<=104;x=x+4) {
				Thread.sleep(300);
				barraDeCarregamento.setValue(x);
			}
			frmSistemaIntegradoDe.dispose();
			Login.main(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
