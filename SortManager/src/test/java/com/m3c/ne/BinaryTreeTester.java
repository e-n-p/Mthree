package com.m3c.ne;

import com.m3c.ne.binaryTree.BinaryTreeImp;
import com.m3c.ne.binaryTree.ElementNotFoundException;
import com.m3c.ne.sorters.BinaryTreeSorter;
import com.m3c.ne.sorters.SortInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryTreeTester {
    public SortInterface sorter;

    @Before
    public void setup(){
        sorter = new BinaryTreeSorter();
    }
    BinaryTreeImp testTree = new BinaryTreeImp(new int[]{1,2,4,5,4,5,5});

    @Test
    public void testEmptyArray(){
        int[] emptyArray = new int[0];
        int[] sortedArray = sorter.sort(emptyArray);
        Assert.assertEquals(0,sortedArray.length);
    }
    @Test
    public void testDuplicates(){
        int[] duplicatesArr={1,2,4,5,4,5,5};
        String originalOrder = testTree.getNonSortedTree();
        int[] sortedArr= sorter.sort(duplicatesArr);
        System.out.println("order entered to the tree: "+originalOrder);
        System.out.println("sorted order return: "+Arrays.toString(sortedArr));
        Assert.assertArrayEquals(new int[]{1,2,4,4,5,5,5},sortedArr);
    }
    @Test
    public void singleElementArray(){
        int[] singleArray={5};
        int[] sortedArray = sorter.sort(singleArray);
        Assert.assertArrayEquals(singleArray,sortedArray);
    }
    @Test
    public void reverseSortedArray(){
        int[] reversedArray={9,8,7,6,5,4,3,2,1};
        int[] sortedArray=sorter.sort(reversedArray);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9},sortedArray);
    }
    @Test
    public void testNegatives(){
        int[] negativeArray = {-5,-8,-41,0,7};
        int[] sortedArray = sorter.sort(negativeArray);
        Assert.assertArrayEquals(new int[]{-41,-8,-5,0,7}, sortedArray);
    }
    @Test
    public void testPresorted(){
        int[] PresortedArray={1,3,4,5,8,555};
        int[] sortedArray = sorter.sort(PresortedArray);
        Assert.assertArrayEquals(PresortedArray,sortedArray);
    }
    @Test(expected = ElementNotFoundException.class)
    public void exceptionNoLeftChild() throws ElementNotFoundException {
        try{
            testTree.getLeftChild(8);
        }catch(ElementNotFoundException E){
            throw new ElementNotFoundException("No child of this element");
        }
    }
    @Test(expected = ElementNotFoundException.class)
    public void exceptionNoRightChild() throws ElementNotFoundException {
        try{
            testTree.getRightChild(10);
        }catch(ElementNotFoundException E){
            throw new ElementNotFoundException("No child of this element");
        }
    }
    @Test
    public void getLeftChild() {
        try{
            Assert.assertEquals(testTree.getLeftChild(2),1);
        }catch(ElementNotFoundException E){
            E.printStackTrace();
        }
    }
    @Test
    public void getRightChild(){
        try{
            Assert.assertEquals(testTree.getRightChild(2), 9);
        }catch(ElementNotFoundException E){
            E.printStackTrace();
        }
    }
    @Test
    public void testToString(){
        Assert.assertEquals("BinaryTree Sorter",sorter.toString());

    }

}
