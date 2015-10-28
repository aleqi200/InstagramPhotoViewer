package com.aleqi200.instagramphotoviewer.model;

import android.support.v4.widget.SwipeRefreshLayout;

import com.aleqi200.instagramphotoviewer.recycleview.CustomAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by acampelo on 10/20/15.
 */
public class Photo {
    private static final String CLIENT_ID = "bf3c8b679500472f88dcfc696b2720dc";
    private String graphic;
    private String caption;
    private String username;
    private Date relative;
    private Integer likeCount;
    private String userProfileImage;

    public Photo() {
    }

    public Photo(String graphic, String caption, String username, Date relative, Integer likeCount, String userProfileImage) {
        this.graphic = graphic;
        this.caption = caption;
        this.username = username;
        this.relative = relative;
        this.likeCount = likeCount;
        this.userProfileImage = userProfileImage;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRelative() {
        return relative;
    }

    public void setRelative(Date relative) {
        this.relative = relative;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public static List<Photo> getData() {
        ArrayList<Photo> photos = new ArrayList<>();
        photos.add(new Photo("http://www2.monroecounty.gov/files/parks/images/Mendon%20Ponds%20Pond%20View%20Shelter%20Summer%20.jpg",
                "Image1", "someone", null, null, null));
        photos.add(new Photo("http://www.co.chenango.ny.us/images/cook-park/slideshow/cook-park-camping-area-slideshow.jpg",
                "Image2", "another", null, null, null));
        return photos;
    }
}
