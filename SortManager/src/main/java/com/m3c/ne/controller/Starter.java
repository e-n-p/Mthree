package com.m3c.ne.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.IOException;

public class Starter{
    static Logger logger = Logger.getLogger(Starter.class.getName());

    public static void main( String[] args ) throws IOException {
        //TODO get logging to file working, more extensive testing, comments
        //
        PropertyConfigurator.configure("resources/log4j.properties");
        SortManager sortManager = new SortManager();
        sortManager.sortArray(10);
        logger.trace(sortManager.toString());
    }
}