import java.util.Scanner;

public class Lesson03 { // 클래스 선언

	public static void main(String[] args) {

		String name = "";

		Scanner console = new Scanner(System.in);
		System.out.println("이름을 입력하세요 .");
		name = console.nextLine();

		System.out.println(name + "님, 안녕하세요!");

	}
}