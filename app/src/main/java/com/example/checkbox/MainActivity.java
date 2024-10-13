package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
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
    TimePicker timePicker;
    DatePicker datePicker;
    Button datePickerBtn,progressBarBtn;
    ProgressBar progressBar;
    int progress = 0;
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


        timePicker = findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // Handle Time Change
                Toast.makeText(
                        MainActivity.this,
                        "Hour: "+ hourOfDay +" minute: "+minute,
                        Toast.LENGTH_SHORT).show();
            }
        });

        datePicker = findViewById(R.id.datePicker);
        datePickerBtn = findViewById(R.id.date_picker_btn);

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day "+ datePicker.getDayOfMonth();
                String month = "Month" + (datePicker.getMonth() +1);
                String year = "Year "+ datePicker.getYear();
                Toast.makeText(
                        MainActivity.this,
                        day + " " + month + " "+ year,
                        Toast.LENGTH_SHORT).show();
            }
        });

        progressBar = findViewById(R.id.progress_circular);
        progressBarBtn = findViewById(R.id.progress_circular_btn);

        progressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = progress +10;
                progressBar.setProgress(progress);
                Toast.makeText(
                        MainActivity.this,
                        "The Progress "+ progress,
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}