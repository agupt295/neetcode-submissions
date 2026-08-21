class Solution {
    int[] memo = new int[101];
    public int rob(int[] nums) {
        return Math.max(
            dp(0, nums),
            dp(1, nums)
        );
    }

    public int dp(int i, int[] nums){
        if(i >= nums.length) { return 0; }
        if(memo[i] != 0) { return memo[i]; }
        return memo[i] = Math.max(
            (nums[i] + dp(i+2, nums)),
            (nums[i] + dp(i+3, nums))
        );
    }
}
