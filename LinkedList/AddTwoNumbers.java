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
        
        ListNode cur1=l1;
        ListNode cur2=l2;
        
        ListNode res= new ListNode(0);
        ListNode det=res;
        int sum=0;
        while(cur1!=null || cur2!=null)
        {
            sum/=10;            //updating the sum to 0 or single digit remainder.
            if(cur1!=null)
            {
                sum+=cur1.val;
                cur1=cur1.next;
            }
            if(cur2!=null)
            {
                sum+=cur2.val;
                cur2=cur2.next;
            }
            det.next= new ListNode(sum%10);
            det=det.next;
        }
        if(sum/10==1)
        {
            det.next=new ListNode(1);
        }
        
        
        return res.next;
      /*  StringBuilder sb1= new StringBuilder();
         StringBuilder sb2= new StringBuilder();
        
        while(l1!=null)
        {
            sb1.append(l1.val);
            l1=l1.next;
        }
       // System.out.println(sb1);
        
        while(l2!=null)
        {
            sb2.append(l2.val);
            l2=l2.next;
        }
        
        sb1=sb1.reverse();
        sb2=sb2.reverse();
        String s1=sb1.toString();
        String s2= sb2.toString();
        BigInteger b1= new BigInteger(s1);
        //System.out.println(b1);
        BigInteger b2= new BigInteger(s2);
        
        BigInteger sum=b1.add(b2);
        
        String str=sum.toString();
       // System.out.println(str);
        
        ListNode res=null;
        for(int i=0;i<str.length();i++)
        {
            int n=Integer.parseInt(""+str.charAt(i));
            ListNode t= new ListNode(n);
             t.next=res;
             res=t;
        }
        return res;*/
        
    }
}