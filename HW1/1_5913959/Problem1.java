/*********************************************************************
 Purpose/Description: <Determine whether a given integer is an Array >
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package problem1;

import java.util.Scanner;
public class Problem1 {

    
    
    public static void main(String[] args) {
       int[] myArray = {4, 5, 7, 14, 11, 4, 3,2, -4, -8};       
       
       System.out.println("Enter the number you want to search: ");
       Scanner scan = new Scanner(System.in);
       int target = scan.nextInt();
       
       System.out.println("Result: " + isInArray(target,myArray ,myArray.length));   
    }
    
    //// Here Starts the Problem Algorithm Solution////////
    ////Complexity is O(log n)
    
    //This function uses three binary search functions each function O(log n)
     //.....so general complexity O(log n)
    public static boolean isInArray(int t, int[] arr, int n){
       int k = Binary_find_K(arr, n);
       return Binary_search_up(arr, 0,k, t) || Binary_search_down(arr, k,n-1, t);
    }
    
   //Binary search used to find the K index where the array change sorting order O(log n) 
    public static int Binary_find_K(int[] A, int n){
        
        int low_limit = 0;
        int high_limit = n-1;
        int middle = n/2; 
        
       while(low_limit <= high_limit)
        {
            if(A[middle] > A[middle-1] && A[middle] > A[middle+1] )
                return middle;
            
            if(A[middle] < A[middle+1])
                low_limit = middle+1;
            else
                high_limit = middle-1;   
            
            middle = (high_limit + low_limit)/2;
        }       
       
        return -1;
    }
    
    //Binary search used to find if the target element is in the first part of the array O(log n)
    public static boolean Binary_search_up(int[] A, int low, int high, int t){
        
        int middle = (high + low)/2;
        
        while(low <= high){
            if( t== A[middle])
                return true;
            
            if(t>= A[middle])
                low = middle+1;
            else
                high = middle-1;   
            
            middle = (high + low)/2;
        }
        return false;   
    }
    
    //Binary search used to find if the target element is in the last part of the array O(log n)
     public static boolean Binary_search_down(int[] A, int low, int high, int t){
        
        int middle = (high + low)/2;
        
        while(low <= high){
            if( t== A[middle])
                return true;
            
            if(t<= A[middle])
                low = middle+1;
            else
                high = middle-1;   
            
            middle = (high + low)/2;
        }
        return false;   
    }
}
