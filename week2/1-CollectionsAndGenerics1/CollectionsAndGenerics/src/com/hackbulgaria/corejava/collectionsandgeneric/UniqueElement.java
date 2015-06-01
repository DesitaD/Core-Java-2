package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.Arrays;
import java.util.Collection;

public class UniqueElement {
    public static <T> int firstUniqueElement(Collection<T> col) {
        T[] array = (T[]) col.toArray();
        int counter = 0;
        int unique = 0;
        for (int index = 0; index < array.length; index++) {
            for (int i = 0; i < array.length; i++) {
                if (array[index].equals(array[i])) {
                    counter++;
                }
            }
            if (counter == 1) {
                unique = (int) array[index];
                break;
            }
            counter = 0;
        }
        return unique;
    }

    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 1, 44, 4, 55, 5, 4, 3, 1);
        System.out.println(firstUniqueElement(ints));

    }

}
