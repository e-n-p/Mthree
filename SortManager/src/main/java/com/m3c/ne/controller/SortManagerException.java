package com.m3c.ne.controller;

public class SortManagerException extends Exception{

    private String newMessage;

    public SortManagerException(String message) {
        //System.out.println("exception thrown:- ("+ message+") - has been returned, check factory.properties");
        super(message);
    }
    public String getNewMessage() {
        return newMessage;
    }
    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
}
