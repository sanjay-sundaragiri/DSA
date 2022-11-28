/*The Intuition is, use 2 stacks to implement the queue using stack.


 * -To push the elements into queue, directly push into inputStack.
 * -To pop the elements from the queue,check if outputStack is empty or not,if it not empty then pop 
 * the element from the outputStack.If it is empty then push all the elements from inputStack into
 * outputStack and then pop the element from outputStack.
 * -To find the top the Queue, follow the same approach as discussed for pop(),but do not delete the 
 * element as pop() do, just return the top of the outputStack.
 * TC:O(1), SC:(2N)~=O(N).
 * */
import java.util.*;
class QueueU
{ 
	Stack<Integer>inputS= new Stack<>();
	Stack<Integer>outputS= new Stack<>();
	
	void push(int x)
	{
	    inputS.push(x);
	}
	
	int pop()
	{
		if(!outputS.isEmpty())
		{
			return outputS.pop();
		}else {
			
			while(!inputS.isEmpty())
			{
				outputS.push(inputS.pop());
				
			}
			
			return outputS.pop();
		}
	}
	
	
	int peek()
	{
		if(!outputS.isEmpty())
		{
			return outputS.peek();
		}else {
			
			while(!inputS.isEmpty())
			{
				outputS.push(inputS.peek());
				inputS.pop();
			}
			
			return outputS.peek();
		}
	}
}


public class QueueImplementaionUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       QueueU q = new QueueU();
       q.push(1);
       q.push(2);
       q.push(3);
       q.push(4);
       
       System.out.println(q.pop());
       System.out.println(q.peek());
       
	}

}
