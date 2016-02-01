
public class Array2Test {
	
	public static final int TEAM_COUNT = 5;
	public static final int TEAM_PERSON= 6;
	
	public static void main(String[] args) {
		
//		java.util.Scanner scanner = new java.util.Scanner(System.in);
//		scanner.nextInt();
		
//		Scanner hello= new Scanner();
//		hello.sayHello();
//	

		String students[][] = new String[TEAM_COUNT][TEAM_PERSON];
		
		students[0][0] = "황소리";
		students[0][1] = "공정민";
		students[0][2] = "구본호";
		students[0][3] = "문석현";
		students[0][4] = "엄기표";
		students[0][5] = "문석현";
		
		students[1][0] = "이람";
		students[1][1] = "배성진";
		students[1][2] = "전민정";
		students[1][3] = "조형근";
		students[1][4] = "황성재";
		students[1][5] = "김장호";
		
		students[2][0] = "김현섭";
		students[2][1] = "권순길";
		students[2][2] = "김동규";
		students[2][3] = "김하늘";
		students[2][4] = "양지한";
		students[2][5] = "남준호";
		
		students[3][0] = "김광민";
		students[3][1] = "백지경";
		students[3][2] = "이기연";
		students[3][3] = "조민제";
		students[3][4] = "유병훈";
		
		students[4][0] = "이승섭";
		students[4][1] = "백수경";
		students[4][2] = "안신미";
		students[4][3] = "오평화";
		students[4][4] = "김연";
		
/*		int teamCount = students.length;
		int studentCount = 0;
		
		for ( int i=0; i<teamCount; i++ ){ //몇 번째 배열에 있는지 알고싶을때 쓴다.
			//System.out.println(students[i].length);
			studentCount = students[i].length;
			for( int j = 0; j<studentCount; j++ ){
				System.out.println(i+" "+j+" "+students[i][j]);
			}
		}*/
		
		for ( String[] team : students ) { 
			
			for ( String person : team ) {
				
				System.out.println( person );
			}
			
			System.out.println("==================");
			
		}
		
	}
	
}
