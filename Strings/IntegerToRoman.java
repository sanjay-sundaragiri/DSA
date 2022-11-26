import java.util.*;
class Solution {
    public String intToRoman(int num) {
        
        Map<String,Integer> mp= new LinkedHashMap<String,Integer>();
    //initially we store roman numerals into a map.  
        mp.put("M",1000);
        mp.put("CM",900);
        mp.put("D",500);
        mp.put("CD",400);
        mp.put("C",100);
        mp.put("XC",90);         
        mp.put("L",50);
        mp.put("XL",40);
        mp.put("X",10);
        mp.put("IX",9);
        mp.put("V",5);
        mp.put("IV",4);
        mp.put("I",1);
        
        StringBuilder sb= new StringBuilder();
        
        for(Map.Entry<String,Integer> m: mp.entrySet())
        {
            //for each iteration we'll check if the num is greater than or equal with the value in map.
             while(num>=m.getValue())  
            {
                num=num-m.getValue();     
                sb.append(m.getKey());  //if equal then append the key to the string
            }
        }
        
        return sb.toString();
        
    }
}