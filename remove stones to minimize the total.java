import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Step 1: Add all elements to max heap
        for (int pile : piles) {
            maxHeap.add(pile);
        }
        
        // Step 2: Perform k operations
        while (k > 0) {
            int max = maxHeap.poll(); // Take out the largest pile
            int reduced = max - (max / 2); // Reduce by floor(piles[i] / 2)
            maxHeap.add(reduced); // Add back to heap
            k--;
        }
        
        // Step 3: Calculate the total remaining stones
        int total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll(); // Sum all remaining elements
        }
        
        return total;
    }
}
