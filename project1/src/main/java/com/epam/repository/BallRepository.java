package com.epam.repository;

import com.epam.exceptions.DataException;
import com.epam.model.BallObservable;
import com.epam.specification.BallSpecification;
import java.util.List;

public interface BallRepository {

    void save( BallObservable ball ) throws DataException;

    void remove( BallObservable ball ) throws DataException;

    List<BallObservable> query( BallSpecification ballSpecification );
}

