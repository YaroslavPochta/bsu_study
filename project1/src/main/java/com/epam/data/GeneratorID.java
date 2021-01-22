package com.epam.data;

public final class GeneratorID {
    private int ID;
    private static GeneratorID instance;


    private static void initInstance() {
        instance = new GeneratorID();
    }

    public static GeneratorID getInstance() {
        if (instance == null) {
            initInstance();
        }
        return instance;
    }


    private GeneratorID() {
        ID = 0;
    }

    public int generateID() {
        return ID++;
    }
}
