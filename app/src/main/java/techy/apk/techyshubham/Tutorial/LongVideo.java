package techy.apk.techyshubham.Tutorial;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import techy.apk.techyshubham.MainActivity;
import techy.apk.techyshubham.MyAdapter;
import techy.apk.techyshubham.R;
import techy.apk.techyshubham.RelationshipWithBooks.Books;
import techy.apk.techyshubham.SplashMain;
import techy.apk.techyshubham.Tutorial.LVideo.LVOne;
import techy.apk.techyshubham.Tutorial.LVideo.LVZero;
import techy.apk.techyshubham.Tutorial.Tutorial;

import techy.apk.techyshubham.R;

public class LongVideo extends AppCompatActivity {

    ListView listView;
    String[] title = { "How to Share Image of Your App with Another App ",
            "Android Volley Fetching Image And Text from Mysqli Database",
            "How to create Admob Account ",
            "Spin & Wheel to Earning App",
            "Change your App Logo in Android Studio",
            "AdMob Ad Implementation 2024",
            "HD Wallpaper Pro source code",
            "Fb Network Ads Implantation",
            "Make your own hosting for free with xampp",
            "Admob Ads ON And OFF use Firebase Realtime Database "};

    Integer[] imageID = {R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play
            , R.drawable.play};
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView imageMenu;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_video);
        listView = findViewById(R.id.listView_id);

        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(LongVideo.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemID = item.getItemId();
                if (itemID==R.id.mHome){
                    Toast.makeText(LongVideo.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemID==R.id.mDashboard){
                    Toast.makeText(LongVideo.this, "Dashboard Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemID==R.id.mMore){
                    String developerName = "Web Hub Official";
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + developerName)));
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + developerName)));
                    }
                }

                if (itemID==R.id.mRate){
                    Uri uri=Uri.parse("market://details?="+LongVideo.this.getPackageName());
                    Intent gotoMarket= new Intent(Intent.ACTION_VIEW,uri);
                    gotoMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(gotoMarket);
                    }catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+LongVideo.this.getPackageName())));
                    }
                }

                if (itemID==R.id.mShare){
                    String appPackageName=LongVideo.this.getPackageName();
                    Intent intent= new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,"Download Now : https://play.google.com/store/apps/details?id="+appPackageName);
                    intent.setType("text/plain");
                    startActivity(intent);
                }
                if (itemID==R.id.mPolicy){
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://webhub.shop/privacy-policy/")));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(LongVideo.this, "Clicked Again", Toast.LENGTH_SHORT).show();
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
        adapter = new MyAdapter(LongVideo.this, title,imageID);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    Intent intent = new Intent(LongVideo.this, LVZero.class);
                    startActivity(intent);
                } else if (position==1) {
                    Intent intent = new Intent(LongVideo.this, LVOne.class);
                    startActivity(intent);
                }else if (position==2) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==3) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==4) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==5) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==6) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==7) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==8) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                } else if (position==9) {
                    Toast.makeText(LongVideo.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}