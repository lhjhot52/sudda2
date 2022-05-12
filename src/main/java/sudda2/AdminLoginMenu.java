package sudda2;

import java.util.Scanner;

public class AdminLoginMenu {
    private Scanner scn = new Scanner(System.in);
    MemberServiceImpl memberServiceImpl = new MemberService();
    Cards cards;
	Player player;
	Computer com;
	Scanner sc;
	
    public AdminLoginMenu() {
    	cards = new Cards();
        player = new Player();
    	com = new Computer();
    	sc = new Scanner(System.in);
    }
    
    public void adminLoginMenu (MemberVO login) {
    	boolean isTrue = true;
    	while(isTrue) {
    		int subMenuNum = adminLogin();
    		switch (subMenuNum) {
    		case 1:
    			Seokda();
    			break;
    		case 2:
    			isTrue = false;
    			break;
    		default:
    			errorMenu();
    			break;
    		}
    	}
    }

	private int adminLogin() {
		int subMenuNum = 0;
		
		System.out.println("===========================================");
		System.out.println("=============1.섯다게임실행 2.종료=============");
		System.out.println("===========================================");
		
		try {
			System.out.println("메뉴 입력 : ");
			subMenuNum = Integer.parseInt(scn.nextLine());
		}catch(Exception e) {
			System.out.println("잘못된 값을 입력했습니다.");
		}	
		
		return subMenuNum;
	}
	
	private void Seokda() {
		Cards cards = new Cards();
		Player player = new Player();
		Computer com = new Computer();
		player.add(cards.next());
    	player.add(cards.next());
        
    	com.add(cards.next());
    	com.add(cards.next());

    	player.calc();
    	com.calc();
    	player.levelString1();
    	com.levelString1();
    	
    	System.out.println("섯다게임을 시작합니다.");
    	System.out.println();
    	System.out.println("나의 족보는 : " + player.levelString1());
        System.out.println();
    	System.out.println("컴퓨터 족보는 : " + com.levelString1());
    	System.out.println();
    	
    	if((player.calc() == 333) && (com.calc() < 999) || (com.calc() == 333) && (player.calc() < 999)){
    		System.out.println("멍텅구리사구입니다. 재경기 해주세요.");
    		
    	}else if((player.calc() == 33) && (com.calc() <= 20) || (com.calc() == 33) && (player.calc() <= 20)) {
    		System.out.println("사구입니다. 재경기해주세요");
    		
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
    	}else {
    		System.out.println("컴퓨터의 승리");
    	}
		
	}
	
	private void errorMenu() {
		
		
	}

	
}
