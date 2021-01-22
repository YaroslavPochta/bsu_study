package com.company;

import com.company.model.Plant;

import java.util.ArrayList;
import java.util.List;

public class Greenhouse {
    private List<Plant> plantsList = new ArrayList<>();

    public Greenhouse( List<Plant> plantsList ) {
        this.plantsList = plantsList;
    }

    public void add(Plant plant){
        plantsList.add(plant);
    }

}
