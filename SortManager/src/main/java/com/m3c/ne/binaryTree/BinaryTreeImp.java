package com.m3c.ne.binaryTree;

import com.m3c.ne.display.DisplayManager;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImp implements BinaryTree {

    private int nodeCount = 0;
    private ArrayList<Integer> list = new ArrayList<>();
    private Node root;
    private DisplayManager disMan = new DisplayManager();

    public BinaryTreeImp(int value) {
        this.root = new Node(value);
    }

    public BinaryTreeImp(int[] values) {
        this.root = new Node(values[0]);
        if (values.length > 1){
            for (int i=1;i<values.length;i++) {
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

    public void addElement(int element) {
            insertElement(root, element);
    }

    private void insertElement(Node node, int element) {
        if (element > node.getValue() && node.hasRight(node)) {
            insertElement(node.getRight(), element);
        } else if (element > node.getValue()) {
            node.setRight(element);
            nodeCount++;
        } else if (element < node.getValue() && node.hasLeft(node)) {
            insertElement(node.getLeft(), element);
        } else {
            node.setLeft(element);
            nodeCount++;
        }
    }

    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    public boolean findElement(int value) {
        return lookUp(root, value);
    }

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

    public int getLeftChild(int element) throws ElementNotFoundException {
        Node leftParent = getChild(root,element);
        if (leftParent.getLeft() == null){
            disMan.binaryTreeNoChild("right");
            return 0;
        }else {
            return leftParent.getRight().getValue();
        }
    }

    public int getRightChild(int element) throws ElementNotFoundException {
        Node rightParent = getChild(root,element);
        if (rightParent.getRight() == null){
             disMan.binaryTreeNoChild("right");
             return 0;
        }else {
            return rightParent.getRight().getValue();
        }
    }

    private Node getChild(Node node, int element){
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

    public List<Integer> getSortedTreeAsc() {
        return ascOrder(root);
    }

    public List<Integer> getSortedTreeDesc() {
        return descOrder(root);
    }

    private ArrayList<Integer> descOrder(Node node){
        if (node!= null) {
            descOrder(node.getRight());
            list.add(node.getValue());
            descOrder(node.getLeft());
        }
        return list;
    }

    private ArrayList<Integer> ascOrder(Node node){
        if (node!= null) {
            ascOrder(node.getLeft());
            list.add(node.getValue());
            ascOrder(node.getRight());
        }
        return list;
    }
}