package amine.daoues.backup_tt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.SaveCallback;

import java.util.regex.Pattern;

import amine.daoues.backup_tt.data.User;

public class RegisterActivity extends Activity {
    private String emailAddress;
    String URL;
    private Spinner spinner1;

    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);

        final AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Switching to Login Screen/closing register screen
                finish();
            }
        });



        Button button = (Button) findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText TF = (EditText) findViewById(R.id.reg_email);

                String email = TF.getText().toString();

                EditText PS = (EditText) findViewById(R.id.reg_password);
                String pass = PS.getText().toString();

                EditText FN = (EditText) findViewById(R.id.reg_fullname);
                String fn = FN.getText().toString();

                if(fn.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid Name", Toast.LENGTH_SHORT).show();
                } else if (!checkEmail(email)) {

                    Toast.makeText(getApplicationContext(), "Invalid Email Addresss", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                }else {

                    setData();
                    preferences.saveSignUpName(email);
                    Intent intent = new Intent(RegisterActivity.this,
                            LoginActivity.class);
                    startActivity(intent);


                }

            }


        });
    }
    private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }
    public void setData(){

        EditText text = (EditText)findViewById(R.id.reg_fullname);
        String name = text.getText().toString();
        EditText text0 = (EditText)findViewById(R.id.reg_prenom);
        String prenom = text0.getText().toString();
        EditText text01 = (EditText)findViewById(R.id.reg_numtel);
        String numtel = text01.getText().toString();
        EditText text1 = (EditText)findViewById(R.id.reg_email);
        String email = text1.getText().toString();
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        String Gender =  String.valueOf(spinner1.getSelectedItem());
        EditText text3 = (EditText)findViewById(R.id.reg_password);
        String pass = text3.getText().toString();

        final User newUser = new User("User");
        newUser.setFirstName(name);
        newUser.setLastName(prenom);
        newUser.setNumTel(numtel);
        newUser.setMail(email);
        newUser.setGender(Gender);
        newUser.setPassword(pass);
        newUser.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                newUser.play();
            }
        });
        //preferences.saveSignUpName(firstName.getText().toString());
        Toast.makeText(RegisterActivity.this, "Welcome " + name, Toast.LENGTH_SHORT).show();


       /* HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://daoues.olympe.in/pfe/www/www/tt/register.php");


        try {

            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);


            EditText text = (EditText)findViewById(R.id.reg_fullname);
            String name = text.getText().toString();
            nameValuePairs.add(new BasicNameValuePair("Name", name));

            EditText text0 = (EditText)findViewById(R.id.reg_prenom);
            String prenom = text0.getText().toString();
            nameValuePairs.add(new BasicNameValuePair("Prenom", prenom));


            EditText text01 = (EditText)findViewById(R.id.reg_numtel);
            String numtel = text01.getText().toString();
            nameValuePairs.add(new BasicNameValuePair("NumTel", numtel));

            EditText text1 = (EditText)findViewById(R.id.reg_email);
            String email = text1.getText().toString();
            nameValuePairs.add(new BasicNameValuePair("Email", email));


            spinner1 = (Spinner) findViewById(R.id.spinner1);

            nameValuePairs.add(new BasicNameValuePair("Gender", String.valueOf(spinner1.getSelectedItem())));


            EditText text3 = (EditText)findViewById(R.id.reg_password);
            String pass = text3.getText().toString();
            nameValuePairs.add(new BasicNameValuePair("Pass", pass));



            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs , HTTP.UTF_8));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);


        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }*/
    }


}