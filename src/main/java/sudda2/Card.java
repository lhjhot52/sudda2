package sudda2;

public class Card {
	final public static String[] mins = {"m1","m2","m3","m4","m5","m6","m7","m8","m9","m10"
			                            ,"光1","p2","光3","p4","p5","p6","p7","光8","p9","p10"};
	final public static int[] mins_VALUES = {1,2,3,4,5,6,7,8,9,10,
			                                   1,2,3,4,5,6,7,8,9,10};
    final public static boolean[] POWER = {false,false,false,false,false,false,false,false,false,false,
    		                               true,false,true,true,false,false,true,true,true,false};
    int min;
    
    public Card(int min) {
    	this.min = min;
    }
    public String toString() {
    	return mins[min];
    }
    int getValue() {
    	return mins_VALUES[min];
    }
    boolean getPower() {
    	return POWER[min];
    }
}



