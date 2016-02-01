
public class CastingThree {

	public static void main(String[] args){
		
		double numberOne = 100000.12546;
		short numberTwo = (short) numberOne;
		System.out.println(numberTwo);
		
		int numberThree = (int)numberOne;
		System.out.println(numberThree);
		
		char chr = 'A';
		System.out.println(chr);
		char chrTwo = 66;
		System.out.println(chrTwo);
		char chrThree = (char)(chr +1);
		System.out.println(chrThree);
		
		
	}
}
