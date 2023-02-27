package DsaCoursework;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

    public class LFUCache<K, V> {

        private final Map<K, V> cache;
        private final Map<K, Integer> freq;
        private final Map<Integer, LinkedHashSet<K>> freqKeys;
        private final int capacity;
        private int minFreq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            freq = new HashMap<>();
            freqKeys = new HashMap<>();
            minFreq = 0;
        }

        public synchronized void add(K key, V value) {
            if (cache.size() >= capacity) {
                evict();
            }
            cache.put(key, value);
            freq.put(key, 1);
            freqKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }

        public synchronized V get(K key) {
            if (!cache.containsKey(key)) {
                return null;
            }
            int curFreq = freq.get(key);
            freq.put(key, curFreq + 1);
            freqKeys.get(curFreq).remove(key);
            if (curFreq == minFreq && freqKeys.get(curFreq).isEmpty()) {
                minFreq++;
            }
            freqKeys.computeIfAbsent(curFreq + 1, k -> new LinkedHashSet<>()).add(key);
            return cache.get(key);
        }

        public synchronized void remove(K key) {
            if (!cache.containsKey(key)) {
                return;
            }
            int curFreq = freq.get(key);
            freq.remove(key);
            freqKeys.get(curFreq).remove(key);
            cache.remove(key);
            if (curFreq == minFreq && freqKeys.get(curFreq).isEmpty()) {
                minFreq++;
            }
        }

        private void evict() {
            Set<K> evictKeys = freqKeys.get(minFreq);
            K evictKey = evictKeys.iterator().next();
            evictKeys.remove(evictKey);
            cache.remove(evictKey);
            freq.remove(evictKey);
        }

}
