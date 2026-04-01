class Solution {
    public boolean hasDuplicate(int[] nums) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> freq = new HashMap<>();
        boolean answer = false;

        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
            if(freq.get(i) == 2){
                answer = true;
                break;
            }

        }
        return answer;
        
    }
}