package techy.apk.techyshubham.learnJava;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.pdfviewer.PDFView;
import com.github.pdfviewer.util.FitPolicy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import techy.apk.techyshubham.R;

public class LearnJava extends AppCompatActivity {
    private PDFView pdfView;
    String pdfurl="https://firebasestorage.googleapis.com/v0/b/techy-shubham.appspot.com/o/Advanced-java.pdf?alt=media&token=c0967250-3f7c-4ce2-a589-7d84b689db46";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_java);
        pdfView = findViewById(R.id.pdfView);
        new LearnJava.RetrievePDFfromUrl().execute(pdfurl);
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