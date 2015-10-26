package amine.daoues.backup_tt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseQuery;

import java.util.List;

import amine.daoues.backup_tt.data.User;


public class LoginActivity extends Activity {

    public String info;
    //public final String API_KEY = "429324280550619";

    private String TAG = "MainActivity";
    //String URL = "http://daoues.olympe.in/pfe/www/www/tt/";
    String mail, password;
    String email, pass;
    String NumTel, name, gender,id;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //StrictMode.enableDefaults(); //STRICT MODE ENABLED

        final AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);

        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);

        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        EditText text = (EditText) findViewById(R.id.email);
        email = text.getText().toString();

        Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                preferences.saveSignUpName(email);
            }
        });



    }



    public void getData() {
        EditText text = (EditText) findViewById(R.id.email);
        email = text.getText().toString();


        EditText text1 = (EditText) findViewById(R.id.Pass);
        pass = text1.getText().toString();

        if (email == null) {
            Toast.makeText(getApplicationContext(), "Les informations que vous avez entré ne sont pas valides", Toast.LENGTH_SHORT).show();
        } else {
            ParseQuery<User> query = ParseQuery.getQuery("User");
            query.whereEqualTo("mail", email);
            query.findInBackground(new FindCallback<User>() {
                @Override
                public void done(List<User> parseObjects, com.parse.ParseException e) {
                    if (e == null) {
                        Log.d("user", "Retrieved " + parseObjects.size() + " user");
                        //signUpInfo = login;
                        //preferences.saveSignUpName(signUpInfo);
                        if (parseObjects.size() == 0) {
                            Toast.makeText(getApplicationContext(), "Les informations que vous avez entré ne sont pas valides", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }

                    } else {
                        Log.d("score", "Error: " + e.getMessage());
                    }
                }
            });
        }



        /*String result = "";
        InputStream isr = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://daoues.olympe.in/pfe/www/www/tt/login.php"); //YOUR PHP SCRIPT ADDRESS
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
            //   resultView.setText("Couldnt connect to database");
        }
        //convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            isr.close();

            result = sb.toString();
        } catch (Exception e) {
            Log.e("log_tag", "Error  converting result " + e.toString());
        }

        //parse json data
        try {


            JSONArray jArray = new JSONArray(result);


            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                mail = json.getString("Email");
                password = json.getString("Pass");
                NumTel = json.getString("NumTel");
                name = json.getString("Name");
                gender = json.getString("Gender");
                id = json.getString("id");

                Log.e("mail", "" + id);


                if ((mail.equals(email)) && (password.equals(pass))) {



                    Log.e("melek", "melek" + mail);
                    Log.e("melek", "melek" + pass);



                    Intent intent = new Intent(LoginActivity.this,
                            com.BackupAndRestore.MainActivity.class);
                    startActivity(intent);

                }


            }
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data " + e.toString());
        }*/
    }

}
