package com.epam.specification;

import com.epam.model.BallObservable;

public class IDSpecification implements BallSpecification {
    private final int ID;

    public IDSpecification( int ID ) {
        this.ID = ID;
    }

    @Override
    public boolean check( BallObservable ballObservable ) {
        return ( ( ID - ballObservable.getID() ) == 0 );
    }
}
