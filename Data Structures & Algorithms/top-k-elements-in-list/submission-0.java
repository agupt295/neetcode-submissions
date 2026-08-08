class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int freq: map.values()){
            minHeap.add(freq);
            if(minHeap.size() > k) minHeap.remove();
        }
        int[] arr = new int[k];
        int i = 0;
        int targetFreq = minHeap.peek();
        for(int key: map.keySet()) {
            if(map.get(key) >= targetFreq) {
                arr[i++] = key;
            }
        }

        return arr;
    }
}
