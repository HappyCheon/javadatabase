package WindowBuilder.Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Test3 extends JFrame {
	private JTextField txtMid;
	private JPasswordField txtPwd;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	private JTable tblContent;

	Test3DAO dao = new Test3DAO();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Test3() {
		super("컴포넌트 연습");
		setSize(600, 589);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.LIGHT_GRAY);
		pn1.setBounds(0, 47, 584, 48);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 10, 73, 28);
		pn1.add(lblNewLabel);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.PLAIN, 16));
		txtMid.setBounds(84, 10, 116, 28);
		pn1.add(txtMid);
		txtMid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(212, 10, 73, 28);
		pn1.add(lblNewLabel_1);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("굴림", Font.PLAIN, 16));
		txtPwd.setBounds(293, 10, 129, 28);
		pn1.add(txtPwd);
		
		JButton btnMidPwd = new JButton("아이디출력");
		btnMidPwd.setFont(new Font("굴림", Font.PLAIN, 16));
		btnMidPwd.setBounds(437, 10, 135, 28);
		pn1.add(btnMidPwd);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 0, 584, 48);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblDisplay = new JLabel("출  력  창");
		lblDisplay.setForeground(Color.RED);
		lblDisplay.setBackground(Color.LIGHT_GRAY);
		lblDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplay.setFont(new Font("굴림", Font.PLAIN, 16));
		lblDisplay.setBounds(12, 10, 463, 28);
		pn2.add(lblDisplay);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(491, 14, 81, 24);
		pn2.add(btnExit);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 96, 584, 48);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JRadioButton rdMale = new JRadioButton("남 자");
		btnGroupGender.add(rdMale);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 16));
		rdMale.setBounds(129, 6, 74, 36);
		pn3.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여 자");
		rdFemale.setSelected(true);
		btnGroupGender.add(rdFemale);
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 16));
		rdFemale.setBounds(225, 6, 74, 36);
		pn3.add(rdFemale);
		
		JButton btnGender = new JButton("성별출력");
		btnGender.setFont(new Font("굴림", Font.PLAIN, 16));
		btnGender.setBounds(342, 10, 123, 32);
		pn3.add(btnGender);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 145, 318, 216);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학생", "회사원", "군인", "의사", "변호사", "기타"}));
		comboJob.setFont(new Font("굴림", Font.PLAIN, 16));
		comboJob.setBounds(12, 24, 136, 23);
		panel.add(comboJob);
		
		JButton btnJob = new JButton("직업출력");
		btnJob.setFont(new Font("굴림", Font.PLAIN, 16));
		btnJob.setBounds(12, 57, 136, 29);
		panel.add(btnJob);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 97, 136, 109);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "회사원", "공무원", "가사", "변호사", "의사", "군인", "자영업", "운수업", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(172, 79, 136, 127);
		panel.add(scrollPane_1);
		
		JTextArea txtaContent = new JTextArea();
		scrollPane_1.setViewportView(txtaContent);
		
		JButton btnJob2 = new JButton("직업출력2");
		btnJob2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnJob2.setBounds(172, 10, 136, 29);
		panel.add(btnJob2);
		
		JButton btnJob2_1 = new JButton("직업출력3");
		btnJob2_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnJob2_1.setBounds(172, 40, 136, 29);
		panel.add(btnJob2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(318, 145, 266, 216);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chkCard1 = new JCheckBox("국민카드");
		chkCard1.setFont(new Font("굴림", Font.PLAIN, 16));
		chkCard1.setBounds(19, 58, 105, 33);
		panel_1.add(chkCard1);
		
		JCheckBox chkCard2 = new JCheckBox("농협카드");
		chkCard2.setFont(new Font("굴림", Font.PLAIN, 16));
		chkCard2.setBounds(139, 58, 105, 33);
		panel_1.add(chkCard2);
		
		JCheckBox chkCard3 = new JCheckBox("삼성카드");
		chkCard3.setFont(new Font("굴림", Font.PLAIN, 16));
		chkCard3.setBounds(19, 93, 105, 33);
		panel_1.add(chkCard3);
		
		JCheckBox chkCard5 = new JCheckBox("신한카드");
		chkCard5.setFont(new Font("굴림", Font.PLAIN, 16));
		chkCard5.setBounds(19, 128, 105, 33);
		panel_1.add(chkCard5);
		
		JCheckBox chkCard4 = new JCheckBox("LG카드");
		chkCard4.setFont(new Font("굴림", Font.PLAIN, 16));
		chkCard4.setBounds(139, 93, 105, 33);
		panel_1.add(chkCard4);
		
		JCheckBox chkCard6 = new JCheckBox("체크카드");
		chkCard6.setFont(new Font("굴림", Font.PLAIN, 16));
		chkCard6.setBounds(139, 128, 105, 33);
		panel_1.add(chkCard6);
		
		JButton btnCard = new JButton("선택카드출력");
		btnCard.setFont(new Font("굴림", Font.PLAIN, 16));
		btnCard.setBounds(19, 173, 212, 33);
		panel_1.add(btnCard);
		
		// 성별을 Vector에 담아서 comboGender콤보상사에 뿌린다.(남/여)
		ArrayList<String> vDataGender = dao.getGender();
		
		JComboBox comboGender = new JComboBox();
		comboGender.setFont(new Font("굴림", Font.PLAIN, 16));
		comboGender.setBounds(19, 10, 212, 33);
		for(int i=0; i<vDataGender.size(); i++) {
			comboGender.addItem(vDataGender.get(i));
		}
		panel_1.add(comboGender);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 359, 584, 191);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		/* JTable을 디자인탭에 올리는 순서?
		  1. Panel을 만들고, Absolute Layout를 패널에 찍어준다.
		  2. JScrollPane을 패널의 크기에 맞게 그린다.
		  3. JTable을 JScrollPane의 ViewPort에 클릭해 준다.
		  4. 데이터베이스에 연결을 위해 DefaultTableModel객체를 준비해준다.
		     DefaultTableModel객체는 Vector형식의 자료를 사용한다. 따라서 '제목'과 '내용물'을 모두 벡터로 준비시켜준다.
		  5. 준비된 Vector형식의 자료를 DefaultTableModel객체에 올린다.
		  6. DefaultTableModel객체를 JTable에 올려준다.
		  7. JTable을 JScrollPane에 올려준다.
		  8. JScrollPane을 '패널'에 올려준다.
		*/
		
		// 타이틀을 벡터로 처리해둔다.
		Vector title = new Vector();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 데이터로 벡터로 준비해둔다.
		Test3DAO dao = new Test3DAO();
		Vector vData = dao.getList();
		//System.out.println("vData : " + vData);
		
		// DefaultTableModel에 준비한 벡터 자료를 담는다.
		DefaultTableModel defaultTableModel = new DefaultTableModel(vData, title);  // (데이터,타이틀)
		
		// DefaultTableModel를 JTable에 올린다.
		tblContent = new JTable(defaultTableModel);
		
		// 아래로 JTable의 열크기 조절하기
		//tblContent.getColumnModel().getColumn(0).setWidth(50);;  // JTable열크기 조정하기
		tblContent.getColumnModel().getColumn(0).setMaxWidth(50);;  // JTable열크기 조정하기
		//tblContent.getColumnModel().getColumn(1).setMaxWidth(70);
		tblContent.getColumnModel().getColumn(2).setMaxWidth(50);
		tblContent.getColumnModel().getColumn(3).setMaxWidth(60);
		
		// JTable의 열안에서의 정렬
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tm = tblContent.getColumnModel();
		for(int i=0; i<tm.getColumnCount(); i++) {
			tm.getColumn(i).setCellRenderer(render);
		}
		
		// JTable을 JScrollPane에 올려준다.
		JScrollPane spContent = new JScrollPane(tblContent);
		spContent.setBounds(0, 0, 584, 191);
		
		// JScrollPane을 Panel에 올려준다.
		panel_2.add(spContent);
		
		
		setVisible(true);
		
		/* 아래로 메소드 처리 */
		
		// 아이디와비밀번호 출력처리
		btnMidPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String pwd = txtPwd.getText();
				if(mid.equals("") || pwd.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요.");
					if(mid.equals("")) txtMid.requestFocus();
					else txtPwd.requestFocus();
				}
				else {
					lblDisplay.setText("아이디 : "+mid+" , 비밀번호 : "+pwd);
				}
			}
		});
		
		// 성별 출력 버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdMale.isSelected()) lblDisplay.setText("남자 선택");
				else lblDisplay.setText("여자 선택");
			}
		});
		
		// 직업출력 버튼처리
		btnJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDisplay.setText(comboJob.getSelectedItem().toString()+"을 선택하셨습니다.");
			}
		});
		
		// 선택된 직업을 textarea에 출력하기
		btnJob2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtaContent.setText(comboJob.getSelectedItem().toString());
				txtaContent.append(comboJob.getSelectedItem().toString()+"\n");
			}
		});
		
		// 리스트박스의 내용 가져오기.
		btnJob2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaContent.append(list.getSelectedValue().toString()+"\n");
			}
		});
		
		// 선택된 카드를 모두 레이블에 처리하는 버튼메소드
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String card = "";
				if(chkCard1.isSelected()) card += chkCard1.getText() + "/";
				if(chkCard2.isSelected()) card += chkCard2.getText() + "/";
				if(chkCard3.isSelected()) card += chkCard3.getText() + "/";
				if(chkCard4.isSelected()) card += chkCard4.getText() + "/";
				if(chkCard5.isSelected()) card += chkCard5.getText() + "/";
				if(chkCard6.isSelected()) card += chkCard6.getText() + "/";
				lblDisplay.setText("선택카드 : " + card);
			}
		});
		
		// '종료버튼' 처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test3();
	}
}
