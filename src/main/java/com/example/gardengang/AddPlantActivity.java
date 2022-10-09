package com.example.gardengang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddPlantActivity extends AppCompatActivity {

    TextView tvName;
    TextView latinName;
    TextView familyV;
    TextView habitatV;
    TextView habitV;
    TextView hardinessV;
    TextView soilV;
    TextView shadeV;
    TextView moistureV;
    TextView pHV;
    TextView medV;
    long id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);
        ((AddPlantActivity)this).getSupportActionBar().setTitle("Plant Information");
        id = getIntent().getExtras().getLong("ID");
        String common_name = getIntent().getExtras().getString("Common_name");
        String latin_name = getIntent().getExtras().getString("Latin_name");
        String family = getIntent().getExtras().getString("Family");
        String habitat = getIntent().getExtras().getString("Habitat");
        String habit = getIntent().getExtras().getString("Habit");
        String hardiness = getIntent().getExtras().getString("Hardiness");
        String soil = getIntent().getExtras().getString("Soil");
        String shade = getIntent().getExtras().getString("Shade");
        String moisture = getIntent().getExtras().getString("Moisture");
        String pH = getIntent().getExtras().getString("pH");
        String medicinal = getIntent().getExtras().getString("Medicinal");

        tvName = findViewById(R.id.tvName);
        latinName = findViewById(R.id.latinName);
        familyV = findViewById(R.id.family);
        habitatV = findViewById(R.id.habitat);
        habitV = findViewById(R.id.habit);
        hardinessV = findViewById(R.id.hardyharhar);
        soilV = findViewById(R.id.soil);
        shadeV = findViewById(R.id.shade);
        moistureV = findViewById(R.id.moisture);
        pHV = findViewById(R.id.pH);
        medV = findViewById(R.id.medicinal);

        tvName.setText("Common Name: " + common_name);
        latinName.setText("Latin Name: " + latin_name);
        familyV.setText("Family: " + family);
        habitatV.setText("Habitat: " + habitat);
        habitV.setText("Habit: " + habit);
        //"\n(Generally, a lower hardiness number indicates an ability to withstand colder climates. a higher hardiness number indicates an ability to withstand warmer climates. )"
        hardinessV.setText("Hardiness: " + hardiness);
        soilV.setText("Soil: " + soil + "\n(L = Light/Sandy, M = Medium/Loam, H = Heavy)");
        shadeV.setText("Shade: " + shade + "\n(F = Full, S = Semi, N = None)");
        moistureV.setText("Moisture: " + moisture + "\n(D = Dry, M = Moist, W = Wet/Boggy)");
        pHV.setText("pH: " + pH + "\n(A = Acid, N = Neutral, B = Base)");
        medV.setText("Medicinal: " + medicinal);
    }

    public void populate(View view){
        String common_name = getIntent().getExtras().getString("Common_name");
        String latin_name = getIntent().getExtras().getString("Latin_name");
        String hardiness = getIntent().getExtras().getString("Hardiness");
        String shade = getIntent().getExtras().getString("Shade");
        String moisture = getIntent().getExtras().getString("Moisture");
        String pH = getIntent().getExtras().getString("pH");
        DatabaseActivity.databaseAdapter.populateGarden(id, common_name, latin_name);
        int count = SharedViewModel.getPlantCount();

        if(count == 0){
            SharedViewModel.setName1(common_name);
            SharedViewModel.setHardy1(hardiness);
            SharedViewModel.setShade1(shade);
            SharedViewModel.setMoisture1(moisture);
            SharedViewModel.setpHp1(pH);
            SharedViewModel.setPlantCount(1);
        }

        if(count == 1){
            SharedViewModel.setName2(common_name);
            SharedViewModel.setHardy2(hardiness);
            SharedViewModel.setShade2(shade);
            SharedViewModel.setMoisture2(moisture);
            SharedViewModel.setpHp2(pH);
            SharedViewModel.setPlantCount(2);
        }

        if(count == 2){
            SharedViewModel.setName3(common_name);
            SharedViewModel.setHardy3(hardiness);
            SharedViewModel.setShade3(shade);
            SharedViewModel.setMoisture3(moisture);
            SharedViewModel.setpHp3(pH);
            SharedViewModel.setPlantCount(3);
        }

        if(count == 3){
            SharedViewModel.setName4(common_name);
            SharedViewModel.setHardy4(hardiness);
            SharedViewModel.setShade4(shade);
            SharedViewModel.setMoisture4(moisture);
            SharedViewModel.setpHp4(pH);
            SharedViewModel.setPlantCount(4);
        }

        if(count == 4){
            SharedViewModel.setName5(common_name);
            SharedViewModel.setHardy5(hardiness);
            SharedViewModel.setShade5(shade);
            SharedViewModel.setMoisture5(moisture);
            SharedViewModel.setpHp5(pH);
            SharedViewModel.setPlantCount(0);
        }

        startActivity(new Intent(AddPlantActivity.this, DatabaseActivity.class));
        finish();
    }
}
