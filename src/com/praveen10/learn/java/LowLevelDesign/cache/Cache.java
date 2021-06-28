package com.praveen10.learn.java.LowLevelDesign.cache;

import com.praveen10.learn.java.LowLevelDesign.cache.algorithms.exceptions.InvalidElementException;
import com.praveen10.learn.java.LowLevelDesign.cache.policies.EvictionPolicy;
import com.praveen10.learn.java.LowLevelDesign.cache.storage.Storage;
import com.praveen10.learn.java.LowLevelDesign.cache.storage.exceptions.NotFoundException;
import com.praveen10.learn.java.LowLevelDesign.cache.storage.exceptions.StorageFullException;

public class Cache <Key, Value>{

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException | InvalidElementException e) {
            System.out.println("Got storage full. Will try to evict.");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            try {
                this.storage.remove(keyToRemove);
            } catch (NotFoundException notFoundException) {
                notFoundException.printStackTrace();
            }
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }

    }

    public Value get(Key key){
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException | InvalidElementException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
