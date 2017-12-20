/*********************************************************************
 Purpose/Description: <Determine the numbers of occurrences of the input value k in an Array>
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/
package problem3;

import java.util.Scanner;
public class Problem3 {

     
    public static void main(String[] args) {
       int[] myArray = {-1, 2,3, 5,5,5,5, 5,6, 6,6, 6, 6, 9, 9,9,9,10};
       System.out.println("Enter the number you want to search: ");
       Scanner scan = new Scanner(System.in);
       int target = scan.nextInt();
       
       System.out.println("Occurrences: " + occurrence(myArray, myArray.length, target));
    }
    
    //// Here Starts the Problem Algorithm Solution////////
    ////Complexity is O(log n)
    
   //This function use two function to get the lower and higher indexes of the value searched
    //Each function uses binary search O(log n).....so general complexity O(log n)
    public static int occurrence(int[] S,int n, int t){
        int low_index = 0;
        int high_index = 0;
        
        low_index = Binary_low_index(S,n,t);
        if(low_index == -1)
            return 0;
        
        high_index = Binary_high_index(S,n,t);
           return high_index - low_index + 1;
    }
     
    public static int Binary_low_index(int[] A, int n, int t){
        int low_limit = 0;
        int high_limit = n-1;
        int middle = n/2;
        
        if(t == A[low_limit])
            return low_limit;
        
        while(low_limit <= high_limit || t == A[middle]){
            if( t== A[middle] && t != A[middle-1])
                return middle;
            
            if(t> A[middle])
                low_limit = middle+1;
            else
                high_limit = middle-1;   
            
            middle = (high_limit + low_limit)/2;
        }
        return -1;
    }
    
    public static int Binary_high_index(int[] A, int n, int t){
        int low_limit = 0;
        int high_limit = n-1;
        int middle = n/2;
        
        if(t == A[high_limit])
            return high_limit;
        
        while(low_limit <= high_limit || t == A[middle]){
            if( t== A[middle] && t != A[middle+1])
                return middle;
            
            if(t>= A[middle])
                low_limit = middle+1;
            else
                high_limit = middle-1;   
            
            middle = (high_limit + low_limit)/2;
        }
        return -1;   
    }
}
