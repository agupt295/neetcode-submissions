class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) >= left) {
                maxLen = Math.max(maxLen, right-left);
                left = map.get(ch)+1;
            }
            map.put(ch, right);
        }
        maxLen = Math.max(maxLen, right-left);
        return maxLen;
    }
}
