package t4_DBTest_VO;

import java.util.ArrayList;
import java.util.Scanner;

public class DBTestService {
	Scanner sc = new Scanner(System.in);

	DBTestDAO dao = new DBTestDAO();
	DBTestVO vo = new DBTestVO();
	
	// 자료 등록
	public void input() {
		System.out.print("성명 : "); vo.setName(sc.next());
		System.out.print("나이 : "); vo.setAge(sc.nextInt());
		System.out.print("성별 : "); vo.setGender(sc.next());
		System.out.print("입사일 : "); vo.setJoinday(sc.next());
		dao.input(vo);
	}

	// 개별자료 검색
	public void search() {
		
	}

	// 전체자료 검색후 출력처리하는곳
	public void list() {
		ArrayList<DBTestVO> vos = dao.list();
		
		// 전체자료 출력처리하는곳
		System.out.println("============================================");
		System.out.println("번호\t성 명\t나이\t성별\t 가입일자");
		System.out.println("--------------------------------------------");
		
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.println(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getAge()+"\t"+vo.getGender()+"\t"+vo.getJoinday().substring(0,10));
		}
		System.out.println("============================================");
	}

	// 자료 수정
	public void update() {
		
	}

	// 자료 삭제
	public void delete() {
		
	}

}
