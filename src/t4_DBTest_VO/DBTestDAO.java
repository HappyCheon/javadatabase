package t4_DBTest_VO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTestDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	DBTestVO vo = null;
	
	// 처음 DAO생성시에 Database 연결한다.
	public DBTestDAO() {
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
	
	// statement객체 Close
	public void stmtClose() {
		try {
			if(stmt != null) stmt.close();
		} catch (Exception e) {}
	}
	
	// resultset객체 close
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				stmtClose();
			}
		} catch (Exception e) {}
	}

	// 자료 등록처리하기
	public void input(DBTestVO vo) {
		try {
			stmt = conn.createStatement();
			sql = "insert into dbtest values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getJoinday()+"')";
			stmt.executeUpdate(sql);
			System.out.println(vo.getName() + " 님 자료가 등록되었습니다.");
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}

	// 전체자료 검색하기
	public ArrayList<DBTestVO> list() {
		ArrayList<DBTestVO> vos = new ArrayList<DBTestVO>();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest order by idx desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				DBTestVO vo = new DBTestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 개별자료 검색하기
	public DBTestVO search(String name) {
		vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest where name = '"+name+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 자료 삭제처리하기
	public int delete(String name) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			sql = "select * from dbTest where name = '"+name+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				stmtClose();
				stmt = conn.createStatement();
				sql = "delete from dbTest where name = '"+name+"'";
				stmt.executeUpdate(sql);
				res = 1;
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		
		return res;
	}

	// 회원자료 수정처리...(검색후 수정처리한다.)
	public DBTestVO UpdateSearch(int idx) {
		vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbTest where idx = "+idx;
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		return vo;
	}

	// 실제 자료내용 수정처리하기
	public void updateProcess(DBTestVO vo) {
		try {
			stmt = conn.createStatement();
			sql = "update dbTest set name='"+vo.getName()+"', age="+vo.getAge()+", gender='"+vo.getGender()+"', joinday='"+vo.getJoinday()+"' where idx = "+vo.getIdx();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}
}
