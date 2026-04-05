class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxWindow = 0;
        int[] freq = new int[26];

        while(right<s.length()){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right) - 'A']);

            if((right-left+1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            right++;

            maxWindow = Math.max(maxWindow,right-left);
        }

        return maxWindow;
        
    }
}
