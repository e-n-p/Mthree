package com.m3c.ne;

import com.m3c.ne.controller.SortFactory;
import com.m3c.ne.controller.SortManagerException;
import com.m3c.ne.sorters.BinaryTreeSorter;
import com.m3c.ne.sorters.BubbleSorter;
import com.m3c.ne.sorters.MergeSorter;
import com.m3c.ne.sorters.SortInterface;
import org.junit.Assert;
import org.junit.Test;

public class SortManagerTester {

    @Test
    public void mergeInstanceTest(){
        SortInterface mergeSorter= new MergeSorter();
        Assert.assertEquals(true, (mergeSorter instanceof MergeSorter));
    }
    @Test
    public void bubbleInstanceTest(){
        SortInterface bubbleSorter= new BubbleSorter();
        Assert.assertEquals(true, (bubbleSorter instanceof BubbleSorter));
    }
    @Test
    public void treeInstanceTest(){
        SortInterface treeSorter= new BinaryTreeSorter();
        Assert.assertEquals(true, (treeSorter instanceof BinaryTreeSorter));
    }
    @Test
    public void sortFactoryInstanceTest(){
        try {
            SortInterface sorter = SortFactory.getInstance();
            Assert.assertEquals(true, (sorter instanceof BinaryTreeSorter));
        } catch (SortManagerException e) {
            e.printStackTrace();
        }
    }
}
