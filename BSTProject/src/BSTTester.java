/*
 * Christopher Lee
 * 3/3/26
 * Pd:3
 * Create a BST class that implements the BSTInterface and uses the TreeNode class to create a Binary Search Tree.  
 * The class will include the functionality to be constructed, have elements added to it, found within it, replaced, deleted from it, and the tree itself will be traversable.  
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
    BST med = new BST();
    System.out.println(med.isEmpty());
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
    
    /**/
    med.delete("k");
    med.delete("z");
    med.delete("g");
    med.delete("r");
    System.out.println("In Order Traversal");
    med.printInOrder();

    System.out.println(med.size());
    System.out.println(med.isEmpty());
    System.out.println(med.find("m"));
	
 }//end main
}//end class