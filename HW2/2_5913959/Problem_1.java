/*********************************************************************
 Purpose/Description: <This class implements the problem #1 MySingleLinkedList >
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package ds_assignment2;


public class Problem_1 {
    
     private class Node<Object>{         
      Object data;
      Node next;
      
      public Node(){
         this(null,null);
      }
      public Node(Object d){
         this(d,null);
      }
      
      public Node(Object d, Node n){
         this.data = d;
         this.next = n;
      }      
   }
     
      private Node header;  //Reference to the 1st element
   
   //Constructor
   public Problem_1(){
      this.header = null;
   }
   
   
   public boolean isEmpty(){
      return this.header == null;
   }
   
   //Return the size of the linked list
   public int size(){
      int counter = 0;      
      Node pointer = this.header;
      while (pointer != null)
      {
         counter ++;
         pointer = pointer.next;
      }      
      return counter;
   }
   
   //Print the linked list
   public void print(){
      Node pointer = this.header;
      while (pointer != null)
      {
         System.out.print(pointer.data + "\t");
         pointer = pointer.next;
      }      
   }
   
//Test if a value x is contained in the linked list 
   public boolean contains(Object x){
      Node pointer = this.header;
      while (pointer != null)
      {
         if (pointer.data.equals(x))
            return true;         
         pointer = pointer.next;
      }            
      return false;
   }
   
   //Assume Addlast since it is not specified in the instructions
   //Add a value x at the tail of the list if it is not already contained in the linked list
   public boolean addLast(Object x){
      Node myNode = new Node(x);
      
      if(this.contains(x))
          return false;
      
      if (this.isEmpty()){ 
         this.header = myNode;
         return true;
      }
      else
      {      
         Node pointer = this.header;
         while (pointer.next != null)
            pointer = pointer.next;
         
         pointer.next = myNode;
         return true;
      }    
   }
   
   //remove a value x if it is contained in the linked list
    public boolean remove(Object x)
   {
      Node pointer = this.header;
      Node trailer = null;
      
     while(pointer != null && !pointer.data.equals(x)) 
      {
         trailer = pointer;
         pointer = pointer.next;
      }     
      
     if (pointer == null)
         return false;
       
      if (trailer == null) 
         this.header = pointer.next;  //first element case
      else
         trailer.next = pointer.next;  //other cases
         
      return true;
   }
   
}
