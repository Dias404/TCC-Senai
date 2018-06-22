package CadastrarLugar;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Administrador.CadastrarLoja;
import Administrador.CadastrarUsuario;
import Clientes.CadastroDeClientes;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CadastrarBairros {

	private JFrame frmCadBairro;
	private JLabel lblBG;
	
	static String janela;
	public static boolean x = false;
	private JTextField tfNome;

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
		frmCadBairro.setTitle("Cadastrar Cidades");
		frmCadBairro.setBounds(100, 100, 284, 130);
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
		
		lblBG = new JLabel("");
		lblBG.setBounds(0, 0, frameWidth, frameHeight);
		lblBG.setIcon(BG);
		frmCadBairro.getContentPane().add(lblBG);
	}
}
