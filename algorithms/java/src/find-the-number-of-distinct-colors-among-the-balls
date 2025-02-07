/*
You are given an integer limit and a 2D array queries of size n x 2.

There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.

Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.

Note that when answering a query, lack of a color will not be considered as a color.
*/

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColor = new HashMap<>(); // Maps ball to its color
        Map<Integer, Integer> colorCount = new HashMap<>(); // Maps color to its frequency
        int currentDistinct = 0; // Tracks the number of distinct colors
        int[] result = new int[queries.length]; // Stores the result for each query
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0]; // Ball label
            int color = queries[i][1]; // New color
            
            // If the ball was previously colored, update the old color's count
            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);
                int oldCnt = colorCount.get(oldColor);
                colorCount.put(oldColor, oldCnt - 1);
                if (oldCnt - 1 == 0) {
                    currentDistinct--;
                }
            }
            
            // Update the ball's color
            ballColor.put(ball, color);
            
            // Update the new color's count
            int newCnt = colorCount.getOrDefault(color, 0) + 1;
            colorCount.put(color, newCnt);
            if (newCnt == 1) {
                currentDistinct++;
            }
            
            // Store the result for this query
            result[i] = currentDistinct;
        }
        
        return result;
    }
}
