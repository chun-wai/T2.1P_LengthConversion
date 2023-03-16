package com.example.lengthconversion;

// First of all, to import the classes that we need to use
// i.e. EditText for input of number
// i.e. TextView for showing text but user cannot edit it
// i.e. Button for user to click and execute the conversion with the conversion logic
// i.e. Toast to create pop up window to remind user about the input
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

// Second of all, to create variables according to the User Interface i.e. EditText, TextView, Button, Spinner
public class MainActivity extends AppCompatActivity {

    // To create a TextView to guide the user to input a number of length in inch
    TextView instruction;

    // To create a EditText variable namely inputEditText
    EditText inputEditText;

    // To create a TextView variable namely resultTextView
    TextView resultTextView;

    // To create a button variable namely convertButton
    Button convertButton;

    // To implement the conversion logic
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextview);
        inputEditText = findViewById(R.id.inputEditText);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = inputEditText.getText().toString();
                int inch = Integer.parseInt(string);
                double cm = inch * 2.54;
                resultTextView.setText("Result is: " + cm + " cm");
                Toast.makeText(MainActivity.this, "Result is: " + cm + " cm", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // To write the logic of input validation for number input only
    public void validateInput(View view) {
        String input = inputEditText.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        // input validation
        try {
            double inputNumber = Double.parseDouble(input);
            Toast.makeText(this, "Input is valid:" + inputNumber, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Input is not a number", Toast.LENGTH_SHORT).show();
        }
    }
}