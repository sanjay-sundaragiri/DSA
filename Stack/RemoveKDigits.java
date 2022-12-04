/*
->Create a Stack and insert each number in it, Simultaneously,check if there are greater integers in stack than current integer, if yes,then pop number from stack until k values.
->pop out each number from stack add it to the resultant String.
->return the string.
TC:O(n*k) ,SC:O(N).
*/
class Solution {
    public String removeKdigits(String num, int k) {
        int len= num.length();
        if(k==len)
        {
            return "0";
        }
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<len)
        {
            while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        
        while(k>0)
        {
            st.pop();
            k--;
        }
        
        StringBuilder sb=  new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        
        
        while(sb.length()>1 && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        
        
        
        return sb.toString();
    }
}