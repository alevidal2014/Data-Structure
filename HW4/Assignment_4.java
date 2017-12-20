/*********************************************************************
 Purpose/Description: <Radix Sort Using Only Even Digits (Radix=5) Total Time Complexity => O(n)>
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package assignment_4;
import java.util.ArrayList;

public class Assignment_4 {

    public static int input[] = {8, 4, 82, 46, 80, 2, 68, 42};              //Original input Array
    public static ArrayList<Integer> output = new ArrayList<Integer>();     //Output Sorted Array
    public static final int DIGITS = 3;                                     //Max number of digits in the numbers of the digits of the input array
    public static final int RADIX = 5;                                      //Radix of the Sort Method (0,2,4,6,8)
    public static boolean success = true;                                   //Use to know if the sort succeed 
    
    
    public static void main(String[] args) {
        
        System.out.println("Input Array: ");                                //Printing the original Array
        for(int i=0; i< input.length; i++)              //O(n)
        System.out.print(input[i] + "    ");
                       
        radixSort(input, DIGITS);                                           //Sorting the Array
        
        System.out.println("\n\nOutput Array: ");                           //Printing the output if the method succeed
        if(success)
        for(int i=0; i< output.size(); i++)             //O(n)
        System.out.print(output.get(i) + "    ");
        
    }
    
    public static void radixSort(int arr[], int d) {                        //Main Sort Method
           int helper = 1;                                                  //Helper variable to get the digits of a number
           int mydigit;                                                     //Digit of the number  
           int radix;                                                       //Actual index in the buckets                                                   
           ArrayList<Integer>[] buckets = new ArrayList[RADIX];             //Building the buckets to sort
           for (int a = 0; a < buckets.length; a++)             //O(c)
              buckets[a] = new ArrayList();
           
           for (int i = 0; i < arr.length; i++)                 //O(N)      //Copying the input to the output to start sorting
            output.add(arr[i]);
           
 
           
           for(int i=0; i< d; i++){                            //O(c)       //Going through each digit
               for(int j=0; j<arr.length; j++){                //O(n)       //Going through each number
               mydigit = output.get(j)/helper % 10;                         //Getting the digit
               if(mydigit%2 != 0){                                          //Evaluating if the digit is even
                   System.out.println("\nOdd digit found ("+ mydigit + "), Invalid operation on element: " + output.get(j));
                   success = false;
                   return;
               }                   
               radix =mydigit/2;                                            //Getting the actual buckets index
               buckets[radix].add(output.get(j));                           //Building the buckets
               }
               
               output.clear();                                              //Clearing the output for the next iteration
               for(int h=0; h<RADIX; h++)                      //O(c)       //Copying bucket to the output
                   for(int k=0; k< buckets[h].size(); k++)     //O(n) 
                       output.add(buckets[h].get(k));
               
               for (int q = 0; q < RADIX; q++)                 //O(c)       //Clearing the bucket
                   buckets[q].clear();
               
               helper*=10;                                                  //Adjusting the variable to get the next digit
           }
    }
    
   
        
}
