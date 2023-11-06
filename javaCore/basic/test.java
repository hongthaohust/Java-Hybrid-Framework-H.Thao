package basic;

public class test {

	public static void main(String[] args) {
//		for(int i = 2; i< 10; i++) {
//			for (int x= 1; x<= 10; x++) {
//				System.out.println(i + " * " + x + " = " + x*i);
//			}
//		}
//		
//		print_charactor_N(10);
		
		print_charactor_H(0);
		print_charactor_H(2);
		print_charactor_H(5);
	}
	
	public static void print_charactor_N(int y) {
		if(y <=0) {
			System.out.println("Nhập vào số > 0");
		}
		else {
			for(int i = 0; i< y; i++) {
				for(int j = 0; j< y; j++) {
					if(j == 0 || j == i || j == y-1) {
						System.out.print("X");
					}
					else System.out.print("O");
				}
				System.out.println("");
			}
		}
		
	}
	
	public static void print_charactor_H(int y) {
		if(y>2 && y%2==1 ) {
			for(int i = 0; i< y; i++) {
				if(i == (y/2)) {
					for(int j = 0; j< y; j++) {
						System.out.print("H");
					}
				}
				else {
					for(int j = 0; j< y; j++) {
						if(j == 0 || j == y-1) {
							System.out.print("H");
						}
						else System.out.print("O");
					}
				}
				System.out.println("");
			}
		}
		else {
			System.out.println("Nhập vào số lẻ >= 3");
		}
		
	}

}
