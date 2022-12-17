/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
         int n=0;
        ListNode cur=head;
        
        while(cur!=null)
        {
            cur=cur.next;
            n++;
        }
        int[] ar= new int[n];
        cur=head;
        int k=0;
        while(cur!=null)
        {
            ar[k++]=cur.val;
            cur=cur.next;
        }
        for (int j = 1; j < n; j++)
        {  //insertion sort.
            int key = ar[j];  
            int i = j-1;  
            while ( (i > -1) && ( ar [i] > key ) )
            {  
                ar [i+1] = ar[i];  
                i--;  
            }  
            ar[i+1] = key;  
        }  
        
        
        ListNode newN=null;
        for(int i=n-1;i>=0;i--)
        {
            ListNode t= new ListNode(ar[i]);
            t.next=newN;
            newN=t;
        }
        
        return newN;
    }
}