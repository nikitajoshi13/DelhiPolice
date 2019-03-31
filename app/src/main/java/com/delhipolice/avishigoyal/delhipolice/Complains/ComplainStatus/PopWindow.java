package com.delhipolice.avishigoyal.delhipolice.Complains.ComplainStatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

public class PopWindow extends AppCompatActivity {
    Button button;
    TextView textView;
    String date,time,vendor,assigneddate,completionstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.windowpop);
        date="abc";
        time="abc";
        vendor="abc";
        assigneddate="abc";
        completionstatus="abc";
        button=findViewById(R.id.btn);
        textView=findViewById(R.id.texts);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;
        getWindow().setLayout((int)(width*.8),(int) (height*.6));
        textView.setText(date+"\n"+time+"\n"+vendor+"\n"+assigneddate+"\n"+completionstatus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

    }
}
