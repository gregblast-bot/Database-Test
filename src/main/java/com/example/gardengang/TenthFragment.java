package com.example.gardengang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gardengang.databinding.FragmentTenthBinding;

public class TenthFragment extends Fragment {

    private FragmentTenthBinding binding;
    GraphView graphView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTenthBinding.inflate(inflater, container, false);

        // Initializing our graph view.
        graphView = binding.getRoot().findViewById(R.id.idGraphView);

        long[] graphpH = SharedViewModel.getGraphpH();
        int count = SharedViewModel.getCount();
        DataPoint[] dp = new DataPoint[count];
        // Adding each point on our x and y axis.
        for(int i = 0; i < count; i++){
            dp[i] = new DataPoint(i, graphpH[i]);
        }

        // Adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

        // Title for our graph view.
        graphView.setTitle("Average pH");

        // Text color to our graph view.
        graphView.setTitleColor(R.color.purple_200);

        // Set bounds
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(120);
        graphView.getViewport().setMinY(0);
        graphView.getViewport().setMaxY(15);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);

        // Title text size.
        graphView.setTitleTextSize(30);

        // Data series to our graph view.
        graphView.addSeries(series);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}