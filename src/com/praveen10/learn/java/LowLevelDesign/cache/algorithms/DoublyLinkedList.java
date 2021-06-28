package com.praveen10.learn.java.LowLevelDesign.cache.algorithms;

import com.praveen10.learn.java.LowLevelDesign.cache.algorithms.exceptions.InvalidElementException;

public class DoublyLinkedList <E>{

    private DoublyLinkedListNode<E> dummyHead;
    private DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList(){
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);
        this.dummyHead.setNext(dummyTail);
        this.dummyTail.setPrev(dummyHead);
    }

    public boolean isEmpty(){
        return this.dummyHead.getNext() == dummyTail;
    }

    public DoublyLinkedListNode<E> getFirstNode(){
        if(isEmpty()){
            return null;
        }
        return dummyHead.getNext();
    }

    public void remove(DoublyLinkedListNode<E> node){
        if(node != null){
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void addLast(DoublyLinkedListNode<E> node){
        DoublyLinkedListNode<E> tailPrev = dummyTail.getPrev();
        tailPrev.setNext(node);
        node.setNext(dummyTail);
        dummyTail.setPrev(node);
        node.setPrev(tailPrev);
    }

    public DoublyLinkedListNode<E> addLast(E element) throws InvalidElementException {
        if (element == null){
            throw new InvalidElementException();
        }

        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addLast(newNode);
        return newNode;

    }

    public DoublyLinkedListNode<E> getLastNode(){
        if(isEmpty()){
            return null;
        }
        return dummyTail.getPrev();
    }

}
