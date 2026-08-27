class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) { set.add(num); }
        int counter = 0, maxLen = 0;

        for(int num: nums){
            if(set.contains(num-1)) { continue; }
            int currentNum = num;
            while(set.contains(currentNum)) {
                counter++;
                currentNum++;
            }
            maxLen = Math.max(maxLen, counter);
            counter = 0;
        }
        return maxLen;
    }
}
