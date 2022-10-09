package com.example.gardengang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//public class SharedViewModel extends ViewModel {
//    private final MutableLiveData<String> selected = new MutableLiveData<>();
//
//    public void select(String item) {
//        selected.setValue(item);
//    }
//
//    public LiveData<String> getSelected() {
//        return selected;
//    }
//}

public class SharedViewModel {
    private static String Hum = "None";
    private static String TempC1 = "None";
    private static String TempF1 = "None";
    private static String Moist1 = "None";
    private static String pH1 = "None";
    private static String Ex1 = "None";
    private static String TempC2 = "None";
    private static String TempF2 = "None";
    private static String Moist2 = "None";
    private static String pH2 = "None";
    private static String Ex2 = "None";
    private static String TempCavg = "None";
    private static String TempFavg = "None";
    private static String Mavg = "None";
    private static String Pavg = "None";
    private static String name1 = "Plant 1";
    private static String hardy1 = "";
    private static String shade1 = "";
    private static String moisture1 = "";
    private static String pHp1 = "";
    private static String name2 = "Plant 2";
    private static String hardy2 = "";
    private static String shade2 = "";
    private static String moisture2 = "";
    private static String pHp2 = "";
    private static String name3 = "Plant 3";
    private static String hardy3 = "";
    private static String shade3 = "";
    private static String moisture3 = "";
    private static String pHp3 = "";
    private static String name4 = "Plant 4";
    private static String hardy4 = "";
    private static String shade4 = "";
    private static String moisture4 = "";
    private static String pHp4 = "";
    private static String name5 = "Plant 5";
    private static String hardy5 = "";
    private static String shade5 = "";
    private static String moisture5 = "";
    private static String pHp5 = "";
    private static String username = "garden";
    private static String password = "gang";
    private static long[] graphTemp = new long[120];
    private static long[] graphpH = new long[120];
    private static long[] graphEx = new long[120];
    private static long[] graphMoist = new long[120];
    private static int Count = 0;
    private static int PlantCount = 0;

    public static void setTempC1(String tempc1){
        SharedViewModel.TempC1 = tempc1;
    }

    public static String getTempC1(){
        return SharedViewModel.TempC1;
    }

    public static void setTempF1(String tempf1){
        SharedViewModel.TempF1 = tempf1;
    }

    public static String getTempF1(){
        return SharedViewModel.TempF1;
    }

    public static void setMoist1(String moist1){
        SharedViewModel.Moist1 = moist1;
    }

    public static String getMoist1(){
        return SharedViewModel.Moist1;
    }

    public static void setpH1(String pH1){
        SharedViewModel.pH1 = pH1;
    }

    public static String getpH1(){
        return SharedViewModel.pH1;
    }

    public static void setEx1(String ex1){
        SharedViewModel.Ex1 = ex1;
    }

    public static String getEx1(){
        return SharedViewModel.Ex1;
    }

    public static void setTempC2(String tempc2){
        SharedViewModel.TempC2 = tempc2;
    }

    public static String getTempC2(){
        return SharedViewModel.TempC2;
    }

    public static void setTempF2(String tempf2){
        SharedViewModel.TempF2 = tempf2;
    }

    public static String getTempF2(){
        return SharedViewModel.TempF2;
    }

    public static void setMoist2(String moist2){
        SharedViewModel.Moist2 = moist2;
    }

    public static String getMoist2(){
        return SharedViewModel.Moist2;
    }

    public static void setpH2(String pH2){
        SharedViewModel.pH2 = pH2;
    }

    public static String getpH2(){
        return SharedViewModel.pH2;
    }

    public static void setEx2(String ex2){
        SharedViewModel.Ex2 = ex2;
    }

    public static String getEx2(){
        return SharedViewModel.Ex2;
    }

    public static void setTempCavg(String tempCavg){
        SharedViewModel.TempCavg = tempCavg;
    }

    public static String getTempCavg(){
        return SharedViewModel.TempCavg;
    }

    public static void setTempFavg(String tempFavg){
        SharedViewModel.TempFavg = tempFavg;
    }

    public static String getTempFavg(){
        return SharedViewModel.TempFavg;
    }

    public static void setMavg(String mavg){
        SharedViewModel.Mavg = mavg;
    }

    public static String getMavg(){
        return SharedViewModel.Mavg;
    }

    public static void setPavg(String pavg){
        SharedViewModel.Pavg = pavg;
    }

    public static String getPavg(){
        return SharedViewModel.Pavg;
    }

    public static void setHum(String hum){
        SharedViewModel.Hum = hum;
    }

    public static String getHum(){
        return SharedViewModel.Hum;
    }

    public static void setGraphTemp(long[] graphtemp){
        SharedViewModel.graphTemp = graphtemp;
    }

    public static long[] getGraphTemp(){
        return SharedViewModel.graphTemp;
    }

    public static void setGraphpH(long[] graphpH){
        SharedViewModel.graphpH = graphpH;
    }

    public static long[] getGraphpH(){
        return SharedViewModel.graphpH;
    }

    public static void setGraphMoist(long[] graphMoist){
        SharedViewModel.graphMoist = graphMoist;
    }

