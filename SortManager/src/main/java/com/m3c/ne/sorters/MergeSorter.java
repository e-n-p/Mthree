package com.m3c.ne.sorters;

/*
###########################
##name of program: SortManager
##class: BinaryTreeImp
##author: Nick Ellam
##date:17/04/18
##description: Sorts given int arrays using the mergeSorter algorithm
##########################
*/

public class MergeSorter implements SortInterface {

    public int[] sort(int[] arr){
        mergeSort(arr);
        return arr;
    }
    //recursively divides the arr until each element is separated
    private void mergeSort(int[] arr){
        int size = arr.length;
        int mid = size/2;
        if(size<2){
            return;
        }
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        System.arraycopy(arr,0,left,0,leftSize);
        System.arraycopy(arr,mid,right,0,rightSize);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }
    //rejoins the elements in the correct order
    private void merge(int[] left, int[] right, int[] arr){
        int leftsize = left.length;
        int rightsize = right.length;
        int i=0, j=0, k=0;
        while(i < leftsize && j < rightsize){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else {
                arr[k++] = right[j++];
            }
        }
        while(i < leftsize){
            arr[k++] = left[i++];
        }
        while(j < rightsize) {
            arr[k++]=right[j++];
        }
    }
    @Override
    public String toString() { return "Merge Sorter";}
}
