//AVL Trees
// Contains the ability to insert, maintain balance, and preorder + inorder
// traversal. Fix that caused improper balance implemented

import java.util.Random;

class Node {
    private int key, height;
    private Node left, right, parent;

    Node(int d) {
        key = d;
        height = 1;
    }
    
	public void set_key(int new_key)
	{
		key = new_key;
	}

	public void set_height(int new_height)
	{
		height = new_height;
	}

	public void set_left(Node new_left)
	{
		left = new_left;
	}

	public void set_right(Node new_right)
	{
		right = new_right;
	}
	
	public void set_parent(Node new_parent)
	{
		parent = new_parent;
	}

	public int get_key()
	{
		return key;
	}

	public int get_height()
	{
		return height;
	}

	public Node get_left()
	{
		return left;
	}

	public Node get_right()
	{
		return right;
	}
	
	public Node get_parent()
	{
		return parent;
	}
}

class AVLTree {

  private Node root;
  private static int countInsert = 0;
  private static int countSearch = 0;

	public AVLTree()
	{
		root = null;
	}

	public void set_root(Node N)
	{
		root = N;
	}

	public Node get_root()
	{
		return root;
	}
	
  // get the height of the tree
  public int height(Node N)
  {
    if (N == null)
      return 0;

    return N.get_height();
  }
  
  public static int countInserts()
  {
	  int countInserts = countInsert;
	  return countInserts;
  }
  
  public static int countSearches()
  {
	  int countSearches = countSearch;
	  return countSearches;
  }

  // A utility function to get maximum of two integers
  public int max(int a, int b)
  {
  	if(a > b)
  	{
  		return a;
  	}
  	else
  	{
  		return b;
  	}
  }

  // A utility function to right rotate subtree rooted with x
  public Node rightRotate(Node x)
  {
    Node y = x.get_left();
    Node T2 = y.get_right();

    // Perform rotation
    y.set_right(x);
    x.set_left(T2);

    // Update heights
    x.set_height(max(height(x.get_left()), height(x.get_right())) + 1);
    y.set_height(max(height(y.get_left()), height(y.get_right())) + 1);

    // Return new root
    return y;
  }

  // A utility function to left rotate subtree rooted with x
  public Node leftRotate(Node x)
  {
    Node y = x.get_right();
    Node T2 = y.get_left();

    // Perform rotation
    y.set_left(x);
    x.set_right(T2);

    //  Update heights
    x.set_height(max(height(x.get_left()), height(x.get_right())) + 1);
    y.set_height(max(height(y.get_left()), height(y.get_right())) + 1);

    // Return new root
    return y;
  }

  // Get Balance factor of node N
  public int getBalance(Node N)
  {
    if (N == null)
        return 0;

    return height(N.get_left()) - height(N.get_right());
  }

  public Node insert(Node node, int key)
  {
    // 1.  Perform the normal BST insertion
    if (node == null)
    {
    	  countInsert++;
      return (new Node(key)); 
    }
   

    if (key < node.get_key())
    {
      node.set_left(insert(node.get_left(), key));
      countInsert++;
    }
    else if (key > node.get_key())
    {
      node.set_right(insert(node.get_right(), key));
      countInsert++;
    }
    else 
    {
    	  countInsert++;
      return node;
    }

    // 2. Update height of this ancestor node
    node.set_height(1 + max(height(node.get_left()), height(node.get_right())));
    countInsert++;

    /* 3. Get the balance factor of this ancestor
          node to check whether this node became
          unbalanced */
    int balance = getBalance(node);

    // If this node becomes unbalanced, then there
    // are 4 cases: LL,RR,RL,LR
    //Left Left Case
    if (balance > 1 && key < node.get_left().get_key())
    {
    	  countInsert++;
      System.out.println("Solo Right rotate on "+ node.get_key() + " and with key: " + key);
      return rightRotate(node);
    }
    // Right Right Case
    if (balance < -1 && key > node.get_right().get_key())
    {
    		countInsert++;
        System.out.println("Solo Left rotate on "+ node.get_key() + " and with key: " + key);
        return leftRotate(node);
    }
    // Left Right Case
    if (balance > 1 && key > node.get_left().get_key())
    {
    	  countInsert++;
      System.out.println("Left Right on "+ node.get_left().get_key() + "and " + node.get_key() + " and with key: " + key);
      preOrder(node);
      System.out.println();
      node.set_left(leftRotate(node.get_left()));
      return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < node.get_right().get_key())
    {
      countInsert++;
      System.out.println("Right left on "+ node.get_right().get_key() + " and " + node.get_key() + " and with key: " + key);
      preOrder(node);
      System.out.println();
      node.set_right(rightRotate(node.get_right()));
      return leftRotate(node);
    }
    countInsert++;
    return node;
  }
  
