package Swing1;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class T7_Component extends JFrame{

	public T7_Component() {
		/*
		super("컴포넌트 연습");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		*/
		
		super("컴포넌트 연습");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// 레이블 출력(JLabel)
		JLabel lbl1 = new JLabel();
	  lbl1.setText("회원가입폼");
	  this.add(lbl1);
	  
	  JLabel lbl2 = new JLabel("안녕하세요.");
	  add(lbl2);
	  
	  // 버튼(JButton)
	  JButton btn1 = new JButton("확인");
	  add(btn1);
	  
	  // 체크박스(JCheckBox)
	  add(new JCheckBox("남자"));
	  
	  // 라디어버튼(JRadioButton)
	  add(new JRadioButton("여자"));
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T7_Component();
	}
}
