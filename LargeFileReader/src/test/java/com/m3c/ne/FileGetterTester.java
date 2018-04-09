package com.m3c.ne;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class FileGetterTester {

    @Test
    public void testException(){
        FileGetter fileGetter = new FileGetter("resources/noSuchFile.txt");
        Assert.assertEquals(null,fileGetter.openFile());
    }


}
