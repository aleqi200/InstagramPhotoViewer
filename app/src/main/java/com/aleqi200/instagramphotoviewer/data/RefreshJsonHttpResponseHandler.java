package com.aleqi200.instagramphotoviewer.data;

import android.support.v4.widget.SwipeRefreshLayout;

import com.aleqi200.instagramphotoviewer.model.Photo;
import com.aleqi200.instagramphotoviewer.recycleview.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acampelo on 10/28/15.
 */
public class RefreshJsonHttpResponseHandler extends BaseJsonHttpResponseHandler {
    private final CustomAdapter adapter;
    private final SwipeRefreshLayout swipeContainer;

    public RefreshJsonHttpResponseHandler(final CustomAdapter adapter, SwipeRefreshLayout swipeContainer) {
        super(new ArrayList<Photo>());
        this.adapter = adapter;
        this.swipeContainer = swipeContainer;
    }

    @Override
    protected void notifyDone() {

        adapter.clear();
        // ...the data has come back, add new items to your adapter...
        adapter.addAll(photos);
        // Now we call setRefreshing(false) to signal refresh has finished
        swipeContainer.setRefreshing(false);
    }

    @Override
    protected void clearData() {
        photos.clear();
    }
}
