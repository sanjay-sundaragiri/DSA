
/*The Approach is push the data into queue, and traverse upto 1 less than the size of the queue
 and   push the ele into queue and pop the data simultaneously.
 * This will give you the structure as same as stack.
 * 
 * */
import java.util.*;

 class StackU
{
	 Queue<Integer>  q= new LinkedList<>();
	 
	void push(int x)
	{
		q.add(x);
		for(int i=0;i<q.size()-1;i++)
		{
			q.add(q.peek());
			q.poll();
		}
	}
	
	int pop()
	{
		return q.poll();
	}
	
	int peek()
	{
		return q.peek();
	}
	
	void print()
	{
		System.out.println(q);
	}
}

public class StackImplementationUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackU s= new StackU();
       
       s.push(2);
       s.push(3);
       s.push(4);
       s.push(5);
      s.print();
       System.out.println(s.peek());
       System.out.println(s.pop());
       s.print();
	}

}
