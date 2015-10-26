package amine.daoues.backup_tt.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by macbookpro on 28/09/15.
 */
@ParseClassName("Call")
public class Call extends ParseObject {
    public Integer getId(){
        return Integer.getInteger("id");
    }
    public void setId(Integer id){
        put("id",id);
    }

    public String getDate(){
        return getString("date");
    }
    public void setDate(String date){
        put("date",date);
    }

    public String getDuration(){
        return getString("duration");
    }
    public void setDuration(String duration){
        put("duration",duration);
    }

    public String getName(){
        return getString("name");
    }
    public void setName(String name){
        put("name",name);
    }

    public String getNeww(){
        return getString("neww");
    }
    public void setNeww(String neww){
        put("neww",neww);
    }

    public String getNumber(){
        return getString("number");
    }
    public void setNumber(String number){
        put("number",number);
    }

    public String getType(){
        return getString("type");
    }
    public void setType(String type){
        put("type",type);
    }

    public String getUser(){
        return getString("user");
    }
    public void setUser(String user){
        put("user",user);
    }

    public Call() {
    }

    public Call(String theClassName) {
        super(theClassName);
    }

    public void play() {
        // Ah, that takes me back!
    }

    public static ParseQuery<Call> getQuery() {
        return ParseQuery.getQuery(Call.class);
    }
}
