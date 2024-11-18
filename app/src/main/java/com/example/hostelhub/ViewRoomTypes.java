package com.example.hostelhub;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewRoomTypes extends AppCompatActivity {

    private ListView listviewDemo;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_types);

        // Initialize views
        listviewDemo = findViewById(R.id.list_view_Demo);
        Button buttonUpdate = findViewById(R.id.button_update);
        Button buttonDelete = findViewById(R.id.button_delete);

        // Initialize the database helper
        databaseHelper = new DatabaseHelper(this);

        // Display data in the ListView
        displayDemo();

        // Handle the update button click
       buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                handleUpdate();
           }

        });

        // Handle the delete button click
      buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               handleDelete();
            }
       });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the displayed data
        displayDemo();
   }

    private void displayDemo() {
        // Fetch data from the database
        Cursor cursor = databaseHelper.getAllDemo(); // Ensure the method exists in DatabaseHelper

            // Use a custom adapter for the ListView
           DemoAdapter adapter = new DemoAdapter(this, cursor, 0);
            listviewDemo.setAdapter(adapter);

    }

    private void handleUpdate() {
       // Logic for updating a room type
       Intent intent = new Intent(ViewRoomTypes.this, UpdateHostelActivity.class);
        startActivity(intent);
   }

   private void handleDelete() {
       // Logic for deleting a room type
       Intent intent = new Intent(ViewRoomTypes.this, DeleteHostelActivity.class);
       startActivity(intent);
        Toast.makeText(this, "Delete button clicked", Toast.LENGTH_SHORT).show();
    }
}
