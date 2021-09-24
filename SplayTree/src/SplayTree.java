//AVL

import java.util.Random;

class Node {
    private int key, height;
    private Node left, right, parent;

    Node(int d) {
        key = d;
        height = 1;
    }

	// set key
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


public class SplayTree
  {
	  private Node root;
	  private static int countInsert = 0;
	  private static int countSearch = 0;

		public SplayTree()
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

		//count operations and rotations
		public static int countInserts()
		  {
			  int countInserts = countInsert;
			  return countInserts;
		  }

		//count operations and rotations
		public static int countSearches()
		{
			  int countSearches = countSearch;
			  return countSearches;
		}

		//LR.
		public void leftRotate(Node x)
		{
			System.out.println("Rotating left : " + x.get_key());
			Node parent = x.get_parent();
			Node left = x.get_left();
			x.set_left(parent);
			parent.set_right(left);
			if(left!=null){
				left.set_parent(parent);
			}
			Node gp = x.get_parent().get_parent();
			parent.set_parent(x);
			x.set_parent(gp);

			if(gp==null)
			{
				set_root(x);
			}
			else{
				if(gp.get_left() == (parent))
				{
					gp.set_left(x);
				}
				else{
					gp.set_right(x);
				}
			}
		}

		//RR.
		public void rightRotate(Node x)
		{
			System.out.println("Rotating right : " + x.get_key());
			Node parent = x.get_parent();
			Node right = x.get_right();
			x.set_right(parent);
			parent.set_left(right);
			if(right!=null){
				right.set_parent(parent);
			}
			Node gp = x.get_parent().get_parent();
			x.set_parent(gp);
			parent.set_parent(x);

			if(gp == null)
			{
				set_root(x);
			}
			else{
				if(gp.get_left() == parent)
				{
					gp.set_left(x);
				}
				else
				{
					gp.set_right(x);
				}
			}
		}

		public void insert(int key)
		{
			// 1.  Perform the normal BST insertion
			Node node = new Node(key);
			countInsert++;
			if(get_root() == null)
			{
				countInsert++;
				set_root(node);
				return;
			}

		    Node temp = root;
		    countInsert++;
			while(temp != null)
			{
				countInsert++;
				if(temp.get_key() > key)
				{
					countInsert++;
					if(temp.get_left() == null)
					{
						countInsert++;
						temp.set_left(node);
						node.set_parent(temp);
						splay(node);
						return;
					}
					temp = temp.get_left();
				}

				if(temp.get_key() < key)
				{
					countInsert++;
					if(temp.get_right() == null)
					{
						countInsert++;
						temp.set_right(node);
						node.set_parent(temp);
						splay(node);
						return;
					}
					temp = temp.get_right();
				}
			}
		}

		/*
		 //Splay Operation: Three cases:
			x has no grandparent (zig)
			If x is left child of root y, then rotate (xy)R.
			Else if x is right child of root y, then rotate (yx)L.

			x is LL or RR grandchild (zig-zig)
			If x is left child of y, and y is left child of z,
			then rotate at grandfather (yz)R and then rotate at father (xy)R.
			Else if x is right child of y, and y is right child of z,
			then rotate at grandfather (yz)L and then rotate at father (xy)L.
			If x has not become the root, then continue splaying at x.

			x is LR or RL grandchild (zig-zag)
			If x is right child of y, and y is left child of z,
			then rotate at father (yx)L and then rotate at grandfather (xz)R.
			Else if x is left child of y, and y is right child of z,
			then rotate at father (yx)R and then rotate at grandfather (xz)L.
			If x has not become the root, then continue splaying at x.
		 */
		public void splay(Node x)
		{
			System.out.println("Splay node : " + x.get_key());
			if(x.get_parent() == null)
			{
				countInsert++;
				set_root(x);
				return;
			}

			//zig-x has no grandparent
			if(x.get_parent().get_parent()==null)
			{
				countInsert++;
				if(x.get_parent().get_right() == x)
				{
					countInsert++;
					leftRotate(x);
					set_root(x);
				}
				else
				{
					countInsert++;
					rightRotate(x);
					set_root(x);
				}
				countInsert++;
				return;
			}

			//zig-zag-x is LR or RL grandchild
			if(x.get_parent().get_right() == x && x.get_parent().get_parent().get_left() == x.get_parent())
			{
				countInsert++;
				leftRotate(x);
				countInsert++;
				rightRotate(x);
				splay(x);
				return;
			}

			//zig-zag-x is LR or RL grandchild
			if(x.get_parent().get_left() == x && x.get_parent().get_parent().get_right() == x.get_parent())
			{
				countInsert++;
				rightRotate(x);
				countInsert++;
				leftRotate(x);
				splay(x);
				return;
			}

			//zig-zig-x is LL or RR grandchild
			if(x.get_parent().get_right() == x && x.get_parent().get_parent().get_right() == x.get_parent())
			{
				countInsert++;
				leftRotate(x.get_parent());
				countInsert++;
				leftRotate(x);
				splay(x);
				return;
			}

			//zig-zig-x is LL or RR grandchild
			if(x.get_parent().get_left() == x && x.get_parent().get_parent().get_left() == x.get_parent())
			{
				countInsert++;
				rightRotate(x.get_parent());
				countInsert++;
				rightRotate(x);
				splay(x);
				return;
			}
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
				return -1;  // false, missing
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

					//if no children
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

		      // If only one node then return root
		      if (root == null)
		    	  	return root;

		      return root;
		}


		/* return the node with minimum value found in tree.*/
		private Node minValueNode(Node node)
		{
			Node current = node;

		    /*find the leftmost leaf */
		    while (current.get_left() != null)
		    current = current.get_left();

		    return current;
		}


		private void preOrder(Node node)
		{
			if (node != null)
			{
		      System.out.print(node.get_key() + " ");
		      preOrder(node.get_left());
		      preOrder(node.get_right());
			}
		}

		private void inorderRec(Node root)
		{
	      if (root != null)
	      {
	    	  	inorderRec(root.get_left());
		    System.out.println(root.get_key());
		    inorderRec(root.get_right());
		  }
		}


  public static void main(String[] args)
  {
    SplayTree splayTree = new SplayTree();
    int i = 0;
    int tmp;
    Random rand = new Random();

    for(i = 0; i < 100; i++)
    {
      tmp = rand.nextInt(100000);
      System.out.println("Inserting "+ tmp + " into the tree.");
      //tree.set_root(tree.insert(tree.get_root(), tmp));
      splayTree.insert(tmp);
    }

    //Splay Tree
    System.out.println("\nInorder traversal" +
            " of constructed tree is : ");
    splayTree.inorderRec(splayTree.get_root());
    System.out.println("\n\nNow for the preorder traversal");
    splayTree.preOrder(splayTree.get_root());
    System.out.println();
    System.out.println("Search for Node; -1 if not found in tree: ");
    System.out.println("Search for Node 508: " + splayTree.search(508));
    System.out.println("Delete Node 508: " + splayTree.deleteNode(splayTree.get_root(), 508));
    System.out.println("Search for Node 508: " + splayTree.search(508));
    System.out.println("Search for Node 1477: " + splayTree.search(1477));
    System.out.println("Num Operations and rotations for splayTree insert is: " + countInserts());
    System.out.println("Num Operations for splayTree search is: " + countSearches());

  }
}
