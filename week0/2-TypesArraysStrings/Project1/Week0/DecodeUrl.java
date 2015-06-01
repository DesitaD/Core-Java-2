package Week0;

/**
 *
 * @author Desislava
 */
public class DecodeUrl {
   public static String decodeUrl(String input){
       
       return input.replaceAll("%20", " ").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
   }
   public static void main(String []args){
        System.out.println(decodeUrl("kitten%20pic.jpg"));
    }
}
