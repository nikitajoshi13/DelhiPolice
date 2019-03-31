package com.delhipolice.avishigoyal.delhipolice.SplashScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;
import com.delhipolice.avishigoyal.delhipolice.Login.LoginActivity;
import com.delhipolice.avishigoyal.delhipolice.R;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

public class SlpashScreen extends AppCompatActivity {

    MyPrefences myPrefences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myPrefences=new MyPrefences(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slpash_screen);
        getSupportActionBar().hide();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if(myPrefences.isNotLogin()) {
                        Intent i = new Intent(SlpashScreen.this, LoginActivity.class);
                        startActivity(i);
                    }

                    else
                    {
                        Intent i = new Intent(SlpashScreen.this, ComplainLodge.class);
                        startActivity(i);
                    }
                }
            }
        }.start();

    }
}
