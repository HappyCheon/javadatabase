package WindowBuilder.Test2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DBTest2List extends JFrame {
	private JTextField txtSearch;
	private JTable table;
	
	DBTest2DAO dao = new DBTest2DAO();
	@SuppressWarnings("rawtypes")
	Vector vData = new Vector();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DBTest2List() {
		super("컴포넌트 연습");
		setSize(600, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pnTop = new JPanel();
		pnTop.setBounds(0, 0, 584, 58);
		getContentPane().add(pnTop);
		pnTop.setLayout(null);
		
		JComboBox comboSearch = new JComboBox();
		comboSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		comboSearch.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		comboSearch.setBounds(9, 10, 98, 38);
		pnTop.add(comboSearch);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		txtSearch.setBounds(116, 10, 147, 38);
		pnTop.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("조건검색");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		btnSearch.setBounds(272, 10, 98, 38);
		pnTop.add(btnSearch);
		
		JButton btnList = new JButton("전체검색");
		btnList.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList.setBounds(379, 10, 98, 38);
		pnTop.add(btnList);
		
		JButton btnExit = new JButton("닫기");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(486, 10, 86, 38);
		pnTop.add(btnExit);
		
		JPanel pnContent = new JPanel();
		pnContent.setBounds(0, 68, 584, 373);
		getContentPane().add(pnContent);
		pnContent.setLayout(null);
		
		// 타이틀을 Vector타입으로 준비
		Vector title = new Vector();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 데이터를 Vector타입으로 준비
		vData = dao.getList();
		
		// 준비된 Vector타입의 자료와 제목을 DefaultTableModel을 생성하면서 담는다.
		DefaultTableModel defaultTableModel = new DefaultTableModel(vData, title);
		
		// defaultTableModel을 table을 생성하면서 올려준다.
		table = new JTable(defaultTableModel);
		
		// table을 JScrollPane생성시 함께 올려준다.
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 560, 353);
		
		// scrollPane을 패널에 올린다.
		pnContent.add(scrollPane);
		
		setVisible(true);
		
		/* 아래는 메소드 영역 */
		
		// 전체검색처리
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getList();
				defaultTableModel.setDataVector(vData, title);
			}
		});
		
		// 조건검색처리
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comboStr = comboSearch.getSelectedItem().toString();
				String txtStr = txtSearch.getText();
				
				if(txtStr.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
					txtSearch.requestFocus();
					return;
				}
				
				if(comboStr.equals("성명")) {
					vData = dao.getSearch("name", txtStr);
				}
				else if(comboStr.equals("나이")) {
					if(!Pattern.matches("^[0-9]*$", txtStr)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
						txtSearch.requestFocus();
						return;
					}
					else {
						vData = dao.getSearch("age", txtStr);
					}
				}
				else if(comboStr.equals("성별")) {
					vData = dao.getSearch("gender", txtStr);
				}
				else {
					vData = dao.getSearch("joinday", txtStr);
				}
				
				if(vData.size() == 0) {
					JOptionPane.showMessageDialog(null, "검색된 자료가 없습니다.");
				}
				else {
					defaultTableModel.setDataVector(vData, title);
				}
				
			}
		});
		
		// 닫기버튼클릭처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		new DBTest2List();
	}
}
