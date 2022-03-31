package Swing1;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T2 extends JFrame {
	
	public T2() {
		//this.setSize(400, 300);
		setBounds(300, 400, 350, 300);	// 좌표와 크기 지정(x,y,w,h)
		setTitle("스윙연습2");
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new T2();
	}
}
