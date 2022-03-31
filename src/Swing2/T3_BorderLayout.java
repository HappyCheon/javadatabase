package Swing2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class T3_BorderLayout extends JFrame {
	JButton btn1, btn2, btn3, btn4, btnExit, btnOk;
	JPanel pn1;

	public T3_BorderLayout() {
		super("Border레이아웃");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		btn1 = new JButton("북쪽");
		btn2 = new JButton("남쪽");
		btn3 = new JButton("서쪽");
		// btn4 = new JButton("동쪽");
		btnOk = new JButton("확인");
		btnExit = new JButton("종료");
		
		pn1 = new JPanel();
		pn1.add(btnOk);
		pn1.add(btnExit);
		
		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
		// add(btn4, BorderLayout.EAST);
		add(pn1, BorderLayout.CENTER);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 확인버튼
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "확인버튼을 누르셨습니다.");
			}
		});
		
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T3_BorderLayout();
	}
}
