class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //create hashmap of String, List<String>

        //iterate through strs
            //temp string is copy of str
            //if temp exists, add str to the value list
            //if not, add the sorted string : list.add(unsorted string)
        
        //return a list containing the values of the hashmap

        HashMap<String, List<String>> myMap = new HashMap<>();
        for(String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            if(myMap.containsKey(sortedStr)) {
                myMap.get(sortedStr).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                myMap.put(sortedStr, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> value : myMap.values()) {
            res.add(value);
        }
        return res;
    }
}
