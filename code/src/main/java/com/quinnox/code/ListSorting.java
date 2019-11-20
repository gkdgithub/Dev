package com.quinnox.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorting {
		
		public static void main(String[] args) {
				List<Integer> list= new ArrayList<>();
				list.add(567);
				list.add(299);
				list.add(800);
				list.add(80);
				
				// By Default sorting
				Collections.sort(list);
				System.out.println(list);
				
				// Custom Sorting
				Collections.sort(list, new ListSort());
				System.out.println(list);
		}
		
static class ListSort implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	
	}
}
