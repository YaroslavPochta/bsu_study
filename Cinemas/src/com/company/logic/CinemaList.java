package com.company.logic;

import com.company.model.Cinema;

import java.util.*;

public class CinemaList {
    private List<Cinema> cinemaList;

    public CinemaList( List<Cinema> cinemaList ) {
        this.cinemaList = cinemaList;
    }

    public List<Cinema> sortByName() {
        List<Cinema> cloneList = new ArrayList<>(cinemaList);
        Collections.sort(cloneList, new Comparator<Cinema>() {
            @Override
            public int compare( Cinema o1, Cinema o2 ) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return cloneList;
    }

    public Set<String> uniqueMovies() throws DataException {
        if (cinemaList.size() == 0) {
            throw new DataException("Empty list");
        }
        Set<String> uniqueMovies = new HashSet<>();
        for (Cinema cinema : cinemaList) {
            uniqueMovies.addAll(cinema.getMovies());
        }
        return uniqueMovies;

    }

    private List<Cinema> sortByNumberOfSeats(){
        List<Cinema> cloneList = new ArrayList<>(cinemaList);
        Collections.sort(cloneList, new Comparator<Cinema>() {
            @Override
            public int compare( Cinema o1, Cinema o2 ) {
                return - (o1.getNumberOfSeats() - o2.getNumberOfSeats());
            }
        });
        return cloneList;
    }

    public Cinema findCinemaWithBiggestSeatsNumber() throws DataException {
        if (cinemaList.size() == 0) {
            throw new DataException("Empty list");
        }
        List<Cinema> cloneList = new ArrayList<>(cinemaList);
        return sortByNumberOfSeats().get(0);
    }

    public Cinema findCinmeaWithNumberOfSeats(int number) throws DataException {
        if (cinemaList.size() == 0) {
            throw new DataException("Empty list");
        }
        List<Cinema> cloneList = sortByNumberOfSeats();
        Cinema requiredCinema = new Cinema("anyname", number, null);
        return cloneList.get(Collections.binarySearch(cloneList, requiredCinema , new Comparator<Cinema>() {
            @Override
            public int compare(Cinema o1, Cinema o2 ) {
                return o1.getNumberOfSeats() - o2.getNumberOfSeats();
            }
        }));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CinemaList{\n");
        for (Cinema cinema : cinemaList) {
            sb.append(cinema).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }
}

