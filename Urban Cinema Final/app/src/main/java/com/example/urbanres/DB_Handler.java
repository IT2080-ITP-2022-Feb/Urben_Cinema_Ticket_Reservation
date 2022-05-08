package com.example.urbanres;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.util.ArrayList;

import com.example.urbanres.Food.FoodModelClass;
import com.example.urbanres.Reservation.bookingModel;

import com.example.urbanres.Movies.Model;
import com.example.urbanres.Reviews.Reviews;

public class DB_Handler extends SQLiteOpenHelper {

    Context context;

    //Database name
    public static final String DATABASE_NAME = "Movie.db";

    //Movie table
    public static final String MOVIE_TABLE = "movies_table";
    public static final String MOVIE_COLUMN_ID = "movieID";
    public static final String MOVIE_COLUMN_NAME = "name";
    public static final String MOVIE_COLUMN_GENRE = "genre";
    public static final String MOVIE_COLUMN_DURATION = "duration";
    public static final String MOVIE_COLUMN_YEAR = "year";
    public static final String MOVIE_COLUMN_DESCRIPTION = "description";
    public static final String MOVIE_COLUMN_CAST = "castTEXT";
    public static final String MOVIE_COLUMN_POSTER = "poster";
    public static final String MOVIE_COLUMN_COVER = "coverImage";
    public static final String MOVIE_COLUMN_START_DATE = "start_date";
    public static final String MOVIE_COLUMN_END_DATE = "end_date";
    public static final String MOVIE_COLUMN_TRAILER = "trailerLink";
    public static final String MOVIE_COLUMN_PRICE = "ticketPrice";

    //User table
    public static final String USER_TABLE = "users_table";
    public static final String USER_COLUMN_ID = "userID";
    public static final String USER_COLUMN_USERNAME = "username";
    public static final String USER_COLUMN_EMAIL = "email";
    public static final String USER_COLUMN_PASSWORD = "password";
    public static final String USER_COLUMN_CONTACT = "contact";
    public static final String USER_COLUMN_IMAGE = "image";

    //Admin table
    public static final String ADMIN_TABLE = "admin_table";
    public static final String ADMIN_COLUMN_ID = "adminID";
    public static final String ADMIN_COLUMN_NAME = "name";
    public static final String ADMIN_COLUMN_USERNAME = "username";
    public static final String ADMIN_COLUMN_PASSWORD = "password";

    //Booking table
    public static final String BOOKING_TABLE = "booking_table";
    public static final String BOOKING_COLUMN_ID = "bookingId";
    public static final String BOOKING_COLUMN_N_TICKETS = "normalTickets";
    public static final String BOOKING_COLUMN_BOX_TICKETS = "boxTickets";
    public static final String BOOKING_COLUMN_DATE = "date";
    public static final String BOOKING_COLUMN_TIME = "time";
    public static final String BOOKING_COLUMN_AMOUNT = "amount";
    public static final String BOOKING_COLUMN_MOVIE_NAME = "movieName";

    //Discount table
    public static final String DISCOUNT_TABLE = "discount_table";
    public static final String DISCOUNT_COLUMN_ID = "discountID";
    public static final String DISCOUNT_COLUMN_CODE = "couponCode";
    public static final String DISCOUNT_COLUMN_PERCENTAGE = "percentage";


    //Reviews table
    public static final String REVIEWS_TABLE = "reviews_table";
    public static final String REVIEWS_COLUMN_ID = "revID";
    public static final String REVIEWS_COLUMN_USERID = "userID";
    public static final String REVIEWS_COLUMN_SCOUNT = "count";
    public static final String REVIEWS_COLUMN_MESSAGE = "message";
    public static final String REVIEWS_COLUMN_DATE = "date";


    //Theater Rating table
    public static final String THEATER_RATING_TABLE = "theater_rating_table";
    public static final String THEATER_RATING_COLUMN_ID = "ratingID";
    public static final String THEATER_RATING_COLUMN_USERID = "userID";
    public static final String THEATER_RATING_COLUMN_COUNT = "count";
    public static final String THEATER_RATING_COLUMN_MESSAGE = "message";
    public static final String THEATER_RATING_COLUMN_DATE = "date";

