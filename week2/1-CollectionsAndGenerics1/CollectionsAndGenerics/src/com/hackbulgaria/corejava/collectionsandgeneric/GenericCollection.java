package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericCollection {

    public static <T> void reverse(Collection<T> collection) {
        int start = 0;
        int end = collection.size() - 1;
        T temp;

        T[] array = (T[]) collection.toArray();
        while (start <= end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;

        }
        System.out.println(collection);
        collection.clear();
        for (int i = 0; i < array.length; i++) {
            collection.add((T) array[i]);
        }
        System.out.println(collection);
    }

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);

        reverse(collection);

    }

}
