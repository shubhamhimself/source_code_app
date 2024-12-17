package techy.apk.techyshubham.RelationshipWithBooks;

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

public class Books extends AppCompatActivity {
private PDFView pdfView;
String pdfurl="https://firebasestorage.googleapis.com/v0/b/techy-shubham.appspot.com/o/IT.pdf?alt=media&token=6979ae00-40d1-4a72-adc6-4574de5dae9d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        pdfView = findViewById(R.id.pdfView);
        new RetrievePDFfromUrl().execute(pdfurl);
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