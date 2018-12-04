package pathofexileuniques.eddytom.com.pathofexileuniques;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

class HtmlSync extends AsyncTask<Void, Integer, String> {
    String TAG = getClass().getSimpleName();
    String price;
    String url;

    HtmlSync(String u) {
        url = u;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG + " PreExceute", "On pre Exceute we currently do nothing.");
    }

    protected String doInBackground(Void... arg0) {
        Log.d(TAG + " DoINBackGround", "On doInBackground we are pinging website for html.");

        //Something to do with a progress bar.
       /* for(int i=0; i<10; i++){
            Integer in = new Integer(i);
            publishProgress(i);
        }*/
        try {
            Connection.Response res = Jsoup.connect(url).timeout(1000000).execute();
            Document doc = res.parse();
            Element table = doc.selectFirst("tbody");
            price = table.attr("data-buyout");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }

    protected void onProgressUpdate(Integer... a) {
        super.onProgressUpdate(a);
        Log.d(TAG + " onProgressUpdate", "You are in progress update ... " + a[0]);
    }

    protected void onPostExecute(String result) {
    }
}