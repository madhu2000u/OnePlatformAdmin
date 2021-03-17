package com.madhu.oneplatformadmin.Networking;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.madhu.oneplatformadmin.Constants;
import com.madhu.oneplatformadmin.Secrets;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class HttpClient {
    OkHttpClient client;
    Request request;
    Context context;

    public HttpClient(Context context){
        client=new OkHttpClient();
        this.context=context;


    }

    private void buildRequest(String class_number, String column, String date){            //this is the column of the subject in the excel sheet
        String url= Constants.BASE_URL+"/"+column;
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body(date, class_number));
        Log.d("nettt",body(date, class_number));


        request=new Request.Builder()
                .header("X-Api-Key", Secrets.key)        //not a good way to store and handle API keys, but it is just for temporary purposes and testing
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "PostmanRuntime/7.26.8")
                .url(url)
                .patch(body)
                .build();
    }

    public void sendRequest(final String column, String date, String class_number){
        buildRequest(class_number, column,date);
        Toast.makeText(context, "Marking...", Toast.LENGTH_SHORT).show();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("req", request.headers().toString());
                Log.d("nettt", "On Failure - "+ e.getMessage());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Couldn't not mark. Try checking your Internet connection", Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(context, "Failure - "+e.getMessage(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("nettt", "Success -"+response.code()+ response.body().string());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Successfully marked", Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(context, "Success - "+response.code(), Toast.LENGTH_SHORT).show();

            }

        });


    }

    String body(String date, String class_number){
        //return "{'"+date+"':'"+column+"'}";
        return  "{\""+date+"\":\""+class_number+"\"}";
    }

}
