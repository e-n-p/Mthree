package com.m3c.ne.sorters;

import java.util.List;
import com.m3c.ne.binaryTree.*;

public class BinaryTreeSorter implements SortInterface {


    @Override
    public int[] sort(int[] arr) {
        BinaryTreeImp tree = new BinaryTreeImp(arr);
        List<Integer> list = tree.getSortedTreeAsc();
        int[] res = new int[arr.length];
        for(int i =0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }
    @Override
    public String toString() { return "BinaryTree Sorter";}
}
