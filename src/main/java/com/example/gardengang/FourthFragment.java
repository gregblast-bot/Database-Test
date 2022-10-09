package com.example.gardengang;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gardengang.databinding.FragmentFourthBinding;

public class FourthFragment extends Fragment {

    private FragmentFourthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view =  inflater.inflate(R.layout.fragment_fourth, container, false);
        //binding = FragmentFourthBinding.inflate(inflater, container, false);
        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText e1_data = view.findViewById(R.id.edittext_first4);
        final Button butt = view.findViewById(R.id.btnQuery);

        e1_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String common_name = e1_data.getText().toString().toLowerCase();
               //String latin_name = e1_data.getText().toString().toLowerCase();
            }
        });

//        butt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatabaseActivity databitch = new DatabaseActivity();
//                // Move to index in the database
//                Intent intent = new Intent(getActivity(), DatabaseActivity.class);
//                String query = intent.getStringExtra(SearchManager.QUERY);
//                Cursor c = databitch.getWordMatches(query, null);
//                //process Cursor and display results
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
