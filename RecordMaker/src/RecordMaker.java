import java.util.Scanner;

public class RecordMaker {
	public static void main(String[] args) {
		System.out.print("java Record Maker ");
		Scanner userInput = new Scanner(System.in);
		int count = userInput.nextInt();

		int employeeNum = 0;
		int list[] = new int[count];
		String employeeId = "";
		int score = 0;
		for(int i=0; i<count; i++){
			employeeNum = (int) (Math.random()*100000);
			for (int j : list) {
				int printed = list[j];
				if(printed==employeeNum){
					employeeNum = (int) (Math.random()*100000);
				}
			}
			employeeId = lpad(employeeNum+" ",6,"0");

			score = (int) (Math.random()*100);

			System.out.println(employeeId + " " + score);

		}
	}

	public static String lpad(String source, int length, String defValue) {

		int sourceLength = source.length();
		int needLength = length - sourceLength;

		for (int i = 0; i < needLength; i++) {
			source = defValue + source;
		}

		return "NT" + source;
	}

}
