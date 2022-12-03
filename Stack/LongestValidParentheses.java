class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0 || s.length()<2)
            return 0;
        
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(i);
            }
            else{
                //closing bracket
                if(!st.isEmpty() && s.charAt(st.peek())=='(' )
                {
                    st.pop();
                }
               else{
                    st.push(i);
                }
               
            }
        }
        
        System.out.println(st);
        
        int endTerminal=s.length();
        int max=0;
        while(!st.isEmpty())
        {
            int start=st.pop();
            max= Math.max(endTerminal-start-1 ,max );
            endTerminal= start;
        }
        
        return Math.max(max, endTerminal);
    }
}