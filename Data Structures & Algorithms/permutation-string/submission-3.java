class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        for(int i=0;i<s1.length();i++){
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        for(int i=0;i<s2.length()-s1.length();i++){
            if(matches(s1Counts,s2Counts)) return true;

            s2Counts[s2.charAt(i) - 'a']--;
            s2Counts[s2.charAt(i+s1.length()) - 'a']++;
        }

        return matches(s1Counts,s2Counts);
        
    }

    public boolean matches(int[] s1Counts,int[] s2Counts){
        for(int i=0;i<26;i++){
            if(s1Counts[i] != s2Counts[i]){
                return false;
            }
        }
        return true;
    }
}
