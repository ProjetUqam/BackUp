package amine.daoues.backup_tt.data;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Daoues on 15/09/2015.
 */

@ParseClassName("User")
public class User extends ParseObject {
    public Integer getId(){
        return Integer.getInteger("id");
    }
    public void setId(Integer id){
        put("id",id);
    }
    public String getFirstName(){
        return getString("firstName");
    }
    public void setFirstName(String firstName){
        put("firstName",firstName);
    }
    public String getLastName(){
        return getString("lastName");
    }
    public void setLastName(String lastName){
        put("lastName",lastName);
    }
    public String getNumTel(){
        return getString("numTel");
    }
    public void setNumTel(String numTel){
        put("numTel",numTel);
    }
    public String getGender(){
        return getString("gender");
    }
    public void setGender(String gender){
        put("gender",gender);
    }
    public String getMail(){
        return getString("mail");
    }
    public void setMail(String mail){
        put("mail",mail);
    }
    public String getPassword(){
        return getString("password");
    }
    public void setPassword(String password){
        put("password",password);
    }
    public ParseFile getPhotoFile() {
        return getParseFile("photo");
    }

    public void setPhotoFile(ParseFile file) {
        put("photo", file);
    }
    public User() {
    }
    public User(String theClassName) {
        super(theClassName);
    }
    public void play() {
        // Ah, that takes me back!
    }
    public static ParseQuery<User> getQuery() {
        return ParseQuery.getQuery(User.class);
    }
}
