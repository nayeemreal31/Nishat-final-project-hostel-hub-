package com.example.hostelhub;



import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_Password);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               Toast.makeText(LoginActivity.this, "Register button clicked!!", Toast.LENGTH_SHORT).show();
                                               Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                                               startActivity(intent);
                                           }
                                       }

        );
        btnLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(LoginActivity.this, "Login button clicked!!", Toast.LENGTH_SHORT).show();
                                        }
                                    }

        );
        btnLogin.setOnClickListener(view -> {
            String Username=etUsername.getText().toString();
            String Password=etPassword.getText().toString();


            if(Username.isEmpty() || Password.isEmpty()){


                Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

            }
            else {
                if (Username.equals("admin") && Password.equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                    startActivity(intent);

                } else {
                    DatabaseHelper dbHelper = new DatabaseHelper(LoginActivity.this);
                    boolean result = dbHelper.checkUserByUsername(Username, Password);
                    if (result) {
                        Toast.makeText(LoginActivity.this, "Valid user", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, FacilitesDisplay.class);
                        startActivity(intent);


                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid username and password!!", Toast.LENGTH_SHORT).show();


                    }
                }


            }

        });

    }
}



