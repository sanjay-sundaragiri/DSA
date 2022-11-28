


class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> l1= new ArrayList<>();
       // int[] ar1= new int[matches.length];
        int a=0;
        Set<Integer> set1= new HashSet<>();
          Set<Integer> set2= new HashSet<>();
        
          Map<Integer,Integer> map1= new HashMap<>();
        for(int i=0;i<matches.length;i++)
        {
            set1.add(matches[i][0]);
             set2.add(matches[i][1]);
            
            map1.put(matches[i][1],map1.getOrDefault(matches[i][1],0)+1);
        }
      //  System.out.println(set1);
      //  System.out.println(set2);
        for(int i : set1)
        {
            if(!set2.contains(i))
            {
                l1.add(i);
            }
        }
      //  System.out.println(l1);
        Collections.sort(l1);
        
       List<Integer>l2= new ArrayList<>();
        for(Map.Entry<Integer,Integer> m: map1.entrySet())
        {
            if(m.getValue()==1)
            {
                l2.add(m.getKey());
            }
        }
      // System.out.println(l2);
        Collections.sort(l2);
        list.add(l1);
        list.add(l2);
        
        return list;
    }
}