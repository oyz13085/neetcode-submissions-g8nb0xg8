

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map stores: <Value, Index>
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // 1. Check if the "Partner" we need is already in the map
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }

            // 2. If not, "remember" this current number and its index
            seen.put(nums[i], i);
        }

        // Return empty array if no solution is found (though the problem says one always exists)
        return new int[] {};
    }
}