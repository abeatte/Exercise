package com.artbeatte.exercises.hashs;

import java.util.*;

/**
 * @author art.beatte
 * @version 10/18/15
 */
public class HashMapWTime<K, V> {

    private HashMap<K, TreeMap<Float, V>> mBuckets;

    public HashMapWTime() {
        mBuckets = new HashMap<>();
    }

    public V put(K key, float time, V value) {
        TreeMap<Float, V> values = mBuckets.get(key);
        if (values == null) {
            values = new TreeMap<>();
            mBuckets.put(key, values);
        }
        return values.put(time, value);
    }

    /**
     * Returns the value associated with time. If time is not present returns value associated with the next largest
     * value of time.
     * @return the value for time or times next largest present value
     */
    public V get(K key, float time) {
        TreeMap<Float, V> values = mBuckets.get(key);
        if (values == null) return null;
        Float floorTime = values.floorKey(time);
        return floorTime == null ? null : values.get(floorTime);
    }

    public V remove(K key, float time) {
        TreeMap<Float, V> values = mBuckets.get(key);
        return values == null ? null : values.remove(time);
    }

    public boolean isEmpty() {
        if (mBuckets.isEmpty()) return true;
        boolean isEmpty = true;
        Iterator<K> itr = mBuckets.keySet().iterator();
        while (itr.hasNext() && isEmpty) {
            isEmpty = mBuckets.get(itr.next()).isEmpty();
        }
        return isEmpty;
    }
}
