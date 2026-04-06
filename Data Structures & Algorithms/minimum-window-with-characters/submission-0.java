class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];
        for (char c : t.toCharArray()) freq[c]++;

        int left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {
            // PHASE 2: INHALE (Expand Right)
            if (freq[s.charAt(right)]-- > 0) {
                required--;
            }

            // PHASE 3: EXHALE (Shrink Left)
            while (required == 0) {
                // Update the "Best" only if it's a new record
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;
                
                // If freq becomes > 0, we officially OWE it again
                if (freq[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
