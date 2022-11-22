class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--)
        {
           if(digits[i]<9){
               digits[i]++;
            //   System.out.print(digits[i]+" ");
                return digits;
           }else
            digits[i]=0;
         }
    
        int [] newarr=new int[n+1];
         newarr[0]=1;
    return newarr;        

        
        
        
        
        
        
        
        
        
        
        
        
       /* 
        this code doesn't satisfying the testcase [9] to [1,0];
       int integer=0;
        for(int i=0;i<digits.length;i++)
        {
            integer= (integer*10)+digits[i];
        }
       integer= integer+1;
      //  System.out.println(integer);
        String s=String.valueOf(integer);
       //System.out.println(s);
       
        //s.toArray(B);
        String [] str=s.split(",");
        int[] A= new int[digits.length];
        for(int i=0;i<str.length;i++)
        {
            A[i]=Integer.parseInt(str[i]);
          // System.out.print(A[i]+" ");
        }
        
        
        return A;*/
    }
}