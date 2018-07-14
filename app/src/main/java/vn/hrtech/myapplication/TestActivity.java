package vn.hrtech.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getJSON();
    }

    public void getJSON() {
        RequestQueue myQueue = Volley.newRequestQueue(this);

        String url = "https://swapi.co/api/planets/?page=2";

        /*JsonRequest registrationRequest = new JsonRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("RESPONSE", "|" + response + "|");
                String jsonString = response;
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
                JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();
                Log.d("JSON", jsonArray.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };*/
        JsonObjectRequest registrationRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("JSON", "onResponse: " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("JSON", "onErrorResponse: " + error.toString() );
            }
        });
        myQueue.add(registrationRequest);
    }

}
