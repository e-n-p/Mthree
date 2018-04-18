package com.m3c.ne;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BubbleSortTester.class,
        MergeSortTester.class,
        BinaryTreeTester.class,
        DisplayTester.class,
        SortManagerTester.class
})

public class TestSuite {
}