package WindowBuilder.Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test1 {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 window = new Test1();
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
	public Test1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("굴림", Font.PLAIN, 20));
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("회 원 가 입");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 32));
		lblNewLabel_1.setBounds(159, 31, 503, 69);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("입 력");
		btnNewButton.setBackground(UIManager.getColor("Table.selectionBackground"));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton.setBounds(35, 344, 156, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("수 정");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton_1.setBounds(226, 344, 156, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("조회");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton_2.setBounds(417, 344, 156, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnExit = new JButton("종 료");
		
		btnExit.setFont(new Font("굴림", Font.PLAIN, 22));
		btnExit.setBounds(608, 344, 156, 35);
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 120, 619, 178);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 20));
		txtName.setBounds(174, 34, 244, 35);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("성  명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 34, 128, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("나  이");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(12, 106, 128, 35);
		panel.add(lblNewLabel_2);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(174, 106, 244, 35);
		panel.add(txtAge);
		frame.setBounds(100, 100, 818, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* ======================================== */
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
