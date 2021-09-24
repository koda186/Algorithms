// Graph.java
// This program contains a basic graph implementation using an adjacency list
// It contains insert for both edges and nodes, searching for nodes, and print

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

class Node
{
  private String my_name;
  private ArrayList<String> adj;

  public Node(String n1)
  {
    my_name = n1;
    adj = new ArrayList<>();
  }

  public String get_node()
  {
    return my_name;
  }

  public void add_edge(String the_node)
  {
    adj.add(the_node);
  }

  //remove edges
  public void remove_edge(String the_node)
  {
	  adj.remove(the_node);
  }

  public ArrayList<String> get_edges()
  {
    return adj;
  }
}


//Graph
public class Graph
{
  private ArrayList<Node> nodes;
  private int size;

  boolean tmpVisited[] = new boolean[100];

  public Graph()
  {
    nodes = new ArrayList<>();

    size = 0;
  }

  //addNode to list
  public void add_node(String n1)
  {
    for(Node tmp : this.nodes)
    {
    	  //node cycled into tmp
    	  //System.out.println("THIS-->tmp node cycled: " + tmp.get_node());
      if (tmp.get_node().equals(n1))
      {
        System.out.println("Duplicate node found");
        return;
      }
    }

    this.nodes.add(new Node(n1));
    //node added
    System.out.println("THIS node added: " + n1);
	System.out.println();
    this.size++;
  }
  //add edges to list
  public void add_edge(String n1, String n2)
  {
	System.out.println("n1 == " + n1 + ":" + " n2 == " + n2 );
    boolean found = false;
    for(Node tmp : this.nodes)
    {
    	  //tmp node printout
    	  //System.out.println("tmp node added " + tmp.get_node() );
      if (tmp.get_node().equals(n1))
      {
         //tmp node edge printout
         //System.out.println("if tmp node " + tmp.get_node() + " .equals " + n1);
         found = true;
         tmp.add_edge(n2);
         //found tmp node edge printout
         System.out.println("found, tmp node edge added: " + n2 + " : " + n1 + "---" + n2);
         System.out.println();
         break;
      }
    }

    if(!found)
    {
      System.out.println("Node not found " + n1);
      this.nodes.add(new Node(n1));
      this.nodes.get(nodes.size()-1).add_edge(n2);
      size++;
    }

    //System.out.println("n1 == " + n1 + ":" + " n2 == " + n2 );
    found = false;
    for(Node tmp : this.nodes)
    {
    	  //tmp node printout
	  //System.out.println("tmp node added " + tmp.get_node() );
      if (tmp.get_node().equals(n2))
      {
         //tmp node edge printout
         //System.out.println("if tmp node " + tmp.get_node() + " .equals " + n2);
         found = true;
         tmp.add_edge(n1);
         //found tmp node edge printout
         System.out.println("found, tmp node edge added: " + n1 + " : " + n2 + "---" + n1);
         System.out.println();
         break;
      }
    }
    if(!found)
    {
      System.out.println("Node not found " + n2);
      this.nodes.add(new Node(n2));
      this.nodes.get(nodes.size()-1).add_edge(n1);
      size++;
    }
  }

  //Search Nodes for String X
  public boolean search(String x)
  {
	  boolean isFound = false;
	  for(Node tmp : this.nodes)
	  {
		  if (x.equals(tmp.get_node()))
			  isFound = true;
		  //System.out.println("Searching for Node: " + tmp.get_node());
	  }
	  return isFound;
  }

  //find node location
  public Node searchNodeIndex(String x)
  {
	  Node searchIndex = null;
	  int index = 0;
	  if (search(x))
	  {
	  for(Node tmp : this.nodes)
	  {
		  if (x.equals(tmp.get_node()))
		  {
			  //isFound = true;
			  index++;
			  searchIndex = (this.nodes.get(index));
			  //System.out.println("Searching for Node: " + searchIndex.get_node());
			  //System.out.println("SearchIndex is: " + searchIndex);
			  //System.out.println("Searching for Node: " + tmp.get_node());
		  }
	  }
	  }
	  else
		  System.out.print("Node not found in Graph!");
	  return searchIndex;
  }

  //delete node
  public void delete(String x)
  {
	//delete node
	System.out.println("Node Deleted: " + x);
	this.nodes.remove(searchNodeIndex(x));
	this.size--;

	//delete edges
	for(Node tmp : this.nodes)
	{
		//removeEdges(tmp.get_edges());
		tmp.remove_edge(x);
	}
  }

