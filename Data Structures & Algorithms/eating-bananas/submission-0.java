class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        int minK = Integer.MAX_VALUE;

        for(int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int left = 1, right = maxPile;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(calculateHours(mid, piles) <= h) {
                minK = Math.min(minK, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minK;
    }

    public int calculateHours(int speed, int[] piles){
        int hours = 0;
        for(int pile: piles) {
            hours += pile/speed;
            if(pile % speed != 0) {
                hours++;
            }
        }
        return hours;
    }
}