    public static long[] getGraphMoist(){
        return SharedViewModel.graphMoist;
    }

    public static void setGraphEx(long[] graphex){
        SharedViewModel.graphEx = graphex;
    }

    public static long[] getGraphEx(){
        return SharedViewModel.graphEx;
    }

    public static void setCount(int count){
        SharedViewModel.Count = count;
    }

    public static int getCount(){
        return SharedViewModel.Count;
    }

    public static void setPlantCount(int plantCount){
        SharedViewModel.PlantCount = plantCount;
    }

    public static int getPlantCount(){
        return SharedViewModel.PlantCount;
    }

    public static void setName1(String name1){
        SharedViewModel.name1 = name1;
    }

    public static String getName1(){
        return SharedViewModel.name1;
    }

    public static void setHardy1(String hardy1){
        SharedViewModel.hardy1 = hardy1;
    }

    public static String getHardy1(){
        return SharedViewModel.hardy1;
    }

    public static void setShade1(String shade1){
        SharedViewModel.shade1 = shade1;
    }

    public static String getShade1(){
        return SharedViewModel.shade1;
    }

    public static void setMoisture1(String moisture1){
        SharedViewModel.moisture1 = moisture1;
    }

    public static String getMoisture1(){
        return SharedViewModel.moisture1;
    }

    public static void setpHp1(String pHp1){
        SharedViewModel.pHp1 = pHp1;
    }

    public static String getpHp1(){
        return SharedViewModel.pHp1;
    }

    public static void setName2(String name2){
        SharedViewModel.name2 = name2;
    }

    public static String getName2(){
        return SharedViewModel.name2;
    }

    public static void setHardy2(String hardy2){
        SharedViewModel.hardy2 = hardy2;
    }

    public static String getHardy2(){
        return SharedViewModel.hardy2;
    }

    public static void setShade2(String shade2){
        SharedViewModel.shade2 = shade2;
    }

    public static String getShade2(){
        return SharedViewModel.shade2;
    }

    public static void setMoisture2(String moisture2){
        SharedViewModel.moisture2 = moisture2;
    }

    public static String getMoisture2(){
        return SharedViewModel.moisture2;
    }

    public static void setpHp2(String pHp2){
        SharedViewModel.pHp2 = pHp2;
    }

    public static String getpHp2(){
        return SharedViewModel.pHp2;
    }

    public static void setName3(String name3){
        SharedViewModel.name3 = name3;
    }

    public static String getName3(){
        return SharedViewModel.name3;
    }

    public static void setHardy3(String hardy3){
        SharedViewModel.hardy3 = hardy3;
    }

    public static String getHardy3(){
        return SharedViewModel.hardy3;
    }

    public static void setShade3(String shade3){
        SharedViewModel.shade3 = shade3;
    }

    public static String getShade3(){
        return SharedViewModel.shade3;
    }

    public static void setMoisture3(String moisture3){
        SharedViewModel.moisture3 = moisture3;
    }

    public static String getMoisture3(){
        return SharedViewModel.moisture3;
    }

    public static void setpHp3(String pHp3){
        SharedViewModel.pHp3 = pHp3;
    }

    public static String getpHp3(){
        return SharedViewModel.pHp3;
    }

    public static void setName4(String name4){
        SharedViewModel.name4 = name4;
    }

    public static String getName4(){
        return SharedViewModel.name4;
    }

    public static void setHardy4(String hardy4){
        SharedViewModel.hardy4 = hardy4;
    }

    public static String getHardy4(){
        return SharedViewModel.hardy4;
    }

    public static void setShade4(String shade4){
        SharedViewModel.shade4 = shade4;
    }

    public static String getShade4(){
        return SharedViewModel.shade4;
    }

    public static void setMoisture4(String moisture4){
        SharedViewModel.moisture4 = moisture4;
    }

    public static String getMoisture4(){
        return SharedViewModel.moisture4;
    }

    public static void setpHp4(String pHp4){
        SharedViewModel.pHp4 = pHp4;
    }

    public static String getpHp4(){
        return SharedViewModel.pHp4;
    }

    public static void setName5(String name5){
        SharedViewModel.name5 = name5;
    }

    public static String getName5(){
        return SharedViewModel.name5;
    }

    public static void setHardy5(String hardy5){
        SharedViewModel.hardy5 = hardy5;
    }

    public static String getHardy5(){
        return SharedViewModel.hardy5;
    }

    public static void setShade5(String shade5){
        SharedViewModel.shade5 = shade5;
    }

    public static String getShade5(){
        return SharedViewModel.shade5;
    }

    public static void setMoisture5(String moisture5){
        SharedViewModel.moisture5 = moisture5;
    }

    public static String getMoisture5(){
        return SharedViewModel.moisture5;
    }

    public static void setpHp5(String pHp5){
        SharedViewModel.pHp5 = pHp5;
    }

    public static String getpHp5(){
        return SharedViewModel.pHp5;
    }

    public static void setUsername(String username){
        SharedViewModel.username = username;
    }

    public static String getUsername(){
        return SharedViewModel.username;
    }

    public static void setPassword(String password){
        SharedViewModel.password = password;
    }

    public static String getPassword(){
        return SharedViewModel.password;
    }
}