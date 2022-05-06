package sudda2;

import java.util.Scanner;

public class CardDeck {
	public static void main(String[] args) {
	
    System.out.println("===========< 섯다 게임 >===========");
    System.out.println("----------------------------------------");
    int com[] = new int[2];
    int player[] = new int [2];
    int w, r;
    int cardResult;
    int cardResultP;
    boolean outside;

    w = 0;
   
    while(w < 2){
        r = (int)(Math.random() * 10)+1; 
        
            com [w] = r;
            w++;
        }
   

        for(int i = 0;i < com.length; i++){
        System.out.println("computer [" + (i + 1) + "] = " + com[i]);
    }

    System.out.println("-----------------------------------------");

    w = 0;
    while(w < 2){
        r = (int)(Math.random() * 10)+1; 
            player [w] = r;
            w++;
        }
   
        
        for(int i = 0;i < player.length; i++){
        System.out.println("player [" + (i + 1) + "] = " + player[i]);
        
    }
    System.out.println("----------------------------------------");
    
cardResult=0;
outside:while(com[0]==com[1]){            
        if(com[0]==10){
            cardResult=com[0];
            cardResult = 30;
        } else if (com[0]==9){
            cardResult=com[0];
            cardResult = 29;
        } else if (com[0]==8){
            cardResult=com[0];
            cardResult = 28;
        } else if (com[0]==7){
            cardResult=com[0];
            cardResult = 27;
        } else if (com[0]==6){
            cardResult=com[0];
            cardResult= 26;
        } else if (com[0]==5){
            cardResult=com[0];
            cardResult = 25;
        } else if (com[0]==4){
            cardResult=com[0];
            cardResult= 24;
        } else if (com[0]==3){
            cardResult=com[0];
            cardResult = 23;
        } else if (com[0]==2){
            cardResult=com[0];
            cardResult= 22;
        } else if (com[0]==1){
            cardResult=com[0];
            cardResult= 21;
        }         
        System.out.println("computer 값 = " + cardResult);
        break outside;

}  

    
    while(com[0]!=com[1]){

        if(com[0]==1 && com[1]==2 || com[0]==1 && com[1]==2){
                        cardResult = 20;
                    } else if(com[0]==1 && com[0]==4 || com[1]==1 && com[0]==4){
                        cardResult=19;
                    } else if (com[0]==1 && com[0]==9 || com[1]==1&& com[0]==9){
                        cardResult=18;
                    } else if (com[0]==1 && com[0]==10 || com[1]==1&& com[0]==10){
                        cardResult=17;
                    } else if (com[0]==4 && com[0]==10 || com[1]==4&& com[0]==10){
                        cardResult=16;
                    } else if (com[0]==4 && com[0]==6 || com[1]==4&& com[0]==6){
                        cardResult=15;
                    } else {
                        cardResult = (com[0] + com[1])%10;
                    } 

                    System.out.println("computer 값 = " + cardResult);
                    break;
}
    


cardResultP=0;
outside:while(player[0]==player[1]){            
            if(player[0]==10){
                cardResultP=player[0];
                cardResultP = 30;
            } else if (player[0]==9){
                cardResultP=player[0];
                cardResultP = 29;
            } else if (player[0]==8){
                cardResultP=player[0];
                cardResultP = 28;
            } else if (player[0]==7){
                cardResultP=player[0];
                cardResultP = 27;
            } else if (player[0]==6){
                cardResultP=player[0];
                cardResultP= 26;
            } else if (player[0]==5){
                cardResultP=player[0];
                cardResultP = 25;
            } else if (player[0]==4){
                cardResultP=player[0];
                cardResultP= 24;
            } else if (player[0]==3){
                cardResultP=player[0];
                cardResultP = 23;
            } else if (player[0]==2){
                cardResultP=player[0];
                cardResultP= 22;
            } else if (player[0]==1){
                cardResultP=player[0];
                cardResultP= 21;
            }         
            System.out.println("player 값 = " + cardResultP);
            break outside;

    }  

        
        while(player[0]!=player[1]){

            if(player[0]==1 && player[1]==2 || player[0]==1 && player[1]==2){
                            cardResultP = 20;
                        } else if(player[0]==1 && player[0]==4 || player[1]==1 && player[0]==4){
                            cardResultP=19;
                        } else if (player[0]==1 && player[0]==9 || player[1]==1&& player[0]==9){
                            cardResultP=18;
                        } else if (player[0]==1 && player[0]==10 || player[1]==1&& player[0]==10){
                            cardResultP=17;
                        } else if (player[0]==4 && player[0]==10 || player[1]==4&& player[0]==10){
                            cardResultP=16;
                        } else if (player[0]==4 && player[0]==6 || player[1]==4&& player[0]==6){
                            cardResultP=15;
                        } else {
                            cardResultP = (player[0] + player[1])%10;
                        } 

                        System.out.println("player 값 = " + cardResultP);
                        break;
    }
    System.out.println("----------------------------------------");

    if(cardResultP > cardResult){
        System.out.println("--> 이겼습니다 ");
    }else if(cardResultP < cardResult ){
        System.out.println("--> 졌습니다 ");
    } else if(cardResultP == cardResult){
        System.out.println("--> 무승부 ");
    }
    }
}