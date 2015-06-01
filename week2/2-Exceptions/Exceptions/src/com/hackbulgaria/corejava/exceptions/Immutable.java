package com.hackbulgaria.corejava.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.io.Serializable;
import java.lang.*;

import org.apache.commons.lang.*;





public class Immutable<E> extends ArrayList<E> implements List<E> {
    private List<E> list = new ArrayList<E>();
    
    public Immutable(Collection<? extends E> collection){
        
        for(E coll:collection){
            this.list.add((E) SerializationUtils.clone((Serializable) coll));
         }
    }
    
    public static <E> List<E> asList(E... arguments){
        List<E> list = Arrays.asList(arguments);
       
        Immutable<E> output = new Immutable<E>(list);
        return output;
    }
    
    

    @Override
    public boolean add(E arg0) {
     throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public void add(int arg0, E arg1) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

  
    @Override
    public boolean contains(Object arg0) {
        return this.list.contains(arg0);
    }




    @Override
    public E get(int arg0) {
        return (E) SerializationUtils.clone(arg0);
    }

    @Override
    public int indexOf(Object arg0) {
        return this.list.indexOf(arg0);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }

    @Override
    public int lastIndexOf(Object arg0) {
        return this.list.lastIndexOf(arg0);
    }

    @Override
    public ListIterator<E> listIterator() {
        return this.list.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int arg0) {
        return this.list.listIterator(arg0);
    }

    @Override
    public E remove(int arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public boolean remove(Object arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public boolean removeIf(Predicate<? super E> arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    protected void removeRange(int arg0, int arg1) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public void replaceAll(UnaryOperator<E> arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public E set(int arg0, E arg1) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public void sort(Comparator<? super E> arg0) {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

   
    @Override
    public List<E> subList(int arg0, int arg1) {
        return this.list.subList(arg0, arg1);
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return super.toArray();
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO Auto-generated method stub
        return super.toArray(arg0);
    }

    @Override
    public void trimToSize() {
        throw new UnsupportedOperationException("The List is immutable!!!");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
