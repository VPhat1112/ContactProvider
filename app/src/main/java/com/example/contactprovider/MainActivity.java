package com.example.contactprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;

import android.content.ContentResolver;
import android.content.pm.PackageManager;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button contact;
    List<Item> list = new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void btnGetContact(View v){
        getPhoneContact();
    }
    public void getPhoneContact(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},0);
        }
        ContentResolver contentResolver= getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor= contentResolver.query(uri,null,null,null,null);

        Log.i("CONTACT_PROVIDER_DEMO","TOTAL # of Contacts ::: "+ Integer.toString(cursor.getCount()));
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()){
                 String contactName= cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                 String contactNumber= cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                Log.i("CONTACT_PROVIDER_DEMO","Contact Name ::: "+ contactName +"   Ph # :::"+ contactNumber);
                ListView listView = findViewById(R.id.select_dialog_listview);
                Item item1 = new Item(contactName, contactNumber);
                list.add(item1);
                adapter=new Adapter(this, list);
                listView.setAdapter(adapter);
            }
        }
    }
}