package amine.daoues.backup_tt;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import amine.daoues.backup_tt.data.Bookmarks;
import amine.daoues.backup_tt.data.Call;
import amine.daoues.backup_tt.data.Sms;
import amine.daoues.backup_tt.data.User;

/**
 * Created by Daoues on 15/09/2015.
 */
public class BackUpTTApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Y01sLeGPNVCaSov4Yr7nR76zRp7HWf6yDtTBFVHS", "ZHzNTE8Xc0fEBs0P4XiEij1cUp1S9b9AbzelWiOi");

        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
        ParseUser.enableAutomaticUser();


        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Sms.class);
        ParseObject.registerSubclass(Bookmarks.class);
        ParseObject.registerSubclass(Call.class);

        // Enable Local Datastore.
        /*Parse.enableLocalDatastore(this);
        Parse.initialize(this, "BN7DKl6kUxwpbKcB7E5s9136bt7hezeaFv1lfS7J", "YPd2MzbpCimsYkpDc3C79VkSSSp7DGVqkIz4Hvpa");
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        ParseObject.registerSubclass(Doctor.class);
        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Mesure.class);
        ParseObject.registerSubclass(Traitement.class);
        ParseObject.registerSubclass(Remarque.class);*/
    }
}
