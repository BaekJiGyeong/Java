package com.ktds.jgbaek;

public class Market {
	
	private int appleCount = 15; // 인스턴스만 쓸 수 있는 필드 ( 인스턴스 필드 )
	private int money = 4000;
	
	public static final int APPLE_PRICE = 500; // 상수 ( 클래스 필드 (static) )
	
	// 진짜 로직은 start에 들어감
	public void start(){
		
		Customer 김광민 = new Customer();
		김광민.setMoney(5300);
		김광민.setAppleCount(0);
		
		while ( true) {
		
			if ( this.appleCount == 0 || 김광민.getMoney() < Market.APPLE_PRICE ) {
				System.out.println("안 팔아요.");
				break;
			}
			
			// 소비자에게 돈을 받는다.
			김광민.pay(1000);
			this.money += 1000;
			
			// 소비자에게 사과를 준다.
			this.appleCount -= 1;
			김광민.getApple(1);
			
			// 거스름돈을 남겨 준다.
			int money = 1000 - ( Market.APPLE_PRICE * 1 );
			this.money -= money;
			김광민.takeMoney(money);
			
			// 소비자의 정보를 출력한다.
			김광민.printMyInfo();
		}
		
	}
	
	// 앞으로 메인문은 이렇게 쓸것
	// 메인은 제일 밑으로
	public static void main(String[] args){
		
		Market market = new Market();
		market.start();
		
	}

}
