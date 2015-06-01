package Week0;

/**
 *
 * @author Desislava
 */
public class NumberPalindrome {
    
    public static boolean isPalindrome(int argument){
        int palindrome = argument; 
        int reverse = 0;

        while (palindrome != 0) {
            long remainder = palindrome % 10;
            reverse = (int) (reverse * 10 + remainder);
            palindrome = palindrome / 10;
        }
        
        if (argument == reverse) {
            return true;
        }
        return false;
    }
     public static void main(String []args){
        System.out.println(isPalindrome(1233));
        
    } 
}
