package com.company.parser;

import com.company.model.Plant;

import java.util.List;

public interface Parser {
    List<Plant> parse(String filename);
}
