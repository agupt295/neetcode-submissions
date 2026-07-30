class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);
            arr[s_char-'a']++;
            arr[t_char-'a']--;
        }

        for(int num: arr) {
            if(num != 0) return false;
        }
        return true;
    }
}
