package sudda2;

public class Player {
	final static int MAX_TABLE_SIZE = 2;

	Card[] tables;

	int count;

	Player() {
		tables = new Card[MAX_TABLE_SIZE];
	}

	void add(Card card) {
		tables[count++] = card;
	}
	
	public void init() {
		tables = new Card[MAX_TABLE_SIZE];
	}
	
	public String toString1() {
		String str = "";
		int index = 0;
		for (int i = 0; i < MAX_TABLE_SIZE; ++i) {
			if (tables[i] == null) {
				break;
			} else {
				str += "[" + tables[i] + "]";
			}
		}
		return str;
	}

	public String levelString1() {
		String str = "";
		int temp;
		int first = tables[0].getValue();
		int second = tables[1].getValue();
		boolean a, b;
		a = tables[0].getPower();
		b = tables[1].getPower();

		if (first > second) {
			temp = first;
			first = second;
			second = temp;
		}

		if (a && b) {
			if (first == 3 && second == 8) {
				str = "38광땡";
			} else if (first == 1 && second == 3) {
				str = "13광땡";
			} else if (first == 1 && second == 8) {
				str = "18광땡";
			} else if (first == 3 && second == 7) {
				str = "땡잡이";
			} else if (first == 4 && second == 7) {
				str = "암행어사";
			} else if (first == 4 && second == 9) {
				str = "멍텅구리사구";
			} else if (first == 1) {
				if (second == 4) {
					str = "독사";
				} else if (second == 9) {
					str = "구삥";
				} else {
					str = (first + second) % 10 + "끗";
				}
			} else {
				str = (first + second) % 10 +"끗";
			}
			 
		} else {
			if (first == second) {
				if (first == 10) {
					str = "장땡";
				} else if (first == 9) {
					str = "구땡";
				} else if (first == 8) {
					str = "팔땡";
				} else if (first == 7) {
					str = "칠땡";
				} else if (first == 6) {
					str = "육땡";
				} else if (first == 5) {
					str = "오땡";
				} else if (first == 4) {
					str = "사땡";
				} else if (first == 3) {
					str = "삼땡";
				} else if (first == 2) {
					str = "이땡";
				} else if (first == 1) {
					str = "일땡";
				}
			} else if (first == 1) {
				if (second == 2) {
					str = "알리";
				} else if (second == 4) {
					str = "독사";
				} else if (second == 9) {
					str = "구삥";
				} else if (second == 10) {
					str = "장삥";
				} else {
					str = (first + second) % 10 + "끗";
				}
			} else if (first == 4) {
				if (second == 10) {
					str = "장사";
				} else if (second == 6) {
					str = "세륙";
				} else if (second == 9) {
					str = "사구";
				} else {
					str = (first + second) % 10 + "끗";
				}
			} else {
				str = (first + second) % 10 + "끗";
			}

		}
		return str;
	}

	int calc() {
		int temp;
		int value = 0;
		int first = tables[0].getValue();
		int second = tables[1].getValue();
		boolean a, b;
		a = tables[0].getPower();
		b = tables[1].getPower();

		if (first > second) {
			temp = first;
			first = second;
			second = temp;
		}
		
		if (a && b) {
			if (first == 3 && second == 8) {
				value = 1000;
			} else if (first == 1 && second == 3) {
				value = 999;
			} else if (first == 1 && second == 8) {
				value = 999;
			} else if (first == 3 && second == 7) {
				value = 0;
			} else if (first == 4 && second == 7) {
				value = 1;
			} else if (first == 4 && second == 9) {
				value = 333;
			} else if (first == 1) {
				if (second == 4) {
					value = 19;
				} else if (second == 9) {
					value = 18;
				} else {
					value = (first + second) % 10;
				}
			} else {
				value = (first + second) % 10;
			}
		} else {
			if (first == second) {
				if (first == 10) {
					value = 100;
				} else if (first == 9) {
					value = 99;
				} else if (first == 8) {
					value = 98;
				} else if (first == 7) {
					value = 97;
				} else if (first == 6) {
					value = 96;
				} else if (first == 5) {
					value = 95;
				} else if (first == 4) {
					value = 94;
				} else if (first == 3) {
					value = 93;
				} else if (first == 2) {
					value = 92;
				} else if (first == 1) {
					value = 91;
				}
			} else if (first == 1) {
				if (second == 2) {
					value = 20;
				} else if (second == 4) {
					value = 19;
				} else if (second == 9) {
					value = 18;
				} else if (second == 10) {
					value = 17;
				} else {
					value = (first + second) % 10;
				}
			} else if (first == 4) {
				if (second == 10) {
					value = 16;
				} else if (second == 6) {
					value = 15;
				} else if (second == 9) {
					value = 33;
				} else {
					value = (first + second) % 10;
				}
			} else {
				value = (first + second) % 10;
			}
		}
		
		return value;
	}
	
	int lv() {
		int temp;
		int value = 0;
		int first = tables[0].getValue();
		int second = tables[1].getValue();
		boolean a, b;
		a = tables[0].getPower();
		b = tables[1].getPower();

		if (first > second) {
			temp = first;
			first = second;
			second = temp;
		}
		
		if (a && b) {
			if (first == 3 && second == 8) {
				value = 1000;
			} else if (first == 1 && second == 3) {
				value = 990;
			} else if (first == 1 && second == 8) {
				value = 990;
			} else if (first == 3 && second == 7) {
				value = 0; 
			} else if (first == 4 && second == 7) {
				value = 1;
			} else if (first == 4 && second == 9) {
				value = 333;
			} else if (first == 1) {
				if (second == 4) {
					value = 19;
				} else if (second == 9) {
					value = 18;
				} else {
					value = (first + second) % 10;
				}
			} else {
				value = (first + second) % 10;
			}
			 
		} else {
			if (first == second) {
				if (first == 10) {
					value = 101;
				} else if (first == 9) {
					value = 100;
				} else if (first == 8) {
					value = 100;
				} else if (first == 7) {
					value = 100;
				} else if (first == 6) {
					value = 100;
				} else if (first == 5) {
					value = 100;
				} else if (first == 4) {
					value = 100;
				} else if (first == 3) {
					value = 100;
				} else if (first == 2) {
					value = 100;
				} else if (first == 1) {
					value = 100;
				}
			} else if (first == 1) {
				if (second == 2) {
					value = 20;
				} else if (second == 4) {
					value = 19;
				} else if (second == 9) {
					value = 18;
				} else if (second == 10) {
					value = 17;
				} else {
					value = (first + second) % 10;
				}
			} else if (first == 4) {
				if (second == 10) {
					value = 16;
				} else if (second == 6) {
					value = 15;
				} else if (second == 9) {
					value = 33;
				} else {
					value = (first + second) % 10;
				}
			} else {
				value = (first + second) % 10;
			}
		}
		
		return value;
	}		
}
	