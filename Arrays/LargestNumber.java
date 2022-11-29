class Solution {
    public String largestNumber(int[] nums) {
        String[] s_ar = new String[nums.length];
        String largeNum="";
        for(int i=0;i<nums.length;i++)
        {
            s_ar[i]=String.valueOf(nums[i]);
        }
        
        Arrays.sort(s_ar, new LargeNumComparator());
        
        
        if(s_ar[0].equals("0"))
        {
            return "0";    
        }
        
       for(String s: s_ar)
       {
           largeNum+=s;
       }
        
        return largeNum;
    }
    
    
    
    
    public class LargeNumComparator implements Comparator<String>
    {
        @Override
        public int compare(String a , String b)
        {
            System.out.println(a+" "+b);
            String order1= a+b;
            String order2= b+a;
          //  System.out.println(order1+" "+order2);
            
            return order2.compareTo(order1);
        }
    }
}