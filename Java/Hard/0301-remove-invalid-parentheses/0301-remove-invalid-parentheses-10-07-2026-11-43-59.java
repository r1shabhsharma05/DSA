import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum removals
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRemove++;
            }

            else if (ch == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        dfs(
            s,
            0,
            leftRemove,
            rightRemove,
            0,
            new StringBuilder()
        );

        return new ArrayList<>(result);
    }

    private void dfs(
        String s,
        int index,
        int leftRemove,
        int rightRemove,
        int balance,
        StringBuilder path
    ) {

        // End of string
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(path.toString());
            }

            return;
        }

        char ch = s.charAt(index);

        // Opening parenthesis
        if (ch == '(') {

            // Remove '('
            if (leftRemove > 0) {

                dfs(
                    s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    path
                );
            }

            // Keep '('
            path.append(ch);

            dfs(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                path
            );

            path.deleteCharAt(path.length() - 1);
        }

        // Closing parenthesis
        else if (ch == ')') {

            // Remove ')'
            if (rightRemove > 0) {

                dfs(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    path
                );
            }

            // Keep ')' only if matching '(' exists
            if (balance > 0) {

                path.append(ch);

                dfs(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    path
                );

                path.deleteCharAt(path.length() - 1);
            }
        }

        // Normal character
        else {

            path.append(ch);

            dfs(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                path
            );

            path.deleteCharAt(path.length() - 1);
        }
    }
}