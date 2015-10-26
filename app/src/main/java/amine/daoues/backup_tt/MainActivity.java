package amine.daoues.backup_tt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;


public class MainActivity extends ActionBarActivity
{
  Button btnBookmarksBackup;
  Button btnAppBackup;
  Button btnCallLogsBackup;
  Button btnContactBackup;
  Button btnSMSBackup;
  Button  btnImagesBackup;
  Button ibSettings;
  LinearLayout llStorageBar;
  //TextView topText;
  TextView tvFreeSpace;
  TextView tvUsedSpace;
  View vProgress;
  private ImageView imageViewRound;

  ShareActionProvider mShareActionProvider;
  String TITLES[] = {"Accueil","Profile","A propos","Deconnection"};
  int ICONS[] = {R.drawable.home,R.drawable.cloud,R.drawable.about,R.drawable.logout};
  private Toolbar toolbar;
  RecyclerView mRecyclerView;
  RecyclerView.Adapter mAdapter;
  RecyclerView.LayoutManager mLayoutManager;
  DrawerLayout Drawer;
  String NAME = "Faten Belarbi";
  String EMAIL = "faten.belarbi@esprit.tn";
  //getString(R.string.mail);
  int PROFILE = R.drawable.amin;
    //= R.drawable.test;
    String user;

  ActionBarDrawerToggle mDrawerToggle;

  //final AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);

  public int barWidth(double paramDouble1, double paramDouble2, int paramInt)
  {
    return (int)(100.0D * (paramDouble2 / (paramDouble1 + paramDouble2)) * paramInt / 100.0D);
  }

  public void crateStorateDicretories()
  {
    File localFile1 = new File(Environment.getExternalStorageDirectory() + File.separator + "smsContactsBackups" + File.separator + "sms");
    File localFile2 = new File(Environment.getExternalStorageDirectory() + File.separator + "smsContactsBackups" + File.separator + "contacts");
    File localFile3 = new File(Environment.getExternalStorageDirectory() + File.separator + "smsContactsBackups" + File.separator + "callLogs");
    File localFile4 = new File(Environment.getExternalStorageDirectory() + File.separator + "smsContactsBackups" + File.separator + "App");
    File localFile5 = new File(Environment.getExternalStorageDirectory() + File.separator + "smsContactsBackups" + File.separator + "bookmarks");
    Log.d("sms path is", localFile1.getAbsolutePath());
    if (!localFile1.exists())
      localFile1.mkdirs();
    if (!localFile2.exists())
      localFile2.mkdirs();
    if (!localFile3.exists())
      localFile3.mkdirs();
    if (!localFile4.exists())
      localFile4.mkdirs();
    if (!localFile5.exists())
      localFile5.mkdirs();
  }

  public double discSpace(String paramString)
  {
	  StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
	  int Free  = (stat.getAvailableBlocks() * stat.getBlockSize()) / 1048576;
	  return Free;
  }
  public double discSpace1(String paramString)
  {
  StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());        
  int Total = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
  return Total;
  }
  public void intitViews()
  {

    this.tvUsedSpace = ((TextView)findViewById(R.id.tvUsedSpace));
    this.tvFreeSpace = ((TextView)findViewById(R.id.tvFreeSpace));
    this.btnSMSBackup = ((Button)findViewById(R.id.btnSMSBackup));
    this.btnBookmarksBackup = ((Button)findViewById(R.id.btnBookmarksBackup));
    this.btnAppBackup  = ((Button)findViewById(R.id.btnappBackup));
    this.btnCallLogsBackup = ((Button)findViewById(R.id.btnCallLogsBackup));
    this.btnContactBackup = ((Button)findViewById(R.id.btnContactsBackup));
    this.btnImagesBackup = ((Button)findViewById(R.id.btnImageBackup));
    this.llStorageBar = ((LinearLayout)findViewById(R.id.llStorageBar));
    this.ibSettings = ((Button)findViewById(R.id.ibSettings));
    //this.topText = ((TextView)findViewById(R.id.toptext));
    //Typeface localTypeface = Typeface.createFromAsset(getAssets(), "nexalight.otf");
    //this.topText.setTypeface(localTypeface);
    
    this.btnSMSBackup.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.startActivity(new Intent(MainActivity.this, SmsBackupActivity.class));


		}
	});
    this.btnBookmarksBackup.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.startActivity(new Intent(MainActivity.this, BookMarksActivity.class));
				}
	});
    this.btnAppBackup.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.startActivity(new Intent(MainActivity.this, AppMainActivity.class));
		}
	});
    this.btnCallLogsBackup.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.startActivity(new Intent(MainActivity.this, CallLogsActivity.class));
        }
	});
    this.btnContactBackup.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.startActivity(new Intent(MainActivity.this, ContactsActivity.class));
				}
	});
    this.btnImagesBackup.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            MainActivity.this.startActivity(new Intent(MainActivity.this, ImagesActivity.class));
        }
    });

