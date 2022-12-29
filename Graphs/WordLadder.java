class Pair
{
    String first;
    int second;
    Pair(String f,int s)
    {
        first=f;
        second=s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //SC: O(2N)
        //insert all the words into set.
        Set<String>set= new HashSet<>();
        for(String s: wordList)
        {
            set.add(s);
        }

        Queue<Pair>q= new LinkedList<>();
        q.add(new Pair(beginWord,1));

        set.remove(beginWord);//remove the startWord from set,so that we don't traverse back again to same string.
        //O(N)*10*26.
        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int steps=q.peek().second;
            q.remove();

            if(word.equals(endWord)) 
               return steps;
            //O(10*26).
            for(int i=0;i<word.length();i++)
            {
                //replace a-z At each index of he word.
                for(char c='a';c<='z';c++)
                {
                    char[] c_Ar= word.toCharArray();
                    c_Ar[i]=c;    //replacing a-z in string.
                    String replacedWord= new String(c_Ar);
                    if(set.contains(replacedWord)) //check  String after replacing each char 
                    {
                        //add into queueand increase the lvel by 1.
                     q.add(new Pair(replacedWord,steps+1));

                     set.remove(replacedWord);
                    }

                }
            }

        }

        return 0;
    }
}