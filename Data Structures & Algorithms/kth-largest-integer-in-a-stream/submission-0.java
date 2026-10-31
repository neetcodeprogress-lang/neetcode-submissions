class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        //initializes object given k, and the stream of integers nums
        this.k = k;
        pq = new PriorityQueue<>();
        //add elements of num to pq
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        //adds val to stream and returns the kth largest integer in the stream
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
