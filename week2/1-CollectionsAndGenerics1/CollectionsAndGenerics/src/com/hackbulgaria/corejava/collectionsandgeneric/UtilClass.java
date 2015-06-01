package com.hackbulgaria.corejava.collectionsandgeneric;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UtilClass {


    static String convertHashMap(HashMap<? extends Object, ? extends Object> hashMap){
        StringBuilder converted = new StringBuilder();
        converted.append("{");
        for(Entry<? extends Object, ? extends Object> elements  : hashMap.entrySet()){
           converted.append(elements.getKey()+":"+elements.getValue()+"; ");
        }
        converted.delete(converted.length()-2, converted.length());
        converted.append("}");
        return converted.toString();
    }
    
    static Map<String, Integer> occurancesOFWordsinText(String text) {

        Map<String, Integer> hm = new LinkedHashMap<String, Integer>();
        StringBuilder container = new StringBuilder();
        int index = 2;

        for (int e = 0; e < text.length(); e++) {
            while (text.charAt(e) != ' ' && e < text.length() - 1) {
                container.append(text.charAt(e));
                e++;
            }

            if (text.length() - 1 == e) {
                container.append(text.charAt(e));
            }
            if (hm.containsKey(container.toString())) {
                hm.put(container.toString(), index);
                index++;
            }
            else{
                hm.put(container.toString(), 1);
            }
            container.delete(0, container.length());

        }
        return hm;
    }
   
    
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Dessy", 21);
        map.put("Peter", 27);
        map.put("Anelia", 25);
        map.put("Tinka", 28);
        String result = UtilClass.convertHashMap(map);
        System.out.println(result);
        
        Map<String, Integer> results = UtilClass.occurancesOFWordsinText("Ninjas are all over the place! We are all going to die!");
        System.out.println(results);
        
       
    }
}
