package com.quinnox.code.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapSortByValue {

	public static void main(String[] args) {
		
		TreeMap<String,Integer> treeMap=new TreeMap<>();
		treeMap.put("Math", 98); 
        treeMap.put("Data Structure", 85); 
        treeMap.put("Database", 91); 
        treeMap.put("Java", 95); 
        treeMap.put("Operating System", 79); 
        treeMap.put("Networking", 80);
        
        ArrayList<Entry<String, Integer>> arrayList=new ArrayList<>(treeMap.entrySet());
        Collections.sort(arrayList, new SortByValueComp());
        
        for(Entry<String, Integer> entry:arrayList){
        	System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        
	}

}

class SortByValueComp implements Comparator<Entry<String,Integer>>{

	@Override
	public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
		return (entry1.getValue()).compareTo(entry2.getValue());
		
		// Reverse order
		//return -(entry1.getValue()).compareTo(entry2.getValue());
	}
	
}
