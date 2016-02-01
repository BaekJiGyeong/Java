
public class SwitchTest {
	public static void main(String[] args) {

		int numberOne = 1;

		switch (numberOne) { // 비교, 논리식 X  산술식 O
		case 1: // numberOne이 1 이라면
			System.out.println("numberOne의 값은 1입니다.");
			break;
		case 2: // numberOne이 2 이라면
			System.out.println("numberOne의 값은 2입니다.");
			break;
		case 3: // numberOne이 3 이라면
			System.out.println("numberOne의 값은 3입니다.");
			break;
		default:
			System.out.println("numberOne의 값은 알 수 없습니다.");
			break;
		}

		if ( numberOne == 1 ) {
			System.out.println("numberOne의 값은 1입니다.");			
		}
		else if ( numberOne == 2 ) {
			System.out.println("numberOne의 값은 2입니다.");			
		}
		else if ( numberOne == 3 ) {
			System.out.println("numberOne의 값은 3입니다.");			
		}
		else {
			System.out.println("numberOne의 값은 알 수 없습니다.");
		}
		
		
	}
}
