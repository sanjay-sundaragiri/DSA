
//User function Template for Java
//refer to word ladder 1.
class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String>set= new HashSet<>();
        for(String s: wordList)
        {
            set.add(s);
        }
        ArrayList<String>t= new ArrayList<>();
        t.add(startWord);
        
       Queue<ArrayList<String>>q= new LinkedList<>();
        q.add(t);
        
        ArrayList<String>usedOnLevel= new ArrayList<>();
        usedOnLevel.add(startWord);
        
        int level=0;
        ArrayList<ArrayList<String>>ans= new ArrayList<>();
        while(!q.isEmpty())
        {
            ArrayList<String>ls= q.poll();
            //erase all the words that are used in the previous level.
            if(ls.size()>level)
            {
                level++;
                for(String s : usedOnLevel)
                {
                    set.remove(s);
                }
            }
            
            String word = ls.get(ls.size()-1);
            //if matches.
            if(word.equals(targetWord))
            {
                if(ans.size()==0)
                {
                    ans.add(ls);
                    
                }
                else if(ans.get(0).size()==ls.size())
                {
                    ans.add(ls);
                }
            }
            for(int i=0;i<word.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char[] c_Ar= word.toCharArray();
                    c_Ar[i]=c;
                    
                    String replacedWord = new String(c_Ar);
                    if(set.contains(replacedWord))
                    {
                        ls.add(replacedWord);
                        
                        ArrayList<String>temp= new ArrayList<>(ls);
                        q.add(temp);
                        
                        //mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        ls.remove(ls.size()-1);
                    }
                }
            }
            
            
        }
        return ans;
    }
}