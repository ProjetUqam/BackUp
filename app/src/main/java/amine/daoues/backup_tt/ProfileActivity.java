package amine.daoues.backup_tt;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.ByteArrayOutputStream;
import java.util.List;

import amine.daoues.backup_tt.data.User;

/**
 * Created by macbookpro on 02/10/15.
 */
public class ProfileActivity extends Activity {
    private static int RESULT_LOAD_IMG = 1;
    private ProgressDialog progressDialog;
    String imgDecodableString;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        final AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);
        user = preferences.getSignUpName();
        //F
        progressDialog = ProgressDialog.show(ProfileActivity.this, "",
                "Downloading Image...", true);
        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>(
                "ImageUpload");
        query1.whereEqualTo("UserId", user);
        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    for (ParseObject object : parseObjects) {
                        ParseFile fileObject = (ParseFile) object.get("ImageFile");
                        fileObject.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] data, ParseException e) {
                                if (e == null) {
                                    Log.d("Profile", "We've got data in data.");
                                    // Decode the Byte[] into Bitmap
                                    Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                                    ImageView image = (ImageView) findViewById(R.id.imageView_round);
                                    image.setImageBitmap(bmp);
                                    progressDialog.dismiss();
                                }
                            }
                        });
                    }
                } else {
                    // something went wrong
                    Toast.makeText(ProfileActivity.this, "problème de connexion", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Faten
        ParseQuery<User> query2 = ParseQuery.getQuery("User");
        query2.whereEqualTo("mail", user);
        query2.findInBackground(new FindCallback<User>() {
            //@Override
            public void done(List<User> users, ParseException e) {
                if (e == null) {
                    Toast.makeText(ProfileActivity.this, "Welcome" + user, Toast.LENGTH_SHORT).show();
                    for (User i : users){
                        TextView nomTextView = (TextView)findViewById(R.id.NomTextView);
                        nomTextView.setText(i.getFirstName());
                        TextView prenomTextView = (TextView)findViewById(R.id.PrenomTextView);
                        prenomTextView.setText(i.getLastName());
                        TextView mailTextView = (TextView)findViewById(R.id.MailTextView);
                        mailTextView.setText(i.getMail());
                        TextView numTextView = (TextView)findViewById(R.id.NumTextView);
                        numTextView.setText(i.getNumTel());
                    }
                } else {
                    // something went wrong
                    Toast.makeText(ProfileActivity.this, "problème de connexion", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //

        //Bouton Modifier
        Button modifier = (Button)findViewById(R.id.btnModifier);
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Visibility GONE
                TextView nom = (TextView)findViewById(R.id.NomTextView);
                nom.setVisibility(View.GONE);
                TextView prenom = (TextView)findViewById(R.id.PrenomTextView);
                prenom.setVisibility(View.GONE);
                TextView mail = (TextView)findViewById(R.id.MailTextView);
                mail.setVisibility(View.GONE);
                TextView num = (TextView)findViewById(R.id.NumTextView);
                num.setVisibility(View.GONE);
                Button btnModifier = (Button)findViewById(R.id.btnModifier);
                btnModifier.setVisibility(View.GONE);
                //SET VISIBLE
                EditText Enom = (EditText)findViewById(R.id.NomEditText);
                Enom.setVisibility(View.VISIBLE);
                EditText Eprenom = (EditText)findViewById(R.id.PrenomEditText);
                Eprenom.setVisibility(View.VISIBLE);
                EditText Email = (EditText)findViewById(R.id.MailEditText);
                Email.setVisibility(View.VISIBLE);
                EditText Enum = (EditText)findViewById(R.id.NumEditText);
                Enum.setVisibility(View.VISIBLE);
                Button btnValider = (Button)findViewById(R.id.btnValider);
                btnValider.setVisibility(View.VISIBLE);
                //Get text from EditTexts
                btnValider.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText Enom = (EditText)findViewById(R.id.NomEditText);
                        final String Snom = Enom.getText().toString();
                        EditText Eprenom = (EditText)findViewById(R.id.PrenomEditText);
                        final String Sprenom = Eprenom.getText().toString();
                        EditText Email = (EditText)findViewById(R.id.MailEditText);
                        final String Smail = Email.getText().toString();
                        EditText Enum = (EditText)findViewById(R.id.NumEditText);
                        final String Snum =  Enum.getText().toString();
                        //Update ParseObject
                        ParseQuery<User> query = new ParseQuery<User>(
                                "User");
                        query.whereEqualTo("mail", user);
                        query.findInBackground(new FindCallback<User>() {
                            @Override
                            public void done(List<User> parseObjects, com.parse.ParseException e) {
                                if (e == null) {
                                    for (User i : parseObjects) {
                                        i.put("firstName", Snom);
                                        i.put("lastName", Sprenom);
                                        i.put("mail", Smail);
                                        i.put("numTel", Snum);
                                        i.saveInBackground();
                                    }
                                } else {
                                    Log.d("score", "Error: " + e.getMessage());
                                }
                            }
                        });

                        //SET VISIBILITY GONE
                        Enom.setVisibility(View.GONE);
                        Eprenom.setVisibility(View.GONE);
                        Email.setVisibility(View.GONE);
                        Enum.setVisibility(View.GONE);
                        Button btnValider = (Button)findViewById(R.id.btnValider);
                        btnValider.setVisibility(View.GONE);
                        //SET VISIBILE
                        TextView nom = (TextView)findViewById(R.id.NomTextView);
                        nom.setVisibility(View.VISIBLE);
                        TextView prenom = (TextView)findViewById(R.id.PrenomTextView);
                        prenom.setVisibility(View.VISIBLE);
                        TextView mail = (TextView)findViewById(R.id.MailTextView);
                        mail.setVisibility(View.VISIBLE);
                        TextView num = (TextView)findViewById(R.id.NumTextView);
                        num.setVisibility(View.VISIBLE);
                        Button btnModifier = (Button)findViewById(R.id.btnModifier);
                        btnModifier.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.imageView_round);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

                ////////////////Delete old
                ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>(
                        "ImageUpload");
                query1.whereEqualTo("UserId", user);
                query1.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> parseObjects, ParseException e) {
                        if (e == null) {
                            for (ParseObject object : parseObjects) {
                                object.deleteInBackground();
                            }
                        } else {
                            // something went wrong
                            Toast.makeText(ProfileActivity.this, "pas d'image", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



                /////////////SavetoParse

                // Locate the image in res > drawable-hdpi
                Bitmap bitmap = ((BitmapDrawable)imgView.getDrawable()).getBitmap();
                // Convert it to byte
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                // Compress image to lower quality scale 1 - 100
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] image = stream.toByteArray();

                // Create the ParseFile
                ParseFile file = new ParseFile("profile.png", image);
                // Upload the image into Parse Cloud
                file.saveInBackground();

                // Create a New Class called "ImageUpload" in Parse
                ParseObject ImageUpload = new ParseObject("ImageUpload");

                // Create a column named "ImageName" and set the string
                ImageUpload.put("ImageName", "Profile Picture");

                // Create a column named "ImageFile" and insert the image
                ImageUpload.put("ImageFile", file);

                //Create a column named "UserId"
                ImageUpload.put("UserId", user);

                // Create the class and the columns
                ImageUpload.saveInBackground();

                // Show a simple toast message
                Toast.makeText(ProfileActivity.this, "Image Uploaded",
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }
}
