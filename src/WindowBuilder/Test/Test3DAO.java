package WindowBuilder.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Test3DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	DBTest3VO vo = null;
	
	// 처음 DAO생성시에 Database 연결한다.
	public Test3DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javagreen";
			String user = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~~~");
		}
	}
	
	// Database Close
	public void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// preparedstatement객체 Close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// resultset객체 close
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				pstmtClose();
			}
		} catch (Exception e) {}
	}

	// 전체자료를 Vector에 담아서 전송처리한다.
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getList() {
		Vector vData = new Vector();
		try {
			sql = "select * from dbtest order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		}
		return vData;
	}

	// 성별만 담아오기
	public ArrayList<String> getGender() {
		ArrayList<String> vDataGender = new ArrayList<String>();
		try {
			sql = "select distinct gender from dbtest";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vDataGender.add(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("SQL에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vDataGender;
	}
	
	
}
