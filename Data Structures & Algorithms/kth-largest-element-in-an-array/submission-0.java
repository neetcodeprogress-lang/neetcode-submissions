class Solution {
    public int findKthLargest(int[] nums, int k) {
        /* 
        create a minheap, asc order
        add elements of num to minheap.
            if > k, pop
            offer num to minheap

        should by now have a minheap that is of size k
        sorted in asc order,(poll is the lowest)

        while not empty
            store poll into a variable

        return that variable
        */

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // [4, 5]
            }
        }
        return maxHeap.peek();
    }
}
