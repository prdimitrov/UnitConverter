package com.example.unitconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            textView = findViewById(R.id.textView);
            editText = findViewById(R.id.editText);
            button = findViewById(R.id.button);

            button.setOnClickListener(v1 -> {
                try {
                    double input = Double.parseDouble(editText.getText().toString());
                    textView.setText(String.valueOf(convertToPounds(input)));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                }
            });
            return insets;
        });
    }
    private double convertToPounds(double kilograms) {
        // 1 kilogram = 2.20462262 pounds
        return kilograms * 2.20462262;
    }
}