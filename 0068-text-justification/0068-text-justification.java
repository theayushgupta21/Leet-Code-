class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            // Greedily find how many words fit on this line
            int j = i;
            int lineLen = 0; // total letters (no spaces) of words in the line
            while (j < n && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }
            // words[i..j-1] go on this line

            int wordCount = j - i;
            int gaps = wordCount - 1;
            StringBuilder sb = new StringBuilder();

            if (j == n || gaps == 0) {
                // last line, or a single word: left-justify
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int totalSpaces = maxWidth - lineLen;
                int base = totalSpaces / gaps;
                int extra = totalSpaces % gaps; // leftmost gaps get one extra space

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaces = base + (k - i < extra ? 1 : 0);
                        for (int s = 0; s < spaces; s++) sb.append(' ');
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}