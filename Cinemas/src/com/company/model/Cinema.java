package com.company.model;

import java.util.List;

public class Cinema {
    private String name;
    private int numberOfSeats;
    private List<String> movies;

    public Cinema( String name, int numberOfSeats, List<String> movies ) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public List<String> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cinema{");
        sb.append("name='").append(name).append('\'');
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", movies=").append(movies);
        sb.append('}');
        return sb.toString();
    }
}
