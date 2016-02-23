import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelloWorld {

	public static void main(String[] args) {
		
//		System.out.println("Hello World!");
//		System.out.println(10);
//		System.out.println(10.0);
//		System.out.println('a');
//		System.out.println("JAVA");
//		System.out.println(true);
//		System.out.println('A'+1);
//		
//		System.out.print("\n");
//		
//		System.out.println(10+20);
//		System.out.println(10.0+30);
//		System.out.println(10-5);
//		System.out.println(50*2);
//		System.out.println(10/2);
//		System.out.println("Hello, " + "World");
//		System.out.println("Java" + 8);
//		System.out.println("10 + 5" +10 +5 );
		
		File file = new File("D:\\배우들.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			String[] actors = null;
			
			String query = "INSERT INTO ACTOR_LIST ( ACTOR_LIST_ID, MOVIE_ID, ACTOR_ID) ";
			query += "VALUES (ACTOR_LIST_ID_SEQ.NEXTVAL, '%d', ";
			query += "(SELECT ACTOR_ID FROM ACTOR WHERE ACTOR_NAME = '%s')); \n";
			
			int movieId = 0;
			
			while((line = reader.readLine()) != null) {
				
				movieId++;
				if ( movieId >= 11) {
					break;
				}
				
				actors = line.split(",");
				for ( int i = 0; i< actors.length; i++) {
					actors[i] = actors[i].trim();
					System.out.printf(query, movieId, actors[i]);
				}
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
}



