package Swing2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T5_CardLayout extends JFrame {
	JButton btn1, btn2, btn3, btn4;

	public T5_CardLayout() {
		super("카드 레이아웃");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//setLayout(new CardLayout());
		CardLayout card = new CardLayout();
		setLayout(card);
		
		btn1 = new JButton("봄");
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		setVisible(true);
		
		// 메소드 영역
		// 봄 버튼 처리
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		// 여름 버튼 처리
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		// 가을 버튼 처리
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		// 겨울 버튼 처리
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T5_CardLayout();
	}
}
