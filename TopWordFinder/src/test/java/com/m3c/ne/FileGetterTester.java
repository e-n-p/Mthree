package com.m3c.ne;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

import java.io.FileNotFoundException;

public class FileGetterTester {

    @Test
    public void testForNull(){
        FileGetter fileGetter = new FileGetter("resources/noSuchFile.txt");
        Assert.assertEquals(null,fileGetter.openFile());
    }

}
