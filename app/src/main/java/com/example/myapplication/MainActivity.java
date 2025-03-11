package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private EditText first, second;
    private TextView result;

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
        first = findViewById(R.id.inputFirstNumber);
        second = findViewById(R.id.inputSecondNumber);
        result = findViewById(R.id.textResult);
    }

    public void onPlusButtonClick(View view) {
        print('+');
    }
    public void onMinusButtonClick(View view) {
        print('-');
    }
    public void onDivideButtonClick(View view) {
        print('/');
    }
    public void onMultiplyButtonClick(View view) {

        print('*');
    }

    private void print(char operation){
       try {
           BigDecimal num1 = new BigDecimal(Double.parseDouble(first.getText().toString()));
           BigDecimal num2 = new BigDecimal(Double.parseDouble(second.getText().toString()));
           switch (operation){
               case '+':
                   result.setText((String.valueOf(num1.add(num2))));
                   break;
               case '-':
                   result.setText((String.valueOf(num1.subtract(num2))));
                   break;
               case  '*':
                   result.setText((String.valueOf(num1.multiply(num2))));
                   break;
               case '/':
                   result.setText((String.valueOf(num1.divide(num2))));
                   break;
           }
       }
       catch (Exception e){
           result.setText("Try again please");
       }
    }

}