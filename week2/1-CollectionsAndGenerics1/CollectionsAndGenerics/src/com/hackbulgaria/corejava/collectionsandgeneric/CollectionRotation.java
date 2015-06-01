package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class CollectionRotation {

    public static <T> void rotate(Collection<T> collection, int rotateStep) {
        T[] rotacion = (T[]) collection.toArray();
        T[] rotateCollection = (T[]) new Object[rotacion.length];
        
      Deque<T> deq= new LinkedList<T>(collection);
              
              
        if (rotateStep == 0)
            System.out.println(collection);
        else if(rotateStep>0){
            for (int i = 0; i < rotateStep; i++) {
                T temp = deq.removeLast();
                deq.addFirst(temp);
                
            }
        }
        else{
            for (int i = rotateStep; i < 0; i++){
                T temp = deq.removeFirst();
                deq.addLast(temp);
            }
        }
        
        System.out.println(deq.toString());
    }

    public static void main(String[] args) {
        Collection<Integer> rot = new ArrayList<Integer>();
        rot.add(1);
        rot.add(2);
        rot.add(3);
        rot.add(4);
        rotate(rot, -1);

    }

}
