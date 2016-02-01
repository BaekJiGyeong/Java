
public class ForTest {
	public static void main(String[] args) {
		
		for (int i = 1; i < 10; i++) { System.out.println("9 x " + i + " = " + 9 * i); }
		

		
		System.out.println();
		
		
		
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}

		// 하나의 for문을 이용해서 "*********"을 출력하세요

		/*
		 * for (int i = 0; i<10; i++){ System.out.print("*"); }
		 */

		/**
		 * 중첩 for문을 이용하여 
		 * * 
		 * ** 
		 * *** 
		 * **** 
		 * *****
		 */

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		int numberOne = 10;
		
		numberOne++;
		// numberOne += 1;
		// numberOne = numberOne + 1;
		System.out.println(++numberOne); // 앞에 ++붙으면 즉시 값이 증가됨.
		System.out.println(numberOne++); // 뒤에 ++붙으면 ;만나야 값이 증가됨.		
		System.out.println(numberOne);
		System.out.println();
		
		for( int i=1; i<10; i+=2){			
			System.out.println(i);
		}
		
		System.out.println();
		
		for( int i = 0; i <10; i++){
			if ( i%2 == 0 ) { 
				//continue 현재시점부터 밑에있는 모든것들을 무시한다.
				continue; //짝수면 건너뛰어서 for문 돌아라.
			}
			System.out.println(i);
			
		}
	}
}
