package com.m3c.ne;

import com.m3c.ne.binaryTree.BinaryTreeImp;
import com.m3c.ne.binaryTree.ElementNotFoundException;
import com.m3c.ne.sorters.BinaryTreeSorter;
import com.m3c.ne.sorters.SortInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTester {
    public SortInterface sorter;

    @Before
    public void setup(){
        sorter = new BinaryTreeSorter();
    }
    BinaryTreeImp testTree = new BinaryTreeImp(new int[]{2,9,6,7,1});

    @Test
    public void testEmptyArray(){
        int[] emptyArray = new int[0];
        int[] sortedArray = sorter.sort(emptyArray);
        Assert.assertEquals(0,sortedArray.length);
    }
    @Test
    public void singleElementArray(){
        int[] singleArray={5};
        int[] sortedArray = sorter.sort(singleArray);
        Assert.assertArrayEquals(singleArray,sortedArray);
    }
    @Test
    public void duplicatesInArray(){
        int[] arrayWDuplicates={4,4,4,10,4,8,8};
        int[] sortedArray=sorter.sort(arrayWDuplicates);
        Assert.assertArrayEquals(new int[]{4,4,4,4,8,8,10},sortedArray);
    }
    @Test
    public void reverseSortedArray(){
        int[] reversedArray={9,8,7,6,5,4,3,2,1};
        int[] sortedArray=sorter.sort(reversedArray);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9},sortedArray);
    }
    @Test
    public void testNegatives(){
        int[] negativeArray = {-5,-8,-41,-5,0,7};
        int[] sortedArray = sorter.sort(negativeArray);
        Assert.assertArrayEquals(new int[]{-41,-8,-5,-5,0,7}, sortedArray);
    }
    @Test
    public void testPresorted(){
        int[] PresortedArray={1,3,4,5,8,555};
        int[] sortedArray = sorter.sort(PresortedArray);
        Assert.assertArrayEquals(PresortedArray,sortedArray);
    }
    @Test
    public void exceptionNoChild() throws ElementNotFoundException {
        try{
            testTree.getLeftChild(8);
        }catch(ElementNotFoundException E){
            throw new ElementNotFoundException("No child of this element");
        }
    }

}
