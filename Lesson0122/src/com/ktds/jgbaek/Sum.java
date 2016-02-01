package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class Sum {
		
	public void getSum ( List list ){
		int sum = 0;
		for (int i =0; i<10; i++) {
			sum += (int)list.get(i);
		}
		
		System.out.println(sum);
		
	}

}
