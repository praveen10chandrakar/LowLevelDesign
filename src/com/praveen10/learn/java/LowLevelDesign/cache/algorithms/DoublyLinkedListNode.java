package com.praveen10.learn.java.LowLevelDesign.cache.algorithms;

public class DoublyLinkedListNode<E> {
    private E element;
    private DoublyLinkedListNode<E> prev;
    private DoublyLinkedListNode<E> next;

    public DoublyLinkedListNode(E element){
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DoublyLinkedListNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<E> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<E> next) {
        this.next = next;
    }
}
