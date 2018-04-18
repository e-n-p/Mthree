package com.m3c.ne.controller;

import com.m3c.ne.display.DisplayManager;
import com.m3c.ne.sorters.*;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

/*
###########################
##name of program: SortManager
##class: SortManager
##author: Nick Ellam
##date:17/04/18
##description: Handles the sorting calls by generating unsorted array and provides addition timing information
##########################
*/

public class SortManager {
    //init logger
    static Logger logger = Logger.getLogger(SortManager.class.getName());

    void sortArray(int size){
        DisplayManager displayManager  = new DisplayManager();
        //error checking input
        if(size < 0){
            displayManager.validIntegerMessage();
            logger.debug("Invalid integer entered");
        }else {
            try {
                SortInterface sorter = SortFactory.getInstance();
                int[] arrayToSort = createArray(size);

                displayManager.displayUnsortedArray(sorter, arrayToSort);
                long start = System.nanoTime();
                int[] sortedArray = sorter.sort(arrayToSort);
                long end = System.nanoTime();

                displayManager.displaySorted(sortedArray, end - start);
            }catch(SortManagerException sme){
                //catches and logs SortFactory usage exceptions
                displayManager.sortErrorMessage(sme.getMessage());
                logger.debug("SortFactor.getInstance has failed, exception message: "+ sme.getMessage());
            }
        }
    }

    private int[] createArray(int size){
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i=0;i< size; i++){
            unsortedArray[i] = random.nextInt(size*10)+1;
        }
        logger.info("Generated Array: "+ Arrays.toString(unsortedArray));
        return unsortedArray;
    }
}