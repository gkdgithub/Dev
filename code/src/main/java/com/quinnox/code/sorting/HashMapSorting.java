package com.quinnox.code.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapSorting {
	
	static Map<String,Integer> hashMap=new HashMap<>();
	
	public static void main(String[] args) {
		
		hashMap.put("Jayant", 80); 
        hashMap.put("Abhishek", 90); 
        hashMap.put("Anushka", 80); 
        hashMap.put("Amit", 75); 
        hashMap.put("Danish", 40);
        
        sortByKeyNaturalOrder();
        sortByKeyNaturalOrder2();
        sortByKeyRevOrder();
        sortByKeyRevOrder2();
	}

	private static void sortByKeyNaturalOrder() {
		
		TreeMap<String,Integer> treeMap=new TreeMap<>(hashMap);
		//treeMap.putAll(hashMap);
		Set<Entry<String, Integer>> entries=treeMap.entrySet();
		Iterator<Entry<String, Integer>> itr=entries.iterator();
		while(itr.hasNext()){
			Entry<String, Integer> entry=itr.next();
			//System.out.print(entry.getKey()+" : ");
			//System.out.println(entry.getValue());
		}
	}
	
	private static void sortByKeyNaturalOrder2() {
		
		ArrayList<String> keys=new ArrayList<>(hashMap.keySet());
		Collections.sort(keys);
		for(String key:keys){
			//System.out.println(key + " : "+hashMap.get(key));
		}
	}
	
	private static void sortByKeyRevOrder(){
		
		TreeMap<String,Integer> treeMap=new TreeMap<>(Collections.reverseOrder());
		treeMap.putAll(hashMap);
		Set<Entry<String, Integer>> entries=treeMap.entrySet();
		Iterator<Entry<String, Integer>> itr=entries.iterator();
		while(itr.hasNext()){
			Entry<String, Integer> entry=itr.next();
			//System.out.print(entry.getKey()+" : ");
			//System.out.println(entry.getValue());
		}
		
	}
	
	private static void sortByKeyRevOrder2(){
		ArrayList<String> keys=new ArrayList<>(hashMap.keySet());
		Collections.sort(keys);Collections.reverse(keys);
		for(String key:keys){
			System.out.println(key + " : "+hashMap.get(key));
		}
	}

}
