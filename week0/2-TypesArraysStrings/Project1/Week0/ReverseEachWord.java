package Week0;

/**
 *
 * @author Desislava
 */
public class ReverseEachWord {
    public static String reverseEveryChar(String arg){
        String[] split = arg.split("\\s+");
        for(int i=0;i<split.length;i++){
           System.out.println(split[i]);  
        }  
        String[] reversed=new String[split.length];
        for(int i=0; i<split.length;i++){
     StringBuilder result= new StringBuilder(split[i]);
     reversed[i]= result.reverse().toString();
        }
    return reversed.toString(); 
 }   
 
 public static void main(String[] args){
     String k="What is this";
     System.out.println(reverseEveryChar(k));
 }
}
