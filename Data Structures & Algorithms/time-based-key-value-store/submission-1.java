class TimeMap {

    //key: foo | values<val, time>: [[bar, 1],[bar2, 4]]
    //key<String>, value<Map<key, List>>
    //already in sorted order

    private Map<String, TreeMap<Integer, String>> myMap;

    public TimeMap() {
        myMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        //if myMap of that key has a null value(nothing)
        //use lambda function to set as the value
        //otherwise get the value of the key
        myMap.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        //binary search to achieve log time complexity
        String empty = "";
        if (!myMap.containsKey(key)) {
            return empty;
        }
        
        TreeMap<Integer, String> sortedMap = myMap.get(key);

        Integer recent = null;

        for(Integer time : sortedMap.keySet()) {
            if (time <= timestamp) {
                recent = time;
            } else {
                break; // found the recent
            }
        }
        // recent == null ? return empty : return sortedMap.get(recent);
        if (recent == null) {
            return empty;
        } else {
            return sortedMap.get(recent);
        }
    }
}
