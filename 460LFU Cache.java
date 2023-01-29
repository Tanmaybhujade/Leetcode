        class LFUCache {

        private Map<Integer, Integer> keyValues = new HashMap<>();
        private Map<Integer, Integer> keyCounts = new HashMap<>();
        private Map<Integer, LinkedHashSet<Integer>> countToRefs = new HashMap<>();

        private Integer capacity;
        private Integer size = 0;
        private int minCount = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = keyValues.get(key);
            if (value == null) {
                return -1;
            }

            incrementCounterForKey(key, keyCounts.get(key));
            return value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            
            Integer old = keyValues.get(key);
            if (size < capacity || old != null) {
                keyValues.put(key, value);
                Integer count = keyCounts.get(key);
                if (count == null) {
                    incrementCounterForKey(key, 0);
                } else {
                    incrementCounterForKey(key, count);
                }

                if (old == null) {
                    size++;
                }

            } else {

                LinkedHashSet<Integer> set = countToRefs.get(minCount);
                Integer removedKey = set.iterator().next();
                set.remove(removedKey);
                keyValues.remove(removedKey);
                keyCounts.remove(removedKey);

                size--;
                put(key, value);
            }
        }

        private void unsetCounter(Integer key, Integer count) {
            LinkedHashSet<Integer> oldSet = countToRefs.get(count);
            oldSet.remove(key);
            if (oldSet.isEmpty()) {
                if (minCount == count) {
                    minCount = count + 1;
                }
            }
        }

        private void incrementCounterForKey(Integer key, Integer counter) {
            if (counter == 0) {
                minCount = 1;
            } else {
                unsetCounter(key, counter);
            }

            LinkedHashSet<Integer> newSet = countToRefs.getOrDefault(counter + 1, new LinkedHashSet<>());
            newSet.add(key);
            countToRefs.put(counter + 1, newSet);
            keyCounts.put(key, counter + 1);
        }
}
