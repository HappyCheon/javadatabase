package t3_DBTest_CRUD;

import java.util.Scanner;

public class DBTestRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// DB연결
		DBTest dbTest = new DBTest();
		
		// 메뉴 작업
		int sel = 6;
		String name = "";
			
		while(true) {
			System.out.println("___ 작업선택 ___");
			System.out.print("1.자료입력  2.개별조회  3.전체조회  4.수정  5.삭제  6.종료 ==>> ");
			sel = scanner.nextInt();
			if(sel < 1 || sel > 5) break;
			
			switch(sel) {
				case 1:
					// 입력처리
					System.out.print("성명을 입력하세요? "); name = scanner.next();
					System.out.print("나이를 입력하세요? "); int age = scanner.nextInt();
					System.out.print("성별을 입력하세요?(1:남자, 2:여자) "); String gender = scanner.next();
					System.out.print("입사일을 입력하세요?(yyyy-mm-dd) "); String joinday = scanner.next();
					if(gender.equals("1")) gender = "m";
					else gender = "f";
					dbTest.input(name, age, gender, joinday);
					break;
				case 2:
					// 개별자료 검색
					while(true) {
						System.out.print("검색할 성명을 입력하세요? ");
						name = scanner.next();
						dbTest.searchTest(name);	// 개별조회 메소드 호출
						System.out.print("계속할까요?(y/n) ");
						String ans = scanner.next();
						if(!ans.toUpperCase().equals("Y")) break;
					}
					break;
				case 3:
					// 전체조회
					dbTest.list();	// 전체조회 메소드 호출
					break;
				case 4:
					// 수정처리
					
					break;
				case 5:
					// 삭제처리
					
					break;
				default:
					break;
			}
		}
		System.out.println("=====================================================");
		System.out.println(".......작업끝..입니다.....");
		
		// DB Close처리
		// dbTest.rsClose();
		dbTest.dbClose();
		scanner.close();
	}
}
