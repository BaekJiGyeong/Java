
public class IFtest {
	public static void main(String[] args) {

		int money = 1200;
		if (money >= 1200) {
			System.out.println("캔 커피를 삽니다.");
		}

		int age = 27;
		if (age >= 30) {
			System.out.println("당신의 나이는 30대 입니다.");
		} else {
			System.out.println("당신의 나이는 30대가 아닙니다.");
		}

		if (age >= 30 && money >= 1200) {
			System.out.println("캔 커피를 삽니다.");
		}

		// 나이가 20세 이상이고, 현재 가진 금액이 4,500원 이상일 때,
		// "담배를 삽니다"라고 출력하는 명령문을 만드세요.

		if (age >= 20 && money >= 4500) {
			System.out.println("담배를 삽니다.");
		} else {
			System.out.println("담배를 못삽니다.");
		}

		// 남자일 경우 남탕, 여자일 경우 여탕
		int sex = 1;
		if (sex == 0) {
			System.out.println("남탕으로 가세요.");
		} else {
			System.out.println("여탕으로 가세요.");
		}

		// 학점 if - else

		/*
		 * int score = 77; if ( score >= 90 && score <= 100 ) {
		 * System.out.println("A"); } else { if ( score >= 80 && score <= 89 ) {
		 * System.out.println("B"); } else { if ( score >= 70 && score <= 79 ) {
		 * System.out.println("C"); } else { if ( score >= 60 && score <= 69 ) {
		 * System.out.println("D"); } else { System.out.println("F"); } } } }
		 */

		
		
		// if - else if

		int score = 77;
		
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		} 
		else if (score >= 80 && score <= 89) {
			System.out.println("B");
		} 
		else if (score >= 70 && score <= 79) {
			System.out.println("C");
		} 
		else if (score >= 60 && score <= 69) {
			System.out.println("D");
		} 
		else {
			System.out.println("F");
		}
		
		
		
		// 두 정수의 평균을 구한다.
		// 이 평균값이 50 이상이라면, "대기"를 출력하고
		// 75점 이상이라면 "합격"을 출력한다.
		// 100점 이라면 "수석 합격"을 출력한다.
		
		int numberOne = 75;
		int numberTwo = 98;
		int numberAvg = ( numberOne + numberTwo ) / 2 ;
		
		if ( numberAvg == 100 ) {
			System.out.println("수석 합격");
		}
		else if ( numberAvg >= 75 ) {
			System.out.println("합격");
		}
		else if ( numberAvg >= 50 ) {
			System.out.println("대기");
		}
		
		
		//문자열 비교문 만들기
		//char형은 거의 쓰지 않는다.
		
		String operator = "+";
		
		if ( operator.equals("+") ) {
			System.out.println("더하기를 합니다.");
		}
		
	}

}
