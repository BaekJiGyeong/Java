package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class Level {

	public void getLevel(List list) {

		int sum = 0;
		double average = 0;
		String level = "";

		for (int i = 0; i < 10; i++) {
			sum += (int) list.get(i);
		}
		average = sum / list.size();

		if (average >= 9) {
			level = "A";
		} 
		else if (average >= 8) {
			level = "B";
		} 
		else if (average >= 7) {
			level = "C";
		} 
		else if (average >= 6) {
			level = "D";
		} 
		else {
			level = "F";
		}

		System.out.println(level);

	}

}
