package com.example.a226part2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInternet()) {
                    showToast("Internet is connected ");
                } else {
                    showToast("No internet ");
                }
            }
        });
    }

    private boolean checkInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Check if networkInfo is not null before accessing its properties
        return networkInfo != null && networkInfo.isConnected();
    }

    private void showToast(String myString) {
        Toast.makeText(MainActivity.this, " " + myString, Toast.LENGTH_LONG).show();
    }

    private void addValues(int a, int b, int c) {

        int sum = a + b + c;
        button.setText("Sum is : " + sum);
    }

    private void makeDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("This is a sadness in my heart that no one will ever understand ")
                .setMessage("Hello Sanikingsrs")
                .show();
    }
}