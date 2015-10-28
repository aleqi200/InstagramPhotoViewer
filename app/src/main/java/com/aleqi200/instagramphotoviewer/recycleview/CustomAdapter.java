/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.aleqi200.instagramphotoviewer.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aleqi200.instagramphotoviewer.R;
import com.aleqi200.instagramphotoviewer.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Provide views to RecyclerView with data from photosArray.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Photo> photosArray;
    private Context context;

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView userNameTxtView;
        private final TextView textViewCaption;
        private final ImageView photoView;
        private final ImageView profileImage;
        private final ViewGroup viewGroup;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            userNameTxtView = (TextView) v.findViewById(R.id.txt_user_name);
            textViewCaption = (TextView) v.findViewById(R.id.txt_caption);
            photoView = (ImageView) v.findViewById(R.id.img_photo);
            profileImage = (ImageView) v.findViewById(R.id.img_profile_image);
            viewGroup = (ViewGroup) v.findViewById(R.id.list_item);
        }

        public TextView getUserNameTxtView() {
            return userNameTxtView;
        }

        public ImageView getPhotoView() {
            return photoView;
        }

        public TextView getTextViewCaption() {
            return textViewCaption;
        }

        public ImageView getProfileImage() {
            return profileImage;
        }

        public void toggleVisibility() {
            viewGroup.setVisibility(View.VISIBLE);
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(List<Photo> dataSet, Context context) {
        photosArray = dataSet;
        this.context = context;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.photo_layout, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        Photo photo = photosArray.get(position);
        Picasso.with(context).load(photo.getGraphic()).into(viewHolder.getPhotoView());
        Picasso.with(context).load(photo.getUserProfileImage()).into(viewHolder.getProfileImage());
        viewHolder.getUserNameTxtView().setText(photo.getUsername());
        viewHolder.getTextViewCaption().setText(photo.getCaption());

        viewHolder.toggleVisibility();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return photosArray.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        photosArray.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Photo> list) {
        photosArray.addAll(list);
        notifyDataSetChanged();
    }
}
