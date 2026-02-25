import java.lang.Comparable;

public class BST implements BSTInterface
{
    TreeNode root = null;
    int size = 0;
    public BST ()
    {
        root = new TreeNode(null);
    }
    public void add(Comparable newVal)
    {
        if(root!=null)
            addHelper(newVal, root);
        else   
            root=new TreeNode(newVal, null, null);
        size++;
    }
    public void addHelper(Comparable newVal, TreeNode e)
    {
        if(newVal<=e.getValue)
            if(e.getLeft()==null)
                e.setLeft(newVal);
            else
                addHelper(e.getValue(), e.leftChild());
        else  
            if(e.getRight()==null)
                e.setRight(newVal);  
            else
                addHelper(e.getValue(), e.RightChild());
    }
    public void printInOrder()
    {
        if(root!=null)
        {
            printInOrderHelper(root.getLeft());
            System.out.print(root.getValue());
            printInOrderHelper(root.getRight());
        }
    }
    public void printInOrderHelper(TreeNode subRoot)
    {
        if(root!=null)
        {
            printInOrder(subRoot.getLeft());
            System.out.print(subRoot.getValue());
            printInOrder(subRoot.getRight());
        }
    }
    
    

}