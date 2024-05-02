package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText name, email, username, password, confirm;
    Button clear,create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);

        clear = findViewById(R.id.clear_button);
        create = findViewById(R.id.create_button);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateFields()) {
                    Toast.makeText(MainActivity.this, "Fill the required fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearForm() {
        name.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        confirm.setText("");
    }

    private boolean validateFields() {
        boolean isValid = true;

        if (name.getText().toString().isEmpty()) {
            name.setError("Name cannot be empty");
            isValid = false;
        }

        if (email.getText().toString().isEmpty() || !isValidEmail(email.getText().toString())) {
            email.setError("Invalid email address");
            isValid = false;
        }

        if (password.getText().toString().length()<6) {
            password.setError("passwrod length should be atleast 6");
            isValid = false;
        }
        return isValid;
    }

    // Method to validate email format
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return Pattern.matches(emailPattern, email);
    }
}
