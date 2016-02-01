import java.util.Scanner;

public class ConvertAtoB {

	public void convertAndPrintCelToFah(Scanner userInput){
		
		System.out.println("섭씨를 화씨로 변경합니다.");
		System.out.println("섭씨를 입력해주세요.");
		int cel = userInput.nextInt();
		double fah = ( cel * 1.8 ) + 32 ;
		System.out.println("섭씨" + cel + "도는 화씨" + fah + "도 입니다.");		
	}
	
	public void convertAndPrintFahToCel(Scanner userInput){
		System.out.println("화씨를 섭씨로 변경합니다.");
		System.out.println("화씨를 입력해주세요.");
		int fah = userInput.nextInt();
		double cel = ( fah - 32) /1.8;
		System.out.println("화씨" + fah + "도는 섭씨" + cel + "도 입니다.");
	}
}
