package techy.apk.techyshubham;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class SplashMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_main);

        //For Splash Screen
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Code here
                Intent myIntent = new Intent(SplashMain.this,SlideActivity.class);
                startActivity(myIntent);
                finish();
            }
        }, 4000);
    }
}