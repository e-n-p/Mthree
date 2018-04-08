package com.m3c.ne.controller;

import com.m3c.ne.sorters.BinaryTreeSorter;
import com.m3c.ne.sorters.BubbleSorter;
import com.m3c.ne.sorters.MergeSorter;
import com.m3c.ne.sorters.SortInterface;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {
    public static SortInterface getInstance() throws SortManagerException {
        try( FileReader fr = new FileReader("resources/factory.properties")) {
            Properties properties = new Properties();
            properties.load(fr);
            String sorter = properties.getProperty("sorter");
            switch (sorter) {
                case "bubble":
                    return new BubbleSorter();
                case "merge":
                    return new MergeSorter();
                case "tree":
                    return new BinaryTreeSorter();
                default:
                    throw new SortManagerException(sorter);
            }
        } catch (IOException e1) {
            throw new SortManagerException("File read error");
        }
    }
}