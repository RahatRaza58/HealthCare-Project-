package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm, edPhone;
    Button btn;
    TextView tv;
    String verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        edPhone = findViewById(R.id.editTextRegPhone);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                String phone = edPhone.getText().toString();
                Database db = new Database(getApplicationContext(), "HealthCare", null, 1);

                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0 || phone.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Fill Up All Data", Toast.LENGTH_SHORT).show();
                } else {
                    if (!isValidUsername(username)) {
                        Toast.makeText(getApplicationContext(), "Invalid Username! Username must be at least 3 characters long and should not contain numeric values.", Toast.LENGTH_SHORT).show();
                    } else if (!isValidEmail(email)) {
                        Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                    } else if (!isValidMobileNumber(phone)) {
                        Toast.makeText(getApplicationContext(), "Invalid Mobile Number! Mobile number should be at least 11 digits long.", Toast.LENGTH_SHORT).show();
                    } else if (!isValidPassword(password)) {
                        Toast.makeText(getApplicationContext(), "Invalid Password! Password must contain at least 8 characters and should include a letter, a digit, and a special character.", Toast.LENGTH_SHORT).show();
                    } else if (!password.equals(confirm)) {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    } else {
                        // Generate verification code
                        verificationCode = generateVerificationCode();

                        // Send email with the verification code
                        sendVerificationEmail(email, verificationCode);

                        // Save user registration info in the database
                        db.register(username, email, password, phone);

                        Toast.makeText(getApplicationContext(), "Registration Successful! Please check your email for the verification code.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                }
            }
        });
    }

    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z]{3,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(username).matches();
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        String regex = "^[0-9]{1,11}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(mobileNumber).matches();
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    private String generateVerificationCode() {
        // Generate a random 6-digit verification code
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }

    private void sendVerificationEmail(String email, String code) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email Verification Code");
        intent.putExtra(Intent.EXTRA_TEXT, "Your verification code is: " + code);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No email client found.", Toast.LENGTH_SHORT).show();
        }
    }
}