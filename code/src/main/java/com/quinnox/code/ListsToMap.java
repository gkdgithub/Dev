package com.quinnox.code;

import java.util.*;
public class ListsToMap {
  static public void main(String[] args) {
    List<String> names = Arrays.asList("apple,orange,pear".split(","));
    List<String> things = Arrays.asList("123,456,789".split(","));
    Map<Integer,Object[]> map = new LinkedHashMap<Integer,Object[]>();  
    
    /*Iterator<String> i1 = names.iterator();
    Iterator<String> i2 = things.iterator();
    while (i1.hasNext() && i2.hasNext()) {
        map.put(i1.next(), i2.next());
    }
*/    
    int count=1;
    for (int i=0; i<names.size(); i++) {
      map.put(count++,new Object[]{names.get(i), things.get(i)});
    }

    Set<Integer> keyset = map.keySet();
    int rownum = 0;
    for (Integer key : keyset)
    {
        
        Object [] objArr = map.get(key);
	        for (Object obj : objArr)
	        {
	           System.out.println(obj+"==============");
	        }
    }
  }
}
