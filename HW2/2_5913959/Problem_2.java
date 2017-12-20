/*********************************************************************
 Purpose/Description: <This class implements the problem #2 MySortedSingleList >
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package ds_assignment2;


public class Problem_2 {
     private class Node<Comparable>{         
      Comparable data;
      Node next;
      
      public Node(){
         this(null,null);
      }
      public Node(Comparable d){
         this(d,null);
      }
      
      public Node(Comparable d, Node n){
         this.data = d;
         this.next = n;
      }      
   }
     
      private Node header;  //Reference to the 1st element
   
   //Constructor
   public Problem_2(){
      this.header = null;
   }
   
   
   public boolean isEmpty(){
      return this.header == null;
   }
   
   //Return the size of the Sorted linked list
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
   
//Test if a value x is contained in the Sorted linked list 
   public boolean contains(Comparable x){
      Node pointer = this.header;
      while (pointer != null && x.compareTo(pointer.data)>=0)
      {
         if (pointer.data.equals(x))
            return true;         
         pointer = pointer.next;
      }            
      return false;
   }
   
    //Add a value x ,maitaining the sorted order of the list, if it is not already contained in the linked list
   public boolean add(Comparable x){
      Node myNode = new Node(x);
      
      if(this.contains(x))
          return false;
      
      if (this.isEmpty()){ 
         this.header = myNode;
         return true;
      }  
      else{
         Node pointer = this.header;
         Node trailer = null;
         while (pointer != null && x.compareTo(pointer.data)>0)
         {
             trailer = pointer;
             pointer = pointer.next;
         }             
         
         if (trailer == null){ //first element case
            myNode.next = this.header;
            this.header = myNode;
            }
         else{
            myNode.next = pointer; 
            trailer.next = myNode;  //other cases
         }
          
      return true;
      }    
   }
   
   //remove a value x if it is contained in the linked list
    public boolean remove(Comparable x)
   {
      Node pointer = this.header;
      Node trailer = null;
      
    while(pointer != null && x.compareTo(pointer.data)>0) 
      {
         trailer = pointer;
         pointer = pointer.next;
      }     
      
    if (pointer == null) //not in the list
        return false;
    
    if(pointer.data.equals(x)){   
        if (trailer == null)  //first element case    
            this.header = pointer.next;              
        else
            trailer.next = pointer.next;  //other cases
            
        return true;       
    }
    
    return false;
   }
}
