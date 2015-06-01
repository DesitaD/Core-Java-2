package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedQueue<T> {
    private Queue<T> boundedQue = new LinkedList<T>();
    private int size;
    private int bound;

    public BoundedQueue(int bound) {
        this.boundedQue = new LinkedList();
        this.size = 0;
        this.bound = bound;

    }

    public void offer(T item) {
        if (size < bound) {
            boundedQue.add(item);
            size++;
        } else {
            boundedQue.remove();
            boundedQue.add(item);
        }
    }

    public String toString() {
        return boundedQue.toString();

    }

    public static void main(String[] args) {
        BoundedQueue boundedQueue = new BoundedQueue(3);
        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);
        System.out.println(boundedQueue.toString());

    }

}
