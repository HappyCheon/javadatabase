package Swing1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T3_Listener extends JFrame implements WindowListener {
	
	public T3_Listener() {
		super("스윙연습3");
		setBounds(200, 250, 300, 350);
		
		setVisible(true);
		
		// 윈도우 감시자(Listener)를 호출....(현재 윈도우를 감시)
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T3_Listener();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
