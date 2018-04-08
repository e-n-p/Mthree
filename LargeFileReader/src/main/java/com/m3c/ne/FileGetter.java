package com.m3c.ne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileGetter {

    private final String path;

    //constructor taking path to file
    FileGetter(String path){
        this.path = path;
    }
    //method to open file handling file not found exceptions
    BufferedReader openFile(){
        try {
            return new BufferedReader(new FileReader(path));
        }catch (FileNotFoundException F){
            F.printStackTrace();
        }
        return null;
    }
}