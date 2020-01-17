package com.example.admin.nlptry;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.nlptry.CreateUserResponse;
import com.example.admin.nlptry.MultipleResource;
import com.example.admin.nlptry.User;
import com.example.admin.nlptry.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseText = (TextView) findViewById(R.id.textView);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Retrofit m = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIInterface jsonPlaceHolderApi = m.create(APIInterface.class);

        Call<List<Post>> call = jsonPlaceHolderApi.Get();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    responseText.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getBrandName() + "\n";
                    content += "User ID: " + post.getProductName() + "\n";
                    content += "Title: " + post.getManufacturingYear() + "\n";


                    responseText.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                responseText.setText(t.getMessage());
            }
        });
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        TextView t = findViewById(R.id.textView);
        date d = new date();
        String dat = d.getday()+" "+d.getMonth()+" "+d.getYear();
        t.setText(dat);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        TextView t = findViewById(R.id.textView4);
        time d = new time();
        //String dat = d.getday()+" "+d.getMonth()+" "+d.getYear();
        String dat = d.getHour()+" "+d.getMin();
        t.setText(dat);
    }

    public void openlogin(View view)
    {
        Intent x = new Intent(this,Login.class);
        startActivity(x);
    }
    public void opentest(View view)
    {
        Intent x = new Intent(this,Test.class);
        startActivity(x);
    }
}
