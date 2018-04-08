package com.m3c.ne.controller;

public class Starter
{
    public static void main( String[] args ){
        //TODO check/finish expception handling, add logging code, more xtensive testing, comments
        SortManager sortManager = new SortManager();
        sortManager.sortArray(100);
    }
}