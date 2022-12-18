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
import java.math.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        StringBuilder s1= new StringBuilder();
        StringBuilder s2= new StringBuilder();
        
      while(l1!=null || l2!=null)
      {
          if(l1!=null)
          {
              s1.append(l1.val);
              l1=l1.next;
          }
          if(l2!=null)
          {
              s2.append(l2.val);
              l2=l2.next;
          }
      }
        String st1=s1.toString();
        String st2= s2.toString();
        BigInteger b1= new BigInteger(st1);
        BigInteger b2= new BigInteger(st2);
        
        b1=b1.add(b2);
        
        String s=b1.toString();
      //  System.out.println(s);
        ListNode res=null;
        
        for(int i=s.length()-1;i>=0;i--)
        {
            
            ListNode n=new ListNode(Integer.parseInt(""+s.charAt(i)));
            n.next=res;
            res=n;
        }
        return res;
        
    }
}