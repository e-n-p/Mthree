package com.m3c.ne.binaryTree;

/*
###########################
##name of program: SortManager
##class: Node
##author: Nick Ellam
##date:17/04/18
##description: creates a simple object that exists as elements of the binary tree
##########################
*/
class Node {

    private Node left;
    private Node right;
    private int value;
    //node constructor
    Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
    //set right element
    void setRight(int element){
        this.right=new Node(element);
    }
    //set left element
    void setLeft(int element){
        this.left=new Node(element);
    }

    Node getLeft() {
        return left;
    }
    Node getRight(){
        return right;
    }

    int getValue(){
        return value;
    }
    //checks if node has right element
    boolean hasRight(Node node){
        if(node.getRight() == null){
            return false;
        }else {
            return true;
        }
    }
    //checks if node has left element
    boolean hasLeft(Node node){
        if(node.getLeft() == null){
            return false;
        }else {
            return true;
        }
    }
}