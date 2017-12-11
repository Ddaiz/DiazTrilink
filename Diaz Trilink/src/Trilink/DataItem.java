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
public class DataItem 
{

    public int iData;
    public int intData = 1;
    public DataItem(int iD)
    {
       iData = iD;
    }

/*
‘******************************************************
‘***  Method Name displayItem()
‘***  Method Author Dave Diaz
‘******************************************************
‘*** Purpose of the Method: 
‘*** To display each number
‘*** Method Inputs: none
‘*** List all the method parameters with their expected value ranges
‘*** Return value: String holding our values with separators
‘*** If this is a function list the return data type and the expected range of 
‘*** values to be returned.
‘******************************************************
‘*** Date 12/10/2017
‘******************************************************
*/
    public String displayItem()
    {
       return String.format("%d \n", iData);
    }   
}
