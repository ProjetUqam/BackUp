package amine.daoues.backup_tt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseObject;

/**
 * Created by Daoues on 08/09/2015.
 */
public class CheckEntryActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_entry);

        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/

        AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);
        if (preferences.hasSignUpInformation()) {
        gotoMainActivity();
        } else {
        gotoSignUpActivity();
        }
        finish();
        }
private void gotoMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        }
private void gotoSignUpActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        }
}
