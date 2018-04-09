package com.m3c.ne;

import com.m3c.ne.display.DisplayManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DisplayTester {

    DisplayManager displayManager = new DisplayManager();

    @Test
    public void testPrintArrayNoInput(){
        int[] emptyArray = new int[0];
        String printString = displayManager.print(emptyArray);
        Assert.assertEquals("",printString);
    }

    @Test
    public void testPrintArray(){
        int[] simpleArray = {3,2,1};
        String printString = displayManager.print(simpleArray);
        Assert.assertEquals("3,2,1",printString);
    }
}
