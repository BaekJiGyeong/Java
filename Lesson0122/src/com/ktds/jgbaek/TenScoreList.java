package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TenScoreList {

	public void start() {

		List<Integer> score = new ArrayList<Integer>();
		Sum sum = new Sum();
		Average average = new Average();
		Level level = new Level();
				
		while (true){
			System.out.println("10개의 점수를 입력해주세요");
			try {
				Scanner userInput = new Scanner(System.in);
				for (int i = 0; i < 10; i++) {
					score.add(userInput.nextInt());
				}
				break;
			} 
			catch (InputMismatchException ime) {
				System.out.println("잘못 입력하셨습니다. 정수만 입력할 수 있어요.");
				System.out.println(ime.getClass().getName()+"예외가 " + ime.getMessage() + "때문에 발생했습니다.");
				Scanner userInput = new Scanner(System.in);
			}
		}

		System.out.println("합계");
		sum.getSum(score);
		System.out.println("평균");
		average.getAverage(score);
		System.out.println("학점");
		level.getLevel(score);

	}

	public static void main(String[] args) {

		TenScoreList list = new TenScoreList();
		list.start();

	}
}
