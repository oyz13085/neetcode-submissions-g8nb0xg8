class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;

        // Using a for loop for 'right' is cleaner as it auto-increments
        for (int right = 0; right < s.length(); right++) {
            
            // PHASE 1: SHRINK (The "While" Loop)
            // While the new char is already in our window, 
            // keep removing the leftmost char and moving 'left' forward.
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // PHASE 2: EXPAND
            // Now the window is guaranteed to be unique. Add the new char.
            set.add(s.charAt(right));

            // PHASE 3: RECORD
            // The current window size is (right - left + 1)
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
