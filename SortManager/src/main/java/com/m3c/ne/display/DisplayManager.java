package com.m3c.ne.display;

import com.m3c.ne.sorters.SortInterface;
import org.apache.log4j.Logger;
import java.text.DecimalFormat;

/*
###########################
##name of program: SortManager
##class: DisplayManager
##author: Nick Ellam
##date:17/04/18
##description: handles all printing out to console for the program, contains logging
##########################
*/

public class DisplayManager {
    static Logger logger = Logger.getLogger(DisplayManager.class.getName());

    public void displayUnsortedArray(SortInterface sorter, int[] arrUnsorted){
        System.out.println("Sort using: "+ sorter.toString());
        System.out.println("Unsorted Array: " + print(arrUnsorted));
    }

    //prints sorted array with time take in more readable format
    public void displaySorted(int[] arrSorted, long time){
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("Sorted Array: "+print(arrSorted));
        System.out.println("This sort took: "+ df.format(time));
        logger.info("Sorting took "+df.format(time));
        logger.info("The array sorted was "+print(arrSorted));
    }

    public String print(int[] arr){
        String res ="";
        if(arr.length > 0){
            for (int element : arr) {
                res += element+",";
            }
            res = res.substring(0,res.length()-1);
        }
        return res;
    }

    public void sortErrorMessage(String message){
        System.out.println("exception thrown:- ("+ message+") - has been returned, check factory.properties");
        logger.debug("exception thrown:- ("+ message+")");
    }

    public void binaryTreeNoChild(String direction){
        System.out.println("There doesn't exist a "+ direction +" child of this element");
    }
    public void validIntegerMessage(){
        System.out.println("Please enter a valid integer");
    }
}
