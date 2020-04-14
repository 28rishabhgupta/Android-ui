package com.example.complete_android_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.complete_android_app.databinding.ActivitySignUpBinding;

import java.util.regex.Pattern;

public class Sign_up extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    public static final int CAMERA_REQUEST = 999;
    ImageView imageView;
    Button submit;
    TextView signuplogin;
    Uri imageUri;

    ActivitySignUpBinding activitySignUpBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpBinding=DataBindingUtil.setContentView(Sign_up.this,R.layout.activity_sign_up);

        ImageView imageCamera = findViewById(R.id.camera_click);
        signuplogin=(TextView)findViewById(R.id.signup_login);
        signuplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signlogin=new Intent(Sign_up.this,Login1.class);
                startActivity(signlogin);
                finish();
            }
        });
        submit = (Button)findViewById(R.id.signup_submit_button);
        imageView = (ImageView)findViewById(R.id.person_image);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isName() && isPhn() && isEmail() && isRta() && isDeposit() && isPassword()) {
                    Intent intent = new Intent(Sign_up.this, Login1.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(Sign_up.this, "Sign Up Successfull", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Sign_up.this, "Check all feilds", Toast.LENGTH_SHORT).show();
                }
            }

        });

        activitySignUpBinding.nameET1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = activitySignUpBinding.nameET1.getText().toString().trim();
                if (name.length()<1){
                    activitySignUpBinding.snameTv.setVisibility(View.VISIBLE);
                    activitySignUpBinding.snameTv.setText("Enter the name");
                }
                else if(Pattern.compile("^[a-zA-Z ]*$").matcher(name).matches()){
                    activitySignUpBinding.snameTv.setVisibility(View.INVISIBLE);
                }
                else{
                    activitySignUpBinding.snameTv.setVisibility(View.VISIBLE);
                    activitySignUpBinding.snameTv.setText("Enter valid name");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

       activitySignUpBinding.sinPhnEt.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               String phnNo=activitySignUpBinding.sinPhnEt.getText().toString().trim();
               if (phnNo.length()<1){
                   activitySignUpBinding.sPhnTv.setVisibility(View.VISIBLE);
                   activitySignUpBinding.sPhnTv.setText("Enter the number");
               }
               else if (Pattern.compile("[0-9]{8,12}").matcher(phnNo).matches()){
                   activitySignUpBinding.sPhnTv.setVisibility(View.INVISIBLE);
               }
               else{
                   activitySignUpBinding.sPhnTv.setVisibility(View.VISIBLE);
                   activitySignUpBinding.sPhnTv.setText("Enter valid number");

               }

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
        activitySignUpBinding.emailET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phnNo=activitySignUpBinding.emailET.getText().toString().trim();
                if (phnNo.length()<1){
                    activitySignUpBinding.emailTV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.emailTV.setText("Enter the email");
                }
                else if (Pattern.compile( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(phnNo).matches()){
                    activitySignUpBinding.emailTV.setVisibility(View.INVISIBLE);
                }
                else{
                    activitySignUpBinding.emailTV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.emailTV.setText("Enter valid email");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        activitySignUpBinding.RTAET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phnNo=activitySignUpBinding.RTAET.getText().toString().trim();
                if (phnNo.length()<1){
                    activitySignUpBinding.RTATV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.RTAET.setText("Enter the RTA number");
                }
                else if (Pattern.compile( "[0-9]{5,12}").matcher(phnNo).matches()){
                    activitySignUpBinding.RTATV.setVisibility(View.INVISIBLE);
                }
                else{
                    activitySignUpBinding.RTATV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.RTATV.setText("Enter valid RTA number");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        activitySignUpBinding.DepoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phnNo=activitySignUpBinding.DepoET.getText().toString().trim();
                if (phnNo.length()<1){
                    activitySignUpBinding.depoTV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.depoTV.setText("Deposit shouldn't be empty");
                }
                else if (Pattern.compile( "[0-9]{5,12}").matcher(phnNo).matches()){
                    activitySignUpBinding.depoTV.setVisibility(View.INVISIBLE);
                }
                else{
                    activitySignUpBinding.depoTV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.depoTV.setText("Deposit not valid");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        activitySignUpBinding.passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phnNo=activitySignUpBinding.passwordET.getText().toString().trim();
                if (phnNo.length()<1){
                    activitySignUpBinding.passwordTV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.passwordTV.setText("Enter the password");
                }
                else if (phnNo.length()<8){
                    activitySignUpBinding.passwordTV.setVisibility(View.VISIBLE);
                    activitySignUpBinding.passwordTV.setText("Enter valid password");
                }
                else{
                    activitySignUpBinding.passwordTV.setVisibility(View.INVISIBLE);



                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
    boolean isName(){
        String name = activitySignUpBinding.nameET1.getText().toString().trim();
        if (name.length()<1){
            activitySignUpBinding.snameTv.setVisibility(View.VISIBLE);
            activitySignUpBinding.snameTv.setText("Enter the name");
            return false;

        }
        else if(Pattern.compile("^[a-zA-Z ]*$").matcher(name).matches()){
            activitySignUpBinding.snameTv.setVisibility(View.INVISIBLE);
            return true;

        }
        else{
            activitySignUpBinding.snameTv.setVisibility(View.VISIBLE);
            activitySignUpBinding.snameTv.setText("Enter valid name");
            return false;

        }

    }
    boolean isPhn(){
        String phnNo=activitySignUpBinding.sinPhnEt.getText().toString().trim();
        if (phnNo.length()<1){
            activitySignUpBinding.sPhnTv.setVisibility(View.VISIBLE);
            activitySignUpBinding.sPhnTv.setText("Enter the number");
            return false;

        }
        else if (Pattern.compile("[0-9]{8,12}").matcher(phnNo).matches()){
            activitySignUpBinding.sPhnTv.setVisibility(View.INVISIBLE);
            return true;

        }
        else{
            activitySignUpBinding.sPhnTv.setVisibility(View.VISIBLE);
            activitySignUpBinding.sPhnTv.setText("Enter valid number");
            return false;


        }


    }
    boolean isEmail(){
        String phnNo=activitySignUpBinding.emailET.getText().toString().trim();
        if (phnNo.length()<1){
            activitySignUpBinding.emailTV.setVisibility(View.VISIBLE);
            activitySignUpBinding.emailTV.setText("Enter the email");
            return false;

        }
        else if (Pattern.compile( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(phnNo).matches()){
            activitySignUpBinding.emailTV.setVisibility(View.INVISIBLE);
            return true;

        }
        else{
            activitySignUpBinding.emailTV.setVisibility(View.VISIBLE);
            activitySignUpBinding.emailTV.setText("Enter valid email");
            return false;


        }


    }
    boolean isRta(){
        String phnNo=activitySignUpBinding.RTAET.getText().toString().trim();
        if (phnNo.length()<1){
            activitySignUpBinding.RTATV.setVisibility(View.VISIBLE);
            activitySignUpBinding.RTAET.setText("Enter the RTA number");
            return false;

        }
        else if (Pattern.compile( "[0-9]{5,12}").matcher(phnNo).matches()){
            activitySignUpBinding.RTATV.setVisibility(View.INVISIBLE);
            return true;

        }
        else{
            activitySignUpBinding.RTATV.setVisibility(View.VISIBLE);
            activitySignUpBinding.RTATV.setText("Enter valid RTA number");
            return false;


        }


    }
    boolean isDeposit(){
        String phnNo=activitySignUpBinding.DepoET.getText().toString().trim();
        if (phnNo.length()<1){
            activitySignUpBinding.depoTV.setVisibility(View.VISIBLE);
            activitySignUpBinding.depoTV.setText("Deposit shouldn't be empty");
            return false;

        }
        else if (Pattern.compile( "[0-9]{5,12}").matcher(phnNo).matches()){
            activitySignUpBinding.depoTV.setVisibility(View.INVISIBLE);
            return true;

        }
        else{
            activitySignUpBinding.depoTV.setVisibility(View.VISIBLE);
            activitySignUpBinding.depoTV.setText("Deposit not valid");
            return false;

        }
    }
        boolean isPassword(){
        String phnNo=activitySignUpBinding.passwordET.getText().toString().trim();
        if (phnNo.length()<1){
            activitySignUpBinding.passwordTV.setVisibility(View.VISIBLE);
            activitySignUpBinding.passwordTV.setText("Enter the password");
            return false;
        }
        else if (phnNo.length()<8){
            activitySignUpBinding.passwordTV.setVisibility(View.VISIBLE);
            activitySignUpBinding.passwordTV.setText("Enter the valid password");
            return false;
        }
        else{
            activitySignUpBinding.passwordTV.setVisibility(View.INVISIBLE);

            return true;

        }

    }
    public void OpenCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    public void OpenGallery(View view) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        } else if (requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);

        }
    }

}
