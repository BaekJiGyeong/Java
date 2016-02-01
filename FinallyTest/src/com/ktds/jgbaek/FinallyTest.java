package com.ktds.jgbaek;

public class FinallyTest {
		public void start() {
			
			try {
			int number = Integer.parseInt("123");
			
			String str = null; // 메모리가 없는데(인스턴스가 아닌데) 인스턴스 실행하려함
			str.length(); // NullPointerException
			
			System.out.println(number);
			}
			catch(NumberFormatException | NullPointerException nfe) {
				System.out.println("숫자 변환에 실패했습니다. "+nfe.getMessage());
				
				if ( nfe instanceof NumberFormatException ) {
					System.out.println("숫자변환을 할 수 없습니다.");
				}
				else if ( nfe instanceof NullPointerException ) {
					System.out.println("잘못된 참조입니다.");
				}
				
			}
			
//			catch(NullPointerException npe) {
//				System.out.println("잘못된 참조입니다. 객체가 null이 아닌지 확인하세요.");
//			}
			finally {
				System.out.println("숫자 변환을 종료합니다."); // 에러가 나든 안나든 finally 꼭실행
			}
			}
	public static void main(String[] args) {
		FinallyTest test = new FinallyTest();
		test.start();
		
//		this.start(); static이 있어서 안됨

	}

}
