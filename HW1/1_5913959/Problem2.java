/*********************************************************************
 Purpose/Description: <Determine the balance index of an Array >
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package problem.pkg2;


public class Problem2 {

    public static void main(String[] args) {
         int[] myArray = {-5, 3, 7, -8, -2, 5, 2};
        
         System.out.println("Balance Index = " + balIndex(myArray, myArray.length));  
    }
    
     //// Here Starts the Problem Algorithm Solution////////
    ////Complexity is O(n)
    public static int balIndex(int S[], int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += S[i];
        }
        
        if(sum == 0)
             return n-1;
        
        int lowsum = 0;      //Lowsum is the accumulative sum from the beginng
        int highrest = sum;   //Highrest is the accumulative rest from certain point to the end   
        
        for (int i = 0; i < n; i++) {  
            if(lowsum  == highrest - S[i])
                return i;
            lowsum += S[i];
            highrest -= S[i];
        }
        
    return -1;
    } 
}
