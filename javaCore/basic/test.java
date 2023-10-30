package basic;

public class test {

	public static void main(String[] args) {
		print_charactor_N(5);
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

}
