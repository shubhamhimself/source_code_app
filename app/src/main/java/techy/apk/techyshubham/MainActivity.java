package techy.apk.techyshubham;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

import techy.apk.techyshubham.FullSourceCode.AndroidApp;
import techy.apk.techyshubham.FullSourceCode.SourceCode;
import techy.apk.techyshubham.KnowAboutMe.KnowAbout;
import techy.apk.techyshubham.LearnAndroidStudio.LearnAndroid;
import techy.apk.techyshubham.LivewithAdmin.LIveAdmin;
import techy.apk.techyshubham.RelationshipWithBooks.CategoriesBooks;
import techy.apk.techyshubham.Tutorial.SVOne;
import techy.apk.techyshubham.Tutorial.SVideo.SVZero;
import techy.apk.techyshubham.Tutorial.Tutorial;
import techy.apk.techyshubham.WebsiteDesigning.Website;
import techy.apk.techyshubham.learnJava.LearnJava;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] title = {"Full Source Code", "Tutorial", "Learn Java", "Live with Admin", "Clients Projects",
            "Learn Android Studio", "Relationship With Books","My Portfolio","Know About Me"};
    Integer[] imageID = {R.drawable.programming,R.drawable.tutorial,R.drawable.learn,R.drawable.live,R.drawable.light,
            R.drawable.android,R.drawable.books,R.drawable.bro,R.drawable.fol};

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView imageMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView_id);
        ImageSlider imageSlider=findViewById(R.id.imageSlider);

        //slider image
        ArrayList<SlideModel> slideModels= new ArrayList<>();
         slideModels.add(new SlideModel(R.drawable.img1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int itemID=item.getItemId();
            if (itemID==R.id.mHome){
                Toast.makeText(MainActivity.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemID==R.id.mDashboard){
                    Toast.makeText(MainActivity.this, "Dashboard Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemID==R.id.mMore){
                    String developerName = "Web Hub Shop";
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + developerName)));
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + developerName)));
                    }
                }

                if (itemID==R.id.mRate){
                  Uri uri=Uri.parse("market://details?="+MainActivity.this.getPackageName());
                  Intent gotoMarket= new Intent(Intent.ACTION_VIEW,uri);
                  gotoMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                  try {
                      startActivity(gotoMarket);
                  }catch (ActivityNotFoundException e){
                      startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+MainActivity.this.getPackageName())));
                  }
                }

                if (itemID==R.id.mShare){
                    String appPackageName=MainActivity.this.getPackageName();
                    Intent intent= new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,"Download Now : https://play.google.com/store/apps/details?id="+appPackageName);
                    intent.setType("text/plain");
                    startActivity(intent);
                }
                if (itemID==R.id.mPolicy){
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://shubhamofficial.in/privacy-policy.html")));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(MainActivity.this, "Clicked Again", Toast.LENGTH_SHORT).show();
                    }
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
        // App Bar Click Event
        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //list view
        MyAdapter adapter = new MyAdapter(MainActivity.this, title,imageID);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    Intent intent = new Intent(MainActivity.this, SourceCode.class);
                    startActivity(intent);
                } else if (position==1) {
                    Intent intent = new Intent(MainActivity.this, Tutorial.class);
                    startActivity(intent);
                } else if (position==2) {
                    Intent intent = new Intent(MainActivity.this, LearnJava.class);
                    startActivity(intent);
                } else if (position==3) {
                    Intent intent = new Intent(MainActivity.this, LIveAdmin.class);
                    startActivity(intent);
                } else if (position==4) {
                        String developerName = "Web Hub Shop";
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + developerName)));
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + developerName)));
                        }
                } else if (position==5) {
                    Intent intent = new Intent(MainActivity.this, LearnAndroid.class);
                    startActivity(intent);
                } else if (position==6) {
                    Intent intent = new Intent(MainActivity.this, CategoriesBooks.class);
                    startActivity(intent);
                } else if (position==7) {
                    Intent intent = new Intent(MainActivity.this, Website.class);
                    startActivity(intent);
                } else if (position==8) {
                    Intent intent = new Intent(MainActivity.this, KnowAbout.class);
                    startActivity(intent);
                }
            }
        });

    } // OnCreate Method Close here ==============

} // Public Class CLose Here =====================

