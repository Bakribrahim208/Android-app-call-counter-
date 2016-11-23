package com.example.usersfiles.contact_project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.usersfiles.contact_project.Models.MainData;

import java.util.ArrayList;

/**
 * Created by UsersFiles on 5/8/2016.
 */
public class DbConnection extends SQLiteOpenHelper {

    public static final String name = "Phone.db";
    public static final int version = 1;
    public DbConnection(Context con) {
        super(con, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQl_phoneTable =
                "CREATE TABLE " + Move_data.TABLE_NAME +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL," +
                        Move_data.COLUMN_ID + "  INTEGER," +
                        Move_data.COLUMN_Name + " TEXT," +
                        Move_data.COLUMN_Phone + "  TEXT, " +
                        Move_data.COLUMN_income + "  TEXT," +
                          Move_data.COLUMN_outCome + "  TEXT)";



        sqLiteDatabase.execSQL(SQl_phoneTable);

     }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // sqLiteDatabase.execSQL("Drop TABLE if   exists"+Move_data.TABLE_NAME);
        // onCreate(sqLiteDatabase);

    }

    public void insert_data(
                            String name,
                            String phone,
                            String income,
                            String outcome) {
        SQLiteDatabase dp = this.getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put(Move_data.COLUMN_Name, name);
        data.put(Move_data.COLUMN_Phone, phone);
        data.put(Move_data.COLUMN_income, income);
        data.put(Move_data.COLUMN_outCome, outcome);
        dp.insert(Move_data.TABLE_NAME, null, data);
    }

    //using this fucntion to get   movies when no internet connection
    public ArrayList<MainData> ALLRecords(  ) {

        ArrayList<MainData> Movees = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String table;

          table="select * from "+ Move_data.TABLE_NAME;


        Cursor dataset = db.rawQuery(table, null);
        dataset.moveToFirst();
        while (dataset.isAfterLast() == false) {
            //dataset.getString(dataset.getColumnIndex("move_title")
            MainData entry = new MainData(
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Name)),
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Phone)),
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_income)),
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_outCome)) );
            Movees.add(entry);
            dataset.moveToNext();
        }
        return Movees;


    }
    public ArrayList<MainData> ALLRecords(String quary  ) {

        ArrayList<MainData> Movees = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String table;

        table="select * from "+ Move_data.TABLE_NAME;


        Cursor dataset = db.rawQuery(quary, null);
        dataset.moveToFirst();
        while (dataset.isAfterLast() == false) {
            //dataset.getString(dataset.getColumnIndex("move_title")
            MainData entry = new MainData(
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Name)),
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Phone)),
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_income)),
                    dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_outCome)) );
            Movees.add(entry);
            dataset.moveToNext();
        }
        return Movees;


    }



//using this function to get favourite movies
  /*  public ArrayList<MainData> ALLRecords_id(ArrayList<favouriteMove> moveis) {

        ArrayList<MainData> Movees = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String where_str="";
        for ( int i=0;i<moveis.size();i++)
        {
            Cursor dataset = db.rawQuery("select * from Top_Rated WHERE "+ Move_data.COLUMN_ID+"="+moveis.get(i).getId(), null);

            dataset.moveToFirst();
            while (dataset.isAfterLast() == false) {
                //dataset.getString(dataset.getColumnIndex("move_title")
                MainData entry = new MainData(dataset.getInt(dataset.getColumnIndex(Move_data.COLUMN_ID)),
                        dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Title)),
                        dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Date)),
                        dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_moveimgae)),
                        dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Date)),
                        dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_backdrop_path)),
                        dataset.getString(dataset.getColumnIndex(Move_data.COLUMN_Rate)));
                Movees.add(entry);
                dataset.moveToNext();
            }



        }
        return Movees;
    }*/
    public static final class Move_data implements BaseColumns {

        public static final String TABLE_NAME = "Names_LIST";
        public static final String COLUMN_ID = "ID_NAME";
        public static final String COLUMN_Name = "Name";
        public static final String COLUMN_Phone = "Phone";
        public static final String COLUMN_income = "income";
        public static final String COLUMN_outCome = "outCome";





    }


}
