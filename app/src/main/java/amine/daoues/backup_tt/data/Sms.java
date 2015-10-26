package amine.daoues.backup_tt.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Daoues on 15/09/2015.
 */

@ParseClassName("Sms")
public class Sms extends ParseObject {
    public Integer getId(){
        return Integer.getInteger("id");
    }
    public void setId(Integer id){
        put("id",id);
    }

    public String getAddress(){
        return getString("address");
    }
    public void setAddress(String address){
        put("address",address);
    }

    public String getDate(){
        return getString("date");
    }
    public void setDate(String date){
        put("date",date);
    }

    public String getType(){
        return getString("type");
    }
    public void setType(String type){
        put("type",type);
    }

    public String getContent(){
        return getString("content");
    }
    public void setContent(String content){
        put("content",content);
    }

    public String getUser(){
        return getString("user");
    }
    public void setUser(String user){
        put("user",user);
    }

    public Sms() {
    }

    public Sms(String theClassName) {
        super(theClassName);
    }

    public void play() {
        // Ah, that takes me back!
    }

    public static ParseQuery<Sms> getQuery() {
        return ParseQuery.getQuery(Sms.class);
    }
}
