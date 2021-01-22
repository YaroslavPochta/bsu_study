package com.company;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            MyCont<String> cont = new MyCont();
            cont.add("hgjrd");
            cont.add("aaaaaaa");
            cont.add("bbnvbv");
            System.out.println(cont.min());
            System.out.println(Collections.min(cont.getList(), new CompareStringLength()));
        }
        catch( EmptyCollectionException e)
        {
            System.out.println("Empty List");
        }
    }
}