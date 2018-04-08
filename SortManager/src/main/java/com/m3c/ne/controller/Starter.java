package com.m3c.ne.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import static java.util.logging.Level.WARNING;

public class Starter
{
    private static Logger logger = Logger.getLogger(Starter.class.getName());



    public static void main( String[] args ) throws IOException {
        //TODO check/finish exception handling, add logging code, more xtensive testing, comments

        Properties props = new Properties();
        props.load(new FileInputStream("/home/nick/Programming/gitProjects/Mthree/SortManager/resources/log4j.properties"));

        SortManager sortManager = new SortManager();
        sortManager.sortArray(100);
        logger.log(WARNING,"Testing logging");
    }
}