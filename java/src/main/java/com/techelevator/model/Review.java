package com.techelevator.model;

public class Review
{
    private final int account_id;
    private final int rating;
    private final String review;
    private final int movie_id;

    public Review(int account_id, int rating, String review, int movie_id)
    {
        this.account_id = account_id;
        this.rating = rating;
        this.review = review;
        this.movie_id = movie_id;
    }


    public int getAccountId()
    {
        return account_id;
    }

    public int getRating()
    {
        return rating;
    }

    public String getReview()
    {
        return review;
    }

    public int getMovie_id()
    {
        return movie_id;
    }


}