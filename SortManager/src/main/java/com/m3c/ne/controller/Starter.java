package com.m3c.ne.controller;

import org.apache.log4j.PropertyConfigurator;
import java.io.IOException;

/*
###########################
##name of program: SortManager
##class: Starter
##author: Nick Ellam
##date:17/04/18
##description: main class for program
##########################
*/

public class Starter{

    public static void main( String[] args ) throws IOException {
        PropertyConfigurator.configure("resources/log4j.properties");
        SortManager sortManager = new SortManager();
        sortManager.sortArray(5);
    }
}