class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        char[] t = a.clone();
        Arrays.sort(t);

        // find the range of positions that differ from the sorted string
        int l = 0, r = n - 1;
        while (l < n && a[l] == t[l]) l++;
        if (l == n) return 0;                 // already sorted
        while (a[r] == t[r]) r--;

        if (r - l + 1 < n) return 1;          // sort just the mismatched range
        if (n == 2) return -1;                // "ba": only length-1 substrings are allowed

        char mn = t[0], mx = t[n - 1];
        int mnCount = 0, mxCount = 0;
        for (char c : a) {
            if (c == mn) mnCount++;
            if (c == mx) mxCount++;
        }

        // the min appears only at the end AND the max appears only at the start
        if (a[n - 1] == mn && mnCount == 1 && a[0] == mx && mxCount == 1) return 3;
        return 2;
    }
}