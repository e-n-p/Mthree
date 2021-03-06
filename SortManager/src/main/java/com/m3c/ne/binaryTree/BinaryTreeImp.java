package com.m3c.ne.binaryTree;

import com.m3c.ne.display.DisplayManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
###########################
##name of program: SortManager
##class: BinaryTreeImp
##author: Nick Ellam
##date:17/04/18
##description: creates and controls access to the binary tree
##########################
*/

public class BinaryTreeImp implements BinaryTree {

    private int nodeCount = 0;
    private ArrayList<Integer> list = new ArrayList<>();
    private Node root;
    private DisplayManager displayManager = new DisplayManager();

    //single element constructor
    public BinaryTreeImp(int value) {
        this.root = new Node(value);
    }
    //multi element constructors
    public BinaryTreeImp(int[] values) {
        if (values.length >= 1) {
            this.root = new Node(values[0]);
            nodeCount++;
            for (int i = 1; i < values.length; i++) {
                addElement(values[i]);
            }
        }
    }

    public int getRootElement() {
        return root.getValue();
    }

    public int getNumberOfElements() {
        return nodeCount;
    }

    //adds single element onto tree
    public void addElement(int element) {
        insertElement(root, element);
    }

    //recursively insert elements to the tree
    private void insertElement(Node node, int element) {
        if (element >= node.getValue() && node.hasRight(node)) {
            insertElement(node.getRight(), element);
        } else if (element > node.getValue()) {
            node.setRight(element);
            nodeCount++;
        } else if (element <= node.getValue() && node.hasLeft(node)) {
            insertElement(node.getLeft(), element);
        } else {
            node.setLeft(element);
            nodeCount++;
        }
    }

    //add many elements to the tree
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    //interface class calls lookup method
    public boolean findElement(int value) {
        return lookUp(root, value);
    }

    //find if element exists in the tree
    private boolean lookUp(Node node, int value) {
        while (node != null) {
            if (value == node.getValue()) {
                return true;
            } else if (value > node.getValue() && node.hasRight(node)) {
                node = node.getRight();
            } else if (value < node.getValue() && node.hasLeft(node)) {
                node = node.getLeft();
            } else {
                return false;
            }
        }
        return false;
    }

    //return left child of given element, throwing an exception if nothing is found
    public int getLeftChild(int element) throws ElementNotFoundException {
        try {
            Node leftParent = getElementVal(root, element);
            if (leftParent == null) {
                displayManager.binaryTreeNoChild("left");
                return 0;
            } else {
                return leftParent.getLeft().getValue();
            }
        } catch (NullPointerException E) {
            throw new ElementNotFoundException("No left child of element " + element);
        }
    }

    //return right child of given element, throwing an exception if nothing is found
    public int getRightChild(int element) throws ElementNotFoundException {
        try {
            Node rightParent = getElementVal(root, element);
            if (rightParent == null) {
                displayManager.binaryTreeNoChild("right");
                return 0;
            } else {
                return rightParent.getRight().getValue();
            }
        } catch (NullPointerException E) {
            throw new ElementNotFoundException("No right child of element" + element);
        }
    }

    //returns node with matching value
    private Node getElementVal(Node node, int element) {
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            } else if (element > node.getValue() && node.hasRight(node)) {
                node = node.getRight();
            } else if (element < node.getValue() && node.hasLeft(node)) {
                node = node.getLeft();
            } else {
                return null;
            }
        }
        return null;
    }

    //interface method calls recursive method
    public List<Integer> getSortedTreeAsc() {
        return ascOrder(root);
    }

    //interface method calls recursive method
    public List<Integer> getSortedTreeDesc() {
        return descOrder(root);
    }

    //recursive access tree returning a sorted list
    private ArrayList<Integer> descOrder(Node node) {
        if (node != null) {
            descOrder(node.getRight());
            list.add(node.getValue());
            descOrder(node.getLeft());
        }
        return list;
    }

    //recursive access tree returning a sorted list
    private ArrayList<Integer> ascOrder(Node node) {
        if (node != null) {
            ascOrder(node.getLeft());
            list.add(node.getValue());
            ascOrder(node.getRight());
        }
        return list;
    }

    //returns int[] of tree sorted as it was entered into the tree
    public int[] getNonSortedTree(){
        Queue<Node> level = new LinkedList<>();
        level.add(root);
        int counter=0;
        int[] res= new int[nodeCount];
        while(!level.isEmpty()){
            Node node = level.poll();
            res[counter] = node.getValue();
            if(node.getLeft() != null){
                level.add(node.getLeft());
            }
            if(node.getRight() != null){
                level.add(node.getRight());
            }
            counter++;
        }
        return res;
    }
}