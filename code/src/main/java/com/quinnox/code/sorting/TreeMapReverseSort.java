package com.quinnox.code.sorting;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapReverseSort {

	public static void main(String[] args) {
		
		// Sorting based on key but in reverse order
		Map<Integer, String> treemap=new TreeMap<Integer, String>(Collections.reverseOrder());
		
		treemap.put(1, "Welcome"); 
        treemap.put(2, "to"); 
        treemap.put(3, "the"); 
        treemap.put(4, "Geeks"); 
        treemap.put(5, "Community");
        
        Iterator<Entry<Integer, String>> itr=treemap.entrySet().iterator();
        while(itr.hasNext()){
        	Entry<Integer, String> entry=itr.next();
        	System.out.print(entry.getKey() + " : ");
        	System.out.println(entry.getValue());
        }
	}

}
