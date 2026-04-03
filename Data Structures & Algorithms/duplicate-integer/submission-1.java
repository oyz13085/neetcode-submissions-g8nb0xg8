class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();

        for(int number:nums){
            if(numbers.contains(number)){
                return true;
            }

            numbers.add(number);
        }

        return false;
        
    }
}