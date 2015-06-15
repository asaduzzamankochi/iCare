package com.example.ahad.icare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by Mobile App Develop on 10-6-15.
 */
public class MyProfile extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }

    public void btnEditProfile(View v) {

        Intent intent = new Intent(MyProfile.this, MyProfileInformation.class);
        startActivity(intent);

    }
}
