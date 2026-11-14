class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*

        look at first element of strs
            if not an anagram of any existing elements in output
            list, then add to next element of outputList

            if is anagram of existing elements in outputList,
            then add to that listElement of outputList
        
        then go to next element, repeat until we iterate thru
        all of the elements

        finally return the outputList
        */

        //create outputList
        List<List<String>> outputList = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<>();
        //iterate through strs, 
        for (String str : strs) {
            //str = "pots"
            boolean anagramExists = false; 
            if (outputList.size() <= 0) {
                    //add to outputList
                    tempList.add(str);
                    outputList.add(tempList);
                    tempList.clear();
            } else {
                for (List<String> listString : outputList) {
                    // [["act"]]
                    if (isAnagram(listString.get(0), str)) {
                        anagramExists = true;
                    } else {
                        tempList.add(str);
                        outputList.add(tempList);
                        tempList.clear();
                    }
                    if (anagramExists) {
                        // add to that listElement
                        listString.add(str);
                        
                        //now reset anagramExists for other str
                        anagramExists = false;
                    }
                }
            }
            
        }
        return outputList;
    }

    public static boolean isAnagram(String s, String t) {
        //first compare lengths
        //if they are the same, sort them out, and compare each char?

        if (s.length() != t.length()) {
            return false;
        } else {
            char [] sCharArray= s.toCharArray();
            char [] tCharArray= t.toCharArray();

            Arrays.sort(sCharArray);
            Arrays.sort(tCharArray);

            for (int i = 0; i < sCharArray.length; i++) {
                if (sCharArray[i] != tCharArray[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
