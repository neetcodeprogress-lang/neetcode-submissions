class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        int max = 0;
        // left and right pointers
        int left = 0;
        int right = 1;
        // if right < left, mov left to right
        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                //smaller, move left
                left = right;
            }
            if (prices[right] > prices[left]) {
                max = Math.max(max, prices[right] - prices[left]);
            }
            right++;
        }
        // if right > left, compare to global max

        return max;
        //return max
    }
}