  //search helper
  public int search(int key)  
  {
	  countSearch++;
	  return searchNode(root, key);
  }
  
  //search
  private int searchNode(Node node, int key) 
  {	  
	  countSearch++;
	  if ((node == null)) 
	  {
		  countSearch++;
		  return -1;  //false-missing
	  } 
	  else if (key < node.get_key()) 
	  {
		  countSearch++;
		  return searchNode(node.get_left(), key);

	  } 
	  else if (key > node.get_key()) 
	  {
		  countSearch++;
		  return searchNode(node.get_right(), key);
	  } 
	  else 
	  {
		  countSearch++;
		  return node.get_key();
	  }
  }
  
  //delete node
  public Node deleteNode(Node root, int key)
  {
	  if (root == null)
		  return root;
	  
	  if (key < root.get_key())
	  {
		  root.set_left(deleteNode(root.get_left(),key));
	  }
	  else if (key > root.get_key())
	  {
		  root.set_right(deleteNode(root.get_right(),key));
	  }
	  else 
	  {
		  if ((root.get_left() == null) || (root.get_right() == null))
		  {
			  Node temp = null;
			  if(temp == root.get_left())
				  temp = root.get_right();
			  else 
				  temp = root.get_left();
			  
			  /*no children*/
			  if (temp == null)
			  {
				  temp = root;
				  root = null;
			  }
			  else
			  {
				  //one child
				  root = temp;
			  }
		  }
		  else 
		  {
			  Node temp = minValueNode(root.get_right());
              root.set_key(temp.get_key());  
              root.set_right(deleteNode(root.get_right(), temp.get_key()));   
          }  
      }  

      // If only one node, return root  
      if (root == null)  
          return root;  

      // 2. Update height of this ancestor node 
      root.set_height(max(height(root.get_left()), height(root.get_right())) + 1);  

      /* 3. Get the balance factor of this ancestor
      node to check whether this node became
      unbalanced */ 
      int balance = getBalance(root);  

      // If this node becomes unbalanced, then there
      // are 4 cases; LL,RR,RL,LR 
      //Left Left Case
      if (balance > 1 && getBalance(root.get_left()) >= 0)  
          return rightRotate(root);  

      // Left Right Case  
      if (balance > 1 && getBalance(root.get_left()) < 0)  
      {  
          root.set_left(leftRotate(root.get_left()));  
          return rightRotate(root);  
      }  

      // Right Right Case  
      if (balance < -1 && getBalance(root.get_right()) <= 0)  
          return leftRotate(root);  

      // Right Left Case  
      if (balance < -1 && getBalance(root.get_right()) > 0)  
      {  
          root.set_right(rightRotate(root.get_right()));  
          return leftRotate(root);  
      }  
      return root;  
  }  
 
  /* return the node with minimum value found in tree. */
  private Node minValueNode(Node node)  
  {  
      Node current = node;  

      /* loop down to leftmost leaf */
      while (current.get_left() != null)  
      current = current.get_left();  

      return current;  
  }  

  // A utility function to print preorder traversal
  // of the tree.
  // The function also prints height of every node
  private void preOrder(Node node)
  {
    if (node != null) {
      System.out.print(node.get_key() + " ");
      preOrder(node.get_left());
      preOrder(node.get_right());
    }
  }

  private void inorderRec(Node root)
  {
      if (root != null) {
          inorderRec(root.get_left());
          System.out.println(root.get_key());
          inorderRec(root.get_right());
      }
  }
		

  public static void main(String[] args)
  {
    AVLTree tree = new AVLTree();
    int i = 0;
    int tmp;
    Random rand = new Random();

    for(i = 0; i < 1000; i++)
    {
      tmp = rand.nextInt(100000);
      System.out.println("Inserting "+ tmp + " into the tree.");
      tree.set_root(tree.insert(tree.get_root(), tmp));
    }
    
    //AVLTree
    System.out.println("\nInorder traversal" +
                    " of constructed tree is : ");
    tree.inorderRec(tree.get_root());
    System.out.println("\n\nNow for the preorder traversal");
    tree.preOrder(tree.get_root());
    System.out.println("");
    System.out.println("Search for Node; -1 if not found in tree: ");
    System.out.println("Search for Node 645: " + tree.search(645));
    System.out.println("Search for Node: " + tree.deleteNode(tree.get_root(), 645));
    System.out.println("Search for Node 645: " + tree.search(645));
    System.out.println("Search for Node 439: " + tree.search(439));
    System.out.println("Num Operations for AVL insert is: " + countInserts());
    System.out.println("Num Operations for AVL search is: " + countSearches());
  }
}
