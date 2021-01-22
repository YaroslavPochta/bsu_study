package com.company.model;

public abstract class Plant {
    private final String name;
    private final SoilType soilType;
    private final Origin origin;

    public Plant( String name, SoilType soilType, Origin origin ) {
        this.name = name;
        this.soilType = soilType;
        this.origin = origin;
    }

    public SoilType getSoilType() {
        return soilType;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getName() {
        return name;
    }
}
