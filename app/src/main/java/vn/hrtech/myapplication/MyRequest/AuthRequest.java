package vn.hrtech.myapplication.MyRequest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import vn.hrtech.myapplication.Modals.User;
import vn.hrtech.myapplication.R;
import vn.hrtech.myapplication.RegisterActivity;

public class AuthRequest extends CommonRequest{

    private boolean isSuccess = false;
    public AuthRequest(Context context) {
        super(context);
    }
    public void getToken(String email, String password) {
        String url = getHost() + "api/User/Login";
        final JSONObject userData = new JSONObject();
        try {
            userData.put("Username", email);
            userData.put("Password", password);

        } catch(JSONException e) {
            //something went wrong
            e.printStackTrace();
        }

        StringRequest registrationRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                User.data.setToken(response);
                Log.d("Token", "|" + response + "|");
                Log.d("Token", "|" + User.data.getToken() + "|");
                //getUserData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("E", error.toString());
                //mEmailView.setError("Không tồn tại tài khoản");
                //mEmailView.requestFocus();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return userData.toString().getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    return null;
                }
            }
        };

        setTimeout(registrationRequest, 600000);

        myQueue.add(registrationRequest);
    }

    public void getUserDatas() {
        String url = getHost() + "api/User/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Login", response);
                        User.data = new User();
                        User.data.getObject(response);
                        Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        isSuccess = true;
                        //openDashboard(false);
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Login", error.toString());
                    Toast.makeText(context, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
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
        setTimeout(stringRequest, 600000);

        myQueue.add(stringRequest);
    }

    public void postRegisterRequest(String email, String pass) {
        String reg_url = getHost() + "api/User";

        JSONObject userData = new JSONObject();
        try {
            userData.put("Username", email);
            userData.put("Password", pass);
        } catch(JSONException e) {
            e.printStackTrace();
        }

        Response.Listener<JSONObject> successHandler = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                Log.d("Register", response.toString());
                //RegisterActivity.login();
            }
        };

        Response.ErrorListener failureHandler = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
            }
        };

        JsonObjectRequest registrationRequest = new JsonObjectRequest(Request.Method.POST,
                reg_url, userData, successHandler, failureHandler);

        setTimeout(registrationRequest, 600000);
        myQueue.add(registrationRequest);

    }
}
