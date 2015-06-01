package com.hackbulgaria.corejava.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapWithoutNULLKey extends HashMap{
    boolean flag=false;
    
    public HashMapWithoutNULLKey() {
        super();
    }
    

    public boolean isFlag() {
        return flag;
    }



    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    
    @Override
    public boolean containsKey(Object arg0) {
        
        // TODO Auto-generated method stub
        return super.containsKey(arg0);
    }

  



    @Override
    public Object get(Object arg0) {
       if(this.isFlag()){
           return super.get(arg0);
       }
       else{
       if(arg0!= null){
        return super.get(arg0);
       }
       else{
           throw new NullPointerException("Incorrect key! The key can't be null!!!");
       }
       }
    }

   
    @Override
    public Object put(Object arg0, Object arg1) {
        if(this.isFlag()){
            return super.put(arg0, arg1);
        }
        else{
        if (arg0!=null && arg1!=null){
        return super.put(arg0, arg1);
        }
        else {
            throw new NullPointerException();
        }
        }
    }

    @Override
    public void putAll(Map arg0) {
        if(this.isFlag()){
        super.putAll(arg0);
        }
        else{
            if(arg0.containsKey(null) && arg0.containsValue(null)){
                arg0.remove(null);
                super.putAll(arg0);   
            }
        }
    }

    @Override
    public Object putIfAbsent(Object arg0, Object arg1) {
        if(this.isFlag()){
            return super.putIfAbsent(arg0, arg1);
        }
        else{
            if (arg0!=null && arg1!=null){
        
            return super.putIfAbsent(arg0, arg1);
            }
            else {
                throw new NullPointerException();
            }
    }
        
    }

    public static void main(String[] args) {
        HashMapWithoutNULLKey hmn=new HashMapWithoutNULLKey();
        hmn.put(null, null);
        HashMap hm= new HashMap();
        hm.put(null, null);

    }

}
