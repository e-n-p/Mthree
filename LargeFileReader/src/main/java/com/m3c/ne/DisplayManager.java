package com.m3c.ne;

class DisplayManager {
    //class handling printing through sout
    void timeSeconds(long start, long end){
        System.out.println("This operation took: "+((end-start)/1000)+" seconds");
    }

    void topThree(String word, Integer count){
        System.out.println("word: "+word+", count: "+count);
    }
}
