/*->The Intuition is use a stack.
->Traverse through the string,if there is any opening bracket ,then push into the stack.
->If the char is closing bracket,then pop out the char from stack and check if both are opposite brackets,if yes continue traversing,else return false.
->After the completion of string traversal, check if stack is empty or not,if it is empty hence it is a balanced string,return True, else return false.
-TC: O(N) : SC:O(N).
*/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> openSt= new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(c=='(' || c=='{' || c=='[')
            {
                openSt.push(c);
                
            }else{
                if(openSt.isEmpty())//edge case,where the string is starting with a closed bracket.
                    return false;
                char ch=openSt.pop();
                
                if ( (c==')' && ch=='(') || (c=='}' && ch=='{') || (c==']' && ch=='[') )
                {
                    continue;
                }else{
                    
                    return false;
                }
            }
        }
     
        return (openSt.isEmpty()) ? true : false;
    }
}