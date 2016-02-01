
public class CastingOne {
	
	public static void main(String[] args){
		
/*		// 묵시적 캐스팅
		// 2byte : short
		short shortNumber = 10;
		// 4byte : integer
		int number =shortNumber;
		// 8byte : long
		long longNumber =shortNumber;
		
		System.out.println("number is " + number);
		System.out.println("longNumber is " + longNumber );*/
		
		// 명시적 캐스팅
		// 8byte :long
		long longNumber =1000;
		// 4byte : integer
		int number = (int)longNumber;
		// 2byte : short
		short shortNumber = (short)longNumber;
		
		
		System.out.println("number is " + number);
		System.out.println("longNumber is " + shortNumber );
		
/*		shortNumber = 35;
		
		// 묵시적 캐스팅
		number = shortNumber;
		longNumber = shortNumber;
		
		System.out.println("number is " + number);
		System.out.println("longNumber is " + longNumber );*/
		
	}

}
