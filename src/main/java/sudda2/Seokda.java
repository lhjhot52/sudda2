package sudda2;

import java.util.Scanner;

public class Seokda {
	private Scanner scn = new Scanner(System.in);
	MemberServiceImpl memberServiceImpl = new MemberService();
	AdminLoginMenu adminLogin = new AdminLoginMenu();

	public void run() {
		new_game();
	}

	public void new_game() {
		boolean run = true;

		while (run) {
			int menuNum = 0;

			System.out.println("===========================================");
			System.out.println("===========1.로그인 2.회원가입 3.종료===========");
			System.out.println("===========================================");

			try {
				System.out.println("메뉴 입력 : ");
				menuNum = Integer.parseInt(scn.nextLine());
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하였습니다.");
			}
			switch (menuNum) {
			case 1:
				MemberVO login = login();
				adminLogin.adminLoginMenu(login);
				break;
			case 2:
				memberInsert();
				break;
			case 3:
				System.out.println("==============시스템을 종료합니다.==============");
				scn.close();
				run = false;
				break;
			default:
				errorMenu();
				break;
			}

		}

	}

	private void memberInsert() {
		System.out.println("아이디 : ");
		String memberId = scn.nextLine();
		System.out.println("비밀번호 : ");
		String password = scn.nextLine();
		System.out.println("이름 : ");
		String name = scn.nextLine();
		System.out.print("연락처 : ");
		String phone = scn.nextLine();
		System.out.print("주소 : ");
		String address = scn.nextLine();
		MemberVO vo = new MemberVO(memberId, password, name, phone, address);

		memberServiceImpl.memberInsert(vo);

	}

	private MemberVO login() {
		System.out.println("아이디 : ");
		String memberId = scn.nextLine();
		System.out.println("비밀번호 : ");
		String password = scn.nextLine();
		MemberVO vo = new MemberVO(memberId, password);

		MemberVO memberVO = memberServiceImpl.login(vo);

		if (memberVO.getMemberId() != null) {
			System.out.println(memberVO.getMemberName() + "님이 접속하였습니다.");
		} else {
			System.out.println("로그인에 실패하였습니다.");
			return memberVO;
		}
		return memberVO;
	}

	private void errorMenu() {
		System.out.println("없는 메뉴입니다.");

	}
}