    //Favorite table
    public static final String FAVORITE_TABLE = "favorite_table";
    public static final String FAVORITE_COLUMN_ID = "favID";
    public static final String FAVORITE_COLUMN_USERID = "userID";
    public static final String FAVORITE_COLUMN_MOVIE_ID = "movieID";


    //Food table
    public static final String FOOD_TABLE = "food_table";
    public static final String FOOD_COLUMN_ID = "foodID";
    public static final String FOOD_COLUMN_NAME = "name";
    public static final String FOOD_COLUMN_IMAGE = "image";
    public static final String FOOD_COLUMN_PRICE = "price";

    //Order table
    public static final String ORDER_TABLE = "order_table";
    public static final String ORDER_COLUMN_ID = "orderID";
    public static final String ORDER_COLUMN_DATETIME = "date_time";
    public static final String ORDER_COLUMN_SHEET_NO = "sheetNumber";
    public static final String ORDER_COLUMN_TOTAL_ITEMS = "totalItems";
    public static final String ORDER_COLUMN_AMOUNT = "amount";
    public static final String ORDER_COLUMN_USERID = "userId";

    //Order_Food table
    public static final String ORDER_FOOD_TABLE = "order_food_table";
    public static final String ORDER_FOOD_COLUMN_ID = "orderID,foodID";
    public static final String ORDER_FOOD_COLUMN_PRODUCT_NAME = "productName";
    public static final String ORDER_FOOD_COLUMN_QUANTITY = "quantity";





