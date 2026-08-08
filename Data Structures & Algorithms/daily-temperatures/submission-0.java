class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                arr[i] = 0;
            } else {
                arr[i] = stack.peek()[1]-i;
            }
            stack.add(new int[]{temperatures[i], i});
        }

        return arr;
    }
}
