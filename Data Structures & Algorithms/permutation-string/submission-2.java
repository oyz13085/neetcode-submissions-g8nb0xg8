class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length();

        while(right<=s2.length()){
            char[] sub1 = s1.toCharArray();
            Arrays.sort(sub1);
            String sortSub1 = new String(sub1);

            char[] sub2 = s2.substring(left,right).toCharArray();
            Arrays.sort(sub2);
            String sortSub2 = new String(sub2);

            if(sortSub2.equals(sortSub1)){
                return true;
            }

            left++;
            right++;
        }

        return false;
        
    }
}
