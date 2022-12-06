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
->Add the nums into a HashSet.
->if set contains current value, also it must not contain next value or it reaches null,then increment the count by 1.
->return the count.
-TC: O(N)+O(N).
-SC: O(N).
*/
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int count=0;
         Set<Integer> set = new HashSet<>();
        for(int i : nums){ set.add(i);}
        
        while(head!=null)
        {
            if( set.contains(head.val) && (head.next==null ||  !set.contains(head.next.val)) )
            {
                count++;
            }
            head = head.next;
        }
        
        
        return count;
    }
   
}