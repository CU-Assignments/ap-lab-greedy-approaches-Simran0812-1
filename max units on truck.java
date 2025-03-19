import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort in descending order based on units per box
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int boxCount = Math.min(box[0], truckSize); // Take as many boxes as possible within the truck size
            totalUnits += boxCount * box[1];
            truckSize -= boxCount;

            if (truckSize == 0) break; // Stop when truck is full
        }

        return totalUnits;
    }
}
