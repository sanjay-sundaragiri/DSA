/* ->Queue is data structure,which follows First In First Out.
 * 
 * */

class Queue
{
	int arr[];
	int front;
	int rear;
	int count;
	int n;
	Queue(int size)
	{
		arr= new int[size];
		front=0;
		rear=0;
		count=0;
		n=size;
	}
	
	void enqueue(int data)
	{
		if(count==n)
			return;
		
		arr[rear%n]=data;
		rear++;
		count++;
	}
	
	int dequeue()
	{
		if(count==0)
			return -1;
		
		//arr[front%n]=-1;
		int num= arr[front];
		front++;
		count--;
		
		return num;
	}
	
	int peek()
	{
		if(count==0)
			return -1;
		
		return arr[front%n];
	}
	boolean isEmpty()
	{
		if(count==0)
			return true;
		
		return false;
	}
	
	boolean isFull()
	{
		if(count==n)
			return true;
		
		return false;
	}
	void print()
	{
		for(int i=front;i<rear;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	int size()
	{
		return count;
	}
}





public class QueueImplementationUsingArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Queue q= new Queue(5);
		  q.enqueue(1);     //inserts values into the queue. 
		  q.enqueue(2);     
		  q.enqueue(3);
		  q.enqueue(4);
		  q.enqueue(5);
		  System.out.println("Queue is full: "+q.isFull());//returns true if queue is full or else returns false.
		 
		  System.out.println("popped element: "+q.dequeue());//removes and returns the popped element.
		  
		  System.out.println("peek of the queue: "+q.peek());     //returns the top of the queue.
		  System.out.println("popped element: "+q.dequeue());
		  q.print();
		  System.out.println("Queue is Empty: "+q.isEmpty()); // returns true if queue id empty,else returns false.
		  System.out.println("peek of the queue: "+q.peek());
		  
		  System.out.println("Size of the Queue: "+q.size());//returns the size.
		  
		  
  }

}
