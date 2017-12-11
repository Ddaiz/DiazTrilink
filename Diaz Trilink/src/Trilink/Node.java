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
public class Node 
{
    private static final int ORDER = 3;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];
    public int parentCount = 0;
    
/*
‘******************************************************
‘***  Method Name connectChild()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method:
‘*** To connect the child location in the array to the actual value
‘*** Method Inputs: location and node
‘*** List all the method parameters with their expected value ranges
‘*** Return value: none
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if(child != null)
        {
            child.parent = this;
        }
    }
    /*
‘******************************************************
‘***  Method Name disconnectChild()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To disconnect child from node and return it
‘*** Method Inputs: the location
‘*** List all the method parameters with their expected value ranges
‘*** Return value: none
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }
    
    /*
‘******************************************************
‘***  Method Name getChild()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To return the child
‘*** Method Inputs: child location
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the node holding the child
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public Node getChild(int childNum)
    {
        return childArray[childNum];
    }
    /*
‘******************************************************
‘***  Method Name getParent()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To return the parent
‘*** Method Inputs: none
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the node holding the parent
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/    
    public Node getParent()
    {
        parentCount += 1;
        return parent;
    }
/*
‘******************************************************
‘***  Method Name isLeaf()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To determine if the node has a child
‘*** Method Inputs: 
‘*** List all the method parameters with their expected value ranges
‘*** Return value: boolean value telling us if it holds the value or not
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public boolean isLeaf()
    {
        return (childArray[0]==null) ? true : false;
    }
    
/*
‘******************************************************
‘***  Method Name getNumItems()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To return number of items held
‘*** Method Inputs: none
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the number of items
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public int getNumItems()
    {
        return numItems;
    }
     /*
‘******************************************************
‘***  Method Name getItem()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To the dataItem at the index
‘*** Method Inputs: the index
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the dataitem at the index
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/   
    public DataItem getItem(int index)
    {
        return itemArray[index];
    }
/*
‘******************************************************
‘***  Method Name isFull()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To determine if the amount of space we asked for is full
‘*** Method Inputs: none
‘*** List all the method parameters with their expected value ranges
‘*** Return value: boolean value to determine
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public boolean isFull()
    {
        return (numItems==ORDER-1) ? true : false;
    }
    
/*
‘******************************************************
‘***  Method Name findItem()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To find the value entered in the method
‘*** Method Inputs: value to look for in our Linked list
‘*** List all the method parameters with their expected value ranges
‘*** Return value: location in integer value
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    
    public int findItem(int key)
    {
        for(int j = 0; j<ORDER-1; j++)
        {
            if(itemArray[j] == null)
                break;
            else if(itemArray[j].iData == key)
            {
                //itemArray[j].intData += 1;
                return j;
            }
        }
        return -1;
    }
/*
‘******************************************************
‘***  Method Name insertItem()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To insert the dataitem into the location we want
‘*** Method Inputs: the dataitem to insert
‘*** List all the method parameters with their expected value ranges
‘*** Return value: integer
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public int insertItem(DataItem newItem)
    {
        numItems++;
        int newKey = newItem.iData;
        
        for(int j=ORDER-2; j>=0; j--)
        {
            if(itemArray[j] == null)
                continue;
            else
            {
                int itsKey = itemArray[j].iData;
                if(newKey < itsKey)
                    itemArray[j+1] = itemArray[j];
                else
                {
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

/*
‘******************************************************
‘***  Method Name displayNode()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To display and format output
‘*** Method Inputs: none
‘*** List all the method parameters with their expected value ranges
‘*** Return value: the string holding our format
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public String displayNode()
    {
        String output = "";
        for(int j = 0; j < numItems; j++)
            output += itemArray[j].displayItem();
        return output;
    }   
    
    public int getParentCount()
    {
        return this.parentCount;
    }
}
    

