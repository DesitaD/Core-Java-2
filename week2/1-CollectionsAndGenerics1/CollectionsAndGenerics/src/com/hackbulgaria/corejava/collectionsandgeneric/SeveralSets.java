package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SeveralSets {
    public static <T> HashSet<T> DuplicatesElinSets(Collection<T>... sets){
        HashSet<T> duplicates= new HashSet<T>();
        for(Collection<T> collection: sets){
            duplicates.addAll(collection);
        }
        for(Collection<T> collection: sets ){
            duplicates.retainAll(collection);
        }
        
        return duplicates;
    }

    public static void main(String[] args) {
        Collection<Integer> A = new ArrayList<Integer>();;
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        Collection<Integer> B= new ArrayList<Integer>();;
        B.add(4);
        B.add(5);
        B.add(6);
        Collection<Integer> C=new ArrayList<Integer>();;
        C.add(5);
        C.add(6);
        
        
      
       System.out.println(DuplicatesElinSets(A,B,C));

    }
;
}
