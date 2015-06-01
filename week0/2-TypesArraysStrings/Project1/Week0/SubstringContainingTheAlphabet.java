package Week0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Desislava
 */
public class SubstringContainingTheAlphabet {
// funtion that give us the smallest substring that contains all letters from english alphabet
    public static void smallestSubstringContainingTheAlphabet(String str) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listWithAlphabet = new ArrayList<>();
        String sub;
        int i, c, length;
        length = str.length();
        if (length<26){
            System.out.println("The string doesn't contains all letters form the alphabet!");}
        System.out.println("Smallest substring of \"" + str + "\" is :-");
         if (length<26){
            System.out.println("The string doesn't contains all letters form the alphabet!");
         }else{
        int j = 0, r = 0;
        // take the substrings which have length bigger or equal to 26
        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                sub = str.substring(c, c + i);
                if (sub.length() >= 26) {
                    list.add(j, sub);
                    j++;
                }
            }
        }
        // function that checks if the substring contains all letters from the alphabet
        boolean flag = false;
        for (int p = 0; p < list.size(); p++) {
            for (char t = 'a'; t < 'z' + 1; t++) {
                if (list.get(p).contains("" + t)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                listWithAlphabet.add(r, list.get(p));
            }
        }

        int min = listWithAlphabet.get(0).length(), index = 0;
// get the smallest substring 
        for (int g = 1; g < listWithAlphabet.size(); g++) {
            if (min > listWithAlphabet.get(g).length()) {
                min = listWithAlphabet.get(g).length();
                index = g;
            }
        }
        System.out.println(listWithAlphabet.get(index));
         }
    }
    public static void main(String args[]) {
       
        String str;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        str = in.nextLine();
        boolean flag = true;
        // check if the string contains only characters from ASCII table
        for (int i=0; i<str.length(); i++){
           if(str.charAt(i)>=0 && str.charAt(i)<=255)
               flag= true;
           else{
               flag=false;
               break;
           }
        }
        if(flag==false){ 
            System.out.println("The string must contans only characters from ASCII table!!!");
        }
        else{
        smallestSubstringContainingTheAlphabet(str.toLowerCase());
        }
    }
}
