package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class Average {
		
	public void getAverage ( List list ){
		
		int sum = 0;
		double average = 0;
		
		for (int i =0; i<10; i++) {
			sum += (int)list.get(i);
		}
		average = sum/(double)list.size();
		
		System.out.println(average);
		
	}

}

