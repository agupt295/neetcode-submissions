class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) { map.put(nums[i], i); }

        for(int i = 0; i< nums.length; i++) {
            int second_num = target-nums[i];
            if(map.containsKey(second_num) && i != map.get(second_num)) {
                return new int[]{i, map.get(second_num)};
            }
        }
        return new int[]{-1, -1};
    }
}
