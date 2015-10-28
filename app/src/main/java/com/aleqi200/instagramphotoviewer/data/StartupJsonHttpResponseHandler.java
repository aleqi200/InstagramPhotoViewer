package com.aleqi200.instagramphotoviewer.data;

import com.aleqi200.instagramphotoviewer.model.Photo;
import com.aleqi200.instagramphotoviewer.recycleview.CustomAdapter;

import java.util.List;

/**
 * Created by acampelo on 10/28/15.
 */
public class StartupJsonHttpResponseHandler extends BaseJsonHttpResponseHandler {
    private final CustomAdapter adapter;

    public StartupJsonHttpResponseHandler(List<Photo> photos, final CustomAdapter adapter) {
        super(photos);
        this.adapter = adapter;
    }

    @Override
    protected void notifyDone() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void clearData() {
        //do nothing on startup
    }
}
