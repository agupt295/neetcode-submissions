class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftArr = new int[len];
        leftArr[0] = nums[0];
        int[] rightArr = new int[len];
        rightArr[len-1] = nums[len-1];

        for(int i = 1; i < len; i++){
            leftArr[i] = leftArr[i-1]*nums[i];
        }

        for(int i = len-2; i >= 0; i--) {
            rightArr[i] = rightArr[i+1]*nums[i];
        }

        int[] answer = new int[len];
        answer[0] = rightArr[1];
        answer[len-1] = leftArr[len-2];

        for(int i = 1; i < len-1; i++) {
            int product = 1;
            answer[i] = leftArr[i-1]*rightArr[i+1];
        }

        return answer;
    }
}  
