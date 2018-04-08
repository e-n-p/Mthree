package com.m3c.ne;

class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int value;

    TreeNode(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
    void setRight(int element){
        this.right=new TreeNode(element);
    }
    void setLeft(int element){
        this.left=new TreeNode(element);
    }
    TreeNode getLeft() {
        return left;
    }
    TreeNode getRight(){
        return right;
    }
    int getValue(){
        return value;
    }

    boolean hasRight(TreeNode node){
        if(node.getRight() == null){
            return false;
        }else {
            return true;
        }
    }

    boolean hasLeft(TreeNode node){
        if(node.getLeft() == null){
            return false;
        }else {
            return true;
        }
    }
}