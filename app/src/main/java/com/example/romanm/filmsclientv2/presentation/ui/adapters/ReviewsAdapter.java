package com.example.romanm.filmsclientv2.presentation.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.romanm.filmsclientv2.data.source.remote.models.Reviews;

import java.util.List;

/**
 * Created by RomanM on 29.10.2017.
 */

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {

    private List<Reviews> reviews;


    @Override
    public ReviewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return LayoutInflater.from(parent.getContext()).inflate();
        return null;
    }

    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewsViewHolder extends RecyclerView.ViewHolder {
        public ReviewsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
