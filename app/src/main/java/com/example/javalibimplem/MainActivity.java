package com.example.javalibimplem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText phoneNumber, emailAddress, amount;
    private Button checkoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phone_number);
        emailAddress = findViewById(R.id.email_address);
        amount = findViewById(R.id.amount);
        checkoutBtn = findViewById(R.id.checkout_btn);

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneNumber.getText().toString();
                String email = emailAddress.getText().toString();
                String price = amount.getText().toString();

                Intent intent = new Intent(MainActivity.this, CheckoutActivity.class);
                intent.putExtra("PHONE_NUMBER", phone);
                intent.putExtra("EMAIL_ADDRESS", email);
                intent.putExtra("PRICE_AMOUNT", price);

                startActivity(intent);

            }
        });
    }


}