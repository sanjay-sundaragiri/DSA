//TC: O(N)+O(N) , SC:O(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length;
       int[] res= new int[n-k+1];
       int a=0;
        Deque<Integer>q = new ArrayDeque<>();
       for(int i=0;i<n;i++)
       {
           //remove the numbers out of k range or size.
           if(!q.isEmpty() && q.peek()==i-k){
               q.poll();
           }

           //remove smaller elements that are less than current number.
           while(!q.isEmpty() && nums[q.peekLast()]< nums[i])
           {
               q.pollLast();
           }

           q.add(i);
           if(i>= k-1)   //finding the max element from the window
           {
               res[a++]= nums[q.peek()];
           }
       }

       return res;
    }
}