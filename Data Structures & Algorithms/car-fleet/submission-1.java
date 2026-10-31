class Solution {
    public static int carFleet(int target, int[] position, int[] speed) {
        //2  2  1  1     1  2  2   1 SPEED
        //4, 1, 0, 7 --> 7, 4, 1,  0 POSITION
        //               3  3  4.5 10 Time - 3 different times == 3 different fleets
        //timeToReachTarget = (target - position) / speed
        //if timeToReachTarget of a position is < timeToReachTarget of another position this means:
        //will form fleet?

        //cars 1 & 2 will form a fleet if 2.timeToReachTarget >= 1.timeToReachTarget


        Stack<Double> myStack = new Stack<>();

        //put the array into another array representing position (0) and speed (1)
        int[][] myTempArray = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            myTempArray[i] = new int[]{position[i], speed[i]};
        }
        //ok so sort the outer position array in desc order
        // Arrays.sort(myArray, Arrays.reverseOrder());
        //this sorts based on first element of each subarray?
        Arrays.sort(myTempArray, (a, b) -> Integer.compare(b[0], a[0]));
//        int[][] myArray = new int[position.length][2];
//        for(int i = myArray.length - 1; i > -1; i--) {
//            myArray[i] = new int[]{myTempArray[i][0], myTempArray[i][1]};
//        }

        double timeToReachTarget = 0;
        for(int i = 0; i < myTempArray.length; i++) {
            //double to avoid integer division
            timeToReachTarget = (double) (target - myTempArray[i][0]) / myTempArray[i][1];
            if(myStack.empty()) {
                myStack.push((double)timeToReachTarget);
            } else {
                if (timeToReachTarget > myStack.peek()) { //new fleet, add time to stack
                    myStack.push((double)timeToReachTarget);
                }
            }
        }
        return myStack.size();
    }
}
