class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        /* 
        create a priority queue / maxheap of size k
        iterate through points:
        for each point in points
            calculate distance using formula
            add the point to the heap sorted by distance to the origin, in desc
        
        by now should have a heap of points of size k sorted by distance to origin in desc order, now we create a 2d array of size k total elements to add to and return

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[row][i] = minHeap.poll()
        }

        return res;
        */

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        for(int[] point : points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
