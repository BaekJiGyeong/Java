import java.util.Scanner;

public class Lesson0118 {
	public static void main(String[] args) {
		/** Scanner를 이용해 숫자 두 개를 입력받는다.
		 * Scanner를 이용해 연산자 하나를 입력받는다.
		 * 입력 받을 수 있는 연산자는 +, -, *, / 로 제한한다.
		 * 문자를 입력받는 scanner기능은 .next()를 사용한다.
		 * 입력 받은 연산자에 해당하는 계산을 한 뒤 결과를 출력한다.
		 */
		
		double numberOne = 0;
		double numberTwo = 0;
		String operator = "";
		double result = 0.0;
		
		System.out.println("< Calculator >");
		System.out.print("First Number : ");
		Scanner userInput = new Scanner( System.in );
		numberOne = userInput.nextInt();
		
		System.out.print("Second Number : ");
		numberTwo = userInput.nextInt();
		
		System.out.print("Select Operator ( +, -, *, /) : ");
		operator = userInput.next();
		
		if ( operator.equals("+")) {
			result = numberOne + numberTwo;
			System.out.println("result : "+numberOne +" "+ operator +" "+numberTwo+" = "+result);
		}
		else if ( operator.equals("-")) {
			result = numberOne - numberTwo;
			System.out.println("result : "+numberOne +" "+ operator +" "+numberTwo+" = "+result);
		}
		else if ( operator.equals("*")) {
			result = numberOne * numberTwo;
			System.out.println("result : "+numberOne +" "+ operator +" "+numberTwo+" = "+result);
		}
		else if ( operator.equals("/")) {
			result = numberOne / numberTwo;
			System.out.println("result : "+numberOne +" "+ operator +" "+numberTwo+" = "+result);
		}
		else {
			System.out.println("You selected wrong operator");			
		}		
	}
}
