class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Hashmap key:number(int); val: NumOccurrences(int)

        //create hashmap 
        Map<Integer, Integer> myHashMap = new HashMap<>();

        //iterate through nums
        for (int number : nums) {
            // if number exists as a key in the hashmap
            if (myHashMap.containsKey(number)) {
                //increment that key's value
                int temp = myHashMap.get(number) + 1;
                myHashMap.put(number, temp);
            } else {
            //else the number doesn't exist as a key in hashmap
                //add number as key in hashmap
                myHashMap.put(number, 1);
            }

            /*
                number = 2
                [key: 2 val: 1]
            */
        }
        //at this point we have:
            //hashmap with numbers and their counts per number
        //maybe make a list where each element is a value key pair

        List<Integer> mySortedList = new ArrayList<>(myHashMap.values());
        Collections.sort(mySortedList, Collections.reverseOrder());
        int index = 0;
        int count = 0;
        int [] myReturnArray = new int[k];
        // int [] myReturnArray = {5,5};
        
        for(Map.Entry<Integer, Integer> entry : myHashMap.entrySet()) {
            //iterate through mySortedList
            while (index < k) {   //stop at k
                //see if value matches any of the top k elements. 
                //if it does, add keyit to the returnArray
                if (mySortedList.get(index) == entry.getValue()) {
                    myReturnArray[count] = entry.getKey();
                    count++;
                    break;
                }//if it doesn't, go on to the next entry
                index++;
            }
            //reset index
            index = 0;
        }
        
            //return the top k numbers keys in a list
                //maybe once arrayList is sorted,
                //get keys by their value if possible:

        return myReturnArray;

    }
}
