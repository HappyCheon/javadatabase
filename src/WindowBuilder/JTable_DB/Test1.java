package WindowBuilder.JTable_DB;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Test1 extends JFrame {
	JPanel pnTop, pn1, pn2, pn3;
	JLabel lblCnt;
	int img1Cnt = 0, img2Cnt = 0, img3Cnt = 0;

	public Test1() {
		super("컴포넌트 연습");
		setSize(600, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		pnTop = new JPanel();
		pnTop.setBounds(0, 0, 584, 50);
		getContentPane().add(pnTop);
		pnTop.setLayout(null);
		
		JButton btnTotal = new JButton("모두보기");
		btnTotal.setBounds(12, 10, 86, 38);
		pnTop.add(btnTotal);
		
		JButton btn1 = new JButton("1보기");
		btn1.setBounds(96, 10, 86, 38);
		pnTop.add(btn1);
		
		JButton btn2 = new JButton("2보기");
		btn2.setBounds(180, 10, 86, 38);
		pnTop.add(btn2);
		
		JButton btn3 = new JButton("3보기");
		btn3.setBounds(264, 10, 86, 38);
		pnTop.add(btn3);
		
		JButton btnClose = new JButton("모두닫기");
		btnClose.setBounds(432, 10, 86, 38);
		pnTop.add(btnClose);
		
		JButton btnRandom = new JButton("랜덤보기");
		btnRandom.setBounds(348, 10, 86, 38);
		pnTop.add(btnRandom);
		
		JButton btnNewButton = new JButton("종료");
		btnNewButton.setBounds(516, 10, 60, 38);
		pnTop.add(btnNewButton);
		
		pn1 = new JPanel();
		pn1.setBounds(10, 52, 183, 344);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lbl1 = new JLabel("New label");
		lbl1.setIcon(new ImageIcon("D:\\JavaGreen\\html5_css3_javascript\\images\\4.jpg"));
		lbl1.setBounds(12, 10, 159, 324);
		pn1.add(lbl1);
		pn1.setVisible(false);
		
		pn2 = new JPanel();
		pn2.setBounds(201, 52, 183, 344);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lbl2 = new JLabel("New label");
		//lbl2.setIcon(new ImageIcon("D:\\JavaGreen\\html5_css3_javascript\\images\\2.jpg"));
		URL imgUrl = this.getClass().getClassLoader().getResource("2.jpg");
		lbl2.setIcon(new ImageIcon(imgUrl));
		
		lbl2.setBounds(12, 10, 159, 324);
		pn2.add(lbl2);
		pn2.setVisible(false);
		
		pn3 = new JPanel();
		pn3.setBounds(392, 52, 183, 344);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lbl3 = new JLabel("New label");
		lbl3.setIcon(new ImageIcon("D:\\JavaGreen\\html5_css3_javascript\\images\\3.jpg"));
		lbl3.setBounds(12, 10, 159, 324);
		pn3.add(lbl3);
		
		lblCnt = new JLabel("1: 0 , 2: 0 , 3: 0");
		lblCnt.setForeground(Color.RED);
		lblCnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnt.setBounds(20, 406, 552, 25);
		getContentPane().add(lblCnt);
		pn3.setVisible(false);
		
		setVisible(true);
		
		/* ------------------------메소드 영역-------------------------------- */
		
		// 모두 보기
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDisplay();
				img1Cnt++; img2Cnt++; img3Cnt++;
				dispCnt();
			}
		});
		
		// 모두 닫기
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn1.setVisible(false);
				pn2.setVisible(false);
				pn3.setVisible(false);
				dispCnt();
			}
		});
		
		// 1보기
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn1.setVisible(true);
				pn2.setVisible(false);
				pn3.setVisible(false);
				img1Cnt++;
				dispCnt();
			}
		});
		
		// 2보기
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn1.setVisible(false);
				pn2.setVisible(true);
				pn3.setVisible(false);
				img2Cnt++;
				dispCnt();
			}
		});
		
		// 3보기
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn1.setVisible(false);
				pn2.setVisible(false);
				pn3.setVisible(true);
				img3Cnt++;
				dispCnt();
			}
		});
		
		// 랜덤보기
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int randSu = (int) (Math.random()*3) + 1;
				if(randSu == 1) {
					pn1.setVisible(true);
					pn2.setVisible(false);
					pn3.setVisible(false);
					img1Cnt++;
				}
				else if(randSu == 2) {
					pn1.setVisible(false);
					pn2.setVisible(true);
					pn3.setVisible(false);
					img2Cnt++;
				}
				else {
					pn1.setVisible(false);
					pn2.setVisible(false);
					pn3.setVisible(true);
					img3Cnt++;
				}
				dispCnt();
			}
		});
		
		// 종료
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// 모든자료 보여주기
	protected void allDisplay() {
			pn1.setVisible(true);
			pn2.setVisible(true);
			pn3.setVisible(true);
	}

	// 시간 지연하기(사용하지 않음...)
	protected void delay(int delay) {
		try {
//			for(int i=0; i<delay; i++) {
//				Thread.sleep(500);
//			}
			for (int i = 1; i <= delay; i++) {
//				 TimeUnit.SECONDS.sleep(1);
				 TimeUnit.MILLISECONDS.sleep(300);
			}
		} catch (InterruptedException e) {}
	}
	
	// 그림 보여준 횟수 누적하기
	protected void dispCnt() {
		lblCnt.setText("1: "+img1Cnt+" , 2: "+img2Cnt+" , 3: "+img3Cnt);
	}

	public static void main(String[] args) {
		new Test1();
	}
}
