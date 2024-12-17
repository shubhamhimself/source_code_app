package techy.apk.techyshubham.RelationshipWithBooks.Story;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.pdfviewer.PDFView;
import com.github.pdfviewer.util.FitPolicy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import techy.apk.techyshubham.R;

public class StoryOne extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;

    private Button mButtonPlay;
    private Button mButtonPause;
    private Button mButtonResume;
    private Button mButtonStop;

    private SeekBar mSeekBar;

    private TextView mPass;
    private TextView mDuration;
    private TextView mDue;

    private MediaPlayer mPlayer;
    private Handler mHandler;
    private Runnable mRunnable;

    int length ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one);
        mContext = getApplicationContext();
        mActivity = StoryOne.this;
        mButtonPlay = findViewById(R.id.btn_play);
        mButtonPause = findViewById(R.id.btn_pause);
        mButtonResume = findViewById(R.id.btn_res);
        mButtonStop = findViewById(R.id.btn_stop);
        mSeekBar = findViewById(R.id.seek_bar);
        mPass = findViewById(R.id.tv_pass);
        mDuration = findViewById(R.id.tv_duration);
        mDue = findViewById(R.id.tv_due);
        mHandler = new Handler();
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                String audioUrl = "https://firebasestorage.googleapis.com/v0/b/techy-shubham.appspot.com/o/Main%20Yahaan%20Hoon%20Veer%20Zaara%20128%20Kbps.mp3?alt=media&token=ee9b7c51-986e-4342-9fa0-42342c1f4cec";
                mPlayer = new MediaPlayer();
                try {
                    mPlayer.setDataSource(audioUrl);
                    mPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mPlayer.start();
                Toast.makeText(mContext,"Media Player is playing.",Toast.LENGTH_SHORT).show();
                getAudioStats();
                initializeSeekBar();
            }
        });

        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.pause();
                length = mPlayer.getCurrentPosition();
            }
        });
        mButtonResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.seekTo(length);
                mPlayer.start();
            }
        });

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
            }
        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(mPlayer!=null && b){
                    mPlayer.seekTo(i*1000);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    protected void stopPlaying(){
        if(mPlayer!=null){
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
            Toast.makeText(mContext,"Stop playing.",Toast.LENGTH_SHORT).show();
            if(mHandler!=null){
                mHandler.removeCallbacks(mRunnable);
            }
        }
    }

    protected void getAudioStats(){
        int duration  = mPlayer.getDuration()/1000; // In milliseconds
        int due = (mPlayer.getDuration() - mPlayer.getCurrentPosition())/1000;
        int pass = duration - due;
        mPass.setText("" + pass + " seconds");
        mDuration.setText("" + duration + " seconds");
        mDue.setText("" + due + " seconds");
    }

    protected void initializeSeekBar(){
        mSeekBar.setMax(mPlayer.getDuration()/1000);
        mRunnable = new Runnable() {
            @Override
            public void run() {
                if(mPlayer!=null){
                    int mCurrentPosition = mPlayer.getCurrentPosition()/1000; // In milliseconds
                    mSeekBar.setProgress(mCurrentPosition);
                    getAudioStats();
                }
                mHandler.postDelayed(mRunnable,1000);
            }
        };
        mHandler.postDelayed(mRunnable,1000);
    }
}