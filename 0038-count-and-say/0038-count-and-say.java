class Solution {
    public String countAndSay(int n) {
        String curr = "1";

        for (int term = 2; term <= n; term++) {
            StringBuilder next = new StringBuilder();
            int i = 0;

            while (i < curr.length()) {
                char ch = curr.charAt(i);
                int j = i;
                while (j < curr.length() && curr.charAt(j) == ch) {
                    j++;
                }
                next.append(j - i).append(ch); // run length, then the digit
                i = j;
            }

            curr = next.toString();
        }

        return curr;
    }
}