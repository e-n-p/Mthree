package com.m3c.ne.sorters;

public class BubbleSorter implements SortInterface {

    public int[] sort(int[] arr){
        bubbleSort(arr);
        return arr;
    }
    public void bubbleSort(int[] arr){
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
