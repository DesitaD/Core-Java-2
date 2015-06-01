package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class OnOffCollection<T> {
    private Collection<T> storage;

    public OnOffCollection(List<T> list) {
        super();
        this.storage = list;
    }

    public void addElement(T item) {
        if (item == null)
            throw new IllegalArgumentException("You should add a valid item!");
        else {
            if (!storage.contains(item)) {
                storage.add(item);
            } else {
                storage.remove(item);
            }
        }
    }

    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {

        List<Object> list = new ArrayList<Object>();
        OnOffCollection collectionss = new OnOffCollection(list);
        collectionss.addElement(1);
        collectionss.addElement(2);
        collectionss.addElement(3);
        collectionss.addElement(1);
        collectionss.addElement(3);
        collectionss.addElement(5);
        System.out.println(collectionss.toString());

    }
}
