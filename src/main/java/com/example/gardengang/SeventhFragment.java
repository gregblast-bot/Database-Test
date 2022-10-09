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

import com.example.gardengang.databinding.FragmentSeventhBinding;

public class SeventhFragment extends Fragment {

    private FragmentSeventhBinding binding;
    GraphView graphView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSeventhBinding.inflate(inflater, container, false);

        // Initializing our graph view.
        graphView = binding.getRoot().findViewById(R.id.idGraphView);

        long[] graphMoist = SharedViewModel.getGraphMoist();
        int count = SharedViewModel.getCount();
        DataPoint[] dp = new DataPoint[count];
        // Adding each point on our x and y axis.
        for(int i = 0; i < count; i++){
            dp[i] = new DataPoint(i, graphMoist[i]);
        }

        // Adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

        // Title for our graph view.
        graphView.setTitle("Average Moisture");

        // Text color to our graph view.
        graphView.setTitleColor(R.color.purple_200);

        // Set bounds
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(count);
        graphView.getViewport().setMinY(0);
        graphView.getViewport().setMaxY(100);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);

        // Title text size.
        graphView.setTitleTextSize(30);

        // Data series to our graph view.
        graphView.addSeries(series);

        SeventhFragment rsum = new SeventhFragment();
        getFragmentManager().beginTransaction().remove(rsum).commit();
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
