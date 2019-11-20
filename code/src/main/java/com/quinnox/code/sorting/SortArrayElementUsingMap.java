package com.quinnox.code.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortArrayElementUsingMap {

	public static void main(String[] args) {
		
		// Sorting array based on its length using map
		String[] str={"Quinnox","I","From","Am"};
		sort(str,str.length);
		
	}

	private static void sort(String[] str, int length) {
		
		TreeMap<String,Integer> treeMap=new TreeMap<String,Integer>();
		for(String str2:str){
			if(!(treeMap.containsKey(str2))){
				treeMap.put(str2, str2.length());
			}
		}
		//System.out.println(treeMap);
		
		ArrayList<Entry<String,Integer>> list=new ArrayList<>(treeMap.entrySet());
		Collections.sort(list, new SortStrLengthComp());
		
		for(Entry<String,Integer> entry:list){
			System.out.println(entry.getKey());
			//System.out.println(entry.getValue());
		}
	}

}

class SortStrLengthComp implements Comparator<Entry<String,Integer>>{

	@Override
	public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
		
		return (entry1.getValue()).compareTo(entry2.getValue());
	}
	
}
