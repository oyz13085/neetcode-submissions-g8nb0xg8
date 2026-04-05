class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int num:freq.keySet()){
            if(bucket[freq.get(num)] == null){
                bucket[freq.get(num)] = new ArrayList<>();
            }
            bucket[freq.get(num)].add(num);
        }

        int[] result = new int[k];
        for(int i=bucket.length-1;i>0 && k > 0;i--){
            if(bucket[i] != null){
                for(int num:bucket[i]){
                    result[k-1] = num;
                    k--;
                    if(k ==0) return result;
                }
            }
        }

        return result;


        
    }
}
