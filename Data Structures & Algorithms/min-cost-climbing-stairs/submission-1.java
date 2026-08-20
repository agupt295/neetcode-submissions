class Solution {
    int[] memo = new int[101];
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dp(0, cost), dp(1, cost));
    }

    public int dp(int i, int[] cost){
        if(i >= cost.length) {
            return 0;
        }
        if(memo[i] != 0) { return memo[i]; }

        return memo[i] = Math.min(
            cost[i] + dp(i+1, cost),
            cost[i] + dp(i+2, cost)
        );
    }
}
