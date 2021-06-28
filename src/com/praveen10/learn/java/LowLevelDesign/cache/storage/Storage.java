package com.praveen10.learn.java.LowLevelDesign.cache.storage;

import com.praveen10.learn.java.LowLevelDesign.cache.storage.exceptions.NotFoundException;
import com.praveen10.learn.java.LowLevelDesign.cache.storage.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
}
