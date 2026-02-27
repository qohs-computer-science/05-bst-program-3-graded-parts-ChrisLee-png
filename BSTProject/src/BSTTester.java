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
    med.add("a");
    med.add("b");
    med.add("c");
    med.add("d");
    med.add("e");
    med.add("f");
    med.add("g");
    med.add("h");

    System.out.println("In Order Traversal");
    med.printInOrder();
    System.out.println("Pre Order Traversal");
    med.printPreOrder();
    System.out.println("Post Order Traversal");
    med.printPostOrder();
   
	
 }
}