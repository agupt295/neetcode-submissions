class Solution {
    Queue<Integer> queue = new LinkedList<>();
    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();
        for(String str: strs){
            strBuilder.append(invert(str));
            queue.add(str.length());
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        while(!queue.isEmpty()) {
            int len = queue.remove();
            list.add(invert(str.substring(start, len + start)));
            start += len;
        }
        return list;
    }

    // helper functions
    public String invert(String str){
        StringBuilder invertedStr = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            invertedStr.append(str.charAt(i));
        }
        return invertedStr.toString();
    }
}
