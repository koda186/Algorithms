// BST.java
// Basic implementation of BST containing insert and print methods
// Also contains implementation of basic BST node

class Node
{
    private int key;
    private Node deleteKey;
    private Node left, right;
    int size;

    public Node(int item) {
        key = item;
        deleteKey = null;
        left = right = null;
    }

    public void set_deleteKey( Node delete_key)
    {
    		deleteKey = delete_key;
    }

    public Node get_deleteKey()
    {
      return deleteKey;
    }

    public Node get_left()
    {
    		return left;
    }

    public Node get_right()
    {
      return right;
    }

    public int get_key()
    {
      return key;
    }

    public void set_left(Node new_left)
    {
      left = new_left;
    }

    public void set_right(Node new_right)
    {
      right = new_right;
    }

    public void set_key(int new_key)
    {
      key = new_key;
    }

    //return min val
    public int min()
    {
        if (left == null)
        {
        		return key;
        }
        else
        {
              return left.min();
        }
    }

	public boolean remove(int delete_key, Node parent)
	{
        if (delete_key < key)
        {
        		if (left != null)
            {
            	  //TODO //FIX Was super tired and my mind can't think! finals week.
            	  return left.remove(delete_key, left.get_left());
             }
             else
            	 	return false;
        }
        else if (delete_key > key)
        {
            if (right != null)
            {
            	//TODO //FIX Was super tired and my mind can't think! finals week.
            		return right.remove(delete_key, right.get_right());
            }
            else
            	  	return false;
        }
        else
        {
        		if ((left != null) && (right != null))
            {
        			//choose min ele from the right subtree
            	  	set_key(right.min());
            	  	//apply remove
            	  	right.remove(get_key(), get_left());
            }
            else if (parent.get_left() == parent)
            {
            	  //TODO //FIX will work it on school break Was super tired and my mind can't think! finals week.
            	  	parent.set_left((left != null) ? left : right);
            }
            else if (parent.get_right() == parent)
            {
            	  //TODO //FIX will work it on school break Was super tired and my mind can't think! finals week.
            	  	parent.set_right((left != null) ? left.get_left() : right.get_left());
            }
              return true;
        }

	}
}

class BinarySearchTree
{

    /* Class containing left and right child of current node and key value*/

    // Root of BST
    private Node root;
    //private Node deleteKey;
   // private Node x;
    private int size;


    // Constructor
    BinarySearchTree() {
        root = null;
        //deleteKey = null;
        //x = null;
        size = 0;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root, key);
       size++;
    }

    public int tree_size()
    {
    		return size;
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.get_key())
            root.set_left(insertRec(root.get_left(), key));
        else if (key > root.get_key())
            root.set_right(insertRec(root.get_right(), key));

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.get_left());
            System.out.println(root.get_key());
            inorderRec(root.get_right());
        }
    }
    //delete/remove item given
    public boolean remove(int delete_key)
    {
    		//chk if root exist
        if (root == null)
              return false;
        else
        {
        		//if root is equal to deleteKey
            if (root.get_key() == delete_key)
            {
            	    Node tmpRoot = new Node(delete_key);
                boolean isRemoved = root.remove(delete_key, tmpRoot);
                root = tmpRoot.get_left();
                size--;
                return isRemoved;
            }
            else
            {
            		return root.remove(delete_key, null);
            }
        }
    	}

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Tree size: " + tree.tree_size());

        // print inorder traversal of the BST
        tree.inorder();
        System.out.println("Deleted: " + tree.remove(30));
        tree.inorder();

    }
}
