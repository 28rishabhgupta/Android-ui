package com.example.complete_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.complete_android_app.databinding.ActivityResetPassBinding;

import java.util.regex.Pattern;

public class ResetPass extends AppCompatActivity {
    String Pass="0";



    ActivityResetPassBinding activityResetPassBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);


        activityResetPassBinding = DataBindingUtil.setContentView(ResetPass.this, R.layout.activity_reset_pass);
        activityResetPassBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ResetPass.this,Login1.class);
                startActivity(back);
                finish();
            }
        });
        activityResetPassBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPassword() && iscPass()) {


                    Intent login = new Intent(ResetPass.this, Login1.class);
                    startActivity(login);
                    finish();
                    Toast.makeText(ResetPass.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetPass.this, "Check all feilds", Toast.LENGTH_SHORT).show();

                }

            }
        });

        activityResetPassBinding.passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Pass = activityResetPassBinding.passwordET.getText().toString().trim();
                if (Pass.length() < 1) {
                    activityResetPassBinding.passwordTV.setVisibility(View.VISIBLE);
                    activityResetPassBinding.passwordTV.setText("Enter the password");
                } else if (Pass.length() < 8) {
                    activityResetPassBinding.passwordTV.setVisibility(View.VISIBLE);
                    activityResetPassBinding.passwordTV.setText("Password too short");
                } else {
                    activityResetPassBinding.passwordTV.setVisibility(View.INVISIBLE);


                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        activityResetPassBinding.passwordET1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String cpass = activityResetPassBinding.passwordET1.getText().toString().trim();
                if (cpass.length() < 1) {
                    activityResetPassBinding.passwordTV1.setVisibility(View.VISIBLE);
                    activityResetPassBinding.passwordTV1.setText("Enter the password");
                } else if (Pattern.compile(Pass).matcher(cpass).matches()) {
                    activityResetPassBinding.passwordTV1.setVisibility(View.INVISIBLE);

                } else {
                    activityResetPassBinding.passwordTV1.setVisibility(View.VISIBLE);
                    activityResetPassBinding.passwordTV1.setText("Password does not match");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    boolean isPassword() {
        String phnNo = activityResetPassBinding.passwordET.getText().toString().trim();
        if (phnNo.length() < 1) {
            activityResetPassBinding.passwordTV.setVisibility(View.VISIBLE);
            activityResetPassBinding.passwordTV.setText("Enter the password");
            return false;

        } else if (phnNo.length() < 8) {
            activityResetPassBinding.passwordTV.setVisibility(View.VISIBLE);
            activityResetPassBinding.passwordTV.setText("Enter the valid password");
            return false;

        } else {
            activityResetPassBinding.passwordTV.setVisibility(View.INVISIBLE);
            return true;


        }

    }

    boolean iscPass() {
        String cpass = activityResetPassBinding.passwordET1.getText().toString().trim();
        if (cpass.length() < 1) {
            activityResetPassBinding.passwordTV1.setVisibility(View.VISIBLE);
            activityResetPassBinding.passwordTV1.setText("Enter the password");
            return false;
        } else if (Pattern.compile(Pass).matcher(cpass).matches()) {
            activityResetPassBinding.passwordTV1.setVisibility(View.INVISIBLE);

            return true;
        }
        else {
            activityResetPassBinding.passwordTV1.setVisibility(View.VISIBLE);
            activityResetPassBinding.passwordTV1.setText("Password Doesnt match");
            return false;


        }


    }
}
