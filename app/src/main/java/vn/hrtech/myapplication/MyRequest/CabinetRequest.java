package vn.hrtech.myapplication.MyRequest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import vn.hrtech.myapplication.Modals.Cabinet;
import vn.hrtech.myapplication.Modals.User;

public class CabinetRequest extends CommonRequest {
    public CabinetRequest(Context context) {
        super(context);
    }

    public Cabinet getCabinet() {
        return null;

    }

    public void openCabinet(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Cabin", response);
                        //openDashboard(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Cabin", error.toString());
            }
        }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", User.data.getToken());
                return headers;
            }
        };
        //setTimeout(stringRequest, 600000);

        myQueue.add(stringRequest);
    }
}
