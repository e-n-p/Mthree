package com.m3c.ne;

public class Starter {

    public static void main(String[] args){
        //TODO tests
        TopWordFinder topWordFinder = new TopWordFinder();
        topWordFinder.processDocument("resources/books.txt");
    }
}
