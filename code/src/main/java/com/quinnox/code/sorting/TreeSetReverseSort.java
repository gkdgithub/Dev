package com.quinnox.code.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetReverseSort {

	public static void main(String[] args) {
		
		 //Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
		 Set<Integer> set = new TreeSet<>();
		    set.add(10);
		    set.add(20);
		    set.add(7);
		    set.add(4);
		    set.add(1);
		    set.add(2);
		    set.add(3);
		    set.add(4);
		    System.out.println(set);
		    
		/*List<Integer> list=new ArrayList<>(set);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);*/
		    
		/*List<Integer> list=new ArrayList<>();
		list.addAll(set);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);*/
		
	}

}
