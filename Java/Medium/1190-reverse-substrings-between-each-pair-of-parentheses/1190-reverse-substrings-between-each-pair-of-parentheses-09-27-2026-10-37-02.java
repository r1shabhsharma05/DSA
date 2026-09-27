class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        String curr = "";

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(curr);
                curr = "";
            }

            else if (ch == ')') {
                curr = new StringBuilder(curr).reverse().toString();
                curr = stack.pop() + curr;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }
}