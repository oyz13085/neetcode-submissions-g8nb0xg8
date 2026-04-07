class Solution {
    public String minWindow(String s, String t) {
        int[] debt = new int[128];
        int required = t.length();
        
        for(int i=0;i<t.length();i++){
            debt[t.charAt(i)]++;
        }

        int maxLeft = -1;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right=0;right<s.length();right++){
            if(debt[s.charAt(right)]-->0){
                required--;
            }

            while(required==0){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    maxLeft = left;
                }

                if(++debt[s.charAt(left)]>0){
                    required++;
                }
                
                left++;
            }
        }

        return (maxLeft < 0)? "" : s.substring(maxLeft,maxLeft+minLen);
    }
}
