package com.uni.fuel_calc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onButtonClick(View view){
        Log.i("btn test", "onButtonClick: ");

        EditText editTextMileage= (EditText)findViewById(R.id.editTextMileage);
        EditText editTextFuelConsumption= (EditText)findViewById(R.id.editTextFuelConsumption);

        Float milleage= Float.parseFloat(editTextMileage.getText().toString());
        Float fuelConsumption= Float.parseFloat(editTextFuelConsumption.getText().toString());

        TextView result = (TextView)findViewById(R.id.textViewResult);
        String fuelType = null;
        if (((RadioButton)findViewById(R.id.radioButtonDiesel)).isChecked()) fuelType="дизеля";
        if (((RadioButton)findViewById(R.id.radioButtonGas)).isChecked()) fuelType="бензина";
        if (fuelType == null) result.setText("Не выбран тип топлива") ;
        else result.setText("Расход "+fuelType+" составил "+ String.format("%.2f", milleage/100*fuelConsumption) );

    }
}