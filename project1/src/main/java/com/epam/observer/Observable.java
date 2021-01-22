package com.epam.observer;

import com.epam.model.Ball;

public interface Observable<T extends Ball> {
    void addObserver( Observer<T> obs );
}
