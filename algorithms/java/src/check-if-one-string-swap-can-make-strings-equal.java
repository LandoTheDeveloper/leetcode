/*
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
*/

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        // Check if strings are equal, if so we are done.
        if (s1.equals(s2)) {
            return true;
        }

        // Loop through and find a substring of length - 2.
        // ex: bank, kanb. length = 4 - 2 = 2. "an" found.
        int strlen = s1.length();  // s1.length == s2.length

        ArrayList<Character> a1 = new ArrayList<>();
        ArrayList<Character> a2 = new ArrayList<>();

        for (int i = 0; i < strlen; i++) {
            a1.add(s1.charAt(i));
        }
        
        for (int i = 0; i < strlen; i++) {
            a2.add(s2.charAt(i));
        }


        // Add mismatch characters to tracking arr
        ArrayList<Character> mismatch1 = new ArrayList<>();
        ArrayList<Character> mismatch2 = new ArrayList<>();
        for (int i = 0; i < strlen; i++) {
            // If same character, skip
            if (a1.get(i) == a2.get(i)) {
                continue;
            } else {
                mismatch1.add(a1.get(i));
                mismatch2.add(a2.get(i));
            }
        }

        // If mismatch arr size != 2, return false. Impossible case.
        if (mismatch1.size() != 2) {
            return false;
        }

        if ((mismatch1.get(0) == mismatch2.get(1)) && (mismatch1.get(1) == mismatch2.get(0))) {
            return true;
        }
        return false;
    }
}
