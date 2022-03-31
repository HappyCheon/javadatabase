package Swing1;

import javax.swing.JFrame;

public class T5_WindowClose extends JFrame {

	public T5_WindowClose() {
		super("스윙 - 화면 종료");
		setSize(300, 250);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 종료버튼(x)사용하기
	}
	
	public static void main(String[] args) {
		new T5_WindowClose();
	}
}
