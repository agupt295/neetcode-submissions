class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new HashMap<>();
        int len = position.length;
        int fleetNum = 1;
        double latestTime = 0;
        int maxPosition = -1;

        for(int i = 0; i < len; i++) {
            double time = (double)(target-position[i])/speed[i];
            map.put(position[i], time);
            if(maxPosition < position[i]) {
                maxPosition = position[i];
                latestTime = time;
            }
        }

        for(int i=target-1; i >= 0; i--){
            if(!map.containsKey(i)) {
                continue;
            }

            double time = map.get(i);
            if(time <= latestTime) {
                continue;
            } else {
                latestTime = time;
                fleetNum++;
            }
        }
        return fleetNum;
    }
}
