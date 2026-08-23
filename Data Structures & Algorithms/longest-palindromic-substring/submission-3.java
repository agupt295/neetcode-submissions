class Solution {
    int maxLen = 0;
    int start = 0, end = 0;
    int[][] memo = new int[1001][1001];

    public String longestPalindrome(String s) {
        for(int[] memoArr: memo) {
            Arrays.fill(memoArr, -1);
        }
        dp(0, s.length()-1, s);
        return s.substring(start, end+1);
    }

    public void dp(int i, int j, String s){
        if(i > j) { return; }
        if(memo[i][j] != -1) { return; }

        if(isPalindrome(i, j, s)) {
            if(maxLen < j-i+1) {
                maxLen = j-i+1;
                start = i;
                end = j;
            }
            memo[i][j] = 1;
        } else {
            memo[i][j] = 0;
            dp(i, j-1, s);
            dp(i+1, j, s);
        }
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
