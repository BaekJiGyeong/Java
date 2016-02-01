import java.util.Scanner;

public class Lesson0113 {

	public static void main(String[] args) {

		// 체질량 지수 계산해서 출력하기
		// 몸무게 / (키 * 키)

		double cejil;
		double height, weight;

		Scanner console = new Scanner(System.in);
		System.out.println("당신의 키는? ");
		height = console.nextInt();

		Scanner console2 = new Scanner(System.in);
		System.out.println("당신의 무게는? ");
		weight = console2.nextInt();

		cejil = weight / (height * height);

		System.out.println("당신의 체질량 지수는 " + cejil + "입니다. \n");

		// 화씨온도를 섭씨온도로 변환해서 출력하기
		// (화씨온도 -32) / 1.8

		System.out.println("화씨온도 -> 섭씨온도 ");

		double f, c;
		Scanner console3 = new Scanner(System.in);
		System.out.println("화씨온도 :");
		f = console3.nextInt();
		c = (f - 32) / 1.8;
		System.out.println("변환된 섭씨온도 :" + c);

		// 섭씨온도를 화씨온도로 변환해서 출력하기
		// (1.8*섭씨온도)+32
		System.out.println("\n");
		System.out.println("섭씨온도 -> 화씨온도 ");

		double f1, c1;
		Scanner console4 = new Scanner(System.in);
		System.out.println("섭씨온도 :");
		c1 = console4.nextInt();
		f1 = (1.8 * c1) + 32;
		System.out.println("변환된 화씨온도 :" + f1);
		
	}

}
