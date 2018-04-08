package com.m3c.ne;

import java.util.List;

public class Starter {

    public static void main(String[] args){
        System.out.println("Heloo");
        BinaryTree bts = new Tree(10);
        bts.addElement(8);
        bts.addElements(new int[]{1,5,9,7,6});
        List<Integer> list = bts.getSortedTreeAsc();
        for (Integer element:list){
            System.out.println(element);
        }
    }
}