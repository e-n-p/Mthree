package com.m3c.ne.controller;

import com.m3c.ne.sorters.BinaryTreeSorter;
import com.m3c.ne.sorters.BubbleSorter;
import com.m3c.ne.sorters.MergeSorter;
import com.m3c.ne.sorters.SortInterface;
import org.apache.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
###########################
##name of program: SortManager
##class: SortFactory
##author: Nick Ellam
##date:17/04/18
##description: generates sort instance depending on options read in from factory.properties
##########################
*/

public class SortFactory {
    //initialise logger
    static Logger logger = Logger.getLogger(SortFactory.class.getName());

    public static SortInterface getInstance() throws SortManagerException {
        String resourceLocation= "resources/factory.properties";
        //access properties location, read file with fileReader
        try( FileReader fr = new FileReader(resourceLocation)) {
            Properties properties = new Properties();
            //load properties
            properties.load(fr);
            String sorter = properties.getProperty("sorter");
            logger.trace("The chose sorter for this run was: "+sorter);
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
            //catches and logs exceptions in reading resource files
            logger.debug("File read error, accessing "+ resourceLocation);
            throw new SortManagerException("File read error");
        }
    }
}