package com.m3c.ne;

import org.junit.Assert;
import org.junit.Test;

public class WordFinderTester {



    @Test
    public void correctResults(){
        String path = "resources/test.txt";
        TopWordFinder topWordFinder = new TopWordFinder(path);
        String[] res = topWordFinder.processDocument();
        Assert.assertArrayEquals(new String[]{"the 7","and 6","rat 3"},res);
    }


}
