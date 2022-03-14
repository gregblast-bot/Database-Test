package com.sandipbhattacharya.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    TextView tvName;

    long id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        String family = getIntent().getExtras().getString("family");
        String common_name = getIntent().getExtras().getString("common name");
        String latin_name = getIntent().getExtras().getString("latin name");
        tvName = findViewById(R.id.tvName);
        tvName.setText(common_name);
        
       btnGet.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {
                Snackbar.make(view, "Addding a plant to your garden!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//     public void editContact(View view){
//         String email = etEmail.getText().toString();
//         //MainActivity.DatabaseAdapter.updateEmailNew(id, email);
//         startActivity(new Intent(EditContactActivity.this, MainActivity.class));
//         finish();
//     }
}
