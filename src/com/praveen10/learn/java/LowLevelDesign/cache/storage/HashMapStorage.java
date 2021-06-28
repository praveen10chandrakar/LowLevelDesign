package com.praveen10.learn.java.LowLevelDesign.cache.storage;

import com.praveen10.learn.java.LowLevelDesign.cache.storage.exceptions.NotFoundException;
import com.praveen10.learn.java.LowLevelDesign.cache.storage.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K, V> implements Storage<K, V>{

    private Map<K, V> storage;
    private final Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }


    @Override
    public void add(K k, V v) throws StorageFullException {
        if(isFull()) throw new StorageFullException("Capacity full...");
        storage.put(k, v);
    }

    @Override
    public void remove(K k) throws NotFoundException {
        if(!storage.containsKey(k)) throw new NotFoundException(k + " doesn't exist in cache.");
        storage.remove(k);
    }

    @Override
    public V get(K k) throws NotFoundException {
        if(!storage.containsKey(k)) throw new NotFoundException(k + " doesn't exist in cache.");
        return storage.get(k);
    }

    public boolean isFull(){
        return storage.size() == capacity;
    }

}
