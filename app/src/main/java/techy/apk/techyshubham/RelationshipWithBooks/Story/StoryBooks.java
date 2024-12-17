package techy.apk.techyshubham.RelationshipWithBooks.Story;

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

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import techy.apk.techyshubham.FullSourceCode.AndroidApp;
import techy.apk.techyshubham.MainActivity;
import techy.apk.techyshubham.MyAdapter;
import techy.apk.techyshubham.R;
import techy.apk.techyshubham.RelationshipWithBooks.Books;
import techy.apk.techyshubham.SplashMain;

public class StoryBooks extends AppCompatActivity {
    ListView listView;
    String[] title = {"পথের পাঁচালী – বিভূতিভূষণ বন্দোপাধ্যায়",
            "পথের দাবি- শরৎচন্দ্র চট্টোপাধ্যায়",
            "নৌকাডুবি- রবীন্দ্রনাথ ঠাকুর",
            "পদ্মা নদীর মাঝি- মানিক বন্দোপাধ্যায়"};

    Integer[] imageID = {R.drawable.sbooks
            , R.drawable.sbooks
            , R.drawable.sbooks
            , R.drawable.sbooks};
    ArrayAdapter<String> adapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView imageMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_books);
        listView = findViewById(R.id.listView_id);

        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(StoryBooks.this, drawerLayout, R.string.open, R.string.close);
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
                    Toast.makeText(StoryBooks.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemID==R.id.mDashboard){
                    Toast.makeText(StoryBooks.this, "Dashboard Clicked", Toast.LENGTH_SHORT).show();
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
                    Uri uri=Uri.parse("market://details?="+StoryBooks.this.getPackageName());
                    Intent gotoMarket= new Intent(Intent.ACTION_VIEW,uri);
                    gotoMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(gotoMarket);
                    }catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+StoryBooks.this.getPackageName())));
                    }
                }

                if (itemID==R.id.mShare){
                    String appPackageName=StoryBooks.this.getPackageName();
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
                        Toast.makeText(StoryBooks.this, "Clicked Again", Toast.LENGTH_SHORT).show();
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
        adapter = new MyAdapter(StoryBooks.this, title,imageID);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    Intent intent = new Intent(StoryBooks.this, StoryZero.class);
                    startActivity(intent);
                } else if (position==1) {
                    Intent intent = new Intent(StoryBooks.this, StoryOne.class);
                    startActivity(intent);
                } else if (position==2) {
                    Intent intent = new Intent(StoryBooks.this, StoryTwo.class);
                    startActivity(intent);
                } else if (position==3) {
                    Intent intent = new Intent(StoryBooks.this, StoryThree.class);
                    startActivity(intent);
                }
            }
        });
    }
}