import java.util.Scanner;

public class CelToFah {
	
	public static void main(String[] args){
		
		/**
		 *  섭씨 -> 화씨 f = (c x 1.8) + 32
		 *  화씨 -> 섭씨 c = (f - 32 ) / 1.8
		 */
		
		int typeChoice = 0;
		Scanner userInput = new Scanner( System.in );
		ConvertAtoB converter = new ConvertAtoB();
		
		// 무한 반복
		while ( true ) { 
			System.out.println("온도를 변환하는 프로그램입니다.");
			System.out.println("섭씨를 화씨로 변경하시려면 1번");
			System.out.println("화씨를 섭씨로 변경하시려면 2번");
			System.out.println("종료 하시려면 3번을 입력하세요.");
			
			typeChoice = userInput.nextInt(); // scanner 에서 next라고 하는 것은 무언가를 받아오겠다 라는 뜻.
			
			if ( typeChoice == 1 ) {
				converter.convertAndPrintCelToFah(userInput);
			}
			
			else if ( typeChoice == 2 ) {
				converter.convertAndPrintFahToCel(userInput);
			}
			
			else if ( typeChoice == 3 ) {
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		System.out.println("프로그램을 종료합니다.");
		
	}

}
