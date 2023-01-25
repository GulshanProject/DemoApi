package com.example.MovieApi.Repository;

import com.example.MovieApi.Entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,String> {

    public Movie findBytconst(String tconst);
}
