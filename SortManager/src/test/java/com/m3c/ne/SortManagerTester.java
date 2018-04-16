package com.m3c.ne;

import com.m3c.ne.controller.SortManager;
import org.junit.Before;
import org.junit.Test;

public class SortManagerTester {

    @Before
    public void setup(){

    }

    @Test
    public void exception(){
        SortManager sortManager = new SortManager();
        sortManager.sortArray(-8);
    }


    @Test
    public void testCreateArraySize(){

    }



}
