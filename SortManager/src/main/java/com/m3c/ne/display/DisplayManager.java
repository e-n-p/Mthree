package com.m3c.ne.display;

import com.m3c.ne.sorters.SortInterface;
import java.text.DecimalFormat;

public class DisplayManager {

    public void displayUnsortedArray(SortInterface sorter, int[] arrUnsorted){
        System.out.println("Sort using: "+ sorter.toString());
        System.out.println("Unsorted Array: " + print(arrUnsorted));
    }

    public void displaySorted(int[] arrSorted, long time){
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("Sorted Array: "+print(arrSorted));
        System.out.println("This sort took: "+ df.format(time));
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
    }

    public void binaryTreeNoChild(String direction){
        System.out.println("There doesn't exist a "+ direction +" child of this element");
    }
}
