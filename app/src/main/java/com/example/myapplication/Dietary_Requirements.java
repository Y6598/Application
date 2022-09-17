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

public class Dietary_Requirements extends AppCompatActivity {


    ImageButton back_Button;
    Button continue_Button;
    TextInputLayout allergiesDropdown;
    AutoCompleteTextView allergiesDropdownSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietary_requirements);
        allergiesDropdown=findViewById(R.id.allergiesDropdown);
        allergiesDropdownSearch=findViewById(R.id.allergiesDropdownSearch);

        String [] allergies_list={"Soy","Dairy","Fish","Egg","Pumpkin","None"};
        ArrayAdapter<String> allergy_adapter=new ArrayAdapter<>(Dietary_Requirements.this,R.layout.allergies_dropdown,allergies_list);
        allergiesDropdownSearch.setAdapter(allergy_adapter);
        allergiesDropdownSearch.setThreshold(1);

        back_Button=(ImageButton) findViewById(R.id.backButton);
        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( Dietary_Requirements.this,Profile_Page.class);
                startActivity(intent);
            }
        });

        continue_Button = (Button) findViewById(R.id.continueButton);
        continue_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //add where to go @before.class
                Intent intent = new Intent(Dietary_Requirements.this, Dietary_Requirements.class);
                startActivity(intent);
            }


        });





    }
}