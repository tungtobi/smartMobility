package vn.hrtech.myapplication.MyRequest;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public interface VolleyCallback {
    void onSuccess(JSONArray jsonArray);
    void onError(VolleyError volleyError);
}
