package techy.apk.techyshubham.LearnAndroidStudio;

import android.os.AsyncTask;
import android.os.Bundle;

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
import techy.apk.techyshubham.learnJava.LearnJava;

public class LearnAndroid extends AppCompatActivity {
    private PDFView pdfView;
    String pdfurl="https://firebasestorage.googleapis.com/v0/b/techy-shubham.appspot.com/o/AndroidStudioEssentialsPreview.pdf?alt=media&token=38f1f7ba-1992-4d03-971f-a5ffa1fa9edb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_android);
        pdfView = findViewById(R.id.pdfView);
        new LearnAndroid.RetrievePDFfromUrl().execute(pdfurl);
    }
    class RetrievePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .enableAnnotationRendering(false)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .autoSpacing(false)
                    .pageFitPolicy(FitPolicy.WIDTH)
                    .fitEachPage(false)
                    .pageSnap(false)
                    .pageFling(false)
                    .nightMode(false)
                    .load();
        }

    }


}