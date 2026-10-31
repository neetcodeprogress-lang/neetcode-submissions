class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        
        int l = 1;
        int r = getMax(piles);
        int m = (l + r) / 2;
        while (l <= r) {
            m = (l+r) / 2;
            long count = 0;
            for (int n : piles) {
                count += Math.ceil((double) n / m);

            }

            if (count <= h) {
                //set current result
                min = m;
                //r = m - 1;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return min;
    }

    public int getMax(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}
