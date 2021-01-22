package com.epam.model;

import com.epam.observer.Observable;
import com.epam.observer.Observer;
import com.epam.data.GeneratorID;

import java.util.ArrayList;
import java.util.List;

public class BallObservable extends Ball implements Observable {
    private List<Observer> observers = new ArrayList<Observer>();
    private final int ID;

    public BallObservable( Point center, double radius ) {
        super(center, radius);
        ID = GeneratorID.getInstance().generateID();
    }

    @Override
    public void setCenter( Point center ) {
        super.setCenter(center);
        notifyObservers();
    }

    @Override
    public void setRadius( double radius ) {
        super.setRadius(radius);
        notifyObservers();
    }

    public int getID() {
        return ID;
    }

    public void addObserver( Observer observer ) {
        observers.add(observer);
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
