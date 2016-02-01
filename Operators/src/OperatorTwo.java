public class OperatorTwo {
	public static void main(String[] args) {

		double floatnumber1 = 10.5;
		double floatnumber2 = 17.7;
		double floatnumber3 = 9.98;

		boolean result = floatnumber1 != floatnumber2;
		System.out.println(result);

		boolean result2 = floatnumber2 == floatnumber3;
		System.out.println(result2);
		
		boolean result3 = floatnumber1 < floatnumber2 || floatnumber2 <floatnumber3;
		System.out.println(result3);
	}
}   