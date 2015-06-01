package Week0;
/**
 *
 * @author Desislava
 */
public class StringPalindrome {
    public static boolean isPalindrome(String argument){
      boolean flag = true;
      int br= argument.length()-1;
      for(int i=0;i<=argument.length()/2;i++){
          if(argument.charAt(i)!= argument.charAt(br)){
              flag=false;
              break;
          }
          else{
              flag=true;
              br--;
          }
      }
      return flag;
    }
    
    public static void main(String[] args){
         System.out.println(isPalindrome("kakawakak"));
    }
    
}
