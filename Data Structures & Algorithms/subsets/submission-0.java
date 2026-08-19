class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        bt(0, nums, new ArrayList<>());
        return list;
    }

    public void bt(int i, int[] nums, List<Integer> subList){
        if(i == nums.length) {
            list.add(new ArrayList<>(subList));
            return;
        }
        
        subList.add(nums[i]);
        bt(i+1, nums, subList);
        
        subList.remove(subList.size() - 1);
        bt(i+1, nums, subList);
    }
}