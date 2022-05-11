package sudda2;

import java.util.Scanner;

public class Seokda {
	private Scanner scn = new Scanner(System.in);
	MemberServiceImpl memberServiceImpl = new MemberService();
	
	Cards cards;
	Player player;
	Computer com;
	Scanner sc;
	
    public Seokda() {
    	cards = new Cards();
        player = new Player();
    	com = new Computer();
    	sc = new Scanner(System.in);
    }
    public void run() {
    	new_game();
    }

	public void new_game() {
		boolean run = true;
		
		while(run) {
			int menuNum = 0;
			
			System.out.println("===========================================");
			System.out.println("===========1.로그인 2.회원가입 3.종료===========");
			System.out.println("===========================================");
			
			try {
				System.out.println("메뉴 입력 : ");
				menuNum = Integer.parseInt(scn.nextLine());
			}catch(Exception e) {
				System.out.println("잘못된 값을 입력하였습니다.");
			}
		    switch (menuNum) {
		    case 1 :
		    	MemberVO login = login();
		    	break;
		    case 2 :
		    	memberInsert();
		    	break;
		    case 3:
		    	System.out.println("=======시스템을 종료합니다.=======");
		    	scn.close();
		    	run = false;
		    	break;
		    default :
		    	errorMenu();
		    	break;
		    }
		
		}
    	player.add(cards.next());
    	player.add(cards.next());
        
    	com.add(cards.next());
    	com.add(cards.next());

    	player.calc();
    	com.calc();
    	
    	
    	System.out.println("섯다게임을 시작합니다.");
    	System.out.println();
    	System.out.println("나의 카드는 : " + player);
    	System.out.println("나의 족보는 : " + player.levelString1());
    	System.out.println();
    	System.out.println("컴퓨터 카드는 : " + com);
    	System.out.println("컴퓨터 족보는 : " + com.levelString1());
    	System.out.println();
    	
    	if((player.calc() == 333) && (com.calc() < 999) || (com.calc() == 333) && (player.calc() < 999)){
    		System.out.println("멍텅구리사구입니다. 재경기 해주세요.");
    		new Seokda().new_game();
    	}else if((player.calc() == 33) && (com.calc() <= 20) || (com.calc() == 33) && (player.calc() <= 20)) {
    		System.out.println("사구입니다. 재경기해주세요");
    		new Seokda().new_game();
    	}else if((player.calc() == 2) && (com.calc() == 1)) {
    		System.out.println("플레이어가 땡잡이로 승리하였습니다.");
    	}else if((com.calc() == 2) && (player.calc() == 1)) {
    		System.out.println("컴퓨터가 땡잡이로 승리하였습니다.");
    	}else if((player.calc() == 5) && (player.calc() == 4)) {
    		System.out.println("플레이어가 암행어사로 승리하였습니다.");
    	}else if((com.calc() == 5) && (player.calc() == 4)) {
    		System.out.println("컴퓨터가 암행어사로 승리하였습니다.");
    	}else if(player.calc() > com.calc()) {
    		System.out.println("플레이어 승리 !");
    	}else if(player.calc() == com.calc()) {
    		System.out.println("무승부입니다.");
    		System.out.println("재경기 하겠습니다.");
    		new Seokda().new_game();
    	}else {
    		System.out.println("컴퓨터의 승리");
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
		MemberVO vo = new MemberVO(memberId,password);
		
		MemberVO memberVO = memberServiceImpl.login(vo);
	}
	
}
