class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int cur = 0;
        ArrayList<Character> usedLetters = new ArrayList<>();

        int len = s.length();
      
        for (int i = 0; i < len; i++) {
            cur = 0;
            for (int j = i; j < len; j++) {
                if (usedLetters.contains(s.charAt(j))) {
                    break;
                } else {
                    cur++;
                    usedLetters.add(s.charAt(j));
                }
                if (cur > res) {
                    res = cur;
                }
            }
            usedLetters.clear();
        }
        return res;
    }
}
