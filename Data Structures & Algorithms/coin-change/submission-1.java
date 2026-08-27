class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int minSum = dp(coins, amount, coins.length-1);
        return minSum >= 99999 ? -1: minSum;
    }

    public int dp(int[] coins, int amount, int i){
        if(i < 0) { return 99999; }
        if(amount == 0) { return 0; }
        if(coins[i] > amount) {
            return dp(coins, amount, i-1);
        } else if (coins[i] == amount) { return 1; }

        int take = 1 + dp(coins, amount-coins[i], i);
        int notTake = dp(coins, amount, i-1);
        return Math.min(take, notTake);
    }
}
