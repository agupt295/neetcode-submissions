class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) maxQueue.add(stone);
        
        while(maxQueue.size() >= 2) {
            int heavy = maxQueue.poll();
            int light = maxQueue.poll();
            if(heavy == light) { continue; }
            maxQueue.add(heavy-light);
        }
        if(maxQueue.isEmpty()) return 0;
        return maxQueue.peek();
    }
}
