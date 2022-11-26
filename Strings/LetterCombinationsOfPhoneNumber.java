class Solution {
    public List<String> letterCombinations(String digits) {
     LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) 
            return ans;
		String[] map =  {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++)
        {
			int x = Character.getNumericValue(digits.charAt(i));
            //  System.out.println(x);
			while(ans.peek().length()==i){
				String t = ans.remove();
            //    System.out.println(t);
				for(char s : map[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;   
    }
}