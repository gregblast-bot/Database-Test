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

import com.example.gardengang.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1 = (Button)getView().findViewById(R.id.button);
        ed1 = (EditText)getView().findViewById(R.id.editText);
        ed2 = (EditText)getView().findViewById(R.id.editText2);

        b2 = (Button)getView().findViewById(R.id.button2);
        tx1 = (TextView)getView().findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().toLowerCase().equals(SharedViewModel.getUsername()) &&
                        ed2.getText().toString().toLowerCase().equals(SharedViewModel.getPassword())) {
//                    Toast.makeText(getActivity().getApplicationContext(),
//                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}