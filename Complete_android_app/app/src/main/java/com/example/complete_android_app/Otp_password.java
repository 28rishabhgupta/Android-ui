package com.example.complete_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Otp_password extends AppCompatActivity {
    TextView otp;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_password);
        otp=(TextView)findViewById(R.id.resdtp);
        submit=(Button)findViewById(R.id.otp_submit) ;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset_password=new Intent(Otp_password.this,ResetPass.class);
                startActivity(reset_password);
                finish();
            }
        });
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Otp_password.this, "OTP sent successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
