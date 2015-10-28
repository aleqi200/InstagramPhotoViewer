package com.aleqi200.instagramphotoviewer.data;

import com.aleqi200.instagramphotoviewer.model.Photo;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by acampelo on 10/28/15.
 */
public abstract class BaseJsonHttpResponseHandler extends JsonHttpResponseHandler {
    protected List<Photo> photos;

    public BaseJsonHttpResponseHandler(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        try {
            if (statusCode == 200) {
                if (response.has("data")) {
                    clearData();
                    JSONArray items = response.getJSONArray("data");
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject object = (JSONObject) items.get(i);
                        if (object.getString("type").equals("image") && !object.isNull("caption")) {

                            String caption = object.getJSONObject("caption").getString("text");
                            String username = object.getJSONObject("user").getString("username");
                            String profileImage = object.getJSONObject("user").getString("profile_picture");
                            String url = object.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
                            photos.add(new Photo(url, caption, username, null, null, profileImage));
                        }
                    }
                    notifyDone();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected abstract void notifyDone();

    protected abstract void clearData();

}
