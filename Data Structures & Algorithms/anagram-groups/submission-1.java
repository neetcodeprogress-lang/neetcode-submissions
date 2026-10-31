class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //HashMap using key: SortedString 
        //              and value: List<String> anagramsOfSortedString
        //ex: Key: "ate", val: ["eat", "tea", "ate"]
        
        Map<String, List<String>> myMap = new HashMap<>();

        // iterate through each string
        //     for each string sort it
        for (String s : strs) {

            char [] myS = s.toCharArray();
            Arrays.sort(myS);
            String tempSortedString = new String(myS);
            myMap.putIfAbsent(tempSortedString, new ArrayList<String>());
            
        //   if a list<String>already exists in keys for
        //   that sorted string then add the original
        //   string to that list for that specific key
            myMap.get(tempSortedString).add(s);

            // if (myMap.containsKey(tempSortedString)) {
            // } else {
            // //         else make a new key with that sorted string,
            // //             and add a new list with that string inside
            // //             of that list

            // }
            
        }

        // List<List<String>> outputList = new ArrayList<List<String>>(myMap.values());
        
        // return outputList;
        return new ArrayList<>(myMap.values());
    }
}
