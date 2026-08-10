class Solution {
    public String minWindow(String s, String t) {

        int[] have = new int[256];
        int[] needed = new int[256];

        // t ki frequency store karo
        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }

        int low = 0;

        int ans = Integer.MAX_VALUE;
        int start = 0;

        for (int high = 0; high < s.length(); high++) {

            // current window me character add
            have[s.charAt(high)]++;

            // jab tak current window valid hai
            while (right(have, needed)) {

                int len = high - low + 1;

                // minimum window
                if (len < ans) {
                    ans = len;
                    start = low;
                }

                // left character remove
                have[s.charAt(low)]--;

                low++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + ans);
    }

    public boolean right(int[] have, int[] needed) {

        for (int i = 0; i < 256; i++) {

            if (have[i] < needed[i]) {
                return false;
            }
        }

        return true;
    }
}