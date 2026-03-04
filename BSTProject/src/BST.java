import java.lang.Comparable;

public class BST implements BSTInterface
{
    TreeNode root = null;
    int size = 0;
    public BST ()
    {
        root = null;
    }//BST constructor
    public void add(Comparable newVal)
    {
        if(root!=null)
            addHelper(newVal, root);
        else   
            root=new TreeNode(newVal);
        size++;
    }//add method
    private void addHelper(Comparable newVal, TreeNode e)
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
    }//addHelper method
    public void printInOrder()
    {
        if(root!=null)
        {
            printInOrderHelper(root.getLeft());
            System.out.println(root.getValue());
            printInOrderHelper(root.getRight());
        }//checks if tree is empty
    }//printInOrder method
    private void printInOrderHelper(TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            printInOrderHelper(subRoot.getLeft());
            System.out.println(subRoot.getValue());
            printInOrderHelper(subRoot.getRight());
        }//checks if tree still has things
    }//print printInOrderHelper method
    public void printPreOrder()
    {
        if(root!=null)
        {
            System.out.println(root.getValue());
            printPreOrderHelper(root.getLeft());
            printPreOrderHelper(root.getRight());
        }//checks if tree is empty
    }//print printPreOrder method
    private void printPreOrderHelper(TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            System.out.println(subRoot.getValue());
            printPreOrderHelper(subRoot.getLeft());
            printPreOrderHelper(subRoot.getRight());
        }//checks if tree still has things
    }//print printPreOrderHelper method

    public void printPostOrder()
    {
        if(root!=null)
        {
            printPostOrderHelper(root.getLeft());
            printPostOrderHelper(root.getRight());
            System.out.println(root.getValue());
        }//checks if tree is empty
    }//print printPostOrder method
    private void printPostOrderHelper(TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            printPostOrderHelper(subRoot.getLeft());
            printPostOrderHelper(subRoot.getRight());
            System.out.println(subRoot.getValue());
        }//checks if tree still has things
    }//print printPostOrder method
    public boolean delete(Comparable old)
    {
        size--;
        if(root!=null)
        {
            if(root.getValue().equals(old)){
                if(root.getLeft()==null && root.getRight()==null){
                    root = null;
                    return true;
                }//case for when there is no child
                else if(root.getLeft()==null){
                    root = root.getRight();
                    return true;
                }//case for when there is only right child
                else if(root.getRight()==null){
                    root = root.getLeft();
                    return true;
                }//case for when there is only left child
                else
                {
                    TreeNode t = root.getLeft();
                    while(t.getRight()!=null)
                        t=t.getRight();
                    t.setRight(root.getRight());
                    root = root.getLeft();
                    return true;
                }//case for when there are two children
            }//checks for if root is value
            else if(root.getValue().compareTo(old)<0)
                return deleteHelper(old, root, root.getRight());
                
            else
                return deleteHelper(old, root, root.getLeft());
        }//checks if tree is empty
        size++;
        return false;                    
    }//delete method
    private boolean deleteHelper(Comparable old, TreeNode parent, TreeNode subRoot)
    {
        if(subRoot!=null)
        {
            if(old.equals(subRoot.getValue()))
            {
                if(subRoot.getLeft()==null && subRoot.getRight()==null){
                    if(subRoot.equals(parent.getLeft()))
                        parent.setLeft(null);
                    else 
                        parent.setRight(null);
                    subRoot = null;
                    return true;
                }//case for when there is no children
                else if(subRoot.getLeft()==null){
                    if(subRoot.equals(parent.getLeft()))
                        parent.setLeft(subRoot.getRight());
                    else 
                        parent.setRight(subRoot.getRight());
                    subRoot = null;
                    return true;
                }//case for when there is only right child
                else if(subRoot.getRight()==null)
                {
                    System.out.println("E");
                    if(subRoot.equals(parent.getLeft()))
                        parent.setLeft(subRoot.getLeft());
                    else 
                        parent.setRight(subRoot.getLeft());
                    subRoot = null;
                    return true;
                }//case for when there is only left child
                else
                {
                    if(subRoot.equals(parent.getLeft()))
                        parent.setLeft(subRoot.getLeft());
                    else 
                        parent.setRight(subRoot.getLeft());
                    TreeNode t = subRoot.getLeft();
                    while(t.getRight()!=null)
                        t=t.getRight();
                    t.setRight(subRoot.getRight());
                    return true;
                }//case for when there is two children
            }//checks if subroot matches value
            else if(subRoot.getValue().compareTo(old)<0)
                return deleteHelper(old, subRoot, subRoot.getRight());  
            else 
                return deleteHelper(old, subRoot, subRoot.getLeft());
        }//checks if tree still has things
        size++;
        return false;

    }//deleteHelper method

    public boolean find(Comparable toFind)
    {
        if(root!=null)
            if(root.getValue().equals(toFind))
                return true;
            else if(root.getValue().compareTo(toFind)<0)
                return findHelper(toFind, root.getRight());
            else
                return findHelper(toFind, root.getLeft());
        else
            return false;
    }//add method
    
    private boolean findHelper(Comparable toFind, TreeNode e)
    {
        if(e!=null)
            if(e.getValue().equals(toFind))
                return true;
            else if(e.getValue().compareTo(toFind)<0)
                return findHelper(toFind, e.getRight());
            else    
                return findHelper(toFind, e.getLeft());
        else
            return false;
    }

    public int size()
    {
        return size;
    }//print printPostOrder method

    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean replace(Comparable old, Comparable toAdd)
    {
        if(root!=null)
            if(root.getValue().equals(old))
            {
                
                return true;
            }
            else if(root.getValue().compareTo(old)<0)
                return replaceHelper(old, toAdd, root.getRight());
            else
                return replaceHelper(old, toAdd, root.getLeft());
        else
            return false;
    }
    private boolean replaceHelper(Comparable old, Comparable toAdd, TreeNode e)
    {
        if(e!=null)
            if(e.getValue().equals(old))
                
                return true;
            else if(e.getValue().compareTo(old)<0)
                return findHelper(old, e.getRight());
            else    
                return findHelper(old, e.getLeft());
        else
            return false;
    }

}//BST class