package com.example.hostelhub;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        Button btnInsertDemo=findViewById(R.id.btn_Insert_Demo);
        Button btnViewDemo=findViewById(R.id.btn_View_Demo);

        btnInsertDemo.setOnClickListener(v -> {
            Intent intent=new Intent(AdminHomeActivity.this, InsertRoomTypesActivity.class );
            startActivity(intent);


        });

        btnViewDemo.setOnClickListener(v -> {
            Intent intent=new Intent(AdminHomeActivity.this, ViewRoomTypes.class );
            startActivity(intent);


        });




    }
}