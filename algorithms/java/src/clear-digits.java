/*
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.
*/

class Solution {
    public String clearDigits(String s) {
        // Loop through string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If character is digit, search backwards until we find a non-digit char
            if (Character.isDigit(ch)) {
                int j = i - 1;
                while (j >= 0 && Character.isDigit(s.charAt(j))) {
                    j--;
                }
                // make new string concatting up to j and past i.
                s = s.substring(0, j) + s.substring(i+1);
                i = 0;  // Set i back to 0 to avoid skipping numbers.
                }
            }
        // Res.
        return s;
    }
}
