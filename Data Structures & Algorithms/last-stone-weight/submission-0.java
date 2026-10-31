class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        if stones.length == 1 return stones[0];

        add elements of stones into MaxHeap
        while MaxHeap.size() >= 2
            pop off first two
            compare
                if equal, they are destroyed
                elif x < y,
                    x is destroyed, y = y - x
                    add back to maxHeap
                else (y < x)
                    y is destroyed, x = x - y
                    add back to maxHeap

        if empty, return 0;
        else return stones[i];
        */
        if (stones.length == 1)
            return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            maxHeap.offer(i);
        }

        while(maxHeap.size() >= 2) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x < y) {
                y = y - x;
                maxHeap.offer(y);
            } else if (y < x) {
                x = x - y;
                maxHeap.offer(x);
            }
        }

        if(maxHeap.isEmpty()) return 0;
        else return maxHeap.poll();
    }
}
