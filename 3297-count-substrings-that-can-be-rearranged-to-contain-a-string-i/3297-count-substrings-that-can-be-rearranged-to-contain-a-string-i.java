class Solution {
    public long validSubstringCount(String word1, String word2) {

        int[] have = new int[26];
        int[] needed =new int[26];

        for( int i= 0; i < word2.length(); i++){
            needed[word2.charAt(i)- 'a']++;
        }

        int left = 0;
        long ans = 0;

        for (int right = 0; right< word1.length(); right++){

            have[word1.charAt(right) -'a']++;

            while(valid(have,needed)){
                have[word1.charAt(left) - 'a']--;
                left++;
            }

            ans += left;
        }
        return ans;
    }
    public boolean valid(int[] have, int[] needed) {
        for (int i =0; i<26; i++){
            if(have[i]<needed[i]){
                return false;
            }
        }
        return true;
    }
}