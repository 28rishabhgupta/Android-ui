package com.example.complete_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.complete_android_app.databinding.ActivityLogin1Binding;

import java.util.regex.Pattern;

public class Login1 extends AppCompatActivity {
ActivityLogin1Binding activityLogin1Binding;
Button bt1;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        activityLogin1Binding= DataBindingUtil.setContentView(Login1.this,R.layout.activity_login1);
        textView=(TextView)findViewById(R.id.forpass);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Otp = new Intent(Login1.this,Otp_password.class);
                startActivity(Otp);
                finish();
            }
        });
        bt1=(Button)findViewById(R.id.button2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmail() && isPassword()) {


                    Intent login = new Intent(Login1.this, MainActivity.class);
                    startActivity(login);
                    finish();
                    Toast.makeText(Login1.this, "Login Up Successfull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login1.this, "Check all feilds", Toast.LENGTH_SHORT).show();

                }
            }

        });
        activityLogin1Binding.emailET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phnNo=activityLogin1Binding.emailET.getText().toString().trim();
                if (phnNo.length()<1){
                    activityLogin1Binding.emailTV.setVisibility(View.VISIBLE);
                    activityLogin1Binding.emailTV.setText("Enter the email");
                }
                else if (Pattern.compile( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(phnNo).matches()){
                    activityLogin1Binding.emailTV.setVisibility(View.INVISIBLE);
                }
                else{
                    activityLogin1Binding.emailTV.setVisibility(View.VISIBLE);
                    activityLogin1Binding.emailTV.setText("Enter valid email");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        activityLogin1Binding.passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phnNo=activityLogin1Binding.passwordET.getText().toString().trim();
                if (phnNo.length()<1){
                    activityLogin1Binding.passwordTV.setVisibility(View.VISIBLE);
                    activityLogin1Binding.passwordTV.setText("Enter the password");
                }
                else if (phnNo.length()<8){
                        activityLogin1Binding.passwordTV.setVisibility(View.VISIBLE);
                        activityLogin1Binding.passwordTV.setText("Enter the valid password");
                }
                else{
                    activityLogin1Binding.passwordTV.setVisibility(View.INVISIBLE);


                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    boolean isEmail(){
        String phnNo=activityLogin1Binding.emailET.getText().toString().trim();
        if (phnNo.length()<1){
            activityLogin1Binding.emailTV.setVisibility(View.VISIBLE);
            activityLogin1Binding.emailTV.setText("Enter the email");
            return false;
        }
        else if (Pattern.compile( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(phnNo).matches()){
            activityLogin1Binding.emailTV.setVisibility(View.INVISIBLE);
            return true;
        }
        else{
            activityLogin1Binding.emailTV.setVisibility(View.VISIBLE);
            activityLogin1Binding.emailTV.setText("Enter valid email");
            return false;


        }


    }
    boolean isPassword(){
        String phnNo=activityLogin1Binding.passwordET.getText().toString().trim();
        if (phnNo.length()<1){
            activityLogin1Binding.passwordTV.setVisibility(View.VISIBLE);
            activityLogin1Binding.passwordTV.setText("Enter the password");
            return false;

        }
        else if (phnNo.length()<8){
            activityLogin1Binding.passwordTV.setVisibility(View.VISIBLE);
            activityLogin1Binding.passwordTV.setText("Enter the valid password");
            return false;

        }
        else{
            activityLogin1Binding.passwordTV.setVisibility(View.INVISIBLE);
            return true;



        }

    }
}
