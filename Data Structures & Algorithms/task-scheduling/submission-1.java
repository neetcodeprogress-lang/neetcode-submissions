class Solution {
    public int leastInterval(char[] tasks, int n) {
        /* 
        iterate through tasks
            add each char of tasks to map: K=char:char, V=int:occurrences
        
        then add values to a maxheap
            something like maxHeap = {3, 2, 2}
        
        then create an empty queue of int[]

        now calculate by iterating through maxHeap
        int time = 0;
        while(maxHeap not empty and queue not emtpy) 
            time++;
            if(maxHeap not empty) 
                int temp = maxHeap.pop() - 1;
                if(temp > 0) {
                    queue.offer(new int[]{temp, time + n})
            
            if(Q not empty and Q.peek()[1] == time)
                add value:occurrences back to heap
        
        return time
        */  
        HashMap<Character, Integer> myMap = new HashMap<>();
        for(char task : tasks) {
            myMap.put(task, myMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : myMap.values()) {
            maxHeap.offer(num);
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time += 1;
            if(!maxHeap.isEmpty()) {
                int temp = maxHeap.poll() - 1;
                if(temp > 0) {
                    queue.offer(new int[]{temp, time + n});

                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
