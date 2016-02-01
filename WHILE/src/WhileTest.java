import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {

		int i = 0;
		while (i < 10) { 

			System.out.println(i);
			i++;

		}
		
		Scanner input = new Scanner(System.in);
		String inputValue = "";

		boolean isRunning = true;
		while (isRunning) {

			System.out.println("출력중.. 종료 하려면 exit를 입력하세요.");
			inputValue = input.next();

			if (inputValue.equalsIgnoreCase("exit")) { //equalsIgnoreCase 는 대소문자 안가림
				isRunning = false;
			}

		}
			
	}

}
