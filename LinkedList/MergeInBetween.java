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
/*
->Store all the nodes in array and reverse it.
->Create a LL from 0 to ath node.
->Create a Ll from bth node to end.
->Initially merge , firstLL to list2. Then merge list2 to lastLL.
->return firstLL.
-TC: O(a+b+N), SC:O(N).

*/
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        List<Integer>ar= new ArrayList<>();
        ListNode h1=list1;
        while(h1!=null)
        {
            ar.add(h1.val);     //storing all the nodes in array.
            h1=h1.next;        
        }
        Collections.reverse(ar);    //reverse it.
        System.out.println(ar);
        ListNode first=null;
        int n=ar.size();
        for(int i=n-a;i<n;i++)
        {
            ListNode temp= new ListNode(ar.get(i));    
            temp.next=first;                           //creating a ll from 0 to ath node.
            first=temp;
        }
        
        ListNode last=null;
        for(int i=0;i<n-b-1;i++)
        {
            ListNode temp= new ListNode(ar.get(i)); 
            temp.next=last;                             //creating a ll from bth node to end.
            last=temp; 
        }
        
        
        ListNode curr=first;
        while(curr.next!=null)
        {
            curr=curr.next;
        }
        
        curr.next=list2;     //merging first ll to list2.
        
        ListNode c2=list2;
        while(c2.next!=null)
        {
            c2=c2.next;
        }
        c2.next=last;         //merging list2 to last.
        return first;
    }
}