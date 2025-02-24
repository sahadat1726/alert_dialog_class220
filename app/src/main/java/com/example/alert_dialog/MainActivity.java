package com.example.alert_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button dialog_button;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog_button = findViewById(R.id.dialog_button);
        text = findViewById(R.id.text);

        dialog_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_button.setText("Show Dialog");
                dialog_button.setBackgroundColor(Color.LTGRAY);
                alertDialog();
            }
        });


    }

    void alertDialog(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("This is Alert Dialog")
                .setMessage("Do you want to open this site?")
                .setCancelable(false)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog_button.setText("Site Lodding...");
                        dialog_button.setBackgroundColor(Color.BLUE);
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}

