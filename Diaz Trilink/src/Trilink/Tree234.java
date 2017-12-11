/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trilink;

/**
 *
 * @author Dave
 */
public class Tree234 
{
    private Node root = new Node();
    public String output = "";
/*
‘******************************************************
‘***  Method Name find()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To find the string we are looking for in our linked list
‘*** Method Inputs: String key
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the array location or a -1 saying not found
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public int find(int key)
    {
        Node curNode = root;
        int childNumber;
        while(true)
        {
            if((childNumber = curNode.findItem(key) ) != -1)
                return childNumber;
            else if(curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }
    /*
‘******************************************************
‘***  Method Name insert()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To connect the child location in the array to the actual value
‘*** Method Inputs: String sValue
‘*** List all the method parameters with their expected value ranges
‘*** Return value: none
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public void insert(int iValue)
    {
        Node curNode = root;
        DataItem tempItem = new DataItem(iValue);
        while(true)
        {
            if(curNode.isFull())
            {
                curNode = curNode.getParent();
                
                curNode = getNextChild(curNode, iValue);
            }
            else if( curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode, iValue);
        }
        curNode.insertItem(tempItem);
    }
    

    /*
‘******************************************************
‘***  Method Name getNextChild()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To get the next value on our list
‘*** Method Inputs: Node theNode, String sValue
‘*** List all the method parameters with their expected value ranges
‘*** Return value: none
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public Node getNextChild(Node theNode, int iValue)
    {
        int j;
        int numItems = theNode.getNumItems();
        for(j=0; j<numItems; j++)
        {
            if( iValue < theNode.getItem(j).iData)
                return theNode.getChild(j);
        }
        return theNode.getChild(j);
    }
    /*
‘******************************************************
‘***  Method Name displayTree()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To call our recursive display function and return our string output
‘*** Method Inputs: Nothing
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the String value holding our list
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public String displayTree()
    {
        recDisplayTree(root, 0, 0);
        return output;
    }
/*
‘******************************************************
‘***  Method Name recDisplayTree()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To recursively display each node and the count of how many are in the textfile
‘*** Method Inputs: Node thisNode, int level, int childNumber
‘*** List all the method parameters with their expected value ranges
‘*** Return value: none
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    private void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        
        output += thisNode.displayNode();
        
        int numItems = thisNode.getNumItems();
        for(int j = 0; j< numItems + 1;j++)
        {
            Node nextNode = thisNode.getChild(j);
            if(nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }
    
    public boolean delete(int key)
    {
        Node curNode = root;
        int childNumber;
        while(true)
        {
            if((childNumber = curNode.findItem(key) ) != -1)
            {
                curNode.remove(childNumber, curNode);
                return true;
            }
            else if(curNode.isLeaf())
                return false;
            else
                curNode = getNextChild(curNode, key);
        }
    }
    
    public String setParentCount()
    {
        Node temp = new Node();
        String output = "";        
        output = Integer.toString(temp.parentCount);
        temp = null;
        return output;
    }

    public void remove(int childNumber, Node root)
    {
        Node curNode = root;
        curNode.disconnectChild(childNumber);
        curNode = null;
    }
}
