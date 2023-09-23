package com.example.covoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button _btnInsert,_btnUpdate;
    EditText  _txtDATE, _txtTELEPHONE , _txtDEPART , _txtARRIVE , _txtNBREPASSAGE;
    SQLiteOpenHelper OpenHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnInsert=(Button)findViewById(R.id.btnInsert);
        _btnUpdate=(Button)findViewById(R.id.btnUpdate);
        _txtTELEPHONE=(EditText)findViewById(R.id.txtTel);
        _txtDATE=(EditText)findViewById(R.id.txtDate);
        _txtDEPART=(EditText)findViewById(R.id.txtDepart);
        _txtARRIVE=(EditText)findViewById(R.id.txtArr);
        _txtNBREPASSAGE=(EditText)findViewById(R.id.txtNbr);
        OpenHelper=new DatabaseHelper(this);
        _btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telephone= _txtTELEPHONE.getText().toString();
                String date= _txtDATE.getText().toString();
                String depart= _txtDEPART.getText().toString();
                String arrive= _txtARRIVE.getText().toString();
                String nbrepassage = _txtNBREPASSAGE.getText().toString();
                db= OpenHelper.getWritableDatabase();
                insertData(telephone, date, depart, arrive,nbrepassage);
                Toast.makeText(getApplicationContext(), "INSERTED SUCCESSFULLY", Toast.LENGTH_LONG).show();

            }
        });
        _btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date= _txtDATE.getText().toString();
                String depart= _txtDEPART.getText().toString();
                String arrive= _txtARRIVE.getText().toString();
                String nbrepassage = _txtNBREPASSAGE.getText().toString();
                db= OpenHelper.getWritableDatabase();
                updateData(date, depart, arrive,nbrepassage);
                Toast.makeText(getApplicationContext(), "UPDATED SUCCESSFULLY", Toast.LENGTH_LONG).show();

            }
        });
    }
    public void insertData(String telephone, String date, String depart, String arrive, String nbrepassage){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLS_1, telephone);
        contentValues.put(DatabaseHelper.COLS_2, date);
        contentValues.put(DatabaseHelper.COLS_3, depart);
        contentValues.put(DatabaseHelper.COLS_4, arrive);
        contentValues.put(DatabaseHelper.COLS_5, nbrepassage);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
    public boolean updateData( String date, String depart, String arrive, String nbrepassage){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLS_2, date);
        contentValues.put(DatabaseHelper.COLS_3, depart);
        contentValues.put(DatabaseHelper.COLS_4, arrive);
        contentValues.put(DatabaseHelper.COLS_5, nbrepassage);
        String id = _txtTELEPHONE.getText().toString();
        return db.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COLS_1 + "=?", new String[]{id})>0;

    }

}