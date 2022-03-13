package com.sandipbhattacharya.databasedemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseAdapter databaseAdapter;
    RecyclerView rvPrograms;
    ContactsAdapter contactsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreCreateDB.copyDB(this);
        databaseAdapter = new DatabaseAdapter(this);
        contactsList = databaseAdapter.getAllContacts();
        rvPrograms = findViewById(R.id.rvPrograms);
        rvPrograms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        contactsAdapter = new ContactsAdapter(this, contactsList, rvPrograms);
        rvPrograms.setAdapter(contactsAdapter);
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
//            String name = cursor.getString(1);
//            String email = cursor.getString(2);
//            Intent intent = new Intent(MainActivity.this, EditContactActivity.class);
//            intent.putExtra("id", id);
//            intent.putExtra("name", name);
//            intent.putExtra("email", email);
//            startActivity(intent);
//            finish();
//            Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
//        }
    }
}