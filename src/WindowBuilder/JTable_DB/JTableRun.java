package WindowBuilder.JTable_DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class JTableRun extends JFrame {
  DefaultTableModel defaultTableModel;
  JTable jTable;
  JScrollPane jScrollPane;
  
  private JTextField txtName;
  private JTextField txtAge;
  private JTextField txtGender;
  private JTextField txtJoinday;
  
  JTableDAO dao = new JTableDAO();
  JTableVO vo = null;
  
  int idx = 0;
  
  @SuppressWarnings("rawtypes")
  Vector vData = null;

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public JTableRun() {
    super("테이블 연습3");
    setSize(470, 368);
    setLocationRelativeTo(null);
    
    getContentPane().setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Vector title = new Vector();
    title.add("번호");
    title.add("성명");
    title.add("나이");
    title.add("성별");
    title.add("입사일");
    
    vData = dao.getList();
    
    defaultTableModel = new DefaultTableModel(vData,title);
    jTable = new JTable(defaultTableModel);
    jScrollPane = new JScrollPane(jTable);
    jScrollPane.setBounds(0, 0, 454, 221);
    
    getContentPane().add(jScrollPane);
    
    JLabel lblNewLabel = new JLabel("성명");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(18, 239, 57, 15);
    getContentPane().add(lblNewLabel);
    
    JLabel label = new JLabel("나이");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setBounds(93, 239, 57, 15);
    getContentPane().add(label);
    
    JLabel label_1 = new JLabel("성별");
    label_1.setHorizontalAlignment(SwingConstants.CENTER);
    label_1.setBounds(175, 239, 57, 15);
    getContentPane().add(label_1);
    
    JLabel label_2 = new JLabel("입사일");
    label_2.setHorizontalAlignment(SwingConstants.CENTER);
    label_2.setBounds(250, 239, 57, 15);
    getContentPane().add(label_2);
    
    txtName = new JTextField();
    txtName.setBounds(10, 264, 70, 21);
    getContentPane().add(txtName);
    txtName.setColumns(10);
    
    txtAge = new JTextField();
    txtAge.setColumns(10);
    txtAge.setBounds(87, 264, 70, 21);
    getContentPane().add(txtAge);
    
    txtGender = new JTextField();
    txtGender.setColumns(10);
    txtGender.setBounds(166, 264, 70, 21);
    getContentPane().add(txtGender);
    
    txtJoinday = new JTextField();
    txtJoinday.setColumns(10);
    txtJoinday.setBounds(244, 264, 70, 21);
    getContentPane().add(txtJoinday);
    
    JButton btnInput = new JButton("추  가");
    btnInput.setBounds(345, 231, 97, 23);
    getContentPane().add(btnInput);
    
    JButton btnDelete = new JButton("삭  제");
    btnDelete.setBounds(345, 275, 97, 23);
    getContentPane().add(btnDelete);
    
    JButton btnExit = new JButton("종  료");
    btnExit.setBounds(345, 296, 97, 23);
    getContentPane().add(btnExit);
    
    JButton btnUpdate = new JButton("수  정");
    btnUpdate.setBounds(345, 252, 97, 23);
    getContentPane().add(btnUpdate);
    
    JButton button = new JButton("박스클리어");
    button.setBounds(20, 295, 105, 23);
    getContentPane().add(button);
    
    
    setVisible(true);
    
    /* --------------- 메소드영역 ------------------------- */
    
    // 자료 추가하기
    btnInput.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(txtName.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "성명을 입력하세요!");
          txtName.requestFocus();
        }
        else if(txtAge.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "나이를 입력하세요!");
          txtAge.requestFocus();
        }
        else if(txtGender.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "성별을 입력하세요!");
          txtGender.requestFocus();
        }
        else if(txtJoinday.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "입사일을 입력하세요!");
          txtJoinday.requestFocus();
        }
        else {
          vo = new JTableVO();
          vo.setName(txtName.getText());
          vo.setAge(Integer.parseInt(txtAge.getText()));
          vo.setGender(txtGender.getText());
          vo.setJoinday(txtJoinday.getText());
          dao.JTableInput(vo);
          
          JOptionPane.showMessageDialog(null, "자료가 삽입되었습니다.");
          
          txtName.setText("");
          txtAge.setText("");
          txtGender.setText("");
          txtJoinday.setText("");
          
          vData = dao.getList();
          defaultTableModel.setDataVector(vData, title);
        }
      }
    });
    
    // 자료 삭제하기
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(jTable.getSelectedRow() == -1) {
          JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요.");
          return;
        }
        else {
          int res = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?","삭제창",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(res == JOptionPane.YES_OPTION) {
            
            int row = jTable.getSelectedRow();
            int idx = Integer.parseInt(jTable.getValueAt(row, 0).toString());
            dao.setDelete(idx);
            JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
            vData = dao.getList();
            defaultTableModel.setDataVector(vData, title);
          }
          else if(res == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "삭제 취소!!!");
          }
          else {
            JOptionPane.showMessageDialog(null, "삭제 취소!!!");
          }
        }
      }
    });
    
    // jTable클릭시 내용을 텍스트박스로 가져오기
    jTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        //선택한 셀의 행 번호계산 
        int row = jTable.getSelectedRow();
        
        //테이블의 모델객체 얻어오기
        TableModel data = jTable.getModel();
        
        idx = Integer.parseInt(data.getValueAt(row,0).toString());
        String name = (String) data.getValueAt(row,1);
        int age = Integer.parseInt(data.getValueAt(row,2).toString());
        String gender = (String) data.getValueAt(row,3);
        String joinday = data.getValueAt(row,4).toString().substring(0,10);
        
        txtName.setText(name);
        txtAge.setText(age+"");
        txtGender.setText(gender);
        txtJoinday.setText(joinday);
      }
    });
    
    // 선택된 자료 수정하기
    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        vo = new JTableVO();
        vo.setIdx(idx);
        vo.setName(txtName.getText());
        vo.setAge(Integer.parseInt(txtAge.getText().toString()));
        vo.setGender(txtGender.getText());
        vo.setJoinday(txtJoinday.getText());
        
        dao.setUpdate(vo);
        JOptionPane.showMessageDialog(null, "수정 되었습니다.");
        vData = dao.getList();
        defaultTableModel.setDataVector(vData, title);
      }
    });
    
    // 박스 클리어
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        txtName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtJoinday.setText("");
        txtName.requestFocus();
      }
    });
    
    // 작업종료
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "수고 하셨습니다.");
        System.exit(0);
      }
    });
  }
  
  public static void main(String[] args) {
    new JTableRun();
  }
}
