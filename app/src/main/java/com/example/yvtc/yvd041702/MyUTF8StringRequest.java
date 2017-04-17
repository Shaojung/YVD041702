package com.example.yvtc.yvd041702;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * Created by yvtc on 2017/4/17.
 */

public class MyUTF8StringRequest extends StringRequest {
    public MyUTF8StringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String str = null;
        try {
            str = new String(response.data,"utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(response));
    }
}
