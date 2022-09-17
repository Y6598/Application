package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.Patterns;

import com.google.android.material.textfield.TextInputEditText;

public class Continue_With_Email extends AppCompatActivity {
    ImageButton back_Button;
    Button continue_Button;
    TextInputEditText passwordA1;
    TextInputEditText confirmPassword;
    TextInputEditText emailAddress;
    TextInputEditText confirmEmailAddress;
    TextView emailAddressAlert;
    TextView confirmEmailAddressAlert;
    TextView passwordAlert;
    TextView confirmPasswordAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.continue_with_email);

        emailAddress = (TextInputEditText) findViewById(R.id.emailAddress);
        confirmEmailAddress = (TextInputEditText) findViewById(R.id.confirmEmailAddress);
        passwordA1 = (TextInputEditText) findViewById(R.id.password);
        confirmPassword = (TextInputEditText) findViewById(R.id.confirmPassword);
        emailAddressAlert=(TextView)findViewById(R.id.emailAddressAlert);
        confirmEmailAddressAlert=(TextView)findViewById(R.id.confirmEmailAddressAlert);
        passwordAlert=(TextView)findViewById(R.id.passwordAlert);
        confirmPasswordAlert=(TextView)findViewById(R.id.confirmPasswordAlert);


        back_Button = (ImageButton) findViewById(R.id.backButton);
        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Continue_With_Email.this, CreateAccountOptions.class);
                startActivity(intent);
            }
        });

        continue_Button = (Button) findViewById(R.id.continueButton);
        continue_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean val = validateEmailAddressAndConfirmEmailAddress();
                Boolean val1 = validatePasswordAndConfirmPassword();
                if ((val && val1) == true) {
                    Intent intent = new Intent(Continue_With_Email.this, Profile_Page.class);
                    startActivity(intent);
                }


            }


        });
    }




    private boolean validatePasswordAndConfirmPassword() {

            String confirm_Password = confirmPassword.getText().toString().trim();
            String password = passwordA1.getText().toString().trim();

            if (password.isEmpty()) {
                passwordAlert.setText("Field can't be empty");
                return false;
            }
            if (confirm_Password.isEmpty()) {
                confirmPasswordAlert.setText("Field can't be empty");
                return false;
            }

            if (!password.equals(confirm_Password)) {
                confirmPasswordAlert.setText("Passwords not matched");
                return false;
            }else {
                passwordAlert.setError(null);
                confirmPasswordAlert.setError(null);
                return true;
            }

    }

    private boolean validateEmailAddressAndConfirmEmailAddress() {

        String email_Address = emailAddress.getText().toString().trim();
        String confirm_Email_Address = confirmEmailAddress.getText().toString().trim();

        if (email_Address.isEmpty()) {
            emailAddressAlert.setText("Field can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email_Address).matches()) {
            emailAddressAlert.setText("Please enter a valid email address");
            return false;
        } else  if (confirm_Email_Address.isEmpty()) {
            emailAddressAlert.setText("Field can't be empty");
            return false;

        } else if (!email_Address.equals(confirm_Email_Address)) {
            confirmEmailAddressAlert.setText("Email Address not matched");
            return false;
        }else {
            emailAddressAlert.setError(null);
            confirmEmailAddressAlert.setError(null);
            return true;
        }

    }
}