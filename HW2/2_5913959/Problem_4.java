/*********************************************************************
 Purpose/Description: <This class implements the problem #4 The Sorted Stack Time Complexity O(n^2) >
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/

package ds_assignment2;

import java.util.Stack;
public class Problem_4 {
    private Stack myStack;
    private Stack temp;
    
    public Problem_4(){
        myStack = new Stack();
        temp = new Stack();
    }
    
    public void pushOn(int value){
        this.myStack.push(value);
    }
    
    //Method to print the stack using recursion 
    public void printStack(){
         if (this.myStack.isEmpty())
             return;
         
         int p = (int)this.myStack.peek();
         System.out.println("\t" + p);
         this.myStack.pop();
         this.printStack();
         this.pushOn(p);   
            
    }
    
    //Main method to sort the stack using a temporal stack. Complexity is O(n^2)
    public void sort(){
        int value;
        while(!this.myStack.isEmpty()){
            value = (int)this.myStack.pop(); //Getting the value to sort
            int popCounter = 0;
            while(!this.temp.isEmpty() && value > (int)this.temp.peek()){//find the right place to push the new value in temp              
                this.myStack.push(this.temp.pop()); 
                popCounter++;
            }                  
            this.temp.push(value);  //Push the value in temp stack    
            
            for (int i = 0; i < popCounter ; i++) 
                this.temp.push(this.myStack.pop()); //Return values already ordered into temp stack         
        }  
        
        while(!this.temp.isEmpty()){  //Returning full temporal stack into main stack to get the right order
            this.myStack.push(this.temp.pop());
        }
    }
}
