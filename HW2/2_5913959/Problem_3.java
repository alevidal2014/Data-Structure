/*********************************************************************
 Purpose/Description: <This class implements the problem #3 Infix to Postfix Notation >
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package ds_assignment2;

import java.util.Stack;

public class Problem_3 {
    private Stack myStack;
    private String output;
    
    public Problem_3(){
        this.myStack = new Stack();
        this.output = "";
    }
    
    //Main method to process a single char and put into the stack or in the output
    public void proccessChar(char c){
        char p;
        if(!isOperation(c))
            this.output += c;
        else{
           if(this.myStack.isEmpty() || c=='('){
               this.myStack.push(c);
               return;
           }
           if(c==')'){
              p = (char)this.myStack.peek();
              while(p != '(')
              {
                 output += p; 
                 this.myStack.pop();
                  p = (char)this.myStack.peek();
              } 
              this.myStack.pop();  //Pop '(' symbol
              return;
            } 
           
            p = (Character)this.myStack.peek();
            while(this.precedence(c)<=this.precedence(p) && !this.myStack.isEmpty() && p!='(')
            {
                output += p;
                this.myStack.pop();
                if(this.myStack.isEmpty())
                    break;
                p = (char)this.myStack.peek();
            }
            this.myStack.push(c);                       
        }    
    }
    
    //Empty the rest of the stack to the output
    public void completeOutput(){
        while(!this.myStack.isEmpty())
            this.output += this.myStack.pop();        
    }
    
    public String getOutput(){
        return this.output;
    }
            
    //Helper method to know if a character is one of the valid operations or parenthesis
    private boolean isOperation(char c){
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='(' || c==')';
    }
    
    //Helper method to return presedence ....Assume +- (Precedence 0), */(precedence 1)
    private int precedence(char c){
        if(c =='+' || c =='-')
            return 0;
        return 1;        
    }
}
