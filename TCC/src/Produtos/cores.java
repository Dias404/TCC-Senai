package Produtos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cores {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cores window = new cores();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 276, 215);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 250, 165);
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setFocusable(false);
		button.setBackground(Color.BLACK);
		button.setBounds(10, 10, 20, 20);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setFocusable(false);
		button_1.setBackground(Color.decode("#333333"));
		button_1.setBounds(40, 10, 20, 20);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setFocusable(false);
		button_2.setBackground(Color.decode("#666666"));
		button_2.setBounds(70, 10, 20, 20);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setFocusable(false);
		button_3.setBackground(Color.decode("#999999"));
		button_3.setBounds(100, 10, 20, 20);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setFocusable(false);
		button_4.setBackground(Color.decode("#cccccc"));
		button_4.setBounds(130, 10, 20, 20);
		panel.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setFocusable(false);
		button_5.setBackground(Color.decode("#dddddd"));
		button_5.setBounds(160, 10, 20, 20);
		panel.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setFocusable(false);
		button_6.setBackground(Color.decode("#eeeeee"));
		button_6.setBounds(190, 10, 20, 20);
		panel.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7.setFocusable(false);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(220, 10, 20, 20);
		panel.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_8.setFocusable(false);
		button_8.setBackground(Color.decode("#ca0808"));
		button_8.setBounds(10, 41, 20, 20);
		panel.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_9.setFocusable(false);
		button_9.setBackground(Color.decode("#fd9828"));
		button_9.setBounds(40, 41, 20, 20);
		panel.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_10.setFocusable(false);
		button_10.setBackground(Color.decode("#fffd38"));
		button_10.setBounds(70, 41, 20, 20);
		panel.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setForeground(Color.WHITE);
		button_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_11.setFocusable(false);
		button_11.setBackground(Color.decode("#159c1f"));
		button_11.setBounds(100, 41, 20, 20);
		panel.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_12.setFocusable(false);
		button_12.setBackground(Color.decode("#2dfffe"));
		button_12.setBounds(130, 41, 20, 20);
		panel.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setForeground(Color.WHITE);
		button_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_13.setFocusable(false);
		button_13.setBackground(Color.decode("#307be1"));
		button_13.setBounds(160, 41, 20, 20);
		panel.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setForeground(Color.WHITE);
		button_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_14.setFocusable(false);
		button_14.setBackground(Color.decode("#9825fb"));
		button_14.setBounds(190, 41, 20, 20);
		panel.add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setForeground(Color.WHITE);
		button_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_15.setFocusable(false);
		button_15.setBackground(Color.decode("#fc28fc"));
		button_15.setBounds(220, 41, 20, 20);
		panel.add(button_15);
		
		JButton button_16 = new JButton("");
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_16.setFocusable(false);
		button_16.setBackground(Color.decode("#de6868"));
		button_16.setBounds(10, 72, 20, 20);
		panel.add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_17.setFocusable(false);
		button_17.setBackground(Color.decode("#f4b171"));
		button_17.setBounds(40, 72, 20, 20);
		panel.add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setForeground(Color.WHITE);
		button_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_18.setFocusable(false);
		button_18.setBackground(Color.decode("#fed86f"));
		button_18.setBounds(70, 72, 20, 20);
		panel.add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setForeground(Color.WHITE);
		button_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_19.setFocusable(false);
		button_19.setBackground(Color.decode("#94c380"));
		button_19.setBounds(100, 72, 20, 20);
		panel.add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setForeground(Color.WHITE);
		button_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_20.setFocusable(false);
		button_20.setBackground(Color.decode("#78a5ae"));
		button_20.setBounds(130, 72, 20, 20);
		panel.add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setForeground(Color.WHITE);
		button_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_21.setFocusable(false);
		button_21.setBackground(Color.decode("#71a9da"));
		button_21.setBounds(160, 72, 20, 20);
		panel.add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setForeground(Color.WHITE);
		button_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_22.setFocusable(false);
		button_22.setBackground(Color.decode("#8e7ec1"));
		button_22.setBounds(190, 72, 20, 20);
		panel.add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setForeground(Color.WHITE);
		button_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_23.setFocusable(false);
		button_23.setBackground(Color.decode("#c17ca0"));
		button_23.setBounds(220, 72, 20, 20);
		panel.add(button_23);
		
		JButton button_24 = new JButton("");
		button_24.setForeground(Color.WHITE);
		button_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_24.setFocusable(false);
		button_24.setBackground(Color.decode("#cd1f1f"));
		button_24.setBounds(10, 103, 20, 20);
		panel.add(button_24);
		
		JButton button_25 = new JButton("");
		button_25.setForeground(Color.WHITE);
		button_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_25.setFocusable(false);
		button_25.setBackground(Color.decode("#e49042"));
		button_25.setBounds(40, 103, 20, 20);
		panel.add(button_25);
		
		JButton button_26 = new JButton("");
		button_26.setForeground(Color.WHITE);
		button_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_26.setFocusable(false);
		button_26.setBackground(Color.decode("#f0c142"));
		button_26.setBounds(70, 103, 20, 20);
		panel.add(button_26);
		
		JButton button_27 = new JButton("");
		button_27.setForeground(Color.WHITE);
		button_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_27.setFocusable(false);
		button_27.setBackground(Color.decode("#6ca754"));
		button_27.setBounds(100, 103, 20, 20);
		panel.add(button_27);
		
		JButton button_28 = new JButton("");
		button_28.setForeground(Color.WHITE);
		button_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_28.setFocusable(false);
		button_28.setBackground(Color.decode("#47818d"));
		button_28.setBounds(130, 103, 20, 20);
		panel.add(button_28);
		
		JButton button_29 = new JButton("");
		button_29.setForeground(Color.WHITE);
		button_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_29.setFocusable(false);
		button_29.setBackground(Color.decode("#5a7fa8"));
		button_29.setBounds(160, 103, 20, 20);
		panel.add(button_29);
		
		JButton button_30 = new JButton("");
		button_30.setForeground(Color.WHITE);
		button_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_30.setFocusable(false);
		button_30.setBackground(Color.decode("#6751a5"));
		button_30.setBounds(190, 103, 20, 20);
		panel.add(button_30);
		
		JButton button_31 = new JButton("");
		button_31.setForeground(Color.WHITE);
		button_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_31.setFocusable(false);
		button_31.setBackground(Color.decode("#a44f79"));
		button_31.setBounds(220, 103, 20, 20);
		panel.add(button_31);
		
		JButton button_32 = new JButton("");
		button_32.setForeground(Color.WHITE);
		button_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_32.setFocusable(false);
		button_32.setBackground(Color.decode("#650202"));
		button_32.setBounds(10, 134, 20, 20);
		panel.add(button_32);
		
		JButton button_33 = new JButton("");
		button_33.setForeground(Color.WHITE);
		button_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_33.setFocusable(false);
		button_33.setBackground(Color.decode("#773f0e"));
		button_33.setBounds(40, 134, 20, 20);
		panel.add(button_33);
		
		JButton button_34 = new JButton("");
		button_34.setForeground(Color.WHITE);
		button_34.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_34.setFocusable(false);
		button_34.setBackground(Color.decode("#7e5f11"));
		button_34.setBounds(70, 134, 20, 20);
		panel.add(button_34);
		
		JButton button_35 = new JButton("");
		button_35.setForeground(Color.WHITE);
		button_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_35.setFocusable(false);
		button_35.setBackground(Color.decode("#284d17"));
		button_35.setBounds(100, 134, 20, 20);
		panel.add(button_35);
		
		JButton button_36 = new JButton("");
		button_36.setForeground(Color.WHITE);
		button_36.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_36.setFocusable(false);
		button_36.setBackground(Color.decode("#0e343c"));
		button_36.setBounds(130, 134, 20, 20);
		panel.add(button_36);
		
		JButton button_37 = new JButton("");
		button_37.setForeground(Color.WHITE);
		button_37.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_37.setFocusable(false);
		button_37.setBackground(Color.decode("#0a3862"));
		button_37.setBounds(160, 134, 20, 20);
		panel.add(button_37);
		
		JButton button_38 = new JButton("");
		button_38.setForeground(Color.WHITE);
		button_38.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_38.setFocusable(false);
		button_38.setBackground(Color.decode("#20144c"));
		button_38.setBounds(190, 134, 20, 20);
		panel.add(button_38);
		
		JButton button_39 = new JButton("");
		button_39.setForeground(Color.WHITE);
		button_39.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_39.setFocusable(false);
		button_39.setBackground(Color.decode("#4b1230"));
		button_39.setBounds(220, 134, 20, 20);
		panel.add(button_39);
	}

}
