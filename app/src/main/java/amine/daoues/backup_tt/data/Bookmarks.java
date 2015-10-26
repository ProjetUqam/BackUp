package amine.daoues.backup_tt.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by macbookpro on 28/09/15.
 */
@ParseClassName("Bookmarks")
public class Bookmarks extends ParseObject {
    public Integer getId(){
        return Integer.getInteger("id");
    }
    public void setId(Integer id){
        put("id",id);
    }

    public String getBookmark(){
        return getString("bookmark");
    }
    public void setBookmark(String bookmark){
        put("bookmark",bookmark);
    }

    public String getDate(){
        return getString("date");
    }
    public void setDate(String date){
        put("date",date);
    }

    public String getFavicon(){
        return getString("favicon");
    }
    public void setFavicon(String favicon){
        put("favicon",favicon);
    }

    public String getThumbnail(){
        return getString("thumbnail");
    }
    public void setThumbnail(String thumbnail){
        put("thumbnail",thumbnail);
    }

    public String getTitle(){
        return getString("title");
    }
    public void setTitle(String title){
        put("title",title);
    }

    public String getTouch_icon(){
        return getString("touch_icon");
    }
    public void setTouch_icon(String touch_icon){
        put("touch_icon",touch_icon);
    }

    public String getUrl(){
        return getString("url");
    }
    public void setUrl(String url){
        put("url",url);
    }

    public String getUser_entered(){
        return getString("user_entered");
    }
    public void setUser_entered(String user_entered){
        put("user_entered",user_entered);
    }

    public String getVisits(){
        return getString("visits");
    }
    public void setVisits(String visits){
        put("visits",visits);
    }


    public String getUser(){
        return getString("user");
    }
    public void setUser(String user){
        put("user",user);
    }

    public Bookmarks() {
    }

    public Bookmarks(String theClassName) {
        super(theClassName);
    }

    public void play() {
        // Ah, that takes me back!
    }

    public static ParseQuery<Bookmarks> getQuery() {
        return ParseQuery.getQuery(Bookmarks.class);
    }
}
