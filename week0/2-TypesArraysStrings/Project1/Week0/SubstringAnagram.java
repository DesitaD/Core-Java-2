package Week0;

import static Week0.Anagrams.anagram;
import java.util.ArrayList;

/**
 *
 * @author Desislava
 */
public class SubstringAnagram {

    public static boolean hasAnagramOf(String A, String B) {
        ArrayList<String> list = new ArrayList<>();
        boolean flag = false;
        String sub;
        int j = 0;
        for (int c = 0; c < B.length(); c++) {
            for (int i = 1; i <= B.length() - c; i++) {
                sub = B.substring(c, c + i);
                if (sub.length() == A.length()) {
                    list.add(j, sub);
                    j++;
                }

            }
        }
        for (int index = 0; index < list.size(); index++) {
            if (anagram(A, list.get(index))) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }
    
    public static void main(String[] args){
        System.out.println(hasAnagramOf("pak","klmtyuiytrewqakdmnbvc"));
    }
    
}
