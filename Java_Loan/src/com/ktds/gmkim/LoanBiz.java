package com.ktds.gmkim;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LoanBiz {

	public static final int MAX_AVAILABLE_LOAN_MONEY = 100000000;

	private Calendar cal;
	private LoanVO vo;
	private LoanInput in;
	
	private List<LoanVO> list;
	private String name;
	
	private long bankMoney;
	private long money;
	private long result;
	
	private int choice;
	
	/**
	 * 기본 생성자
	 */
	public LoanBiz() {

		cal = Calendar.getInstance();
		vo = new LoanVO();
		in = new LoanInput();
		list = new ArrayList<LoanVO>();
		name = "";
		bankMoney = 1000000000L;
		money = 0L;
		choice = 0;
		result = 0;
	}

	/**
	 * 프로그램 시작
	 */
	public void startProgram() {

		while (true) {
			
			// 메뉴 출력
			System.out.println("대출 1번, 상환 2번, 파산 3번, 종료 0번");

			// 메뉴 입력
			choice = in.inputInt();

			if (choice == 1) {
				
				vo = new LoanVO();
				
				// 은행이 돈이 있는지 확인
				if (this.bankMoney <= 0) {
					System.out.println("은행 돈 없음");
					continue;
				}

				System.out.println("은행 보유 자금 : " + this.bankMoney);
				
				// 정보 입력 
				System.out.println("당신의 이름, 보유자금, 전화번호, 담보, 대출금액을 순서대로 입력하세요.");
				
				vo.setName( in.inputString() );
				vo.setMoney(in.inputLong());
				vo.setPhoneNumber( in.inputString() );
				vo.setSecurity( in.inputString() );
				
				// 빌릴돈 입력
				this.money = in.inputLong();
				
				// 빌릴돈 + 빌린돈이 1억 넘으면 거절
				if ( (this.money + vo.getLoanMoney()) > 100000000 ) {
					System.out.println("1억 이상 빌릴 수 없음");
					continue;
				}

				// 현재 시간 밀리세컨드 등록
				vo.setMil( cal.getTimeInMillis() );
				
				// 유저 돈 증가
				vo.addMoney(money);
				
				// 유저 빌린 돈 입력
				vo.setLoanMoney(money);
				
				// 은행 돈 감소
				this.bankMoney -= vo.getLoanMoney();

				// 리스트에 유저 인스턴스 등록
				this.list.add(vo);
			}
			else if (choice == 2) {

				vo = new LoanVO();
				
				// 이름 입력
				System.out.println("이름을 입력하세요.");
				this.name = in.inputString();
				
				// 이름에 맞는 인스턴스 vo에 입력
				for (LoanVO loanVO : list) {
					if ( this.name.equals(loanVO.getName()) ) {
						vo = loanVO;
					}
				}
				
				// 해당 사람 있는지 확인
				if ( !this.list.contains(vo) ) {
					System.out.println("그런사람은 대출한적 없어요.");
					continue;
				}
				
				// 상환할 돈 계산
				result = (long)( vo.getLoanMoney() * Math.pow(1.1, Math.round((cal.getTimeInMillis() - vo.getMil()) / 1000 / 5))) ;
				
				System.out.println("상환해야 할 돈 : " + result + "원");
				
				// 유저가 상환할 돈 있는지 확인
				if ( vo.getMoney() < vo.getLoanMoney() ) {
					System.out.println("답이 없습니다. 파산 하세요.");
					continue;
				}
				
				// 상환
				this.bankMoney += vo.getLoanMoney();

				// 해당 인스턴스 리스트에서 제거
				this.list.remove( vo );
				System.out.println("상환 되셨습니다.");
			}
			else if (choice == 3) {
				
				vo = new LoanVO();
				
				// 이름 입력
				this.name = in.inputString();
				
				// 이름에 맞는 인스턴스 vo에 입력
				for (LoanVO loanVO : list) {
					if ( this.name.equals(loanVO.getName()) ) {
						vo = loanVO;
					}
				}
				
				// 해당 사람 있는지 확인
				if ( !this.list.contains(vo) ) {
					System.out.println("그런사람은 대출한적 없어요.");
					continue;
				}
				
				// 해당 인스턴스 리스트에서 제거
				this.list.remove( vo );
				
				System.out.println("파산신청 되었습니다.");
			}
			else if (choice == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("다시 입력하세요.");
			}
		}
	}
}
