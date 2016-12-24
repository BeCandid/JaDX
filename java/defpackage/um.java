package defpackage;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.facebook.GraphRequest;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: GraphRequestAsyncTask */
public class um extends AsyncTask<Void, Void, List<uo>> {
    private static final String a = um.class.getCanonicalName();
    private final HttpURLConnection b;
    private final un c;
    private Exception d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((List) obj);
    }

    public um(un requests) {
        this(null, requests);
    }

    public um(HttpURLConnection connection, un requests) {
        this.c = requests;
        this.b = connection;
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.b + ", requests: " + this.c + "}";
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (ul.b()) {
            Log.d(a, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.c.c() == null) {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.c.a(handler);
        }
    }

    protected void a(List<uo> result) {
        super.onPostExecute(result);
        if (this.d != null) {
            Log.d(a, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.d.getMessage()}));
        }
    }

    protected List<uo> a(Void... params) {
        try {
            if (this.b == null) {
                return this.c.g();
            }
            return GraphRequest.a(this.b, this.c);
        } catch (Exception e) {
            this.d = e;
            return null;
        }
    }
}