//    this.tvUsedSpace.setTypeface(localTypeface);
//    this.tvFreeSpace.setTypeface(localTypeface);
//    this.btnSMSBackup.setTypeface(localTypeface);
//    this.btnBookmarksBackup.setTypeface(localTypeface);
//    this.btnAppBackup.setTypeface(localTypeface);
//    this.btnCallLogsBackup.setTypeface(localTypeface);
//    this.btnContactBackup.setTypeface(localTypeface);
  }

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);
    user = preferences.getSignUpName();

    imageViewRound=(ImageView)findViewById(R.id.imageView_round);
    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
    imageViewRound.setImageBitmap(icon);


      //Faten Get image for the drawer
//      ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>(
//              "ImageUpload");
//      query1.whereEqualTo("UserId", user);
//      query1.findInBackground(new FindCallback<ParseObject>() {
//          @Override
//          public void done(List<ParseObject> parseObjects, ParseException e) {
//              if (e == null) {
//                  for (ParseObject object : parseObjects) {
//                      ParseFile fileObject = (ParseFile) object.get("ImageFile");
//
//                      fileObject.getDataInBackground(new GetDataCallback() {
//                          @Override
//                          public void done(byte[] data, ParseException e) {
//                              if (e == null) {
//                                  Log.d("Profile", "We've got data in data.");
//                                  // Decode the Byte[] into Bitmap
//                                  Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
//
//                                  //ImageView image = (ImageView) findViewById(R.id.imageView_round);
//                                  //image.setImageBitmap(bmp);
//                                  Drawable drawable = new BitmapDrawable(getResources(), bmp);
//                                  //String name = getResources().getResourceEntryName(drawable);
//                                  //int temp = getResources().getIdentifier(name , "drawable", getPackageName());
//                                  PROFILE = bmp;
//                                  //mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE,this);
//                                  //mRecyclerView.setAdapter(mAdapter);
//                              }
//                          }
//                      });
//                  }
//              } else {
//                  // something went wrong
//                  //PROFILE = R.drawable.test;
//                  Toast.makeText(MainActivity.this, "pas d'image", Toast.LENGTH_SHORT).show();
//              }
//          }
//      });
//

    /*((ImageView)findViewById(R.id.imageView_sms)).setOnTouchListener(new View.OnTouchListener() {

      @Override
      public boolean onTouch(View v, MotionEvent event) {
        return false;
      }
    });*/

    //btnSMSBackup.setBackgroundResource(R.drawable.sms);

    drawer();

    intitViews();
    double d1 = discSpace(getString(R.string.free));
    double d2 = discSpace1(getString(R.string.used));
    this.llStorageBar.measure(0, 0);
    
    if (Utils.isSDcardPresent())
    {
      this.tvFreeSpace.setText(Html.fromHtml("<font color='#ffffff'>" + getString(R.string.free) + ":</font>" + Math.round(d1 * 100.0D) / 100.0D + " GB"));
      this.tvUsedSpace.setText(Html.fromHtml("<font color='#ffffff'>" + getString(R.string.storage_used) + ":</font>" + Math.round(d2 * 100.0D) / 100.0D + " GB"));
    }
    this.vProgress = findViewById(R.id.vProgress);
    this.llStorageBar.removeAllViews();
    this.llStorageBar.addView(this.vProgress, new ViewGroup.LayoutParams(barWidth(d1, d2, this.llStorageBar.getMeasuredWidth()), 30));
    crateStorateDicretories();
    
   }

  private void drawer() {
    toolbar = (Toolbar) findViewById(R.id.tool_bar);
    setSupportActionBar(toolbar);

    mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
    mRecyclerView.setHasFixedSize(true);
      //Faten:Get the photo
//      ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>(
//              "ImageUpload");
//      query1.whereEqualTo("UserId", user);
//      query1.findInBackground(new FindCallback<ParseObject>() {
//          @Override
//          public void done(List<ParseObject> parseObjects, ParseException e) {
//              if (e == null) {
//                  for (ParseObject object : parseObjects) {
//                      ParseFile fileObject = (ParseFile) object.get("ImageFile");
//
//                      fileObject.getDataInBackground(new GetDataCallback() {
//                          @Override
//                          public void done(byte[] data, ParseException e) {
//                              if (e == null) {
//                                  Log.d("Profile", "We've got data in data.");
//                                  // Decode the Byte[] into Bitmap
//                                  Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
//
//                                  //ImageView image = (ImageView) findViewById(R.id.imageView_round);
//                                  //image.setImageBitmap(bmp);
//                                  Drawable drawable = new BitmapDrawable(getResources(), bmp);
//                                  //String name = getResources().getResourceEntryName(drawable);
//                                  //int temp = getResources().getIdentifier(name , "drawable", getPackageName());
//                                  PROFILE = bmp;
//                                  //mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE,this);
//                                  //mRecyclerView.setAdapter(mAdapter);
//                              }
//                          }
//                      });
//                  }
//              } else {
//                  // something went wrong
//                  //PROFILE = R.drawable.test;
//                  Toast.makeText(MainActivity.this, "pas d'image", Toast.LENGTH_SHORT).show();
//              }
//          }
//      });
      //
    mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE,this);
    mRecyclerView.setAdapter(mAdapter);

    final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
      @Override public boolean onSingleTapUp(MotionEvent e) {
        return true;
      }

    });


    mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
      @Override
      public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());

        if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
          Drawer.closeDrawers();
          switch (recyclerView.getChildPosition(child)) {
            case 1: {
              startActivity(new Intent(MainActivity.this, MainActivity.class));
              //finish();
              return true;
            }
            //Toast.makeText(MainActivity.this,"The Item Clicked is: 1",Toast.LENGTH_SHORT).show();
            case 2: {
              startActivity(new Intent(MainActivity.this, ProfileActivity.class));
              //finish();
              return true;
            }
            //Toast.makeText(MainActivity.this,"The Item Clicked is: 2",Toast.LENGTH_SHORT).show();
            case 3: {
              startActivity(new Intent(MainActivity.this, About.class));
              //finish();
              return true;
            }
            case 4: {
              final AppSharedPreferences preferences = AppSharedPreferences.newInstance(MainActivity.this);
              preferences.clearSignUpInformation();
              //System.exit(0);
              startActivity(new Intent(MainActivity.this, LoginActivity.class));

              //finish();
              return true;
            }
//            case 5: {
//              //startActivity(new Intent(MainActivity.this, DoctorChat.class));
//              //finish();
//              return true;
//            }
//            case 6: {
//              //startActivity(new Intent(MainActivity.this, History.class));
//              //finish();
//              return true;
//            }
            //case 7: Toast.makeText(MainActivity.this,"The Item Clicked is: 7",Toast.LENGTH_SHORT).show();
          }
          //Toast.makeText(MainActivity.this,"The Item Clicked is: "+recyclerView.getChildPosition(child),Toast.LENGTH_SHORT).show();
          return true;
        }
        return false;
      }

      @Override
      public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
      }

      @Override
      public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

      }
    });


    mLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mLayoutManager);

    Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
    mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

      @Override
      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        // code here will execute once the drawer is opened
      }

      @Override
      public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        // Code here will execute once drawer is closed
      }
    };
    Drawer.setDrawerListener(mDrawerToggle);
    mDrawerToggle.syncState();

  }

  public void onDestroy()
  	{
  		super.onDestroy();
  	}

  	@Override
 	public void onResume() 
 	{
  		super.onResume();

  		/*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT)
  		 {
  			startActivityForResult(new Intent(Settings.ACTION_WIRELESS_SETTINGS), 0);
  		 }*/
	}

	@Override
	public void onPause() 
	{
		super.onPause();
	}
	
	public void onBackPressed()
	{
		finish();
		super.onBackPressed();
	}

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    MenuItem shareItem = menu.findItem(R.id.menu_item_share);
      shareItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {
              Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
              sharingIntent.setType("text/plain");
              String shareBody = "BackUp_TunisieTelecom is an awesome application.";
              sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Big news");
              sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
              startActivity(Intent.createChooser(sharingIntent, "Share via"));
              return false;
          }
      });
//    if (shareItem != null) {
//      //mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
//    }
//    setShareIntent();
    return true;
  }

  private void setShareIntent() {
    if (mShareActionProvider != null) {

      Intent shareIntent = new Intent(Intent.ACTION_SEND);
      shareIntent.setType("text/plain");
      shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Android Development");
      //shareIntent.putExtra(Intent.EXTRA_TEXT, mainTextView.getText());

      mShareActionProvider.setShareIntent(shareIntent);
    }
  }
}
