package com.m3c.ne;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.IOException;

/*
###########################
##name of program: TopWordFinder
##class: Starter
##author: Nick Ellam
##date:18/04/18
##description: main class for program
##########################
*/

public class Starter {

    private static Logger logger = Logger.getLogger(Starter.class.getName());


    public static void main(String[] args) throws IOException{
        DisplayManager displayManager = new DisplayManager();
        PropertyConfigurator.configure("resources/log4j.properties");
        String path = "resources/test.txt";
        TopWordFinder topWordFinder = new TopWordFinder(path);

        //record time at start of run
        Long start = System.currentTimeMillis();
        displayManager.topThree(topWordFinder.processDocument());
        Long end = System.currentTimeMillis();
        displayManager.timeSeconds(start, end);

        logger.info("run started, "+start+", run ended "+end);
    }
}
