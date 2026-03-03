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
                if(root.getLeft()==null && root.getRight()==null){
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
            else if(root.getValue().compareTo(old)<0)
            {
                return deleteHelper(old, root, root.getRight());
            }
                
            else
                return deleteHelper(old, root, root.getLeft());
        }
        return false;                    
    }
    public boolean deleteHelper(Comparable old, TreeNode root, TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            if(old.equals(subRoot.getValue()))
            {
                if(subRoot.getLeft()==null && subRoot.getRight()==null){
                    if(subRoot.equals(root.getLeft()))
                        root.setLeft(null);
                    else 
                        root.setRight(null);
                    subRoot = null;
                    return true;
                }
                else if(subRoot.getLeft()==null){
                    if(subRoot.equals(root.getLeft()))
                        root.setLeft(subRoot.getRight());
                    else 
                        root.setRight(subRoot.getRight());
                    subRoot = null;
                    return true;
                }
                else if(subRoot.getRight()==null){
                    System.out.println("E");
                    if(subRoot.equals(root.getLeft()))
                        root.setLeft(subRoot.getLeft());
                    else 
                        root.setRight(subRoot.getLeft());
                    subRoot = null;
                    return true;
                }
                else
                {
                    TreeNode t = subRoot.getLeft();
                    while(t.getRight()!=null)
                        t=t.getRight();
                    t.setRight(subRoot.getRight());
                    subRoot = subRoot.getLeft();
                    return true;
                }
            }
            else if(subRoot.getValue().compareTo(old)<0)
            {
                return deleteHelper(old, subRoot, subRoot.getRight());
            }   
            else 
                return deleteHelper(old, subRoot, subRoot.getLeft());
        }
        else
            return false;

    }
}