package com.praveen10.learn.java.LowLevelDesign.cache.policies;

import com.praveen10.learn.java.LowLevelDesign.cache.algorithms.exceptions.InvalidElementException;

public interface EvictionPolicy <Key> {

    void keyAccessed(Key key) throws InvalidElementException;

    // Evict key from eviction policy and return it.
    Key evictKey();

}
