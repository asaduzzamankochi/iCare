package com.example.ahad.icare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mobile App Develop on 10-6-15.
 */
public class MyProfileInformation extends ActionBarActivity {

    private EditText edtName;
    private EditText edtBirthDay;
    private EditText edtGender;
    private EditText edtBloodGroup;
    private EditText edtHeight;
    private EditText edtWeight;
    private EditText edtPhone;

    private String name;
    private String birthDay;
    private String gender;
    private String bloodGroup;
    private String height;
    private String weight;
    private String phoneNo;

    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_information);

        edtName = (EditText) findViewById(R.id.edtName);
        edtBirthDay = (EditText) findViewById(R.id.edtBirthDay);
        edtGender = (EditText) findViewById(R.id.edtGender);
        edtBloodGroup = (EditText) findViewById(R.id.edtBloodGroup);
        edtHeight = (EditText) findViewById(R.id.edtHeight);
        edtWeight = (EditText) findViewById(R.id.edtWeight);
        edtPhone = (EditText) findViewById(R.id.edtPhoneNo);


    }

    public void btnSubmit(View v) {
        getValue();
        dbHelper.insertMyProfile(name, birthDay, gender, bloodGroup, height, weight, phoneNo);
        Intent intent = new Intent(MyProfileInformation.this, MainActivity.class);
        startActivity(intent);


    }

    public void getValue() {
        name = edtName.getText().toString();
        birthDay = edtBirthDay.getText().toString();
        gender = edtGender.getText().toString();
        bloodGroup = edtBloodGroup.getText().toString();
        height = edtHeight.getText().toString();
        weight = edtWeight.getText().toString();
        phoneNo = edtPhone.getText().toString();

    }


}
