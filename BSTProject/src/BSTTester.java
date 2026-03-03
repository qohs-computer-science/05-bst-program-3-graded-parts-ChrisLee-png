/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
    BST med = new BST();
    med.add("g");
    med.add("r");
    med.add("k");
    med.add("c");
    med.add("g");
    med.add("m");
    med.add("y");
    med.add("z");
    med.add("x");

    
    System.out.println("Pre Order Traversal");
    med.printPreOrder();
    System.out.println("Post Order Traversal");
    med.printPostOrder();
    System.out.println("In Order Traversal");
    med.printInOrder();
    
    med.delete("g");
    med.delete("k");
    med.delete("z");

    //med.delete("r");
    System.out.println("In Order Traversal");
    med.printInOrder();

    /**/

    
   
	
 }
}