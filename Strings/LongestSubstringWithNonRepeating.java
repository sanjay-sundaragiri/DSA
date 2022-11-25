/*Use a HashSet to store  distinct characters.
->if the ith char is not present in set,then add into HashSet,and update the set size into the max.
->if the ith char already present in set,then delete the char from the set.
-TC:O(N), SC:O(N).

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1)
        {
            return 0;
        }
        if(s.length()==1)
        {
            return 1;
        }
        Set<Character>set= new HashSet<>();
        int max= Integer.MIN_VALUE;
       int j=0,i=0;
        while(j<s.length())
        {
            if(!set.contains(s.charAt(j)))
            {
               set.add(s.charAt(j++));
                max= Math.max(set.size(),max); 
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}