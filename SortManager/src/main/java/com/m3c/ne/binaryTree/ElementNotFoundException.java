package com.m3c.ne.binaryTree;

public class ElementNotFoundException extends Exception {

    private String newMessage;

    public ElementNotFoundException(String message) {
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
