package com.example.gardengang;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseActivity extends AppCompatActivity {

    static DatabaseAdapter databaseAdapter;
    DatabaseAdapter.DatabaseHelper helper;
    SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        ((DatabaseActivity)this).getSupportActionBar().setTitle("Database");
        PreCreateDB.copyDB(this);
        databaseAdapter = new DatabaseAdapter(this);
        ListView lvContact = findViewById(R.id.lvContact);
        final SimpleCursorAdapter simpleCursorAdapter = databaseAdapter.populateListViewFromDB();
        lvContact.setAdapter(simpleCursorAdapter);

        simpleCursorAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                String partialValue = constraint.toString();
                return databaseAdapter.getAllSuggestedValues(partialValue);

            }
        });

        EditText theFilter = findViewById(R.id.searchFilter);
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                simpleCursorAdapter.getFilter().filter(s.toString());
                simpleCursorAdapter.notifyDataSetChanged();
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
                String common_name = cursor.getString(1);
                String latin_name = cursor.getString(2);
                String family = cursor.getString(3);
                String habitat = cursor.getString(4);
                String habit = cursor.getString(5);
                String hardiness = cursor.getString(6);
                String soil = cursor.getString(7);
                String shade = cursor.getString(8);
                String moisture = cursor.getString(9);
                String pH = cursor.getString(10);
                String medicinal = cursor.getString(11);
                Intent intent = new Intent(DatabaseActivity.this, AddPlantActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("Common_name", common_name);
                intent.putExtra("Latin_name", latin_name);
                intent.putExtra("Family", family);
                intent.putExtra("Habitat", habitat);
                intent.putExtra("Habit", habit);
                intent.putExtra("Hardiness", hardiness);
                intent.putExtra("Soil", soil);
                intent.putExtra("Shade", shade);
                intent.putExtra("Moisture", moisture);
                intent.putExtra("pH", pH);
                intent.putExtra("Medicinal", medicinal);
                startActivity(intent);
                finish();
                Toast.makeText(DatabaseActivity.this, common_name, Toast.LENGTH_LONG).show();
            }
        });
    }
}
