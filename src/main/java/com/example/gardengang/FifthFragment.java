package com.example.gardengang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gardengang.databinding.FragmentFifthBinding;

public class FifthFragment extends Fragment {

    private FragmentFifthBinding binding;
    Button b1;
    EditText ed1,ed2;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFifthBinding.inflate(inflater, container, false);

        String un = SharedViewModel.getUsername();
        String pass = SharedViewModel.getPassword();

        EditText ed1 =  binding.getRoot().findViewById(R.id.edittext_fifth1);
        EditText ed2 =  binding.getRoot().findViewById(R.id.edittext_fifth2);

        ed1.setText(un);
        ed2.setText(pass);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1 = (Button)getView().findViewById(R.id.buttonSet);
        ed1 = (EditText)getView().findViewById(R.id.edittext_fifth1);
        ed2 = (EditText)getView().findViewById(R.id.edittext_fifth2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = ed1.getText().toString().toLowerCase();
                String second = ed2.getText().toString().toLowerCase();
                SharedViewModel.setUsername(first);
                SharedViewModel.setPassword(second);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