  //dfs traversal
  //public void DFSUtil(int v, boolean visited[], ArrayList<Node> nodeList)
  public void DFSUtil(String startingNode, boolean visited[])
  {
	  //TODO
	  int v = 0;
	  for(Node tmp : this.nodes)
	  {
		  if(startingNode.equals(tmp.get_node()))
		  {
			  // Mark current node as visited
			  visited[v] = true;
			  System.out.println("v" + v + " == " + tmp.get_node());
			  System.out.println(tmp.get_node() +" is Visited: " + visited[v]);
			  //System.out.println(this.nodes.get(v) + " == " + tmp.get_node());
		      ArrayList<String> adj = tmp.get_edges();
		      System.out.println("Edges are: " + adj);

		      int n = 1;
			  for(String tmpAdj : adj)
		      {
		        if (!visited[n])
		        {
		        		System.out.println(tmp.get_node() + " --DFS--> " + tmpAdj);
		        		System.out.println(tmpAdj + " is Visited: " + visited[n]);

		        		DFSUtil(tmpAdj, visited);
		        }
		        n++;
		      }
		  }
		  v++;

		  //check for connected graph if each node is visited
		  for(int index = 0; index < visited.length; index++)
	      {
	        	tmpVisited[index] = visited[index];
	      }
	  }
  }

   //helper function
   void DFS(String startingNode)
   {
    	  	int size = size();
    	  	// Mark all the nodes as not visited(set as false by default by java)
        boolean visited[] = new boolean[size];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(startingNode, visited);
   }

   //check if graph is connected
   Boolean isConnected()
   {
    	  	//TODO
    	  	boolean flag = false;
    	  	//traverse all nodes to check if visited
    	  	for(int index = 0; index < size; index++)
    	  	{
    	  		//System.out.println(index);
    	  		if (tmpVisited[index] == true)
    	  		{
    	  			flag = true;
    	  		}
    	  		else
    	  		{
    	  			//System.out.println(index);
    	  			flag = false;
    	  		}
    	  	}
    	  	return flag;
    }



  //graph size
  public int size()
  {
    return this.size;
  }

  //print graph
  public void print()
  {
    for(Node tmp : nodes)
    {
      System.out.println("tmp node: " + tmp.get_node());
      ArrayList<String> to_print = tmp.get_edges();
      System.out.println("Edges are: " + to_print);
      for(String tmp2 : to_print)
      {
    	  	System.out.println(tmp.get_node() + "--"+ tmp2);
        //System.out.printf("%s %s\n", tmp.get_node(), tmp2);
      }
      System.out.println();
    }
  }

  public static void main(String args[])
  {
    Graph my_graph = new Graph();

    System.out.println("We will manually load in a graph, and then create and load in a large graph from file.");
    my_graph.add_node("A");
    my_graph.add_node("B");
    my_graph.add_node("C");
    my_graph.add_node("D");
    my_graph.add_node("E");
    System.out.println("Search for node 'B' before deletion; found: " + my_graph.search("B"));
    System.out.println("Search for node 'F' found: " + my_graph.search("F"));
    System.out.println();
    //my_graph.delete("B");
    //System.out.println("Search node found: " + my_graph.search("B"));
    System.out.println("my_graph size: " + my_graph.size());
	System.out.println();
    System.out.println("Adding Edges now");
    my_graph.add_edge("A", "B");
    my_graph.add_edge("A", "C");
    my_graph.add_edge("A", "D");
    my_graph.add_edge("A", "E");
    my_graph.add_edge("B", "C");
    my_graph.add_edge("B", "D");
    my_graph.add_edge("B", "E");
    my_graph.add_edge("C", "D");
    my_graph.add_edge("C", "E");
    my_graph.add_edge("D", "E");
    System.out.println("my_graph size: " + my_graph.size());
    //my_graph.delete("B");
    //System.out.println("Search for node 'B' after deletion; found: " + my_graph.search("B"));
    //System.out.println("Edges after deleting 'B': ");
    	my_graph.print();
    System.out.println("my_graph size: " + my_graph.size());
    my_graph.print();
    System.out.println("DFS: ");
    System.out.println("my_graph size: " + my_graph.size());
    my_graph.DFS("A");
    System.out.println("Graph is connected: " + my_graph.isConnected());



  }
}
