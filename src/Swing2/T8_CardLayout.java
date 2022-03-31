package Swing2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class T8_CardLayout extends JFrame {
  JPanel pnTop, pnCenter;
  JButton btnPre, btnNext, btnFirst, btnLast, btnExit;
  JButton btn1, btn2, btn3, btn4;
	
	public T8_CardLayout() {
		super("CardLayout 연습");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		pnTop = new JPanel();
		btnFirst = new JButton("처음");
		btnPre = new JButton("이전");
		btnNext = new JButton("다음");
		btnLast = new JButton("마지막");
		btnExit = new JButton("종료");
		
		pnTop.add(btnFirst);
		pnTop.add(btnPre);
		pnTop.add(btnNext);
		pnTop.add(btnLast);
		pnTop.add(btnExit);
		
		pnCenter = new JPanel();
		CardLayout card = new CardLayout();
		pnCenter.setLayout(card);
		btn1 = new JButton("봄");
		btn1.setBackground(Color.GREEN);
		btn2 = new JButton("여름");
		btn2.setBackground(Color.BLUE);
		btn3 = new JButton("가을");
		btn3.setBackground(Color.RED);
		btn4 = new JButton("겨울");
		btn4.setBackground(Color.GRAY);
		pnCenter.add(btn1);
		pnCenter.add(btn2);
		pnCenter.add(btn3);
		pnCenter.add(btn4);
		
		add(pnTop, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 메소드 작성
		// 봄 버튼클릭 메소드
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "봄을 선택하셨습니다.");
			}
		});
		
		// 여름 버튼클릭 메소드
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "여름을 선택하셨습니다.");
			}
		});
		
		// 가을 버튼클릭 메소드
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "가을을 선택하셨습니다.");
			}
		});
		
		// 겨울 버튼클릭 메소드
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "겨울을 선택하셨습니다.");
			}
		});
		
		// 처음버튼 메소드
		btnFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(pnCenter);
			}
		});
		
		// 이전버튼 메소드
		btnPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(pnCenter);
			}
		});
		
    // 다음버튼 메소드
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(pnCenter);
			}
		});
		
		// 마지막버튼 메소드
		btnLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.last(pnCenter);
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
		new T8_CardLayout();
	}
}
