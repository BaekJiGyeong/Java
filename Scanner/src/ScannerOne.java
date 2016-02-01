import java.util.Scanner;

public class ScannerOne {

	public static void main(String[] args){
		//변수의 선언과 동시에 값의 초기화를 함.
		int numberOne = 15;		
		System.out.println(numberOne);
		
		//변수를 선언만 한다.
		int numberTwo;
		
		//선언된 변수에 값을 초기화 한다.
		numberTwo = 35;
		System.out.println(numberTwo);		
		
		//변수를 선언함.
		int numberThree;
		
		//Scanner를 이용해 변수의 값을 초기화 함
		Scanner input = new Scanner(System.in);
		numberThree = input.nextInt();

		
		System.out.println(numberThree+"을 입력하셨습니다.");
		
		
	}
}
