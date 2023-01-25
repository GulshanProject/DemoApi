package com.example.MovieApi.Service;


import com.example.MovieApi.Entity.Movie;
import com.example.MovieApi.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;


    //get all movies

    public List<Movie> getAllMovies(){

        List<Movie> list =(List<Movie>)this.movieRepository.findAll();
        return list;
    }


    //Adding the Movie
    public Movie addMovie(Movie m)
    {
        Movie result =movieRepository.save(m);
        return result;
    }
}
