package com.quinnox.code;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ReverseStringOnPlace {

	public static void main(String[] args) {
		
		
		InputStream source=System.in;
		
		System.out.println("Enter The String : ");
		Scanner scanner=new Scanner(source);
		
		String str=scanner.nextLine();	
		String[] names=str.split(" ");
		
		// printing normal reverse
		/*String revString=new StringBuffer(str).reverse().toString();
		System.out.print(revString);*/
		
		
		// 1 way
/*		for(String name:names){
			StringBuffer stringBuffer=new StringBuffer(name);
			System.out.print(stringBuffer.reverse()+" ");
		}*/
		
		
		// 2nd way
/*		String reverseString="";
		for(String name:names){
			reverseString=new StringBuffer(name).reverse().toString();
			System.out.print(reverseString+" ");
		}*/
		
		// 3rd way
		TreeMap<Integer,String> treeMap=new TreeMap<>();
		int count=1;
		for(String name:names){
			treeMap.put(count++, name);
		}
		//System.out.println(treeMap);
		
		Set<Integer> keys=treeMap.keySet();
		//System.out.println(keys);
		Iterator<Integer> itr=keys.iterator();
		while(itr.hasNext()){
			int key=itr.next();
			//System.out.println(key);
			System.out.print(new StringBuffer(treeMap.get(key)).reverse().toString()+" ");
		}
		
	}

}
