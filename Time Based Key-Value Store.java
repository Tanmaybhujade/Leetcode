class TimeMap {
    
    class Pair {
        public String value;
        public int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    
    private Map<String, List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> lst = map.get(key);
        int l = 0, r = lst.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int time = lst.get(mid).timestamp;
            if (time < timestamp) {
                l = mid + 1;
            } else if (time > timestamp) {
                r = mid - 1;
            } else return lst.get(mid).value;
        }
        return (l < lst.size() && lst.get(l).timestamp <= timestamp) ? lst.get(l).value : (r >= 0 ? lst.get(r).value : "");
    }
}
