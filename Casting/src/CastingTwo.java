
public class CastingTwo {

	public static void main(String[] args) {

		// 숫자 15를 2로 나눈다.

		int numberOne = 15;
		int numberTwo = numberOne / 2;

		// 결과를 출력한다.
		System.out.println(numberOne + " 나누기 2의 결과는 " + numberTwo + "입니다.");
		// double numberThree = (double) numberOne / 2;
		double numberThree = numberOne / 2.0;
		System.out.println(numberOne + " 나누기 2의 결과는 " + numberThree + "입니다.");

		// 숫자 15를 실수로 변환한다.
		
		double numberFour = numberOne;
		

		// 실수 15를 2로 나눈다.
		double numberFive = numberFour / 2;

		// 결과를 출력한다.
		System.out.println(numberFour + "나누기 2의 결과는" + numberFive + "입니다.");

	}

}
