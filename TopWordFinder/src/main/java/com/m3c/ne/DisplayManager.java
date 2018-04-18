package com.m3c.ne;

/*
###########################
##name of program: TopWordFinder
##class: DisplayManager
##author: Nick Ellam
##date:18/04/18
##description: class handling printing through sout
##########################
*/

class DisplayManager {
    void timeSeconds(long start, long end){
        System.out.println("This operation took: "+((end-start)/1000)+" seconds");
    }

    void topThree(String[] arr ){
        for (String s:arr) {
            System.out.println(s);
        }
    }
}
