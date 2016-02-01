import java.util.Scanner;

public class FiveNumberAsc {
	public static void main(String[] args) {

		int number[] = new int[5];
		
		Scanner userInput = new Scanner(System.in);
		
		
		String state = "";

		while (true) {

			System.out.println("<숫자 정렬 프로그램>");
			System.out.println("오름차순 정렬을 원하시면 asc를");
			System.out.println("내림차순 정렬을 원하시면 desc를");
			System.out.println("종료를 원하시면 exit를 입력해주세요.");
			state = userInput.next();

			if (state.equalsIgnoreCase("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}

			else {
				System.out.println("숫자 5개를 입력해주세요.");

				for (int i = 0; i < 5; i++) {
					System.out.print(i + 1 + " : ");
					number[i] = userInput.nextInt();
				}

				if (state.equalsIgnoreCase("asc")) {

					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (number[j] > number[j + 1]) {
								int tmp = number[j];
								number[j] = number[j + 1];
								number[j + 1] = tmp;
							}
						}
					}
				}

				else if (state.equalsIgnoreCase("desc")) {

					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (number[j] < number[j + 1]) {
								int tmp = number[j];
								number[j] = number[j + 1];
								number[j + 1] = tmp;
							}
						}
					}
				}

				System.out.print(state + " -> ");
				for (int numbers : number)
					System.out.print(numbers);
				System.out.println("\n");
			}
		}
	}
}
