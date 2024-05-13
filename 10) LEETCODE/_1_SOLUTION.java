import java.util.Stack;

class Solution {
    public static boolean isMatch(char a,char b) {
        if(a == '(' && b == ')') {
            return true;
        } else if(a == '{' && b == '}') {
            return true;
        } else if(a == '[' && b == ']') {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char pop_char = stack.pop();
                if(!isMatch(pop_char,curr)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static int longestValidParentheses(String s) {
        int longLength = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                if(isValidParentheses(s.substring(i,j))) {
                    if((j-i) > longLength) {
                        longLength = j-i;
                    }
                } else {
                    break;
                }
            }
        }
        return longLength;
    }
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));

    }
}
