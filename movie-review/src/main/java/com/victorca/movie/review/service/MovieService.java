package com.victorca.movie.review.service;

import com.victorca.movie.review.MovieReviewApplication;
import com.victorca.movie.review.model.Movie;
import com.victorca.movie.review.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
            return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
