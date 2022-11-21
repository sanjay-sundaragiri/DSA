/*Create a map as key stores the sorted string of each string from strs[],and value stores a List[] of same string that matches after sorting it.
->Then traverse through the List of strings from map,and store each list of strings into the resultant List[].

-TC:O(N)+O(N) , SC:O(N).
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>res= new ArrayList<>();
        Map<String,List<String>>map= new HashMap<>();
        
        for(String temp : strs)
        {
            char[]ch= temp.toCharArray();
            Arrays.sort(ch);
            String s=new String(ch);
            if(map.containsKey(s))
            {
                map.get(s).add(temp);
            }else{
                map.put(s,new ArrayList<>());
                map.get(s).add(temp);
            }
        }
      //  System.out.println(map);
        for(List<String> t : map.values())
        {
            List<String>temp= new ArrayList<>();
            for(String s : t)
            {
                temp.add(s);
            }
            res.add(temp);
        }
        return res;
    }
}