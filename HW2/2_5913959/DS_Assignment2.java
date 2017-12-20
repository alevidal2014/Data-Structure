/*********************************************************************
 Purpose/Description: < This programs fuction as a tester for the 4 problems of the assignment #2>
 Author’s Panther ID: <5913959>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/ 
package ds_assignment2;

import java.util.Scanner;
public class DS_Assignment2 {

    
    public static void main(String[] args) {
      
      //Testing Problem #1 Linked List
     /* System.out.println("*************Linked List*****************");
      Problem_1 myList = new Problem_1();
      myList.addLast(25);
      myList.addLast(50);
      myList.addLast(75);
      myList.addLast(100);
      myList.print();
      System.out.println("\nThe size of the lsit is: " + myList.size());
      System.out.println("It is 25 in the list: " + myList.contains(25));
      System.out.println("It is 15 in the list: " + myList.contains(15));
      myList.remove(50);
      myList.print();
      
      //Testing Problem #2 Sorted Linked List
      System.out.println("\n\n********** Sorted Linked List*****************");
      Problem_2 myList2 = new Problem_2();
      myList2.add(20);
      myList2.add(30);
      myList2.add(50);
      myList2.add(25);
      myList2.add(5);
      myList2.add(100);
      myList2.add(75);
      myList2.print();
      System.out.println("\nThe size of the lsit is: " + myList2.size());
      System.out.println("It is 25 in the list: " + myList2.contains(25));
      System.out.println("It is 15 in the list: " + myList2.contains(15));
      myList2.remove(50);
      myList2.remove(5);
      myList2.remove(100);
      myList2.print();
      
      
      //Testing Problem #3 Infix to postfix
      System.out.println("\n\n********** Infix to Postfix Notation*****************");
      Scanner scan = new Scanner(System.in);
      System.out.println("Insert an expression in Infix notation: (= to end expresion )");
      String input = scan.next();  
            
      Problem_3 postfix = new Problem_3();
      
        for (int i = 0; i < input.length() && input.charAt(i)!= '='; i++) {
            postfix.proccessChar(input.charAt(i));
        }
      
        postfix.completeOutput();
        System.out.println("Your output in Postfix Notation is: " + postfix.getOutput());
*/
      //Testing Problem #4 Sorting and Stack
      System.out.println("\n\n*************Sorting an Stack*****************\n Stack unsorted");
      Problem_4 sortedStack = new Problem_4();
      sortedStack.pushOn(10);
      sortedStack.pushOn(4);
      sortedStack.pushOn(15);
      sortedStack.pushOn(1);
      sortedStack.pushOn(2);
      sortedStack.pushOn(7);
      sortedStack.pushOn(12);
      sortedStack.printStack();
      sortedStack.sort();
      System.out.println("\nAfter Sorted ...");
      sortedStack.printStack();
      
    }
    
}
