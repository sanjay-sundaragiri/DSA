/* Stack is a Data Structure,which follows Last In First Out (LIFO) approach.
 * we can access the values from the top of the stack,i.e, least recently inserted values.
 * */

class Stack
{
	int arr[];   
	int top;
	
	Stack(int size)   //intializing  size of the stack.
	{  
		
		arr= new int[size];
		top=-1;
	}
	
	void push(int data)        //pushes values into stack.
	{
		arr[++top]=data;
		
	}
	int pop()  // deletes the top of the element and returns the element.
	{
		if(top==-1)
			return -1;
		
		int ele= arr[top];
		top--;
		
		return ele;
	}
	 
	int peek()             //returns top of the stack.
	{
		if(top==-1)
			return -1;
		
		return arr[top];
	}
	
	boolean isEmpty()     //checking stack is empty or not
	{
		if(top==-1)
			return true;
		
		return false;
	}
	
	boolean isFull()     //checking stack is full or not
	{
		if(top+1==arr.length)
		{
			return true;
		}
		
		return false;
	}
	
	void print()
	{
		for(int i=0;i<top+1;i++)
		{
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
	}
}





public class StackImplementaionUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stack s = new Stack(4);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.print();
        System.out.println(s.pop());//removes the top of the element and returns.
        s.print();
        System.out.println(s.peek());  //returns the top of the stack.
        s.print();
       
        System.out.println(s.isEmpty());//returns true if stack is empty,else false.
        System.out.println(s.isFull());//  returns true if stack is full,else false.
	}

}
