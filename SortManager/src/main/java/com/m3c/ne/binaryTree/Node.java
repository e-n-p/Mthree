package com.m3c.ne.binaryTree;

public class Node {

    private Node left;
    private Node right;
    private int value;

    public Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
    public void setRight(int element){
        this.right=new Node(element);
    }
    public void setLeft(int element){
        this.left=new Node(element);
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight(){
        return right;
    }
    public int getValue(){
        return value;
    }

    public boolean hasRight(Node node){
        if(node.getRight() == null){
            return false;
        }else {
            return true;
        }
    }

    public boolean hasLeft(Node node){
        if(node.getLeft() == null){
            return false;
        }else {
            return true;
        }
    }
}