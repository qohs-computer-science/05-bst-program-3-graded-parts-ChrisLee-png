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
    System.out.println("BST is empty: "+ med.isEmpty());
    System.out.println("Values are now added ");
    med.add("O");
    med.add("R");
    med.add("C");
    med.add("H");
    med.add("A");
    med.add("R");
    med.add("D");
    med.add("Q");
    med.add("U");
    med.add("I");
    med.add("N");
    med.add("C");
    med.add("E");

    System.out.println("Pre Order Traversal");
    med.printPreOrder();
    System.out.println("Post Order Traversal");
    med.printPostOrder();
    System.out.println("In Order Traversal");
    med.printInOrder();
    
    /**/
    System.out.println("D was removed: "+ med.delete("D"));
    System.out.println("O was removed: "+ med.delete("O"));
    System.out.println("C was removed: "+ med.delete("C"));
    System.out.println("E was removed: "+ med.delete("E"));


    System.out.println("In Order Traversal after removals");
    med.printInOrder();

    System.out.println("BST stores "+med.size()+" values");
    System.out.println("BST is empty: "+ med.isEmpty());
    System.out.println("m was found: "+med.find("m"));
    System.out.println("R was replaced: "+med.replace("R","m"));

    System.out.println("In Order Traversal after replacement");
    med.printInOrder();
 }//end main
}//end class