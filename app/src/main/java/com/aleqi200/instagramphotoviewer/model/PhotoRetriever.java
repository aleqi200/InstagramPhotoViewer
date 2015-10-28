package com.aleqi200.instagramphotoviewer.model;

import android.support.v4.widget.SwipeRefreshLayout;

import com.aleqi200.instagramphotoviewer.data.RefreshJsonHttpResponseHandler;
import com.aleqi200.instagramphotoviewer.data.StartupJsonHttpResponseHandler;
import com.aleqi200.instagramphotoviewer.recycleview.CustomAdapter;
import com.loopj.android.http.AsyncHttpClient;

import java.util.List;

/**
 * Created by acampelo on 10/28/15.
 */
public class PhotoRetriever {
    private static final String CLIENT_ID = "bf3c8b679500472f88dcfc696b2720dc";
    private static final String URL = "https://api.instagram.com/v1/media/popular?client_id=" + CLIENT_ID;

    public static void getRealData(final List<Photo> photos, final CustomAdapter adapter) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new StartupJsonHttpResponseHandler(photos, adapter));
    }

    public static void getRealData(CustomAdapter adapter, SwipeRefreshLayout swipeContainer) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new RefreshJsonHttpResponseHandler(adapter, swipeContainer));
    }
}
