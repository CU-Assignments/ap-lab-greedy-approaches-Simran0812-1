import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int left = 0, right = Math.min(tasks.length, workers.length);
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canComplete(mid, tasks, workers, pills, strength)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    private boolean canComplete(int mid, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> deque = new ArrayDeque<>();
        int m = workers.length;
        
        for (int i = m - mid; i < m; i++) {
            deque.addLast(workers[i]);
        }
        
        int count = pills;
        for (int i = mid - 1; i >= 0; i--) {
            if (!deque.isEmpty() && deque.peekLast() >= tasks[i]) {
                deque.pollLast(); // Strong worker directly handles task
            } else if (!deque.isEmpty() && count > 0 && deque.peekFirst() + strength >= tasks[i]) {
                deque.pollFirst(); // Weakest worker + pill handles task
                count--;
            } else {
                return false; // Task cannot be completed
            }
        }
        
        return true;
    }
}
