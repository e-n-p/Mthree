package com.m3c.ne.sorters;

/*
###########################
##name of program: SortManager
##class: BinaryTreeImp
##author: Nick Ellam
##date:17/04/18
##description: uses the bubblesort algorith to sort a given int array
##########################
*/

public class BubbleSorter implements SortInterface {

    public int[] sort(int[] arr){
        bubbleSort(arr);
        return arr;
    }
    private void bubbleSort(int[] arr){
        int hold;
        Boolean swapped =true;
        while(swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    hold = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = hold;
                    swapped = true;
                }
            }
        }
    }
    @Override
    public String toString() { return "Bubble Sorter";}
}
