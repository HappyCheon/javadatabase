package WindowBuilder.Test2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DBTestInput extends JFrame {

	public DBTestInput() {
		super("컴포넌트 연습");
		setSize(600, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 441);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		setVisible(true);
		
		/* 아래로 메소드 처리 */
	}
	
	public static void main(String[] args) {
		new DBTestInput();
	}
}
