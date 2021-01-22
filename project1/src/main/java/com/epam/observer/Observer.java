package com.epam.observer;

import com.epam.model.Ball;

public interface Observer<T extends Ball> {
    void update( T obj );
}
