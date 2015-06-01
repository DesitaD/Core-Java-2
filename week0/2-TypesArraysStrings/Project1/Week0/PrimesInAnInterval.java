
package Week0;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Desislava
 */
public class PrimesInAnInterval {
// function that give us all prime numbers in a given interval
    public static ArrayList<Integer> primesInAnInterval(int start, int end){
    ArrayList <Integer> primesList = new ArrayList <> ();
    if(start>0 && end>0 && start<end){
    for (int i=start;i<=end; i++){
        boolean prime = true;      
         if (i%2 == 0 && i >2){
             prime =  false;
         }
       for (int j = 3; j < Math.sqrt(i); j+=2) {
           if (i % j == 0) {
               prime =  false;
           }
       }
       if (prime)
           primesList.add(i);
       }
    }
    else 
        System.out.print("Invalid input!");
    return primesList;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a start index:");
        int start= in.nextInt();
        System.out.println("Enter an end index:");
        int end= in.nextInt();
        ArrayList<Integer> primes = primesInAnInterval(start,end);
        for (int p:primes){
            System.out.printf("%d, ",p);
        }
        System.out.println();
    }
    
}
