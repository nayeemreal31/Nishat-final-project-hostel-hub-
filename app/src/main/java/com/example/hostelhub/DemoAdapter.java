package com.example.hostelhub;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class DemoAdapter extends CursorAdapter {


    public DemoAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_demo, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView typesTextView = view.findViewById(R.id.text_view_Room_Types);
        TextView priceTextView = view.findViewById(R.id.text_view_Room_Price);
        ImageView demoImageView = view.findViewById(R.id.image_view_Demo);

        String type = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ROOM_TYPES));
        double price = cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ROOM_PRICE));
        byte[] imageBytes = cursor.getBlob(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ROOM_IMAGE_URI));


        typesTextView.setText(type);
        priceTextView.setText(String.valueOf(price));
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        demoImageView.setImageBitmap(bitmap);


    }

}
