package com.example.MovieApi.Controllers;


import com.example.MovieApi.Entity.Movie;
import com.example.MovieApi.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //get all movies controller

    @GetMapping("/duration")
    public ResponseEntity<List<Movie>> getMovies()
    {
        List<Movie> list = movieService.getAllMovies();
        if(list.size() <=0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(list);
    }





    // new book handler
    @PostMapping("/new-movie")
    public ResponseEntity<Movie> addMovie (@RequestBody Movie movie)
    {
        Movie m=null;

        try {
            m=this.movieService.addMovie(movie);
            System.out.println("New movie successfully added");
            return ResponseEntity.status(HttpStatus.CREATED).body(m);


        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
