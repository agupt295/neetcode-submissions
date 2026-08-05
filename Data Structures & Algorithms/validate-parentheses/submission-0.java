class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '[' || ch == '(' || ch == '{')  {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char openingBracket = stack.pop();
                    if(
                        (ch == ']' && openingBracket != '[') ||
                        (ch == ')' && openingBracket != '(') ||
                        (ch == '}' && openingBracket != '{')
                    ) {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
