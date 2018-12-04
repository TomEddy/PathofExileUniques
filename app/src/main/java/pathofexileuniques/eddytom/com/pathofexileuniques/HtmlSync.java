package pathofexileuniques.eddytom.com.pathofexileuniques;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

class HtmlSync extends AsyncTask<Void, Integer, String>
{
    String TAG = getClass().getSimpleName();
    String title;

    protected void onPreExecute (){
        super.onPreExecute();
        Log.d(TAG + " PreExceute","On pre Exceute we currently do nothing.");
    }

    protected String doInBackground(Void...arg0) {
        Log.d(TAG + " DoINBackGround","On doInBackground we are pinging website for html.");

        //Something to do with a progress bar.
       /* for(int i=0; i<10; i++){
            Integer in = new Integer(i);
            publishProgress(i);
        }*/
        try {
            String url = "http://poe.trade/";

            Connection.Response res = Jsoup.connect(url).timeout(10000000).execute();

            Document doc = res.parse();
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return title;
    }

    protected void onProgressUpdate(Integer...a){
        super.onProgressUpdate(a);
        Log.d(TAG + " onProgressUpdate", "You are in progress update ... " + a[0]);
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d(TAG + " onPostExecute", "" + title);
    }
}