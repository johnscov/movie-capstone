package com.techelevator.controller;

import com.techelevator.dao.MovieDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.FilterDto;
import com.techelevator.model.Review;
import com.techelevator.model.ReviewDto;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    private ReviewDao reviewDao;
    private UserDao userDao;

    public ReviewController(ReviewDao reviewDao, UserDao userDao) {
        this.reviewDao = reviewDao;
        this.userDao =  userDao;
    }


    @GetMapping( "/reviews/{movie_id}")
    public List<Review> getReviewsByMovieId(@PathVariable int movie_id){
try{
        return reviewDao.getReviewsByMovieId(movie_id);
    }
        catch (
    DaoException e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "retrieving movies failed failed.");
    }
    }

    @PostMapping("/reviews")
    public boolean createReview(@RequestBody ReviewDto reviewDto, Principal principal){
        System.out.println(reviewDto.getMovie_id());
        System.out.println(reviewDto.getRating());
        System.out.println(reviewDto.getReview());
        User user = userDao.getUserByUsername(principal.getName());

        try{
            return reviewDao.createReview(user.getId(), reviewDto.getRating(), reviewDto.getReview(), reviewDto.getMovie_id());
        }
        catch (
                DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "retrieving movies failed failed.");
        }

//        return false;
    }
}