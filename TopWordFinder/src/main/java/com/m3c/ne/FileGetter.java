package com.m3c.ne;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
###########################
##name of program: TopWordFinder
##class: FileGetter
##author: Nick Ellam
##date:18/04/18
##description: handles accessing file to be read for the program, return BufferedReader
##########################
*/

class FileGetter {

    private final String path;
    private static Logger logger = Logger.getLogger(DisplayManager.class.getName());

    //constructor taking path to file
    FileGetter(String path){
        this.path = path;
        logger.info("The given path"+path);
    }

    //method to open file handling file not found exceptions
    BufferedReader openFile(){
        try {
            return new BufferedReader(new FileReader(path));
        }catch (FileNotFoundException F){
            F.printStackTrace();
            logger.debug("File not found");
        }
        return null;
    }
}