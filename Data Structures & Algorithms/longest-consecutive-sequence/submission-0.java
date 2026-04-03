class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        int longest = 0;
        for(int num:nums){
            numbers.add(num);
        }

        for(int num:nums){
            int currentStreak = 1;
            if(!numbers.contains(num-1)){
                while(numbers.contains(num+currentStreak)){
                    currentStreak ++;
                }
                if(currentStreak>longest){
                    longest = currentStreak;
                }
            }
        }

        return longest;

        
    }
}
