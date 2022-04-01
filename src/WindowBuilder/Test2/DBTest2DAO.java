package WindowBuilder.Test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DBTest2DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	DBTest2VO vo = null;
	
	// 처음 DAO생성시에 Database 연결한다.
	public DBTest2DAO() {
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
		} finally {
			rsClose();
		}
		return vData;
	}

	// 회원가입시키기
	public void DBTestInput(DBTest2VO vo) {
		try {
			sql = "insert into dbtest value (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getJoinday());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}

	// 개별자료 검색처리
	public DBTest2VO getSearch(int idx) {
		DBTest2VO vo = new DBTest2VO();
		try {
			sql = "select * from dbtest where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(idx);
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 조건검색하기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getSearch(String comboStr, String txtStr) {
		Vector vData = new Vector();
		try {
			sql = "select * from dbtest where "+comboStr+" like ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			if(!comboStr.equals("age")) {
				pstmt.setString(1, "%"+txtStr+"%");
			}
			else {
				pstmt.setInt(1, Integer.parseInt(txtStr));
			}
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
		} finally {
			rsClose();
		}
		return vData;
	}
	
	
}
