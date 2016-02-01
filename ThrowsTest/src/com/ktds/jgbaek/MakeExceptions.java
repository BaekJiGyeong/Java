package com.ktds.jgbaek;

public class MakeExceptions {
	/**
	 * 문자를 숫자로 변환한다. 만약, 예외상황이 발생하면 적절한 조치를 취해준다.
	 * 
	 * @param str
	 * @return
	 */
	public int parseInt(String str) {

		try {
			return Integer.parseInt(str);
		}

		catch (NumberFormatException nfe) {
			return 0;
		}

	}

	/**
	 * 문자를 숫자로 변환한다. 만약, 예외상황이 발생하면 적절한 조치를 취하지 않는다.
	 * 
	 * @param str
	 * @return
	 * @throws NumberFormatException
	 */
	public int parseInt2(String str) throws NumberFormatException { // throw 뒤에책임전가
		return Integer.parseInt(str);
	}

	public int parseInt3(String str) 
	{
		try {
			return Integer.parseInt(str);
		} 
		catch (NumberFormatException nfe) {
			System.out.println(str + "은 숫자로 바꿀 수 없습니다!!");
			// throw nfe;
			invalidNumberException ine = new invalidNumberException(str + "은 숫자로 바꿀 수 없습니다!!");
			throw ine;
		}
	}
}
