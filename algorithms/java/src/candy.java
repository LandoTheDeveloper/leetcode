import java.util.*;

class Solution {
    public static int candy(int[] ratings) {
        int totalCandy = 0;
        // Each child must have one candy
        ArrayList<Integer> candies = new ArrayList<Integer>(Collections.nCopies(ratings.length, 1));

        int leftN; 
        int self;
        int rightN;
        for (int i = 0; i < candies.size(); i++) {
            leftN = 30000;
            self = ratings[i];
            rightN = 30000;


            if (i < candies.size() - 1) {
                rightN = ratings[i + 1];
            }

            if (i > 0) {
                leftN = ratings[i - 1];
            }
            
            // Compare to neighbors
            if ((self > leftN) && (self > rightN)) {
                if (candies.get(i - 1) > candies.get(i+1)) {
                    candies.set(i, candies.get(i - 1) + 1);
                } else if (candies.get(i+1) > candies.get(i-1)) {
                    candies.set(i, candies.get(i + 1) + 1);
                } else {
                    candies.set(i, candies.get(i - 1) + 1);
                }
            } else if (self > leftN) {
                candies.set(i, candies.get(i - 1) + 1);
            } else if (self > rightN) {
                candies.set(i, candies.get(i + 1) + 1);
            }
        }

        // Go backwards to check again
        for (int i = 0; i < candies.size(); i++) {
            leftN = 30000;
            self = ratings[i];
            rightN = 30000;


            if (i < candies.size() - 1) {
                rightN = ratings[i + 1];
            }

            if (i > 0) {
                leftN = ratings[i - 1];
            }
            
            // Compare to neighbors
            if ((self > leftN) && (self > rightN)) {
                if (candies.get(i - 1) > candies.get(i+1)) {
                    candies.set(i, candies.get(i - 1) + 1);
                } else if (candies.get(i+1) > candies.get(i-1)) {
                    candies.set(i, candies.get(i + 1) + 1);
                } else {
                    candies.set(i, candies.get(i - 1) + 1);
                }
            } else if (self > leftN) {
                candies.set(i, candies.get(i - 1) + 1);
            } else if (self > rightN) {
                candies.set(i, candies.get(i + 1) + 1);
            }
        }
        System.out.println("Candies: " + candies);

        // Add up total candies
        for (int i = 0; i < candies.size(); i++) {
            totalCandy += candies.get(i);
        }

        return totalCandy;
    }

    public static void main(String[] args) {
        int[] ratings = {3,2,1,1,4,3,3};
        System.out.println(candy(ratings));
    }
}