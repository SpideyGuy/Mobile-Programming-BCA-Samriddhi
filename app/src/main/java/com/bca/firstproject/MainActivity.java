package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName, etEmail, etPassword;

    TextView tvRegister;

    Button btnVerify;

    LinearLayout llInner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivity_absolute);

        etFirstName = (EditText) findViewById(R.id.et_fname);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_pwd);
        btnVerify = (Button) findViewById(R.id.btn_verify);

        tvRegister = (TextView) findViewById(R.id.tv_register);

        llInner = (LinearLayout) findViewById(R.id.inner_ll);

        TextView tvFormName = new TextView(this);
        tvFormName.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tvFormName.setText("This is Form Name");
        tvFormName.setTextSize(18);

        if(llInner != null){
            llInner.addView(tvFormName);
        }

//        String fName = etFirstName.getText().toString();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = etFirstName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(email.equalsIgnoreCase("admin@gmail.com") && password.equals("Nepal123")){
                    Toast.makeText(MainActivity.this, "Welcome " + fName, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Sorry Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regActivity);
            }
        });

    }
}