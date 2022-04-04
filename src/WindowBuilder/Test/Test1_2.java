package WindowBuilder.Test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Test1_2 extends JFrame {
	private JTextField txtName;
	private JTextField txtAge;

	public Test1_2() {
		super("컴포넌트 연습");
		setSize(818, 505);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblNewLabel_1 = new JLabel("회 원 가 입");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 32));
		lblNewLabel_1.setBounds(159, 31, 503, 69);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("입 력");
		btnNewButton.setBackground(UIManager.getColor("Table.selectionBackground"));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton.setBounds(35, 344, 156, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("수 정");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton_1.setBounds(226, 344, 156, 35);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("조회");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton_2.setBounds(417, 344, 156, 35);
		getContentPane().add(btnNewButton_2);
		
		JButton btnExit = new JButton("종 료");
		
		btnExit.setFont(new Font("굴림", Font.PLAIN, 22));
		btnExit.setBounds(608, 344, 156, 35);
		getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 120, 619, 178);
		getContentPane().add(panel);
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
		setBounds(100, 100, 818, 505);
		
		
		setVisible(true);
		
		/* ======================================== */
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Test1_2();
	}
}
