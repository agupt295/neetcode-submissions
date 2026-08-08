class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if(isOperation(token)) {
                int num1 = stack.pop(), num2 = stack.pop();
                int result = 0;
                switch(token) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public boolean isOperation(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }
}
