package com.m3c.ne.controller;

import com.m3c.ne.display.DisplayManager;
import com.m3c.ne.sorters.*;
import java.util.Random;

public class SortManager {
    public void sortArray(int size){
        DisplayManager disMan  = new DisplayManager();
        try {
            SortInterface sorter = SortFactory.getInstance();
            int[] arrayToSort = createArray(size);

            disMan.displayUnsortedArray(sorter, arrayToSort);
            long start = System.nanoTime();
            int[] sortedArray = sorter.sort(arrayToSort);
            long end = System.nanoTime();

            disMan.displaySorted(sortedArray, end - start);
        }catch(SortManagerException sme){
            disMan.sortErrorMessage(sme.getMessage());
        }
    }
    private int[] createArray(int size){
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i=0;i< size; i++){
            unsortedArray[i] = random.nextInt(size*10)+1;
        }
        return unsortedArray;
    }
}