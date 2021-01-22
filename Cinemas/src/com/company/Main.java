package com.company;
import com.company.logic.CinemaList;
import com.company.logic.DataException;
import com.company.logic.Reader;
import com.company.model.Cinema;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INPUT_FILENAME = "input.xml";
    public static void main(String[] args) {
	final List<Cinema> listOfCinemas = Reader.parse(INPUT_FILENAME);
        System.out.println(listOfCinemas);
        System.out.println("\n\n\n\n");
        CinemaList cinemaList = new CinemaList(new ArrayList<Cinema>());
        try{
            System.out.println(cinemaList.findCinemaWithBiggestSeatsNumber());
            System.out.println(cinemaList.findCinmeaWithNumberOfSeats(8));
            System.out.println(cinemaList.uniqueMovies());
            System.out.println(cinemaList.sortByName());
        } catch (DataException e){
            System.out.println(e.getMessage());
        }
    }


}
