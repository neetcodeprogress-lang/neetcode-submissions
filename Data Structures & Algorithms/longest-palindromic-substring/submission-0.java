class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int max = 0;
        HashMap<Integer, List<Integer>> myMap = new HashMap<>();
        for(int i = 1; i < s.length() - 1; i++) {
            int l = i - 1;
            int r = i + 1;
            int count = 1;
            
            while((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))) {
                count++;
                l--;
                r++;
            }
            if(!myMap.containsKey(count)) {
                myMap.put(count, Arrays.asList(l + 1, r));
                max = Math.max(count, max);
            }
            l = i;
            r = i + 1;
            count = 1;
            while((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))) {
                count++;
                l--;
                r++;
            }
            if(!myMap.containsKey(count)) {
                myMap.put(count, Arrays.asList(l + 1, r));
                max = Math.max(count, max);
            }
        }

        List<Integer> indices = myMap.get(max);
        return s.substring(indices.get(0), indices.get(1));

        //find middle
        //length 2: l=0,r=1. length 4: l=1,r=2. length 6: l=2,r=3
        //length 3: l=0,r=2. length 5: l=1,r=3. length 7: l=2,r=4
        //basically, if len % 2 == 0, r is len / 2
        //  else, r is (len / 2) + 1


        //while l and r are within bounds and they equal each other
            //count++

        //add it to hashmap of count : word(string)
    }
}
