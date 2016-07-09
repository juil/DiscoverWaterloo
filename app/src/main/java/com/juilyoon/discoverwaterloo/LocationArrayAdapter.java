package com.juilyoon.discoverwaterloo;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juil on 16-07-08.
 */
public class LocationArrayAdapter extends ArrayAdapter<Location> {
    public LocationArrayAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Location currentLocation = getItem(position);

        // Set location image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.location_image);
        imageView.setImageResource(currentLocation.getImageResourceId());

        // Set location name
        TextView locationName = (TextView) listItemView.findViewById(R.id.location_name);
        locationName.setText(currentLocation.getName());

        // Set location rating
        TextView locationRating = (TextView) listItemView.findViewById(R.id.location_rating);
        // Display number of stars according to rating
        locationRating.setText(generateStarRating(parent.getResources().getString(R.string.star),
                                                currentLocation.getRating()));

        // Set location description
        TextView locationDescription = (TextView) listItemView.findViewById(R.id.location_description);
        locationDescription.setText(currentLocation.getDescription());

        // Set location reviews link
        TextView locationReviews = (TextView) listItemView.findViewById(R.id.location_reviews);
        locationReviews.setText(generateLink(currentLocation.getReviewUrl(), "Reviews"));

        // Set map link
        TextView locationMap = (TextView) listItemView.findViewById(R.id.location_map);
        locationMap.setText(generateLink(currentLocation.getMapUrl(), "Map"));

        // Return the whole list item layout to be shown in the ListView
        return listItemView;
    }

    private String generateStarRating(String with, int count) {
        return new String(new char[count]).replace("\0", " " + with);
    }

    private Spanned generateLink(String url, String text) {
        String link = "<a href='" + url +"'>" + text + "</a>";
        return Html.fromHtml(link);
    }
}
