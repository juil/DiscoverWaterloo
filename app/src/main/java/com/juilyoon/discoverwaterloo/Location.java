package com.juilyoon.discoverwaterloo;

/**
 * Created by juil on 16-07-08.
 */
public class Location {
    /** The name of the location. */
    private String name;
    /** A integer rating 1-5 */
    private int rating;
    /** Short description of location. */
    private String description;
    /** Link to location in review site. */
    private String reviewUrl;
    /** Link to Google map. */
    private String mapUrl;
    /** Drawable id of representative image. */
    private int imageResourceId;

    public Location(String name, int rating, String description, String reviewUrl, String mapUrl, int imageResourceId) {
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.reviewUrl = reviewUrl;
        this.mapUrl = mapUrl;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {

        return description;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
