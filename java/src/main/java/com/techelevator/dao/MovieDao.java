package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> filterMovies(int genres[], String[] mpaa, int[] years, int moviePerPage, int pageNumber, String sortedBy);

    //    public List<Movie> getMovies();
    public List<Movie> getGroupOfMovies(int moviePerPage, int pageNumber, String sortedBy);

    public Movie getMovieById(int id);

    public List<Movie> getMoviesByUserFavGenre(int moviePerPage, int pageNumber, String sortedBy,int[] genres_id );


    public List<Movie> getMoviesByUserFavMovies(int moviePerPage, int pageNumber, String sortedBy,int userId );

}