package com.example.checkbox;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;

    RadioGroup radioGroup;
    Spinner spinner;

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

        checkBox = findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // Code to execute when checkbox id checked
                    Toast.makeText(MainActivity.this,
                            "The Checkbox is checked",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,
                            "The Check is not checked",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this,
                        "You selected: " +radioButton.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        spinner = findViewById(R.id.spinner);

        // Data Source:
        String[] courses = {"C/C++", "Java", "Kotlin","Python"};

        // Array Adapter : used to populate the  'Spinner' with
        //                 items from a string array resource
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this,
                android.R.layout.simple_spinner_item,
                courses
                );
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);





    }
}