    public DB_Handler(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        //create movie table
        String create_movies_table =
                "CREATE TABLE "+MOVIE_TABLE+" ( "+
                        MOVIE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        MOVIE_COLUMN_NAME+" TEXT, "+
                        MOVIE_COLUMN_GENRE+" TEXT, "+
                        MOVIE_COLUMN_DURATION+" TEXT, "+
                        MOVIE_COLUMN_YEAR+" INTEGER, "+
                        MOVIE_COLUMN_DESCRIPTION+" TEXT, "+
                        MOVIE_COLUMN_CAST+" TEXT, "+
                        MOVIE_COLUMN_POSTER+" BLOB, "+
                        MOVIE_COLUMN_COVER+" BLOB, "+
                        MOVIE_COLUMN_START_DATE+" TEXT, "+
                        MOVIE_COLUMN_END_DATE+" TEXT, "+
                        MOVIE_COLUMN_TRAILER+" TEXT, "+
                        MOVIE_COLUMN_PRICE+" REAL)";

        //create user table
        String create_users_table =
                "CREATE TABLE "+USER_TABLE+" ( "+
                        USER_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        USER_COLUMN_USERNAME+" TEXT, "+
                        USER_COLUMN_EMAIL+" TEXT, "+
                        USER_COLUMN_PASSWORD+" TEXT, "+
                        USER_COLUMN_CONTACT+" TEXT, "+
                        USER_COLUMN_IMAGE+" BLOB)";

        //create admin table
        String create_admin_table =
                "CREATE TABLE "+ADMIN_TABLE+" ( "+
                        ADMIN_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        ADMIN_COLUMN_NAME+" TEXT, "+
                        ADMIN_COLUMN_USERNAME+" TEXT, "+
                        ADMIN_COLUMN_PASSWORD+" TEXT)";

        //create booking table
        String create_booking_table =
                "CREATE TABLE "+BOOKING_TABLE+" ( "+
                        BOOKING_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        BOOKING_COLUMN_N_TICKETS+" TEXT, "+
                        BOOKING_COLUMN_BOX_TICKETS+" TEXT, "+
                        BOOKING_COLUMN_DATE+" TEXT, "+
                        BOOKING_COLUMN_TIME+" TEXT, "+
                        BOOKING_COLUMN_AMOUNT+" TEXT, "+
                        BOOKING_COLUMN_MOVIE_NAME+" TEXT)";

        //create discount table
        String create_discount_table =
                "CREATE TABLE "+DISCOUNT_TABLE+" ( "+
                        DISCOUNT_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        ADMIN_COLUMN_NAME+" TEXT, "+
                        DISCOUNT_COLUMN_CODE+" TEXT, "+
                        DISCOUNT_COLUMN_PERCENTAGE+" INTEGER)";

        //create review table
        String create_reviews_table =
                "CREATE TABLE "+REVIEWS_TABLE+" ( "+
                        REVIEWS_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        REVIEWS_COLUMN_USERID+" INTEGER, "+
                        REVIEWS_COLUMN_SCOUNT+" TEXT, "+
                        REVIEWS_COLUMN_MESSAGE+" TEXT, "+
                        REVIEWS_COLUMN_DATE+" DATE)";


        //create theater rating table
        String create_theater_rating_table =
                "CREATE TABLE "+THEATER_RATING_TABLE+" ( "+
                        THEATER_RATING_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        THEATER_RATING_COLUMN_USERID+" INTEGER, "+
                        THEATER_RATING_COLUMN_COUNT+" INTEGER, "+
                        THEATER_RATING_COLUMN_MESSAGE+" TEXT,"+
                        THEATER_RATING_COLUMN_DATE+" DATE)";

        //create favorite table
        String create_favorite_table =
                "CREATE TABLE "+FAVORITE_TABLE+" ( "+
                        FAVORITE_COLUMN_ID+" INTEGER PRIMARY KEY, " +
                        FAVORITE_COLUMN_USERID+" INTEGER, "+
                        FAVORITE_COLUMN_MOVIE_ID+" INTEGER)";

        //create food table
        String create_food_table =
                "CREATE TABLE " + FOOD_TABLE + " ( " +
                        FOOD_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        FOOD_COLUMN_NAME + " TEXT, " +
                        FOOD_COLUMN_IMAGE + " BLOB, " +
                        FOOD_COLUMN_PRICE + " REAL)";

        //create order table
        String create_order_table =
                "CREATE TABLE " + ORDER_TABLE + " ( " +
                        ORDER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ORDER_COLUMN_DATETIME + " DATETIME, " +
                        ORDER_COLUMN_SHEET_NO + " TEXT, " +
                        ORDER_COLUMN_TOTAL_ITEMS + " INTEGER, " +
                        ORDER_COLUMN_AMOUNT + " REAL, " +
                        ORDER_COLUMN_USERID + " INTEGER)";

        //create order_food table
        String create_order_food_table =
                "CREATE TABLE " + ORDER_FOOD_TABLE + " ( " +
                        ORDER_FOOD_COLUMN_ID + " PRIMARY KEY, " +
                        ORDER_FOOD_COLUMN_PRODUCT_NAME + " TEXT, " +
                        ORDER_FOOD_COLUMN_QUANTITY + " REAL)";


        //execute tables
        try {
            db.execSQL(create_movies_table);
            db.execSQL(create_users_table);
            db.execSQL(create_admin_table);

            db.execSQL(create_booking_table);
            db.execSQL(create_discount_table);

            db.execSQL(create_reviews_table);
            db.execSQL(create_theater_rating_table);
            db.execSQL(create_favorite_table);

            db.execSQL(create_food_table);
            db.execSQL(create_order_table);
            db.execSQL(create_order_food_table);


//            Toast.makeText(context, "Table created successfully!", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
//            Toast.makeText(context, "Table creation failed!:"+ e.getMessage(), Toast.LENGTH_SHORT).show();

            //Toast.makeText(context, "Table created successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


            String drop_admin_table = "DROP TABLE IF EXISTS " + ADMIN_TABLE;
            String drop_movie_table = "DROP TABLE IF EXISTS " + MOVIE_TABLE;
            String drop_user_table = "DROP TABLE IF EXISTS " + USER_TABLE;
            String drop_booking_table = "DROP TABLE IF EXISTS " + BOOKING_TABLE;
            String drop_discount_table = "DROP TABLE IF EXISTS " + DISCOUNT_TABLE;
            String drop_reviews_table = "DROP TABLE IF EXISTS " + REVIEWS_TABLE;
            String drop_fav_table = "DROP TABLE IF EXISTS " + FAVORITE_TABLE;

            db.execSQL(drop_admin_table);
            db.execSQL(drop_movie_table);
            db.execSQL(drop_user_table);
            db.execSQL(drop_booking_table);
            db.execSQL(drop_discount_table);
            db.execSQL(drop_reviews_table);
            db.execSQL(drop_fav_table);

            onCreate(db);

    }




    public void deleteInfo(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(MOVIE_TABLE, MOVIE_COLUMN_ID + " = ? ", new String[]{id});
        db.close();
    }

    public long addMovie(String MovieName, String Duration, String Year, String Genre, String Description, String Cast, String Trailer, String StartDate, String EndDate, String Tickets) {
        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();



        //create a new map of values, where column names the keys


        ContentValues values = new ContentValues();
        values.put(MOVIE_COLUMN_NAME, MovieName);
        values.put(MOVIE_COLUMN_DURATION, Duration);
        values.put(MOVIE_COLUMN_YEAR, Year);
        values.put(MOVIE_COLUMN_GENRE, Genre);
        values.put(MOVIE_COLUMN_DESCRIPTION, Description);

        values.put(MOVIE_COLUMN_CAST, Cast);

//        try {
//            FileInputStream fs = new FileInputStream(poster);
//            byte[] imgbyte = new byte[fs.available()];
//            fs.read(imgbyte);
//
//            values.put(MOVIE_COLUMN_POSTER, imgbyte);
//
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        values.put(MOVIE_COLUMN_TRAILER, Trailer);
        values.put(MOVIE_COLUMN_START_DATE, StartDate);
        values.put(MOVIE_COLUMN_END_DATE, EndDate);
        values.put(MOVIE_COLUMN_PRICE, Tickets);



        //Insert the new raw, returning primary key value of the new raw
        return myDB.insert(MOVIE_TABLE, null, values);
    }

    public ArrayList<Model>  getAllData(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();

        //Select all info in database
        String selectQuery = "SELECT * FROM " + MOVIE_TABLE + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Get the data from columns
        if (cursor.moveToNext()) {
            do {
                @SuppressLint("Range") Model model = new Model(
                        ""+cursor.getInt(cursor.getColumnIndex(MOVIE_COLUMN_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_NAME)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_DURATION)),
                        ""+cursor.getInt(cursor.getColumnIndex(MOVIE_COLUMN_YEAR)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_GENRE)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_DESCRIPTION)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_CAST)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_TRAILER)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_START_DATE)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_END_DATE)),
                        ""+cursor.getString(cursor.getColumnIndex(MOVIE_COLUMN_PRICE))

                );
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }

    public Model getSingleMovie(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(MOVIE_TABLE, new String[]{
                MOVIE_COLUMN_ID,
                MOVIE_COLUMN_NAME,
                MOVIE_COLUMN_GENRE,
                MOVIE_COLUMN_DURATION,
                MOVIE_COLUMN_YEAR,
                MOVIE_COLUMN_DESCRIPTION,
                MOVIE_COLUMN_CAST,
                MOVIE_COLUMN_POSTER,
                MOVIE_COLUMN_COVER,
                MOVIE_COLUMN_START_DATE,
                MOVIE_COLUMN_END_DATE,
                MOVIE_COLUMN_TRAILER,
                MOVIE_COLUMN_PRICE,


        },MOVIE_COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        Model MModel;
        if (cursor != null){
            cursor.moveToFirst();
            MModel = new Model(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10)
            );
            return MModel;
        }
        return null;
    }

    public int updateInfo(Model model) {
        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();



        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();

        values.put(MOVIE_COLUMN_NAME, model.getMovieName());
        values.put(MOVIE_COLUMN_DURATION, model.getDuration());
        values.put(MOVIE_COLUMN_YEAR, model.getYear());
        values.put(MOVIE_COLUMN_GENRE, model.getGenre());
        values.put(MOVIE_COLUMN_DESCRIPTION, model.getDescription());

        //Update the new raw, returning primary key value of the new raw
        int status = myDB.update(MOVIE_TABLE, values, MOVIE_COLUMN_ID +" =? ", new String[]{String.valueOf(model.getMovieId())});
        myDB.close();
        return status;
    }

    public Boolean validateLogin(String un, String pw) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + USER_COLUMN_USERNAME + " = ? AND " + USER_COLUMN_PASSWORD + " = ? ", new String[]{un, pw});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkUsername(String un) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM "+ USER_TABLE + " WHERE " + USER_COLUMN_USERNAME + " = ? ", new String[]{un});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean insertData(String un, String email, String contact, String pw) {
        SQLiteDatabase myDB = this.getReadableDatabase();
        ContentValues val = new ContentValues();
        val.put(USER_COLUMN_USERNAME, un);
        val.put(USER_COLUMN_EMAIL, email);
        val.put(USER_COLUMN_CONTACT, contact);
        val.put(USER_COLUMN_PASSWORD, pw);

        long result = myDB.insert(USER_TABLE, null, val);
        if (result == -1)
            return false;
        else
            return true;
    }

    public bookingModel getSingleBooking(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(BOOKING_TABLE, new String[]{
                BOOKING_COLUMN_ID,
                BOOKING_COLUMN_N_TICKETS,
                BOOKING_COLUMN_BOX_TICKETS,
                BOOKING_COLUMN_DATE,
                BOOKING_COLUMN_TIME,
                BOOKING_COLUMN_AMOUNT,
                BOOKING_COLUMN_MOVIE_NAME,
        },BOOKING_COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        bookingModel bModel;
        if (cursor != null){
            cursor.moveToFirst();
            bModel = new bookingModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            );
            return bModel;
        }
        return null;
    }

    public int updateBooking(bookingModel model) {
        SQLiteDatabase db = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();


        values.put(BOOKING_COLUMN_N_TICKETS, model.getN_tickets());
        values.put(BOOKING_COLUMN_BOX_TICKETS, model.getBox_tickets());
        values.put(BOOKING_COLUMN_DATE, model.getDate());
        values.put(BOOKING_COLUMN_TIME, model.getTime());
        values.put(BOOKING_COLUMN_AMOUNT, model.getAmount());
        values.put(BOOKING_COLUMN_MOVIE_NAME, model.getMovieName());

        int status = db.update(BOOKING_TABLE, values, BOOKING_COLUMN_ID +" =? ", new String[]{String.valueOf(model.getId())});

        db.close();
        return status;
    }

    public ArrayList<bookingModel> getBookingList() {
        String sql = "select * from " + BOOKING_TABLE;
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<bookingModel> storeBooking = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String noOfTckts = cursor.getString(1);
                String noOfBoxTckts = cursor.getString(2);
                String date = cursor.getString(3);
                String time = cursor.getString(4);
                String amount = cursor.getString(5);
                String movieName = cursor.getString(6);

                storeBooking.add(new bookingModel(id,noOfTckts,noOfBoxTckts,date,time,amount, movieName));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeBooking;
    }

    public void deleteBooking(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(BOOKING_TABLE, BOOKING_COLUMN_ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

    public Bitmap getImg(int id) {

        SQLiteDatabase db = getWritableDatabase();
        Bitmap bitmap = null;

        Cursor cursor = db.rawQuery("SELECT * FROM "+MOVIE_TABLE+ " WHERE "+MOVIE_COLUMN_ID+ " =? ", new String[]{
                String.valueOf(id)
        });
        if (cursor.moveToNext()){
            byte[] image = cursor.getBlob(7);
            bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        }
        return bitmap;
    }

    public long addBooking(String noOfTckts, String noOfBoxTckts, String date, String time, String amount, String movieName) {
        //gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(BOOKING_COLUMN_N_TICKETS, noOfTckts);
        values.put(BOOKING_COLUMN_BOX_TICKETS, noOfBoxTckts);
        values.put(BOOKING_COLUMN_DATE, date);
        values.put(BOOKING_COLUMN_TIME, time);
        values.put(BOOKING_COLUMN_AMOUNT, amount);
        values.put(BOOKING_COLUMN_MOVIE_NAME, movieName);


        //Insert the new raw, returning primary key value of the new raw
        long newBooking = db.insert(BOOKING_TABLE, null, values);
        return newBooking;
    }

    public int countReviews() {
        SQLiteDatabase myDB = getReadableDatabase();
        String query = "SELECT * FROM "+ REVIEWS_TABLE;

        Cursor cursor = myDB.rawQuery(query,null);
        return cursor.getCount();
    }

    @SuppressLint("Range")
    public float countRating() {
        SQLiteDatabase myDB = getReadableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT SUM(" + REVIEWS_COLUMN_SCOUNT + ") as Total FROM " + REVIEWS_TABLE, null);

        float total = 0;
        if (cursor.moveToFirst()) {

            total = cursor.getInt(cursor.getColumnIndex("Total"));// get final total
        }
        return total;
    }

    public ArrayList<Reviews> getAllReviews(String orderBy) {
        ArrayList<Reviews> arrayList = new ArrayList<>();
        //Select all info in database
        String selectQuery = "SELECT * FROM " + REVIEWS_TABLE + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //Get the data from columns
        if (cursor.moveToNext()) {
            do {
                @SuppressLint("Range") Reviews model = new Reviews(
                        ""+cursor.getInt(cursor.getColumnIndex(REVIEWS_COLUMN_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(REVIEWS_COLUMN_MESSAGE)),
                        ""+cursor.getString(cursor.getColumnIndex(REVIEWS_COLUMN_DATE)),
                        ""+cursor.getString(cursor.getColumnIndex(REVIEWS_COLUMN_SCOUNT))

                );
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }

    public long addReview(String rev, String date, String rt) {
        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(REVIEWS_COLUMN_MESSAGE, rev);
        values.put(REVIEWS_COLUMN_DATE, date);
        values.put(REVIEWS_COLUMN_SCOUNT, rt);

        //Insert the new raw, returning primary key value of the new raw
        long newReview = myDB.insert(REVIEWS_TABLE, null, values);
        return newReview;
    }

    public int updateReview(Reviews model) {
        SQLiteDatabase db = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();

        values.put(REVIEWS_COLUMN_ID, model.getId());
        values.put(REVIEWS_COLUMN_SCOUNT, model.getScount());
        values.put(REVIEWS_COLUMN_DATE, model.getDate());
        values.put(REVIEWS_COLUMN_MESSAGE, model.getReview());


        int status = db.update(REVIEWS_TABLE, values, REVIEWS_COLUMN_ID +" =? ", new String[]{String.valueOf(model.getId())});

        db.close();
        return status;
    }

    public void deleteReview(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(REVIEWS_TABLE,"revID =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public long addTheterRev(String trev, String rt, String date) {
        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(THEATER_RATING_COLUMN_MESSAGE, trev);
        values.put(THEATER_RATING_COLUMN_COUNT, rt);
        values.put(THEATER_RATING_COLUMN_DATE, date);

        //Insert the new raw, returning primary key value of the new raw
        long newTReview = myDB.insert(THEATER_RATING_TABLE, null, values);
        return newTReview;
    }





    //food section
    public long addFood(String foodName, String price) {
        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(FOOD_COLUMN_NAME, foodName);
        values.put(FOOD_COLUMN_PRICE, price);

        //Insert the new raw, returning primary key value of the new raw
        long newFood = myDB.insert(FOOD_TABLE, null, values);
        return newFood;
    }

    public FoodModelClass getSingleFood(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(FOOD_TABLE, new String[]{
                FOOD_COLUMN_ID,
                FOOD_COLUMN_NAME,
                FOOD_COLUMN_IMAGE,
                FOOD_COLUMN_PRICE,

        },FOOD_COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        FoodModelClass FModel;
        if (cursor != null){
            cursor.moveToFirst();
            FModel = new FoodModelClass(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return FModel;
        }
        return null;
    }

    public int countFoodList() {

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + FOOD_TABLE;

        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();

    }

    public ArrayList<FoodModelClass> getAllFoodData(String orderBy) {
        ArrayList<FoodModelClass> arrayList = new ArrayList<>();

        //Select all info in database
        String selectQuery = "SELECT * FROM " + FOOD_TABLE + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Get the data from columns
        if (cursor.moveToNext()) {
            do {
                @SuppressLint("Range") FoodModelClass model = new FoodModelClass(
                        "" + cursor.getInt(cursor.getColumnIndex(FOOD_COLUMN_ID)),
                        "" + cursor.getString(cursor.getColumnIndex(FOOD_COLUMN_NAME)),
                        "" + cursor.getString(cursor.getColumnIndex(FOOD_COLUMN_PRICE))
                );
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }



    //Update Data

    public int updateInfo(FoodModelClass model){

        //gets the data repository in write mode
        SQLiteDatabase myDB = getWritableDatabase();

        //create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(FOOD_COLUMN_NAME, model.getFoodName());
        values.put(FOOD_COLUMN_PRICE, model.getFoodPrice());

        //Update the new raw, returning primary key value of the new raw
        int status = myDB.update(FOOD_TABLE, values, FOOD_COLUMN_ID +" =? ", new String[]{String.valueOf(model.getFoodID())});
        myDB.close();
        return status;

    }

    //Delete a food

    public void deletefoodInfo (String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(FOOD_TABLE, FOOD_COLUMN_ID + " = ? ", new String[]{id});
        db.close();
    }
}
