package vn.hrtech.myapplication.MyRequest;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import vn.hrtech.myapplication.Modals.Goods;
import vn.hrtech.myapplication.Modals.User;

public class GoodsRequest extends CommonRequest{
    public GoodsRequest(Context context) {
        super(context);
    }

    public void createGoods(String idSender, String idReceiver) {
        String url = getHost() + "api/Good";

        final JSONObject goods = new JSONObject();

        try {
            goods.put("IdReceiver", "b42725b1-f0bc-47e8-8f1f-3b2cbd854a93");
            goods.put("IdSender", "b42725b1-f0bc-47e8-8f1f-3b2cbd854a93");
            goods.put("AddressRecive", "somewhere");
            goods.put("Name", "abc");
            goods.put("Status", idSender);

        } catch(JSONException e) {
            //something went wrong
            e.printStackTrace();
        }

        Response.Listener<JSONObject> successHandler = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, "thành công", Toast.LENGTH_SHORT).show();
                Log.d("Response", response.toString());
            }
        };

        Response.ErrorListener failureHandler = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "thất bại", Toast.LENGTH_SHORT).show();
            }
        };

        JsonObjectRequest registrationRequest = new JsonObjectRequest(Request.Method.POST,
                url, goods, successHandler, failureHandler);

        myQueue.add(registrationRequest);
    }

    public void getGoodsList(final VolleyCallback callback) {
        String url = getHost() + "api/Good/sender/b42725b1-f0bc-47e8-8f1f-3b2cbd854a93";

        ArrayList<Goods> goodses = new ArrayList<Goods>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Res", response.toString());
                callback.onSuccess(response);
                }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("E", "onErrorResponse: " + error.toString());
            }
        });

        setTimeout(request, 600000);

        myQueue.add(request);
    }
}
