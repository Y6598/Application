package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;

public class Profile_Page extends AppCompatActivity {

    TextInputLayout gender_dropdown;
    AutoCompleteTextView gender;
    ImageButton back_Button;
    Button continue_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        gender_dropdown=findViewById(R.id.gender_dropdown);
        gender=findViewById(R.id.gender);
        String [] genders={"Male","Female","Others"};
        ArrayAdapter<String> gender_Adapter=new ArrayAdapter<>(Profile_Page.this,R.layout.gender_dropdown,genders);
        gender.setAdapter(gender_Adapter);

        back_Button = (ImageButton) findViewById(R.id.backButton);
        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Page.this, Continue_With_Email.class);
                startActivity(intent);
            }
        });

        continue_Button = (Button) findViewById(R.id.continueButton);
        continue_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //added allergies code as don't have dietary requirements code in dietary requirements class and xml
                Intent intent = new Intent(Profile_Page.this, Dietary_Requirements.class);
                startActivity(intent);
            }


        });
    }
}