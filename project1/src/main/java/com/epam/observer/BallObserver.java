package com.epam.observer;

import com.epam.exceptions.SingletonException;
import com.epam.logic.Calculator;
import com.epam.model.BallObservable;
import com.epam.model.BallParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class BallObserver implements Observer<BallObservable> {
    private Map<Integer, BallParameters> ballParametersMap = new HashMap<Integer, BallParameters>();
    private final Calculator calculator;
    private static BallObserver instance;

    public BallObserver( Calculator calculator ) {
        this.calculator = calculator;
    }

    public void update( BallObservable obj ) {
        double area = calculator.squareOfTheSphere(obj.getRadius());
        double volume = calculator.volume(obj.getRadius());
        BallParameters ballParameters = new BallParameters(area, volume);
        ballParametersMap.put(obj.getID(), ballParameters);
    }

    public BallParameters getParameters( Integer ID ) {
        return ballParametersMap.get(ID);
    }

    public static void initInstance( Calculator calculator ) throws SingletonException {
        if (instance == null) {
            instance = new BallObserver(calculator);
        } else {
            throw new SingletonException("Singleton reinitialization");
        }
    }

    public static BallObserver getInstance() throws SingletonException {
        if (instance != null) {
            return instance;
        } else {
            throw new SingletonException("Singleton isn't initialixed");
        }
    }
}
