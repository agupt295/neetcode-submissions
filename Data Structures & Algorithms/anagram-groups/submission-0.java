class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            String arrangedStr = arrange(str);
            if(map.containsKey(arrangedStr)) {
                map.get(arrangedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(arrangedStr, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String arrange(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
    }
}
