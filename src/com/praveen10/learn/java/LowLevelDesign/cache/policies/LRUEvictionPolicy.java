package com.praveen10.learn.java.LowLevelDesign.cache.policies;

import com.praveen10.learn.java.LowLevelDesign.cache.algorithms.DoublyLinkedList;
import com.praveen10.learn.java.LowLevelDesign.cache.algorithms.DoublyLinkedListNode;
import com.praveen10.learn.java.LowLevelDesign.cache.algorithms.exceptions.InvalidElementException;

import java.util.Map;

public class LRUEvictionPolicy <Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(DoublyLinkedList<Key> dll, Map<Key, DoublyLinkedListNode<Key>> mapper) {
        this.dll = dll;
        this.mapper = mapper;
    }

    @Override
    public void keyAccessed(Key key) throws InvalidElementException {
        if (mapper.containsKey(key)){
            dll.remove(mapper.get(key));
            dll.addLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> node = dll.addLast(key);
            mapper.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = dll.getFirstNode();
        if(node == null){
            return null;
        }
        dll.remove(node);
        return node.getElement();
    }

}
