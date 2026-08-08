class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int secondNum = binary(numbers, i+1, target-numbers[i]);
            if(secondNum != -1) {
                return new int[]{i+1, secondNum};
            }
        }
        return null;
    }

    public int binary(int[] nums, int left, int target){
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid+1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
