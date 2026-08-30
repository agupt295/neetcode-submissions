class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) { return false; }

        int[] freqArr = new int[26];
        for(char ch: s1.toCharArray()){
            freqArr[ch-'a']++;
        }
        int totalChars = s1.length();
        int left = 0, right = -1;

        while(left < s2.length()){
            int leftCharIdx = s2.charAt(left)-'a';
            if(freqArr[leftCharIdx] == 0) {
                left++;
            } else {
                int[] copyArr = new int[26];
                int traversedChars = 0;

                right = left;
                while(right < s2.length()) {
                    int rightCharIdx = s2.charAt(right)-'a';
                    if(freqArr[rightCharIdx] + copyArr[rightCharIdx] > 0) { // you can do a -1 (since > 0 in s1)
                        copyArr[rightCharIdx] -= 1;
                        traversedChars++;
                    } else { // if already 0, and extra char in s1 (not present in s2)
                        // left = right;
                        left++;
                        break;
                    }
                    right++;
                }
                if(totalChars == traversedChars) { return true; }
                if(right >= s2.length()) { return false; }
            }
        }
        return false;
    }
}
