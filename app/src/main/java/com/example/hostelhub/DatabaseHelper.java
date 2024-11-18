package com.example.hostelhub;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TEST_DB";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_REGISTER = "register";

    public static final String TABLE_ROOM = "Room";

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_EMAIL = "email";

    public static final String COL_PASSWORD = "password";

    public static final String COL_PHONE = "mobile";

    public static final String COL_ROOM_TYPES = "RoomTypes";

    public static final String COL_ROOM_PRICE = "RoomPrice";

    public static final String COL_ROOM_IMAGE_URI = "RoomImageUri";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOM);


        onCreate(db);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_REGISTER + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_PASSWORD + " TEXT, " +
                COL_PHONE + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_ROOM + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ROOM_TYPES + " TEXT, " +
                COL_ROOM_PRICE + " REAL, " +
                COL_ROOM_IMAGE_URI + " BOLB)");


    }


    public boolean insertUser(String username, String email, String password, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_PHONE, phone);
        long result = db.insert(TABLE_REGISTER, null, contentValues);

        return result != -1;
    }

    public boolean checkUserByUsername(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REGISTER + " WHERE " + COL_USERNAME + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});
        boolean exits = cursor.getCount() > 0;
        cursor.close();


        return exits;
    }

    public void InsertDemo(String roomTypes, double price, byte[] imageByteArray) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ROOM_TYPES, roomTypes);
        contentValues.put(COL_ROOM_PRICE, price);
        contentValues.put(COL_ROOM_IMAGE_URI, imageByteArray);
         db.insert(TABLE_ROOM, null, contentValues);
        db.close();


    }

    public Cursor getAllDemo() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ROOM, null);
    }


}

