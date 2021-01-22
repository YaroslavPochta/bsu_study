package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

public class MyCont<T extends  Comparable<T>>{

    private List<T> list;
// read from file
    // use standard algorithm as you can
    // clone()
    // Вывод в особом порядке (clone() -> sort() -> out())
    // Иерархия пользовательских типов
    // Поиск - contains() или clone() -> binarySearch()
    // Контейнер можно наследовать от ArrayList
    // Метод вывода - это не toString(). toString() возвращает только строку !!!
    MyCont() {
        this.list = new ArrayList<T>();
    }

    public MyCont(List<T> list) {
        this.list = list;
    }

    public void add(T obj) {
        list.add(obj);
    }

    public List<T> getList() {
        return list;
    }

    public String toString() {
        return list.toString();
    }

    public T min() throws EmptyCollectionException {
        if(list.isEmpty()) throw new EmptyCollectionException();
        return Collections.min(list);
    }


    // Min length string


}

