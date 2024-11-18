package com.example.hostelhub;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText etUsername=findViewById(R.id.et_Register_username);
        EditText etEmail=findViewById(R.id.et_Register_email);
        EditText etPassword=findViewById(R.id.et_Register_Password);
        EditText etconPassword=findViewById(R.id.et_Register_con_Password);
        EditText etPhone=findViewById(R.id.et_Register_Phone);
        Button btnLogin=findViewById(R.id.btn_login);
        Button btnRegister=findViewById(R.id.btn_register);









        btnRegister.setOnClickListener(v->{
                    String Username=etUsername.getText().toString();
                    String Email= etEmail.getText().toString();
                    String  Password=etPassword.getText().toString();
                    String conPassword=etconPassword.getText().toString();
                    String Phone=etPhone.getText().toString();

                    if(Password.equals(conPassword) && !Password.isEmpty() && !Email.isEmpty() &&!Username.isEmpty()){
                        Toast.makeText(RegisterActivity.this, "Okay!!Let me insert your info in DB", Toast.LENGTH_SHORT).show();
                        DatabaseHelper dbHelper= new DatabaseHelper(RegisterActivity.this);
                        boolean isInserted=dbHelper.insertUser( Username, Email,Password,Phone);

                        if(isInserted){
                            Toast.makeText(RegisterActivity.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Incorrect password or Empty username or Empty password", Toast.LENGTH_SHORT).show();

                    }


                }
        );
        btnLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(RegisterActivity.this, "Login button clicked!!", Toast.LENGTH_SHORT).show();
                                            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                                            startActivity(intent);
                                        }
                                    }

        );

    }
}