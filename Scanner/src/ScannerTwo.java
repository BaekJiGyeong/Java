import java.util.Scanner;

public class ScannerTwo {
	public static void main(String[] args){
		
		// int형 변수 두 개를 정의한다.
		int numberOne;
		int numberTwo;
		
		// int형 변수 각각에 Scanner를 통해 값을 입력받는다.
		Scanner scanner = new Scanner( System.in );
		System.out.println("숫자 두 개를 더하는 프로그램입니다.");
		
		System.out.print("Firt number : ");
		numberOne = scanner.nextInt();
		
		System.out.print("Second number : ");
		numberTwo = scanner.nextInt();
		
		// int형 변수 두 개를 더해 다른 변수에 저장한다.
		int additionResult = numberOne + numberTwo;
				
		// 두 개를 더한 결과를 출력한다.
		System.out.println(numberOne + " + " + numberTwo + " = " + additionResult);
		
	}

}


