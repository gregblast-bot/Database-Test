package com.example.gardengang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gardengang.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    int tempInt1, hardyInt1, hardyInt2, hardyInt3, hardyInt4, hardyInt5;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);

        String name1 = SharedViewModel.getName1();
        String name2 = SharedViewModel.getName2();
        String name3 = SharedViewModel.getName3();
        String name4 = SharedViewModel.getName4();
        String name5 = SharedViewModel.getName5();

        String hardy1 = SharedViewModel.getHardy1();
        String hardy2 = SharedViewModel.getHardy2();
        String hardy3 = SharedViewModel.getHardy3();
        String hardy4 = SharedViewModel.getHardy4();
        String hardy5 = SharedViewModel.getHardy5();
        String temp1 = SharedViewModel.getTempCavg();

        String shade1 = SharedViewModel.getShade1();
        String shade2 = SharedViewModel.getShade2();
        String shade3 = SharedViewModel.getShade3();
        String shade4 = SharedViewModel.getShade4();
        String shade5 = SharedViewModel.getShade5();
        String ex1 = SharedViewModel.getEx1();
        String ex2 = SharedViewModel.getEx2();

        String moist1 = SharedViewModel.getMoisture1();
        String moist2 = SharedViewModel.getMoisture2();
        String moist3 = SharedViewModel.getMoisture3();
        String moist4 = SharedViewModel.getMoisture4();
        String moist5 = SharedViewModel.getMoisture5();
        String moisture1 = SharedViewModel.getMoist1();
        String moisture2 = SharedViewModel.getMoist2();

        String pHp1 = SharedViewModel.getpHp1();
        String pHp2 = SharedViewModel.getpHp2();
        String pHp3 = SharedViewModel.getpHp3();
        String pHp4 = SharedViewModel.getpHp4();
        String pHp5 = SharedViewModel.getpHp5();
        String pH1 = SharedViewModel.getpH1();
        String pH2 = SharedViewModel.getpH2();

        TextView num1 =  binding.getRoot().findViewById(R.id.plant1);
        TextView num2 =  binding.getRoot().findViewById(R.id.plant2);
        TextView num3 =  binding.getRoot().findViewById(R.id.plant3);
        TextView num4 =  binding.getRoot().findViewById(R.id.plant4);
        TextView num5 =  binding.getRoot().findViewById(R.id.plant5);

        TextView op1 = binding.getRoot().findViewById(R.id.optimal1);
        TextView subop1 = binding.getRoot().findViewById(R.id.suboptimal1);
        TextView crit1 = binding.getRoot().findViewById(R.id.critical1);

        TextView op2 = binding.getRoot().findViewById(R.id.optimal2);
        TextView subop2 = binding.getRoot().findViewById(R.id.suboptimal2);
        TextView crit2 = binding.getRoot().findViewById(R.id.critical2);

        TextView op3 = binding.getRoot().findViewById(R.id.optimal3);
        TextView subop3 = binding.getRoot().findViewById(R.id.suboptimal3);
        TextView crit3 = binding.getRoot().findViewById(R.id.critical3);

        TextView op4 = binding.getRoot().findViewById(R.id.optimal4);
        TextView subop4 = binding.getRoot().findViewById(R.id.suboptimal4);
        TextView crit4 = binding.getRoot().findViewById(R.id.critical4);

        TextView op5 = binding.getRoot().findViewById(R.id.optimal5);
        TextView subop5 = binding.getRoot().findViewById(R.id.suboptimal5);
        TextView crit5 = binding.getRoot().findViewById(R.id.critical5);

        // hardiness == 15 min 37C
        // hardiness == 14 min 35C
        // hardiness == 13 min 32C
        // hardiness == 12 min 30C
        // hardiness == 11 min 27C
        // hardiness == 10 min 25C
        // hardiness == 9 min 20C
        // hardiness == 8 min 17C
        // hardiness == 7 min 15C
        // hardiness == 6 min 12C
        // hardiness == 5 min 10C
        // hardiness == 4 min 0C
        // hardiness == 3 min -5C
        // hardiness == 2 min -15C
        // hardiness == 1 min

        if(temp1 == "None"){
            tempInt1 = 0;
        }
        else{
            tempInt1 = Integer.parseInt(temp1);
        }

        if(hardy1 == "" || hardy1 == null){
            hardyInt1 = 0;
        }
        else{
            hardyInt1 = Integer.parseInt(hardy1);
        }

        if(hardy2 == "" || hardy2 == null){
            hardyInt2 = 0;
        }
        else{
            hardyInt2 = Integer.parseInt(hardy2);
        }

        if(hardy3 == "" || hardy3 == null){
            hardyInt3 = 0;
        }
        else{
            hardyInt3 = Integer.parseInt(hardy3);
        }

        if(hardy4 == "" || hardy4 == null){
            hardyInt4 = 0;
        }
        else{
            hardyInt4 = Integer.parseInt(hardy4);
        }

        if(hardy5 == "" || hardy5 == null){
            hardyInt5 = 0;
        }
        else{
            hardyInt5 = Integer.parseInt(hardy5);
        }

        if((hardyInt1 == 1) && (tempInt1 < 32) && (tempInt1 > -20)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 1) && (tempInt1 < -20) && (tempInt1 > -25)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 1) && (tempInt1 < -25)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 2) && (tempInt1 < 32) && (tempInt1 > -15)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 2) && (tempInt1 < -15) && (tempInt1 > -20)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 2) && (tempInt1 < -20)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 3) && (tempInt1 < 32) && (tempInt1 > -5)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 3) && (tempInt1 < -5) && (tempInt1 > -10)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 3) && (tempInt1 < -10)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 4) && (tempInt1 < 32) && (tempInt1 > 0)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 4) && (tempInt1 < 0) && (tempInt1 > -5)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);

        }
        if((hardyInt1 == 4) && (tempInt1 < -5)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 5) && (tempInt1 < 32) && (tempInt1 > 10)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 5) && (tempInt1 < 10) && (tempInt1 > 5)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);

        }
        if((hardyInt1 == 5) && (tempInt1 < 5)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 6) && (tempInt1 < 32) && (tempInt1 > 12)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 6) && (tempInt1 < 12) && (tempInt1 > 6)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 6) && (tempInt1 < 6)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 7) && (tempInt1 < 32) && (tempInt1 > 15)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 7) && (tempInt1 < 15) && (tempInt1 > 7)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 7) && (tempInt1 < 7)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 8) && (tempInt1 < 32) && (tempInt1 > 17)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 8) && (tempInt1 < 17) && (tempInt1 > 8)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);

        }
        if((hardyInt1 == 8) && (tempInt1 < 8)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 9) && (tempInt1 < 32) && (tempInt1 > 20)) {
                op1.setVisibility(View.VISIBLE);
                op1.setBackgroundColor(Color.GREEN);
                subop1.setVisibility(View.INVISIBLE);
                crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 9) && (tempInt1 < 20) && (tempInt1 > 9)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);

        }
        if((hardyInt1 == 9) && (tempInt1 < 9)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 10) && (tempInt1 < 32) && (tempInt1 > 25)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 10) && (tempInt1 < 25) && (tempInt1 > 10)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 10) && (tempInt1 < 10)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 11) && (tempInt1 < 32) && (tempInt1 > 27)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 11) && (tempInt1 < 27) && (tempInt1 > 11)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 11) && (tempInt1 < 11)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 12) && (tempInt1 < 33) && (tempInt1 > 27)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 12) && (tempInt1 < 27) && (tempInt1 > 12)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 12) && (tempInt1 < 12)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 13) && (tempInt1 < 34) && (tempInt1 > 27)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 13) && (tempInt1 < 27) && (tempInt1 > 13)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 13) && (tempInt1 < 13)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 14) && (tempInt1 < 35) && (tempInt1 > 27)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 14) && (tempInt1 < 27) && (tempInt1 > 14)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 14) && (tempInt1 < 14)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }

        if((hardyInt1 == 15) && (tempInt1 < 36) && (tempInt1 > 27)) {
            op1.setVisibility(View.VISIBLE);
            op1.setBackgroundColor(Color.GREEN);
            subop1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 15) && (tempInt1 < 27) && (tempInt1 > 15)){
            subop1.setVisibility(View.VISIBLE);
            subop1.setBackgroundColor(Color.YELLOW);
            op1.setVisibility(View.INVISIBLE);
            crit1.setVisibility(View.INVISIBLE);
        }
        if((hardyInt1 == 15) && (tempInt1 < 15)){
            crit1.setVisibility(View.VISIBLE);
            crit1.setBackgroundColor(Color.RED);
            op1.setVisibility(View.INVISIBLE);
            subop1.setVisibility(View.INVISIBLE);
        }


        if((hardyInt2 == 1) && (tempInt1 < 32) && (tempInt1 > -20)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 1) && (tempInt1 < -20) && (tempInt1 > -25)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 1) && (tempInt1 < -25)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 2) && (tempInt1 < 32) && (tempInt1 > -15)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 2) && (tempInt1 < -15) && (tempInt1 > -20)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 2) && (tempInt1 < -20)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 3) && (tempInt1 < 32) && (tempInt1 > -5)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 3) && (tempInt1 < -5) && (tempInt1 > -10)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 3) && (tempInt1 < -10)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 4) && (tempInt1 < 32) && (tempInt1 > 0)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 4) && (tempInt1 < 0) && (tempInt1 > -5)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 4) && (tempInt1 < -5)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 5) && (tempInt1 < 32) && (tempInt1 > 10)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 5) && (tempInt1 < 10) && (tempInt1 > 5)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 5) && (tempInt1 < 5)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 6) && (tempInt1 < 32) && (tempInt1 > 12)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 6) && (tempInt1 < 12) && (tempInt1 > 6)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 6) && (tempInt1 < 6)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 7) && (tempInt1 < 32) && (tempInt1 > 15)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 7) && (tempInt1 < 15) && (tempInt1 > 7)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 7) && (tempInt1 < 7)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 8) && (tempInt1 < 32) && (tempInt1 > 17)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 8) && (tempInt1 < 17) && (tempInt1 > 8)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 8) && (tempInt1 < 8)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 9) && (tempInt1 < 32) && (tempInt1 > 20)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 9) && (tempInt1 < 20) && (tempInt1 > 9)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 9) && (tempInt1 < 9)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 10) && (tempInt1 < 32) && (tempInt1 > 25)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 10) && (tempInt1 < 25) && (tempInt1 > 10)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 10) && (tempInt1 < 10)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 11) && (tempInt1 < 32) && (tempInt1 > 27)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 11) && (tempInt1 < 27) && (tempInt1 > 11)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 11) && (tempInt1 < 11)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 12) && (tempInt1 < 33) && (tempInt1 > 27)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 12) && (tempInt1 < 27) && (tempInt1 > 12)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);

        }
        if((hardyInt2 == 12) && (tempInt1 < 12)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 13) && (tempInt1 < 34) && (tempInt1 > 27)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 13) && (tempInt1 < 27) && (tempInt1 > 13)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 13) && (tempInt1 < 13)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 14) && (tempInt1 < 35) && (tempInt1 > 27)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 14) && (tempInt1 < 27) && (tempInt1 > 14)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 14) && (tempInt1 < 14)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }

        if((hardyInt2 == 15) && (tempInt1 < 36) && (tempInt1 > 27)) {
            op2.setVisibility(View.VISIBLE);
            op2.setBackgroundColor(Color.GREEN);
            subop2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);
        }
        if((hardyInt2 == 15) && (tempInt1 < 27) && (tempInt1 > 15)){
            subop2.setVisibility(View.VISIBLE);
            subop2.setBackgroundColor(Color.YELLOW);
            op2.setVisibility(View.INVISIBLE);
            crit2.setVisibility(View.INVISIBLE);

        }
        if((hardyInt2 == 15) && (tempInt1 < 15)){
            crit2.setVisibility(View.VISIBLE);
            crit2.setBackgroundColor(Color.RED);
            op2.setVisibility(View.INVISIBLE);
            subop2.setVisibility(View.INVISIBLE);
        }


        if((hardyInt3 == 1) && (tempInt1 < 32) && (tempInt1 > -20)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 1) && (tempInt1 < -20) && (tempInt1 > -25)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 1) && (tempInt1 < -25)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 2) && (tempInt1 < 32) && (tempInt1 > -15)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 2) && (tempInt1 < -15) && (tempInt1 > -20)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 2) && (tempInt1 < -20)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 3) && (tempInt1 < 32) && (tempInt1 > -5)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 3) && (tempInt1 < -5) && (tempInt1 > -10)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 3) && (tempInt1 < -10)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 4) && (tempInt1 < 32) && (tempInt1 > 0)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 4) && (tempInt1 < 0) && (tempInt1 > -5)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 4) && (tempInt1 < -5)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 5) && (tempInt1 < 32) && (tempInt1 > 10)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 5) && (tempInt1 < 10) && (tempInt1 > 5)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 5) && (tempInt1 < 5)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 6) && (tempInt1 < 32) && (tempInt1 > 12)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 6) && (tempInt1 < 12) && (tempInt1 > 6)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 6) && (tempInt1 < 6)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 7) && (tempInt1 < 32) && (tempInt1 > 15)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 7) && (tempInt1 < 15) && (tempInt1 > 7)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 7) && (tempInt1 < 7)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 8) && (tempInt1 < 32) && (tempInt1 > 17)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 8) && (tempInt1 < 17) && (tempInt1 > 8)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 8) && (tempInt1 < 8)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 9) && (tempInt1 < 32) && (tempInt1 > 20)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 9) && (tempInt1 < 20) && (tempInt1 > 9)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 9) && (tempInt1 < 9)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 10) && (tempInt1 < 32) && (tempInt1 > 25)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 10) && (tempInt1 < 25) && (tempInt1 > 10)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 10) && (tempInt1 < 10)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 11) && (tempInt1 < 32) && (tempInt1 > 27)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 11) && (tempInt1 < 27) && (tempInt1 > 11)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 11) && (tempInt1 < 11)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 12) && (tempInt1 < 33) && (tempInt1 > 27)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 12) && (tempInt1 < 27) && (tempInt1 > 12)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 12) && (tempInt1 < 12)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 13) && (tempInt1 < 34) && (tempInt1 > 27)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 13) && (tempInt1 < 27) && (tempInt1 > 13)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 13) && (tempInt1 < 13)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 14) && (tempInt1 < 35) && (tempInt1 > 27)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 14) && (tempInt1 < 27) && (tempInt1 > 14)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 14) && (tempInt1 < 14)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 15) && (tempInt1 < 36) && (tempInt1 > 27)) {
            op3.setVisibility(View.VISIBLE);
            op3.setBackgroundColor(Color.GREEN);
            subop3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 15) && (tempInt1 < 27) && (tempInt1 > 15)){
            subop3.setVisibility(View.VISIBLE);
            subop3.setBackgroundColor(Color.YELLOW);
            op3.setVisibility(View.INVISIBLE);
            crit3.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 15) && (tempInt1 < 15)){
            crit3.setVisibility(View.VISIBLE);
            crit3.setBackgroundColor(Color.RED);
            op3.setVisibility(View.INVISIBLE);
            subop3.setVisibility(View.INVISIBLE);
        }


        if((hardyInt4 == 1) && (tempInt1 < 32) && (tempInt1 > -20)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 1) && (tempInt1 < -20) && (tempInt1 > -25)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 1) && (tempInt1 < -25)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 2) && (tempInt1 < 32) && (tempInt1 > -15)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 2) && (tempInt1 < -15) && (tempInt1 > -20)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 2) && (tempInt1 < -20)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 3) && (tempInt1 < 32) && (tempInt1 > -5)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 3) && (tempInt1 < -5) && (tempInt1 > -10)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 3) && (tempInt1 < -10)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 4) && (tempInt1 < 32) && (tempInt1 > 0)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 4) && (tempInt1 < 0) && (tempInt1 > -5)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 4) && (tempInt1 < -5)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt3 == 5) && (tempInt1 < 32) && (tempInt1 > 10)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt3 == 5) && ((tempInt1 < 10) && (tempInt1 > 5))){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 5) && (tempInt1 < 5)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 6) && (tempInt1 < 32) && (tempInt1 > 12)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 6) && (tempInt1 < 12) && (tempInt1 > 6)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 6) && (tempInt1 < 6)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 7) && (tempInt1 < 32) && (tempInt1 > 15)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 7) && (tempInt1 < 15) && (tempInt1 > 7)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 7) && (tempInt1 < 7)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 8) && (tempInt1 < 32) && (tempInt1 > 17)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 8) && (tempInt1 < 17) && (tempInt1 > 8)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 8) && (tempInt1 < 8)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 9) && (tempInt1 < 32) && (tempInt1 > 20)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 9) && (tempInt1 < 20) && (tempInt1 > 9)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 9) && (tempInt1 < 9)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 10) && (tempInt1 < 32) && (tempInt1 > 25)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 10) && (tempInt1 < 25) && (tempInt1 > 10)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 10) && (tempInt1 < 10)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 11) && (tempInt1 < 32) && (tempInt1 > 27)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 11) && (tempInt1 < 27) && (tempInt1 > 11)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 11) && (tempInt1 < 11)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 12) && (tempInt1 < 33) && (tempInt1 > 27)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 12) && (tempInt1 < 27) && (tempInt1 > 12)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 12) && (tempInt1 < 12)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 13) && (tempInt1 < 34) && (tempInt1 > 27)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 13) && (tempInt1 < 27) && (tempInt1 > 13)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 13) && (tempInt1 < 13)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 14) && (tempInt1 < 35) && (tempInt1 > 27)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 14) && (tempInt1 < 27) && (tempInt1 > 14)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 14) && (tempInt1 < 14)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }

        if((hardyInt4 == 15) && (tempInt1 < 36) && (tempInt1 > 27)) {
            op4.setVisibility(View.VISIBLE);
            op4.setBackgroundColor(Color.GREEN);
            subop4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 15) && (tempInt1 < 27) && (tempInt1 > 15)){
            subop4.setVisibility(View.VISIBLE);
            subop4.setBackgroundColor(Color.YELLOW);
            op4.setVisibility(View.INVISIBLE);
            crit4.setVisibility(View.INVISIBLE);
        }
        if((hardyInt4 == 15) && (tempInt1 < 15)){
            crit4.setVisibility(View.VISIBLE);
            crit4.setBackgroundColor(Color.RED);
            op4.setVisibility(View.INVISIBLE);
            subop4.setVisibility(View.INVISIBLE);
        }


        if((hardyInt5 == 1) && (tempInt1 < 32) && (tempInt1 > -20)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 1) && (tempInt1 < -20) && (tempInt1 > -25)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 1) && (tempInt1 < -25)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 2) && (tempInt1 < 32) && (tempInt1 > -15)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 2) && (tempInt1 < -15) && (tempInt1 > -20)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 2) && (tempInt1 < -20)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 3) && (tempInt1 < 32) && (tempInt1 > -5)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 3) && (tempInt1 < -5) && (tempInt1 > -10)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 3) && (tempInt1 < -10)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 4) && (tempInt1 < 32) && (tempInt1 > 0)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 4) && (tempInt1 < 0) && (tempInt1 > -5)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 4) && (tempInt1 < -5)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 5) && (tempInt1 < 32) && (tempInt1 > 10)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 5) && (tempInt1 < 10) && (tempInt1 > 5)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 5) && (tempInt1 < 5)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 6) && (tempInt1 < 32) && (tempInt1 > 12)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 6) && (tempInt1 < 12) && (tempInt1 > 6)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 6) && (tempInt1 < 6)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 7) && (tempInt1 < 32) && (tempInt1 > 15)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 7) && (tempInt1 < 15) && (tempInt1 > 7)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 7) && (tempInt1 < 7)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 8) && (tempInt1 < 32) && (tempInt1 > 17)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 8) && (tempInt1 < 17) && (tempInt1 > 8)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 8) && (tempInt1 < 8)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 9) && (tempInt1 < 32) && (tempInt1 > 20)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 9) && (tempInt1 < 20) && (tempInt1 > 9)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 9) && (tempInt1 < 9)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 10) && (tempInt1 < 32) && (tempInt1 > 25)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 10) && (tempInt1 < 25) && (tempInt1 > 10)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 10) && (tempInt1 < 10)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 11) && (tempInt1 < 32) && (tempInt1 > 27)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 11) && (tempInt1 < 27) && (tempInt1 > 11)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 11) && (tempInt1 < 11)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 12) && (tempInt1 < 33) && (tempInt1 > 27)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 12) && (tempInt1 < 27) && (tempInt1 > 12)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 12) && (tempInt1 < 12)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 13) && (tempInt1 < 34) && (tempInt1 > 27)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 13) && (tempInt1 < 27) && (tempInt1 > 13)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 13) && (tempInt1 < 13)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 14) && (tempInt1 < 35) && (tempInt1 > 27)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 14) && (tempInt1 < 27) && (tempInt1 > 14)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 14) && (tempInt1 < 14)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        if((hardyInt5 == 15) && (tempInt1 < 36) && (tempInt1 > 27)) {
            op5.setVisibility(View.VISIBLE);
            op5.setBackgroundColor(Color.GREEN);
            subop5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 15) && (tempInt1 < 27) && (tempInt1 > 15)){
            subop5.setVisibility(View.VISIBLE);
            subop5.setBackgroundColor(Color.YELLOW);
            op5.setVisibility(View.INVISIBLE);
            crit5.setVisibility(View.INVISIBLE);
        }
        if((hardyInt5 == 15) && (tempInt1 < 15)){
            crit5.setVisibility(View.VISIBLE);
            crit5.setBackgroundColor(Color.RED);
            op5.setVisibility(View.INVISIBLE);
            subop5.setVisibility(View.INVISIBLE);
        }

        num1.setText(name1);
        num2.setText(name2);
        num3.setText(name3);
        num4.setText(name4);
        num5.setText(name5);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SixthFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
