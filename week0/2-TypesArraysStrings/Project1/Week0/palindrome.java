package Week0;

/**
 *
 * @author Desislava
 */
public class palindrome {
    public static boolean isPalindrome(long number) {
        long palindrome = number; 
        int reverse = 0;

        while (palindrome != 0) {
            long remainder = palindrome % 10;
            reverse = (int) (reverse * 10 + remainder);
            palindrome = palindrome / 10;
        }
        
        if (number == reverse) {
            return true;
        }
        return false;
    }
    
    public static long getLargestPalindrome(long N){
       long result=1;
        for (long i=1;i<N;i++){
            if(isPalindrome(i)){
                result=i;  
            }
        }
        return result;
    }
    public static void main(String []args){
        System.out.println(isPalindrome(99));
        System.out.println(getLargestPalindrome(101));
    }

}
