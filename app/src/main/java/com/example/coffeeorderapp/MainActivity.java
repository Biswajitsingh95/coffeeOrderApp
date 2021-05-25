package com.example.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.orderBtn);
//        TextView numOfCoffee = findViewById(R.id.coffeeNum);
//        TextView moneyView = findViewById(R.id.moneyView);
        Button incCoffee = findViewById(R.id.increase);
        Button decCoffee = findViewById(R.id.decrease);

        btn.setOnClickListener(v -> {

            EditText text = findViewById(R.id.nameText);
            String name = text.getText().toString();

            CheckBox whippedCreamCheck = findViewById(R.id.whippedCreamBox);
            Boolean isWhippedCreamChecked = whippedCreamCheck.isChecked();

            CheckBox chocolateCheck = findViewById(R.id.chocolateBox);
            Boolean hasChocolateChecked = chocolateCheck.isChecked();
                int price = calculatePrice(isWhippedCreamChecked,hasChocolateChecked);
                String priceMessage = createOrderSummary(name,price,isWhippedCreamChecked,hasChocolateChecked);
                moneyViewMessage(priceMessage);
        });

        incCoffee.setOnClickListener(v -> {
            if(numberOfCoffee<100){
                numberOfCoffee = numberOfCoffee+1;
                display(numberOfCoffee);
            }
            else
                return;

        });

        decCoffee.setOnClickListener(v -> {
            if(numberOfCoffee==1){
                return;
            }
            else{
                numberOfCoffee = numberOfCoffee-1;
                display(numberOfCoffee);
            }

        });

    }
    public void display(int number){
        TextView numberOfCoffee = findViewById(R.id.coffeeNum);
        numberOfCoffee.setText(" "+number);
    }

//    public void totalMoneyView(int number){
//        TextView moneyView = findViewById(R.id.moneyView);
//        moneyView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    public void moneyViewMessage(String message){
        TextView moneyView = findViewById(R.id.moneyView);
        moneyView.setText(message);
    }

    private int calculatePrice(Boolean addWhippedCream, Boolean addChocolate)
    {
        int basePrice = 5;
        if(addWhippedCream){
            basePrice = basePrice+1;
        }
        if(addChocolate){
            basePrice = basePrice+2;
        }
        return numberOfCoffee*basePrice;
    }

    public String createOrderSummary(String name, int price, Boolean hasWhippedCream, Boolean hasChocolate){
        String summary;
        summary = "Name : " + name + "\nAdded whipped Cream ? " + hasWhippedCream;
        summary = summary + "\nAdded chocolate ? " + hasChocolate + "\nTotal cost = " + price;
        summary = summary + "\n\t\n Thank you :)";
        return summary;
    }
}



