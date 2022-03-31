package Swing1;

import javax.swing.JFrame;

public class T1 {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();	// 프레임은 컨테이너역할이다.
		
		frame.setSize(400, 300);	// 프레임의 크기를 지정한다.
		
		frame.setTitle("스윙 연습1");
		
		frame.setVisible(true); 	// 프레임을 화면에 출력시켜준다.
	}
}
