import java.lang.Comparable;

public class BST implements BSTInterface
{
    TreeNode root = null;
    int size = 0;
    public BST ()
    {
        root = null;
    }
    public void add(Comparable newVal)
    {
        if(root!=null)
            addHelper(newVal, root);
        else   
            root=new TreeNode(newVal);
        size++;
    }
    public void addHelper(Comparable newVal, TreeNode e)
    {
        if(newVal.compareTo(e.getValue())<=0)
            if(e.getLeft()==null)
                e.setLeft(new TreeNode(newVal));
            else
                addHelper(newVal, e.getLeft());
        else  
            if(e.getRight()==null)
                e.setRight(new TreeNode(newVal));  
            else
                addHelper(newVal, e.getRight());
    }
    public void printInOrder()
    {
        if(root!=null)
        {
            printInOrderHelper(root.getLeft());
            System.out.println(root.getValue());
            printInOrderHelper(root.getRight());
        }
    }
    public void printInOrderHelper(TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            printInOrderHelper(subRoot.getLeft());
            System.out.println(subRoot.getValue());
            printInOrderHelper(subRoot.getRight());
        }
    }
    public void printPreOrder()
    {
        if(root!=null)
        {
            System.out.println(root.getValue());
            printPreOrderHelper(root.getLeft());
            printPreOrderHelper(root.getRight());
        }
    }
    public void printPreOrderHelper(TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            System.out.println(subRoot.getValue());
            printPreOrderHelper(subRoot.getLeft());
            printPreOrderHelper(subRoot.getRight());
        }
    }

    public void printPostOrder()
    {
        if(root!=null)
        {
            printPostOrderHelper(root.getLeft());
            printPostOrderHelper(root.getRight());
            System.out.println(root.getValue());
        }
    }
    public void printPostOrderHelper(TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            printPostOrderHelper(subRoot.getLeft());
            printPostOrderHelper(subRoot.getRight());
            System.out.println(subRoot.getValue());
        }
    }
    public boolean delete(Comparable old)
    {
        if(root!=null)
        {
            if(root.getValue().equals(old)){
                if(root.getLeft()==null && root.getLeft()==null){
                    root = null;
                    return true;
                }
                else if(root.getLeft()==null){
                    root = root.getRight();
                    return true;
                }
                else if(root.getRight()==null){
                    root = root.getLeft();
                    return true;
                }
                else
                {
                    TreeNode t = root.getLeft();
                    while(t.getRight()!=null)
                        t=t.getRight();
                    t.setRight(root.getRight());
                    root = root.getLeft();
                    return true;
                }
            }
            else
                deleteHelper(old, root);
        }
        return false;
                           
    }
    public void deleteHelper(Comparable old, TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            
        }
    }
    
    

}