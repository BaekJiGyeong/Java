import java.util.Scanner;

public class TenScoreAverage {

	public static void main(String[] args) {
		// 배열로 점수 10개 받아와서 평균내기

		System.out.println("<점수 10개 평균내기 프로그램>");
		System.out.println("점수 10개를 입력하시오");

		Scanner userInput = new Scanner(System.in);
		int score[] = new int[10];
		int scoreSum = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print(i + 1 + " : ");
			score[i] = userInput.nextInt();
		}

		for (int i = 0; i < score.length; i++) {
			scoreSum = scoreSum + score[i];
		}

		double scoreAvg = scoreSum / 10;
		System.out.println("Average : " + scoreAvg);

	}

}