package vn.hrtech.myapplication.MyRequest;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CommonRequest {
    RequestQueue myQueue;
    Context context;
    CommonRequest(Context context){
        myQueue = Volley.newRequestQueue(context);
        this.context = context;
    }
    public String getHost() {
        String host = "http://";
        String subDomain = "";
        String domain = "smartdelivery.ml";
        subDomain = subDomain == "" ? "" : subDomain + ".";
        host += subDomain + domain + "/";
        Log.d("HOST", host);
        return host;
    }
    public void setTimeout(Request request, int timeout){
        request.setRetryPolicy(new DefaultRetryPolicy(
                timeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
}
