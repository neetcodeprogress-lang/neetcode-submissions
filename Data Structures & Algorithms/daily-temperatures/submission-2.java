class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int tempCount = 0;
        for(int i = 0; i < result.length; i++) {
            // if (tempCount == 0) {
            //     result[i] = tempCount;
            // }
            tempCount = 0;
            result[i] = tempCount;
            for(int n = i + 1; n < result.length; n++) {
                tempCount++;
                if (temperatures[n] > temperatures[i]) {
                    //next day is warmer, add count to arr
                    result[i] = tempCount;
                    tempCount = 0;
                    break;
                }
            }
        }

        return result;
    }
}
