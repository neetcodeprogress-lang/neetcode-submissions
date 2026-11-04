class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 1 2 3
        // 3 2 3
        int[] cheapest = new int[cost.length];
        
        for(int i = cost.length - 1; i >= 0; i--) {
            if(i + 2 > cost.length - 1 || i + 1 > cost.length - 1) {
                cheapest[i] = cost[i];
            } else {
                cheapest[i] = cost[i] + Math.min(cheapest[i+1], cheapest[i+2]);
            } 
        }

        return Math.min(cheapest[0], cheapest[1]);
    }
}
