package WindowBuilder.Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;

public class Test2 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 window = new Test2();
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
	public Test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 906, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JCheckBox chk1 = new JCheckBox("백두산");
		chk1.setBounds(59, 78, 116, 44);
		chk1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("다녀온 산");
		lblNewLabel.setBounds(56, 24, 157, 35);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		
		JCheckBox chk2 = new JCheckBox("한라산");
		chk2.setBounds(59, 184, 116, 44);
		chk2.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JCheckBox chk3 = new JCheckBox("태백산");
		chk3.setBounds(59, 290, 116, 44);
		chk3.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JCheckBox chk4 = new JCheckBox("소백산");
		chk4.setBounds(59, 396, 116, 44);
		chk4.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JCheckBox chk5 = new JCheckBox("천태산");
		chk5.setBounds(59, 502, 116, 44);
		chk5.setFont(new Font("굴림", Font.PLAIN, 20));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(chk1);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(chk2);
		frame.getContentPane().add(chk3);
		frame.getContentPane().add(chk4);
		frame.getContentPane().add(chk5);
		
		JLabel lblNewLabel_1 = new JLabel("교통수단");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(501, 52, 157, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(417, 108, 228, 438);
		frame.getContentPane().add(panel);
		
		JRadioButton radio1_1 = new JRadioButton("택 시");
		buttonGroup.add(radio1_1);
		radio1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JRadioButton radio1_2 = new JRadioButton("버 스");
		buttonGroup.add(radio1_2);
		radio1_2.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JRadioButton radio1_3 = new JRadioButton("기 차");
		buttonGroup.add(radio1_3);
		radio1_3.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JRadioButton radio1_3_1 = new JRadioButton("자전거");
		buttonGroup.add(radio1_3_1);
		radio1_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JRadioButton radio1_3_1_1 = new JRadioButton("도 보");
		buttonGroup.add(radio1_3_1_1);
		radio1_3_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JRadioButton radio1 = new JRadioButton("자가용");
		buttonGroup.add(radio1);
		radio1.setFont(new Font("굴림", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(radio1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio1_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio1_3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio1_3_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio1_3_1_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(radio1_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(radio1_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(radio1_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(radio1_3_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(radio1_3_1_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(radio1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
	}
}
