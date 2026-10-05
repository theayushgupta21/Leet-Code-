class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // current score at this depth level

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0); // start a new depth level with score 0
            } else {
                int v = stack.pop(); // score accumulated inside this pair
                int innerScore = (v == 0) ? 1 : 2 * v;
                stack.push(stack.pop() + innerScore); // add to the enclosing level
            }
        }

        return stack.pop();
    }
}