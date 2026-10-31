class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //set l = 0, r = s1.length() - 1
        int l = 0;
        int r = s1.length() - 1;

        //go thru s2
        while(r < s2.length()) {
            if (isPermutation(s1, s2.substring(l, r + 1))) {
                return true;
            } else {
        // window is permutation ? return true : keep iterating
            //iterating: l++, r++
                l++;
                r++;
            }
        }
        //if no permutation found, return false
        return false;
    }
    
    public boolean isPermutation(String s1, String substring)  {
        //add s1 chars to map<Character, Integer>
        HashMap<Character,Integer> myMap = new HashMap<>();

        for(Character c : s1.toCharArray()) {
            if(myMap.containsKey(c)) {
                Integer count = myMap.get(c);
                myMap.put(c, count + 1);
            } else {
                myMap.putIfAbsent(c, 1);
            }
        }
        //check if substring chars match

        for(Character c : substring.toCharArray()) {
            if (!myMap.containsKey(c)) {
                return false;
            } else {
                //else map.get(character) -= 1
                Integer count = myMap.get(c);
                myMap.put(c, count - 1);
                count = myMap.get(c);
                if (count == 0 || count < 0) {
                    //remove key
                    myMap.remove(c);
                }
            }
        }

        return myMap.isEmpty();
    }
}
