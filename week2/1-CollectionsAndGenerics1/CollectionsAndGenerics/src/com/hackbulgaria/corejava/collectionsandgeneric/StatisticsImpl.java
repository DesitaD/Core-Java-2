package com.hackbulgaria.corejava.collectionsandgeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class StatisticsImpl implements Statistics {
    private ArrayList<Integer> list;
    
    
 

    public StatisticsImpl(ArrayList<Integer> list) {
        super();
        this.list = list;
        
    }
    public void add(int number){
        list.add(number);
    }
    
//    @Override
//    public Iterator<StatisticsImpl> iterator() {
//     Iterator<StatisticsImpl> it = new Iterator<StatisticsImpl>() {
//
//            private int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < list.size() && list.get(currentIndex) != null;
//            }
//
//            @Override
//            public StatisticsImpl next() {
//                return list.get(currentIndex++);
//            }
//            
//        return it;
//    }
    
    @Override
    public float getMean() {
        float sum=0;
        for(int i=0; i<list.size();i++){
            sum+=list.get(i);
        }
        return sum/list.size();
    }

    @Override
    public float getMedian() {
        if(list.size()%2 != 0){
            return list.get(list.size()/2);
        }
        else{
        return (list.get(list.size()/2-1)+list.get(list.size()/2))/2;
        }
    }

    @Override
    public float getMode() {
        Collections.sort(list);
        int counter=0,most=0;
        int temp=0;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).equals(list.get(i+1))){
                counter++;
            }
            
                if(most<counter){
                    most=counter;
                    temp=list.get(i);
                }
                counter=0;

            }
        
        return temp;
    }

    @Override
    public float getRange() {
        Collections.sort(list);
        
        return list.get(list.size()-1)-list.get(0);
    }

    
    public static void main(String[] args) {
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(15);
        elements.add(11);
        elements.add(20);
        elements.add(11);
        elements.add(15);
        elements.add(25);
        elements.add(11);
        elements.add(10);
        elements.add(11);
        elements.add(11);
        elements.add(20);
       
        
       StatisticsImpl lili=new StatisticsImpl(elements);
       lili.add(0);
   
       System.out.println(elements.size());
       System.out.println(lili.getMedian());
       System.out.println(lili.getMode());
       System.out.println(lili.getRange());

    }
  
}
