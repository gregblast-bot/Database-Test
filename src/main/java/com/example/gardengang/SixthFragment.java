package com.example.gardengang;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gardengang.databinding.FragmentSixthBinding;

public class SixthFragment extends Fragment {

    private FragmentSixthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSixthBinding.inflate(inflater, container, false);
        String shum = "    " + SharedViewModel.getHum() + "    ";
        String stempC1 = "    " + SharedViewModel.getTempC1() + "    ";
        String stempF1 = "    " + SharedViewModel.getTempF1() + "    ";
        String smoist1 = "    " + SharedViewModel.getMoist1() + "    ";
        String spH1 = "    " + SharedViewModel.getpH1() + "    ";
        String sex1 = "    " + SharedViewModel.getEx1() + "    ";
        String stempC2 = "    " + SharedViewModel.getTempC2() + "    ";
        String stempF2 = "    " + SharedViewModel.getTempF2() + "    ";
        String smoist2 = "    " + SharedViewModel.getMoist2() + "    ";
        String spH2 = "    " + SharedViewModel.getpH2() + "    ";
        String sex2 = "    " + SharedViewModel.getEx2() + "    ";

        String stempCavg = "    " + SharedViewModel.getTempCavg() + "    ";
        String stempFavg = "    " + SharedViewModel.getTempFavg() + "    ";
        String smoistavg = "    " + SharedViewModel.getMavg() + "    ";
        String spHavg = "    " + SharedViewModel.getPavg() + "    ";

        TextView hum1 =  binding.getRoot().findViewById(R.id.textView83);
        TextView hum2 = binding.getRoot().findViewById(R.id.textView98);
        TextView humavg = binding.getRoot().findViewById(R.id.textView113);
        TextView tempC1 = binding.getRoot().findViewById(R.id.textView81);
        TextView tempF1 = binding.getRoot().findViewById(R.id.textView79);
        TextView moist1 = binding.getRoot().findViewById(R.id.textView85);
        TextView pH1 = binding.getRoot().findViewById(R.id.textView89);
        TextView ex1 = binding.getRoot().findViewById(R.id.textView87);
        TextView tempC2 = binding.getRoot().findViewById(R.id.textView96);
        TextView tempF2 = binding.getRoot().findViewById(R.id.textView94);
        TextView moist2 = binding.getRoot().findViewById(R.id.textView100);
        TextView pH2 = binding.getRoot().findViewById(R.id.textView104);
        TextView ex2 = binding.getRoot().findViewById(R.id.textView102);
        TextView tempCavg = binding.getRoot().findViewById(R.id.textView111);
        TextView tempFavg = binding.getRoot().findViewById(R.id.textView109);
        TextView moistavg = binding.getRoot().findViewById(R.id.textView115);
        TextView pHavg = binding.getRoot().findViewById(R.id.textView119);
        TextView exavg = binding.getRoot().findViewById(R.id.textView117);

        hum1.setText(shum);
        hum2.setText(shum);
        humavg.setText(shum);
        tempC1.setText(stempC1);
        tempF1.setText(stempF1);
        moist1.setText(smoist1);
        pH1.setText(spH1);
        ex1.setText(sex1);
        tempC2.setText(stempC2);
        tempF2.setText(stempF2);
        moist2.setText(smoist2);
        pH2.setText(spH2);
        ex2.setText(sex2);
        tempCavg.setText(stempCavg);
        tempFavg.setText(stempFavg);
        moistavg.setText(smoistavg);
        pHavg.setText(spHavg);
        exavg.setText(sex1);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SixthFragment.this)
                        .navigate(R.id.action_SixthFragment_to_SeventhFragment);
            }
        });
        binding.buttonSecond6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SixthFragment.this)
                        .navigate(R.id.action_SixthFragment_to_TenthFragment);
            }
        });
        binding.buttonThird6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SixthFragment.this)
                        .navigate(R.id.action_SixthFragment_to_EleventhFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}