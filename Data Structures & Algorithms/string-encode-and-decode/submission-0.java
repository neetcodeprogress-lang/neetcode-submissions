class Solution {

//What it is asking: turn a list of strings into a single string(encode)
//                   then turn it back into a list of strings(decode)

    Map<Integer,String> myMap;

    public String encode(List<String> strs) {
        //store it in a hashmap? so that it can be decoded
        // index : value

        // Create hashmap of index : value
        myMap = new HashMap<>();
        // Create StringBuilder obj
        StringBuilder myBuilder = new StringBuilder("");
        // create index variable=0
        int index = 0;
        // for each str in strs, 
            // add index and value
            // append str to stringbuilder?
        for (String str : strs) {
            myMap.put(index, str);
            myBuilder.append(str);
            index++;
        }

        //at this point hashmap should be filled with index and String
        // and stringuilder obj should be all one string
        //so return string an dleave hashmap to be used by decode

        return myBuilder.toString();
        
    }

    public List<String> decode(String str) {
        //We have a filled hashmap with index and value pairs
        List<String> arrayList = new ArrayList<>();

        //create arraylist
        //add each value to arraylist by index
        for(int i = 0; i < myMap.size(); i++) {
            arrayList.add(myMap.get(i));
        }
        return arrayList;

    }
}
